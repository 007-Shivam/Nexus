package com.shivam.nexus.activities.enrolment

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.shivam.nexus.R

private val auth: FirebaseAuth by lazy { Firebase.auth }

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun EnrolmentScreen(){
    val context = LocalContext.current

    var fullName by remember { mutableStateOf("") }
    var emailId by remember { mutableStateOf("") }
    var contactNumber by remember { mutableStateOf("") }
    var yourCommunity by remember { mutableStateOf("") }
    var communityName by remember { mutableStateOf("") }

    var isExpanded by remember { mutableStateOf(false) }
    val keyboardController = LocalSoftwareKeyboardController.current

    fun validateForm(): Boolean {
        return !(fullName.isBlank() || emailId.isBlank() || contactNumber.isBlank() || yourCommunity.isBlank() || communityName.isBlank())
    }

    fun resetFields(){
        fullName = ""
        emailId = ""
        contactNumber = ""
        yourCommunity = ""
        communityName = ""
    }

    Box(
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
    ) {
        Text(
            text = stringResource(id = R.string.enrolment_title),
            style = TextStyle(
                fontSize = 35.sp,
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Bold,
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(20.dp)
        )

        LazyColumn (
            modifier = Modifier
                .align(Alignment.Center)
                .padding(top = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            item {
                TextField(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .border(
                            BorderStroke(width = 2.dp, color = Color.Black),
                            shape = RoundedCornerShape(50.dp)
                        )
                        .border(
                            width = 2.dp,
                            brush = Brush.radialGradient(listOf(Color.Black, Color.White)),
                            shape = RoundedCornerShape(50.dp)
                        ),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            keyboardController?.hide()
                        }
                    ),
                    value = fullName,
                    onValueChange = { fullName = it },
                    placeholder = { Text(text = stringResource(id = R.string.full_name)) },
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        disabledContainerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                    ),
                )
            }

            item{
                Spacer(modifier = Modifier.height(15.dp))
            }

            item {
                TextField(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .border(
                            BorderStroke(width = 2.dp, color = Color.Black),
                            shape = RoundedCornerShape(50.dp)
                        )
                        .border(
                            width = 2.dp,
                            brush = Brush.radialGradient(listOf(Color.Black, Color.White)),
                            shape = RoundedCornerShape(50.dp)
                        ),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            keyboardController?.hide()
                        }
                    ),
                    value = emailId,
                    onValueChange = { emailId = it },
                    placeholder = { Text(text = stringResource(id = R.string.email_id)) },
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        disabledContainerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                    ),
                )
            }

            item{
                Spacer(modifier = Modifier.height(15.dp))
            }

            item {
                TextField(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .border(
                            BorderStroke(width = 2.dp, color = Color.Black),
                            shape = RoundedCornerShape(50.dp)
                        )
                        .border(
                            width = 2.dp,
                            brush = Brush.radialGradient(listOf(Color.Black, Color.White)),
                            shape = RoundedCornerShape(50.dp)
                        ),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            keyboardController?.hide()
                        }
                    ),
                    value = contactNumber,
                    onValueChange = { contactNumber = it },
                    placeholder = { Text(text = stringResource(id = R.string.contact_no)) },
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        disabledContainerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                    ),
                )
            }

            item{
                Spacer(modifier = Modifier.height(15.dp))
            }

            item {
                ExposedDropdownMenuBox(expanded = isExpanded, onExpandedChange = {isExpanded = !isExpanded}) {
                    TextField(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .border(
                                BorderStroke(width = 2.dp, color = Color.Black),
                                shape = RoundedCornerShape(50.dp)
                            )
                            .border(
                                width = 2.dp,
                                brush = Brush.radialGradient(listOf(Color.Black, Color.White)),
                                shape = RoundedCornerShape(50.dp)
                            )
                            .menuAnchor(),
                        readOnly = true,
                        trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded) },
                        value = yourCommunity,
                        onValueChange = { yourCommunity = it },
                        placeholder = { Text(text = stringResource(id = R.string.choose_community)) },
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            disabledContainerColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent,
                        ),
                    )

                    ExposedDropdownMenu(
                        expanded = isExpanded,
                        onDismissRequest = { isExpanded = false },
                        modifier = Modifier.height(200.dp)
                    ) {
                        communities.forEachIndexed { index, text ->
                            DropdownMenuItem(
                                text = { Text(text = text) },
                                onClick = {
                                    yourCommunity = communities[index]
                                    isExpanded = false
                                },
                                contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                            )
                        }
                    }
                }
            }

            item{
                Spacer(modifier = Modifier.height(15.dp))
            }

            item {
                TextField(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .border(
                            BorderStroke(width = 2.dp, color = Color.Black),
                            shape = RoundedCornerShape(50.dp)
                        )
                        .border(
                            width = 2.dp,
                            brush = Brush.radialGradient(listOf(Color.Black, Color.White)),
                            shape = RoundedCornerShape(50.dp)
                        ),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            keyboardController?.hide()
                        }
                    ),
                    value = communityName,
                    onValueChange = { communityName = it },
                    placeholder = { Text(text = stringResource(id = R.string.name_community)) },
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        disabledContainerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                    ),
                )
            }

            item{
                Spacer(modifier = Modifier.height(20.dp))
            }

            item {
                Text(
                    text = stringResource(id = R.string.upload_title),
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontFamily = FontFamily.Default,
                        fontWeight = FontWeight.Bold,
                    ),
                    textAlign = TextAlign.Center,
                )
            }

            item{
                Spacer(modifier = Modifier.height(5.dp))
            }

            item {
                Text(
                    text = stringResource(id = R.string.upload_description),
                    style = TextStyle(
                        fontSize = 15.sp,
                        fontFamily = FontFamily.Default,
                    ),
                    textAlign = TextAlign.Center,
                )
            }

            item{
                Spacer(modifier = Modifier.height(15.dp))
            }

            item {
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
                    modifier = Modifier
                        .align(Alignment.Center)
                ) {
                    Icon(
                        imageVector = Icons.Rounded.AddCircle,
                        contentDescription = "upload_icon",
                        modifier = Modifier.size(15.dp)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = stringResource(id = R.string.upload_btn))
                }
            }

            item{
                Spacer(modifier = Modifier.height(15.dp))
            }

            item {
                Button(
                    onClick = {
                        if (validateForm()){
                            signUp(
                                fullName,
                                emailId,
                                contactNumber,
                                yourCommunity,
                                communityName,
                            )
                            resetFields()
                            Toast.makeText(context,
                                "Enrolled Successfully",
                                Toast.LENGTH_LONG
                            ).show()
                        } else{
                            Toast.makeText(context,
                                "Please fill all text fields.",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                    modifier = Modifier
                        .align(Alignment.Center)
                ) {
                    Text(text = stringResource(id = R.string.submit_btn))
                }
            }


        }
    }
}

@Preview
@Composable
fun EnrolmentScreenPreview() {
    EnrolmentScreen()
}


private fun signUp(
    fullName: String,
    emailId: String,
    contactNumber: String,
    yourCommunity: String,
    communityName: String,
) {
    val firestore = FirebaseFirestore.getInstance()
    val usersCollection = firestore.collection("Enrolment")

    // Check if email is already in use
    usersCollection.whereEqualTo("Email_Id", emailId)
        .get()
        .addOnSuccessListener { documents ->
            if (documents.isEmpty) {
                // Email is not in use, proceed with storing user data
                val userProfile = hashMapOf(
                    "Full_Name" to fullName,
                    "Email_Id" to emailId,
                    "Contact_Number" to contactNumber,
                    "Your_Community" to yourCommunity,
                    "Community_Name" to communityName
                )
                usersCollection.add(userProfile)
            }
        }
}
