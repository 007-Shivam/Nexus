package com.shivam.nexus.activities.log_in

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shivam.nexus.R

@Composable
fun LogInScreen(
    state: SignInState,
    onSignInClick: () -> Unit
){

    val context = LocalContext.current
    LaunchedEffect(key1 = state.signInError) {
        state.signInError?.let { error ->
            Toast.makeText(
                context,
                error,
                Toast.LENGTH_LONG
            ).show()
        }
    }

    Box (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(
                color = Color(254, 253, 251,),
                shape = RoundedCornerShape(50.dp)
            )
            .border(
                BorderStroke(width = 1.dp, color = Color.Black),
                shape = RoundedCornerShape(50.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Column (
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(align = Alignment.Start)
                    .border(
                        BorderStroke(width = 3.dp, color = Color.Black),
                        shape = RoundedCornerShape(50.dp)
                    )
                    .padding(start = 20.dp)
                ,
                text = stringResource(id = R.string.login_screen),
                style = TextStyle(
                    fontSize = 55.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(94, 48, 35),
                )
            )

            Spacer(modifier = Modifier.height(10.dp))

            Image(
                painter = painterResource(id = R.drawable.login),
                contentDescription = "login_image",
                modifier = Modifier
                    .size(500.dp, 300.dp)
                    .border(
                        BorderStroke(width = 3.dp, color = Color.Black),
                        shape = RoundedCornerShape(50.dp)
                    )
            )

            Spacer(modifier = Modifier.height(10.dp))

            Button(
                onClick = onSignInClick,
                modifier = Modifier
                    .wrapContentWidth(align = Alignment.CenterHorizontally)
                    .border(
                        BorderStroke(width = 1.dp, color = Color.Black),
                        shape = RoundedCornerShape(50.dp)
                    )
                    .width(250.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(95, 149, 243)),
                content = {
                    Image(
                        painter = painterResource(id = R.drawable.google),
                        contentDescription = "login_btn",
                        modifier = Modifier
                            .size(50.dp)
                    )
                    Spacer(modifier = Modifier.width(15.dp))
                    Text(
                        text = stringResource(id = R.string.login_btn),
                        style = TextStyle(
                            fontSize = 15.sp,
                            fontFamily = FontFamily.Serif,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                        )
                    )
                }
            )
        }
    }
}