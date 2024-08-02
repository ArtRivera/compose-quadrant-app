package com.artrivera.composecuadrantapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artrivera.composecuadrantapp.ui.theme.ComposeCuadrantAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeCuadrantAppTheme {
                QuadrantView()
            }
        }
    }


    @Composable
    fun QuadrantView(modifier: Modifier = Modifier) {
        Scaffold(modifier) { innerPadding ->
            Column(modifier = Modifier.padding(innerPadding)) {
                Row(Modifier.weight(1f)) {
                    QuadrantContainer(
                        modifier = Modifier.weight(1f),
                        title = stringResource(R.string.text_composable_title),
                        description = stringResource(R.string.text_composable_desc),
                        backgroundColor =  Color(0xFFEADDFF)

                    )
                    QuadrantContainer(
                        modifier = Modifier.weight(1f),
                        title = stringResource(R.string.image_composable_title),
                        description = stringResource(R.string.image_composable_desc),
                        backgroundColor = Color(0xFFD0BCFF)

                    )
                }
                Row(Modifier.weight(1f)) {
                    QuadrantContainer(
                        modifier = Modifier.weight(1f),
                        title = stringResource(R.string.row_composable_title),
                        description = stringResource(R.string.row_composable_desc),
                        backgroundColor = Color(0xFFB69DF8)
                    )
                    QuadrantContainer(
                        modifier = Modifier.weight(1f),
                        title = stringResource(R.string.column_composable_title),
                        description = stringResource(R.string.column_composable_desc),
                        backgroundColor = Color(0xFFF6EDFF),
                    )

                }
            }
        }

    }

    @Composable
    fun QuadrantTitle(title: String) {
        Text(
            title,
            modifier = Modifier.padding(bottom = 16.dp),
            fontWeight = FontWeight.Bold
        )
    }

    @Composable
    fun QuadrantDescription(description: String) {
        Text(
            description,
            textAlign = TextAlign.Justify
        )
    }

    @Composable
    fun QuadrantContainer(
        modifier: Modifier = Modifier,
        title: String,
        description: String,
        backgroundColor: Color
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(backgroundColor)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            QuadrantTitle(title)
            QuadrantDescription(description)
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun QuadrantViewPreview() {
        ComposeCuadrantAppTheme {
            QuadrantView()
        }
    }
}
