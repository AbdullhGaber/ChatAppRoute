package com.example.chatapproute.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.example.chatapproute.R
import com.example.chatapproute.ui.theme.BluePrimaryColor
import com.example.chatapproute.ui.theme.LightGrey

@Composable
fun AuthTextField(
    modifier: Modifier = Modifier,
    value : String,
    isPasswordField : Boolean = false,
    isPasswordVisible : Boolean = false,
    onValueChange : (String) -> Unit,
    onPasswordVisibilityChange: (Boolean) -> Unit = {},
    label: String,
    error: String,
) {
    Column(modifier.fillMaxWidth(0.85F)) {
        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = label)
            },
            isError = error.trim().isNotEmpty(),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = BluePrimaryColor,
                unfocusedIndicatorColor = LightGrey,
                errorIndicatorColor = Color.Red,
                unfocusedTextColor = Color.Black,
                focusedTextColor = Color.Black,
                errorTextColor = Color.Black,
                focusedContainerColor = Color.Transparent,
                errorContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent
            ),
            visualTransformation = if(isPasswordField && !isPasswordVisible) PasswordVisualTransformation() else VisualTransformation.None,
            suffix = {
                if(isPasswordField){
                    Icon(
                        imageVector = if(isPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                        contentDescription = stringResource(
                            R.string.password_visibility_icon
                        ),
                        modifier = Modifier.clickable {
                            onPasswordVisibilityChange(!isPasswordVisible)
                        }
                    )
                }
            }
        )
        if (error.isNotEmpty())
            Text(text = error, color = Color.Red)

    }
}

@Preview
@Composable
fun AuthTextFieldPreview() {
}