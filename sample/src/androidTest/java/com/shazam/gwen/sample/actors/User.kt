/*
 * Copyright 2018 Shazam Entertainment Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 */

package com.shazam.gwen.sample.actors

import com.shazam.gwen.Actor
import com.shazam.gwen.Arranger
import com.shazam.gwen.Asserter
import com.shazam.gwen.sample.actions.HasActions
import com.shazam.gwen.sample.actions.LaunchesActions
import com.shazam.gwen.sample.actions.SelectsActions
import com.shazam.gwen.sample.asserters.SeesAssertions

object User

val Arranger.user: User
    get() = User

val Actor.user: User
    get() = User

val Asserter.user: User
    get() = User

infix fun User.has(block: HasActions.() -> Unit): User {
    block.invoke(HasActions)
    return this
}

infix fun User.launches(block: LaunchesActions.() -> Unit): User {
    block.invoke(LaunchesActions)
    return this
}

infix fun User.selects(block: SelectsActions.() -> Unit): User {
    block.invoke(SelectsActions)
    return this
}

infix fun User.sees(block: SeesAssertions.() -> Unit): User {
    block.invoke(SeesAssertions)
    return this
}
