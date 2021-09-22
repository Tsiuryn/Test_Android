package com.example.testproject.themes

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.testproject.R
import com.google.android.material.switchmaterial.SwitchMaterial
import java.util.*


class ThemesActivity : AppCompatActivity() {

    companion object{
        const val key = "MY_KEY"
    }

    private lateinit var vDayNight: SwitchMaterial
    private lateinit var vLocale: SwitchMaterial
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_themes)
        vDayNight = findViewById(R.id.vDayNight)
        vLocale = findViewById(R.id.vLocale)
        vDayNight.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
        val isChecked = intent.extras?.getBoolean(key)
        if(isChecked != null){
            vLocale.isChecked = isChecked
        }
        val intent = Intent(this, ThemesActivity::class.java)

        vLocale.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                setLocale("ru")
                finish()
            }else{
                setLocale("en")
                finish()


            }
            intent.putExtra(key, isChecked)
            startActivity(intent)
        }
    }

    private fun setLocale( languageCode: String) {
        val locale = Locale(languageCode)
        Locale.setDefault(locale)
        val config: Configuration = resources.configuration
        config.setLocale(locale)
        resources.updateConfiguration(config, resources.displayMetrics)
    }
}