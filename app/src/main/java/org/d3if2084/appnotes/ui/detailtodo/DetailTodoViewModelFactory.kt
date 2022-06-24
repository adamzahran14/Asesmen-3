package org.d3if2084.appnotes.ui.detailtodo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3if2084.appnotes.data.db.TodoDao
import java.lang.IllegalArgumentException

class DetailTodoViewModelFactory (
    private val db: TodoDao,
    private val todoId : Long
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailTodoViewModel::class.java)) {
            return DetailTodoViewModel(db, todoId) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}