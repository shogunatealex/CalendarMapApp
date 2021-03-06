package com.adventurousalex.calendargooglemapapiapp;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static android.R.attr.ellipsize;
import static android.R.attr.uiOptions;

public class FrontPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);;
        setContentView(R.layout.activity_front_page);

    }

    // this is a button listener for the buttons. Will add more as I have more buttons.
    View.OnClickListener buttonListener = (new View.OnClickListener() {
        // this adds the events to the to do item
        public void onClick(View v) {

        }

    });

    // is the buttons click activity that starts up a new page, maybe move this to the listener?
    public void toDoFillerActivity(View v) {

        startActivityForResult(new Intent(FrontPage.this,addToDoActivity.class),272);
    }

    // collects the data from any other activites that are created
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 272 && resultCode == RESULT_OK){
            addToDo(data.getStringExtra("title"),data.getStringExtra("location"),data.getStringExtra("duration"));
        }
    }

    // for the to do list. Not exactly sure if it is going to work. May need to either remove or adjust
    View.OnTouchListener toDoListener = (new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        v.getBackground().setColorFilter(0xe000000, PorterDuff.Mode.SRC_ATOP);
                        v.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        v.getBackground().clearColorFilter();
                        v.invalidate();
                        break;
                    }
                }
                return false;
            }
        });

    // this creates a new to do item, still need to make it dynamic and to actually design it more
    public void addToDo(String eventTitle, String eventLocation, String duration) {

        LinearLayout toDoContainer = (LinearLayout) findViewById(R.id.toDoListContainer);

        // For testing programatic layouts
        // Creating a new RelativeLayout
        RelativeLayout toDoItem = new RelativeLayout(this);
        toDoItem.setBackgroundResource(R.drawable.customborder);

        // converts a hard pixel value into a dp value
        final float scale = getApplicationContext().getResources().getDisplayMetrics().density;
        int pixels = (int) (48 * scale + 0.5f);

        //sets the height and width of the toDoItem to be added
        RelativeLayout.LayoutParams hgtWdth = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, pixels);

        // add those params to the layout
        toDoItem.setLayoutParams(hgtWdth);

        //START Creating the title TextView
        TextView title= new TextView(this);
        title.setText(eventTitle);
        title.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);

        // Defining the layout parameters of the TextView
        RelativeLayout.LayoutParams titleParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);
        titleParams.setMargins((int)(16 * scale + 0.5f),0,0,0);
        title.setPadding(0,(int)(4 * scale + 0.5f),0,0);
        // Setting the parameters on the TextView
        title.setLayoutParams(titleParams);
        title.setEllipsize(TextUtils.TruncateAt.END);
        title.setMaxLines(1);
        title.setMaxWidth((int)(224 * scale + 0.5f));
        //FINISH TITLE TextView

        //START LOCATION TextView
        TextView location = new TextView(this);
        location.setText(eventLocation);
        location.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);

        // definining location layout params
        RelativeLayout.LayoutParams locationParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);
        locationParams.setMargins((int)(16 * scale + 0.5f),0,0,0);
        location.setLayoutParams(locationParams);
        location.setPadding(0,0,0,(int)(4 * scale + 0.5f));
        location.setEllipsize(TextUtils.TruncateAt.END);
        location.setMaxLines(1);
        location.setMaxWidth((int)(224 * scale + 0.5f));
        location.setGravity(Gravity.BOTTOM);
        //END LOCATION TextView

        //START VERTICAL LINE view
        View vertLine = new View(this);
        vertLine.setBackgroundColor(0xffCCCCCC);
        RelativeLayout.LayoutParams vertLineParams = new RelativeLayout.LayoutParams(
                (int)(1 * scale + 0.5f),
                (int)(48 * scale + 0.5f)
        );
        vertLineParams.setMargins((int)(248 * scale + 0.5f),(int)(8 * scale + 0.5f),0,(int)(8 * scale + 0.5f));
        vertLine.setLayoutParams(vertLineParams);
        //END VERTICAL LINE view

        //START HORIZONTAL LINE view
        View horizLine = new View(this);
        horizLine.setBackgroundColor(0xffCCCCCC);
        RelativeLayout.LayoutParams horizLineParams = new RelativeLayout.LayoutParams(
                (int)(224 * scale + 0.5f),
                (int)(1 * scale + 0.5f)
        );
        horizLineParams.setMargins((int)(16 * scale + 0.5f),(int)(24 * scale + 0.5f),0,0);
        horizLine.setLayoutParams(horizLineParams);
        //END HORIZONTAL LINE view

        toDoItem.setClickable(true);
        toDoItem.setOnTouchListener(toDoListener);
        // Adding the TextView to the RelativeLayout as a child
        toDoItem.addView(title);
        toDoItem.addView(location);
        toDoItem.addView(vertLine);
        toDoItem.addView(horizLine);
        toDoContainer.addView(toDoItem);

    }




}
