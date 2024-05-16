package br.com.fiap.sowa.ui.screens

import android.Manifest
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.sowa.model.NotificationHandler
import br.com.fiap.sowa.ui.components.*
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun LoginScreen(navController: NavController) {
    val context = LocalContext.current
    val postNotificationPermission = rememberPermissionState(permission = Manifest.permission.POST_NOTIFICATIONS)
    val notificationHandler = remember { NotificationHandler(context) }

    LaunchedEffect(key1 = true) {
        if (!postNotificationPermission.status.isGranted) {
            postNotificationPermission.launchPermissionRequest()
        }
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            GradientHeaderWithImage()
            LoginAndCadastro(navController)
            Spacer(modifier = Modifier.height(16.dp))
            EmailAndPasswordFields(navController)
            Spacer(modifier = Modifier.height(16.dp))
            ButtonEnter(navController)

            Button(onClick = {
                notificationHandler.showExpandedNotificationWithBigText()
            }) { Text(text = "Big text notification") }

            Spacer(modifier = Modifier.height(16.dp))
            ExternalLoginButtons()
            Spacer(modifier = Modifier.weight(1f))
            FooterLogin()
        }
    }
}

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewLoginScreen() {
    val navController = rememberNavController()
    Box(modifier = Modifier.fillMaxSize()) {
        LoginScreen(navController = navController)
    }
}
