package com.example.taskahmedali.data.network

import com.example.taskahmedali.core.API_KEY
import com.example.taskahmedali.model.NewsRsm
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Ahmed Ali Ebaid
 * ahmedali26002844@gmail.com
 * 23/04/2022
 */
interface Api {

  @GET("v2/top-headlines")
  suspend fun getBreakingNews(
    @Query("country")
    country: String = "us",
    @Query("apiKey")
    apiKey: String = API_KEY
  ): NewsRsm?
}