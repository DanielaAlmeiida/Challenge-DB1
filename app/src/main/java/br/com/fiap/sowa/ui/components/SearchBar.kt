package br.com.fiap.sowa.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.fiap.sowa.R


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SearchBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(0.dp, 0.dp, 0.dp, 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            shape = RoundedCornerShape(50.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                disabledContainerColor = Color.White,
            ),
            modifier = Modifier
                .padding(20.dp, 0.dp),
            value = "",
            onValueChange = {
            },
            label = {
                Text(text = "Pesquisar")
            },
            placeholder = {
                Text(text = "Pesquisar...")
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_search_24),
                    contentDescription = null
                )
            },
        )

        OutlinedButton(
            onClick = { },
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.white)),
            shape = RoundedCornerShape(50.dp),
            modifier = Modifier
                .padding(0.dp, 0.dp, 10.dp, 0.dp)
                .fillMaxHeight(.8f),

            content = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_filter_alt_24),
                        contentDescription = null,
                        tint = colorResource(id = R.color.grayPrincipal),
                    )
                }
            }
        )
    }
}