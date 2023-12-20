package com.example.kotlin_prak4.Data.DataSource.Product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_prak4.databinding.Fragment2Binding
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Fragment2 : Fragment() {
    // Привязка для использования с layout fragment2.xml.
    private lateinit var binding: Fragment2Binding

    // ViewModel для управления данными продуктов.
    private lateinit var viewModel: ProductVM

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Инициализация привязки макета.
        binding = Fragment2Binding.inflate(inflater, container, false)

        // Получение экземпляра ViewModel.
        viewModel = ViewModelProvider(this)[ProductVM::class.java]

        // Настройка Retrofit для работы с API.
        val retrofit = Retrofit.Builder()
            .baseUrl("https://dummyjson.com") // URL API.
            .addConverterFactory(GsonConverterFactory.create()) // Конвертер для JSON.
            .build()

        // Создание API-интерфейса из Retrofit.
        val productApi = retrofit.create(ProductApi::class.java)

        // Запуск корутины для асинхронного получения данных и их добавления в базу данных.
        CoroutineScope(Dispatchers.IO).launch {
            val products = productApi.getAllProduct()
            viewModel.addAllItem(products.products)
        }

        // Создание и настройка адаптера для RecyclerView.
        val adapter = ProductListAdapter()
        binding.resyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            this.adapter = adapter
        }

        // Наблюдение за LiveData из ViewModel и обновление UI.
        viewModel.allProducts.observe(viewLifecycleOwner) { product ->
            adapter.setData(product)
        }

        // Обработчики событий для кнопок интерфейса.
        binding.addButton.setOnClickListener {
            // Код для кнопки добавления нового продукта.
        }
        binding.buttonBackFragment2.setOnClickListener {
            // Код для возвращения на предыдущий экран.
        }

        return binding.root
    }
}
