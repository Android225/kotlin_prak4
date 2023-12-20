package com.example.kotlin_prak4.Data.DataSource.Product

import androidx.lifecycle.LiveData

 // Репозиторий для работы с данными о продуктах.
class ProductRepository(private val productDao: ProductDao) {

    val getAllData: LiveData<List<Product>> = productDao.getAll()

    suspend fun addProduct(product: Product) {
        productDao.insert(product)
    }

    suspend fun addAllProduct(products: List<Product>) {
        productDao.insertAll(products)
    }

    suspend fun deleteProduct(product: Product) {
        productDao.delete(product)
    }
}
