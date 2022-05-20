package com.example.dropdown6

import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.geometry.Size

class ExposedDropMenuStateHolder {

    var enabled by mutableStateOf(false)
    var value by mutableStateOf("")
    var selectedIdex by mutableStateOf(-1)
    var size by mutableStateOf(Size.Zero)
    val icon: Int
        @Composable get() = if (enabled) {
            R.drawable.up50px
        } else {
            R.drawable.down50px
        }
    val items = (1..5).map {
        "Activitatea autorizata $it"
    }
    fun onEnabled(newValue: Boolean) {
        enabled = newValue
    }
    fun onSelectedIndex(newValue: Int) {
        selectedIdex = newValue
        value = items[selectedIdex]
    }
    fun onSize(newValue: Size) {
        size = newValue
    }
}
@Composable
fun rememberExposedMenuStateHolder() = remember {
    ExposedDropMenuStateHolder()

}

