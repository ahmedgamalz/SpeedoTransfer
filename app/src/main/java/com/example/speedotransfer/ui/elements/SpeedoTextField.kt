package com.example.speedotransfer.ui.elements


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.speedotransfer.R
import com.example.speedotransfer.ui.theme.BodyRegular14
import com.example.speedotransfer.ui.theme.BodyRegular16
import com.example.speedotransfer.ui.theme.D300
import com.example.speedotransfer.ui.theme.G70
import com.example.speedotransfer.ui.theme.G700





@Composable
fun SpeedoTextField(
    labelText: String,
    value: String,
    onValueChange: (String) -> Unit,
    placeholderText: String,
    icon: Int,
    modifier: Modifier = Modifier,
    keyboardOptions :KeyboardOptions,
    visualTransformation: VisualTransformation = VisualTransformation.None

) {
    var fullName by remember {
        mutableStateOf("")
    }


    Column(

    ) {
        Text(
            text = labelText,
            style = BodyRegular16,
            color = G700,
            modifier = modifier
                .fillMaxWidth()
                .height(24.dp)
                .padding(start = 16.dp)
        )
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            textStyle = BodyRegular14,
            placeholder = {
                Text(
                    text = placeholderText,
                    style = BodyRegular14,
                    color = G70,
                    modifier = modifier
                        .height(21.dp)
                )
            },
            trailingIcon = {

                    Icon(
                        painter = painterResource(id = icon), contentDescription = "",
                        modifier = modifier.size(24.dp) , tint = G700
                    )


            },

            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = G700,
                focusedBorderColor = G700,
                focusedTrailingIconColor = G700,
                cursorColor = G700,
                disabledPlaceholderColor = G70,
                disabledTrailingIconColor = G70,
                disabledBorderColor = G70,
                errorBorderColor = D300,
                errorTrailingIconColor = D300,
            ),
            shape = RoundedCornerShape(6.dp),
            keyboardOptions = keyboardOptions,
            visualTransformation = visualTransformation,
            modifier = modifier
                .padding(top = 8.dp, start = 16.dp, end = 16.dp, bottom = 8.dp)
                .fillMaxWidth()
                .height(52.dp)

        )
//        Text(
//            text = "This is an error message.",
//            style = BodyRegular14,
//            color = D300,
//            modifier = modifier
//                .fillMaxWidth()
//                .height(21.dp)
//                .padding(start = 16.dp)
//        )
    }
}

@Preview(showSystemUi = true)
@Composable
private fun SpeedoTextFieldPreview() {

    var text by remember {
        mutableStateOf("Fady")
    }

    SpeedoTextField(
        labelText = "User Name",
        value = text,
        onValueChange = {text = it},
        placeholderText = "Enter your name",
        icon = R.drawable.setting,
        keyboardOptions = KeyboardOptions.Default
    )

}


