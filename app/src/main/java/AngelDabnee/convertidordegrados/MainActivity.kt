package AngelDabnee.convertidordegrados

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var conversion : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val captureTemperautre = findViewById<EditText>(R.id.editTextNumberDecimal_write_temperature)
        val spinner = findViewById<Spinner>(R.id.spinner)
        val bottonConvert = findViewById<Button>(R.id.button_convert)
        val resultConvert = findViewById<TextView>(R.id.textView_results)
        val options = resources.getStringArray(R.array.convert_option)

        //Así se prepara el spiner, dandole los elementos según lo que lo querramos rellenar
        if (spinner != null){
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, options)
            spinner.adapter = adapter


            spinner.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener{
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    Toast.makeText(this@MainActivity, "opcionseleccionada", Toast.LENGTH_SHORT).show()

                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }


        }

        bottonConvert.setOnClickListener{
            converter(conversion)
        }

    }
    fun converter(convert:Int){
        when(convert){
            0 ->{
                //°Cto°F
            }
            1 ->{
                //°Cto°K
            }
            2 ->{
                //°Fto°C
            }
            3 ->{
                //°Fto°K
            }
            4 ->{
                //°Kto°C
            }
            5 ->{
                //°Kto°F
            }
        }
    }
}