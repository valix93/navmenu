package it.valix93.sample

import android.graphics.Typeface
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        private const val ID_HOME = 1
        private const val ID_EXPLORE = 2
        private const val ID_MESSAGE = 3
        private const val ID_NOTIFICATION = 4
        private const val ID_ACCOUNT = 5
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_selected.typeface = Typeface.createFromAsset(assets, "fonts/SourceSansPro-Regular.ttf")

        bottomNavigation.add(MeowBottomNavigation.Model(ID_HOME, R.drawable.ic_home))
        bottomNavigation.add(MeowBottomNavigation.Model(ID_EXPLORE, R.drawable.ic_explore))
        bottomNavigation.add(MeowBottomNavigation.Model(ID_MESSAGE, R.drawable.ic_message))
        bottomNavigation.add(MeowBottomNavigation.Model(ID_NOTIFICATION, R.drawable.ic_notification))
        bottomNavigation.add(MeowBottomNavigation.Model(ID_ACCOUNT, R.drawable.ic_account))

        bottomNavigation.setCount(ID_NOTIFICATION, "3")

        bottomNavigation.setOnShowListener {
            val name = when (it.id) {
                it.valix93.navmenu.MainActivity.Companion.ID_HOME -> "HOME"
                it.valix93.navmenu.MainActivity.Companion.ID_EXPLORE -> "EXPLORE"
                it.valix93.navmenu.MainActivity.Companion.ID_MESSAGE -> "MESSAGE"
                it.valix93.navmenu.MainActivity.Companion.ID_NOTIFICATION -> "NOTIFICATION"
                it.valix93.navmenu.MainActivity.Companion.ID_ACCOUNT -> "ACCOUNT"
                else -> ""
            }
            tv_selected.text = "$name page is selected"
        }

        bottomNavigation.setOnClickMenuListener {
            val name = when (it.id) {
                it.valix93.navmenu.MainActivity.Companion.ID_HOME -> "HOME"
                it.valix93.navmenu.MainActivity.Companion.ID_EXPLORE -> "EXPLORE"
                it.valix93.navmenu.MainActivity.Companion.ID_MESSAGE -> "MESSAGE"
                it.valix93.navmenu.MainActivity.Companion.ID_NOTIFICATION -> "NOTIFICATION"
                it.valix93.navmenu.MainActivity.Companion.ID_ACCOUNT -> "ACCOUNT"
                else -> ""
            }
//            Toast.makeText(this, "$name is clicked", Toast.LENGTH_SHORT).show()
        }
    }
}
