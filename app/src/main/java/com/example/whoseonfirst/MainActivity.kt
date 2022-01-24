package com.example.whoseonfirst

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
const val TAG = "TEAM_NAME_ACTIVITY"
class MainActivity : AppCompatActivity() {
    // Initializes our ListViewModel, Did this for encapslation of functions in another Object
    private val teamListViewModel: TeamNameViewModel by lazy {
        ViewModelProvider(this).get(TeamNameViewModel::class.java)
    }
    // Set up to initialize our views later after they have been inflated.
    private lateinit var randomButton: Button
    private lateinit var teamOneName: EditText
    private lateinit var teamTwoName: EditText
    private lateinit var resultText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Links the resource ID of our views to our variable names.
        randomButton = findViewById(R.id.random_button)
        teamOneName = findViewById(R.id.team_one_name)
        teamTwoName = findViewById(R.id.team_two_name)
        resultText = findViewById(R.id.result_textview)
        // Action listener for when the random button is pushed.
        randomButton.setOnClickListener {
            // Takes the value of our PlainText views and stores them as strings.
            val teamOne = teamOneName.text.toString()
            val teamTwo = teamTwoName.text.toString()

            // Checks that there is two teams to pick between.
            if(teamOne.isNotBlank() && teamTwo.isNotBlank()){
                // Adds the teams to a mutable list by calling a method on our model.
                teamListViewModel.addTeam(teamOne)
                teamListViewModel.addTeam(teamTwo)
                // Grabs a random team from our list and stores it.
                val randomTeamSelection = teamListViewModel.randomTeam()
                // Changes our resultText message to the team that should go first.
                resultText.text = getString(R.string.results_on_click, randomTeamSelection)
                // Clears the list so it doesn't keep growing and size.
                teamListViewModel.clearList()
                // Log how many teams are in our list. Useful to make sure our list was cleared.
                Log.i(TAG, "Current List ${teamListViewModel.getList().size}")

            } else {
                // Prompts the user with an error message if they do not have both teams with names.
                Toast.makeText(this, R.string.no_team_warning, Toast.LENGTH_LONG).show()
            }
        }


    }
}