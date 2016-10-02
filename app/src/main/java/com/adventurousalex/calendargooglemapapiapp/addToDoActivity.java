package com.adventurousalex.calendargooglemapapiapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.EditText;

/**
 * Created by alexa on 10/2/2016.
 */

public class addToDoActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.addtodowindow);

        DisplayMetrics disMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(disMetrics);

        int screenWidth = disMetrics.widthPixels;
        int screenHeight = disMetrics.heightPixels;

        getWindow().setLayout((int) (screenWidth * .8), (int) (screenHeight * .8));
    }


    //sends the data back when the back button is pressed. Need to link this to a button
    @Override
    public void onBackPressed() {
        Intent i = new Intent();
        EditText title = (EditText) findViewById(R.id.toDoTitle);
        EditText location = (EditText) findViewById(R.id.eventLocation);
        EditText duration = (EditText) findViewById(R.id.eventDuration);
        i.putExtra("title",title.getText().toString());
        i.putExtra("location",location.getText().toString());
        i.putExtra("duration",duration.getText().toString());
        setResult(RESULT_OK,i);
        finish();


    }
}
