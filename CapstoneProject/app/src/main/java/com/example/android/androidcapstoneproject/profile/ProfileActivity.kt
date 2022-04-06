package com.example.android.androidcapstoneproject.profile

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.example.android.androidcapstoneproject.R
import com.google.firebase.auth.FirebaseAuth

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.main_menu, menu)
//        return super.onCreateOptionsMenu(menu)
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        val navHostFragment =
//            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container)
//                    as NavHostFragment
//        val navController = navHostFragment.navController
//
//        when(item.itemId){
//            R.id.logout -> {
//                FirebaseAuth.getInstance().signOut()
//                navController.popBackStack() // TODO: navigate back to authFragment
//                //Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show()
//                return true
//            }
//        }
//
//        return super.onOptionsItemSelected(item)
//    }
}