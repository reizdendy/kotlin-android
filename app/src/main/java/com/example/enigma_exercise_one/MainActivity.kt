package com.example.enigma_exercise_one

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.enigma_exercise_one.constant.PLAYER_1_NAME
import com.example.enigma_exercise_one.constant.PLAYER_2_NAME
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),View.OnClickListener {
    val activityName = "MAIN_ACTIVITY"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("$activityName ON CREATE")
        play_button.setOnClickListener(this)
    }

    //cara manual override onClick
    override fun onClick(v: View?) {
        when(v){
            play_button->toBoardActivity()
        }
    }
    fun toBoardActivity(){
        val intent = Intent(this, BoardActivity::class.java)
        intent.putExtra(PLAYER_1_NAME, player1.text.toString())
        intent.putExtra(PLAYER_2_NAME, player2.text.toString())
        startActivity(intent)
    }

}
