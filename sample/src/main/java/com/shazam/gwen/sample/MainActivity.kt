/*
 * Copyright 2018 Shazam Entertainment Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 */

package com.shazam.gwen.sample

import android.os.Bundle
import android.preference.PreferenceManager.getDefaultSharedPreferences
import android.support.v7.app.AppCompatActivity
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val preferences by lazy {
        getDefaultSharedPreferences(applicationContext)
    }

    private var isLoggedIn
        get() = preferences.getBoolean(IS_LOGGED_IN_PREF_KEY, false)
        set(value) {
            preferences.edit().apply {
                putBoolean(IS_LOGGED_IN_PREF_KEY, value)
                commit()
            }
        }

    private val button by lazy {
        findViewById<TextView>(R.id.login_button)
    }

    private val label by lazy {
        findViewById<TextView>(R.id.label)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            isLoggedIn = !isLoggedIn
            updateUi()
        }

        updateUi()
    }

    private fun updateUi() {
        button.text = if (isLoggedIn) getString(R.string.logout) else getString(R.string.login)
        label.text = getString(R.string.is_logged_in, isLoggedIn.toString())
    }

    companion object {
        const val IS_LOGGED_IN_PREF_KEY = "com.shazam.gwen.sample.IS_LOGGED_IN"
    }
}
