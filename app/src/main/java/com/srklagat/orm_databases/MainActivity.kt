package com.srklagat.orm_databases

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.srklagat.orm_databases.data.SchoolDatabase
import com.srklagat.orm_databases.entities.models.Director
import com.srklagat.orm_databases.entities.models.School
import com.srklagat.orm_databases.entities.models.Student
import com.srklagat.orm_databases.entities.models.Subject
import com.srklagat.orm_databases.entities.relations.StudentSubjectCrossRef
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dao = SchoolDatabase.getInstance(this).schoolDao

        val directors = listOf(
            Director("James K", "Flutter School"),
            Director("Iyan M", "Kotlin School"),
            Director("Birik N", "JetBrains School")
        )
        val schools = listOf(
            School("Flutter School"),
            School("Kotlin School"),
            School("JetBrains School")
        )
        val subjects = listOf(
            Subject("Dating for programmers"),
            Subject("Avoiding depression"),
            Subject("Bug Fix Meditation"),
            Subject("Logcat for Newbies"),
            Subject("How to use Google")
        )
        val students = listOf(
            Student("Sam  K", 2, "Kotlin School"),
            Student("Mumbi L", 5, "Flutter School"),
            Student("Mark M", 8, "Kotlin School"),
            Student("Lytah B", 1, "Kotlin School"),
            Student("James D", 2, "JetBrains School")
        )
        val studentSubjectRelations = listOf(
            StudentSubjectCrossRef("Sam  K", "Dating for programmers"),
            StudentSubjectCrossRef("Sam  K", "Avoiding depression"),
            StudentSubjectCrossRef("Sam  K", "Bug Fix Meditation"),
            StudentSubjectCrossRef("Mumbi L", "Logcat for Newbies"),
            StudentSubjectCrossRef("Mark M", "Dating for programmers"),
            StudentSubjectCrossRef("Lytah B", "How to use Google"),
            StudentSubjectCrossRef("Donny Jepp", "Logcat for Newbies"),
            StudentSubjectCrossRef("James D", "Avoiding depression"),
            StudentSubjectCrossRef("Sam  K", "Dating for programmers")
        )
        lifecycleScope.launch {
            directors.forEach { dao.insertDirector(it) }
            schools.forEach { dao.insertSchool(it) }
            subjects.forEach { dao.insertSubject(it) }
            students.forEach { dao.insertStudent(it) }
            studentSubjectRelations.forEach { dao.insertStudentSubjectCrossRef(it) }

            val schoolWithDirector = dao.getSchoolAndDirectorWithSchoolName("Kotlin School")

            val schoolWithStudents = dao.getSchoolWithStudents("Kotlin School")
        }
    }
}