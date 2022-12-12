package io.github.tiagonuneslx.burgerapp.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import io.github.tiagonuneslx.burgerapp.android.db.entity.Burger

/**
 * 1. Build the Home page UI natively
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            BurgerAppTheme {
                HomeScreen()
            }
        }
    }
}

@Composable
private fun HomeScreen(homeViewModel: HomeViewModel = viewModel()) {
    val burgers by homeViewModel.burgers.collectAsState()
    Home(burgers)
}

@Composable
private fun Home(burgers: List<Burger>?) {
    val systemUiController = rememberSystemUiController()
    val backgroundColor = MaterialTheme.colors.background
    LaunchedEffect(systemUiController, backgroundColor) {
        systemUiController.setStatusBarColor(
            color = backgroundColor,
            darkIcons = false
        )
        systemUiController.setNavigationBarColor(
            color = backgroundColor,
            darkIcons = false
        )
    }
    Surface(
        modifier = Modifier
            .systemBarsPadding()
            .fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column(
            Modifier.padding(horizontal = 24.dp)
        ) {
            Spacer(Modifier.height(36.dp))
            TopAppBar()
            Spacer(modifier = Modifier.height(64.dp))
            Column(Modifier.padding(horizontal = 8.dp)) {
                Text("Every Bite a", fontSize = 32.sp, fontWeight = FontWeight.ExtraBold)
                Text("Better burger!", fontSize = 24.sp, fontWeight = FontWeight.Normal)
                Spacer(modifier = Modifier.height(24.dp))
                FiltersRow()
                Spacer(modifier = Modifier.height(24.dp))
                if (burgers != null) {
                    BurgersGrid(burgers)
                }
            }
        }
    }
}

@Composable
private fun TopAppBar() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        IconButton(onClick = { }) {
            Image(
                painter = painterResource(id = R.drawable.ic_menu),
                contentDescription = stringResource(R.string.menu_button_content_description),
                modifier = Modifier.size(28.dp, 24.dp)
            )
        }
        Image(
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = stringResource(R.string.search_button_content_description),
            modifier = Modifier
                .clip(CircleShape)
                .clickable { }
                .size(52.dp, 52.dp)
        )
    }
}

@Composable
private fun FiltersRow() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                Modifier
                    .offset(y = (-1).dp)
                    .clip(CircleShape)
                    .size(6.dp)
                    .background(MaterialTheme.colors.primary)
            ) {}
            Spacer(Modifier.width(10.dp))
            Text(
                "Burgers",
                fontFamily = Poppins,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Text("Pasta", fontFamily = Poppins, fontSize = 14.sp)
        Text("Salads", fontFamily = Poppins, fontSize = 14.sp)
        Image(
            painter = painterResource(id = R.drawable.ic_filter),
            contentDescription = stringResource(R.string.filter_button_content_description),
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
                .clickable { }
                .size(48.dp, 48.dp)
        )
    }
}

@Composable
private fun BurgersGrid(burgers: List<Burger>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(burgers, key = { it.id }) { burger ->
            Column(
                Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .clickable { }) {
                Image(
                    painter = painterResource(id = burger.thumbnailResourceId),
                    contentDescription = burger.name,
                    Modifier
                        .fillMaxWidth()
                        .aspectRatio(1.2307693f, false)
                )
                Spacer(modifier = Modifier.height(6.dp))
                Column(Modifier.padding(horizontal = 16.dp)) {
                    Text(
                        burger.name,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        burger.description,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Normal
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            "$%.2f".format(burger.price),
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Box(
                            Modifier
                                .clip(CircleShape)
                                .size(24.dp)
                                .clickable { }
                                .background(Color.Black)
                        ) {
                            Text(
                                "+",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.align(Alignment.Center)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}

@Preview(
    device = Devices.PIXEL_3A,
    showBackground = true,
    showSystemUi = true,
    backgroundColor = 0xFFFFFF,
    apiLevel = 33
)
@Composable
fun AppPreview() {
    BurgerAppTheme {
        Home(Burger.samples)
    }
}
