package me.eclorelavie.passwordstrength;

...

import android.support.test.rule.ActivityTestRule;
import org.junit.Rule;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.assertition.ViewAssertions.*;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class CheckerUiTest {
  
  private final static Srting WEAK_PASSWORD = "password";
  private final static Srting STRONG_PASSWORD = "paSswOrd31";
  
  private final static Srting WEAK_STATUS = "Слабый";
  private final static Srting STRONG_STATUS = "Сильный";

  @Rule
  public ActivityTestRule<MainActivity> mActivityRule = new
  ActivityTestRule<>(MainActivity.class);

  @Test
  public void BadPasswordStatusIsDisplayed() {
    onView(withId(R.id.password))
        .perform(
             typeText(WEAK_PASSWORD),
             closeSoftKeyboard()
        );

    onView(withId(R.id.check_strength)).perform(click());

    onView(withId(R.id.result)).check(matches(withText(WEAK_STATUS)));
  }
