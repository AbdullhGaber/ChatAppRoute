package com.example.chatapproute.screens.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.SecondaryIndicator
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale.Companion.Crop
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chatapproute.R
import com.example.chatapproute.components.ChatAppTopBar
import com.example.chatapproute.components.ChatSearchBar
import com.example.chatapproute.model.Category
import com.example.chatapproute.screens.home.components.RoomCardList
import com.example.chatapproute.ui.theme.BluePrimaryColor
import com.example.domain.entities.ChatRoom

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(){
    Scaffold(
        topBar = {
           Column {
               ChatAppTopBar(title = "Home")
               Spacer(modifier = Modifier.height(8.dp))
               ChatSearchBar(
                   modifier = Modifier.padding(horizontal = 16.dp)
               )
               Spacer(modifier = Modifier.height(8.dp))
           }
        },
        floatingActionButton = {
            IconButton(
                onClick = {

                },
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = BluePrimaryColor
                ),
                modifier = Modifier.size(60.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Add button",
                    tint = Color.White,
                    modifier = Modifier.size(40.dp)
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .paint(
                    painter = painterResource(id = R.drawable.bg),
                    contentScale = Crop
                )
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
        ){
            val tabItems = listOf(
                stringResource(R.string.my_rooms) ,
                stringResource(R.string.browse)
            )

            val selectedIndex = remember{ mutableIntStateOf(0) }

            TabRow(
                selectedTabIndex = selectedIndex.intValue,
                containerColor = Color.Transparent,
                indicator = { tabPositions ->
                    SecondaryIndicator(
                        Modifier
                            .tabIndicatorOffset(tabPositions[selectedIndex.intValue])
                            .height(2.dp),
                        color = Color.White
                    )
                }
            ) {
                tabItems.forEachIndexed{ index: Int, item: String ->
                    Tab(
                        selected = index == selectedIndex.intValue,
                        onClick = { selectedIndex.intValue = index },
                        text = {
                            Text(
                                text = item,
                                fontSize = 12.sp,
                                fontWeight = FontWeight(700),
                                letterSpacing = 0.36.sp,
                            )
                        },
                        selectedContentColor = Color.White,
                        unselectedContentColor = Color.White
                    )
                }
            }

            Spacer(Modifier.height(16.dp))

            val pagerState = rememberPagerState(initialPage = 0) { 2 }
            val rooms = listOf(
                ChatRoom(name = "The Movies Zone" , categoryId = Category.MOVIES_CATEGORY , joinedUID = listOf("")),
                ChatRoom(name = "The Movies Zone" , categoryId = Category.MOVIES_CATEGORY , joinedUID = listOf("")),
                ChatRoom(name = "The Movies Zone" , categoryId = Category.MOVIES_CATEGORY , joinedUID = listOf("")),
                ChatRoom(name = "The Movies Zone" , categoryId = Category.MOVIES_CATEGORY , joinedUID = listOf("")),
                ChatRoom(name = "The Movies Zone" , categoryId = Category.MOVIES_CATEGORY , joinedUID = listOf("")),
                ChatRoom(name = "The Movies Zone" , categoryId = Category.MOVIES_CATEGORY , joinedUID = listOf("")),
            )
            HorizontalPager(state = pagerState) {
                when(pagerState.targetPage){
                    0 -> {
                        RoomCardList(
                            rooms = rooms
                        )
                    }

                    1 -> {
                        RoomCardList(
                            rooms = rooms
                        )
                    }
                }
            }

            LaunchedEffect(pagerState.currentPage,pagerState.isScrollInProgress){
                if(!pagerState.isScrollInProgress){
                    selectedIndex.intValue = pagerState.currentPage
                }
            }

            LaunchedEffect(key1 = selectedIndex){
                pagerState.animateScrollToPage(selectedIndex.intValue)
            }
        }
    }
}

@Composable
@Preview
fun PreviewHomeScreen(){
    HomeScreen()
}