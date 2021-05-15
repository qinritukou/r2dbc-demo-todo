package com.orangeman.example.todo.controllers

import com.orangeman.example.todo.repositories.TaskRepositories
import com.orangeman.example.todo.repositories.models.Task
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api/tasks")
class TaskController(
    private val taskRepositories: TaskRepositories
) {

    @GetMapping
    fun get(): Flux<Task> {
        return taskRepositories.findAll()
    }

    @PutMapping
    fun put(
        @RequestBody task: Task
    ): Mono<Integer> {
        return taskRepositories.updateStatus(task.id, task.completed)
    }

}