package com.arzu.todoapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arzu.todoapp.domain.model.Todo
import com.arzu.todoapp.domain.usecase.AddTodoUseCase
import com.arzu.todoapp.domain.usecase.DeleteTodoUseCase
import com.arzu.todoapp.domain.usecase.GetTodosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject


/*
 * Created by Arzu Pinarcıoğlu on 11-Dec-25
 */
@HiltViewModel
class TodoViewModel @Inject constructor(
    private val getTodosUseCase: GetTodosUseCase,
    private val addTodoUseCase: AddTodoUseCase,
    private val deleteTodoUseCase: DeleteTodoUseCase
): ViewModel() {
    val todoList : StateFlow<List<Todo>> = getTodosUseCase().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList<Todo>()
    )

    fun addTodo(title: String) {
        viewModelScope.launch {
            addTodoUseCase(title)
        }
    }
    fun deleteTodo(todo: Todo) {
        viewModelScope.launch {
            deleteTodoUseCase(todo)
        }
    }
}