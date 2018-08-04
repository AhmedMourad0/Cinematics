package inc.ahmedmourad.cinematics.mvvm.model.api

import inc.ahmedmourad.cinematics.BuildConfig
import inc.ahmedmourad.cinematics.mvvm.model.objects.*
import inc.ahmedmourad.cinematics.mvvm.model.room.entities.CollectionsEntity
import inc.ahmedmourad.cinematics.mvvm.model.room.entities.ListsEntity
import inc.ahmedmourad.cinematics.mvvm.model.room.entities.MoviesEntity
import inc.ahmedmourad.cinematics.mvvm.model.room.entities.PersonsEntity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {

    // http://api.themoviedb.org/3/movie/popular?api_key=0f02ef1fcb6f9f8b5d41a906f992a27a&page=1
    @GET("movie/popular")
    fun getPopularMovies(
            @Query("api_key") apiKey: String = BuildConfig.API_KEY,
            @Query("page") page: Int
    ): Call<PopularMovies>

    // http://api.themoviedb.org/3/movie/top_rated?api_key=0f02ef1fcb6f9f8b5d41a906f992a27a&page=1
    @GET("movie/top_rated")
    fun getTopRatedMovies(
            @Query("api_key") apiKey: String = BuildConfig.API_KEY,
            @Query("page") page: Int
    ): Call<TopRatedMovies>

    // http://api.themoviedb.org/3/movie/now_playing?api_key=0f02ef1fcb6f9f8b5d41a906f992a27a&page=1
    @GET("movie/now_playing")
    fun getNowPlayingMovies(
            @Query("api_key") apiKey: String = BuildConfig.API_KEY,
            @Query("page") page: Int
    ): Call<NowPlayingMovies>

    // http://api.themoviedb.org/3/movie/upcoming?api_key=0f02ef1fcb6f9f8b5d41a906f992a27a&page=1
    @GET("movie/upcoming")
    fun getUpcomingMovies(
            @Query("api_key") apiKey: String = BuildConfig.API_KEY,
            @Query("page") page: Int
    ): Call<UpcomingMovies>

    // http://api.themoviedb.org/3/movie/283995?api_key=0f02ef1fcb6f9f8b5d41a906f992a27a&append_to_response=trailers,alternative_titles,changes,credits,images,keywords,lists,releases,reviews,similar,translations,recommendations
    @GET("movie/{id}")
    fun getMovie(
            @Path("id") id: Int,
            @Query("api_key") apiKey: String = BuildConfig.API_KEY,
            @Query("append_to_response") append: String = "trailers,alternative_titles,changes,credits,images,keywords,lists,countries,reviews,similar,translations,recommendations"
    ): Call<MoviesEntity>

    // http://api.themoviedb.org/3/movie/20760/lists?api_key=0f02ef1fcb6f9f8b5d41a906f992a27a&page=1
    @GET("movie/{id}/lists")
    fun getMovieLists(
            @Path("id") id: Int,
            @Query("api_key") apiKey: String = BuildConfig.API_KEY,
            @Query("page") page: Int
    ): Call<Lists>

    // http://api.themoviedb.org/3/movie/263115/reviews?api_key=0f02ef1fcb6f9f8b5d41a906f992a27a&page=1
    @GET("movie/{id}/reviews")
    fun getMovieReviews(
            @Path("id") id: Int,
            @Query("api_key") apiKey: String = BuildConfig.API_KEY,
            @Query("page") page: Int
    ): Call<Reviews>

    // http://api.themoviedb.org/3/movie/263115/similar?api_key=0f02ef1fcb6f9f8b5d41a906f992a27a&page=1
    @GET("movie/{id}/similar")
    fun getMovieSimilars(
            @Path("id") id: Int,
            @Query("api_key") apiKey: String = BuildConfig.API_KEY,
            @Query("page") page: Int
    ): Call<Similars>

    // http://api.themoviedb.org/3/movie/263115/recommendations?api_key=0f02ef1fcb6f9f8b5d41a906f992a27a&page=1
    @GET("movie/{id}/recommendations")
    fun getMovieRecommendations(
            @Path("id") id: Int,
            @Query("api_key") apiKey: String = BuildConfig.API_KEY,
            @Query("page") page: Int
    ): Call<Recommendations>

    // http://api.themoviedb.org/3/list/6064?api_key=0f02ef1fcb6f9f8b5d41a906f992a27a
    @GET("list/{id}")
    fun getList(
            @Path("id") id: Int,
            @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): Call<ListsEntity>

    // http://api.themoviedb.org/3/collection/748?api_key=0f02ef1fcb6f9f8b5d41a906f992a27a&append_to_response=images
    @GET("collection/{id}")
    fun getCollection(
            @Path("id") id: Int,
            @Query("api_key") apiKey: String = BuildConfig.API_KEY,
            @Query("append_to_response") append: String = "images"
    ): Call<CollectionsEntity>

    // http://api.themoviedb.org/3/person/6968?api_key=0f02ef1fcb6f9f8b5d41a906f992a27a&append_to_response=changes,credits,images,tagged_images
    @GET("person/{id}")
    fun getPerson(
            @Path("id") id: Int,
            @Query("api_key") apiKey: String = BuildConfig.API_KEY,
            @Query("append_to_response") append: String = "changes,credits,images,tagged_images"
    ): Call<PersonsEntity>

    // http://api.themoviedb.org/3/person/6968/tagged_images?api_key=0f02ef1fcb6f9f8b5d41a906f992a27a&page=1
    @GET("person/{id}/tagged_images")
    fun getPersonTaggedImages(
            @Path("id") id: Int,
            @Query("api_key") apiKey: String = BuildConfig.API_KEY,
            @Query("page") page: Int
    ): Call<TaggedImages>
}
