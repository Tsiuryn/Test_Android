package com.example.testproject.cardView

import android.animation.PropertyValuesHolder
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.text.Html
import android.text.method.LinkMovementMethod
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import com.example.testproject.R

internal class ExpandableCard : CardView {

    private val vTitle: TextView by bindView(R.id.vTitle)
    private val vBody: LinearLayout by bindView(R.id.vBody)
    private val vArrow: ImageView by bindView(R.id.vArrow)

    private val expandDuration = 200L
    private var isCollapsed = false

    @JvmOverloads
    constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
            : super(context) {
        init()
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int)
            : super(context) {
        init()
    }

    @SuppressLint("Recycle", "ResourceType")
    private fun init() {
        LayoutInflater.from(context).inflate(R.layout.expandable_card_view, this, true)
        setUpCardView()
        listenerClick()
        this.apply {
            radius = 16f
        }
        if (isCollapsed) expand(false) else collapse(false)
    }

    var textTitle: String? = null
    set(value) {
        field = value
        if(!value.isNullOrBlank()){
            vTitle.text = value
        }
    }

    /**
     * Formatting elements were designed to display special types of text:
     * <b> - Bold text
     * <strong> - Important text
     * <i> - Italic text
     * <em> - Emphasized text
     * <mark> - Marked text
     * <small> - Smaller text
     * <del> - Deleted text
     * <ins> - Inserted text
     * <sub> - Subscript text
     * <sup> - Superscript text
     */
    private fun setUpCardView() {
        val textView = TextView(context).apply {
            text =
                Html.fromHtml("Click <a href=\"http://www.google.com\">here</a> to <b>switch</b> <del>on</del> the <i>red light</i>.")
            textSize = 55f
        }
        textView.movementMethod = LinkMovementMethod.getInstance()
        vBody.addView(textView)


    }

    private fun listenerClick() {
        vArrow.setOnClickListener {
            if (isCollapsed) expand(true) else collapse(true)
        }
    }

    private fun collapse(animate: Boolean) {
        if (isCollapsed) return

        setHeightToZero(animate)
        rotateArrow(0f, animate)
        isCollapsed = true
    }

    private fun expand(animate: Boolean) {
        if (!isCollapsed) return

        setHeightToContentHeight(animate)
        rotateArrow(180f, animate)
        isCollapsed = false
    }

    private fun rotateArrow(rotation: Float, animate: Boolean) {
        ViewCompat.animate(vArrow)
            .rotation(rotation)
            .withLayer()
            .setDuration(if (animate) expandDuration else 0)
            .start()
    }

    private fun setHeightToContentHeight(animate: Boolean) {
        measureContentView()
        val targetHeight = vBody.measuredHeight
        if (animate) {
            animate(0, targetHeight)
        } else {
            setContentHeight(targetHeight)
        }
    }

    private fun setHeightToZero(animate: Boolean) {
        if (animate) {
            animate(vBody.height, 0)
        } else {
            setContentHeight(0)
        }
    }

    private fun setContentHeight(height: Int) {
        vBody.layoutParams.height = height
        vBody.requestLayout()
    }

    private fun measureContentView() {
        val widthMS = MeasureSpec.makeMeasureSpec(width, MeasureSpec.AT_MOST)
        val heightMS = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED)
        vBody.measure(widthMS, heightMS)
    }

    private fun animate(from: Int, to: Int) {
        val valuesHolder: PropertyValuesHolder = PropertyValuesHolder.ofInt("prop", from, to)

        val animator = ValueAnimator.ofPropertyValuesHolder(valuesHolder)
        animator.duration = expandDuration
        animator.addUpdateListener {
            val value = animator.getAnimatedValue("prop") as Int? ?: 0
            vBody.layoutParams.height = value
            vBody.requestLayout()
            invalidate()
        }
        animator.start()
    }
}