package com.moise.ricycleviewpmdm

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moise.ricycleviewpmdm.ui.theme.Superhero
import com.moise.ricycleviewpmdm.ui.theme.getSuperHeros

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperHeroView()
        }
    }
}


@Composable
fun SuperHeroView() {
    val context = LocalContext.current
    LazyVerticalGrid(GridCells.Fixed(2) ) {
        items(getSuperHeros()){
            ItemHero(
                hero = it,
                click ={
                    Toast.makeText(context,it.realName,Toast.LENGTH_SHORT).show()
                } )
        }
    }
}

@Composable
fun ItemHero(hero:Superhero,click:(Superhero)->Unit){
    Card(
        modifier = Modifier
            .padding(4.dp)
            .border(2.dp, Color.Red)
            .clickable {
                click(hero)
            },
    ) {
        Column {
            Image(
                painter = painterResource(id = hero.photo),
                contentDescription = "image",
                modifier = Modifier
                    .width(500.dp)
                    .height(200.dp)
                    )
            Text(hero.superHeroName,modifier=Modifier.align(Alignment.CenterHorizontally))
            Text(hero.realName,modifier=Modifier.align(Alignment.CenterHorizontally))
            Text(hero.publisher,modifier= Modifier
                .padding(8.dp)
                .align(Alignment.End))
        }
    }

}
