
package com.islamux.salam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.islamux.salam.ui.theme.SalamTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SalamTheme {
                val navController = rememberNavController()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(
                                    text = "خواطر إيمانية",
                                    fontSize = 21.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            },
                            actions = {
                                TextButton(onClick = { /* Share logic */ }) {
                                    Text(
                                        text = "شارك",
                                        fontSize = 22.sp,
                                        color = MaterialTheme.colorScheme.primary
                                    )
                                }
                            },
                        )
                    },
                    content = { innerPadding ->
                        SetupNavGraph(
                            navController = navController,
                            modifier = Modifier.padding(innerPadding)
                        )
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SalamTheme {
        val navController = rememberNavController()
        HomePage(navController = navController)
    }
}
