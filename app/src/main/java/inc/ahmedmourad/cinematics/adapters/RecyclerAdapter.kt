package inc.ahmedmourad.cinematics.adapters

import android.arch.paging.PagedListAdapter
import android.content.Context
import android.net.Uri
import android.support.annotation.LayoutRes
import android.support.v7.recyclerview.extensions.DiffCallback
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

import inc.ahmedmourad.cinematics.R
import inc.ahmedmourad.cinematics.mvvm.model.room.entities.*
import kotlin.reflect.KClass

internal class RecyclerAdapter(private val clazz: KClass<*>, @LayoutRes private var itemId: Int, diffCallback: DiffCallback<MoviesEntity>) : PagedListAdapter<MoviesEntity, RecyclerAdapter.ViewHolder>(diffCallback) {

    //TODO: expandable card view and lazy scrolling

    override fun onCreateViewHolder(container: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(LayoutInflater.from(container.context).inflate(itemId, container, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    val context = holder.itemView.context

        when (clazz) {

            PopularMoviesEntity::class,
            TopRatedMoviesEntity::class,
            NowPlayingMoviesEntity::class,
            UpcomingMoviesEntity::class ->
                bindMovieData(holder, position, context)
        }
    }

    private fun bindMovieData(holder: ViewHolder, position: Int, context: Context) {

        val movie = getItem(position) ?: return

        holder.title.text = movie.originalTitle
        holder.language.text = context.getString(R.string.home_card_language, movie.originalLanguage)

        holder.categorySpecific.text =
                when (clazz) {

                    PopularMoviesEntity::class -> context.getString(R.string.home_card_popularity, movie.popularity)

                    TopRatedMoviesEntity::class, NowPlayingMoviesEntity::class -> context.getString(R.string.home_card_rating, movie.votesAverage)

                    UpcomingMoviesEntity::class -> context.getString(R.string.home_card_release_date, movie.releaseDate)

                    else -> throw UnsupportedOperationException("Not yet supported!")
                }

        holder.overview.text =
                if (movie.overview.length > 105)
                    movie.overview.substring(0, 104).plus("...")
                else
                    movie.overview.plus(".")

        if (movie.isAdult)
            holder.adult.visibility = View.VISIBLE
        else
            holder.adult.visibility = View.INVISIBLE

        //TODO: this will change
        val posterBaseUrl = "http://image.tmdb.org/t/p/"
        val pathSize = "w342" //"w92", "w154", "w185", "w342", "w500", "w780"

        val uri = Uri.parse(posterBaseUrl).buildUpon()
                .appendPath(pathSize)
                .appendPath(movie.posterPath)
                .build()

        //TODO: a loading image
        //.error(null) //TODO: error image

        //TODO: might try Glide instead of this
        Picasso.with(context)
                .load(uri.toString().replace("%2F", "/"))
                .into(holder.poster)
    }

    internal inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val poster: ImageView = view.findViewById(R.id.poster)
        val title: TextView = view.findViewById(R.id.title)
        val overview: TextView = view.findViewById(R.id.overview)
        val language: TextView = view.findViewById(R.id.language)
        val adult: TextView = view.findViewById(R.id.adult)
        val categorySpecific: TextView = view.findViewById(R.id.category_specific)
    }
}
