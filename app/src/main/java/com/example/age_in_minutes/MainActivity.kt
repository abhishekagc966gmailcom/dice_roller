package com.example.age_in_minutes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random as Random

class MainActivity : AppCompatActivity() {

    lateinit var dice_image:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // we can call methods on our rollbutton
        val rollButton:Button = findViewById(R.id.roll_button)
        rollButton.text="Let's Roll"
        //IT takes single lambda object context message and duration
        //since mainactivity is subclass of context we can write this
        rollButton.setOnClickListener {
           // Toast.makeText(this, "Button clicked",Toast.LENGTH_SHORT).show()
            rolldice()
        }
        dice_image= findViewById(R.id.image_dice)
    }
    private fun rolldice(){
        //val resultext:TextView=findViewById(R.id.text_result)
        //resultext.text ="Dice Rolled"
         val randomint=Random.nextInt(6)+1
       val drawable_resource= when(randomint){
            1->R.drawable.dice_1
            2->R.drawable.dice_2
            3->R.drawable.dice_3
            4->R.drawable.dice_4
            5->R.drawable.dice_5
            else->R.drawable.dice_6
       }
       // val dice_image:ImageView=findViewById(R.id.image_dice)
        // everytime we are calling our
        //roll dice method we are getting another reference to image view and we are searching for it again
        // in the activity tree which is expensive operation therefore we are going to use best
        // practice and store our Imageview in a field
        //keeping this imageview in field will allow us to reference this view directly at any time
        //
        dice_image.setImageResource(drawable_resource)


        //resultext.text=randomint.toString()
    }
}