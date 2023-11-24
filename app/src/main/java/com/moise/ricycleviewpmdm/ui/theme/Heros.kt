package com.moise.ricycleviewpmdm.ui.theme

import com.moise.ricycleviewpmdm.R

fun getSuperHeros(): MutableList<Superhero> {
    val heroList = mutableListOf<Superhero>()
    heroList.add(Superhero("Batman", "Bruce Wayne", "DC", R.drawable.batman))
    heroList.add(Superhero("Flash", "Jay Garrick", "DC", R.drawable.flash))
    heroList.add(Superhero("Wolverine", "James Howlett", "Marvel", R.drawable.logan))
    heroList.add(Superhero("Green Lantern", "Alan Scott", "DC", R.drawable.green_lantern))
    return heroList
}