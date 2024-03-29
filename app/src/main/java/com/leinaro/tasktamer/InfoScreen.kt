package com.leinaro.tasktamer

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.leinaro.tasktamer.ui.theme.TaskTamerTheme

@Composable
fun InfoScreen(developers: List<Developer>) {
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.surfaceVariant)
            //.fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Developers",
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        LazyColumn() {
            items(developers) { developer ->
                DeveloperItem(developer)
                Divider(modifier = Modifier.padding(vertical = 8.dp))
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "App Version: v1.0(1)",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
private fun DeveloperItem(developer: Developer) {
    val uriHandler = LocalUriHandler.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column {
            Text(
                text = developer.name,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(bottom = 4.dp)
            )

            Row(
                modifier = Modifier
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                    modifier = Modifier
                        .size(16.dp)
                        .padding(end = 4.dp)
                )

                Text(
                    text = developer.email,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary
                )
            }
            Row(
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .clickable {
                        uriHandler.openUri(developer.gitHub)
                    },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = null,
                    modifier = Modifier
                        .size(16.dp)
                        .padding(end = 4.dp)
                )

                Text(
                    text = "GitHub Profile",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun DeveloperScreenPreview() {
    TaskTamerTheme(darkTheme = true) {
        val developers = listOf(
            Developer("John Doe", "https://www.linkedin.com/in/johndoe", "https://www.linkedin.com/in/johndoe"),
            Developer("Jane Smith", "https://www.linkedin.com/in/janesmith", "https://www.linkedin.com/in/janesmith")
        )
        InfoScreen(developers)
    }
}