package com.arzu.todoapp.data.repository

import com.arzu.todoapp.data.datasources.TodoDataSource
import com.arzu.todoapp.data.model.TodoEntity
import com.arzu.todoapp.domain.model.Todo
import com.arzu.todoapp.domain.repository.TodoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/*
 * Created by Arzu Pinarcıoğlu on 11-Dec-25
 */
class TodoRepositoryImpl @Inject constructor(
    private val dataSource: TodoDataSource
): TodoRepository {
    override fun getTodos(): Flow<List<Todo>> {
        return dataSource.getTodos().map { list ->
            list.map {
                Todo(it.id, it.title)
            }
        }
    }

    override suspend fun addTodo(title: String) {
        dataSource.addTodo(title)
    }

    override suspend fun deleteTodo(todo: Todo) {
        dataSource.deleteTodo(
            todo.toEntity()
        )
    }
}