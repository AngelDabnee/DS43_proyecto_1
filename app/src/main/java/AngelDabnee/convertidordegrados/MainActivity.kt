package AngelDabnee.convertidordegrados

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val captureTemperautre = findViewById<EditText>(R.id.editTextNumberDecimal_write_temperature)
        val selectConvert = findViewById<Spinner>(R.id.spinner)
        val bottonConvert = findViewById<Button>(R.id.button_convert)
        val showResult = findViewById<TextView>(R.id.textView_results)

        bottonConvert.setOnClickListener{
            Toast.makeText(this,"" + captureTemperautre.text, Toast.LENGTH_SHORT).show()
        }

    }
    public fun converter(){
        //TODO add when statement to process conversion.

    }
}