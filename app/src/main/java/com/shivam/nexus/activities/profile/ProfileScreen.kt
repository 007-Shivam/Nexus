package com.shivam.nexus.activities.profile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.shivam.nexus.activities.log_in.UserData

@Composable
fun ProfileScreen(
    userData: UserData?,
    onSignOut: () -> Unit
){
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
            )

    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if(userData?.profilePictureUrl != null) {
                AsyncImage(
                    model = userData.profilePictureUrl,
                    contentDescription = "Profile picture",
                    modifier = Modifier
                        .size(150.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(16.dp))
            }

            if(userData?.username != null) {
                Text(
                    text = userData.username,
                    textAlign = TextAlign.Center,
                    fontSize = 36.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(16.dp))
            }

            if(userData?.userEmail != null) {
                Text(
                    text = userData.userEmail,
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium
                )
                Spacer(modifier = Modifier.height(56.dp))
            }
            Button(
                onClick = onSignOut,
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red),

                ) {
                Text(text = "Sign out")
            }
        }
    }

}