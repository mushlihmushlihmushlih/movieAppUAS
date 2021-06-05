package com.example.myapplication

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.example.myapplication.ui.HomeActivity
import com.example.myapplication.utils.DataDummy
import com.example.myapplication.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Test

class HomeActivityTest {
    private val dummyMovies = DataDummy.generateDataMovieDummy()
    private val dummyTvShows = DataDummy.generateDataTvShowDummy()
    private val dummyMoviesFav = DataDummy.generateDummyMovieFavorite()
    private val dummyTvShowsFav = DataDummy.generateDummyTvShowFavorite()



    @Before
    fun setUp() {
        ActivityScenario.launch(HomeActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

    @Test
    fun loadAllMovies(){
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovies.size))
    }

    @Test
    fun detailMovie() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.text_title)).check(matches(isDisplayed()))
        onView(withId(R.id.text_description)).check(matches(isDisplayed()))
        onView(withId(R.id.image_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_favorite)).perform(click())
    }

    @Test
    fun loadAllFavoriteMovies(){
        onView(withId(R.id.navigation_favorite)).perform(click())
        onView(withId(R.id.rv_movies_favorite)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies_favorite)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMoviesFav.size))
    }

    @Test
    fun loadDetailFavoriteMovie(){
        onView(withId(R.id.navigation_favorite)).perform(click())
        onView(withId(R.id.rv_movies_favorite)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies_favorite)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.text_title)).check(matches(isDisplayed()))
        onView(withId(R.id.text_description)).check(matches(isDisplayed()))
        onView(withId(R.id.image_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_favorite)).perform(click())
    }

    @Test
    fun loadTvShows() {
        onView(withId(R.id.navigation_tv_series)).perform(click())
        onView(withId(R.id.rv_series)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_series)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShows.size))
    }

    @Test
    fun detailTvShow() {
        onView(withId(R.id.navigation_tv_series)).perform(click())
        onView(withId(R.id.rv_series)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.text_title)).check(matches(isDisplayed()))
        onView(withId(R.id.text_description)).check(matches(isDisplayed()))
        onView(withId(R.id.image_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_favorite)).perform(click())
    }


    @Test
    fun loadAllFavoriteTvShow(){
        onView(withId(R.id.navigation_favorite)).perform(click())
        onView(withText(R.string.tab_title_tvshow)).perform(click())
        onView(withId(R.id.rv_series_favorite)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_series_favorite)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShowsFav.size))
    }

    @Test
    fun loadDetailFavoriteTvShow(){
        onView(withId(R.id.navigation_favorite)).perform(click())
        onView(withText(R.string.tab_title_tvshow)).perform(click())
        onView(withId(R.id.rv_series_favorite)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.text_title)).check(matches(isDisplayed()))
        onView(withId(R.id.text_description)).check(matches(isDisplayed()))
        onView(withId(R.id.image_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_favorite)).perform(click())
    }
}


