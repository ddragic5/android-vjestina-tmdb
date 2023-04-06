package endava.codebase.android.movieapp.ui.component


import androidx.compose.foundation.clickable
import endava.codebase.android.movieapp.mock.MoviesMock
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
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
    val title: String
)

@Composable
fun MovieCard(
    modifier: Modifier,
    movieCardViewState: MovieCardViewState,
    onFavoriteButtonClicked: () -> Unit,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier
            .padding(15.dp)
            .width(110.dp)
            .height(200.dp)
            .clickable { },
        shape = RoundedCornerShape(20.dp),
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
                    .padding(1.dp)
                    .size(30.dp),
                isFavorite = movieCardViewState.isFavorite,
                onFavoriteClick = { }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MovieCardPreview() {
    val movie = MoviesMock.getMoviesList()[4]
    val movieCardViewState = MovieCardViewState(
        imageUrl = movie.imageUrl,
        isFavorite = movie.isFavorite,
        title = movie.title
    )
    val movieCardModifier = Modifier
        .padding(5.dp)
        .width(140.dp)
        .height(200.dp)

    MovieCard(
        modifier = movieCardModifier,
        movieCardViewState = movieCardViewState,
        onClick = { },
        onFavoriteButtonClicked = { })
}
