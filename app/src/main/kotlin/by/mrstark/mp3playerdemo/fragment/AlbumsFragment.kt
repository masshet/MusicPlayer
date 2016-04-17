package by.mrstark.mp3playerdemo.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import by.mrstark.mp3playerdemo.R
import by.mrstark.mp3playerdemo.entity.Album
import java.util.*

/**
 * Created by mrstark on 27.1.16.
 */
class AlbumsFragment() : AbstractTabFragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater?.inflate(LAYOUT, container, false)
        return root
    }

    fun setContext(context: Context) {
        this.context = context
    }

    companion object {

        private val LAYOUT = R.layout.fragment_example

        fun getInstance(context: Context): AlbumsFragment {
            val fragment = AlbumsFragment()
            fragment.setContext(context)
            fragment.title = context.getString(R.string.tab_item_albums)
            return fragment
        }
    }
}
