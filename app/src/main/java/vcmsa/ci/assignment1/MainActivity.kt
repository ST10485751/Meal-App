package vcmsa.ci.assignment1

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

   var inputTime : EditText? = null
    var display: Button? = null
    var reset: Button? = null
    var mealsuggest: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        inputTime = findViewById<View>(R.id.inputTime) as EditText
        display = findViewById<View>(R.id.display) as Button
        reset = findViewById<View>(R.id.reset) as Button
        mealsuggest = findViewById<View>(R.id.mealsuggest) as TextView

        display!!.setOnClickListener {
            val TimeofDay = inputTime!!.text.toString()
            val mealsuggestion = when (TimeofDay) {

                "morning" -> "Breakfast : Pancakes with bacon"
                "mid morning" -> "Snack 1: Bowl of fruit salad"
                "Afternoon" -> "Lunch : Chicken wrap"
                "mid afternoon" -> "Snack 2: Chicken sandwhich"
                "evening" -> "Supper: Pap and beef stew"

                else -> "Invalid input poi !!!"
            }
            mealsuggest!!.text = mealsuggestion

            reset!!.setOnClickListener {

                inputTime!!.text.clear()

                mealsuggest!!.text = ""

            }
        }

            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }
    }

