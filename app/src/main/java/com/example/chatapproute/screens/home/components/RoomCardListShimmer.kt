package com.example.chatapproute.screens.home.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.chatapproute.util.shimmerEffect

@Composable
fun RoomCardListShimmer(
    modifier : Modifier = Modifier,
){
    LazyVerticalStaggeredGrid(
        modifier = modifier,
        columns = StaggeredGridCells.Fixed(2),
        verticalItemSpacing = 8.dp
    ) {
        items(6){
            Box(
                modifier = Modifier.padding(horizontal = 8.dp).clip(RoundedCornerShape(20.dp)).height(200.dp).shimmerEffect()
            )

        }
    }
}

@Composable
@Preview
fun PreviewRoomCardListShimmer(){
    RoomCardListShimmer()
}