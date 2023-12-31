package com.example.kotlin_prak4.Data.DataSource.Product

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

 // Абстрактный класс для базы данных Room.
@Database(entities = [Product::class], version = 1, exportSchema = false)
abstract class ProductDatabase : RoomDatabase() {

    abstract fun productDao(): ProductDao

    companion object {
        @Volatile
        private var INSTANCE: ProductDatabase? = null

        fun getDatabase(context: Context): ProductDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ProductDatabase::class.java,
                    "product_database"
                )
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
