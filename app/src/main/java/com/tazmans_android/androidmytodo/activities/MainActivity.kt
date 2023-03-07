package com.tazmans_android.androidmytodo.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.tazmans_android.androidmytodo.R
import com.tazmans_android.androidmytodo.databinding.ActivityMainBinding
import com.tazmans_android.androidmytodo.fragments.HomeFragment
import com.tazmans_android.androidmytodo.fragments.TodoItemInfoFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onMenuClick()
        setFragment(HomeFragment.newInstance(), this)
    }

    private fun onMenuClick() {
        binding.bNavigation.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.id_home -> {
                    setFragment(HomeFragment.newInstance(), this)
                }
                R.id.id_new -> {
                    setFragment(TodoItemInfoFragment.newInstance(), this)
                }
            }
            true
        }
    }

    private fun setFragment(newFrag: Fragment, activity: AppCompatActivity) {
        val transition = activity.supportFragmentManager.beginTransaction()
        transition.replace(R.id.placeHolder, newFrag)
        transition.commit()
    }


}