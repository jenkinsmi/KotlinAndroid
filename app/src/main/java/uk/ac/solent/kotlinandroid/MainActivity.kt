package uk.ac.solent.kotlinandroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1.setOnClickListener {
            Toast.makeText(this, et1.getText(), Toast.LENGTH_SHORT).show()
            doAsync {
                val url = URL("http://www.free-map.org.uk/course/ws/hits.php?artist=${et1.text}")
                val response = url.readText()


                uiThread {
                    tv2.text = response
                }
            }
        }
    }
}

