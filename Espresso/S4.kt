package ru.sportmaster.app.activity.C523912

import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.schibsted.spain.barista.assertion.BaristaFocusedAssertions.assertNotFocused
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertDisplayed
import com.schibsted.spain.barista.interaction.BaristaClickInteractions.clickOn
import com.schibsted.spain.barista.interaction.BaristaScrollInteractions.scrollTo

import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.sportmaster.app.R
import ru.sportmaster.app.activity.MainActivity

@LargeTest
@RunWith(AndroidJUnit4::class)
class S4 {

    @get:Rule
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)


    @Test
    fun st_CS_M() {
        scrollTo(R.id.clothes_and_shoes_pager)
        assertDisplayed(R.id.clothes_and_shoes_pager)
        assertDisplayed("Мужчинам")
        assertDisplayed("Одежда")
        clickOn("Одежда")
        assertDisplayed("Мужчинам")
    }

    @Test
    fun st_CS_W() {
        scrollTo(R.id.clothes_and_shoes_pager)
        assertDisplayed(R.id.clothes_and_shoes_pager)
        assertDisplayed("Женщинам")
        clickOn("Женщинам")
        assertDisplayed("Обувь")
        clickOn("Обувь")
        assertDisplayed("Женщинам")
    }

    @Test
    fun st_CS_Ch() {
        scrollTo(R.id.clothes_and_shoes_pager)
        assertDisplayed(R.id.clothes_and_shoes_pager)
        assertDisplayed("Детям")
        clickOn("Детям")
        assertDisplayed("Одежда для мальчиков")
        clickOn("Одежда для мальчиков")
        assertDisplayed("Детям")
    }

    @Test
    fun st_CS_MA() {
        scrollTo(R.id.clothes_and_shoes_pager)
        assertDisplayed(R.id.clothes_and_shoes_pager)
        assertDisplayed("Женщинам")
        scrollTo(R.id.catalogImageView)
        clickOn(R.id.catalogImageView)
        assertNotFocused("Мужчинам")
    }
}