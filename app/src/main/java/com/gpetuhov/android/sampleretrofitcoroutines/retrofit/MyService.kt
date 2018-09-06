package com.gpetuhov.android.sampleretrofitcoroutines.retrofit

import kotlinx.coroutines.experimental.Deferred
import okhttp3.ResponseBody
import retrofit2.http.GET

interface MyService {
    @GET("/")
    fun getResponse(): Deferred<ResponseBody>
}
