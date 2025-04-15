package com.example.student_list


data class StudentModel(
    val avatarResId: Int,
    val hoten: String,
    val mssv: String,
    var selected: Boolean = false
)