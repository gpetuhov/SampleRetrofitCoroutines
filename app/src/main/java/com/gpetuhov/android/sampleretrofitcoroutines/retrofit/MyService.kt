package com.gpetuhov.android.sampleretrofitcoroutines.retrofit

import kotlinx.coroutines.experimental.Deferred
import okhttp3.ResponseBody
import retrofit2.http.GET

// In this example we just print all of the response as string.
// We are using Retrofit Coroutine Adapter,
// so here instead of a Call or Observable the Service returns Deferred.
interface MyService {
    @GET("/")
    fun getResponse(): Deferred<ResponseBody>
}
