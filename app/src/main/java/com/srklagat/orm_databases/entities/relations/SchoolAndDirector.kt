package com.srklagat.orm_databases.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.srklagat.orm_databases.entities.models.Director
import com.srklagat.orm_databases.entities.models.School

data class SchoolAndDirector(
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val director: Director
)