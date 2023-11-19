package com.example.theme

import android.content.Intent
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.CompoundButton
import android.widget.ImageButton
import android.widget.Switch
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : AppCompatActivity() {
    private var status: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    var mStartForResult: ActivityResultLauncher<Intent?>? =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result -> if (result.resultCode == RESULT_OK){
            val intent: Intent? = result.data
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    fun Theme(view: View) {
        val sw: Switch = findViewById(R.id.switch1)
        if (sw.isChecked) AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        else AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val sw: Switch = findViewById(R.id.switch1)
        when(item.itemId){
            R.id.theme -> {

                 if (sw.isChecked == false) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    sw.isChecked = true
                }

                 else if (sw.isChecked == true){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    sw.isChecked = false
                }
                item.setIcon(R.drawable.ic_launcher_foreground)
            }
            R.id.about -> {
                val intent: Intent = Intent(this@MainActivity, About::class.java)
                mStartForResult?.launch(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

}

