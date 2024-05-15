package com.example.hideaway.ui.theme.screens.contact

import android.content.Intent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.hideaway.R
import com.example.hideaway.navigation.HOME_URL
import com.example.hideaway.navigation.MENU_URL
import com.example.hideaway.ui.theme.Purple40


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Contact(navController: NavHostController){
    Column (
        modifier = Modifier
            .paint(
                painterResource(id = R.drawable.safef),
                contentScale = ContentScale.FillBounds
            )
            .fillMaxSize())
    {
        TopAppBar(title = { Text(text = "CONTACT US",
            color = Purple40,
            fontFamily  = FontFamily.Cursive,
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
                IconButton(onClick = { navController.navigate(MENU_URL) }) {
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


        val mContext = LocalContext.current

        //Beginning of  outline button
        Spacer(modifier = Modifier.height(30.dp))


        //Beginning of  outline button
        Spacer(modifier = Modifier.height(30.dp))
        //Email
        OutlinedButton(onClick = {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("cliffeabudo@gmail.com"))
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "HIDEAWAY ")
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hello,I need to know more about")
            mContext.startActivity(shareIntent)
        },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp)
                .height(70.dp),
            shape = RoundedCornerShape(15.dp),
            border = BorderStroke(2.dp, color = Purple40 )

        )
        {
            androidx.compose.material3.Text(text = "EMAIL",
                color = Purple40,
                fontWeight = FontWeight.ExtraBold,
                fontFamily = FontFamily.Cursive,
                fontSize = 50.sp)

        }
        //End of outline button

        //Beginning of  outline button
        Spacer(modifier = Modifier.height(30.dp))
        //SMS
        OutlinedButton(onClick = {
            val smsIntent=Intent(Intent.ACTION_SENDTO)
            smsIntent.data="smsto:0112390902".toUri()
            smsIntent.putExtra("sms_body","Hello,I need to know more about")
            mContext.startActivity(smsIntent)
        },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp),
            shape = RoundedCornerShape(15.dp),
            border = BorderStroke(2.dp, color = Purple40 )

        )
        {
            androidx.compose.material3.Text(text = "SMS",
                color = Purple40,
                fontWeight = FontWeight.ExtraBold,
                fontFamily = FontFamily.Cursive,
                fontSize = 50.sp)

        }
        //End of outline button

        //Beginning of  outline button
        Spacer(modifier = Modifier.height(30.dp))
        //Call
        OutlinedButton(onClick = {
            val callIntent=Intent(Intent.ACTION_DIAL)
            callIntent.data="tel:0112390902".toUri()
            mContext.startActivity(callIntent)
        },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp),
            shape = RoundedCornerShape(15.dp),
            border = BorderStroke(2.dp, color = Purple40 )

        )
        {
            androidx.compose.material3.Text(text = "CALL",
                color = Purple40,
                fontWeight = FontWeight.ExtraBold,
                fontFamily = FontFamily.Cursive,
                fontSize = 50.sp)

        }
        //End of outline button

        //Beginning of  outline button

        OutlinedButton(onClick = {
            navController.navigate(HOME_URL)
        },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp, top = 600.dp)
        ) {
            Text(text = "HOME",
                color = Purple40,
                fontWeight = FontWeight.Bold)
        }



                //.clickable {  mContext.startActivity(Intent(mContext,FormActivity::class.java)) }
    }


}



@Preview(showBackground = true)
@Composable
fun ContactPreview(){
    Contact(navController = rememberNavController())
}