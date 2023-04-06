package endava.codebase.android.movieapp.model

import androidx.annotation.StringRes
import endava.codebase.android.movieapp.R

enum class MovieCategory {
    POPULAR_STREAMING,
    POPULAR_ON_TV,
    POPULAR_FOR_RENT,
    POPULAR_IN_THEATRES,
    NOW_PLAYING_MOVIES,
    NOW_PLAYING_TV,
    UPCOMING_TODAY,
    UPCOMING_THIS_WEEK;

    companion object {
        private val VALUES = values()
        fun getByOrdinal(ordinal: Int) = VALUES.firstOrNull { it.ordinal == ordinal }
    }
}
