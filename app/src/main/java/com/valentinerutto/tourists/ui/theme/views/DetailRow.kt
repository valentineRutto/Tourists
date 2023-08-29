package com.valentinerutto.tourists.ui.theme.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
internal fun DetailRow(
    label: String,
    value: String,
    modifier: Modifier = Modifier,
    separator: @Composable RowScope.() -> Unit = {},
    labelStyle: TextStyle = MaterialTheme.typography.bodyMedium,
    valueStyle: TextStyle = MaterialTheme.typography.bodyMedium,
) {

    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .padding(vertical = 6.dp)
    ) {
        Text(
            text = "$label:",
            style = labelStyle,
            fontWeight = FontWeight.Bold
        )
        separator()
        Text(
            text = value.replaceFirstChar { it.uppercase() },
            style = valueStyle
        )
    }
}

@Composable
internal fun Header(label: String, modifier: Modifier = Modifier) {
    Text(
        text = label,
        style = MaterialTheme.typography.headlineMedium,
        fontWeight = FontWeight.Bold,
        modifier = modifier.padding(
            10.dp
        )
    )
}