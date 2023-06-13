package endava.codebase.android.movieapp.data

import endava.codebase.android.movieapp.ui.movie_details.MovieDetailsViewModel
import endava.codebase.android.movieapp.ui.movie_details.mapper.MovieDetailsMapper
import endava.codebase.android.movieapp.ui.movie_details.mapper.MovieDetailsMapperImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val movieDetailsModule = module {
    viewModel { (movieId: Int) ->
        MovieDetailsViewModel(
            movieRepository = get(),
            movieDetailsMapper = get(),
            movieId = movieId
        )
    }
    single<MovieDetailsMapper> { MovieDetailsMapperImpl() }
}
