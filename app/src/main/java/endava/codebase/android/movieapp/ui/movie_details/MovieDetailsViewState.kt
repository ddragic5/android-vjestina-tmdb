package endava.codebase.android.movieapp.ui.movie_details

import endava.codebase.android.movieapp.ui.component.ActorCardViewState

data class CrewmanViewState(
    val id: Int,
    val name: String,
    val job: String
)

data class MovieDetailsViewState(
    val id: Int,
    val imageUrl: String?,
    val voteAverage: Float,
    val title: String,
    val overview: String,
    val isFavorite: Boolean,
    val crew: List<CrewmanViewState>,
    val cast: List<ActorCardViewState>,
)
