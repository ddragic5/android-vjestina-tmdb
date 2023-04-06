package endava.codebase.android.movieapp.ui.favorites.mapper

import endava.codebase.android.movieapp.model.Movie
import endava.codebase.android.movieapp.ui.component.MovieCardViewState
import endava.codebase.android.movieapp.ui.favorites.FavoritesMovieViewState
import endava.codebase.android.movieapp.ui.favorites.FavoritesViewState

class FavoritesMapperImpl : FavoritesMapper {
    override fun toFavoritesViewState(favoriteMovies: List<Movie>): FavoritesViewState {

        val favoriteMoviesViewStates = favoriteMovies.map {
            mapMovie(it)
        }

        return FavoritesViewState(favoriteMoviesViewStates)
    }

    private fun mapMovie(movie: Movie) = FavoritesMovieViewState(
        id = movie.id,
        movieCardViewState = MovieCardViewState(
            imageUrl = movie.imageUrl,
            isFavorite = movie.isFavorite,
            title = movie.title
        )
    )
}
