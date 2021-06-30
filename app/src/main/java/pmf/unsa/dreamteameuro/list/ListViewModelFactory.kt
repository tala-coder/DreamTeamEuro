package pmf.unsa.dreamteameuro.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import pmf.unsa.dreamteameuro.list.repository.Repository

class ListViewModelFactory(private val repository: Repository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ListViewModel(repository) as T
    }

}