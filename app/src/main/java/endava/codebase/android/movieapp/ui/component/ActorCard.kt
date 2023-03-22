package endava.codebase.android.movieapp.ui.component


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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


data class ActorCardViewState (
    val imageUrl: String?, val name: String,
       val character: String,
    )

@Composable
fun ActorCard(
    actorCardViewState: ActorCardViewState,
    modifier: Modifier = Modifier,

    ){
    Card(modifier = modifier,
        shape= RoundedCornerShape(20.dp),
        elevation = 5.dp) {
        Column {
            AsyncImage(model = actorCardViewState.imageUrl, contentDescription = actorCardViewState.name,
            modifier = Modifier.weight(0.5F),
            contentScale = ContentScale.Crop)

            Column() {
                Text(text = actorCardViewState.name, modifier = Modifier.padding(start = 15.dp, end = 45.dp, top =6.dp),
                    fontSize = 15.sp,
                    color = androidx.compose.ui.graphics.Color.Black)
                Text(text = actorCardViewState.character, modifier = Modifier.padding(start = 15.dp, end = 45.dp, top = 6.dp),
                fontSize = 10.sp,
                color = Color.Gray)
            }


        }
    }
}

@Preview
@Composable
public fun ActorCardPreview() {

    val actorCardViewState = ActorCardViewState(name ="Robert Downey Jr." , imageUrl = "https://media1.popsugar-assets.com/files/thumbor/HwtAUAufmAZv-FgGEIMJS2eQM-A/0x1:2771x2772/fit-in/2048xorig/filters:format_auto-!!-:strip_icc-!!-/2020/03/30/878/n/1922398/eb11f12e5e825104ca01c1.02079643_/i/Robert-Downey-Jr.jpg", character = "Tony Stark/Iron Man")  //For testing purposes

        val actorCardModifier = Modifier
            .height(250.dp)
            .width(150.dp)



    ActorCard(actorCardViewState = actorCardViewState, modifier = actorCardModifier)
}