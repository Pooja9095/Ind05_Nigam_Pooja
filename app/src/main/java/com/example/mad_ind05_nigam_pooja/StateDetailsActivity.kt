package com.example.mad_ind05_nigam_pooja
//Import the neccessary packages
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mad_ind05_nigam_pooja.ui.theme.MAD_Ind05_Nigam_PoojaTheme
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource

// Define the StateDetailsActivity class, which inherits from ComponentActivity
class StateDetailsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Get the passed Parcelable state object from the intent
        val state = intent.getParcelableExtra<State>("state")
        setContent {
            // Apply the theme to the activity
            MAD_Ind05_Nigam_PoojaTheme {
                // Create a Surface with the background color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Check if the state object is not null
                    if (state != null) {
                        // Call the StateDetails composable with the state object
                        StateDetails(state)
                    }
                }
            }
        }
    }
}
// Define the StateDetails composable function that takes a state object
@Composable
fun StateDetails(state: State) {
    // Display the state map image using the resource ID from the state object
    Image(painter = painterResource(state.mapResId), contentDescription = "${state.name} map")
    // Display the state name using the titleLarge typography style
    Text(text = "State: ${state.name}", style = MaterialTheme.typography.titleLarge)
    // Display the state nickname using the bodyLarge typography style
    Text(text = "Nickname: ${state.nickname}", style = MaterialTheme.typography.bodyLarge)
    // Display the state area using the bodyLarge typography style
    Text(text = "Area: ${state.area}", style = MaterialTheme.typography.bodyLarge)
}


