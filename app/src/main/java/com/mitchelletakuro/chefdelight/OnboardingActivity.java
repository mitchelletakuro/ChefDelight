package com.mitchelletakuro.chefdelight;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mitchelletakuro.chefdelight.ui.PrefManager;

import java.util.ArrayList;

public class OnboardingActivity extends AppCompatActivity {

    private ViewPager onboard_pager;
    private TextView  next_tv ;
    private  TextView[] dots;
    private Button    get_started_btn;
    private OnboardAdapter onboardAdapter;
    private LinearLayout dotsLayout;
    private int dotCounts;
    private  PrefManager prefManager;



   ArrayList<OnboardItem> onBoardItems=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        prefManager = new PrefManager(this);
        if(!prefManager.Check()){
            prefManager.setFirst(false);
            Intent intent = new Intent(OnboardingActivity.this,LoginActivity.class);
            startActivity(intent);
            finish();
        }

        setContentView(R.layout.activity_intro);
        setStatusBackgroundColor();
        hideActionBar();

         onboard_pager = findViewById(R.id.onboard_vp);
         get_started_btn = findViewById(R.id.get_started_Btn);
         dotsLayout = findViewById(R.id.layoutDots);
         next_tv= findViewById(R.id.obNxtTv);

         loadData();


         onboardAdapter = new OnboardAdapter(this, onBoardItems);
         onboard_pager.setAdapter(onboardAdapter);
         onboard_pager.setCurrentItem(0);
         onboard_pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
             @Override
             public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

             }

             @Override
             public void onPageSelected(int position) {

             }

             @Override
             public void onPageScrollStateChanged(int state) {

             }
         });

      get_started_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                prefManager.setFirst(false);
                Intent intent = new Intent(OnboardingActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }




    private void setStatusBackgroundColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().getDecorView().setSystemUiVisibility(
                   View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
                     getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.black_transparent));
        }
    }

    private void hideActionBar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }


    public void loadData()
    {

        int[] header = {R.string.ob_header_1, R.string.ob_header_2, R.string.ob_header_3};
        int[] desc = {R.string.ob_desc_1, R.string.ob_desc_2, R.string.ob_desc_3};
        int[] imageId = {R.drawable.ob1, R.drawable.ob2, R.drawable.ob3};

        for(int i=0;i<imageId.length;i++)
        {
            OnboardItem item=new OnboardItem();
            item.setImageID(imageId[i]);
            item.setTitle(getResources().getString(header[i]));
            item.setDescription(getResources().getString(desc[i]));

           onBoardItems.add(item);
        }
    }


    public  void ob_next (View view){
      
    }






}



