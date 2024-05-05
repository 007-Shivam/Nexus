package com.shivam.nexus.activities.enrolment

val communities = listOf(
    "GDSC",
    "GFG",
    "ACM",
    "E-CELL",
    "IIC",
    "NSS",
    "IEEE",
    "SWE",
    "TBP",
    "AIChE",
    "ASCE"
)

data class EnrolmentForm(
    val fullName: String?,
    val emailId: String?,
    val contactNumber: String?,
    val yourCommunity: String?,
    val communityName: String?,
)
