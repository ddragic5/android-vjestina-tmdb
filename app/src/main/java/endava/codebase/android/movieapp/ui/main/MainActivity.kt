package endava.codebase.android.movieapp.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import endava.codebase.android.movieapp.ui.component.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContent {
            Column(

                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceAround,

            ) {MovieCategoryLabelPreview()
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly) {

                    ActorCardPreview()
                    MovieCardPreview()
                }
Row(
    Modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.SpaceEvenly,) {
    CrewItemPreview()
    FavoriteButtonPreview()
    ProgressBarPreview()
}



            }
        }
    }
}




