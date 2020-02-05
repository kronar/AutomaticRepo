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
import com.schibsted.spain.barista.interaction.BaristaScrollInteractions.safelyScrollTo
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

        val info = onView(
                allOf(withId(R.id.ibInfo),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(`is`("androidx.appcompat.widget.Toolbar")),
                                        0),
                                0),
                        isDisplayed()))
        info.perform(click())

        val bInfo = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.toolbar),
                                childAtPosition(
                                        withId(R.id.infoAppBar),
                                        0)),
                        0),
                        isDisplayed()))
        bInfo.perform(click())

        val logo = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withClassName(`is`("androidx.appcompat.widget.Toolbar")),
                                0),
                        1),
                        isDisplayed()))
        logo.check(matches(isDisplayed()))

        val slidesPager = onView(
                allOf(withId(R.id.indicator),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.slidesPager),
                                        0),
                                1),
                        isDisplayed()))
        slidesPager.check(matches(isDisplayed()))

        val bannersRecycler = onView(
                allOf(withId(R.id.image),
                        childAtPosition(
                                allOf(withId(R.id.bannersRecycler),
                                        childAtPosition(
                                                IsInstanceOf.instanceOf(RelativeLayout::class.java),
                                                0)),
                                0),
                        isDisplayed()))
        bannersRecycler.check(matches(isDisplayed()))

        val indicator = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.indicator),
                                childAtPosition(
                                        IsInstanceOf.instanceOf(RelativeLayout::class.java),
                                        1)),
                        2),
                        isDisplayed()))
        indicator.check(matches(isDisplayed()))

        val indicatorT = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.indicator),
                                childAtPosition(
                                        IsInstanceOf.instanceOf(RelativeLayout::class.java),
                                        1)),
                        4),
                        isDisplayed()))
        indicatorT.check(matches(isDisplayed()))

        val sportItemView = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.sportItemView),
                                childAtPosition(
                                        withId(R.id.slider),
                                        0)),
                        0),
                        isDisplayed()))
        sportItemView.check(matches(isDisplayed()))

        val sportItemViewT = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.sportItemView),
                                childAtPosition(
                                        withId(R.id.slider),
                                        2)),
                        0),
                        isDisplayed()))
        sportItemViewT.check(matches(isDisplayed()))
        swipeViewPagerForward(R.id.slider);
        val showAllButton = onView(
                allOf(withId(R.id.showAllButton), withText("Показать все"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.headerView),
                                        0),
                                1),
                        isDisplayed()))
        showAllButton.perform(click())

        val bMain = onView(
                allOf(withId(R.id.ivMain),
                        childAtPosition(
                                allOf(withId(R.id.viewContainer),
                                        childAtPosition(
                                                withId(R.id.navigationFragment),
                                                1)),
                                0),
                        isDisplayed()))
        bMain.perform(click())
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
        val tA = onView(
                    allOf(withId(R.id.btnClose),
                            childAtPosition(
                                    allOf(withId(R.id.root),
                                            childAtPosition(
                                                    withId(android.R.id.content),
                                                    0)),
                                    3),
                            isDisplayed()))
        tA.perform(click())
        scrollTo(R.id.collectionTitleImageView)
        val brandU = onView(
                allOf(withId(R.id.image),
                        childAtPosition(
                                allOf(withId(R.id.slider),
                                        childAtPosition(
                                                withClassName(`is`("android.widget.LinearLayout")),
                                                1)),
                                0),
                        isDisplayed()))
        brandU.perform(click())

        val backbrandU = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.toolbar),
                                childAtPosition(
                                        withId(R.id.appbar),
                                        0)),
                        0),
                        isDisplayed()))
        backbrandU.perform(click())

        val brandD = onView(
                allOf(withId(R.id.image),
                        childAtPosition(
                                allOf(withId(R.id.slider),
                                        childAtPosition(
                                                withClassName(`is`("android.widget.LinearLayout")),
                                                1)),
                                3),
                        isDisplayed()))
        brandD.perform(click())

        val bBrandD = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.toolbar),
                                childAtPosition(
                                        withId(R.id.appbar),
                                        0)),
                        0),
                        isDisplayed()))
        bBrandD.perform(click())
        swipeViewPagerForward(R.id.slider);
        val showAllButton = onView(
                allOf(withId(R.id.showAllButton), withText("Показать все"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.headerView),
                                        0),
                                1),
                        isDisplayed()))
        showAllButton.perform(click())
        sleep(2000);
        val hint = onView(
                allOf(withId(R.id.close),
                        childAtPosition(
                                allOf(withId(R.id.content),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                5),
                        isDisplayed()))
        hint.perform(click())
        assertDisplayed("Бренды")
    }

    @Test
    fun bottomBanner() {
        safelyScrollTo(R.id.actionsPager);
        val bottomBanner = onView(
                allOf(withId(R.id.image),
                        childAtPosition(
                                allOf(withId(R.id.bannersRecycler),
                                        childAtPosition(
                                                IsInstanceOf.instanceOf(android.widget.RelativeLayout::class.java),
                                                0)),
                                0),
                        isDisplayed()))
        bottomBanner.check(matches(isDisplayed()))
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
