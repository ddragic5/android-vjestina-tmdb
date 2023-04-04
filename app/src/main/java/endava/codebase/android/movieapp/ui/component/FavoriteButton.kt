package endava.codebase.android.movieapp.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import endava.codebase.android.movieapp.R
import endava.codebase.android.movieapp.ui.theme.*


@Composable
fun FavoriteButton(
    modifier: Modifier = Modifier
        .size(30.dp)
        .padding(MaterialTheme.spacing.small),

    isFavorite: Boolean,
    onFavoriteClick: () -> Unit,
) {

    Icon(painter = painterResource(id = if (isFavorite) R.drawable.ic_favorite else R.drawable.ic_not_favorite),
        contentDescription = null,
        modifier = modifier
            .clickable { onFavoriteClick() }
            .background(Blue.copy(0.6f), CircleShape)


    )
}

@Preview
@Composable
public fun FavoriteButtonPreview() {


    var isFavorite by remember { mutableStateOf(true) }
    FavoriteButton(
        isFavorite = isFavorite,
        onFavoriteClick = { isFavorite = !isFavorite }
    )
}
