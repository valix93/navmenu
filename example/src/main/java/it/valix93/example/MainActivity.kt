package it.valix93.example

import android.graphics.Typeface
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import it.valix93.navmenu.BottomNavigation
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

        bottomNavigation.add(BottomNavigation.Model(ID_HOME, R.drawable.ic_home))
        bottomNavigation.add(BottomNavigation.Model(ID_EXPLORE, R.drawable.ic_explore))
        bottomNavigation.add(BottomNavigation.Model(ID_MESSAGE, R.drawable.ic_message))
        bottomNavigation.add(BottomNavigation.Model(ID_NOTIFICATION, R.drawable.ic_notification))
        bottomNavigation.add(BottomNavigation.Model(ID_ACCOUNT, R.drawable.ic_account))

        bottomNavigation.setCount(ID_NOTIFICATION, "3")

        bottomNavigation.setOnShowListener {
            val name = when (it.id) {
                ID_HOME -> "HOME"
                ID_EXPLORE -> "EXPLORE"
                ID_MESSAGE -> "MESSAGE"
                ID_NOTIFICATION -> "NOTIFICATION"
                ID_ACCOUNT -> "ACCOUNT"
                else -> ""
            }
            tv_selected.text = "$name page is selected"
        }

        bottomNavigation.setOnClickMenuListener {
            val name = when (it.id) {
                ID_HOME -> "HOME"
                ID_EXPLORE -> "EXPLORE"
                ID_MESSAGE -> "MESSAGE"
                ID_NOTIFICATION -> "NOTIFICATION"
                ID_ACCOUNT -> "ACCOUNT"
                else -> ""
            }
//            Toast.makeText(this, "$name is clicked", Toast.LENGTH_SHORT).show()
        }
    }
}
