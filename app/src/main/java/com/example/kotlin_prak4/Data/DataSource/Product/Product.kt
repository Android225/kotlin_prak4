package com.example.kotlin_prak4.Data.DataSource.Product

import androidx.room.Entity
import androidx.room.PrimaryKey

 // Сущность "Продукт" для базы данных Room.
@Entity
data class Product(
    @PrimaryKey(autoGenerate = true)
    var id: Int,            // Уникальный идентификатор продукта
    var title: String,      // Название продукта
    var price: Double       // Цена продукта
)
