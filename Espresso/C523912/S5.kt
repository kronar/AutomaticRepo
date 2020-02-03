package ru.sportmaster.app.activity.C523912


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions
import com.schibsted.spain.barista.interaction.BaristaScrollInteractions
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.sportmaster.app.R
import ru.sportmaster.app.activity.MainActivity

@LargeTest
@RunWith(AndroidJUnit4::class)
class S5 {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun s5() {
        
        BaristaScrollInteractions.scrollTo(R.id.collectionTitleImageView)
        
        val smLogoImageView = onView(
                allOf(withId(R.id.image),
                        childAtPosition(
                                allOf(withId(R.id.slider),
                                        childAtPosition(
                                                withClassName(`is`("android.widget.LinearLayout")),
                                                1)),
                                0),
                        isDisplayed()))
        smLogoImageView.perform(click())

        val appCompatImageButton2 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.toolbar),
                                childAtPosition(
                                        withId(R.id.appbar),
                                        0)),
                        0),
                        isDisplayed()))
        appCompatImageButton2.perform(click())

        val smLogoImageView2 = onView(
                allOf(withId(R.id.image),
                        childAtPosition(
                                allOf(withId(R.id.slider),
                                        childAtPosition(
                                                withClassName(`is`("android.widget.LinearLayout")),
                                                1)),
                                3),
                        isDisplayed()))
        smLogoImageView2.perform(click())

        val appCompatImageButton3 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.toolbar),
                                childAtPosition(
                                        withId(R.id.appbar),
                                        0)),
                        0),
                        isDisplayed()))
        appCompatImageButton3.perform(click())

        val appCompatTextView = onView(
                allOf(withId(R.id.showAllButton), withText("Показать все"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.headerView),
                                        0),
                                1),
                        isDisplayed()))
        appCompatTextView.perform(click())

        BaristaVisibilityAssertions.assertDisplayed("Бренды")
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
