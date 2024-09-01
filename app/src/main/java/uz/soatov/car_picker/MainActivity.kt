package uz.soatov.car_picker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.soatov.car_picker.ui.theme.Car_pickerTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
			Car_pickerTheme {
				CarPicker()
			}
		}
	}
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CarPicker() {
	CarImageAndButton(
		Modifier
			.fillMaxSize()
			.wrapContentSize(align = Alignment.Center)
	)
}

@Composable
fun CarImageAndButton(modifier: Modifier = Modifier) {
	var result by remember {
		mutableStateOf<Int>(1)
	}
	val imageId = when (result) {
		1 -> R.drawable.car_1
		2 -> R.drawable.car_2
		3 -> R.drawable.car_3
		4 -> R.drawable.car_4
		5 -> R.drawable.car_5
		6 -> R.drawable.car_6
		else -> R.drawable.car_1
	}
	Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier) {
		Image(painter = painterResource(id = imageId), contentDescription = null, contentScale = ContentScale.Fit, modifier = Modifier.width(300.dp).height(300.dp))
		Button(onClick = {
			if (result === 6) {
				result = 1
			} else {
				result++
			}

		}) {
			Text(
				text = "Keyingi mashina"
			)
		}
	}
}