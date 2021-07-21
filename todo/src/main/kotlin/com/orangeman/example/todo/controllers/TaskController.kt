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

    @GetMapping("/{id}")
    fun get(@PathVariable("id") id: Int): Mono<Task> {
        return taskRepositories.findById(id)
    }

    @PostMapping
    fun create(
        @RequestBody task: Task
    ): Mono<Task> {
        return taskRepositories.save(task)
    }

    @PutMapping
    fun updateStatus(
        @RequestBody task: Task
    ): Mono<Int> {
        return taskRepositories.updateStatus(task.id, task.completed)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Int) {

    }

}