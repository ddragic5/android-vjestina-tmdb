package endava.codebase.android.movieapp.ui.component


import endava.codebase.android.movieapp.R
import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


sealed class MovieCategoryLabelTextViewState {
    data class Text(val text: String) : MovieCategoryLabelTextViewState()
    data class TextRes(@StringRes val textRes: Int) : MovieCategoryLabelTextViewState()
}

data class MovieCategoryLabelViewState(
    val itemId: Int,
    val isSelected: Boolean,
    val categoryText: MovieCategoryLabelTextViewState
)

@Composable
fun MovieCategoryLabel(
    movieCategoryLabelViewState: MovieCategoryLabelViewState,
    onItemClick: (MovieCategoryLabelViewState) -> Unit,
    modifier: Modifier = Modifier
) {


    Column(modifier = modifier.width(IntrinsicSize.Min).clickable { onItemClick(movieCategoryLabelViewState) })

    {
        Text(
            text = when (movieCategoryLabelViewState.categoryText) {
                is MovieCategoryLabelTextViewState.Text -> movieCategoryLabelViewState.categoryText.text
                is MovieCategoryLabelTextViewState.TextRes -> stringResource(id = movieCategoryLabelViewState.categoryText.textRes)
            },
            fontWeight = if (movieCategoryLabelViewState.isSelected) FontWeight.ExtraBold else FontWeight.Normal,
            color = endava.codebase.android.movieapp.ui.theme.Gray300,
            fontSize = 12.sp
        )

        if (movieCategoryLabelViewState.isSelected) {
            Divider(
                color = endava.codebase.android.movieapp.ui.theme.Blue,
                thickness = 3.dp,
                modifier = modifier.padding(top = 3.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MovieCategoryLabelPreview() {
    var isSelected by remember { mutableStateOf(false) }

    MovieCategoryLabel(
        movieCategoryLabelViewState = MovieCategoryLabelViewState(
            itemId = 0,
            isSelected = isSelected,
            categoryText = MovieCategoryLabelTextViewState.Text(text = "TMDB")
        ),
        onItemClick = { isSelected = true }
    )
}