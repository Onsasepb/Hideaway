package com.example.hideaway.ui.theme.screens.strategies


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hideaway.R
import com.example.hideaway.navigation.HOME_URL
import com.example.hideaway.ui.theme.HideawayTheme
import com.example.hideaway.ui.theme.Purple40

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Strategies(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color.White)

    ) {
        val mContext = LocalContext.current
        TopAppBar(title = { Text(
            text = "Strategies",
            fontFamily = FontFamily.Cursive,
            color = Purple40,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(start = 50.dp)
        )
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

            Card {
                Image(painter = painterResource(id = R.drawable.pb),
                    contentDescription ="")
            }
            Spacer(modifier = Modifier.height(10.dp))
            Card {
                Image(painter = painterResource(id = R.drawable.pf),
                    contentDescription ="")
            }


        Spacer(modifier = Modifier.height(10.dp))

            Card {
                Image(painter = painterResource(id = R.drawable.ge),
                    contentDescription ="")
            }
            Spacer(modifier = Modifier.height(10.dp))
            Card {
                Image(painter = painterResource(id = R.drawable.pc),
                    contentDescription ="")
            }

        }






    }


@Composable
@Preview(showBackground = true)
fun StrategiesScreenPreview() {
    HideawayTheme {
        Strategies(navController = rememberNavController())


    }
}
