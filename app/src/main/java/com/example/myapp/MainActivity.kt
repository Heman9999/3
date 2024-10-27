package com.example.myapp

import android.annotation.SuppressLint
import android.graphics.Color
import android.media.MediaRecorder
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.View
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
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "SetTextI18n", "ResourceType",
        "CutPasteId"
    )
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
            var startTV : TextView = findViewById(R.id.btnRecord)
            var stopTV : TextView = findViewById(R.id.btnStop);
            var playTV :TextView = findViewById(R.id.btnPlay)
            var stopplayTV : TextView = findViewById(R.id.btnStopPlay)
            var status : TextView = findViewById(R.id.idTVstatus);
            var mFileName : String = ""
            var mRecorder : MediaRecorder = MediaRecorder()


            stopTV.setBackgroundColor(Color.parseColor(getString(R.color.gray)))
            playTV.setBackgroundColor(Color.parseColor(getString(R.color.gray)))
            stopplayTV.setBackgroundColor(Color.parseColor(getString(R.color.gray)))



            fun startRecording(){
                Log.v(TAGS,"Start Recording");


                try {
                    stopTV.setBackgroundColor(Color.parseColor(getString(R.color.purple_200)))
                    startTV.setBackgroundColor(Color.parseColor(getString(R.color.gray)))
                    playTV.setBackgroundColor(Color.parseColor(getString(R.color.gray)))
                    stopplayTV.setBackgroundColor(Color.parseColor(getString(R.color.gray)))

                    mFileName = Environment.getExternalStorageDirectory().absolutePath;
                    mFileName += "/AudioRecording.3gp"

                    mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC)
                    mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
                    mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)

                    mRecorder.setOutputFile(mFileName);
                    mRecorder.prepare()
                }catch (e :Exception){

                    Log.v(TAGS,e.message.toString())
                }
                mRecorder.start()
                startTV.setText("Recording Started")
            }

            startTV.setOnClickListener(object : View.OnClickListener{
                override fun onClick(v: View?) {
                    startRecording()
                }
            })

            fun pauseRecording(){
                Log.v(TAGS,"Stop Recording");
                stopTV.setBackgroundColor(Color.parseColor(getString(R.color.gray)))
                startTV.setBackgroundColor(Color.parseColor(getString(R.color.purple_200)))
                playTV.setBackgroundColor(Color.parseColor(getString(R.color.purple_200)))

                stopplayTV.setBackgroundColor(Color.parseColor(getString(R.color.purple_200)))

                mRecorder.stop()
                mRecorder.release()
                status.setText("Recording Stopped");
            }

            stopTV.setOnClickListener{ pauseRecording() }


        }catch (e : Exception){
            Log.v(TAGS,e.toString())
        }



    }
}



