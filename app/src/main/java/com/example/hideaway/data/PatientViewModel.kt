package com.example.hideaway.data

import android.app.ProgressDialog
import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavHostController
import com.example.hideaway.models.Patient
import com.example.hideaway.navigation.LOGIN_URL
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage

class PatientViewModel(var navController:NavHostController, var context: Context) {
    var authViewModel: AuthViewModel
    var progress:ProgressDialog
    init {
        authViewModel = AuthViewModel(navController, context)
        if (!authViewModel.isLoggedIn()){
            navController.navigate(LOGIN_URL)
        }
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")
    }

    fun uploadPatient(name:String, age:String, progres:String, filePath:Uri){
        val patientId = System.currentTimeMillis().toString()
        val storageRef = FirebaseStorage.getInstance().getReference()
            .child("Patients/$patientId")
        progress.show()
        storageRef.putFile(filePath).addOnCompleteListener{
            progress.dismiss()
            if (it.isSuccessful){
                // Save data to db
                storageRef.downloadUrl.addOnSuccessListener {
                    var imageUrl = it.toString()
                    var patient = Patient(name,age,progres,imageUrl,patientId)
                    var databaseRef = FirebaseDatabase.getInstance().getReference()
                        .child("Patients/$patientId")
                    databaseRef.setValue(patient).addOnCompleteListener {
                        if (it.isSuccessful){
                            Toast.makeText(this.context, "Success", Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(this.context, "Error", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }else{
                Toast.makeText(this.context, "Upload error", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun allPatients(
        patient:MutableState<Patient>,
        patients:SnapshotStateList<Patient>):SnapshotStateList<Patient>{
        progress.show()
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Patients")
        ref.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                patients.clear()
                for (snap in snapshot.children){
                    var retrievedPatient = snap.getValue(Patient::class.java)
                    patient.value = retrievedPatient!!
                    patients.add(retrievedPatient)
                }
                progress.dismiss()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "DB locked", Toast.LENGTH_SHORT).show()
            }
        })
        return patients
    }

    fun deletePatient(patientId:String){
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Patients/$patientId")
        ref.removeValue()
        Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
    }
}