package endava.codebase.android.movieapp.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import endava.codebase.android.movieapp.mock.MoviesMock

data class CrewItemViewState(
    val id: Int,
    val name: String,
    val job: String,
)

@Composable
fun CrewItem(
    crewItemViewState: CrewItemViewState,
    modifier: Modifier,
) {
    Column(modifier = Modifier) {
        Text(
            text = crewItemViewState.name,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
        )
        Text(
            text = crewItemViewState.job,
            fontSize = 14.sp,
        )

    }
}

@Preview(showBackground = true)
@Composable
public fun CrewItemPreview() {
    val crewman = MoviesMock.getCrewman()
    val crewItemViewState = CrewItemViewState(id = crewman.id, name = crewman.name, job = crewman.job)
    CrewItem(crewItemViewState = crewItemViewState, modifier = Modifier)
}
