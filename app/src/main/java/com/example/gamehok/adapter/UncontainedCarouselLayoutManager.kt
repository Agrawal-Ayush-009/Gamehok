package com.example.gamehok.adapter

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class UncontainedCarouselLayoutManager(context: Context) : LinearLayoutManager(context, HORIZONTAL, false) {

    override fun scrollHorizontallyBy(dx: Int, recycler: RecyclerView.Recycler?, state: RecyclerView.State?): Int {
        val scrolled = super.scrollHorizontallyBy(dx, recycler, state)
        offsetChildrenHorizontal(-dx)
        layoutDecoratedItems(recycler)
        return scrolled
    }

    private fun layoutDecoratedItems(recycler: RecyclerView.Recycler?) {
        val parentWidth = width
        var startLeft = 0

        for (i in 0 until childCount) {
            val child = getChildAt(i) ?: continue
            measureChildWithMargins(child, 0, 0)
            val width = getDecoratedMeasuredWidth(child)
            val height = getDecoratedMeasuredHeight(child)

            layoutDecoratedWithMargins(child, startLeft, 0, startLeft + width, height)
            startLeft += width
        }
    }

    override fun generateDefaultLayoutParams(): RecyclerView.LayoutParams {
        return RecyclerView.LayoutParams(
            RecyclerView.LayoutParams.WRAP_CONTENT,
            RecyclerView.LayoutParams.WRAP_CONTENT
        )
    }
}
