package models

data class Member(
    val id: Long,
    val name: String,
    val email: String?,
    val regNo: String?,
    val number: Long,
    val school: String,
    val year: Int,
    val department: String,
    val residence:  String?
)
