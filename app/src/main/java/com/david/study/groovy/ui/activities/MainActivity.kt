package com.david.study.groovy.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.david.study.groovy.R
import com.david.study.groovy.ui.fragments.PlaylistsFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.main_activity_container, PlaylistsFragment.newInstance())
            .commit()
    }
}