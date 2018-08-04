package inc.ahmedmourad.cinematics.mvvm.model.room.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Ignore
import com.google.gson.annotations.SerializedName
import inc.ahmedmourad.cinematics.mvvm.model.objects.*

@Entity(tableName = MoviesEntity.TABLE_NAME)
class MoviesEntity @Ignore private constructor() {

    @SerializedName(value = "id")
    @PrimaryKey
    @ColumnInfo(name = COLUMN_ID)
    var id = -1L

    @SerializedName(value = "poster_path")
    @ColumnInfo(name = COLUMN_POSTER_PATH)
    var posterPath: String? = null

    @SerializedName(value = "release_date")
    @ColumnInfo(name = COLUMN_RELEASE_DATE)
    var releaseDate = ""

    @SerializedName(value = "original_title")
    @ColumnInfo(name = COLUMN_ORIGINAL_TITLE)
    var originalTitle = ""

    @SerializedName(value = "original_language")
    @ColumnInfo(name = COLUMN_ORIGINAL_LANGUAGE)
    var originalLanguage = ""

    @SerializedName(value = "vote_average")
    @ColumnInfo(name = COLUMN_VOTES_AVERAGE)
    var votesAverage = 0.0

    @SerializedName(value = "vote_count")
    @ColumnInfo(name = COLUMN_VOTES_COUNT)
    var votesCount: Long? = null

    @SerializedName(value = "backdrop_path")
    @ColumnInfo(name = COLUMN_BACKDROP_PATH)
    var backdropPath: String? = null

    @SerializedName(value = "adult")
    @ColumnInfo(name = COLUMN_IS_ADULT)
    var isAdult = false

    @SerializedName(value = "overview")
    @ColumnInfo(name = COLUMN_OVERVIEW)
    var overview = ""

    @SerializedName(value = "popularity")
    @ColumnInfo(name = COLUMN_POPULARITY)
    var popularity = 0.0

    @SerializedName(value = "video")
    @ColumnInfo(name = COLUMN_VIDEO)
    var video: String? = null

    @SerializedName(value = "belongs_to_collection")
    @ColumnInfo(name = COLUMN_COLLECTION_INFO)
    var collectionInfo: CollectionInfo? = null

    @SerializedName(value = "production_companies")
    @ColumnInfo(name = COLUMN_PRODUCTION_COMPANIES)
    var productionCompanies: List<ProductionCompany>? = null

    @SerializedName(value = "production_countries")
    @ColumnInfo(name = COLUMN_PRODUCTION_COUNTRIES)
    var productionCountries: List<ProductionCountry>? = null

    @SerializedName(value = "spoken_languages")
    @ColumnInfo(name = COLUMN_SPOKEN_LANGUAGES)
    var spokenLanguages: List<SpokenLanguage>? = null

    @SerializedName(value = "alternative_titles")
    @ColumnInfo(name = COLUMN_ALTERNATIVE_TITLES)
    var alternativeTitles: AlternativeTitles? = null

    @SerializedName(value = "imdb_id")
    @ColumnInfo(name = COLUMN_IMDB_ID)
    var imdbId: String? = null

    @SerializedName(value = "genres")
    @ColumnInfo(name = COLUMN_GENRES)
    var genres: List<Genre>? = null

    @SerializedName(value = "budget")
    @ColumnInfo(name = COLUMN_BUDGET)
    var budget: Long? = null

    @SerializedName(value = "homepage")
    @ColumnInfo(name = COLUMN_HOMEPAGE)
    var homepage: String? = null

    @SerializedName(value = "revenue")
    @ColumnInfo(name = COLUMN_REVENUE)
    var revenue: Long? = null

    @SerializedName(value = "runtime")
    @ColumnInfo(name = COLUMN_RUNTIME)
    var runtime: Int? = null

    @SerializedName(value = "status")
    @ColumnInfo(name = COLUMN_STATUS)
    var status: String? = null

    @SerializedName(value = "tagline")
    @ColumnInfo(name = COLUMN_TAGLINE)
    var tagline: String? = null

    @SerializedName(value = "keywords")
    @ColumnInfo(name = COLUMN_KEYWORDS)
    var keywords: Keywords? = null

    @SerializedName(value = "translations")
    @ColumnInfo(name = COLUMN_TRANSLATIONS)
    var translations: Translations? = null

    @SerializedName(value = "releases")
    @ColumnInfo(name = COLUMN_RELEASES)
    var releases: Releases? = null

    @SerializedName(value = "trailers")
    @Ignore
    var trailers: Trailers? = null

    @SerializedName(value = "reviews")
    @Ignore
    var reviews: MovieReviews? = null

    @SerializedName(value = "similar")
    @Ignore
    var similars: MovieSimilars? = null

    @SerializedName(value = "recommendations")
    @Ignore
    var recommendations: MovieRecommendations? = null

    @SerializedName(value = "lists")
    @Ignore
    var lists: MovieLists? = null

    @SerializedName(value = "credits")
    @Ignore
    var credits: MovieCredits? = null

    @SerializedName(value = "images")
    @Ignore
    var images: MovieImages? = null

    constructor(
            id: Long, posterPath: String?, releaseDate: String, originalTitle: String,
            originalLanguage: String, votesAverage: Double, votesCount: Long?, backdropPath: String?,
            collectionInfo: CollectionInfo?, productionCompanies: List<ProductionCompany>?,
            productionCountries: List<ProductionCountry>?, spokenLanguages: List<SpokenLanguage>?,
            alternativeTitles: AlternativeTitles?, imdbId: String?, adult: Boolean, overview: String,
            popularity: Double, video: String?, genres: List<Genre>?, budget: Long?,
            homepage: String?, revenue: Long?, runtime: Int?, status: String?, tagline: String?,
            keywords: Keywords?, translations: Translations?, releases: Releases?) : this() {

        this.id = id
        this.posterPath = posterPath
        this.releaseDate = releaseDate
        this.originalTitle = originalTitle
        this.originalLanguage = originalLanguage
        this.votesAverage = votesAverage
        this.votesCount = votesCount
        this.backdropPath = backdropPath
        this.collectionInfo = collectionInfo
        this.productionCompanies = productionCompanies
        this.productionCountries = productionCountries
        this.spokenLanguages = spokenLanguages
        this.alternativeTitles = alternativeTitles
        this.imdbId = imdbId
        this.isAdult = adult
        this.overview = overview
        this.popularity = popularity
        this.video = video
        this.genres = genres
        this.budget = budget
        this.homepage = homepage
        this.revenue = revenue
        this.runtime = runtime
        this.status = status
        this.tagline = tagline
        this.keywords = keywords
        this.translations = translations
        this.releases = releases
    }

    @Ignore
    constructor(
            id: Long, posterPath: String?, releaseDate: String, originalTitle: String,
            originalLanguage: String, votesAverage: Double, votesCount: Long?, backdropPath: String?,
           adult: Boolean, overview: String, popularity: Double, video: String?) : this() {

        this.id = id
        this.posterPath = posterPath
        this.releaseDate = releaseDate
        this.originalTitle = originalTitle
        this.originalLanguage = originalLanguage
        this.votesAverage = votesAverage
        this.votesCount = votesCount
        this.backdropPath = backdropPath
        this.isAdult = adult
        this.overview = overview
        this.popularity = popularity
        this.video = video
    }

    @Ignore
    constructor(
            id: Long, posterPath: String?, releaseDate: String, originalTitle: String,
            originalLanguage: String, votesAverage: Double, votesCount: Long?, backdropPath: String?,
            collectionInfo: CollectionInfo?, productionCompanies: List<ProductionCompany>?,
            productionCountries: List<ProductionCountry>?, spokenLanguages: List<SpokenLanguage>?,
            alternativeTitles: AlternativeTitles?, imdbId: String?, adult: Boolean, overview: String,
            popularity: Double, video: String?, genres: List<Genre>?, budget: Long?,
            homepage: String?, revenue: Long?, runtime: Int?, status: String?, tagline: String?,
            keywords: Keywords?, translations: Translations?, trailers: Trailers?, reviews: MovieReviews?,
            similars: MovieSimilars?, recommendations: MovieRecommendations?, lists: MovieLists?, credits: MovieCredits?,
            images: MovieImages?) : this() {

        this.id = id
        this.posterPath = posterPath
        this.releaseDate = releaseDate
        this.originalTitle = originalTitle
        this.originalLanguage = originalLanguage
        this.votesAverage = votesAverage
        this.votesCount = votesCount
        this.backdropPath = backdropPath
        this.collectionInfo = collectionInfo
        this.productionCompanies = productionCompanies
        this.productionCountries = productionCountries
        this.spokenLanguages = spokenLanguages
        this.alternativeTitles = alternativeTitles
        this.imdbId = imdbId
        this.isAdult = adult
        this.overview = overview
        this.popularity = popularity
        this.video = video
        this.genres = genres
        this.budget = budget
        this.homepage = homepage
        this.revenue = revenue
        this.runtime = runtime
        this.status = status
        this.tagline = tagline
        this.keywords = keywords
        this.translations = translations
        this.trailers = trailers
        this.reviews = reviews
        this.similars = similars
        this.recommendations = recommendations
        this.lists = lists
        this.credits = credits
        this.images = images
    }



    companion object {

        @Transient
        @Ignore
        const val TABLE_NAME = "movies"

        @Transient
        @Ignore
        const val COLUMN_ID = "id"

        @Transient
        @Ignore
        const val COLUMN_POSTER_PATH = "poster_path"

        @Transient
        @Ignore
        const val COLUMN_RELEASE_DATE = "release_date"

        @Transient
        @Ignore
        const val COLUMN_ORIGINAL_TITLE = "original_title"

        @Transient
        @Ignore
        const val COLUMN_ORIGINAL_LANGUAGE = "original_language"

        @Transient
        @Ignore
        const val COLUMN_VOTES_AVERAGE = "vote_average"

        @Transient
        @Ignore
        const val COLUMN_VOTES_COUNT = "vote_count"

        @Transient
        @Ignore
        const val COLUMN_BACKDROP_PATH = "backdrop_path"

        @Transient
        @Ignore
        const val COLUMN_COLLECTION_INFO = "collection_info"

        @Transient
        @Ignore
        const val COLUMN_PRODUCTION_COMPANIES = "production_companies"

        @Transient
        @Ignore
        const val COLUMN_PRODUCTION_COUNTRIES = "production_countries"

        @Transient
        @Ignore
        const val COLUMN_SPOKEN_LANGUAGES = "spoken_languages"

        @Transient
        @Ignore
        const val COLUMN_ALTERNATIVE_TITLES = "alternative_titles"

        @Transient
        @Ignore
        const val COLUMN_IMDB_ID = "imdb_id"

        @Transient
        @Ignore
        const val COLUMN_IS_ADULT = "is_adult"

        @Transient
        @Ignore
        const val COLUMN_OVERVIEW = "overview"

        @Transient
        @Ignore
        const val COLUMN_POPULARITY = "popularity"

        @Transient
        @Ignore
        const val COLUMN_VIDEO = "video"

        @Transient
        @Ignore
        const val COLUMN_GENRES = "genres"

        @Transient
        @Ignore
        const val COLUMN_BUDGET = "budget"

        @Transient
        @Ignore
        const val COLUMN_HOMEPAGE = "homepage"

        @Transient
        @Ignore
        const val COLUMN_REVENUE = "revenue"

        @Transient
        @Ignore
        const val COLUMN_RUNTIME = "runtime"

        @Transient
        @Ignore
        const val COLUMN_STATUS = "status"

        @Transient
        @Ignore
        const val COLUMN_TAGLINE = "tagline"

        @Transient
        @Ignore
        const val COLUMN_KEYWORDS = "keywords"

        @Transient
        @Ignore
        const val COLUMN_TRANSLATIONS = "translations"

        @Transient
        @Ignore
        const val COLUMN_RELEASES = "releases"
    }

    override fun equals(other: Any?): Boolean {

        if (this === other)
            return true

        if (javaClass != other?.javaClass)
            return false

        other as MoviesEntity

        if (id != other.id)
            return false

        if (posterPath != other.posterPath)
            return false

        if (releaseDate != other.releaseDate)
            return false

        if (originalTitle != other.originalTitle)
            return false

        if (originalLanguage != other.originalLanguage)
            return false

        if (votesAverage != other.votesAverage)
            return false

        if (votesCount != other.votesCount)
            return false

        if (backdropPath != other.backdropPath)
            return false

        if (isAdult != other.isAdult)
            return false

        if (overview != other.overview)
            return false

        if (popularity != other.popularity)
            return false

        if (video != other.video)
            return false

        if (collectionInfo != other.collectionInfo)
            return false

        if (productionCompanies != other.productionCompanies)
            return false

        if (productionCountries != other.productionCountries)
            return false

        if (spokenLanguages != other.spokenLanguages)
            return false

        if (alternativeTitles != other.alternativeTitles)
            return false

        if (imdbId != other.imdbId)
            return false

        if (genres != other.genres)
            return false

        if (budget != other.budget)
            return false

        if (homepage != other.homepage)
            return false

        if (revenue != other.revenue)
            return false

        if (runtime != other.runtime)
            return false

        if (status != other.status)
            return false

        if (tagline != other.tagline)
            return false

        if (keywords != other.keywords)
            return false

        if (translations != other.translations)
            return false

        if (releases != other.releases)
            return false

        if (trailers != other.trailers)
            return false

        if (reviews != other.reviews)
            return false

        if (similars != other.similars)
            return false

        if (recommendations != other.recommendations)
            return false

        if (lists != other.lists)
            return false

        if (credits != other.credits)
            return false

        if (images != other.images)
            return false

        return true
    }

    override fun hashCode(): Int {

        var result = id.hashCode()

        result = 31 * result + (posterPath?.hashCode() ?: 0)

        result = 31 * result + releaseDate.hashCode()

        result = 31 * result + originalTitle.hashCode()

        result = 31 * result + originalLanguage.hashCode()

        result = 31 * result + votesAverage.hashCode()

        result = 31 * result + (votesCount?.hashCode() ?: 0)

        result = 31 * result + (backdropPath?.hashCode() ?: 0)

        result = 31 * result + isAdult.hashCode()

        result = 31 * result + overview.hashCode()

        result = 31 * result + popularity.hashCode()

        result = 31 * result + (video?.hashCode() ?: 0)

        result = 31 * result + (collectionInfo?.hashCode() ?: 0)

        result = 31 * result + (productionCompanies?.hashCode() ?: 0)

        result = 31 * result + (productionCountries?.hashCode() ?: 0)

        result = 31 * result + (spokenLanguages?.hashCode() ?: 0)

        result = 31 * result + (alternativeTitles?.hashCode() ?: 0)

        result = 31 * result + (imdbId?.hashCode() ?: 0)

        result = 31 * result + (genres?.hashCode() ?: 0)

        result = 31 * result + (budget?.hashCode() ?: 0)

        result = 31 * result + (homepage?.hashCode() ?: 0)

        result = 31 * result + (revenue?.hashCode() ?: 0)

        result = 31 * result + (runtime ?: 0)

        result = 31 * result + (status?.hashCode() ?: 0)

        result = 31 * result + (tagline?.hashCode() ?: 0)

        result = 31 * result + (keywords?.hashCode() ?: 0)

        result = 31 * result + (translations?.hashCode() ?: 0)

        result = 31 * result + (releases?.hashCode() ?: 0)

        result = 31 * result + (trailers?.hashCode() ?: 0)

        result = 31 * result + (reviews?.hashCode() ?: 0)

        result = 31 * result + (similars?.hashCode() ?: 0)

        result = 31 * result + (recommendations?.hashCode() ?: 0)

        result = 31 * result + (lists?.hashCode() ?: 0)

        result = 31 * result + (credits?.hashCode() ?: 0)

        result = 31 * result + (images?.hashCode() ?: 0)

        return result
    }
}