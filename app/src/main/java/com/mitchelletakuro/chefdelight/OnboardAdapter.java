package com.mitchelletakuro.chefdelight;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

public class OnboardAdapter extends PagerAdapter {

    private Context mContext;
    ArrayList<OnboardItem> onboardItems = new ArrayList<>();

    public  OnboardAdapter (Context mContext, ArrayList<OnboardItem> items){
        this.mContext =mContext;
        this.onboardItems = items;
    }

    @Override
    public int getCount() {
        return onboardItems.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.onboarding_intro, container, false);

       OnboardItem item= onboardItems.get(position);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.iv_onboard);
        imageView.setImageResource(item.getImageID());

        TextView tv_title=(TextView)itemView.findViewById(R.id.tv_header_onboard);
        tv_title.setText(item.getTitle());

        TextView tv_content=(TextView)itemView.findViewById(R.id.tv_desc_onboard);
        tv_content.setText(item.getDescription());

        container.addView(itemView);

        return itemView;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }



}

