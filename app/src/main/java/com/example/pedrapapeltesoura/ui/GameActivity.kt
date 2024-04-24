package com.example.pedrapapeltesoura.ui

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pedrapapeltesoura.databinding.ActivityGameBinding
import com.example.pedrapapeltesoura.model.Constant.NUM_PLAYERS

class GameActivity : AppCompatActivity() {

    private val agb: ActivityGameBinding by lazy {
        ActivityGameBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(agb.root)
        agb.toolbarIn.toolbar.apply {
            subtitle = this@GameActivity.javaClass.simpleName
            setSupportActionBar(this)
            var numPlayers = intent.getIntExtra(NUM_PLAYERS, 0)

            agb.rockBtn.setOnClickListener {
                playGame(numPlayers, "Rock")
            }
            agb.paperBtn.setOnClickListener {
                playGame(numPlayers, "Paper")
            }
            agb.scissorBtn.setOnClickListener {
                playGame(numPlayers, "Scissor")
            }
        }
    }

    private fun playGame(numPlayers: Int, choice: String){
        if (numPlayers != 2) playOneVsTwo(choice) else playOneVsThree(choice)
    }

    private fun playOneVsTwo(playerChoice: String){
        val options = arrayOf("Rock", "Paper", "Scissor")
        val bot1Choice = options.random()
    }

    private fun playOneVsThree(playerChoice: String){
    }

    fun ShowResult(context: Context, result: String) {
        val message = when (result) {
            "victory" -> "You won!"
            "defeat" -> "You lost!"
            "draw" -> "Draw!"
            else -> "Invalid Result!"
        }
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}