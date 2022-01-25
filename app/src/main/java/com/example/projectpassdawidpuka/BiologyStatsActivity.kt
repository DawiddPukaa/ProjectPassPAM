package com.example.projectpassdawidpuka

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.example.projectpassdawidpuka.DAO.Student
import com.example.projectpassdawidpuka.DataBase.DataBaseHandler

class BiologyStatsActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_biology_stats)

        val editTextPercent5 = findViewById<TextView>(R.id.editTextPerCentBio5)
        val editTextPercent4 = findViewById<TextView>(R.id.editTextPerCentBio4)
        val editTextPercent3 = findViewById<TextView>(R.id.editTextPerCentBio3)
        val editTextPercent2 = findViewById<TextView>(R.id.editTextPerCentBio2)
        val editTextPercent1 = findViewById<TextView>(R.id.editTextPerCentBio1)

        val bioMarks =   getAllStudentsFromDatabase()

        var percentMark5 = calculatePercentMark(bioMarks,5)
        editTextPercent5.text = "$percentMark5 %".toString()
        var percentMark4 = calculatePercentMark(bioMarks,4)
        editTextPercent4.text = "$percentMark4 %".toString()
        var percentMark3 = calculatePercentMark(bioMarks,3)
        editTextPercent3.text = "$percentMark3 %"
        var percentMark2 = calculatePercentMark(bioMarks,2)
        editTextPercent2.text = "$percentMark2 %".toString()
        var percentMark1 = calculatePercentMark(bioMarks,1)
        editTextPercent1.text = "$percentMark1 %".toString()
    }

    fun getAllStudentsFromDatabase(): ArrayList<Int> {

        val studentIDCard = findViewById<EditText>(R.id.editTextStudentIdCard2)
        val studentName = findViewById<EditText>(R.id.editTextName)
        val studentSurname = findViewById<EditText>(R.id.editTextSurname)
        val studentFieldOfStudy = findViewById<EditText>(R.id.editTextFieldOfStudy)
        val studentNationality = findViewById<EditText>(R.id.editTextNationality)
        val studentAge = findViewById<EditText>(R.id.editTextAge)
        val studentMath = findViewById<EditText>(R.id.editTextMath)
        val studentBiology = findViewById<EditText>(R.id.editTextBiology)
        val studentChemistry = findViewById<EditText>(R.id.editTextChemistry)
        val studentHistory = findViewById<EditText>(R.id.editTextHistory)


        val dataBaseHandler = DataBaseHandler(this, null, null, 1)

        val students = dataBaseHandler.getAllStudents()

        val bioMarks: ArrayList<Int> = ArrayList<Int>(students.size)


        for (i in students.indices) {
            bioMarks.add(students[i].biology)
        }
        return bioMarks;
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun calculatePercentMark(marks: ArrayList<Int>, x: Int): Double {
        val count: Long = marks
            .stream()
            .filter { i -> i.equals(x) }
            .count()
        var result = ((count.toDouble() / marks.size.toDouble()) * 100)
        return result
    }
}