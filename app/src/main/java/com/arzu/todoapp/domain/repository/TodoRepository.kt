package com.arzu.todoapp.domain.repository

import com.arzu.todoapp.domain.model.Todo
import kotlinx.coroutines.flow.Flow

/*
 * Created by Arzu Pinarcıoğlu on 11-Dec-25
 */
interface TodoRepository {
    fun getTodos(): Flow<List<Todo>>
    suspend fun addTodo(title: String)
    suspend fun deleteTodo(todo: Todo)
}