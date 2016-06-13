package by.mrstark.mp3playerdemo.entity

import android.media.MediaMetadataRetriever
import android.os.Parcel
import android.os.Parcelable
import java.io.File

class Song() : Parcelable {

    var title: String = ""
    var artist: String? = ""
    var album: String? = ""
    var genre: String? = ""
    var albumArt: ByteArray? = null
    var path: String = ""

    constructor(source: Parcel?) : this() {
        readParcel(source)
    }

    constructor(file: File?) : this() {
        readFile(file)
    }

    private fun readFile(file: File?) {
        val retriever = MediaMetadataRetriever()
        retriever.setDataSource(file?.absolutePath)
        title = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE)
        artist = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST)
        album = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUM)
        genre = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_GENRE)
        albumArt = retriever.embeddedPicture
        path = file?.absolutePath!!
    }

    private fun readParcel(source: Parcel?) {
        title = source?.readString()!!
        artist = source?.readString()!!
        album = source?.readString()!!
        genre = source?.readString()!!
        source?.readByteArray(albumArt)
        path = source?.readString()!!
    }

    companion object {
        @JvmField final val CREATOR: Parcelable.Creator<Song> = object : Parcelable.Creator<Song> {
            override fun createFromParcel(source: Parcel?): Song? {
                return Song(source)
            }

            override fun newArray(size: Int): Array<Song?> {
                return arrayOfNulls<Song?>(size)
            }

        }
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(title)
        dest?.writeString(artist)
        dest?.writeString(album)
        dest?.writeString(genre)
        dest?.writeByteArray(albumArt)
        dest?.writeString(path)
    }

    override fun describeContents(): Int {
        return 0
    }
}