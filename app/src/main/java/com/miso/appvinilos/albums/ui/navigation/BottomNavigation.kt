import androidx.compose.material3.BottomNavigation
import androidx.compose.material3.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.popUpTo
import com.miso.appvinilos.ui.navigation.BottomNavItem

@Composable
fun BottomNavigation(navController: NavController) {
    val items = listOf(
        BottomNavItem.Albums,
        BottomNavItem.Home
    )

    BottomNavigation {
        val currentRoute = navController.currentDestination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.iconRes), contentDescription = stringResource(id = item.titleRes)) },
                label = { Text(stringResource(id = item.titleRes)) },
                selected = currentRoute == item.route,
                onClick = {
                    if (currentRoute != item.route) {
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.startDestinationRoute ?: "") { saveState = true }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                }
            )
        }
    }
}