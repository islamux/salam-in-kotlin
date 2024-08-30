package com.islamux.salam

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun KhatiraOnePage(navController: NavHostController, modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "الخاطرة 3", fontSize = 21.sp, fontWeight = FontWeight.Bold)
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
//                        Icon(
//                            painter = painterResource(id = R.drawable.ic_back),
//                            contentDescription = "Back"
//                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* Decrease font size */ }) {
//                        Icon(
//                            painter = painterResource(id = R.drawable.ic_decrease_font),
//                            contentDescription = "Decrease Font Size"
//                        )
                    }
                    Text(
                        text = "الخط",
                        fontSize = 18.sp,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                    IconButton(onClick = { /* Increase font size */ }) {
//                        Icon(
//                            painter = painterResource(id = R.drawable.ic_increase_font),
//                            contentDescription = "Increase Font Size"
//                        )
                    }
                }
            )
        },
        content = { innerPadding ->
            val pages = splitTextIntoPages(ElmTextDersThree.getAllContent())
            val pagerState = rememberPagerState(pageCount = { pages.size })

            Column(
                modifier = modifier
                    .padding(innerPadding)
                    .fillMaxSize()
            ) {
                HorizontalPager(
                    state = pagerState,
                    modifier = Modifier.weight(1f),
                    contentPadding = PaddingValues(16.dp),
                    pageSize = PageSize.Fill,
                    pageSpacing = 8.dp,
                    verticalAlignment = Alignment.CenterVertically,
                    userScrollEnabled = true,
                    pageContent = { page ->
                        Text(
                            text = pages[page],
                            fontSize = 18.sp,
                            textAlign = TextAlign.Right,
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp)
                        )
                    }
                )
            }
        }
    )
}