package by.mrstark.mp3playerdemo.fragment

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.RecyclerView

import by.mrstark.mp3playerdemo.MainActivity
import by.mrstark.mp3playerdemo.R
import by.mrstark.mp3playerdemo.adapter.SongsListAdapter
import by.mrstark.mp3playerdemo.entity.Song
import by.mrstark.mp3playerdemo.util.DataUtil

class SongsFragment : AbstractTabFragment() {
    interface OnSongSelectedInterface {
        fun onListSongSelected(index: Int, songs: List<Song>)
    }

    private fun setSongs(bundle: Bundle?): List<Song> {
        if (bundle != null) {
            val albumName = bundle.getString((activity as MainActivity).ALBUM)
            return DataUtil.getInstace().songs.filter { it.album.equals(albumName) }
        } else {
            return DataUtil.getInstace().songs
        }
    }

    override fun getAdapter(): RecyclerView.Adapter<RecyclerView.ViewHolder> {
        val listener = activity as OnSongSelectedInterface
        val songsListAdapter = SongsListAdapter(listener, setSongs(arguments))
        return songsListAdapter
    }

    fun getInstance(context: Context): SongsFragment {
        this.title = context.getString(R.string.tab_item_songs)
        return this
    }
}
