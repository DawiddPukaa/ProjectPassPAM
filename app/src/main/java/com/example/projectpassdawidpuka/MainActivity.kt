package com.example.projectpassdawidpuka

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val goToAuthorButton = findViewById<Button>(R.id.add)
        val goToStudentListButton = findViewById<Button>(R.id.show)
        goToAuthorButton.setOnClickListener(goToAddStudentListner)
        goToStudentListButton.setOnClickListener(goToShowStudentsListner)

        val textViewIDCardd = findViewById<TextView>(R.id.editTextPosition)
        val textViewName = findViewById<TextView>(R.id.editTextName)
        val textViewSurname = findViewById<TextView>(R.id.editTextSurname)
        val textViewFieldOfStudy = findViewById<TextView>(R.id.editTextFieldOfStudy)
        val textViewNationality = findViewById<TextView>(R.id.editTextNationality)
        val textViewAge = findViewById<TextView>(R.id.editTextAge)
        val textViewAvgMarks = findViewById<TextView>(R.id.editTextAvgMarks)

        intent = intent;
        val idCardString: String = intent.getStringExtra("studentID").toString()
        val nameString: String = intent.getStringExtra("name").toString()
        val surnameString: String = intent.getStringExtra("surname").toString()
        val fieldOfStudyString: String = intent.getStringExtra("fieldOfStudy").toString()
        val nationalityString: String = intent.getStringExtra("nationality").toString()
        val agentString: String = intent.getStringExtra("age").toString()
        val avgMarksString: String = intent.getStringExtra("Marks").toString()

        textViewIDCardd.text = idCardString
        textViewName.text = nameString
        textViewSurname.text = surnameString
        textViewFieldOfStudy.text = fieldOfStudyString
        textViewNationality.text = nationalityString
        textViewAge.text = agentString
        textViewAvgMarks.text = avgMarksString

    }


    private val goToAddStudentListner =
        View.OnClickListener { callSecondActivityWithReturnParameters() }

    private val goToShowStudentsListner =
        View.OnClickListener { goToShowStudentsActivity() }

    fun callSecondActivityWithReturnParameters() {
        val intentWithResult = Intent(this, AddStudentActivity::class.java)
        startActivityForResult(intentWithResult, 2)

    }

    fun goToShowStudentsActivity() {
        val nextIntent = Intent(this, StaticticsActivity::class.java)
        startActivity(nextIntent)
    }


}

//przycisk safe data DONE
//funkcje zapisu bazy danych studentów DONE
// i usuwania z bazy danych studentów DONE
//SZUKANIE W BAZIE DONE
//zrobić toast DONE
//layout show
//layout delete



//walidacja na inputach
//nationality jako rozwijany pasek z opcjami
//Statystyki DONE
//dodanie wersji językowej
//ogarnąć o co chodzi z polem id student???????????????

