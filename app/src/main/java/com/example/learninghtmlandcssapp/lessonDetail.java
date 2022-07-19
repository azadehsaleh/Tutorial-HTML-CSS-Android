package com.example.learninghtmlandcssapp;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.example.learninghtmlandcssapp.databinding.ActivityLessonDetailBinding;
public class lessonDetail extends AppCompatActivity {

    private  Courses course;
    private ActivityLessonDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_detail);

        binding = ActivityLessonDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        if(intent == null)
        {
            Log.d("No data","Data Not found");
        }
        else
        {
            course = (Courses) intent.getSerializableExtra("courseClick");
            binding.viewTitle.setText(course.getNameOfLesson());
            binding.viewLength.setText("Length :"+ course.getLengthOfVideo());
            binding.viewDescription.setText(course.getDescription());

            SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
            String data = sharedPreferences.getString(String.valueOf(course.getLessonNumber()),"");
            if(data.isEmpty())
            {
                binding.editTextTextMultiLine.setText("");
            }
            else
            {
                binding.editTextTextMultiLine.setText(data);
            }

        }

        binding.btnMarkComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                courseClass.get().updateStatus(course.getLessonNumber(),true);
                //result_ok = -1 result_canceled = 0
                Intent result = new Intent();
                setResult(RESULT_OK,result);
               // finish();
            }
        });



        binding.btnSaveNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(String.valueOf(course.getLessonNumber()),binding.editTextTextMultiLine.getText().toString());
                editor.commit();

            }
        });
    }



    public void btnWatchVideo(View v)
    {
        //Passing link directly
//        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(course.getLink()));
//        startActivity(intent);
        //Passing link to different class(webView)
        Intent intent = new Intent(lessonDetail.this,webView.class);
        intent.putExtra("link",course.getLink());
        startActivity(intent);
    }



}