package inc.ahmedmourad.cinematics.callbacks

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View

interface ClickListener {

    fun onClick(view: View, position: Int)

    fun onLongClick(view: View, position: Int)
}

class RecyclerTouchListener(context: Context, recyclerView: RecyclerView, private val clickListener: ClickListener?) : RecyclerView.OnItemTouchListener {

    private val gestureDetector: GestureDetector

    init {

        gestureDetector = GestureDetector(context, object : GestureDetector.SimpleOnGestureListener() {

            override fun onSingleTapUp(e: MotionEvent): Boolean {

                return true
            }

            override fun onLongPress(e: MotionEvent) {

                val child = recyclerView.findChildViewUnder(e.x, e.y)

                if (child != null)
                    clickListener?.onLongClick(child, recyclerView.getChildAdapterPosition(child))
            }
        })
    }

    override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {

        val child = rv.findChildViewUnder(e.x, e.y)

        if (child != null && gestureDetector.onTouchEvent(e))
            clickListener?.onClick(child, rv.getChildAdapterPosition(child))

        return false
    }

    override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {

    }

    override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {

    }
}