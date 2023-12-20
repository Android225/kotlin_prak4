package com.example.kotlin_prak4.Data.DataSource.Product

import retrofit2.http.GET
import retrofit2.http.Path

 // Интерфейс для работы с API продуктов через Retrofit.
interface ProductApi {
    @GET("products")
    suspend fun getAllProduct(): Products

    //получение конкретного продукта по его ID
    @GET("products/{id}")
    suspend fun getProductById(@Path("id") productId: Int): Product
}
