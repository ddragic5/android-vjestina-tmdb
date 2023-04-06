package endava.codebase.android.movieapp.ui.home.mapper

import endava.codebase.android.movieapp.model.Movie
import endava.codebase.android.movieapp.model.MovieCategory
import endava.codebase.android.movieapp.ui.component.MovieCategoryLabelTextViewState
import endava.codebase.android.movieapp.ui.component.MovieCategoryLabelViewState
import endava.codebase.android.movieapp.ui.home.HomeMovieCategoryViewState
import endava.codebase.android.movieapp.ui.home.HomeMovieViewState
import endava.codebase.android.movieapp.R




class HomeScreenMapperImpl : HomeScreenMapper {
    override fun toHomeMovieCategoryViewState(
        movieCategories: List<MovieCategory>,
        selectedMovieCategory: MovieCategory,
        movies: List<Movie>
    ): HomeMovieCategoryViewState {

        val movieCategoryLabelStates = movieCategories.map {
            MovieCategoryLabelViewState(
                itemId = it.ordinal,
                isSelected = it == selectedMovieCategory,
                categoryText = MovieCategoryLabelTextViewState.ResourceText(
                    getResourceTextIdFromMovieCategory(it)
                )
            )
        }
        val homeMovieViewStates = movies.map {
            HomeMovieViewState(
                movieId = it.id,
                title = it.title,
                imageUrl = it.imageUrl,
                isFavorite = it.isFavorite
            )
        }

        return HomeMovieCategoryViewState(
            movieCategories = movieCategoryLabelStates,
            movies = homeMovieViewStates
        )
    }
}
fun getResourceTextIdFromMovieCategory(movieCategory: MovieCategory): Int {
    return when (movieCategory) {
        MovieCategory.POPULAR_STREAMING -> R.string.popular
        MovieCategory.POPULAR_ON_TV -> R.string.popular_tv
        MovieCategory.POPULAR_FOR_RENT -> R.string.rent
        MovieCategory.POPULAR_IN_THEATRES -> R.string.theatres
        MovieCategory.NOW_PLAYING_MOVIES -> R.string.playing_movies
        MovieCategory.NOW_PLAYING_TV -> R.string.playing_tv
        MovieCategory.UPCOMING_TODAY -> R.string.upcoming_today
        MovieCategory.UPCOMING_THIS_WEEK -> R.string.upcoming_week
    }
}
