package endava.codebase.android.movieapp.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import endava.codebase.android.movieapp.R
import endava.codebase.android.movieapp.mock.MoviesMock
import endava.codebase.android.movieapp.model.MovieCategory
import endava.codebase.android.movieapp.ui.component.MovieCard
import endava.codebase.android.movieapp.ui.component.MovieCardViewState
import endava.codebase.android.movieapp.ui.component.MovieCategoryLabel
import endava.codebase.android.movieapp.ui.component.MovieCategoryLabelViewState
import endava.codebase.android.movieapp.ui.home.mapper.HomeScreenMapper
import endava.codebase.android.movieapp.ui.home.mapper.HomeScreenMapperImpl
import endava.codebase.android.movieapp.ui.theme.spacing

@Composable
fun HomeRoute(
    viewModel: HomeViewModel,
    onNavigateToMovieDetails: (HomeMovieViewState) -> Unit
) {
    val popularViewState: HomeMovieCategoryViewState by viewModel.popularMovies.collectAsState()
    val nowPlayingViewState: HomeMovieCategoryViewState by viewModel.nowPlayingMovies.collectAsState()
    val upcomingViewState: HomeMovieCategoryViewState by viewModel.upcomingMovies.collectAsState()

    HomeScreen(
        popularCategoryViewState = popularViewState,
        nowPlayingCategoryViewState = nowPlayingViewState,
        upcomingCategoryViewState = upcomingViewState,
        onNavigateToMovieDetails = onNavigateToMovieDetails,
        onCategoryClick = { categoryId -> viewModel.changeCategory(categoryId.itemId) },
        onFavoriteButtonClick = { movieId -> viewModel.toggleFavorite(movieId) }

    )
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    popularCategoryViewState: HomeMovieCategoryViewState,
    nowPlayingCategoryViewState: HomeMovieCategoryViewState,
    upcomingCategoryViewState: HomeMovieCategoryViewState,
    onCategoryClick: (MovieCategoryLabelViewState) -> Unit,
    onNavigateToMovieDetails: (HomeMovieViewState) -> Unit,
    onFavoriteButtonClick: (Int) -> Unit
) {
    Column(
        modifier = modifier
            .verticalScroll(state = rememberScrollState())
    ) {
        Spacer(
            modifier = Modifier
                .height(MaterialTheme.spacing.medium)
        )

        HomeScreenCategory(
            homeMovieCategoryViewState = popularCategoryViewState,
            categoryName = R.string.whats_popular,
            onCategoryClick = onCategoryClick,
            onNavigateToMovieDetails = onNavigateToMovieDetails,
            onFavoriteButtonClick = onFavoriteButtonClick
        )

        Spacer(
            modifier = Modifier
                .height(MaterialTheme.spacing.large)
        )

        HomeScreenCategory(
            homeMovieCategoryViewState = nowPlayingCategoryViewState,
            categoryName = R.string.now_playing,
            onCategoryClick = onCategoryClick,
            onNavigateToMovieDetails = onNavigateToMovieDetails,
            onFavoriteButtonClick = onFavoriteButtonClick
        )

        Spacer(
            modifier = Modifier
                .height(MaterialTheme.spacing.large)
        )

        HomeScreenCategory(
            homeMovieCategoryViewState = upcomingCategoryViewState,
            categoryName = R.string.upcoming,
            onCategoryClick = onCategoryClick,
            onNavigateToMovieDetails = onNavigateToMovieDetails,
            onFavoriteButtonClick = onFavoriteButtonClick
        )
    }
}

@Composable
fun HomeScreenCategory(
    modifier: Modifier = Modifier,
    homeMovieCategoryViewState: HomeMovieCategoryViewState,
    categoryName: Int,
    onCategoryClick: (MovieCategoryLabelViewState) -> Unit,
    onNavigateToMovieDetails: (HomeMovieViewState) -> Unit,
    onFavoriteButtonClick: (Int) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = MaterialTheme.spacing.medium, end = MaterialTheme.spacing.medium)
    ) {
        Text(
            text = stringResource(id = categoryName),
            maxLines = 1,
            modifier = Modifier
                .fillMaxWidth(),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier
                .height(MaterialTheme.spacing.medium)
        )

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.medium),
            userScrollEnabled = true
        ) {
            items(
                items = homeMovieCategoryViewState.movieCategories,
                key = { category -> category.itemId }
            ) { category ->
                MovieCategoryLabel(
                    item = MovieCategoryLabelViewState(
                        itemId = category.itemId,
                        isSelected = category.isSelected,
                        categoryText = category.categoryText
                    ),
                    onClick = { onCategoryClick(category) })
            }
        }

        Spacer(
            modifier = Modifier
                .height(MaterialTheme.spacing.medium)
        )

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.small),
            userScrollEnabled = true
        ) {
            items(
                items = homeMovieCategoryViewState.movies,
                key = { movie -> movie.movieId }
            ) { movie ->
                MovieCard(
                    movieCardViewState = MovieCardViewState(
                        id = movie.movieId,
                        imageUrl = movie.imageUrl,
                        isFavorite = movie.isFavorite,
                        title = movie.title
                    ),
                    onClick = { onNavigateToMovieDetails(movie) },
                    onFavoriteButtonClicked = { onFavoriteButtonClick(movie.movieId) }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    val homeScreenMapper: HomeScreenMapper = HomeScreenMapperImpl()

    val popularCategoryViewState = homeScreenMapper.toHomeMovieCategoryViewState(
        movieCategories = listOf(
            MovieCategory.POPULAR_STREAMING,
            MovieCategory.POPULAR_ON_TV,
            MovieCategory.POPULAR_FOR_RENT,
            MovieCategory.POPULAR_IN_THEATRES
        ),
        selectedMovieCategory = MovieCategory.POPULAR_STREAMING,
        movies = MoviesMock.getMoviesList()
    )

    val nowPlayingCategoryViewState = homeScreenMapper.toHomeMovieCategoryViewState(
        movieCategories = listOf(
            MovieCategory.NOW_PLAYING_MOVIES,
            MovieCategory.NOW_PLAYING_TV
        ),
        selectedMovieCategory = MovieCategory.NOW_PLAYING_MOVIES,
        movies = MoviesMock.getMoviesList()
    )

    val upcomingCategoryViewState = homeScreenMapper.toHomeMovieCategoryViewState(
        movieCategories = listOf(
            MovieCategory.UPCOMING_TODAY,
            MovieCategory.UPCOMING_THIS_WEEK
        ),
        selectedMovieCategory = MovieCategory.UPCOMING_TODAY,
        movies = MoviesMock.getMoviesList()
    )

    val popularViewState by remember { mutableStateOf(popularCategoryViewState) }
    val nowPlayingViewState by remember { mutableStateOf(nowPlayingCategoryViewState) }
    val upcomingViewState by remember { mutableStateOf(upcomingCategoryViewState) }

    HomeScreen(
        popularCategoryViewState = popularViewState,
        nowPlayingCategoryViewState = nowPlayingViewState,
        upcomingCategoryViewState = upcomingViewState,
        onCategoryClick = { },
        onNavigateToMovieDetails = { },
        onFavoriteButtonClick = { }
    )
}
