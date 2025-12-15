package com.arzu.todoapp.domain.usecase

import com.arzu.todoapp.domain.model.Todo
import com.arzu.todoapp.domain.repository.TodoRepository
import javax.inject.Inject

/*
 * Created by Arzu Pinarcıoğlu on 11-Dec-25
 */
class DeleteTodoUseCase @Inject constructor(
    private val repository: TodoRepository
) {
    suspend operator fun invoke(todo: Todo) {
        repository.deleteTodo(todo)
    }
}