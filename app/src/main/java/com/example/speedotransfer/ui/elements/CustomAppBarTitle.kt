package com.example.speedotransfer.ui.elements

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.speedotransfer.ui.theme.G900
import com.example.speedotransfer.ui.theme.TitleMedium

@Composable
fun CutomAppBarTitle(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        style = TitleMedium,
        color = G900,
        modifier = modifier.height(30.dp)

    )
}

@Composable
fun CustomAppBarIcon(icon: Int, modifier: Modifier = Modifier) {
    Icon(
        painter = painterResource(id = icon),
        contentDescription = "Back",
        modifier = modifier.size(24.dp)
    )
}