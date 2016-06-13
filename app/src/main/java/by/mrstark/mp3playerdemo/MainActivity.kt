package by.mrstark.mp3playerdemo

import android.Manifest
import android.app.Fragment
import android.app.FragmentManager
import android.app.FragmentTransaction
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.widget.Toast
import by.mrstark.mp3playerdemo.entity.Album
import by.mrstark.mp3playerdemo.entity.Artist
import by.mrstark.mp3playerdemo.entity.Song
import by.mrstark.mp3playerdemo.fragment.*

class MainActivity : AppCompatActivity(), SongsFragment.OnSongSelectedInterface,
        AlbumsFragment.OnAlbumSelectedInterface, ArtistsFragment.OnArtistSelectedInterface, GenresFragment.OnGenreSelectedInterface{
    val MY_LIBRARY = "my_library"

    val LISTEN_NOW = "listen_now"

    val ALBUM = "album"

    val ARTIST = "artist"
    val ABOUT = "about"
    val GENRE = "genre"
    private var listenNowFragment: ListenNowFragment? = null
    private var myLibraryFragment: MyLibraryFragment? = null

    private var aboutFragment: AboutFragment? = null
    private var manager: FragmentManager? = null
    private var transaction: FragmentTransaction? = null
    private var toolbar: Toolbar? = null
    private var layout: DrawerLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        manager = fragmentManager

        initToolbar()
        initNavigationView()

        if (savedInstanceState == null) {
            loadFragment()
        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), 1)
        }
    }

    override fun onBackPressed() {
        val count = fragmentManager.backStackEntryCount
        if (count == 0) {
            super.onBackPressed()
        } else {
            fragmentManager.popBackStack()
        }
    }

    fun loadFragment() {
        listenNowFragment = ListenNowFragment.getInstance(this)
        aboutFragment = AboutFragment.getInstance(this)
        myLibraryFragment = MyLibraryFragment.getInstance(this)
        transaction = manager!!.beginTransaction()
        transaction!!.add(R.id.container, myLibraryFragment, MY_LIBRARY)
        transaction!!.commit()
    }

    private fun initToolbar() {
        toolbar = findViewById(R.id.toolbar) as Toolbar?
        toolbar!!.setTitle(R.string.my_library)
        toolbar!!.inflateMenu(R.menu.menu)
    }

    fun changeFragment(fragment: Fragment?, tag: String) {
        transaction = manager!!.beginTransaction()
        transaction!!.replace(R.id.container, fragment, tag)
        transaction!!.addToBackStack("")
        transaction!!.commit()
    }

    private fun initNavigationView() {
        layout = findViewById(R.id.drawer_layout) as DrawerLayout?

        val toggle = ActionBarDrawerToggle(this, layout, toolbar, R.string.view_navigation_open, R.string.view_navigation_close)
        layout!!.addDrawerListener(toggle)
        toggle.syncState()

        val navigationView = findViewById(R.id.navigation) as NavigationView?
        navigationView?.setNavigationItemSelectedListener { item ->
            layout!!.closeDrawers()
            when (item.itemId) {
                R.id.listen_now_menu_item -> {
                    toolbar!!.setTitle(R.string.listen_now)
                    changeFragment(listenNowFragment, LISTEN_NOW)
                }
                R.id.my_library_menu_item -> {
                    toolbar!!.setTitle(R.string.my_library)
                    changeFragment(myLibraryFragment, MY_LIBRARY)
                }
                R.id.about_menu_item -> {
                    toolbar!!.setTitle(R.string.about)
                    changeFragment(aboutFragment, ABOUT)
                }
                else -> {
                }
            }
            true
        }

    }

    override fun onListSongSelected(index: Int, songs: List<Song>) {
        Toast.makeText(applicationContext, songs[index].title, Toast.LENGTH_LONG).show()
    }

    override fun onAlbumSelect(name: String) {
        transaction = manager!!.beginTransaction()
        val bundle = Bundle()
        bundle.putString(ALBUM, name)
        val fragment = SongsFragment()
        fragment.arguments = bundle
        transaction!!.replace(R.id.container, fragment)
        transaction!!.addToBackStack("")
        transaction!!.commit()
    }

    override fun onArtistSelect(name: String) {
        transaction = manager!!.beginTransaction()
        val bundle = Bundle()
        bundle.putString(ARTIST, name)
        val fragment = AlbumsFragment()
        fragment.arguments = bundle
        transaction!!.replace(R.id.container, fragment)
        transaction!!.addToBackStack("")
        transaction!!.commit()
    }

    override fun onGenreSelect(name: String) {
        transaction = manager!!.beginTransaction()
        val bundle = Bundle()
        bundle.putString(GENRE, name)
        val fragment = ArtistsFragment()
        fragment.arguments = bundle
        transaction!!.replace(R.id.container, fragment)
        transaction!!.addToBackStack("")
        transaction!!.commit()
    }
}
