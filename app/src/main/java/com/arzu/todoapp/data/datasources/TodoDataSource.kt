package com.arzu.todoapp.data.datasources

import com.arzu.todoapp.data.model.TodoEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

/*
 * Created by Arzu Pinarcıoğlu on 11-Dec-25
 */
@Singleton
class TodoDataSource @Inject constructor() {
    // We define an empty list in the DB.
    private val todos = MutableStateFlow<List<TodoEntity>>(emptyList())
    // get all todos
    fun getTodos() = todos.asStateFlow()

    suspend fun addTodo(title: String) {
        val newItem = TodoEntity(todos.value.size, title)
        todos.value += newItem
    }

    suspend fun deleteTodo(todo: TodoEntity) {
        todos.value -= todo
    }

}