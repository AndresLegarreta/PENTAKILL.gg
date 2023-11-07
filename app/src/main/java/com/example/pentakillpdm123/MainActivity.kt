package com.example.pentakillpdm123

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pentakillpdm123.home.views.HomeMainView
import com.example.pentakillpdm123.login.Auth
import com.example.pentakillpdm123.login.LoginScreenView
import com.example.pentakillpdm123.login.PreferencesManager
import com.example.pentakillpdm123.navigation.NavRoutes
import com.example.pentakillpdm123.onboarding.LaunchScreen
import com.example.pentakillpdm123.positionchamp.PositionChamp
import com.example.pentakillpdm123.ui.theme.Pentakillpdm123Theme

import com.google.accompanist.pager.ExperimentalPagerApi
import kotlinx.coroutines.handleCoroutineException

class MainActivity : AppCompatActivity() {

    @OptIn(ExperimentalPagerApi::class)
    private var canAuthenticate = false
    private lateinit var promptInfo: BiometricPrompt.PromptInfo
    private lateinit var biometricPrompt: BiometricPrompt
    var isAuthenticated = mutableStateOf(false)

    @SuppressLint("UnsafeOptInUsageError")
    @OptIn(ExperimentalPagerApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpAuth()
        setContent {
            Pentakillpdm123Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                )
                {
                    val navController = rememberNavController()

                    Surface(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        //Auth(isAuthenticated, onAuthenticated = ::handleAuthenticationResult )
                        NavigationHost(navController)
                    }
                }
            }
        }
    }
    private fun setUpAuth() {
        val biometricManager = BiometricManager.from(this)
        if (biometricManager.canAuthenticate(BiometricManager.Authenticators.BIOMETRIC_WEAK or BiometricManager.Authenticators.DEVICE_CREDENTIAL) == BiometricManager.BIOMETRIC_SUCCESS) {
            Log.d("MainActivity", "Puede autenticar")
            canAuthenticate = true
            promptInfo = BiometricPrompt.PromptInfo.Builder()
                .setTitle("Autenticación biométrica")
                .setSubtitle("Inicia sesión usando tu huella digital")
                .setAllowedAuthenticators(BiometricManager.Authenticators.BIOMETRIC_WEAK or BiometricManager.Authenticators.DEVICE_CREDENTIAL)
                .build()
            biometricPrompt = BiometricPrompt(
                this,
                ContextCompat.getMainExecutor(this),
                object : BiometricPrompt.AuthenticationCallback() {
                    override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                        super.onAuthenticationError(errorCode, errString)
                        Log.d("MainActivity", "onAuthenticationError: $errString ($errorCode)")

                        // Manejar error
                    }

                    override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                        super.onAuthenticationSucceeded(result)
                        Log.d("MainActivity", "onAuthenticationSucceeded")

                        // Autenticación exitosa
                        handleAuthenticationResult(true)
                    }

                    override fun onAuthenticationFailed() {
                        super.onAuthenticationFailed()
                        // Autenticación fallida
                        Log.d("MainActivity", "onAuthenticationFailed")
                        handleAuthenticationResult(false)
                    }
                })
        } else {
            Log.d("MainActivity", "No puede autenticar")
            // Manejar el caso donde no se puede autenticar
        }
    }

    private fun handleAuthenticationResult(result: Boolean) {
        Log.d("MainActivity", "aquiii")

        isAuthenticated.value = result  // Actualiza el estado observado

        //canAuthenticate = result
        // Aquí puedes manejar el resultado de la autenticación
        // Por ejemplo, puedes cambiar el estado de la UI o navegar a otra pantalla
    }


    fun authenticate(onAuthenticated: (Boolean) -> Unit) {
        if (canAuthenticate) {
            Log.d("MainActivity", "Intentando autenticar")
            biometricPrompt.authenticate(promptInfo)
        } else {
            // Manejar el caso donde no se puede autenticar
            Log.d("MainActivity", "No se puede autenticar")
            onAuthenticated(false)
        }
    }

}
@SuppressLint("SuspiciousIndentation")
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    NavigationHost(navController = navController)

}

@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalPagerApi::class)
@Composable
fun NavigationHost(navController: NavHostController) {
    val context = LocalContext.current
    val preferencesManager = remember { PreferencesManager(context) }
    val navController = rememberNavController()
    val alreadyShowOnboarding = remember { mutableStateOf(preferencesManager.getData("alreadyShowOnboarding",false))}
        NavHost(
            navController, startDestination = if (!alreadyShowOnboarding.value) {
            NavRoutes.launch.route
        }else{
            NavRoutes.login.route
        }
        ){
            composable(NavRoutes.onboarding.route) {
                OnBoardingView(navController)
            }
            composable(NavRoutes.homemainview.route) {
                HomeMainView(navController)
            }
            composable(NavRoutes.positionchamps.route) {
                PositionChamp(navController)
            }
            composable(NavRoutes.login.route) {
                LoginScreenView(navController)
            }
            composable(NavRoutes.news.route) {
                Text(text = "Noticias")
            }
            composable(NavRoutes.launch.route) {
                LaunchScreen(navController)
            }
        }
    }
    @Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Pentakillpdm123Theme {
    }
}