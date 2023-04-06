package endava.codebase.android.movieapp.ui.component


import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import endava.codebase.android.movieapp.R
import endava.codebase.android.movieapp.mock.MoviesMock.getMovieDetails
import endava.codebase.android.movieapp.ui.theme.Green

@Composable
fun ProgressBar(
    modifier: Modifier,
    score: Float
) {
    Box(modifier = modifier.wrapContentSize()) {
        Canvas(modifier = modifier
            .size(60.dp)
            .padding(5.dp))
        {
            drawArc(
                color = Color(100, 300, 100),
                alpha = 0.2f,
                startAngle = 0f,
                sweepAngle = 360f,
                useCenter = false,
                style = Stroke(width = 5.dp.toPx())
            )
            drawArc(
                color = Color(61, 235, 75),
                startAngle = 270f,
                sweepAngle = score * 360f,
                useCenter = false,
                style = Stroke(width = 5.dp.toPx())
            )
        }
        Text(
            text = (score * 100).toString(),
            fontSize = 15.sp,
            color = Color.Black,
            modifier = modifier.align(Alignment.Center)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewUserScoreProgressBar() {
    val score: Float = getMovieDetails().voteAverage
    ProgressBar(score = score, modifier = Modifier)
}
