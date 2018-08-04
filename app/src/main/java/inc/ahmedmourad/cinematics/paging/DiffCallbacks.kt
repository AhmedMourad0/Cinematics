package inc.ahmedmourad.cinematics.paging

import android.support.v7.recyclerview.extensions.DiffCallback
import inc.ahmedmourad.cinematics.mvvm.model.room.entities.MoviesEntity

class MoviesDiffCallback : DiffCallback<MoviesEntity>() {

    override fun areItemsTheSame(oldItem: MoviesEntity, newItem: MoviesEntity): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: MoviesEntity, newItem: MoviesEntity): Boolean {
        return oldItem == newItem
    }
}
