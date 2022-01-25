package com.example.projectpassdawidpuka.Model

class Student {
    var id: Int = 0
    var studentIdCard: String = ""
    var name: String = ""
    var surname: String = ""
    var fieldOfStudy: String = ""
    var nationality: String = ""
    var age: Int = 0
    var math: Int = 0
    var history: Int = 0
    var biology: Int = 0
    var chemistry: Int = 0

    constructor(
        id: Int,
        studentIdCard: String,
        name: String,
        surname: String,
        fieldOfStudy: String,
        nationality: String,
        age: Int,
        math: Int,
        history: Int,
        biology: Int,
        chemistry: Int
    ) {
        this.id = id
        this.studentIdCard = studentIdCard
        this.name = name
        this.surname = surname
        this.fieldOfStudy = fieldOfStudy
        this.nationality = nationality
        this.age = age
        this.math = math
        this.history = history
        this.biology = biology
        this.chemistry = chemistry
    }

    constructor(
        studentIdCard: String,
        name: String,
        surname: String,
        fieldOfStudy: String,
        nationality: String,
        age: Int,
        math: Int,
        history: Int,
        biology: Int,
        chemistry: Int
    ) {
        this.studentIdCard = studentIdCard
        this.name = name
        this.surname = surname
        this.fieldOfStudy = fieldOfStudy
        this.nationality = nationality
        this.age = age
        this.math = math
        this.history = history
        this.biology = biology
        this.chemistry = chemistry
    }

    constructor()
}

