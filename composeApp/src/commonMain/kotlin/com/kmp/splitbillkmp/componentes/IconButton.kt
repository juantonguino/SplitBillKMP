package com.kmp.splitbillkmp.componentes


import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun MainIconButton(imageVector: ImageVector,
                   contentDescription: String,
                   onClick: ()-> Unit,
                   modifier: Modifier,
                   content: @Composable ()-> Unit){
    IconButton(onClick = onClick, modifier = modifier){
        Icon(
            imageVector = imageVector,
            contentDescription = contentDescription
        )
        content()
    }
}
