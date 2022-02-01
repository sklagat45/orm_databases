package com.srklagat.orm_databases.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.srklagat.orm_databases.entities.models.Student
import com.srklagat.orm_databases.entities.models.Subject

data class SubjectWithStudents(
    @Embedded val subject: Subject,
    @Relation(
        parentColumn = "subjectName",
        entityColumn = "studentName",
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val students: List<Student>
)