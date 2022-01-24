package com.example.whoseonfirst

import androidx.lifecycle.ViewModel

class TeamNameViewModel: ViewModel() {

    val teamNames: MutableList<String> = mutableListOf()

    fun addTeam(name: String) {
        teamNames.add(name)
    }

    fun randomTeam(): String {
        return teamNames.random()
    }

    fun getList(): MutableList<String> {
        return teamNames
    }

    fun clearList() {
        teamNames.clear()
    }
}