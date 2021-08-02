package com.pesquiseme.hotmart.presentation.component.bottom_navigation_icon

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import com.pesquiseme.hotmart.R

class BottomNavigationIcon(context: Context?, attrs: AttributeSet?) : LinearLayout(context, attrs) {

    var iconSelectedRes : Drawable? = null
    var iconUnselectedRes : Drawable? = null

    var ivIcon : ImageView

    init {
        gravity = Gravity.CENTER

        val child = LayoutInflater.from(context).inflate(R.layout.component_bottom_navigation_icon, this, true)

        ivIcon = child.findViewWithTag("ivIcon")

        initializeAttrs(attrs)

        ivIcon.setImageDrawable(iconUnselectedRes)
    }

    fun initializeAttrs(attrs: AttributeSet?) {
        if (attrs != null) {
            val typedArray = context.obtainStyledAttributes(attrs, R.styleable.BottomNavigationIcon)
            iconSelectedRes = typedArray.getDrawable(R.styleable.BottomNavigationIcon_menuIconSelected)
            iconUnselectedRes = typedArray.getDrawable(R.styleable.BottomNavigationIcon_menuIconUnselected)
            typedArray.recycle()
        }
    }

    fun setChecked(checked: Boolean) {
        if (checked) {
            ivIcon.setImageDrawable(iconSelectedRes)
        } else {
            ivIcon.setImageDrawable(iconUnselectedRes)
        }
    }

}