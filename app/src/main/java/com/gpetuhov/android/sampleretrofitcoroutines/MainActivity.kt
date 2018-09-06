package com.gpetuhov.android.sampleretrofitcoroutines

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.gpetuhov.android.sampleretrofitcoroutines.retrofit.MyService
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    val retrofit = Retrofit.Builder()
            .baseUrl("http://google.com/")
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        launch {
            val myService = retrofit.create(MyService::class.java)
            val result = myService.getResponse().await()

            launch(UI) {
                textView.text = result.string()
            }
        }
    }
}
