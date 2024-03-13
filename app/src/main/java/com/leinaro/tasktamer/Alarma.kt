package com.leinaro.tasktamer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.leinaro.tasktamer.R.drawable
import com.leinaro.tasktamer.ui.theme.TaskTamerTheme

@Composable
fun Alarma(
    modifier: Modifier = Modifier,
    onComplete: () -> Unit  = {},
    onPostpone: () -> Unit  = {},
    onDismiss: () -> Unit   = {},
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .paint(
                painterResource(id = drawable.background),
                contentScale = ContentScale.FillBounds
            )
            .paint(
                painterResource(id = R.drawable.background_top),
                alignment = Alignment.TopCenter,
                contentScale = ContentScale.FillWidth
            )
            .paint(
                painterResource(id = R.drawable.background_bottom),
                alignment = Alignment.BottomCenter,
                contentScale = ContentScale.FillWidth
            )
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "10:00 AM",
            style = MaterialTheme.typography.displayLarge,
        )
        Text(
            text = "Martes, 10 de Agosto",
            style = MaterialTheme.typography.headlineMedium,
            )

        Spacer(modifier = Modifier.height(80.dp))

        Text(
            text = "Tarea 1",
            style = MaterialTheme.typography.headlineMedium,
        )
        Text(
            text = "Holding out for a hero",
            style = MaterialTheme.typography.titleLarge,
        )

        Spacer(modifier = Modifier.height(80.dp))

        Button(onClick = { onComplete() }) {
            Text(text = "Completar")
        }

        LargeFloatingActionButton(
            modifier = Modifier
                .clip(shape = CircleShape)
                .background(Color(0x4DF07001))
                .padding(16.dp),
            onClick = {  },
            shape = CircleShape,
        ) {
            Icon(Icons.Filled.Close, "Large floating action button")
        }

        Row {
            Button(onClick = { onPostpone() }) {
                Text(text = "Posponer")
            }
            Button(onClick = { onDismiss() }) {
                Text(text = "Silenciar")
            }
        }
    }
}

@Preview
@Composable
fun AlarmaPreview() {
    TaskTamerTheme {
        Alarma()
    }
}
