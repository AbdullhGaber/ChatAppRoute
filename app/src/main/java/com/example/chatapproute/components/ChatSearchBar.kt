package com.example.chatapproute.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.chatapproute.R
import com.example.chatapproute.ui.theme.BluePrimaryColor


@Composable
fun ChatSearchBar(
    modifier: Modifier = Modifier,
    query : String = "",
    onQueryChange : (String) -> Unit = {},
    onSearch : (String) -> Unit = {},

    ){
    TextField(
        value = query,
        onValueChange = onQueryChange,
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.search_ic),
                contentDescription = stringResource(id = R.string.search_icon),
                tint = BluePrimaryColor
            )
        },
        placeholder = {
            Text(
                text = stringResource(id = R.string.search_for_rooms),
                color = BluePrimaryColor.copy(alpha = 0.6f)
            )
        },
        modifier = modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(25 .dp),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                onSearch(query)
            }
        )
    )
}

@Composable
@Preview
fun PreviewChatSearchBar(){
    ChatSearchBar()
}