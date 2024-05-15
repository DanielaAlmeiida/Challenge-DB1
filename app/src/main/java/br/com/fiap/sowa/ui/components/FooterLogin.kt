package br.com.fiap.sowa.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.sowa.R

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun FooterLogin() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(65.dp)
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(Color(0xFF6AD9BE), Color(0xFF17AE8A)),
                    startX = 0f,
                    endX = 900f
                )
            )
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.mm_a_icon),
            contentDescription = "Logo MM&A",
            modifier = Modifier.size(35.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Image(
            painter = painterResource(id = R.drawable.mma_text),
            contentDescription = "MM&A",
            modifier = Modifier
                .size(70.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "© Todos os direitos reservados 2023",
            fontSize = 10.sp,
            color = Color.White,
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.End
        )
    }
}