package com.wei.picquest.ui

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.unit.DpSize
import com.wei.picquest.core.data.utils.NetworkMonitor
import com.wei.picquest.core.manager.SnackbarManager
import com.wei.picquest.uitesthiltmanifest.HiltComponentActivity
import com.wei.picquest.utilities.COMPACT_HEIGHT
import com.wei.picquest.utilities.COMPACT_WIDTH
import com.wei.picquest.utilities.EXPANDED_HEIGHT
import com.wei.picquest.utilities.EXPANDED_WIDTH
import com.wei.picquest.utilities.MEDIUM_HEIGHT
import com.wei.picquest.utilities.MEDIUM_WIDTH
import dagger.hilt.android.testing.BindValue
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import navigationUiRobot
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder
import javax.inject.Inject

/**
 * Tests that the navigation UI is rendered correctly on different screen sizes.
 */
@HiltAndroidTest
class NavigationUiTest {

    /**
     * Manages the components' state and is used to perform injection on your test
     */
    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    /**
     * Create a temporary folder used to create a Data Store file. This guarantees that
     * the file is removed in between each test, preventing a crash.
     */
    @BindValue
    @get:Rule(order = 1)
    val tmpFolder: TemporaryFolder = TemporaryFolder.builder().assureDeletion().build()

    /**
     * Use a test activity to set the content on.
     */
    @get:Rule(order = 2)
    val composeTestRule = createAndroidComposeRule<HiltComponentActivity>()

    @Inject
    lateinit var snackbarManager: SnackbarManager

    @Inject
    lateinit var networkMonitor: NetworkMonitor

    @Before
    fun setup() {
        hiltRule.inject()
    }

    @Test
    fun compactWidth_compactHeight_showsNavigationBar() {
        navigationUiRobot(composeTestRule) {
            setPqAppContent(
                dpSize = DpSize(COMPACT_WIDTH, COMPACT_HEIGHT),
                networkMonitor = networkMonitor,
                snackbarManager = snackbarManager,
            )

            verifyPqBottomBarDisplayed()
            verifyPqNavRailDoesNotExist()
            verifyPqNavDrawerDoesNotExist()
        }
    }

    @Test
    fun mediumWidth_compactHeight_showsNavigationRail() {
        navigationUiRobot(composeTestRule) {
            setPqAppContent(
                dpSize = DpSize(MEDIUM_WIDTH, COMPACT_HEIGHT),
                networkMonitor = networkMonitor,
                snackbarManager = snackbarManager,
            )

            verifyPqBottomBarDoesNotExist()
            verifyPqNavRailDisplayed()
            verifyPqNavDrawerDoesNotExist()
        }
    }

    @Test
    fun expandedWidth_compactHeight_showsNavigationDrawer() {
        navigationUiRobot(composeTestRule) {
            setPqAppContent(
                dpSize = DpSize(EXPANDED_WIDTH, COMPACT_HEIGHT),
                networkMonitor = networkMonitor,
                snackbarManager = snackbarManager,
            )

            verifyPqBottomBarDoesNotExist()
            verifyPqNavRailDoesNotExist()
            verifyPqNavDrawerDisplayed()
        }
    }

    @Test
    fun expandedWidth_compactHeight_whenFoldingDevicePostureIsBookPosture_showsNavigationRail() {
        navigationUiRobot(composeTestRule) {
            setPqAppContentWithBookPosture(
                dpSize = DpSize(EXPANDED_WIDTH, COMPACT_HEIGHT),
                networkMonitor = networkMonitor,
                snackbarManager = snackbarManager,
            )

            verifyPqBottomBarDoesNotExist()
            verifyPqNavRailDisplayed()
            verifyPqNavDrawerDoesNotExist()
        }
    }

    @Test
    fun compactWidth_mediumHeight_showsNavigationBar() {
        navigationUiRobot(composeTestRule) {
            setPqAppContent(
                dpSize = DpSize(COMPACT_WIDTH, MEDIUM_HEIGHT),
                networkMonitor = networkMonitor,
                snackbarManager = snackbarManager,
            )

            verifyPqBottomBarDisplayed()
            verifyPqNavRailDoesNotExist()
            verifyPqNavDrawerDoesNotExist()
        }
    }

    @Test
    fun mediumWidth_mediumHeight_showsNavigationRail() {
        navigationUiRobot(composeTestRule) {
            setPqAppContent(
                dpSize = DpSize(MEDIUM_WIDTH, MEDIUM_HEIGHT),
                networkMonitor = networkMonitor,
                snackbarManager = snackbarManager,
            )

            verifyPqBottomBarDoesNotExist()
            verifyPqNavRailDisplayed()
            verifyPqNavDrawerDoesNotExist()
        }
    }

    @Test
    fun expandedWidth_mediumHeight_showsNavigationDrawer() {
        navigationUiRobot(composeTestRule) {
            setPqAppContent(
                dpSize = DpSize(EXPANDED_WIDTH, MEDIUM_HEIGHT),
                networkMonitor = networkMonitor,
                snackbarManager = snackbarManager,
            )

            verifyPqBottomBarDoesNotExist()
            verifyPqNavRailDoesNotExist()
            verifyPqNavDrawerDisplayed()
        }
    }

    @Test
    fun expandedWidth_mediumHeight_whenFoldingDevicePostureIsBookPosture_showsNavigationRail() {
        navigationUiRobot(composeTestRule) {
            setPqAppContentWithBookPosture(
                dpSize = DpSize(EXPANDED_WIDTH, MEDIUM_HEIGHT),
                networkMonitor = networkMonitor,
                snackbarManager = snackbarManager,
            )

            verifyPqBottomBarDoesNotExist()
            verifyPqNavRailDisplayed()
            verifyPqNavDrawerDoesNotExist()
        }
    }

    @Test
    fun compactWidth_expandedHeight_showsNavigationBar() {
        navigationUiRobot(composeTestRule) {
            setPqAppContent(
                dpSize = DpSize(COMPACT_WIDTH, EXPANDED_HEIGHT),
                networkMonitor = networkMonitor,
                snackbarManager = snackbarManager,
            )

            verifyPqBottomBarDisplayed()
            verifyPqNavRailDoesNotExist()
            verifyPqNavDrawerDoesNotExist()
        }
    }

    @Test
    fun mediumWidth_expandedHeight_showsNavigationRail() {
        navigationUiRobot(composeTestRule) {
            setPqAppContent(
                dpSize = DpSize(MEDIUM_WIDTH, EXPANDED_HEIGHT),
                networkMonitor = networkMonitor,
                snackbarManager = snackbarManager,
            )

            verifyPqBottomBarDoesNotExist()
            verifyPqNavRailDisplayed()
            verifyPqNavDrawerDoesNotExist()
        }
    }

    @Test
    fun expandedWidth_expandedHeight_showsNavigationDrawer() {
        navigationUiRobot(composeTestRule) {
            setPqAppContent(
                dpSize = DpSize(EXPANDED_WIDTH, EXPANDED_HEIGHT),
                networkMonitor = networkMonitor,
                snackbarManager = snackbarManager,
            )

            verifyPqBottomBarDoesNotExist()
            verifyPqNavRailDoesNotExist()
            verifyPqNavDrawerDisplayed()
        }
    }

    @Test
    fun expandedWidth_expandedHeight_whenFoldingDevicePostureIsBookPosture_showsNavigationRail() {
        navigationUiRobot(composeTestRule) {
            setPqAppContentWithBookPosture(
                dpSize = DpSize(EXPANDED_WIDTH, EXPANDED_HEIGHT),
                networkMonitor = networkMonitor,
                snackbarManager = snackbarManager,
            )

            verifyPqBottomBarDoesNotExist()
            verifyPqNavRailDisplayed()
            verifyPqNavDrawerDoesNotExist()
        }
    }
}
