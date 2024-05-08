package com.example.pedrapapeltesoura.ui

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
            val numPlayers = intent.getIntExtra(NUM_PLAYERS, 0)

            agb.rockBtn.setOnClickListener {
                playGame(numPlayers, "Rock")
            }
            agb.paperBtn.setOnClickListener {
                playGame(numPlayers, "Paper")
            }
            agb.scissorBtn.setOnClickListener {
                playGame(numPlayers, "Scissor")
            }
            agb.spockBtn.setOnClickListener {
                playGame(numPlayers, "Spock")
            }
            agb.lizardBtn.setOnClickListener {
                playGame(numPlayers, "Lizard")
            }
        }
    }

    private fun playGame(numPlayers: Int, choice: String){
        if (numPlayers == 2) {
            playOneVsOne(choice)
        }
        else {
            playOneVsTwo(choice)
        }
    }

    private fun playOneVsOne(playerChoice: String) {
        val options = arrayOf("Rock", "Paper", "Scissor", "Spock", "Lizard")
        val bot1Choice = options.random()

        if (playerChoice == bot1Choice) {
            showResultOneVsOne("draw", playerChoice, bot1Choice)
        } else if ((playerChoice == "Rock" && (bot1Choice == "Paper" || bot1Choice == "Spock")) ||
            (playerChoice == "Paper" && (bot1Choice == "Scissor" || bot1Choice ==  "Lizard")) ||
            (playerChoice == "Scissor" && (bot1Choice == "Rock" || bot1Choice == "Spock")) ||
            (playerChoice == "Lizard" && (bot1Choice == "Scissor" || bot1Choice == "Rock")) ||
            (playerChoice == "Spock" && (bot1Choice == "Paper" || bot1Choice == "Lizard"))) {
            showResultOneVsOne("defeat", playerChoice, bot1Choice)
        } else {
            showResultOneVsOne("victory", playerChoice, bot1Choice)
        }
    }

    private fun playOneVsTwo(playerChoice: String) {
        val options = arrayOf("Rock", "Paper", "Scissor", "Spock", "Lizard")
        val bot1Choice = options.random()
        val bot2Choice = options.random()

        val playerWinsAgainstBot1 = (playerChoice == "Rock" && (bot1Choice == "Scissor" || bot1Choice == "Lizard")) ||
                (playerChoice == "Paper" && (bot1Choice == "Rock" || bot1Choice == "Spock")) ||
                (playerChoice == "Scissor" && (bot1Choice == "Paper" || bot1Choice == "Lizard")) ||
                (playerChoice == "Lizard" && (bot1Choice == "Paper" || bot1Choice == "Spock")) ||
                (playerChoice == "Spock" && (bot1Choice == "Rock" || bot1Choice == "Scissor"))

        val playerWinsAgainstBot2 = (playerChoice == "Rock" && (bot2Choice == "Scissor" || bot2Choice == "Lizard")) ||
                (playerChoice == "Paper" && (bot2Choice == "Rock" || bot2Choice == "Spock")) ||
                (playerChoice == "Scissor" && (bot2Choice == "Paper" || bot2Choice == "Lizard")) ||
                (playerChoice == "Lizard" && (bot2Choice == "Paper" || bot2Choice == "Spock")) ||
                (playerChoice == "Spock" && (bot2Choice == "Rock" || bot2Choice == "Scissor"))

        if (playerChoice == bot1Choice && playerChoice == bot2Choice) {
            showResultOneVsTwo("draw", playerChoice, bot1Choice, bot2Choice)
        } else if (playerWinsAgainstBot1 && playerWinsAgainstBot2) {
            showResultOneVsTwo("victory", playerChoice, bot1Choice, bot2Choice)
        } else if (playerWinsAgainstBot1 && playerChoice == bot2Choice) {
            showResultOneVsTwo("draw", playerChoice, bot1Choice, bot2Choice)
        } else if (playerWinsAgainstBot2 && playerChoice == bot1Choice) {
            showResultOneVsTwo("draw", playerChoice, bot1Choice, bot2Choice)
        } else {
            showResultOneVsTwo("defeat", playerChoice, bot1Choice, bot2Choice)
        }
    }

    private fun showResultOneVsOne(result: String, playerChoice: String, bot1Choice: String) {
        val message = when (result) {
            "victory" -> "YOU WON!\n" +
                    "Your choice: $playerChoice \n" +
                    "Bot 1 choice: $bot1Choice \n"
            "defeat" -> "YOU LOST!\n" +
                    "Your choice: $playerChoice \n" +
                    "Bot 1 choice: $bot1Choice\n "
            "draw" -> "DRAW!\n" +
                    "Your choice: $playerChoice \n" +
                    "Bot 1 choice: $bot1Choice \n"
            else -> "Invalid Result!"
        }
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    private fun showResultOneVsTwo(
        result: String, playerChoice: String, bot1Choice: String, bot2Choice: String
    ) {
        val message = when (result) {
            "victory" -> "YOU WON!\n" +
                    "Your choice: $playerChoice \n" +
                    "Bot 1 choice: $bot1Choice \n" +
                    "Bot 2 choice: $bot2Choice"
            "defeat" -> "YOU LOST!\n" +
                    "Your choice: $playerChoice \n" +
                    "Bot 1 choice: $bot1Choice \n" +
                    "Bot 2 choice: $bot2Choice"
            "draw" -> "DRAW!\n" +
                    "Your choice: $playerChoice \n" +
                    "Bot 1 choice: $bot1Choice \n" +
                    "Bot 2 choice: $bot2Choice"
            else -> "Invalid Result!"
        }
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}