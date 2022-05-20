package com.example.dropdown6

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize


@Composable
fun MainScreen() {

    val stateHolder = rememberExposedMenuStateHolder()
    ExosedDropDownMenu(stateHolder = stateHolder)
}
//Final version
@Composable
fun ExosedDropDownMenu(stateHolder: ExposedDropMenuStateHolder) {


    Column{
        Card (modifier = Modifier.fillMaxWidth()


        )

        {
            OutlinedTextField(
                readOnly = true,
                value = stateHolder.value,
                onValueChange = { },
                label = { Text("Activitate selectata") },
                trailingIcon = {
                    Icon(painter = painterResource(id = stateHolder.icon),
                        contentDescription = null,
                        Modifier.clickable {
                            stateHolder.onEnabled(!stateHolder.enabled)
                        }
                    )
//                    Text(modifier = Modifier.weight(20f),
//                        text ="Selecteaza activitatea",
//                        textAlign = TextAlign.Right
//                        )
                },
                modifier = Modifier.onGloballyPositioned {
                    stateHolder.onSize(it.size.toSize())
                }
            )
            DropdownMenu(
                expanded = stateHolder.enabled,
                onDismissRequest = {
                    stateHolder.onEnabled(false)
                },
                modifier = Modifier
                    .width(with(LocalDensity.current)
                    { stateHolder.size.width.toDp() })
            ) {
                stateHolder.items.forEachIndexed { index, s ->
                    DropdownMenuItem(onClick = {
                        stateHolder.onSelectedIndex(index)
                        stateHolder.onEnabled(false)
                    }) {

                        Text(text = s)
                    }
                }

            }

        }


    }



}
