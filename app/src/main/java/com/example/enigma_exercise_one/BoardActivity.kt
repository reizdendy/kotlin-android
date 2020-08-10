package com.example.enigma_exercise_one

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.enigma_exercise_one.constant.PLAYER_1_NAME
import com.example.enigma_exercise_one.constant.PLAYER_2_NAME
import kotlinx.android.synthetic.main.activity_board.*

class BoardActivity : AppCompatActivity() {
    var player1Name = ""
    var player2Name = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board)
        player1Name = intent.getStringExtra(PLAYER_1_NAME).toString();
        player2Name = intent.getStringExtra(PLAYER_2_NAME).toString();
        playersBanner.text="$player1Name VS $player2Name"
        playerTurn.text = "$player1Name's Turn"
    }

    fun handleBackButton(view: View) {
        onBackPressed()
    }

    fun handleButtonClick(view: View) {
        val buttonSelected = view as Button
        var cellID = 0
        when(buttonSelected.id){
            R.id.button1 -> cellID = 1
            R.id.button2 -> cellID = 2
            R.id.button3 -> cellID = 3
            R.id.button4 -> cellID = 4
            R.id.button5 -> cellID = 5
            R.id.button6 -> cellID = 6
            R.id.button7 -> cellID = 7
            R.id.button8 -> cellID = 8
            R.id.button9 -> cellID = 9
        }
        playGame(cellID,buttonSelected)
    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()

    var activePlayer = 1

    private fun playGame(cellID: Int, buttonSelected: Button) {
        if(activePlayer==1){
            buttonSelected.text = "X"
            buttonSelected.setBackgroundColor(Color.parseColor("#009193"))
            player1.add(cellID)
            activePlayer = 2
            playerTurn.text = "$player2Name's Turn"
        }else{
            buttonSelected.text = "o"
            buttonSelected.setBackgroundColor(Color.parseColor("#FF9300"))
            player2.add(cellID)
            activePlayer = 1
            playerTurn.text = "$player1Name's Turn"
        }
        buttonSelected.isEnabled = false;
        checkWinner()
    }

    private fun checkWinner() {
        var winner = 0
        // row 1
        if(player1.contains(1) && player1.contains(2) && player1.contains(3)){
            winner=1
        }
        if(player2.contains(1) && player2.contains(2) && player2.contains(3)){
            winner=2
        }

        // row 2
        if(player1.contains(4) && player1.contains(5) && player1.contains(6)){
            winner=1
        }
        if(player2.contains(4) && player2.contains(5) && player2.contains(6)){
            winner=2
        }

        // row 3
        if(player1.contains(7) && player1.contains(8) && player1.contains(9)){
            winner=1
        }
        if(player2.contains(7) && player2.contains(8) && player2.contains(9)){
            winner=2
        }

        // col 1
        if(player1.contains(1) && player1.contains(4) && player1.contains(7)){
            winner=1
        }
        if(player2.contains(1) && player2.contains(4) && player2.contains(7)){
            winner=2
        }

        // col 2
        if(player1.contains(2) && player1.contains(5) && player1.contains(8)){
            winner=1
        }
        if(player2.contains(2) && player2.contains(5) && player2.contains(8)){
            winner=2
        }

        // col 3
        if(player1.contains(3) && player1.contains(6) && player1.contains(9)){
            winner=1
        }
        if(player2.contains(3) && player2.contains(6) && player2.contains(9)){
            winner=2
        }

        //diagonal
        if(player1.contains(1) && player1.contains(5) && player1.contains(9)){
            winner=1
        }
        if(player2.contains(1) && player2.contains(5) && player2.contains(9)){
            winner=2
        }

        if(player1.contains(3) && player1.contains(5) && player1.contains(7)){
            winner=1
        }
        if(player2.contains(3) && player2.contains(5) && player2.contains(7)){
            winner=2
        }

        if( winner != 0){
            if (winner==1){
                Toast.makeText(this," $player1Name  win the game", Toast.LENGTH_LONG).show()

            }else{
                Toast.makeText(this," $player2Name  win the game", Toast.LENGTH_LONG).show()

            }

        }
    }
}
