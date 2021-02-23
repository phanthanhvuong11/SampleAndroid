package com.example.ailatrieuphu

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var mListQuestion = mutableListOf<Question>()
    private var currentQuestion = 0
    private lateinit var mQuestion: Question
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mListQuestion = getListQuestion()
        if (mListQuestion.isEmpty()) {
            return
        }
        setDataQuestion(mListQuestion[currentQuestion])
    }

    private fun setDataQuestion(question: Question) {
        tvAnswerOne.setBackgroundResource(R.drawable.bg_blue_conner_30)
        tvAnswerTrue.setBackgroundResource(R.drawable.bg_blue_conner_30)
        tvAnswerThree.setBackgroundResource(R.drawable.bg_blue_conner_30)
        tvAnswerFour.setBackgroundResource(R.drawable.bg_blue_conner_30)
        mQuestion = question
        val titleQuestion = "Question ${question.number}"
        tvQuestion.text = titleQuestion
        tvContentQuestion.text = question.content
        tvAnswerOne.text = question.mutableList[0].content
        tvAnswerTrue.text = question.mutableList[1].content
        tvAnswerThree.text = question.mutableList[2].content
        tvAnswerFour.text = question.mutableList[3].content

        tvAnswerOne.setOnClickListener(this)
        tvAnswerTrue.setOnClickListener(this)
        tvAnswerThree.setOnClickListener(this)
        tvAnswerFour.setOnClickListener(this)
    }

    private fun getListQuestion(): MutableList<Question> {
        val mutableListQuestion: MutableList<Question> = mutableListOf()
        val mutableListAnswer1: MutableList<Answer> = mutableListOf()
        mutableListAnswer1.add(Answer("Gà", true))
        mutableListAnswer1.add(Answer("Cá", false))
        mutableListAnswer1.add(Answer("Bò", false))
        mutableListAnswer1.add(Answer("Chó", false))

        val mutableListAnswer2: MutableList<Answer> = mutableListOf()
        mutableListAnswer2.add(Answer("Cà", false))
        mutableListAnswer2.add(Answer("Đá", true))
        mutableListAnswer2.add(Answer("Gối", false))
        mutableListAnswer2.add(Answer("Nước", false))

        val mutableListAnswer3: MutableList<Answer> = mutableListOf()
        mutableListAnswer3.add(Answer("Hồ Chí Minh", false))
        mutableListAnswer3.add(Answer("Đà Nẵng", false))
        mutableListAnswer3.add(Answer("Hà nội", true))
        mutableListAnswer3.add(Answer("Hải Phòng", false))

        mutableListQuestion.add(Question(1, "Con nào là gia cầm?", mutableListAnswer1))
        mutableListQuestion.add(Question(2, "Chân cứng,.. mềm", mutableListAnswer2))
        mutableListQuestion.add(Question(3, "Thủ đô của Việt Nam là?", mutableListAnswer3))
        return mutableListQuestion
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tvAnswerOne -> {
                tvAnswerOne.setBackgroundResource(R.drawable.bg_orange_conner_30)
                checkAnswer(tvAnswerOne, mQuestion, mQuestion.mutableList[0])
            }
            R.id.tvAnswerTrue -> {
                tvAnswerTrue.setBackgroundResource(R.drawable.bg_orange_conner_30)
                checkAnswer(tvAnswerTrue, mQuestion, mQuestion.mutableList[1])
            }
            R.id.tvAnswerThree -> {
                tvAnswerThree.setBackgroundResource(R.drawable.bg_orange_conner_30)
                checkAnswer(tvAnswerThree, mQuestion, mQuestion.mutableList[2])
            }
            R.id.tvAnswerFour -> {
                tvAnswerFour.setBackgroundResource(R.drawable.bg_orange_conner_30)
                checkAnswer(tvAnswerFour, mQuestion, mQuestion.mutableList[3])
            }
        }
    }

    private fun checkAnswer(textView: TextView, question: Question, answer: Answer) {
        Handler().postDelayed({
            if (answer.isCorrect) {
                textView.setBackgroundResource(R.drawable.bg_green_conner_30)
                nextQuestion()
            } else {
                textView.setBackgroundResource(R.drawable.bg_red_conner_30)
                showAnswerCorrect(question)
                gameOver()
            }
        }, 1000)
    }

    private fun gameOver() {
        Handler().postDelayed({
            showDialog("Game Over")
        }, 1000)
    }

    private fun showAnswerCorrect(question: Question) {
        if (question.mutableList.isEmpty()) {
            return
        }
        when {
            question.mutableList[0].isCorrect -> {
                tvAnswerOne.setBackgroundResource(R.drawable.bg_green_conner_30)
            }
            question.mutableList[1].isCorrect -> {
                tvAnswerTrue.setBackgroundResource(R.drawable.bg_green_conner_30)
            }
            question.mutableList[2].isCorrect -> {
                tvAnswerThree.setBackgroundResource(R.drawable.bg_green_conner_30)
            }
            question.mutableList[3].isCorrect -> {
                tvAnswerFour.setBackgroundResource(R.drawable.bg_green_conner_30)
            }
        }
    }

    private fun nextQuestion() {
        if (currentQuestion == mListQuestion.size - 1) {
            showDialog("You Win")
        } else {
            currentQuestion++
            Handler().postDelayed({
                setDataQuestion(mListQuestion[currentQuestion])
            }, 1000)
        }
    }

    private fun showDialog(string: String) {
        AlertDialog.Builder(this).apply {
            setMessage(string)
            setCancelable(false)
            setPositiveButton("Yes") { dialog, _ ->
                currentQuestion = 0
                setDataQuestion(mListQuestion[currentQuestion])
                dialog?.dismiss()
            }
        }.create().show()

    }
}