package endava.codebase.android.movieapp.ui.component

import androidx.compose.material.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

class `FavoriteButton.kt` {


    @Composable
    fun FavoriteButton() {
        val isChecked = remember {
            mutableStateOf(false)
        }
        FavoriteButtonPreview(
            isChecked = isChecked.value,
            onCheckedChange = { isChecked.value = it}
        )
    }

    @Composable
    public fun FavoriteButtonPreview(isChecked: Boolean, onCheckedChange: (Boolean) -> Unit) {
        Checkbox(
            checked = isChecked,
            onCheckedChange = onCheckedChange
        )
    }
}