package com.arzu.todoapp.domain.usecase

import com.arzu.todoapp.domain.repository.TodoRepository
import javax.inject.Inject

/*
 * Created by Arzu Pinarcıoğlu on 11-Dec-25
 */
class GetTodosUseCase @Inject constructor(
    private val repository: TodoRepository
) {
    operator fun invoke() = repository.getTodos()
}