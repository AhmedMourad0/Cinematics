package inc.ahmedmourad.cinematics.utils

import android.content.Context
import android.util.Log
import android.widget.Toast
import inc.ahmedmourad.cinematics.mvvm.model.api.ApiClient
import inc.ahmedmourad.cinematics.mvvm.model.api.ApiInterface
import inc.ahmedmourad.cinematics.mvvm.model.objects.NowPlayingMovies
import inc.ahmedmourad.cinematics.mvvm.model.objects.PopularMovies
import inc.ahmedmourad.cinematics.mvvm.model.objects.TopRatedMovies
import inc.ahmedmourad.cinematics.mvvm.model.objects.UpcomingMovies
import inc.ahmedmourad.cinematics.mvvm.model.room.database.CinematicsDatabase
import org.jetbrains.anko.runOnUiThread
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.ConnectException
import java.net.UnknownHostException

fun fetchPopularMoviesData(context: Context, client: ApiInterface = ApiClient.getInstance().create(ApiInterface::class.java), db: CinematicsDatabase = CinematicsDatabase.getInstance(context), page: Int) {

    Log.e("00000000000000000000000", "page: $page")

    client.getPopularMovies(page = page).enqueue(object : Callback<PopularMovies> {

        override fun onResponse(call: Call<PopularMovies>, response: Response<PopularMovies>) {

            if (response.isSuccessful) {

                db.moviesDao().bulkInsert(
                        response.body()?.movies.orEmpty())

                db.popularMoviesDao().bulkInsert(
                        response.body()?.popularMovies.orEmpty())

            } else {

                context.runOnUiThread {

                    if (response.code() == 504)
                        Toast.makeText(
                                context,
                                "Movie Sync Failed!\nCheck your network connection.",
                                Toast.LENGTH_LONG).show()
                    else
                        Toast.makeText(
                                context,
                                "Movie Sync Failed!",
                                Toast.LENGTH_LONG).show()
                }
            }
        }

        override fun onFailure(call: Call<PopularMovies>, throwable: Throwable) {

            if (!call.isCanceled) {

                context.runOnUiThread {

                    if (throwable is ConnectException || throwable is UnknownHostException)
                        Toast.makeText(
                                context,
                                "Movie Sync Failed!\nCheck your network connection.",
                                Toast.LENGTH_LONG).show()
                    else
                        Toast.makeText(
                                context,
                                """Movie Sync Failed!
                            |${throwable.localizedMessage}
                            |${throwable.cause?.localizedMessage}""".trimMargin(),
                                Toast.LENGTH_LONG).show()
                }

                throwable.printStackTrace()
            }
        }
    })
}

fun fetchTopRatedMoviesData(context: Context, client: ApiInterface = ApiClient.getInstance().create(ApiInterface::class.java), db: CinematicsDatabase = CinematicsDatabase.getInstance(context), page: Int) {

    client.getTopRatedMovies(page = page).enqueue(object : Callback<TopRatedMovies> {

        override fun onResponse(call: Call<TopRatedMovies>, response: Response<TopRatedMovies>) {

            if (response.isSuccessful) {

                db.moviesDao().bulkInsert(
                        response.body()?.movies.orEmpty())

                db.topRatedMoviesDao().bulkInsert(
                        response.body()?.topRatedMovies.orEmpty())

            } else {

                context.runOnUiThread {

                    if (response.code() == 504)
                        Toast.makeText(
                                context,
                                "Movie Sync Failed!\nCheck your network connection.",
                                Toast.LENGTH_LONG).show()
                    else
                        Toast.makeText(
                                context,
                                "Movie Sync Failed!",
                                Toast.LENGTH_LONG).show()
                }
            }
        }

        override fun onFailure(call: Call<TopRatedMovies>, throwable: Throwable) {

            if (!call.isCanceled) {

                context.runOnUiThread {

                    if (throwable is ConnectException || throwable is UnknownHostException)
                        Toast.makeText(
                                context,
                                "Movie Sync Failed!\nCheck your network connection.",
                                Toast.LENGTH_LONG).show()
                    else
                        Toast.makeText(
                                context,
                                """Movie Sync Failed!
                            |${throwable.localizedMessage}
                            |${throwable.cause?.localizedMessage}""".trimMargin(),
                                Toast.LENGTH_LONG).show()
                }

                throwable.printStackTrace()
            }
        }
    })
}

fun fetchNowPlayingMoviesData(context: Context, client: ApiInterface = ApiClient.getInstance().create(ApiInterface::class.java), db: CinematicsDatabase = CinematicsDatabase.getInstance(context), page: Int) {

    client.getNowPlayingMovies(page = page).enqueue(object : Callback<NowPlayingMovies> {

        override fun onResponse(call: Call<NowPlayingMovies>, response: Response<NowPlayingMovies>) {

            if (response.isSuccessful) {

                db.moviesDao().bulkInsert(
                        response.body()?.movies.orEmpty())

                db.nowPlayingMoviesDao().bulkInsert(
                        response.body()?.nowPlayingMovies.orEmpty())

            } else {

                context.runOnUiThread {

                    if (response.code() == 504)
                        Toast.makeText(
                                context,
                                "Movie Sync Failed!\nCheck your network connection.",
                                Toast.LENGTH_LONG).show()
                    else
                        Toast.makeText(
                                context,
                                "Movie Sync Failed!",
                                Toast.LENGTH_LONG).show()
                }
            }
        }

        override fun onFailure(call: Call<NowPlayingMovies>, throwable: Throwable) {

            if (!call.isCanceled) {

                context.runOnUiThread {

                    if (throwable is ConnectException || throwable is UnknownHostException)
                        Toast.makeText(
                                context,
                                "Movie Sync Failed!\nCheck your network connection.",
                                Toast.LENGTH_LONG).show()
                    else
                        Toast.makeText(
                                context,
                                """Movie Sync Failed!
                            |${throwable.localizedMessage}
                            |${throwable.cause?.localizedMessage}""".trimMargin(),
                                Toast.LENGTH_LONG).show()
                }

                throwable.printStackTrace()
            }
        }
    })
}

fun fetchUpcomingMoviesData(context: Context, client: ApiInterface = ApiClient.getInstance().create(ApiInterface::class.java), db: CinematicsDatabase = CinematicsDatabase.getInstance(context), page: Int) {

    client.getUpcomingMovies(page = page).enqueue(object : Callback<UpcomingMovies> {

        override fun onResponse(call: Call<UpcomingMovies>, response: Response<UpcomingMovies>) {

            if (response.isSuccessful) {

                db.moviesDao().bulkInsert(
                        response.body()?.movies.orEmpty())

                db.upcomingMoviesDao().bulkInsert(
                        response.body()?.upcomingMovies.orEmpty())

            } else {

                context.runOnUiThread {

                    if (response.code() == 504)
                        Toast.makeText(
                                context,
                                "Movie Sync Failed!\nCheck your network connection.",
                                Toast.LENGTH_LONG).show()
                    else
                        Toast.makeText(
                                context,
                                "Movie Sync Failed!",
                                Toast.LENGTH_LONG).show()
                }
            }
        }

        override fun onFailure(call: Call<UpcomingMovies>, throwable: Throwable) {

            if (!call.isCanceled) {

                context.runOnUiThread {

                    if (throwable is ConnectException || throwable is UnknownHostException)
                        Toast.makeText(
                                context,
                                "Movie Sync Failed!\nCheck your network connection.",
                                Toast.LENGTH_LONG).show()
                    else
                        Toast.makeText(
                                context,
                                """Movie Sync Failed!
                            |${throwable.localizedMessage}
                            |${throwable.cause?.localizedMessage}""".trimMargin(),
                                Toast.LENGTH_LONG).show()
                }

                throwable.printStackTrace()
            }
        }
    })
}
