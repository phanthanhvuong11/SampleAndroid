package com.example.testanimation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.ybq.android.spinkit.style.*
import kotlinx.android.synthetic.main.activity_progress_bar_custom.*

class ProgressBarCustom : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress_bar_custom)

        progressBar1.indeterminateDrawable = RotatingPlane()
        progressBar2.indeterminateDrawable = DoubleBounce()
        progressBar3.indeterminateDrawable = Wave()
        progressBar4.indeterminateDrawable = WanderingCubes()
        progressBar5.indeterminateDrawable = Pulse()
        progressBar6.indeterminateDrawable = ChasingDots()
        progressBar7.indeterminateDrawable = ThreeBounce()
        progressBar8.indeterminateDrawable = Circle()
        progressBar9.indeterminateDrawable = CubeGrid()
        progressBar10.indeterminateDrawable = FadingCircle()
        progressBar11.indeterminateDrawable = FoldingCube()
        progressBar12.indeterminateDrawable = RotatingCircle()
    }
}