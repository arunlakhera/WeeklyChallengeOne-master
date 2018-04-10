package com.slack.weeklychallengeone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;

class Pop extends Activity{



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.popwindow);

        Bundle materialTitle = getIntent().getExtras();
        String mTitle = materialTitle.getString("title").toUpperCase();

        TextView titleTextView = findViewById(R.id.material_title);
        titleTextView.setText(mTitle);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width*.8), (int) (height*.5));
        showDescription(mTitle);

    }

    public void showDescription(String title) {

        String description = "No Title";

        if (title.equals("CONSTRAINT LAYOUT")) {
            description = "A ConstraintLayout is a ViewGroup which allows you to position and size widgets in a flexible way.";
        }else  if (title.equals("LINEAR LAYOUT")) {
            description = "LinearLayout is a view group that aligns all children in a single direction, vertically or horizontally. You can specify the layout direction with the android:orientation attribute.";
        }else if (title.equals("RELATIVE LAYOUT")) {
            description = "RelativeLayout is a view group that displays child views in relative positions. The position of each view can be specified as relative to sibling elements (such as to the left-of or below another view) or in positions relative to the parent RelativeLayout area (such as aligned to the bottom, left or center).";
        }else if (title.equals("CARD VIEW")){
            description = "CardView is an easy way for you show information inside cards that have a consistent look across the platform. These cards have a default elevation above their containing view group, so the system draws shadows below them. Cards provide an easy way to contain a group of views while providing a consistent style for the container.";
        }else if (title.equals("SCROLL VIEWS")) {
            description = "A view group that allows the view hierarchy placed within it to be scrolled. Scroll view may have only one direct child placed within it. To add multiple views within the scroll view, make the direct child you add a view group, for example LinearLayout, and place additional views within that LinearLayout.";
        }else if (title.equals("GRID VIEW")) {
            description = "GridView is a ViewGroup that displays items in a two-dimensional, scrollable grid. The grid items are automatically inserted to the layout using a ListAdapter.";
        }else {
            description = "No Description";
        }

        TextView descriptionTextView = findViewById(R.id.material_description);
        descriptionTextView.setText(description);

    }

    public void closeClicked(View view) {
        startActivity(new Intent(this,MainActivity.class));
    }
}
