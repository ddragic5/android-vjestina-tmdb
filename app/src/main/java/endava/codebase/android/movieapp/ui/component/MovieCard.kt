package endava.codebase.android.movieapp.ui.component


import endava.codebase.android.movieapp.mock.MoviesMock
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import endava.codebase.android.movieapp.ui.theme.Shapes


data class MovieCardViewState(
    val imageUrl: String?,
    val isFavorite: Boolean,
    val title: String,
    val id: Int,
)

@Composable
fun MovieCard(
    modifier: Modifier = Modifier,
    movieCardViewState: MovieCardViewState,
    onFavoriteButtonClicked: () -> Unit,

    ) {


    Card(
        modifier = modifier,
        shape = Shapes.medium,
        elevation = 5.dp
    ) {
        Box {
            AsyncImage(
                model = movieCardViewState.imageUrl,
                contentDescription = movieCardViewState.title,
                contentScale = ContentScale.Crop
            )
            FavoriteButton(
                modifier = Modifier
                    .padding(5.dp),
                isFavorite = movieCardViewState.isFavorite,
                onFavoriteClick = onFavoriteButtonClicked
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MovieCardPreview() {

    var onFavoriteButtonClicked by remember { mutableStateOf(true) }
    val movie = MoviesMock.getMoviesList()[1]
    val movieCardViewState = MovieCardViewState(
        imageUrl = movie.imageUrl,
        isFavorite = onFavoriteButtonClicked,
        title = movie.title,
        id = movie.id,
    )
    val movieCardModifier = Modifier

        .width(150.dp)
        .height(260.dp)


    MovieCard(
        modifier = movieCardModifier,
        movieCardViewState = movieCardViewState,
        onFavoriteButtonClicked = { onFavoriteButtonClicked = !onFavoriteButtonClicked })
}
