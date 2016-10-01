package com.adventurousalex.calendargooglemapapiapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
public class FrontPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_page);



        //Here MainActivity.this is a Current Class Reference (context)
        addToDo();
    }
    // this adds the events to the to do item
    public void addToDoItem(View v){
        addToDo();
    }
    public void testButton(View v){

        addToDo();

    }

    // this creates a new to do item, still need to make it dynamic and to actually design it more
    public void addToDo() {
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

        // Creating a new TextView
        TextView title= new TextView(this);
        title.setText("Test");
        title.setGravity(Gravity.CENTER_VERTICAL);
        int titleWidth = (int) (100*scale+0.5f);
        title.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);

        // Defining the layout parameters of the TextView
        RelativeLayout.LayoutParams titleParams = new RelativeLayout.LayoutParams(
                titleWidth,
                RelativeLayout.LayoutParams.MATCH_PARENT);
        titleParams.setMargins((int)(16 * scale + 0.5f),0,0,0);
        // Setting the parameters on the TextView
        title.setLayoutParams(titleParams);

        // Adding the TextView to the RelativeLayout as a child
        toDoItem.addView(title);
        toDoContainer.addView(toDoItem);


    }




}
