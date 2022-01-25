package com.example.projectpassdawidpuka

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.projectpassdawidpuka.DAO.Student
import com.example.projectpassdawidpuka.DataBase.DataBaseHandler

class AddStudentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_student)

        val saveDataStudentButton = findViewById<Button>(R.id.saveDataStudent)
        val saveDataToDatabaseButton = findViewById<Button>(R.id.saveDataStudentToDataBase)
        val deleteDataToDatabaseButton = findViewById<Button>(R.id.delete)
        val searchDataToDatabaseButton = findViewById<Button>(R.id.search)

        saveDataStudentButton.setOnClickListener(saveDataStudentListner)
        saveDataToDatabaseButton.setOnClickListener(saveDataToDataBase)
        deleteDataToDatabaseButton.setOnClickListener(deleteStudentListener)
        searchDataToDatabaseButton.setOnClickListener(searchStudentListener)

    }

    val searchStudentListener =
        View.OnClickListener { showStudent() }

    val deleteStudentListener =
        View.OnClickListener { deleteStudent() }

    val saveDataToDataBase =
        View.OnClickListener { addStudent() }

    val saveDataStudentListner =
        View.OnClickListener { saveDataStudentToMain() }

    fun saveDataStudentToMain() {

        val idStudentCard = findViewById<EditText>(R.id.editTextStudentIdCard2)
        val idStudentCardString = idStudentCard.text.toString()
        val name = findViewById<EditText>(R.id.editTextName)
        val nameString: String = name.text.toString()
        val surname = findViewById<EditText>(R.id.editTextSurname)
        val surnameString: String = surname.text.toString()
        val fieldOfStudy = findViewById<EditText>(R.id.editTextFieldOfStudy)
        val fieldOfStudyString: String = fieldOfStudy.text.toString()
        val nationality = findViewById<EditText>(R.id.editTextNationality)
        val nationalityString: String = nationality.text.toString()
        val age = findViewById<EditText>(R.id.editTextAge)
        val ageString: String = age.text.toString()
        val avgMarks: Double = calculateAcgMarks()


        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("studentID", idStudentCardString)
        intent.putExtra("name", nameString)
        intent.putExtra("surname", surnameString)
        intent.putExtra("fieldOfStudy", fieldOfStudyString)
        intent.putExtra("nationality", nationalityString)
        intent.putExtra("age", ageString)
        intent.putExtra("Marks", avgMarks.toString())
        startActivity(intent)
    }

    fun calculateAcgMarks(): Double {
        val history = findViewById<EditText>(R.id.editTextHistory)
        val math = findViewById<EditText>(R.id.editTextMath)
        val chemistry = findViewById<EditText>(R.id.editTextChemistry)
        val biology = findViewById<EditText>(R.id.editTextBiology)

        val historyMark = history.text.toString().toDouble();
        val mathMark = math.text.toString().toDouble();
        val chemistryMark = chemistry.text.toString().toDouble();
        val biologyMark = biology.text.toString().toDouble();

        return (historyMark + mathMark + chemistryMark + biologyMark) / 4
    }

    fun addStudent() {
        val studentIdCard = findViewById<EditText>(R.id.editTextStudentIdCard2)
        val studentName = findViewById<EditText>(R.id.editTextName)
        val studentSurname = findViewById<EditText>(R.id.editTextSurname)
        val studentFieldOfStudy = findViewById<EditText>(R.id.editTextFieldOfStudy)
        val studentNationality = findViewById<EditText>(R.id.editTextNationality)
        val studentAge = findViewById<EditText>(R.id.editTextAge)
        val math = findViewById<EditText>(R.id.editTextMath)
        val history = findViewById<EditText>(R.id.editTextHistory)
        val chemistry = findViewById<EditText>(R.id.editTextChemistry)
        val biology = findViewById<EditText>(R.id.editTextBiology)
        val dataBaseHandler = DataBaseHandler(this, null, null, 1)


        val student = Student(
            studentIdCard.text.toString(),
            studentName.text.toString(),
            studentSurname.text.toString(),
            studentFieldOfStudy.text.toString(),
            studentNationality.text.toString(),
            studentAge.text.toString().toInt(),
            math.text.toString().toInt(),
            history.text.toString().toInt(),
            chemistry.text.toString().toInt(),
            biology.text.toString().toInt(),
        )
        dataBaseHandler.addStudent(student)
        Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show()
    }

    fun showStudent() {
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

        val student =
            dataBaseHandler.findStudent(studentName.text.toString(), studentSurname.text.toString())

        if (student != null) {
            studentIDCard.setText(student.studentIdCard)
            studentFieldOfStudy.setText(student.fieldOfStudy)
            studentNationality.setText(student.nationality)
            studentAge.setText(student.age.toString())
            studentMath.setText(student.math.toString())
            studentBiology.setText(student.biology.toString())
            studentChemistry.setText(student.chemistry.toString())
            studentHistory.setText(student.history.toString())

            Toast.makeText(this, "Data loaded!", Toast.LENGTH_SHORT).show()

        } else {
            Toast.makeText(this, "Unknown player!", Toast.LENGTH_SHORT).show()
        }
    }


    fun deleteStudent() {
        val studentName = findViewById<EditText>(R.id.editTextName)
        val studentSurname = findViewById<EditText>(R.id.editTextSurname)

        val dataBaseHandler = DataBaseHandler(this, null, null, 1)

        val result = dataBaseHandler.deleteStudent(
            studentName.text.toString(),
            studentSurname.text.toString()
        )

        if (result) {
            Toast.makeText(this, "Player deleted!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Unknown player!", Toast.LENGTH_SHORT).show()
        }
    }


}
