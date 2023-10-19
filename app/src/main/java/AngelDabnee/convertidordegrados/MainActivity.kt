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
    //variable del valor de temperatura capturada
    private var value: String = ""
    private var endResult : Double = 0.0
    //no le damos un valor al iniciarla.
    private  lateinit var total : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //variable que capturará lo que trae el texto que ingrese.
        var temp = findViewById<EditText>(R.id.editTextNumberDecimal_write_temperature)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val bottonConvert = findViewById<Button>(R.id.button_convert)

        //Aqui le pasamos lo que deberia de llevar el texview de resultado
        total = findViewById(R.id.textView_results)
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
                    conversion = position
                    //Toast.makeText(this@MainActivity, "opcionseleccionada " + position, Toast.LENGTH_SHORT).show()

                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }


        }

        bottonConvert.setOnClickListener{
            //Convertimos lo que nos pasen en el valor que capture a string para luego convertirlo a double
            value = temp.text.toString()
            converter(conversion)


        }

    }
    fun converter(convert:Int){
        when(convert){
            0 ->{
                //°Cto°F
                //Toast.makeText(this,"°C to F°",Toast.LENGTH_SHORT).show()
                //convertimos a double.
                value.toDouble()
                //Aplicamos la formula
                endResult = ((value.toDouble() * 9/5) + 32)
                total.text = endResult.toString()
            }
            1 ->{
                //°Cto°K
                //Toast.makeText(this,"°C to K°",Toast.LENGTH_SHORT).show()
                value.toDouble()
                //Aplicamos la formula
                endResult = ((value.toDouble() + 273.15))
                total.text = endResult.toString()
            }
            2 ->{
                //°Fto°C
                //Toast.makeText(this,"°F to C°",Toast.LENGTH_SHORT).show()
                value.toDouble()
                //Aplicamos la formula
                endResult = ((value.toDouble() -32) * 5/9)
                total.text = endResult.toString()
            }
            3 ->{
                //°Fto°K
                //Toast.makeText(this,"°F to K°",Toast.LENGTH_SHORT).show()
                value.toDouble()
                //Aplicamos la formula
                endResult = ((value.toDouble() -32) * 5/9 + 273.15)
                total.text = endResult.toString()
            }
            4 ->{
                //°Kto°C
                //Toast.makeText(this,"°K to C°",Toast.LENGTH_SHORT).show()
                value.toDouble()
                //Aplicamos la formula
                endResult = (value.toDouble() -273.15)
                total.text = endResult.toString()
            }
            5 ->{
                //°Kto°F
                //Toast.makeText(this,"°K to F°",Toast.LENGTH_SHORT).show()
                value.toDouble()
                //Aplicamos la formula
                endResult = (value.toDouble() -273.15) * 9/5 +32
                total.text = endResult.toString()
            }
        }
    }
}