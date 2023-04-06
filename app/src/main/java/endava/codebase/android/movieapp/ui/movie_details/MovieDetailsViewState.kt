package endava.codebase.android.movieapp.ui.movie_details

import endava.codebase.android.movieapp.ui.component.ActorCardViewState
import endava.codebase.android.movieapp.ui.component.CrewItemViewState

data class MovieDetailsViewState(
    val id: Int,
    val imageUrl: String?,
    val voteAverage: Float,
    val title: String,
    val overview: String,
    val isFavorite: Boolean,
    val crew: List<CrewItemViewState>,
    val cast: List<ActorCardViewState>,
)

data class ActorViewState(val actorCardViewState: ActorCardViewState)

data class CrewmanViewState(val crewItemViewState: CrewItemViewState)