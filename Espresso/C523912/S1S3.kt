package ru.sportmaster.app.activity.C523912


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.`is`
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
class S1S3 {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)


    @Test
    fun s1s3() {
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

        val appCompatImageButton2 = onView(
                allOf(withId(R.id.ibInfo),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(`is`("androidx.appcompat.widget.Toolbar")),
                                        0),
                                0),
                        isDisplayed()))
        appCompatImageButton2.perform(click())

        val appCompatImageButton3 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.toolbar),
                                childAtPosition(
                                        withId(R.id.infoAppBar),
                                        0)),
                        0),
                        isDisplayed()))
        appCompatImageButton3.perform(click())

        val imageView = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withClassName(`is`("androidx.appcompat.widget.Toolbar")),
                                0),
                        1),
                        isDisplayed()))
        imageView.check(matches(isDisplayed()))

        val linearLayout = onView(
                allOf(withId(R.id.indicator),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.slidesPager),
                                        0),
                                1),
                        isDisplayed()))
        linearLayout.check(matches(isDisplayed()))

        val imageView2 = onView(
                allOf(withId(R.id.image),
                        childAtPosition(
                                allOf(withId(R.id.bannersRecycler),
                                        childAtPosition(
                                                IsInstanceOf.instanceOf(android.widget.RelativeLayout::class.java),
                                                0)),
                                0),
                        isDisplayed()))
        imageView2.check(matches(isDisplayed()))

        val view = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.indicator),
                                childAtPosition(
                                        IsInstanceOf.instanceOf(android.widget.RelativeLayout::class.java),
                                        1)),
                        2),
                        isDisplayed()))
        view.check(matches(isDisplayed()))

        val view2 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.indicator),
                                childAtPosition(
                                        IsInstanceOf.instanceOf(android.widget.RelativeLayout::class.java),
                                        1)),
                        4),
                        isDisplayed()))
        view2.check(matches(isDisplayed()))

        val relativeLayout = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.sportItemView),
                                childAtPosition(
                                        withId(R.id.slider),
                                        0)),
                        0),
                        isDisplayed()))
        relativeLayout.check(matches(isDisplayed()))

        val relativeLayout2 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.sportItemView),
                                childAtPosition(
                                        withId(R.id.slider),
                                        2)),
                        0),
                        isDisplayed()))
        relativeLayout2.check(matches(isDisplayed()))


        val appCompatTextView = onView(
                allOf(withId(R.id.showAllButton), withText("Показать все"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.headerView),
                                        0),
                                1),
                        isDisplayed()))
        appCompatTextView.perform(click())

        val appCompatImageView2 = onView(
                allOf(withId(R.id.ivMain),
                        childAtPosition(
                                allOf(withId(R.id.viewContainer),
                                        childAtPosition(
                                                withId(R.id.navigationFragment),
                                                1)),
                                0),
                        isDisplayed()))
        appCompatImageView2.perform(click())
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
