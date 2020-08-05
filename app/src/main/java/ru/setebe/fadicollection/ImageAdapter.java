package ru.setebe.fadicollection;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 11/18/2019.
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    private Context mContent;
    private List<Upload> mUploads;
    public Map<Integer, String> myMap;



    public ImageAdapter(Context context, List<Upload> uploads){


        mContent = context;
        mUploads = uploads;
        myMap = new HashMap<Integer, String>();

    }




    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(mContent).inflate(R.layout.image_item, parent, false);
       return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ImageViewHolder holder, int position) {
        Upload uploadCurrent = mUploads.get(position);
        holder.textViewName.setText(uploadCurrent.getName());
        Picasso.with(mContent)
                .load(uploadCurrent.getImageUrl())
                .placeholder(R.mipmap.ic_launcher)
                .fit()
                .centerCrop()
                .into(holder.imageView);





        holder.okk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (holder.raqam.getText().toString().equals("")){
                    holder.okk.setChecked(false);



                }

                else {

                    holder.okk.setChecked(true);
                    myMap.put(holder.getPosition(), holder.textViewName.getText().toString()
                            + ":  soni: "+ holder.raqam.getText().toString());

                    holder.opa.setText(holder.raqam.getText());
                    holder.nov.setVisibility(View.VISIBLE);
                    holder.raqam.setVisibility(View.INVISIBLE);
                    holder.opa.setVisibility(View.VISIBLE);

                }

            }
        });


        holder.nov.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



              holder.nov.setVisibility(View.INVISIBLE);
                holder.okk.setChecked(false);
              myMap.remove(holder.getPosition());
                holder.raqam.getText().clear();


            holder.raqam.setVisibility(View.VISIBLE);
            holder.opa.setVisibility(View.INVISIBLE);


            }
        });





    }

    @Override
    public int getItemCount() {
        return  mUploads.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {


        public TextView textViewName;
        public ImageView imageView;
        public CheckBox okk;
        public Button nov;
        public EditText raqam;
        public TextView opa;


        public ImageViewHolder(View itemView){

            super(itemView);
            opa = itemView.findViewById(R.id.opa);
            raqam = itemView.findViewById(R.id.raqam);
            nov = itemView.findViewById(R.id.nov);
            okk = itemView.findViewById(R.id.okk);
            textViewName=itemView.findViewById(R.id.text_view_name);
            imageView = itemView.findViewById(R.id.image_view_upload);


        }
    }

}
