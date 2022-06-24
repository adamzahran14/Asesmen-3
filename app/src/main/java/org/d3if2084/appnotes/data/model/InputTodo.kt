package org.d3if2084.appnotes.data.model

import org.d3if2084.appnotes.data.db.TodoEntity

fun TodoEntity.inputTodo(): Todo {
    val title = title
    return Todo(title)
}