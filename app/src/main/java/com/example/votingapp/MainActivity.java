package com.example.votingapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ToggleButton;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button =findViewById(R.id.button1);
        EditText NameEditText = (EditText) findViewById(R.id.input1);
        EditText wordEditText = (EditText) findViewById(R.id.input2);
        ToggleButton toggleButton1 =(ToggleButton) findViewById(R.id.toggleButton1);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String Name=NameEditText.getText().toString();
                final String word=wordEditText.getText().toString();
                final String switchState = toggleButton1.getText().toString();

                if(Name.length()==0)
                {
                    NameEditText.requestFocus();
                    NameEditText.setError("FIELD CANNOT BE EMPTY");
                }

                else if(!word.matches("^[cC][0-9]{6}$"))
                {
                    wordEditText.requestFocus();
                    wordEditText.setError("ENTER C and then SIX numbers");
                }
                else if(!switchState.equals("Accept"))
                {

                    Toast.makeText(getApplicationContext(), "you need to accept the terms and conditions", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Validation Successful",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}