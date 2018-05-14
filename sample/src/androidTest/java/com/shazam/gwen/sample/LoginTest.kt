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

import android.support.test.runner.AndroidJUnit4
import com.shazam.gwen.given
import com.shazam.gwen.sample.actors.has
import com.shazam.gwen.sample.actors.launches
import com.shazam.gwen.sample.actors.sees
import com.shazam.gwen.sample.actors.selects
import com.shazam.gwen.sample.actors.user
import com.shazam.gwen.then
import com.shazam.gwen.whenever
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginTest {
    @Test
    fun logsInWhenUserSelectsLogin() {
        given {
            user has { loggedOut() }
        } whenever {
            user launches {
                app()
            }
            user selects { login() }
        } then {
            user sees { loggedIn() }
        }
    }

    @Test
    fun logsOutWhenUserSelectsLogout() {
        given {
            user has { loggedIn() }
        } whenever {
            user launches {
                app()
            } selects {
                logout()
            }
        } then {
            user sees { loggedOut() }
        }
    }
}
