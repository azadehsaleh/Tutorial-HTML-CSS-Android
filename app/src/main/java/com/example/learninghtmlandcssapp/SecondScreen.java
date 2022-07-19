package com.example.learninghtmlandcssapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Switch;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.learninghtmlandcssapp.databinding.SeconscreenBinding;

import java.util.ArrayList;

public class SecondScreen extends AppCompatActivity {
    private SeconscreenBinding binding;
    private ArrayList<Courses> CourseList = courseClass.get().getCourses();
    private  CoursesAdapter courseAdapter;
    private int startCode = 1;  // requestCode : If >= 0, this code will be returned in onActivityResult() when the activity exits

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seconscreen);
        this.binding= SeconscreenBinding.inflate(getLayoutInflater());
        setContentView(this.binding.getRoot());


        // specify and set the adapter
        courseAdapter = new CoursesAdapter(this,CourseList);
        binding.etListview.setAdapter(courseAdapter);


        ListView listView = findViewById(R.id.etListview);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Switch ForceSequentialProgression = (Switch) findViewById(R.id.ForceSequentialProgression);
                boolean swichStatus = ForceSequentialProgression.isChecked();
                Intent intent = new Intent(SecondScreen.this,lessonDetail.class);
                if (swichStatus){
                    if (i>0) {
                        if (CourseList.get(i - 1).isCheckStatus()) {
                            intent.putExtra("courseClick", CourseList.get(i));
                            //to get something back from child screen
                            startActivityForResult(intent, startCode);
                        }
                    } else if (i == 0) {
                        intent.putExtra("courseClick", CourseList.get(i));
                        startActivityForResult(intent, startCode);
                    }
                  
                } else{
                    intent.putExtra("courseClick", CourseList.get(i));
                    startActivityForResult(intent, startCode);
                }
            }
        });

      // LogOut Button
      this.binding.LogoutButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              SharedPreferences sharedPref = getSharedPreferences("toggleBox",MODE_PRIVATE);
              SharedPreferences.Editor editor = sharedPref.edit();
              editor.putString("toggleOn","false");
              editor.clear();
              editor.apply();
              Intent intent=new Intent(SecondScreen.this,MainActivity.class);
              startActivity(intent);
              finish();
          }
      });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode  == startCode ) //if same activity or not
            if (resultCode == RESULT_OK) { // activity succeed or not
                //This will automatically refresh the ListView with the values in the ArrayList
                courseAdapter.notifyDataSetChanged();
            }
    }


}
