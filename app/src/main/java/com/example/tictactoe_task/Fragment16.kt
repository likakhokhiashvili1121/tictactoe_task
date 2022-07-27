package com.example.tictactoe_task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.tictactoe_task.databinding.Fragment16Binding

class Fragment16 : Fragment(), View.OnClickListener {

    var clickCounter = 0

    private var activePlayer = 1

    private var firstPlayer = mutableListOf<Int>()
    private var secondPlayer = mutableListOf<Int>()

    private lateinit var binding: Fragment16Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = Fragment16Binding.inflate(layoutInflater, container, false)
        init()

        return binding.root
    }

    private fun init() {


        binding.button1.setOnClickListener(this)
        binding.button2.setOnClickListener(this)
        binding.button3.setOnClickListener(this)
        binding.button4.setOnClickListener(this)
        binding.button5.setOnClickListener(this)
        binding.button6.setOnClickListener(this)
        binding.button7.setOnClickListener(this)
        binding.button8.setOnClickListener(this)
        binding.button9.setOnClickListener(this)
        binding.button10.setOnClickListener(this)
        binding.button11.setOnClickListener(this)
        binding.button12.setOnClickListener(this)
        binding.button13.setOnClickListener(this)
        binding.button14.setOnClickListener(this)
        binding.button15.setOnClickListener(this)
        binding.button16.setOnClickListener(this)

        binding.buttonRestart.setOnClickListener {
            resetButton()
        }
    }

    override fun onClick(clickedView: View?) {

        if (clickedView is Button) {

            var buttonNumber = 0

            when (clickedView.id) {

                R.id.button1 -> buttonNumber = 1
                R.id.button2 -> buttonNumber = 2
                R.id.button3 -> buttonNumber = 3
                R.id.button4 -> buttonNumber = 4
                R.id.button5 -> buttonNumber = 5
                R.id.button6 -> buttonNumber = 6
                R.id.button7 -> buttonNumber = 7
                R.id.button8 -> buttonNumber = 8
                R.id.button9 -> buttonNumber = 9
                R.id.button10 -> buttonNumber = 10
                R.id.button11 -> buttonNumber = 11
                R.id.button12 -> buttonNumber = 12
                R.id.button13 -> buttonNumber = 13
                R.id.button14 -> buttonNumber = 14
                R.id.button15 -> buttonNumber = 15
                R.id.button16 -> buttonNumber = 16

            }

            if (buttonNumber != 0) {
                playGame(clickedView, buttonNumber)
            }
        }
    }

    private fun playGame(clickedView: Button, buttonNumber: Int) {
        if (activePlayer == 1) {
            clickedView.text = "X"
            firstPlayer.add(buttonNumber)
            clickCounter += 1
            activePlayer = 2
        } else {
            clickedView.text = "O"
            secondPlayer.add(buttonNumber)
            clickCounter += 1
            activePlayer = 1
        }
        clickedView.isEnabled = false
        check()
    }

    private fun check() {

        var winnerPlayer = 0

        when{
            firstPlayer.contains(1) && firstPlayer.contains(2) && firstPlayer.contains(3) && firstPlayer.contains(4) -> winnerPlayer = 1
            secondPlayer.contains(1) && secondPlayer.contains(2) && secondPlayer.contains(3)&& secondPlayer.contains(4) -> winnerPlayer = 2

            firstPlayer.contains(5) && firstPlayer.contains(6) && firstPlayer.contains(7) && firstPlayer.contains(8) -> winnerPlayer = 1
            secondPlayer.contains(5) && secondPlayer.contains(6) && secondPlayer.contains(7)&& secondPlayer.contains(8) -> winnerPlayer = 2

            firstPlayer.contains(9) && firstPlayer.contains(10) && firstPlayer.contains(11) && firstPlayer.contains(12) -> winnerPlayer = 1
            secondPlayer.contains(9) && secondPlayer.contains(10) && secondPlayer.contains(11)&& secondPlayer.contains(12) -> winnerPlayer = 2

            firstPlayer.contains(13) && firstPlayer.contains(14) && firstPlayer.contains(15) && firstPlayer.contains(16) -> winnerPlayer = 1
            secondPlayer.contains(13) && secondPlayer.contains(14) && secondPlayer.contains(15)&& secondPlayer.contains(16) -> winnerPlayer = 2

            firstPlayer.contains(1) && firstPlayer.contains(5) && firstPlayer.contains(9) && firstPlayer.contains(13) -> winnerPlayer = 1
            secondPlayer.contains(1) && secondPlayer.contains(5) && secondPlayer.contains(9)&& secondPlayer.contains(13) -> winnerPlayer = 2

            firstPlayer.contains(2) && firstPlayer.contains(6) && firstPlayer.contains(10) && firstPlayer.contains(14) -> winnerPlayer = 1
            secondPlayer.contains(2) && secondPlayer.contains(6) && secondPlayer.contains(10)&& secondPlayer.contains(14) -> winnerPlayer = 2

            firstPlayer.contains(3) && firstPlayer.contains(7) && firstPlayer.contains(11) && firstPlayer.contains(15) -> winnerPlayer = 1
            secondPlayer.contains(3) && secondPlayer.contains(7) && secondPlayer.contains(11)&& secondPlayer.contains(15) -> winnerPlayer = 2

            firstPlayer.contains(4) && firstPlayer.contains(8) && firstPlayer.contains(12) && firstPlayer.contains(16) -> winnerPlayer = 1
            secondPlayer.contains(4) && secondPlayer.contains(8) && secondPlayer.contains(12)&& secondPlayer.contains(16) -> winnerPlayer = 2



            firstPlayer.contains(1) && firstPlayer.contains(6) && firstPlayer.contains(11) && firstPlayer.contains(16) -> winnerPlayer = 1
            secondPlayer.contains(1) && secondPlayer.contains(6) && secondPlayer.contains(11)&& secondPlayer.contains(16) -> winnerPlayer = 2

            firstPlayer.contains(4) && firstPlayer.contains(7) && firstPlayer.contains(10) && firstPlayer.contains(13) -> winnerPlayer = 1
            secondPlayer.contains(4) && secondPlayer.contains(7) && secondPlayer.contains(10)&& secondPlayer.contains(13) -> winnerPlayer = 2
        }


        if (winnerPlayer != 0) {
            if (winnerPlayer == 1) {
                Toast.makeText(requireContext(), "X Wins!!", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(requireContext(), "O Wins!!", Toast.LENGTH_LONG).show()
            }

            disableButtons()
        }
        if (winnerPlayer == 0 && clickCounter == 16) {
            Toast.makeText(requireContext(), "UPS :( DRAW!", Toast.LENGTH_LONG).show()
        }

    }

    private fun disableButtons() {

        binding.button1.isEnabled = false
        binding.button2.isEnabled = false
        binding.button3.isEnabled = false
        binding.button4.isEnabled = false
        binding.button5.isEnabled = false
        binding.button6.isEnabled = false
        binding.button7.isEnabled = false
        binding.button8.isEnabled = false
        binding.button9.isEnabled = false
        binding.button10.isEnabled = false
        binding.button11.isEnabled = false
        binding.button12.isEnabled = false
        binding.button13.isEnabled = false
        binding.button14.isEnabled = false
        binding.button15.isEnabled = false
        binding.button16.isEnabled = false

    }

    private fun enableButtons() {
        binding.button1.isEnabled = true
        binding.button2.isEnabled = true
        binding.button3.isEnabled = true
        binding.button4.isEnabled = true
        binding.button5.isEnabled = true
        binding.button6.isEnabled = true
        binding.button7.isEnabled = true
        binding.button8.isEnabled = true
        binding.button9.isEnabled = true
        binding.button10.isEnabled = true
        binding.button11.isEnabled = true
        binding.button12.isEnabled = true
        binding.button13.isEnabled = true
        binding.button14.isEnabled = true
        binding.button15.isEnabled = true
        binding.button16.isEnabled = true
    }

    private fun resetButton() {
        firstPlayer.clear()
        secondPlayer.clear()
        activePlayer = 1
        enableButtons()
        resetText()
        resetCounter()
    }

    private fun resetText() {

        binding.button1.text = ""
        binding.button2.text = ""
        binding.button3.text = ""
        binding.button4.text = ""
        binding.button5.text = ""
        binding.button6.text = ""
        binding.button7.text = ""
        binding.button8.text = ""
        binding.button9.text = ""
        binding.button10.text = ""
        binding.button11.text = ""
        binding.button12.text = ""
        binding.button13.text = ""
        binding.button14.text = ""
        binding.button15.text = ""
        binding.button16.text = ""

    }

    private fun resetCounter() {
        clickCounter = 0
    }

}