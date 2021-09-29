package uz.dastyor.arzonkassa

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*
import uz.dastyor.arzonkassa.Fragment.MainFragment

class MainActivity : AppCompatActivity() {
    @SuppressLint("RestrictedApi")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        changeFragment(MainFragment())
        setSupportActionBar(toolbar)
        val drawerToggle = ActionBarDrawerToggle(
            this,
            drawer_layout,
            R.string.open,
            R.string.close
        )
        supportActionBar?.setDefaultDisplayHomeAsUpEnabled(false)
        drawerToggle.isDrawerIndicatorEnabled = false;
        drawerToggle.syncState()
        ic_menu.setOnClickListener {
            drawer_layout.openDrawer(GravityCompat.START);
        }


        nav_view.setNavigationItemSelectedListener { menuItem ->
            drawer_layout.closeDrawers()
            when (menuItem.itemId) {
                R.id.home -> {
                    changeFragment(MainFragment())
                }
            }
            true
        }
    }

    fun changeFragment(fr: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame, fr)
            .commit()
    }
}