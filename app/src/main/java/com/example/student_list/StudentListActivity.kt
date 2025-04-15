package com.example.student_list

import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.student_list.R
import com.example.student_list.StudentAdapter
import com.example.student_list.StudentModel
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.student_list.StudentRecyclerAdapter

class StudentListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_list)

        val students = mutableListOf<StudentModel>()
        repeat(28) {
            students.add(
                StudentModel(
                    resources.getIdentifier("thumb$it", "drawable", packageName),
                    "Student $it",
                    "SV$it"
                )
            )
        }

        val adapter = StudentRecyclerAdapter(students)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_students)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)


        // add student
        val btnAdd = findViewById<Button>(R.id.btn_add)
        val inputHoten = findViewById<EditText>(R.id.input_hoten)
        val inputMSSV = findViewById<EditText>(R.id.input_mssv)

        btnAdd.setOnClickListener {
            val hoten = inputHoten.text.toString()
            val mssv = inputMSSV.text.toString()
            if (hoten.isNotEmpty() && mssv.isNotEmpty()) {
                val newStudent = StudentModel(
                    R.drawable.thumb1,
                    hoten,
                    mssv
                )
                students.add(0, newStudent)
                adapter.notifyDataSetChanged()
                inputHoten.text.clear()
                inputMSSV.text.clear()
            }
        }
        // delete student
        val btnDel = findViewById<Button>(R.id.btn_del)
        btnDel.setOnClickListener{
            val selectedStudents = students.filter { it.selected }
            students.removeAll(selectedStudents)
            adapter.notifyDataSetChanged()
        }
    }
}