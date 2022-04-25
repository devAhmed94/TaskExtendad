package com.example.taskahmedali.data.repositories

import com.example.taskahmedali.data.network.Api
import com.example.taskahmedali.model.NewsRsm
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test

/**
 * Ahmed Ali Ebaid
 * ahmedali26002844@gmail.com
 * 25/04/2022
 */
class NewsRepoTest{
  @Test
  fun `getBreakNews() with successful request return News response `() {

    runBlocking {

      //arrange
      val listNews = object : Api {
        override suspend fun getBreakingNews(country: String, apiKey: String): NewsRsm {
          return NewsRsm(
            "ok", 38,
            arrayListOf<NewsRsm.Article>(
              NewsRsm.Article(
                NewsRsm.Article.Source("1", "name"),
                "Rick Noack", "", "", "", "", "", ""
              )
            )
          )
        }
      }

      //act
      val result = listNews.getBreakingNews()

      // assert
      val expected =
        NewsRsm(
          "ok", 38,
          arrayListOf<NewsRsm.Article>(
            NewsRsm.Article(
              NewsRsm.Article.Source("1", "name"),
              "Rick Noack", "", "", "", "", "", ""
            )
          )
        )


      assertEquals(expected, result)

    }
  }

  @Test
  fun `getBreakNews() with successful request return empty response `() {

    runBlocking {

      //arrange
      val listNews = object : Api {
        override suspend fun getBreakingNews(country: String, apiKey: String): NewsRsm? {
          return null
        }
      }

      //act
      val result = listNews.getBreakingNews()

      // assert
      val expected = null

      assertEquals(expected, result)

    }
  }
}