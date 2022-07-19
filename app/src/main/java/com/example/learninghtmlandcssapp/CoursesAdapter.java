package com.example.learninghtmlandcssapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import com.example.learninghtmlandcssapp.databinding.ActivityCustomRowLayoutBinding;

import java.util.List;

public class CoursesAdapter extends ArrayAdapter<Courses> {
    int images[]={R.drawable.number1,R.drawable.number2,R.drawable.number3,R.drawable.number4};
    int IsCompleteImage = R.drawable.checked;

    // Fill in the template code for an array adapter:
    public CoursesAdapter(@NonNull Context context,@NonNull List<Courses> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        ActivityCustomRowLayoutBinding binding;
        if( convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_custom_row_layout,parent,false);
        }
        binding = ActivityCustomRowLayoutBinding.bind(convertView);
        Courses currCourse = getItem(position);
        binding.image.setImageResource(images[position]);
        binding.maintitleview.setText(currCourse.getNameOfLesson());
        binding.subtitleview.setText(String.valueOf(currCourse.getLengthOfVideo()));
        if(currCourse.isCheckStatus()){
            binding.simpleCheckedTextView.setVisibility(View.VISIBLE);
            binding.simpleCheckedTextView.setCheckMarkDrawable(IsCompleteImage);
        } else {
            binding.simpleCheckedTextView.setVisibility(View.GONE);
        }
        return convertView;
    }


}
