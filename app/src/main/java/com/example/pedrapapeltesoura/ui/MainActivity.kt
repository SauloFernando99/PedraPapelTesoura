package com.example.pedrapapeltesoura.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pedrapapeltesoura.model.Constant.NUM_PLAYERS
import com.example.pedrapapeltesoura.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val amb: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(amb.root)
        amb.toolbarIn.toolbar.apply {
            subtitle = this@MainActivity.javaClass.simpleName
            setSupportActionBar(this)
        }

        amb.twoPlayersBtn.setOnClickListener {
            openPlayerSelectionActivity(2)
        }

        amb.threePlayersBtn.setOnClickListener {
            openPlayerSelectionActivity(3)
        }
    }

    private fun openPlayerSelectionActivity(numPlayers: Int) {
        val viewGameIntent = Intent(this@MainActivity, GameActivity::class.java)
        viewGameIntent.putExtra(NUM_PLAYERS, numPlayers)
        startActivity(viewGameIntent)
    }
}