package com.daniilmaster.retrofittest.api

import com.daniilmaster.retrofittest.model.Post
import retrofit2.Response
import retrofit2.http.*

interface SimpleApi {
//    @GET("posts/1")
//    suspend fun getPost(): Post

    //    @GET("psts/1")
    @GET("posts/1")
    suspend fun getPost(): Response<Post>

    @GET("posts/")
    suspend fun getPosts(): Response<List<Post>>


    @GET("posts/{postNumber}")
    suspend fun getPostNumber(
        @Path("postNumber") number: Int
    ): Response<Post>

    @GET("posts")
    suspend fun getCustomPost(
        @Query("userId") userId: Int,
        @Query("_sort") sort: String,
        @Query("_order") order: String
    ): Response<List<Post>>

    @GET("posts")
    suspend fun getCustomPost2(
        @Query("userId") userId: Int,
        @QueryMap options: Map<String, String>
    ): Response<List<Post>>
    
    @POST("posts")
    suspend fun pushPost(
        @Body post: Post
    ): Response<Post>

    @FormUrlEncoded // memo (отправка в виде URL запроса userId=1&id=1 и т.д.)
    @POST("posts")
    suspend fun pushPost2(
        @Field("userId") userId: Int,
        @Field("id") id: Int,
        @Field("title") title: String,
        @Field("body") body: String
    ): Response<Post>
}