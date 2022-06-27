package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.retrofit.api.ApiInterface
import com.example.retrofit.api.Apiutilities
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val userapi = Apiutilities.getInstance().create(ApiInterface::class.java)

        GlobalScope.launch {
            val result = userapi.getUser()
            if(result.body() != null){
                Log.d("Result","onCreate:${result.body()}")
            }
        }
    }
}