package com.orangeman.example.todo.repositories.models

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import org.springframework.lang.NonNull

data class Task(
    @Id
    val id: Int = 0,

    @NonNull
    val description: String = "",

    val completed: Boolean = false,

)
