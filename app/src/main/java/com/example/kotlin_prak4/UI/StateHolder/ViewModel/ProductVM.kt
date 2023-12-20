package com.example.kotlin_prak4.Data.DataSource.Product

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

 // ViewModel для управления данными продуктов.

class ProductVM(application: Application) : AndroidViewModel(application) {
    private val repository: ProductRepository
    val allProducts: LiveData<List<Product>>

    init {
        val productDao = ProductDatabase.getDatabase(application).productDao()
        repository = ProductRepository(productDao)
        allProducts = repository.getAllData
    }

    fun addProduct(product: Product) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addProduct(product)
        }
    }

    fun addAllItem(products: List<Product>) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addAllProduct(products)
        }
    }
}