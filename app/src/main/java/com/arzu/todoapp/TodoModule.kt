package com.arzu.todoapp

import com.arzu.todoapp.data.repository.TodoRepositoryImpl
import com.arzu.todoapp.domain.repository.TodoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/*
 * Created by Arzu Pinarcıoğlu on 11-Dec-25
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class TodoModule {

    @Binds
    abstract fun bindTodoRepository(
        impl: TodoRepositoryImpl
    ): TodoRepository

}