package ru.sportmaster.app.mainscreen

import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.schibsted.spain.barista.assertion.BaristaFocusedAssertions.assertNotFocused
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertDisplayed
import com.schibsted.spain.barista.interaction.BaristaClickInteractions.clickOn
import com.schibsted.spain.barista.interaction.BaristaScrollInteractions
import com.schibsted.spain.barista.interaction.BaristaScrollInteractions.scrollTo
import com.schibsted.spain.barista.interaction.BaristaSleepInteractions.sleep
import com.schibsted.spain.barista.interaction.BaristaViewPagerInteractions.swipeViewPagerForward
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
class DisplayHomeScreenItemsTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)


    @Test
    fun footerMainFavorite() {

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
                                                IsInstanceOf.instanceOf(RelativeLayout::class.java),
                                                0)),
                                0),
                        isDisplayed()))
        imageView2.check(matches(isDisplayed()))

        val view = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.indicator),
                                childAtPosition(
                                        IsInstanceOf.instanceOf(RelativeLayout::class.java),
                                        1)),
                        2),
                        isDisplayed()))
        view.check(matches(isDisplayed()))

        val view2 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.indicator),
                                childAtPosition(
                                        IsInstanceOf.instanceOf(RelativeLayout::class.java),
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

        swipeViewPagerForward(R.id.slider);

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

    @Test
    fun clothesShoes_M() {
        sleep(2000);
        Espresso.pressBack()
        scrollTo(R.id.clothes_and_shoes_pager)
        assertDisplayed(R.id.clothes_and_shoes_pager)
        assertDisplayed("Мужчинам")
        assertDisplayed("Одежда")
        clickOn("Одежда")
        assertDisplayed("Мужчинам")
    }

    @Test
    fun clothesShoes_W() {
        scrollTo(R.id.clothes_and_shoes_pager)
        assertDisplayed(R.id.clothes_and_shoes_pager)
        assertDisplayed("Женщинам")
        clickOn("Женщинам")
        assertDisplayed("Обувь")
        clickOn("Обувь")
        assertDisplayed("Женщинам")
    }

    @Test
    fun clothesShoes_Ch() {
        scrollTo(R.id.clothes_and_shoes_pager)
        assertDisplayed(R.id.clothes_and_shoes_pager)
        assertDisplayed("Детям")
        clickOn("Детям")
        assertDisplayed("Одежда для мальчиков")
        clickOn("Одежда для мальчиков")
        assertDisplayed("Детям")
    }

    @Test
    fun clothesShoes_MA() {
        sleep(2000);
        scrollTo(R.id.clothes_and_shoes_pager)
        assertDisplayed(R.id.clothes_and_shoes_pager)
        assertDisplayed("Женщинам")
        scrollTo(R.id.catalogImageView)
        clickOn(R.id.catalogImageView)
        assertNotFocused("Мужчинам")
    }

    @Test
    fun brands () {
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
        scrollTo(R.id.collectionTitleImageView)
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

        swipeViewPagerForward(R.id.slider);

        val appCompatTextView = onView(
                allOf(withId(R.id.showAllButton), withText("Показать все"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.headerView),
                                        0),
                                1),
                        isDisplayed()))
        appCompatTextView.perform(click())

        val appCompatImageButton4 = onView(
                allOf(withId(R.id.close),
                        childAtPosition(
                                allOf(withId(R.id.content),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                5),
                        isDisplayed()))
        appCompatImageButton4.perform(click())
        assertDisplayed("Бренды")
    }

    @Test
    fun bottomBanner() {
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
