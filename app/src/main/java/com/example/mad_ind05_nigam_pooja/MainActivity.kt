package com.example.mad_ind05_nigam_pooja
//Import necessary packages
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.ui.unit.dp
import android.content.Intent
import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource



// Define the MainActivity class, which inherits from ComponentActivity
class MainActivity : ComponentActivity() {
    // Define a Parcelable data class for the state object
@Parcelize
    data class State(val name: String, val nickname: String, val area: String, @DrawableRes val flagResId: Int, @DrawableRes val mapResId: Int) : Parcelable

    // Initialize the state objects
    private val states = listOf(
        State("Alabama", "Yellowhammer State", "50,744", R.drawable.alabama_flag, R.drawable.alabama_map),
        State("Alaska", "The Last Frontier", "571,951", R.drawable.alaska_flag, R.drawable.alaska_map),
        State("Arizona", "The Grand Canyon State", "113,635", R.drawable.arizona_flag, R.drawable.arizona_map),
        State("Arkansas", "The Natural State", "52,068", R.drawable.arkansas_flag, R.drawable.arkansas_map),
        State("California", "The Golden State", "155,959", R.drawable.california_flag, R.drawable.california_map),
        State("Colorado", "The Centennial State", "103,718", R.drawable.coloroda_flag, R.drawable.coloroda_map),
        State("Connecticut", "The Constitute State", "4,845", R.drawable.connecticut_flag, R.drawable.connecticut_map),
        State("Delaware", "The First State", "1,954", R.drawable.delaware_flag, R.drawable.delaware_map),
        State("Florida", "The Sunshine State", "53,927", R.drawable.florida_flag, R.drawable.florida_map),
        State("Georgia", "The Peach State", "57,906", R.drawable.georgia_flag, R.drawable.georgia_map),
        State("Hawaii", "The Aloha State", "6,423", R.drawable.hawaii_flag, R.drawable.hawaii_map),
        State("Idaho", "The Gem State", "82,747", R.drawable.idaho_flag, R.drawable.idaho_map),
        State("Illinois", "Prairie State", "55,584", R.drawable.hawaii_flag, R.drawable.illionois_map),
        State("Indiana", "The Hoosier State", "35,867", R.drawable.indiana_flag, R.drawable.indiana_map),
        State("Iowa", "The Hawkeye State", "55,869", R.drawable.iowa_flag, R.drawable.iowa_map),
        State("Kansas", "The Sunflower State", "81,815", R.drawable.kansas_flag, R.drawable.kansas_map),
        State("Kentucky", "The Bluegrass State", "39,728", R.drawable.kentucky_flag, R.drawable.kentucky_map),
        State("Louisiana", "The Pelican State", "43,562", R.drawable.louisiana_flag, R.drawable.louisiana_flag),
        State("Maine", "The Pine Tree State", "30,862", R.drawable.maine_flag, R.drawable.maine_map),
        State("Maryland", "The Old Line State", "9,774", R.drawable.maryland_flag, R.drawable.maryland_map),
        State("Massachusetts", "The Bay State", "7,840", R.drawable.massachusetts_flag, R.drawable.massachusetts_map),
        State("Michigan", "The Great Lakes State", "56,804", R.drawable.michigan_flag, R.drawable.michigan_map),
        State("Minnesota", "The North Star State", "79,610", R.drawable.minnesota_flag, R.drawable.minnesota_map),
        State("Mississippi", "The Magnolia State", "46,907", R.drawable.mississippi_flag, R.drawable.mississippi_map),
        State("Missouri", "The Show Me State", "68,886", R.drawable.missouri_flag, R.drawable.missouri_map),
        State("Montana", "The Treasure State", "145,552", R.drawable.montana_flag, R.drawable.montana_map),
        State("Nebraska", "The Cornhusker State", "76,872", R.drawable.nebraska_flag, R.drawable.nebraska_map),
        State("Nevada", "The Silver State", "109,826", R.drawable.nevada_flag, R.drawable.nevada_map),
        State("New Hampshire", "The Granite State", "8,968", R.drawable.new_hampshire_flag, R.drawable.new_hampshire_map),
        State("New Jersey", "The Garden State", "7,417", R.drawable.new_jersey_flag, R.drawable.new_jersey_map),
        State("New Mexico", "The Land of Enchantment", "121,356", R.drawable.new_mexico_flag, R.drawable.new_mexico_map),
        State("New York", "The Empire State", "47,214", R.drawable.new_york_flag, R.drawable.new_york_map),
        State("North Carolina", "The Tar Heel State", "48,711", R.drawable.north_carolina_flag, R.drawable.north_carolina_map),
        State("North Dakota", "The Peace Garden State", "68,976", R.drawable.north_dakota_flag, R.drawable.north_dakota_map),
        State("Ohio", "The Buckeye State", "40,948", R.drawable.ohio_flag, R.drawable.ohio_map),
        State("Oklahoma", "The Sooner State", "68,667", R.drawable.oklahoma_flag, R.drawable.oklahoma_map),
        State("Oregon", "The Beaver State", "95,997", R.drawable.oregon_flag, R.drawable.oregon_map),
        State("Pennsylvania", "The Keystone State", "44,817", R.drawable.pennsylvania_flag, R.drawable.pennsylvania_map),
        State("Rhode Island", "The Ocean State", "1,045", R.drawable.rhode_island_flag, R.drawable.rhode_island_map),
        State("South Carolina", "The Palmetto State", "30,109", R.drawable.south_carolina_flag, R.drawable.south_carolina_map),
        State("South Dakota", "The Mount Rushmore State", "75,885", R.drawable.south_dakota_flag, R.drawable.south_dakota_map),
        State("Tennessee", "The Volunteer State", "41,217", R.drawable.tennessee_flag, R.drawable.tennessee_map),
        State("Texas", "The Lone Star State", "261,797", R.drawable.texas_flag, R.drawable.texas_map),
        State("Utah", "The Beehive State", "82,144", R.drawable.utah_flag, R.drawable.utah_map),
        State("Vermont", "The Green Mountain State", "9,250", R.drawable.vermont_flag, R.drawable.vermont_map),
        State("Virginia", "The Old Dominion State", "39,594", R.drawable.virginia_flag, R.drawable.virginia_map),
        State("Washington", "The Evergreen State", "66,544", R.drawable.washington_flag, R.drawable.washington_map),
        State("West Virginia", "The Mountain State", "24,078", R.drawable.west_virginia_flag, R.drawable.west_virginia_map),
        State("Wisconsin", "The Badger State", "54,310", R.drawable.wisconsin_flag, R.drawable.wisconsin_map),
        State("Wyoming", "The Equality or Cowboy State", "97,100", R.drawable.wyoming_flag, R.drawable.wyoming_map)
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sortedStates = states.sortedBy { it.name }

        setContent {
            MAD_Ind05_Nigam_PoojaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    StateList(states) { state ->
                        onItemClick(state)
                    }
                }
            }
        }
    }

    private fun onItemClick(state: State) {
        // Start the StateDetailsActivity and pass the state object
        val intent = Intent(this, StateDetailsActivity::class.java).apply {
            putExtra("state", state)
        }
        startActivity(intent)
    }
// Define the StateListItem composable function
    @Composable
    fun StateListItem(state: State, onClick: () -> Unit) {
        // Design the layout for the list item here
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .clickable(onClick = onClick)
        ) {
            // Add components like Image, Text, etc.
            Image(painter = painterResource(state.flagResId), contentDescription = "${state.name} flag")
            //Display the state name and nickname as before
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = state.name, style = MaterialTheme.typography.labelLarge) // Display the state name
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = state.nickname, style = MaterialTheme.typography.titleSmall) // Display the state nickname
        }
    }
    // Define the StateList composable function
    @Composable
    fun StateList(states: List<State>, onStateClick: (State) -> Unit) {
        LazyColumn {
            items(states) { state ->
                StateListItem(state) {
                    onStateClick(state)
                }
            }
        }
    }
}

