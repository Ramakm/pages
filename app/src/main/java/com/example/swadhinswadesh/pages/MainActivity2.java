package com.example.swadhinswadesh.pages;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity2 extends ActionBarActivity {

    String date;
    TinyDB tinyDB;
    String title;
    String note;
    TextView tvtitle;
    TextView tvnote;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);

        tinyDB = new TinyDB(getApplicationContext());
        tvtitle = (TextView) findViewById(R.id.textViewtitle);
        tvnote = (TextView) findViewById(R.id.textViewnote);

        Intent intent = getIntent();
        date = intent.getStringExtra(MainActivity.DATE);

        setTitle("Notes on "+date);

        note = tinyDB.getString("note"+date);
        title = tinyDB.getString("title"+date);
        if (note == "") note = "Add a note";
        if (title == "") title = "No node saved for this day.";
        tvtitle.setText(title);
        tvnote.setText(note);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_addnote) {
            Intent intent = new Intent(MainActivity2.this, MainActivity4.class);
            intent.putExtra(MainActivity.DATE, date);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
