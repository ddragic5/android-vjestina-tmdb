package endava.codebase.android.movieapp.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import endava.codebase.android.movieapp.R
import endava.codebase.android.movieapp.ui.theme.Blue


@Composable
fun FavoriteButton(
    modifier: Modifier = Modifier,
    isFavorite: Boolean,
    onClick: () -> Unit,
) {
    Image(painter = painterResource(id = if (isFavorite) R.drawable.ic_favorite else R.drawable.ic_not_favorite),
        contentDescription = null,
        modifier = modifier
            .clickable { onClick() }
            .background(Blue.copy(0.6f), CircleShape)
            .size(30.dp)
            .padding(5.dp)

    )
}

@Preview
@Composable
public fun FavoriteButtonPreview() {


    var isFavorite by remember { mutableStateOf(true) }
    FavoriteButton(
        isFavorite = isFavorite,
        onClick = { isFavorite = !isFavorite }
    )
}
