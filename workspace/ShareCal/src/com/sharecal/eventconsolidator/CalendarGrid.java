package com.sharecal.eventconsolidator;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class CalendarGrid extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_grid);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_calendar_grid, menu);
        return true;
    }
}
