package com.example.hideaway.ui.theme.screens.safety

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hideaway.navigation.HOME_URL
import com.example.hideaway.navigation.MOOD_URL
import com.example.wazitoecommerce.ui.theme.Purple40

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Safety(navController: NavController) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())

    ) {
        val mContext = LocalContext.current

        TopAppBar(title = { Text(text = "Safety Plan",
            color = Purple40,
            fontFamily = FontFamily.Cursive,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(start =50.dp))
        },

//Background color for a top app Bar
            colors = TopAppBarDefaults.mediumTopAppBarColors(Color.White),
//end
//icon
            //Icons before
            navigationIcon = {
                IconButton(onClick = { navController.navigate(HOME_URL) }) {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "menu",
                        //Color for Icon
                        tint = Purple40
                    )
                }
            }
             )
        Spacer(modifier = Modifier.height(10.dp))
        //code for card colors (colors = CardDefaults.cardColors(containerColor = Color.Gray))

                Row(modifier = Modifier
                    .height(120.dp)
                    .fillMaxSize()
                    .padding(all = 15.dp)
                )
                {
                    Icon(
                        imageVector = Icons.Default.Warning,
                        contentDescription = "warning",
                        tint = Purple40,
                        modifier = Modifier
                            .size(60.dp)
                            .clickable { navController.navigate(MOOD_URL) }
                    )
                    Spacer(modifier = Modifier.width(25.dp))
                    Column {
                        Text(
                            text = "Warning Signs",
                            fontSize = 30.sp,
                            modifier = Modifier.padding(
                               start = 15.dp,
                                end = 15.dp,
                                top = 10.dp,
                                bottom = 10.dp
                            )
                        )
                        Text(text = "Add Warning signs that a crisis may occur"
                            , fontSize = 15.sp)
                        }
            }
        Spacer(modifier = Modifier.height(10.dp))

        HorizontalDivider(color = Color.Black,
            modifier = Modifier.padding(start = 15.dp, end = 15.dp))
        //end of section
        Spacer(modifier = Modifier.height(10.dp))

        Row(modifier = Modifier
            .height(120.dp)
            .fillMaxSize()
            .padding(all = 15.dp)
        )
        {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "Strategies",
                tint = Purple40,
                modifier = Modifier
                    .size(60.dp)
                    .clickable { navController.navigate(MOOD_URL) }
            )
            Spacer(modifier = Modifier.width(25.dp))
            Column {
                Text(
                    text = "Strategies",
                    fontSize = 30.sp,
                    modifier = Modifier.padding(
                        start = 15.dp,
                        top = 10.dp,
                        end = 15.dp,
                        bottom = 10.dp
                    )
                )
                Text(text = "Add Coping Strategies in case of a crisis "
                    , fontSize = 15.sp)
                }
        }
        Spacer(modifier = Modifier.height(10.dp))

        HorizontalDivider(color = Color.Black,
            modifier = Modifier.padding(start = 15.dp, end = 15.dp))
        //end of section
        Spacer(modifier = Modifier.height(10.dp))
        Row(modifier = Modifier
            .height(120.dp)
            .fillMaxSize()
            .padding(all = 15.dp)
        )
        {
            Icon(
                imageVector = Icons.Default.Call,
                contentDescription = "contact",
                tint = Purple40,
                modifier = Modifier
                    .size(60.dp)
                    .clickable { navController.navigate(MOOD_URL) }
            )
            Spacer(modifier = Modifier.width(25.dp))
            Column {
                Text(
                    text = "Contacts",
                    fontSize = 30.sp,
                    modifier = Modifier.padding(
                        start = 15.dp,
                        end = 15.dp,
                        top = 10.dp,
                        bottom = 10.dp
                    )
                )
                Text(text = "Add people you can contact if a crisis may occur "
                    , fontSize = 15.sp)
                 }
        }
        Spacer(modifier = Modifier.height(10.dp))

        HorizontalDivider(color = Color.Black,
            modifier = Modifier.padding(start = 15.dp, end = 15.dp))
        //end of section
        Spacer(modifier = Modifier.height(10.dp))
        Row(modifier = Modifier
            .height(120.dp)
            .fillMaxSize()
            .padding(all = 15.dp)
        )
        {
            Icon(
                imageVector = Icons.Default.Create,
                contentDescription = "other",
                tint = Purple40,
                modifier = Modifier
                    .size(60.dp)
                    .clickable { navController.navigate(MOOD_URL) }
            )
            Spacer(modifier = Modifier.width(25.dp))
            Column {
                Text(
                    text = "Other",
                    fontSize = 30.sp,
                    modifier = Modifier.padding(
                        start = 15.dp,
                        end = 15.dp,
                        top = 10.dp,
                        bottom = 10.dp
                    )
                )
                Text(text = "Add any additional notes that could be helpful"
                    , fontSize = 15.sp)
                    }
        }
        Spacer(modifier = Modifier.height(10.dp))

        HorizontalDivider(color = Color.Black,
            modifier = Modifier.padding(start = 15.dp, end = 15.dp))
        //end of section
        Spacer(modifier = Modifier.height(10.dp))









    }
}