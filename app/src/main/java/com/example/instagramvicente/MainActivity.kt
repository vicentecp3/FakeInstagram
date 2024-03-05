package com.example.instagramvicente

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.ImageShader
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.instagramvicente.ui.theme.InstagramVicenteTheme

/*
Vicente Castro
 */

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InstagramVicenteTheme {
                Myapp()
            }
        }
    }
}

@Preview
@Composable
fun Myapp(modifier: Modifier = Modifier){
    var shouldShowOnboarding by remember { mutableStateOf(true) }
    Surface(Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.primary) {
        if (shouldShowOnboarding) {
            OnboardingScreen(onContinueClicked = { shouldShowOnboarding = false })
        }else{
            PantallaFeed()
        }
    }
}

@Composable
fun OnboardingScreen(
    onContinueClicked: () -> Unit,
) {
    Column(
        modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            modifier = Modifier.size(250.dp),
            painter = painterResource(id = R.drawable.instagram_logo_svg),
            contentDescription = "Logo de login"
        )
        Usuario()
        Contrasenia()
        Button(
            onClick = {
                onContinueClicked()
            },
            modifier = Modifier
                .fillMaxWidth()  // Hace que el botón ocupe todo el ancho disponible
                .padding(20.dp),  // Agrega un margen alrededor del botón // Establece el color de fondo del botón
            contentPadding = PaddingValues(16.dp)  // Ajusta el relleno del contenido del botón
        ) {
            Text(text = "Iniciar sesión")  // Establece el color del texto del botón
        }
        Text(text = "\n¿Olvidaste tu contraseña?")
    }
}

@Composable
private fun PantallaFeed() {
    val imagenUsuario =
        ShaderBrush(ImageShader(ImageBitmap.imageResource(id = R.drawable.usuario__1_)))        // imagen de usuarios

    Surface(

    ) {
        Column {
            Row(modifier = Modifier
                .padding(6.dp)
                .horizontalScroll(rememberScrollState())) {
                for (i in 1..10) {
                Canvas(
                    onDraw = { drawCircle(imagenUsuario) },
                    modifier = Modifier
                        .size(90.dp)
                        .padding(10.dp)
                        .border(BorderStroke(2.dp, Color.Red), CircleShape)
                )
                Canvas(
                    onDraw = { drawCircle(imagenUsuario) },
                    modifier = Modifier
                        .size(90.dp)
                        .padding(10.dp)
                        .border(BorderStroke(2.dp, Color.Red), CircleShape)
                )
                Canvas(
                    onDraw = { drawCircle(imagenUsuario) },
                    modifier = Modifier
                        .size(90.dp)
                        .padding(10.dp)
                        .border(BorderStroke(2.dp, Color.Red), CircleShape)
                )
                Canvas(
                    onDraw = { drawCircle(imagenUsuario) },
                    modifier = Modifier
                        .size(90.dp)
                        .padding(10.dp)
                        .border(BorderStroke(2.dp, Color.Red), CircleShape)
                )
            }
            }
                Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                    for (i in 1..10) {
                    Image(
                        modifier = Modifier.size(400.dp),
                        painter = painterResource(id = R.drawable.post),
                        contentDescription = null
                    )
                    Row {
                        Row {
                            Icon(
                                modifier = Modifier.padding(10.dp),
                                painter = painterResource(id = R.drawable.baseline_favorite_border_24),
                                contentDescription = "like"
                            )
                            Icon(
                                modifier = Modifier
                                    .padding(10.dp)
                                    .width(24.dp)
                                    .height(24.dp),
                                painter = painterResource(id = R.drawable.comentario),
                                contentDescription = "comentario"
                            )
                            Icon(
                                modifier = Modifier
                                    .padding(10.dp)
                                    .width(24.dp)
                                    .height(24.dp),
                                painter = painterResource(id = R.drawable.enviar),
                                contentDescription = "Enviar"
                            )
                        }
                        Row(
                            horizontalArrangement = Arrangement.End,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Icon(
                                modifier = Modifier
                                    .padding(10.dp)
                                    .width(24.dp)
                                    .height(24.dp),
                                painter = painterResource(id = R.drawable.marcador),
                                contentDescription = "Enviar"
                            )
                        }
                    }
                    Text(text = "1405 Me gusta", modifier = Modifier.padding(10.dp))
                    Row {
                        Text(buildAnnotatedString {
                                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)){
                                    append("Instagram ")
                                }
                            append("Hola que tal aquí va el pie de foto y to aquello que tu quieras colocar en el post... más") },
                            modifier = Modifier.padding(horizontal = 10.dp),
                        )
                    }
                        Spacer(modifier = Modifier.padding(10.dp))
                }
            }
        }
    }
}

@Composable
fun Usuario() {
    var value by remember { mutableStateOf("") }

    TextField(
        value = value,
        onValueChange = { value = it },
        label = { Text("Usuario") },
        maxLines = 1,
        textStyle = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold),
        modifier = Modifier.padding(20.dp)
    )
}

@Composable
fun Contrasenia() {
    var password by rememberSaveable { mutableStateOf("") }

    TextField(
        value = password,
        onValueChange = { password = it },
        label = { Text("Contraseña") },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
    )
}





