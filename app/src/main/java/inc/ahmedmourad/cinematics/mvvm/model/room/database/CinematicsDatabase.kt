package inc.ahmedmourad.cinematics.mvvm.model.room.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context
import inc.ahmedmourad.cinematics.mvvm.model.room.converters.ImagesConverters
import inc.ahmedmourad.cinematics.mvvm.model.room.converters.MoviesConverters
import inc.ahmedmourad.cinematics.mvvm.model.room.converters.PersonsConverters
import inc.ahmedmourad.cinematics.mvvm.model.room.entities.*
import inc.ahmedmourad.cinematics.mvvm.model.room.daos.*
import inc.ahmedmourad.cinematics.utils.*

@Database(
        entities = [
            MoviesEntity::class,
            PopularMoviesEntity::class,
            TopRatedMoviesEntity::class,
            UpcomingMoviesEntity::class,
            NowPlayingMoviesEntity::class,
            ReviewsEntity::class,
            VideosEntity::class,
            CollectionsEntity::class,
            PersonsEntity::class,
            ListsEntity::class,
            ImagesEntity::class,
            CastMembersEntity::class,
            CrewMembersEntity::class,
            MoviesListsEntity::class,
            MoviesSimilarsEntity::class,
            MoviesRecommendationsEntity::class,
            CollectionsMoviesEntity::class,
            ListsMoviesEntity::class],
        version = 1,
        exportSchema = true)
@TypeConverters(value = [MoviesConverters::class, ImagesConverters::class, PersonsConverters::class])
abstract class CinematicsDatabase : RoomDatabase() {

    abstract fun moviesDao(): MoviesDao

    abstract fun collectionsDao(): CollectionsDao

    abstract fun personsDao(): PersonsDao

    abstract fun listsDao(): ListsDao

    abstract fun popularMoviesDao(): PopularMoviesDao

    abstract fun topRatedMoviesDao(): TopRatedMoviesDao

    abstract fun upcomingMoviesDao(): UpcomingMoviesDao

    abstract fun nowPlayingMoviesDao(): NowPlayingMoviesDao

    abstract fun reviewsDao(): ReviewsDao

    abstract fun videosDao(): VideosDao

    abstract fun imagesDao(): ImagesDao

    abstract fun castMembersDao(): CastMembersDao

    abstract fun crewMembersDao(): CrewMembersDao

    abstract fun moviesListsDao(): MoviesListsDao

    abstract fun moviesSimilarsDao(): MoviesSimilarsDao

    abstract fun moviesRecommendationsDao(): MoviesRecommendationsDao

    abstract fun collectionsMoviesDao(): CollectionsMoviesDao

    abstract fun listsMoviesDao(): ListsMoviesDao

    fun needsSync(context: Context) =
            when (defaultPrefs(context)[KEY_SOURCE, SOURCE_MOVIES]) {

                //TODO: might change this or make sure of the count when reading data
                SOURCE_MOVIES -> moviesDao().getCount() < 20

                else -> moviesDao().getCount() < 20
            }

    fun reset(context: Context) {

//        Utility.PreferencesManager.setSyncType(getContext(), TYPE_MOVIES_SIMPLE)

        // delete old data so we don't build up an endless history
        listsDao().deleteAll()
        moviesDao().deleteAll()
        videosDao().deleteAll()
        imagesDao().deleteAll()
        personsDao().deleteAll()
        reviewsDao().deleteAll()
        castMembersDao().deleteAll()
        crewMembersDao().deleteAll()
        collectionsDao().deleteAll()
        listsMoviesDao().deleteAll()
        moviesListsDao().deleteAll()
        popularMoviesDao().deleteAll()
        topRatedMoviesDao().deleteAll()
        upcomingMoviesDao().deleteAll()
        moviesSimilarsDao().deleteAll()
        nowPlayingMoviesDao().deleteAll()
        collectionsMoviesDao().deleteAll()
        moviesRecommendationsDao().deleteAll()

        popularMoviesDao().resetIndex()
        topRatedMoviesDao().resetIndex()
        upcomingMoviesDao().resetIndex()
        nowPlayingMoviesDao().resetIndex()

        val prefs = defaultPrefs(context)

        prefs[KEY_PAGE_POPULAR] = 1
        prefs[KEY_PAGE_TOP_RATED] = 1
        prefs[KEY_PAGE_NOW_PLAYING] = 1
        prefs[KEY_PAGE_UPCOMING] = 1

//        Utility.PreferencesManager.setIsFirstLoad(getContext(), true)
    }

    companion object {

        private const val DATABASE_NAME = "CinematicsDatabase"

        @Volatile
        private var INSTANCE: CinematicsDatabase? = null

        fun getInstance(context: Context) =
                INSTANCE ?: synchronized(this) {
                    INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
                }

        private fun buildDatabase(context: Context) =
                Room.databaseBuilder(
                        context.applicationContext,
                        CinematicsDatabase::class.java,
                        CinematicsDatabase.DATABASE_NAME
                ).build()
    }
}
