package com.example.hideaway.ui.theme.screens.patients

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
//import coil.compose.rememberAsyncImagePainter
import com.example.hideaway.data.PatientViewModel
import com.example.hideaway.models.Patient
import com.example.hideaway.ui.theme.HideawayTheme


@Composable
fun ViewPatientsScreen(navController:NavHostController) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        var context = LocalContext.current
        var patientRepository = PatientViewModel(navController, context)


        val emptyPatientState = remember { mutableStateOf(Patient("","","","","")) }
        var emptyPatientsListState = remember { mutableStateListOf<Patient>() }

        var patients = patientRepository.allPatients(emptyPatientState, emptyPatientsListState)


        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "All patients",
                fontSize = 30.sp,
                fontFamily = FontFamily.Cursive,
                color = Color.Red)

            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn(){
                items(patients){
                    PatientItem(
                        name = it.name,
                        age = it.age,
                        progres = it.progres,
                        id = it.id,
                        navController = navController,
                        patientRepository = patientRepository,
                        patientImage = it.imageUrl
                    )
                }
            }
        }
    }
}


@Composable
fun PatientItem(name:String, age:String, progres:String, id:String,
                navController:NavHostController,
                patientRepository: PatientViewModel, patientImage:String) {

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = name)
        Text(text = age)
        Text(text = progres)
        /*Image(
            painter = rememberAsyncImagePainter(patientImage),
            contentDescription = null,
            modifier = Modifier.size(250.dp)
        )*/
        Button(onClick = {
            patientRepository.deletePatient(id)
        }) {
            Text(text = "Delete")
        }
        Button(onClick = {
            //navController.navigate(ROUTE_UPDATE_PRODUCTS+"/$id")
        }) {
            Text(text = "Update")
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ViewPatientsScreenPreview(){
    HideawayTheme {
        ViewPatientsScreen(navController = rememberNavController())
    }
}