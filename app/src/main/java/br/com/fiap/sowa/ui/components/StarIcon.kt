package br.com.fiap.sowa.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import br.com.fiap.sowa.R

@Composable
fun StarIcon() {
    Image(
        painter = painterResource(id = R.drawable.star_avaliacao),
        contentDescription = null,
        modifier = Modifier.size(16.dp)
    )
}

