package endava.codebase.android.movieapp.ui.movie_details.mapper

import endava.codebase.android.movieapp.model.MovieDetails
import endava.codebase.android.movieapp.ui.movie_details.MovieDetailsViewState

interface MovieDetailsMapper {
    fun toMovieDetailsViewState(movieDetails: MovieDetails): MovieDetailsViewState
}
