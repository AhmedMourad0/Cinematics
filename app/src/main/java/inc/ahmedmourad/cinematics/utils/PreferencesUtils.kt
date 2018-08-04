package inc.ahmedmourad.cinematics.utils

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

const val KEY_PAGE_POPULAR = "pp"
const val KEY_PAGE_TOP_RATED = "ptr"
const val KEY_PAGE_NOW_PLAYING = "pnp"
const val KEY_PAGE_UPCOMING = "pu"

const val KEY_SOURCE = "s"
const val SOURCE_MOVIES = 0

const val KEY_IS_SYNC_SCHEDULED = "isi"

fun defaultPrefs(context: Context): SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

fun customPrefs(context: Context, name: String): SharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE)

private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {

    val editor = this.edit()

    operation(editor)

    editor.apply()
}

/**
 * puts a key value pair in shared prefs if doesn't exists, otherwise updates value on given [key]
 */
operator fun SharedPreferences.set(key: String, value: Any) {

    when (value) {

        is String -> edit { it.putString(key, value) }

        is Int -> edit { it.putInt(key, value) }

        is Boolean -> edit { it.putBoolean(key, value) }

        is Float -> edit { it.putFloat(key, value) }

        is Long -> edit { it.putLong(key, value) }

        else -> throw UnsupportedOperationException("Type ${value::class} is not supported!")
    }
}

/**
 * finds value on given key.
 * [T] is the type of value
 * @param defaultValue optional default value - will take "" for strings, false for bool and -1 for numeric values if [defaultValue] is not specified or is null
 */
inline operator fun <reified T : Any> SharedPreferences.get(key: String, defaultValue: T? = null): T {

    return when (T::class) {

        String::class -> getString(key, defaultValue as? String ?: "") as T

        Int::class -> getInt(key, defaultValue as? Int ?: -1) as T

        Boolean::class -> getBoolean(key, defaultValue as? Boolean ?: false) as T

        Float::class -> getFloat(key, defaultValue as? Float ?: -1f) as T

        Long::class -> getLong(key, defaultValue as? Long ?: -1) as T

        else -> throw UnsupportedOperationException("Type ${T::class} is not supported!")
    }
}
