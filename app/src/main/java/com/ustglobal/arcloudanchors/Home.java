package com.ustglobal.arcloudanchors;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;

public class Home extends AppCompatActivity implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {

    public static final String FROM = "from";
    public static final String MODE = "mode";
    public String userMode = "user";

    public static final String APARTMENT18 = "apartment18";
    public static final String APARTMENT30 = "apartment30";
    public static final String PACKENHAMHOUSE = "packenham_house";
    public static final String FIREEXIT = "fire_exit";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laucher_activiy);
        //For background animation
        ConstraintLayout layout = findViewById(R.id.main_layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) layout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(3000);
        animationDrawable.start();

        ImageButton settingsBtn = findViewById(R.id.settings_btn);
        settingsBtn.setOnClickListener(v -> {
            PopupMenu popup = new PopupMenu(getApplicationContext(), v);
            popup.getMenuInflater().inflate(R.menu.menu_main ,popup.getMenu());
            popup.setOnMenuItemClickListener(Home.this::onMenuItemClick);
            popup.show();
        });

        ImageButton electBtn = findViewById(R.id.apartment18Btn);
        ImageButton toysBtn = findViewById(R.id.apartment30Btn);
        ImageButton tvBtn = findViewById(R.id.packenhamhouseBtn);
        ImageButton clothingBtn = findViewById(R.id.fireexitBtn);
        electBtn.setOnClickListener(this);
        toysBtn.setOnClickListener(this);
        tvBtn.setOnClickListener(this);
        clothingBtn.setOnClickListener(this);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                userMode = "user";
                return true;
            case R.id.item2:
                userMode = "admin";
                return true;
            default:
                return false;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.apartment18Btn:
                goToCameraActivity(APARTMENT18);
                break;
            case R.id.apartment30Btn:
                goToCameraActivity(APARTMENT30);
                break;
            case R.id.packenhamhouseBtn:
                goToCameraActivity(PACKENHAMHOUSE);
                break;
            case R.id.fireexitBtn:
                goToCameraActivity(FIREEXIT);
                break;

        }
    }

    private void goToCameraActivity(String Section) {
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        i.putExtra(FROM, Section);
        i.putExtra(MODE,userMode);
        startActivity(i);
    }
}
