/*
 * Copyright 2018 Shazam Entertainment Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 */

package com.shazam.gwen.sample.asserters

import android.support.test.InstrumentationRegistry.getInstrumentation
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import com.shazam.gwen.sample.R
import org.hamcrest.core.AllOf

object SeesAssertions {

    fun loggedOut() {
        val instrumentation = getInstrumentation()
        val expectedText = instrumentation.targetContext.getString(R.string.is_logged_in, "false")
        onView(AllOf.allOf(withId(R.id.label), withText(expectedText))).perform(ViewActions.click())
    }

    fun loggedIn() {
        val instrumentation = getInstrumentation()
        val expectedText = instrumentation.targetContext.getString(R.string.is_logged_in, "true")
        onView(AllOf.allOf(withId(R.id.label), withText(expectedText))).perform(ViewActions.click())
    }
}
