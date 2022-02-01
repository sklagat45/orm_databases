package com.srklagat.orm_databases.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.srklagat.orm_databases.entities.models.School
import com.srklagat.orm_databases.entities.models.Student

data class SchoolWithStudents(
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val students: List<Student>
)