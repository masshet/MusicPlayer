package by.mrstark.mp3playerdemo.fragment

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import by.mrstark.mp3playerdemo.MainActivity

import by.mrstark.mp3playerdemo.R
import by.mrstark.mp3playerdemo.adapter.AlbumsListAdapter
import by.mrstark.mp3playerdemo.entity.Album
import by.mrstark.mp3playerdemo.util.DataUtil

/**
 * Created by mrstark on 4/17/16.
 */
open class AlbumsFragment : AbstractTabFragment() {
    interface OnAlbumSelectedInterface {
        fun onAlbumSelect(name: String)
    }

    override fun getAdapter(): RecyclerView.Adapter<RecyclerView.ViewHolder> {
        val listener = activity as OnAlbumSelectedInterface
        return AlbumsListAdapter(listener, getAlbums(arguments))
    }

    fun getInstance(context: Context): AlbumsFragment {
        this.title = context.getString(R.string.tab_item_albums)
        return this
    }

    private fun getAlbums(bundle: Bundle?): List<Album> {
        if (bundle != null) {
            val artistName = bundle.getString((activity as MainActivity).ARTIST)
            return DataUtil.getInstace().albums.filter { it.artist.equals(artistName) }
        } else {
            return DataUtil.getInstace().albums
        }
    }
}
