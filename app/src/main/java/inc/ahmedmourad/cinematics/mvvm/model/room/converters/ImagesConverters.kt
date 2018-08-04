package inc.ahmedmourad.cinematics.mvvm.model.room.converters

import android.arch.persistence.room.TypeConverter
import inc.ahmedmourad.cinematics.mvvm.model.objects.Media

class ImagesConverters {

    companion object {

        @JvmStatic
        @TypeConverter
        fun mediaToInt(media: Media) = media.id

        @JvmStatic
        @TypeConverter
        fun intToMedia(id: Int) = Media(id)
    }
}