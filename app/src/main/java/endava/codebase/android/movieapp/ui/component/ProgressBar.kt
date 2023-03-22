package endava.codebase.android.movieapp.ui.component


import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private const val DEGREES = 360f
private const val SWEEP_START = 90f

@Composable
fun ProgressBar(movieProgress: Float, modifier: Modifier) {
    Box(modifier = modifier.wrapContentSize()) {
        Canvas(
            modifier = modifier
                .size(60.dp)
                .padding(5.dp)
        ) {
            drawArc(
                color = Color(100, 340, 100),
                alpha = 0.2f,
                startAngle = (movieProgress* DEGREES) - SWEEP_START,
                sweepAngle = (1-movieProgress) * DEGREES,
                useCenter = false,
                style = Stroke(width = 6.dp.toPx())
            )
            drawArc(
                color = Color(50, 220, 70),
                startAngle = -SWEEP_START,
                sweepAngle = movieProgress * DEGREES,
                useCenter = false,
                style = Stroke(width = 5.dp.toPx(), cap = StrokeCap.Round,
                )
            )
        }
        Text(
            text = (movieProgress*10).toString(),
            fontSize = 15.sp,
            color = Color.Black,
            modifier = modifier.align(Alignment.Center)
        )
    }
}

@Preview(showBackground = true)
@Composable
public fun ProgressBarPreview() {
    val score: Float = 2.2F/10
    ProgressBar(score, modifier = Modifier)
}