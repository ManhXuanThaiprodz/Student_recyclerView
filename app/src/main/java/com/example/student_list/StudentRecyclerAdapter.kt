package com.example.student_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentRecyclerAdapter(
    val students: MutableList<StudentModel>) : RecyclerView.Adapter<StudentRecyclerAdapter.StudentViewHolder>() {
    class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageAvatar = itemView.findViewById<ImageView>(R.id.image_avatar)
        val textHoten = itemView.findViewById<TextView>(R.id.text_hoten)
        val textMssv = itemView.findViewById<TextView>(R.id.text_mssv)
        val checkSelected = itemView.findViewById<CheckBox>(R.id.check_selected)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.layout_student_item, parent, false)
        return StudentViewHolder(view)

    }
    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = students[position]
        holder.imageAvatar.setImageResource(student.avatarResId)
        holder.textHoten.text = student.hoten
        holder.textMssv.text = student.mssv
        holder.checkSelected.isChecked = student.selected
        holder.checkSelected.setOnClickListener {
            student.selected = !student.selected
            notifyItemChanged(position)
        }

    }
    override fun getItemCount() = students.size

}