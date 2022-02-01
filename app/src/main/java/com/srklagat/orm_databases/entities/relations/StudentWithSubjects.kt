package com.srklagat.orm_databases.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.srklagat.orm_databases.entities.models.Student
import com.srklagat.orm_databases.entities.models.Subject

data class StudentWithSubjects(
    @Embedded val student: Student,
    @Relation(
        parentColumn = "studentName",
        entityColumn = "subjectName",
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val subjects: List<Subject>
)