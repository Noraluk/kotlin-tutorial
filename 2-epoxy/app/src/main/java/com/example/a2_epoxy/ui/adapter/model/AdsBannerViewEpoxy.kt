package com.example.a2_epoxy.ui.adapter.model

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.epoxy.ModelView
import com.example.a2_epoxy.R

@ModelView(defaultLayout = R.layout.banner_view)
class AdsBannerViewEpoxy @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {}