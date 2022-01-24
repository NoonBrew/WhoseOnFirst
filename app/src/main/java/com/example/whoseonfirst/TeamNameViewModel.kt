package com.example.whoseonfirst

import androidx.lifecycle.ViewModel

class TeamNameViewModel: ViewModel() {

    private val teamNames: MutableList<String> = mutableListOf()
    // Adds a team to a list.
    fun addTeam(name: String) {
        teamNames.add(name)
    }
    // Returns a random String value from our list.
    fun randomTeam(): String {
        return teamNames.random()
    }
    // Returns the list, used primarily for logging
    fun getList(): MutableList<String> {
        return teamNames
    }
    // clears our list.
    fun clearList() {
        teamNames.clear()
    }
}