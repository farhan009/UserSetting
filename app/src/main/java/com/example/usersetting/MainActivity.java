package com.example.usersetting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = findViewById(R.id.layout_id);

        if (loadColor() != 0){
            linearLayout.setBackgroundColor(loadColor());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.red_Color){
            linearLayout.setBackgroundColor(getResources().getColor(R.color.red));
            storeColor(getResources().getColor(R.color.red));
        }
        if (item.getItemId() == R.id.green_Color){
            linearLayout.setBackgroundColor(getResources().getColor(R.color.green));
            storeColor(getResources().getColor(R.color.green));
        }
        if (item.getItemId() == R.id.blue_Color){
            linearLayout.setBackgroundColor(getResources().getColor(R.color.blue));
            storeColor(getResources().getColor(R.color.blue));
        }
        if (item.getItemId() == R.id.pink_Color){
            linearLayout.setBackgroundColor(getResources().getColor(R.color.pink));
            storeColor(getResources().getColor(R.color.pink));
        }
        if (item.getItemId() == R.id.gray_Color){
            linearLayout.setBackgroundColor(getResources().getColor(R.color.gray));
            storeColor(getResources().getColor(R.color.gray));
        }

        return super.onOptionsItemSelected(item);
    }

    private void storeColor(int color){
        SharedPreferences sharedPreferences = getSharedPreferences("backgroundColor", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("lastColor", color);
        editor.commit();
    }

    private int loadColor(){

        SharedPreferences sharedPreferences = getSharedPreferences("backgroundColor", Context.MODE_PRIVATE);
        int colorLoad = sharedPreferences.getInt("lastColor", getResources().getColor(R.color.colorPrimary));

        return colorLoad;
    }
}
