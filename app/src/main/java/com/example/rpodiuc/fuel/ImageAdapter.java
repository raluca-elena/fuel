package com.example.rpodiuc.fuel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by rpodiuc on 5/12/15.
 */
public class ImageAdapter extends BaseAdapter{

    private Context mContext;
    public ImageAdapter(Context c) {
        mContext = c;
    }


    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(330, 330));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(1, 1, 1, 1);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }


    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
          //  R.drawable.sample_6, R.drawable.sample_7,
          //  R.drawable.sample_0, R.drawable.sample_1,
           // R.drawable.sample_2, R.drawable.sample_3,
           // R.drawable.sample_4, R.drawable.sample_5,
           // R.drawable.sample_6, R.drawable.sample_7,
           // R.drawable.sample_0, R.drawable.sample_1,
           // R.drawable.sample_2, R.drawable.sample_3,
           // R.drawable.sample_4, R.drawable.sample_5,
           // R.drawable.sample_6, R.drawable.sample_7
    };
}
