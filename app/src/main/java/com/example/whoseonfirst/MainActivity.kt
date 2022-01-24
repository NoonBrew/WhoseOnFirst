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

    val teamListViewModel: TeamNameViewModel by lazy {
        ViewModelProvider(this).get(TeamNameViewModel::class.java)
    }

    private lateinit var randomButton: Button
    private lateinit var teamOneName: EditText
    private lateinit var teamTwoName: EditText
    private lateinit var resultText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        randomButton = findViewById(R.id.random_button)
        teamOneName = findViewById(R.id.team_one_name)
        teamTwoName = findViewById(R.id.team_two_name)
        resultText = findViewById(R.id.result_textview)

        randomButton.setOnClickListener {
            val teamOne = teamOneName.text.toString()
            val teamTwo = teamTwoName.text.toString()


            if(teamOne.isNotBlank() && teamTwo.isNotBlank()){
                teamListViewModel.addTeam(teamOne)
                teamListViewModel.addTeam(teamTwo)
                resultText.text = teamListViewModel.randomTeam()
                // Log how many teams are in our list.
                Log.i(TAG, "Current List ${teamListViewModel.getList().size}")
                teamListViewModel.clearList()
            } else {
                Toast.makeText(this, R.string.no_team_warning, Toast.LENGTH_LONG).show()
            }
        }


    }
}