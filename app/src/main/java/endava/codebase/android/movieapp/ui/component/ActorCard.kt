package endava.codebase.android.movieapp.ui.component


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import endava.codebase.android.movieapp.mock.MoviesMock
import endava.codebase.android.movieapp.ui.theme.Shapes


data class ActorCardViewState(
    val imageUrl: String?, val name: String,
    val character: String, val id: Int?
)

@Composable
fun ActorCard(
    actorCardViewState: ActorCardViewState,
    modifier: Modifier = Modifier,

    ) {
    Card(
        modifier = modifier,
        shape = Shapes.medium,
        elevation = 5.dp
    ) {
        Column {
            AsyncImage(
                model = actorCardViewState.imageUrl,
                contentDescription = actorCardViewState.name,
                modifier = Modifier.weight(1F),
                contentScale = ContentScale.Crop
            )


            Text(
                text = actorCardViewState.name,
                modifier = Modifier.padding(start = 15.dp, end = 45.dp, top = 6.dp),
                fontSize = 15.sp,
                color = androidx.compose.ui.graphics.Color.Black
            )
            Text(
                text = actorCardViewState.character,
                modifier = Modifier.padding(start = 15.dp, end = 45.dp, top = 6.dp),
                fontSize = 10.sp,
                color = Color.Gray
            )

        }
    }
}

@Preview
@Composable
public fun ActorCardPreview() {
    val actor = MoviesMock.getActor()
    val actorCardViewState = ActorCardViewState(
        name = actor.name, imageUrl = actor.imageUrl, character = actor.character, id = actor.id
    )  //For testing purposes

    val actorCardModifier = Modifier
        .height(250.dp)
        .width(150.dp)

    ActorCard(actorCardViewState = actorCardViewState, modifier = actorCardModifier)
}
