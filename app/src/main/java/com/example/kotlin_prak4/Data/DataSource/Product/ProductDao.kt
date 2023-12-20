package com.example.kotlin_prak4.Data.DataSource.Product

import androidx.lifecycle.LiveData
import androidx.room.*

 // работа с продуктами в базе данных.
@Dao
interface ProductDao {

    @Query("SELECT * FROM Product")
    fun getAll(): LiveData<List<Product>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(product: Product)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(products: List<Product>)

    @Delete
    suspend fun delete(product: Product)
}
