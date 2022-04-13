package com.example.project.Home;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project.R;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {

    ArrayList<getDetailsModel> arrayListdetails ;
    Context context ;
    public CourseAdapter(ArrayList<getDetailsModel> arrayList, Home home) {
        this.arrayListdetails = arrayList;
        context = home;
    }

    @NonNull
    @Override
    public CourseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseAdapter.ViewHolder holder, int position) {
        getDetailsModel model = arrayListdetails.get(position);
        Picasso.get().load(model.getCourseimg()).into(holder.courseImageView);
        holder.c_name_txt.setText(model.getCourseName());
        holder.c_track_txt.setText(model.getCourseTracks());
        holder.c_mode_txt.setText(model.getCourseMode());


    }

    @Override
    public int getItemCount() {
        return arrayListdetails.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView c_name_txt, c_track_txt, c_mode_txt;
        private ImageView courseImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            courseImageView = itemView.findViewById(R.id.idIVCourse);
            c_name_txt = itemView.findViewById(R.id.idTVCourseNamenew);
            c_mode_txt = itemView.findViewById(R.id.idTVBatch);
            c_track_txt = itemView.findViewById(R.id.idTVTracks);


            courseImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(context , ContentViewPAge.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("course_name", c_name_txt.getText().toString());
                    intent.putExtra("course_mode", c_mode_txt.getText().toString());
                    intent.putExtra("course_track", c_track_txt.getText().toString());
                    view.getContext().startActivity(intent);
                }
            });
        }
    }
}
