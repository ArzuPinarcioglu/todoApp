package com.arzu.todoapp.domain.model

import com.arzu.todoapp.data.model.TodoEntity

/*
 * Created by Arzu Pinarcıoğlu on 11-Dec-25
 */
data class Todo(
    val id: Int,
    val title: String,
) {
    fun toEntity() : TodoEntity = TodoEntity(id, title )
}