package com.example.projectpassdawidpuka.DataBase

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.projectpassdawidpuka.DAO.Student

class DataBaseHandler(
    context: Context,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

    companion object {
        val DATABASE_VERSION = 1
        val DATABASE_NAME = "studentDB.db"
        val TABLE_STUDENTS = "student"

        val COLUMN_ID = "id"
        val COLUMN_STUDENTCARDID = "student_card_id"
        val COLUMN_STUDENTNAME = "student_name"
        val COLUMN_STUDENTSURNAME = "student_surname"
        val COLUMN_FIELDOFSTUDY = "student_field_of_study"
        val COLUMN_NATIONALITY = "player_nationality"
        val COLUMN_AGE = "player_age"
        val COLUMN_MATH = "math"
        val COLUMN_HISTORY = "history"
        val COLUMN_BIOLOGY = "biology"
        val COLUMN_CHEMISTRY = "chemistry"

    }

    override fun onCreate(db: SQLiteDatabase?) {
        var CREATE_PLAYERS_TABLE = ("CREATE TABLE " +
                TABLE_STUDENTS + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_STUDENTCARDID + " INTEGER,"
                + COLUMN_STUDENTNAME + " TEXT,"
                + COLUMN_STUDENTSURNAME + " TEXT,"
                + COLUMN_FIELDOFSTUDY + " TEXT,"
                + COLUMN_NATIONALITY + " TEXT,"
                + COLUMN_AGE + " TEXT,"
                + COLUMN_MATH + " TEXT,"
                + COLUMN_HISTORY + " TEXT,"
                + COLUMN_BIOLOGY + " TEXT,"
                + COLUMN_CHEMISTRY + " TEXT" + ")"
                )
        db?.execSQL(CREATE_PLAYERS_TABLE)
    }

    override fun onUpgrade(s0: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        s0?.execSQL("DROP TABLE IF EXISTS" + TABLE_STUDENTS)
        onCreate(s0)
    }

    fun addStudent(student: Student) {
        val values = ContentValues()

        values.put(COLUMN_STUDENTCARDID, student.studentIdCard)
        values.put(COLUMN_STUDENTNAME, student.name)
        values.put(COLUMN_STUDENTSURNAME, student.surname)
        values.put(COLUMN_FIELDOFSTUDY, student.fieldOfStudy)
        values.put(COLUMN_NATIONALITY, student.nationality)
        values.put(COLUMN_AGE, student.age)
        values.put(COLUMN_MATH, student.math)
        values.put(COLUMN_BIOLOGY, student.biology)
        values.put(COLUMN_CHEMISTRY, student.chemistry)
        values.put(COLUMN_HISTORY, student.history)

        val db = this.writableDatabase
        db.insert(TABLE_STUDENTS, null, values)
        db.close()
    }

    fun deleteStudent(studentName: String, studentSurname: String): Boolean {
        var result = false

        val query =
            "SELECT * from $TABLE_STUDENTS WHERE $COLUMN_STUDENTNAME = \"$studentName\"" +
                    "and $COLUMN_STUDENTSURNAME = \"$studentSurname\""

        val db = this.writableDatabase

        val cursor = db.rawQuery(query, null)

        if (cursor.moveToFirst()) {
            val id = Integer.parseInt(cursor.getString(0))
            db.delete(
                TABLE_STUDENTS, COLUMN_ID + " = ?",
                arrayOf(id.toString())
            )
            cursor.close()
            result = true
        }
        db.close()
        return result
    }

    fun findStudent(studentName: String, studentSurname: String): Student? {
        val query =
            "SELECT * from $TABLE_STUDENTS WHERE $COLUMN_STUDENTNAME = \"$studentName\"" +
                    "and $COLUMN_STUDENTSURNAME = \"$studentSurname\""
        val db = this.writableDatabase
        val cursor = db.rawQuery(query, null)
        var student: Student? = null

        if (cursor.moveToFirst()) {
            cursor.moveToFirst()

            val id = cursor.getString(0).toInt()
            val studentIDCard = cursor.getString(1)
            val studentNameC = cursor.getString(2)
            val studentSurnameC = cursor.getString(3)
            val studentFieldOfStudy = cursor.getString(4)
            val studentNationality = cursor.getString(5)
            val studentAge = cursor.getString(6).toInt()
            val studentMath = cursor.getString(7).toInt()
            val studentHistory = cursor.getString(8).toInt()
            val studentBiology = cursor.getString(9).toInt()
            val studentChemistry = cursor.getString(10).toInt()

            student = Student(
                id,
                studentIDCard,
                studentNameC,
                studentSurnameC,
                studentFieldOfStudy,
                studentNationality,
                studentAge,
                studentMath,
                studentHistory,
                studentBiology,
                studentChemistry
            )
            cursor.close()
        }
        db.close()
        return student
    }


    //getAll students

    fun getAllStudents(): ArrayList<Student> {

        var students = ArrayList<Student>()
        //Select All Query

        val query = "SELECT * FROM " + TABLE_STUDENTS

        val db: SQLiteDatabase = this.writableDatabase
        val cursor: Cursor = db.rawQuery(query, null)

        // looping through all rows and adding to list
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {

            do {
                val pt: Student = Student()
                pt.id = cursor.getString(0).toInt()
                pt.studentIdCard = cursor.getString(1)
                pt.name = cursor.getString(2)
                pt.surname = cursor.getString(3)
                pt.fieldOfStudy = cursor.getString(4)
                pt.nationality = cursor.getString(5)
                pt.age = cursor.getString(6).toInt()
                pt.math = cursor.getString(7).toInt()
                pt.biology = cursor.getString(8).toInt()
                pt.history = cursor.getString(9).toInt()
                pt.chemistry = cursor.getString(10).toInt()

                //String name = cursor.getString(1);

                //MainActivity.ArrayofName.add(name);
                // Adding contact to list

                students.add(pt)
            } while (cursor.moveToNext())
        }
        // return placetype list

        return students
    }
}


