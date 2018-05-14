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

import android.content.Intent
import android.preference.PreferenceManager.getDefaultSharedPreferences
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.runner.AndroidJUnit4
import com.shazam.gwen.sample.MainActivity.Companion.IS_LOGGED_IN_PREF_KEY
import org.hamcrest.core.AllOf
import org.hamcrest.core.AllOf.allOf
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RawEspressoLoginTest {

    @Test
    fun logsInWhenUserSelectsLogin() {
        val instrumentation = InstrumentationRegistry.getInstrumentation()
        getDefaultSharedPreferences(instrumentation.targetContext.applicationContext).edit().apply {
            putBoolean(IS_LOGGED_IN_PREF_KEY, false)
            commit()
        }

        val intent = Intent(instrumentation.targetContext, MainActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        instrumentation.startActivitySync(intent)

        onView(allOf(withId(R.id.login_button), withText(R.string.login))).perform(click())

        val expectedText = instrumentation.targetContext.getString(R.string.is_logged_in, "true")
        onView(AllOf.allOf(withId(R.id.label), withText(expectedText))).perform(ViewActions.click())
    }
}