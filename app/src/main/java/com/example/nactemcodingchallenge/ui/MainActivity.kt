package com.example.nactemcodingchallenge.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.example.nactemcodingchallenge.data.repository.Repository
import com.example.nactemcodingchallenge.ui.theme.NaCTemCodingChallengeTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import retrofit2.Call
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var repository: Repository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


            repository.getStringResponse("USA")






        setContent {
            NaCTemCodingChallengeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                }
            }
        }
    }
}

