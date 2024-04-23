package com.example.pedrapapeltesoura.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pedrapapeltesoura.databinding.ActivityGameBinding

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
        }
    }
}