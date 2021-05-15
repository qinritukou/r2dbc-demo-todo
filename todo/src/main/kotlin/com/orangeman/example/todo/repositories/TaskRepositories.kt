package com.orangeman.example.todo.repositories

import com.orangeman.example.todo.repositories.models.Task
import org.springframework.data.r2dbc.repository.Modifying
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Mono

interface TaskRepositories : ReactiveCrudRepository<Task, Int> {

    @Modifying
    @Query("update task set completed=:completed where id=:id")
    fun updateStatus(id: Int, completed: Boolean): Mono<Integer>

}