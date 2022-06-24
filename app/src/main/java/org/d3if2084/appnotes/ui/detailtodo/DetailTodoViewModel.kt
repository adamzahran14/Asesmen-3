package org.d3if2084.appnotes.ui.detailtodo

import androidx.lifecycle.ViewModel
import org.d3if2084.appnotes.data.db.TodoDao

class DetailTodoViewModel (private val db: TodoDao, private val todoId : Long): ViewModel()  {

    val data = db.getOneDataTodo(todoId)

}