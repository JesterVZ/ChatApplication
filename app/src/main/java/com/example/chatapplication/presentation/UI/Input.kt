package com.example.chatapplication.presentation.UI

import android.view.RoundedCorner
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chatapplication.presentation.theme.BorderColor

@Composable
fun MainInput(
    label: String,
    modifier: Modifier = Modifier,
    text: String,
    placeholder: String,
    leadingIcon: @Composable (() -> Unit)? = null,
    transformation: VisualTransformation = VisualTransformation.None,
    imeAction: ImeAction = ImeAction.Next,
    keyboardType: KeyboardType = KeyboardType.Text,
    keyBoardActions: KeyboardActions = KeyboardActions(),
    isEnabled: Boolean = true){
    var text by remember { mutableStateOf("") }
    Column() {
        Text(text = label, modifier = Modifier.padding(8.dp));
        OutlinedTextField(
            modifier = modifier.fillMaxWidth(),
            value = text,
            shape = RoundedCornerShape(10.dp),
            onValueChange = {text = it},
            leadingIcon = leadingIcon,
            textStyle = TextStyle(fontSize = 18.sp),
            keyboardOptions = KeyboardOptions(imeAction = imeAction, keyboardType = keyboardType),
            keyboardActions = keyBoardActions,
            visualTransformation = transformation,
            enabled = isEnabled,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = BorderColor,
                unfocusedBorderColor = BorderColor,
                disabledBorderColor = BorderColor,
                disabledTextColor = BorderColor
            ),
            placeholder = {
                Text(text = placeholder, style = TextStyle(fontSize = 18.sp, color = Color.LightGray))
            }
        )
    }


}