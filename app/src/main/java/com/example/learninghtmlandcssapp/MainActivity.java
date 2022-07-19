package com.example.learninghtmlandcssapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.learninghtmlandcssapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(this.binding.getRoot());

        // when the app run, it checks the value of toggleBox
        SharedPreferences sharedPref = getSharedPreferences("toggleBox",MODE_PRIVATE);
        String toggleBox = sharedPref.getString("toggleOn","");
        if (toggleBox.equals("true")){
            Intent intent = new Intent(MainActivity.this, SecondScreen.class);
            startActivity(intent);
        }

        binding.LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (IsValidUser() && IsValidPassword()) {
                    Intent intent = new Intent(MainActivity.this, SecondScreen.class);
                    startActivity(intent);
                } else if (ReturnEmail().isEmpty() && ReturnPassword().isEmpty()){
                    binding.etError.setText("Enter your email and password");
                } else if (ReturnEmail().isEmpty()){
                    binding.etError.setText("Enter your email");
                } else if (ReturnPassword().isEmpty()){
                    binding.etError.setText("Enter your password");
                } else if (!IsValidUser()){
                    binding.etError.setText("The username does not exist");
                        binding.editTextTextEmailAddress.setText("");
                        binding.editTextTextPassword.setText("");
                }else{
                    binding.etError.setText("The username/password combination is incorrect");
                    binding.editTextTextEmailAddress.setText("");
                    binding.editTextTextPassword.setText("");
                }
            }
        });

        binding.switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                SharedPreferences sharedPref = getSharedPreferences("toggleBox",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                if(compoundButton.isChecked() && IsValidPassword() && IsValidUser()){
                    editor.putString("toggleOn","true");
                } else {
                    editor.putString("toggleOn","false");
                }
                editor.apply();
            }
        });


    }


    public String ReturnEmail(){
        return binding.editTextTextEmailAddress.getText().toString();
    }
    public String ReturnPassword(){
        return binding.editTextTextPassword.getText().toString();
    }
    public  boolean IsValidUser(){
        if (ReturnEmail().equals("abcd")) {
            return true;
        } else {
            return false;
        }
    }
    public  boolean IsValidPassword(){
        if (ReturnPassword().equals("1234")) {
            return true;
        } else {
            return false;
        }
    }



}