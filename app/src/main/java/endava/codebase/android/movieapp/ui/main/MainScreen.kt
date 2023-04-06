package endava.codebase.android.movieapp.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import endava.codebase.android.movieapp.navigation.MovieDetailsDestination
import endava.codebase.android.movieapp.navigation.NavigationItem
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import endava.codebase.android.movieapp.R
import endava.codebase.android.movieapp.navigation.MOVIE_ID_KEY
import endava.codebase.android.movieapp.ui.favorites.FavoritesRoute
import endava.codebase.android.movieapp.ui.movie_details.MovieDetailsRoute
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.navigation.NavDestination
import androidx.navigation.NavType
import endava.codebase.android.movieapp.ui.home.HomeScreenRoute
import endava.codebase.android.movieapp.ui.theme.Blue
import endava.codebase.android.movieapp.ui.theme.spacing

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    var showBottomBar by remember { mutableStateOf(false) }
    val showBackIcon = !showBottomBar
    Scaffold(
        topBar = {
            TopBar(
                navigationIcon = {
                    if (showBackIcon) BackIcon(
                        onBackClick = navController::popBackStack
                    )
                },
            )
        },
        bottomBar = {
            if (showBottomBar) {
                BottomNavigationBar(
                    destinations = listOf(
                        NavigationItem.HomeDestination,
                        NavigationItem.FavoritesDestination,
                    ), onNavigateToDestination = {
                        navController.popBackStack(
                            NavigationItem.HomeDestination.route,
                            inclusive = false,
                        )
                        navController.navigate(it.route) { launchSingleTop = true }
                    }, currentDestination = navBackStackEntry?.destination
                )
            }
        },
    ) { padding ->
        Surface(
            color = MaterialTheme.colors.background,
            modifier = Modifier.fillMaxSize(),
        ) {
            NavHost(
                navController = navController,
                startDestination = NavigationItem.HomeDestination.route,
                modifier = Modifier.padding(padding),
            ) {
                composable(NavigationItem.HomeDestination.route) {
                    showBottomBar = true
                    HomeScreenRoute(
                        onNavigateToMovieDetails = {
                            navController.navigate(
                                MovieDetailsDestination.createNavigationRoute(it)
                            )
                        },
                    )
                }
                composable(NavigationItem.FavoritesDestination.route) {
                    showBottomBar = true
                    FavoritesRoute(
                        onNavigateToMovieDetails = {
                            navController.navigate(
                                MovieDetailsDestination.createNavigationRoute(it)
                            )
                        },
                    )
                }
                composable(
                    route = MovieDetailsDestination.route,
                    arguments = listOf(navArgument(MOVIE_ID_KEY) { type = NavType.IntType }),
                ) {
                    showBottomBar = false
                    MovieDetailsRoute()
                }
            }
        }
    }
}

@Composable
private fun TopBar(navigationIcon: @Composable (() -> Unit)? = null) {
    Box(
        modifier = Modifier
            .background(color = Blue)
            .fillMaxWidth()
            .height(dimensionResource(id = R.dimen.top_bar_height)),
        contentAlignment = Alignment.CenterStart,
    ) {
        navigationIcon?.invoke()
        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = null,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Composable
private fun BackIcon(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Image(
        painter = painterResource(id = R.drawable.ic_back_background),
        contentDescription = stringResource(id = R.string.back_button),
        modifier = modifier
            .clickable { onBackClick() }
            .size(dimensionResource(id = R.dimen.back_icon_size))
            .padding(start = MaterialTheme.spacing.small),
        alignment = Alignment.Center,
    )
}

@Composable
private fun BottomNavigationBar(
    destinations: List<NavigationItem>,
    onNavigateToDestination: (NavigationItem) -> Unit,
    currentDestination: NavDestination?,
) {
    BottomNavigation(backgroundColor = Blue) {
        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            destinations.forEach { destination ->
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    if (currentDestination != null) {
                        Image(
                            painter = painterResource(
                                id = if (currentDestination.route == destination.route) destination.selectedIconId
                                else destination.unselectedIconId
                            ),
                            contentDescription = null,
                            modifier = Modifier
                                .size(dimensionResource(id = R.dimen.icon_size))
                                .clickable {
                                    onNavigateToDestination(destination)
                                },
                        )
                    }
                    Text(
                        text = stringResource(id = destination.labelId),
                        style = MaterialTheme.typography.h3
                    )
                }
            }
        }
    }
}
