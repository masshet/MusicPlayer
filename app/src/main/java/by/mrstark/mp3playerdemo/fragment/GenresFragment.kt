package by.mrstark.mp3playerdemo.fragment

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import by.mrstark.mp3playerdemo.R
import by.mrstark.mp3playerdemo.adapter.GenresListAdapter

/**
 * Created by mrstark on 27.1.16.
 */
class GenresFragment : AbstractTabFragment() {
    interface OnGenreSelectedInterface {
        fun onGenreSelect(name: String)
    }

    override fun getAdapter(): RecyclerView.Adapter<RecyclerView.ViewHolder> {
        val listener = (activity as OnGenreSelectedInterface)
        return GenresListAdapter(listener)
    }

    fun getInstance(context: Context): GenresFragment {
        this.context = context
        this.title = context.getString(R.string.tab_item_genres)
        return this
    }
}
