package endava.codebase.android.movieapp.ui.favorites

import androidx.compose.foundation.layout.*
import endava.codebase.android.movieapp.R
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import endava.codebase.android.movieapp.mock.MoviesMock
import endava.codebase.android.movieapp.mock.MoviesMock.getMoviesList
import endava.codebase.android.movieapp.ui.component.MovieCard
import endava.codebase.android.movieapp.ui.component.MovieCardViewState
import endava.codebase.android.movieapp.ui.favorites.mapper.FavoritesMapper
import endava.codebase.android.movieapp.ui.favorites.mapper.FavoritesMapperImpl
import endava.codebase.android.movieapp.ui.theme.MovieAppTheme
import endava.codebase.android.movieapp.ui.theme.spacing

private val favoritesMapper: FavoritesMapper = FavoritesMapperImpl()

val favoritesViewState = favoritesMapper.toFavoritesViewState(MoviesMock.getMoviesList())

@Composable
fun FavoritesRoute(
    onNavigateToMovieDetails: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val favoritesViewState by remember { mutableStateOf(favoritesViewState) }
    FavoritesScreen(
        modifier = modifier
            .fillMaxSize()
            .padding(MaterialTheme.spacing.medium),
        favoritesViewState = favoritesViewState,
        onCardClick = onNavigateToMovieDetails,
        onFavoriteButtonClick = { }
    )
}

@Composable
fun FavoritesScreen(
    modifier: Modifier,
    favoritesViewState: FavoritesViewState,
    onCardClick: (Int) -> Unit,
    onFavoriteButtonClick: () -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.large_spacing)),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.medium_spacing)),
        content = {
            header {
                Text(
                    modifier = Modifier.padding(start = MaterialTheme.spacing.medium),
                    text = "Favorites",
                    fontWeight = FontWeight.Bold
                )
            }
            items(
                items = favoritesViewState.favoriteMoviesViewStates,
                key = { movie -> movie.id }) { card ->
                MovieCard(
                    modifier = Modifier
                        .width(dimensionResource(id = R.dimen.movie_card_favorites_width))
                        .height(dimensionResource(id = R.dimen.movie_card_favorites_height)),
                    movieCardViewState = card.movieCardViewState,
                    onClick = { onCardClick(card.id) },
                    onFavoriteButtonClicked = { onFavoriteButtonClick() }
                )
            }
        },
        modifier = modifier
    )
}

fun LazyGridScope.header(
    content: @Composable LazyGridItemScope.() -> Unit
) {
    item(
        span = { GridItemSpan(this.maxLineSpan) },
        content = content
    )
}

@Preview
@Composable
fun FavoritesScreenPreview() {
    val favoritesScreenModifier = Modifier
        .fillMaxSize()
        .padding(15.dp)
    MovieAppTheme {
        FavoritesScreen(
            modifier = favoritesScreenModifier,
            favoritesViewState = favoritesViewState,
            onCardClick = { },
            onFavoriteButtonClick = { }
        )
    }
}
