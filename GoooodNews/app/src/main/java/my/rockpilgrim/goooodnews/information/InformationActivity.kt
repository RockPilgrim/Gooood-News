package my.rockpilgrim.goooodnews.information

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import my.rockpilgrim.goooodnews.R

class InformationActivity : AppCompatActivity() {

    public val TAG = "Info"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.information_activity)
    }
}