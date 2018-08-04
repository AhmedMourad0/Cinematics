package inc.ahmedmourad.cinematics.mvvm.model.room.converters

import android.arch.persistence.room.TypeConverter

class PersonsConverters {

    companion object {

        @JvmStatic
        @TypeConverter
        fun stringsListToString(list: List<String>) = list.joinToString(separator = "||||")

        @JvmStatic
        @TypeConverter
        fun stringToStringsList(str: String) = str.split("||||").toList()
    }
}
