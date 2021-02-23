package com.example.addtocart.addtocart

import android.graphics.Bitmap
import android.view.View
import android.view.animation.*
import android.widget.ImageView

class AnimationUtils {
    companion object {
        private const val ANIMATION_DURATION = 1000
    }

    private var isAnimationStart: Boolean = false
    @Suppress("DEPRECATION")
    fun translateAnimation(
        viewAnimation: ImageView,
        startView: View,
        endView: View,
        animation: Animation.AnimationListener
    ) {
        startView.isDrawingCacheEnabled = true
        val cache: Bitmap = startView.drawingCache
        val bitmap = Bitmap.createBitmap(cache)
        startView.isDrawingCacheEnabled = false

        viewAnimation.setImageBitmap(bitmap)
        val startViewWidthCenter: Double = (startView.width / 2.0)
        val startViewHeightCenter = startView.height / 2.0

        val endViewWidthCenter: Double = endView.width / 0.75
        val endViewHeightCenter = endView.height / 2.0

        val startPos = IntArray(2)
        startView.getLocationOnScreen(startPos)

        val endPos = IntArray(2)
        endView.getLocationOnScreen(endPos)

        val fromX = startPos[0]
        val toX = endPos[0] + endViewWidthCenter - startViewWidthCenter
        val fromY = startPos[1] - startViewHeightCenter
        val toY = endPos[1] - endViewHeightCenter + startViewHeightCenter

        val animationSet = AnimationSet(true)
        animationSet.interpolator = AccelerateInterpolator()

        val animationDuration = 200
        val startScaleAnimation = ScaleAnimation(
            1.0f, 1.5f, 1.0f, 1.5f,
            startViewWidthCenter.toFloat(), startViewHeightCenter.toFloat()
        )
        startScaleAnimation.duration = animationDuration.toLong()

        val translateAnimation =
            TranslateAnimation(fromX.toFloat(), toX.toFloat(), fromY.toFloat(), toY.toFloat())
        translateAnimation.startOffset = animationDuration.toLong()
        translateAnimation.duration = ANIMATION_DURATION.toLong()

        val translateScaleAnimation =
            ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, toX.toFloat(), toY.toFloat())
        translateScaleAnimation.startOffset = animationDuration.toLong()
        translateScaleAnimation.duration = ANIMATION_DURATION.toLong()


        animationSet.addAnimation(startScaleAnimation)
        animationSet.addAnimation(translateAnimation)
        animationSet.addAnimation(translateScaleAnimation)
        if (isAnimationStart) {
            viewAnimation.clearAnimation()
            animation.onAnimationEnd(null)
        }
        viewAnimation.startAnimation(animationSet)
        animationSet.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation1: Animation?) {
                isAnimationStart = true
                viewAnimation.visibility = View.VISIBLE
                startView.visibility = View.INVISIBLE

                animation.onAnimationStart(animation1)
            }

            override fun onAnimationEnd(animation1: Animation?) {
                viewAnimation.visibility = View.GONE
                startView.visibility = View.VISIBLE
                animation.onAnimationEnd(animation1)
                isAnimationStart = false
            }

            override fun onAnimationRepeat(animation1: Animation?) {
                animation.onAnimationRepeat(animation1)
            }

        })
    }
}