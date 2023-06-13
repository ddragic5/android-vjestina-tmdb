package endava.codebase.android.movieapp.ui.movie_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import endava.codebase.android.movieapp.data.repository.MovieRepository
import endava.codebase.android.movieapp.ui.movie_details.mapper.MovieDetailsMapper
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MovieDetailsViewModel(
    private val movieRepository: MovieRepository,
    movieDetailsMapper: MovieDetailsMapper,
    movieId: Int,
) : ViewModel() {

    val movieDetailsViewState: StateFlow<MovieDetailsViewState> =
        movieRepository
            .movieDetails(movieId)
            .map { movies -> movieDetailsMapper.toMovieDetailsViewState(movies) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = MovieDetailsViewState(
                    id = 1,
                    imageUrl = "",
                    voteAverage = 0F,
                    title = "",
                    overview = "",
                    isFavorite = false,
                    crew = emptyList(),
                    cast = emptyList()
                )
            )

    fun toggleFavorite(movieId: Int) {
        viewModelScope.launch {
            movieRepository.toggleFavorite(movieId)
        }
    }
}
