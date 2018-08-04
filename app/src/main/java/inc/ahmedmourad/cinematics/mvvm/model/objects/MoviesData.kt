package inc.ahmedmourad.cinematics.mvvm.model.objects

import com.google.gson.annotations.SerializedName
import inc.ahmedmourad.cinematics.mvvm.model.room.entities.*

data class CollectionInfo(
        @SerializedName(value = "id") var id: Int,
        @SerializedName(value = "name") var name: String,
        @SerializedName(value = "poster_path") var posterPath: String,
        @SerializedName(value = "backdrop_path") var backdropPath: String)

data class Genre(
        @SerializedName(value = "id") var id: Int,
        @SerializedName(value = "name") var name: String)

data class ProductionCompany(
        @SerializedName(value = "id") var id: Int,
        @SerializedName(value = "name") var name: String)

data class ProductionCountry(
        @SerializedName(value = "iso_3166_1") var shortcut: String,
        @SerializedName(value = "name") var name: String)

data class SpokenLanguage(
        @SerializedName(value = "iso_639_1") var shortcut: String,
        @SerializedName(value = "name") var name: String)

data class Title(
        @SerializedName(value = "iso_3166_1") var shortcut: String,
        @SerializedName(value = "title") var title: String)

data class AlternativeTitles(
        @SerializedName(value = "titles") var titles: List<Title>)

data class Keyword(
        @SerializedName(value = "id") var id: Int,
        @SerializedName(value = "name") var name: String)

data class Keywords(
        @SerializedName(value = "keywords") var keywords: List<Keyword>)

data class Translation(
        @SerializedName(value = "iso_639_1") var languageShortcut: String,
        @SerializedName(value = "iso_3166_1") var countryShortcut: String,
        @SerializedName(value = "name") var name: String,
        @SerializedName(value = "english_name") var englishName: String)

data class Translations(
        @SerializedName(value = "translations") var translations: List<Translation>)

data class Trailers(
        @SerializedName(value = "quicktime") var quicktime: List<VideosEntity>,
        @SerializedName(value = "youtube") var youtube: List<VideosEntity>)

data class MovieReviews(
        @SerializedName(value = "results") var reviews: List<ReviewsEntity>)

data class MovieSimilars(
        @SerializedName(value = "results") var similars: List<MoviesSimilarsEntity>)

data class MovieRecommendations(
        @SerializedName(value = "results") var recommendations: List<MoviesRecommendationsEntity>)

data class MovieLists(
        @SerializedName(value = "results") var lists: List<MoviesListsEntity>)

data class MovieCredits(
        @SerializedName(value = "cast") var castMembers: List<CastMembersEntity>,
        @SerializedName(value = "crew") var crewMembers: List<CrewMembersEntity>)

data class MovieImages(
        @SerializedName(value = "backdrops") var backdrops: List<ImagesEntity>,
        @SerializedName(value = "posters") var posters: List<ImagesEntity>)

data class Country(
        @SerializedName(value = "release_date") var releaseDate: String,
        @SerializedName(value = "iso_3166_1") var shortcut: String,
        @SerializedName(value = "primary") var isPrimary: Boolean,
        @SerializedName(value = "certification") var certification: String)

data class Releases(
        @SerializedName(value = "countries") var countries: List<Country>)
