package com.example.myapp

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.TextClock
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapp.ui.theme.MyApplicationTheme
import java.util.Calendar


class MainActivity : ComponentActivity() {
    var valueArray = arrayOf("Nile", "Amazon", "Yangtze")
    var increment: Int = 1
    val TAG: String = "MyActivitys"
    val TAGS: String = "MyActivitysi"
    @RequiresApi(Build.VERSION_CODES.R)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "SetTextI18n", "ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.recording)
        var textClock : TextClock = findViewById(R.id.clock);

        try {
            Log.e(TAGS,"Hello World");
            var value: CharSequence = textClock.format12Hour
            var hour : Int = Calendar.getInstance().get(Calendar.HOUR)
            var minute : Int = Calendar.getInstance().get(Calendar.MINUTE)
            Log.v(TAGS,hour.toString());
            Log.v(TAGS,minute.toString());
            var hourText: TextView = findViewById(R.id.hours)
            Log.v(TAGS,hourText.text.toString());
            hourText.text
            hourText.setText(hour.toString())


        }catch (e : Exception){
            Log.v(TAGS,e.toString());
        }

        try {
            var startTV : TextView = findViewById(R.id.idTVstatus)
            var stopTV : TextView = findViewById(R.id.btnStop);
            var playTV :TextView = findViewById(R.id.btnPlay)
            var stopplayTV : TextView = findViewById(R.id.btnStopPlay)
            var status : TextView = findViewById(R.id.idTVstatus);

//            stopTV.setBackgroundColor(getResources().getColor(R.color.));
//            playTV.setBackgroundColor(getResources().getColor(R.color.gray));
//            stopplayTV.setBackgroundColor(getResources().getColor(R.color.gray));

            stopTV.setBackgroundColor(Color.parseColor(getString(R.color.gray)))
        }catch (e : Exception){
            Log.v(TAGS,e.toString())
        }

    }
    fun hello(){
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    for(name in valueArray){
                        Greeting(
                            names = name,
                            modifier = Modifier.padding(start = 20.dp*increment, top = 100.dp*increment)
                        )
                        Log.v(TAG,name)
                        increment = increment + 1;
                    }

                    Button(onClick = {
                        increment = 1;
                        valueArray += "Hello World"
                        for(value in valueArray){
                            Log.v(TAG, value)
                        }
                        hello()
                    },Modifier.padding(start = 100.dp, top = 500.dp)){

                        Text("Hello World")
                    }
                }

            }
        }
    }
}




//@Composable
//fun TimeGraph(
//    hoursHeader : @Composable()-> Unit,
//    rowCount : Int,
//    dayLabel: @Composable(Index : Int) -> Unit,
//    sleepBar: @Composable(index : Int) -> Unit,
//    )

@Composable
fun Greeting(names : String, modifier: Modifier = Modifier) {
        Text(
            text = "Hello $names!",
            modifier = modifier
        )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
//        Greeting("Android")
    }
}