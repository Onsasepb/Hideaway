package com.example.hideaway.ui.theme.screens.patients

import android.content.Context
import android.net.Uri
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.hideaway.R
import com.example.hideaway.data.PatientViewModel
import com.example.hideaway.navigation.ADD_PATIENTS_URL
import com.example.hideaway.navigation.VIEW_PATIENTS_URL
import com.example.hideaway.ui.theme.HideawayTheme
import com.example.hideaway.ui.theme.Purple40

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddPatientsScreen(navController:NavHostController){
                Column(
                    modifier = Modifier.fillMaxSize()
                        .paint(
                            painterResource(id = R.drawable.project1),
                            contentScale = ContentScale.FillBounds
                        )
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally

                ) {
                    Text(
                        text = "Add Patient",
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Cursive,
                        color = Purple40
                    )

                    var patientName by remember { mutableStateOf("") }
                    var patientAge by remember { mutableStateOf("") }
                    var patientProgres by remember { mutableStateOf("") }
                    val context = LocalContext.current

                    Spacer(modifier = Modifier.height(30.dp))

                    OutlinedTextField(
                        value = patientName,
                        onValueChange = { patientName = it },
                        label = { Text(text = "Name *") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    OutlinedTextField(
                        value = patientAge,
                        onValueChange = { patientAge = it },
                        label = { Text(text = "Age *") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    OutlinedTextField(
                        value = patientProgres,
                        onValueChange = { patientProgres = it },
                        label = { Text(text = "Activities and/or Sessions Done *") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                    )

                    Spacer(modifier = Modifier.height(20.dp))




                    //---------------------IMAGE PICKER START-----------------------------------//

                    var modifier = Modifier
                    ImagePicker(modifier,context, navController, patientName, patientAge, patientProgres)

                    //---------------------IMAGE PICKER END-----------------------------------//



                }
            }

    @Composable
    fun ImagePicker(modifier: Modifier = Modifier, context: Context,navController: NavHostController, name:String, age:String, progress:String) {
        var hasImage by remember { mutableStateOf(false) }
        var imageUri by remember { mutableStateOf<Uri?>(null) }

        val imagePicker = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.GetContent(),
            onResult = { uri ->
                hasImage = uri != null
                imageUri = uri
            }
        )

        Column(modifier = modifier,) {
            if (hasImage && imageUri != null) {
                val bitmap = MediaStore.Images.Media.
                getBitmap(context.contentResolver,imageUri)
                Image(bitmap = bitmap.asImageBitmap(), contentDescription = "Selected image")
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 32.dp), horizontalAlignment = Alignment.CenterHorizontally,) {
                Button(
                    onClick = {
                        imagePicker.launch("image/*")
                    },
                    colors = ButtonDefaults.buttonColors(Purple40)
                ) {
                    Text(
                        text = "Select Profile Image"
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Button(onClick = {
                    //-----------WRITE THE UPLOAD LOGIC HERE---------------//
                    var patientRepository = PatientViewModel(navController,context)
                    patientRepository.uploadPatient(name, age, progress, imageUri!!)


                },
                    colors = ButtonDefaults.buttonColors(Purple40)
                ) {
                    Text(text = "Upload")
                }
            }
        }
        OutlinedButton(onClick = {
            navController.navigate(VIEW_PATIENTS_URL)
        },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp, top = 20.dp)
                .width(190.dp)) {
            Text(text = "VIEW",
                color = Purple40,
                fontWeight = FontWeight.Bold)
        }
    }


@Composable
@Preview(showBackground = true)
fun AddPatientsScreenPreview(){
    HideawayTheme {
        AddPatientsScreen(navController = rememberNavController())
    }
}