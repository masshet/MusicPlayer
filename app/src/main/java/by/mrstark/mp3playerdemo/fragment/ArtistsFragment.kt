package by.mrstark.mp3playerdemo.fragment

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.mrstark.mp3playerdemo.MainActivity

import by.mrstark.mp3playerdemo.R
import by.mrstark.mp3playerdemo.adapter.ArtistsListAdapter
import by.mrstark.mp3playerdemo.entity.Artist
import by.mrstark.mp3playerdemo.util.DataUtil

class ArtistsFragment : AbstractTabFragment() {
    interface OnArtistSelectedInterface {
        fun onArtistSelect(name: String)
    }

    override fun getAdapter(): RecyclerView.Adapter<RecyclerView.ViewHolder> {
        val listener = activity as OnArtistSelectedInterface
        return ArtistsListAdapter(listener, getArtists(arguments))
    }

    private fun getArtists(arguments: Bundle?): List<Artist>? {
        if (arguments != null) {
            val genreName = arguments.getString((activity as MainActivity).GENRE)
            return DataUtil.getInstace().artists.filter { it.getGenre().equals(genreName) }
        } else {
            return DataUtil.getInstace().artists
        }
    }

    fun getInstance(context: Context): ArtistsFragment {
        this.context = context
        this.title = context.getString(R.string.tab_item_artists)
        return this
    }
}
