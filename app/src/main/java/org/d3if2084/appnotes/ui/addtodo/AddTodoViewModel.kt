package org.d3if2084.appnotes.ui.addtodo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import org.d3if2084.appnotes.data.db.TodoDao
import org.d3if2084.appnotes.data.db.TodoEntity
import org.d3if2084.appnotes.data.model.Todo
import org.d3if2084.appnotes.data.model.inputTodo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AddTodoViewModel (private val db: TodoDao): ViewModel() {

    private val hasilTodo = MutableLiveData<Todo?>()

    val data = db.getDataTodo()

    fun addTodo(title: String, isChecked : Boolean) {
        val dataTodo = TodoEntity(
            title = title,
            isChecked = isChecked
        )
        hasilTodo.value = dataTodo.inputTodo()

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                db.insert(dataTodo)
            }
        }
    }
}