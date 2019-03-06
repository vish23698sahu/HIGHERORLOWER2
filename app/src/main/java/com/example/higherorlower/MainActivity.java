package com.example.higherorlower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int ranNumber;
    String message;

    public void generatingRandomNumber(){
        Random rand=new Random();
        ranNumber=rand.nextInt(30)+1;
    }

    public void Guess (View view){

        EditText editText = (EditText) findViewById(R.id.editText);

        int guessValue = Integer.parseInt(editText.getText().toString());


        if(guessValue > ranNumber) {
            message="Lower..!";
            editText.setText("");

        }
        else
            if(guessValue < ranNumber){
                message="Higher";
                editText.setText("");
            }
            else
                if(guessValue == ranNumber){
                    message="You got it..!, Try again..";
                    editText.setText("");

                    generatingRandomNumber();
                }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

        Log.i("Entered value is:",editText.getText().toString());
        Log.i("random Number:", Integer.toString(ranNumber));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generatingRandomNumber();
    }
}