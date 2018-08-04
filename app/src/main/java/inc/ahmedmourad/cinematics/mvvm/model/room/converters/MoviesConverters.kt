package inc.ahmedmourad.cinematics.mvvm.model.room.converters

import android.arch.persistence.room.TypeConverter
import inc.ahmedmourad.cinematics.mvvm.model.objects.*

class MoviesConverters {

    companion object {

        @JvmStatic
        @TypeConverter
        fun collectionInfoToString(c: CollectionInfo?) =
                if (c == null)
                    null
                else
                    "${c.id}||||${c.name}||||${c.posterPath}||||${c.backdropPath}"

        @JvmStatic
        @TypeConverter
        fun stringToCollectionInfo(str: String?): CollectionInfo? {

            if (str == null)
                return null

            val info = str.split("||||")

            return CollectionInfo(info[0].toInt(), info[1], info[2], info[3])
        }

        @JvmStatic
        @TypeConverter
        fun genresListToString(genres: List<Genre>?): String? {

            if (genres == null)
                return null

            var str = ""

            genres.forEach { str += "${it.id},,,,${it.name}||||" }

            str.dropLast(4)

            return str
        }

        @JvmStatic
        @TypeConverter
        fun stringToGenresList(str: String?): List<Genre>? {

            if (str == null)
                return null

            val genresAsStr = str.split("||||")

            val genres = ArrayList<Genre>()

            genresAsStr.forEach {

                val info = it.split(",,,,")

                genres += Genre(info[0].toInt(), info[1])
            }

            return genres
        }

        @JvmStatic
        @TypeConverter
        fun productionCompaniesListToString(companies: List<ProductionCompany>?): String? {

            if (companies == null)
                return null

            var str = ""

            companies.forEach { str += "${it.id},,,,${it.name}||||" }

            str.dropLast(4)

            return str
        }

        @JvmStatic
        @TypeConverter
        fun stringToProductionCompaniesList(str: String?): List<ProductionCompany>? {

            if (str == null)
                return null

            val companiesAsStr = str.split("||||")

            val companies = ArrayList<ProductionCompany>()

            companiesAsStr.forEach {

                val info = it.split(",,,,")

                companies += ProductionCompany(info[0].toInt(), info[1])
            }

            return companies
        }

        @JvmStatic
        @TypeConverter
        fun productionCountriesListToString(countries: List<ProductionCountry>?): String? {

            if (countries == null)
                return null

            var str = ""

            countries.forEach { str += "${it.shortcut},,,,${it.name}||||" }

            str.dropLast(4)

            return str
        }

        @JvmStatic
        @TypeConverter
        fun stringToProductionCountriesList(str: String?): List<ProductionCountry>? {

            if (str == null)
                return null

            val countriesAsStr = str.split("||||")

            val countries = ArrayList<ProductionCountry>()

            countriesAsStr.forEach {

                val info = it.split(",,,,")

                countries += ProductionCountry(info[0], info[1])
            }

            return countries
        }

        @JvmStatic
        @TypeConverter
        fun spokenLanguagesListToString(languages: List<SpokenLanguage>?): String? {

            if (languages == null)
                return null

            var str = ""

            languages.forEach { str += "${it.shortcut},,,,${it.name}||||" }

            str.dropLast(4)

            return str
        }

        @JvmStatic
        @TypeConverter
        fun stringToSpokenLanguagesList(str: String?): List<SpokenLanguage>? {

            if (str == null)
                return null

            val languagesAsStr = str.split("||||")

            val languages = ArrayList<SpokenLanguage>()

            languagesAsStr.forEach {

                val info = it.split(",,,,")

                languages += SpokenLanguage(info[0], info[1])
            }

            return languages
        }

        @JvmStatic
        @TypeConverter
        fun alternativeTitlesToString(alternativeTitles: AlternativeTitles?): String? {

            if (alternativeTitles == null)
                return null

            var str = ""

            alternativeTitles.titles.forEach { str += "${it.shortcut},,,,${it.title}||||" }

            str.dropLast(4)

            return str
        }

        @JvmStatic
        @TypeConverter
        fun stringToAlternativeTitles(str: String?): AlternativeTitles? {

            if (str == null)
                return null

            val alternativeTitlesAsStr = str.split("||||")

            val alternativeTitles = ArrayList<Title>()

            alternativeTitlesAsStr.forEach {

                val info = it.split(",,,,")

                alternativeTitles += Title(info[0], info[1])
            }

            return AlternativeTitles(alternativeTitles)
        }

        @JvmStatic
        @TypeConverter
        fun keywordsToString(keywords: Keywords?): String? {

            if (keywords == null)
                return null

            var str = ""

            keywords.keywords.forEach { str += "${it.id},,,,${it.name}||||" }

            str.dropLast(4)

            return str
        }

        @JvmStatic
        @TypeConverter
        fun stringToKeywords(str: String?): Keywords? {

            if (str == null)
                return null

            val keywordsAsStr = str.split("||||")

            val keywords = ArrayList<Keyword>()

            keywordsAsStr.forEach {

                val info = it.split(",,,,")

                keywords += Keyword(info[0].toInt(), info[1])
            }

            return Keywords(keywords)
        }

        @JvmStatic
        @TypeConverter
        fun translationsToString(translations: Translations?): String? {

            if (translations == null)
                return null

            var str = ""

            translations.translations.forEach { str += "${it.languageShortcut},,,,${it.countryShortcut},,,,${it.name},,,,${it.englishName}||||" }

            str.dropLast(4)

            return str
        }

        @JvmStatic
        @TypeConverter
        fun stringToTranslations(str: String?): Translations? {

            if (str == null)
                return null

            val translationsAsStr = str.split("||||")

            val translations = ArrayList<Translation>()

            translationsAsStr.forEach {

                val info = it.split(",,,,")

                translations += Translation(info[0], info[1], info[2], info[3])
            }

            return Translations(translations)
        }

        @JvmStatic
        @TypeConverter
        fun releasesToString(releases: Releases?): String? {

            if (releases == null)
                return null

            var str = ""

            releases.countries.forEach { str += "${it.releaseDate},,,,${it.shortcut},,,,${it.isPrimary},,,,${it.certification}||||" }

            str.dropLast(4)

            return str
        }

        @JvmStatic
        @TypeConverter
        fun stringToReleases(str: String?): Releases? {

            if (str == null)
                return null

            val releasesAsStr = str.split("||||")

            val countries = ArrayList<Country>()

            releasesAsStr.forEach {

                val info = it.split(",,,,")

                countries += Country(info[0], info[1], info[2].toBoolean(), info[3])
            }

            return Releases(countries)
        }
    }
}