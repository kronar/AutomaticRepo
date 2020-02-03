package ru.sportmaster.app.activity.C523912


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.scrollTo
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.schibsted.spain.barista.assertion.BaristaFocusedAssertions.assertNotFocused
import com.schibsted.spain.barista.assertion.BaristaListAssertions.assertListNotEmpty
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertDisplayed
import com.schibsted.spain.barista.interaction.BaristaScrollInteractions
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.sportmaster.app.R
import ru.sportmaster.app.activity.MainActivity

@LargeTest
@RunWith(AndroidJUnit4::class)
class S6 {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun s6() {
//        val appCompatImageButton = onView(
//                allOf(withId(R.id.btnClose),
//                        childAtPosition(
//                                allOf(withId(R.id.root),
//                                        childAtPosition(
//                                                withId(android.R.id.content),
//                                                0)),
//                                3),
//                        isDisplayed()))
//        appCompatImageButton.perform(click())

        BaristaScrollInteractions.safelyScrollTo(R.id.actionsPager);

        val imageView = onView(
                allOf(withId(R.id.image),
                        childAtPosition(
                                allOf(withId(R.id.bannersRecycler),
                                        childAtPosition(
                                                IsInstanceOf.instanceOf(android.widget.RelativeLayout::class.java),
                                                0)),
                                0),
                        isDisplayed()))
        imageView.check(matches(isDisplayed()))

        assertNotFocused(R.id.indicator)
        
    }

    private fun childAtPosition(
            parentMatcher: Matcher<View>, position: Int): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

             override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
