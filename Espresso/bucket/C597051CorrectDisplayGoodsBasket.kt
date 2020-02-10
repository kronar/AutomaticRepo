package ru.sportmaster.app.priority.bucket


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertDisplayed
import com.schibsted.spain.barista.interaction.BaristaScrollInteractions.scrollTo
import com.schibsted.spain.barista.interaction.BaristaSleepInteractions.sleep
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
class C597051CorrectDisplayGoodsBasket {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun correctDisplayGoodsBasket() {
        val appCompatImageButton = onView(
                allOf(withId(R.id.btnClose),
                        childAtPosition(
                                allOf(withId(R.id.root),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                3),
                        isDisplayed()))
        appCompatImageButton.perform(click())

        val showAllButton = onView(
                allOf(withId(R.id.showAllButton), withText("Показать все"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.headerView),
                                        0),
                                1),
                        isDisplayed()))
        showAllButton.perform(click())

        sleep(2000)

        val rvCategory = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.rvCategory),
                                childAtPosition(
                                        withClassName(`is`("android.widget.RelativeLayout")),
                                        1)),
                        5),
                        isDisplayed()))
        rvCategory.perform(click())

        val split = onView(
                allOf(withId(R.id.menu_view),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.toolbar),
                                        1),
                                0),
                        isDisplayed()))
        split.perform(click())

        val toBucket = onView(
                allOf(withId(R.id.buy), withText("В корзину"),
                        childAtPosition(
                                allOf(withId(R.id.viewButtons),
                                        childAtPosition(
                                                withId(R.id.prices),
                                                1)),
                                2),
                        isDisplayed()))
        toBucket.perform(click())

        val brvCategory = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.toolbar),
                                childAtPosition(
                                        withClassName(`is`("com.google.android.material.appbar.AppBarLayout")),
                                        0)),
                        0),
                        isDisplayed()))
        brvCategory.perform(click())

        val rvCategoryD = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.rvCategory),
                                childAtPosition(
                                        withClassName(`is`("android.widget.RelativeLayout")),
                                        1)),
                        6),
                        isDisplayed()))
        rvCategoryD.perform(click())

        val rvCategoryDC = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.rvCategory),
                                childAtPosition(
                                        withClassName(`is`("android.widget.RelativeLayout")),
                                        1)),
                        5),
                        isDisplayed()))
        rvCategoryDC.perform(click())

        val splitRv = onView(
                allOf(withId(R.id.menu_view),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.toolbar),
                                        1),
                                0),
                        isDisplayed()))
        splitRv.perform(click())

        val toBucketD = onView(
                allOf(withId(R.id.buy), withText("В корзину"),
                        childAtPosition(
                                allOf(withId(R.id.viewButtons),
                                        childAtPosition(
                                                withId(R.id.prices),
                                                1)),
                                2),
                        isDisplayed()))
        toBucketD.perform(click())

        val rvSizes = onView(
                allOf(withId(R.id.size), withText("41"),
                        childAtPosition(
                                allOf(withId(R.id.rvSizes),
                                        childAtPosition(
                                                withId(R.id.frameSize),
                                                0)),
                                2),
                        isDisplayed()))
        rvSizes.perform(click())

        val ivBasket = onView(
                allOf(withId(R.id.ivBasket),
                        childAtPosition(
                                allOf(withId(R.id.viewBasket),
                                        childAtPosition(
                                                withId(R.id.viewContainer),
                                                3)),
                                0),
                        isDisplayed()))
        ivBasket.perform(click())

        sleep(2000)

        val tA = onView(
                allOf(withId(R.id.close),
                        childAtPosition(
                                allOf(withId(R.id.content),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                4),
                        isDisplayed()))
        tA.perform(click())

        sleep(2000)

        assertDisplayed(R.id.image)
        assertDisplayed(R.id.colorIndicator)
        assertDisplayed(R.id.availableToBuyLayout)

        scrollTo("Скидки")

        assertDisplayed(R.id.image)
        assertDisplayed(R.id.colorIndicator)
        assertDisplayed(R.id.availableToBuyLayout)
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
