package endava.codebase.android.movieapp.ui.favorites

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import endava.codebase.android.movieapp.R
import endava.codebase.android.movieapp.mock.MoviesMock.getMoviesList
import endava.codebase.android.movieapp.ui.component.MovieCard
import endava.codebase.android.movieapp.ui.component.MovieCardViewState
import endava.codebase.android.movieapp.ui.favorites.mapper.FavoritesMapperImpl
import endava.codebase.android.movieapp.ui.theme.spacing

@Composable
fun FavoritesRoute(
    viewModel: FavoritesViewModel,
    onNavigateToMovieDetails: (MovieCardViewState) -> Unit
) {
    val favoritesViewState: FavoritesViewState by viewModel.favoritesViewState.collectAsState()

    FavoritesScreen(
        favoritesViewState = favoritesViewState,
        onNavigateToMovieDetails = onNavigateToMovieDetails,
        onFavoriteButtonClick = { movieId -> viewModel.toggleFavorite(movieId) },
        modifier = Modifier.fillMaxSize()
    )
}

@Composable
fun FavoritesScreen(
    modifier: Modifier = Modifier,
    favoritesViewState: FavoritesViewState,
    onNavigateToMovieDetails: (MovieCardViewState) -> Unit,
    onFavoriteButtonClick: (Int) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(horizontal = MaterialTheme.spacing.medium),
        horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.small),
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.medium),
        modifier = modifier
    ) {
        item(
            span = { GridItemSpan(maxLineSpan) }
        ) {
            Text(
                text = stringResource(R.string.favorites),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = MaterialTheme.spacing.medium
                    ),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        items(
            items = favoritesViewState.favoriteMovies,
            key = { movie -> movie.id }
        ) { movie ->
            MovieCard(
                movieCardViewState = MovieCardViewState(
                    id = movie.id,
                    imageUrl = movie.imageUrl,
                    isFavorite = movie.isFavorite,
                    title = movie.title
                ),
                onClick = { onNavigateToMovieDetails(movie) },
                onFavoriteButtonClicked = { onFavoriteButtonClick(movie.id) },
                modifier = Modifier.height(154.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FavouritesScreenPreview() {
    val favoritesMapper = FavoritesMapperImpl()

    FavoritesScreen(
        favoritesViewState = favoritesMapper.toFavoritesViewState(getMoviesList()),
        onNavigateToMovieDetails = { },
        onFavoriteButtonClick = { }
    )
}
