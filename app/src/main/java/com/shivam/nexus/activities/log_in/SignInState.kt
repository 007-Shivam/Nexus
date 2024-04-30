package com.shivam.nexus.activities.log_in

data class SignInState(
    val isSignInSuccessful: Boolean = false,
    val signInError: String? = null
)
