package com.example.swadhinswadesh.pages;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity4 extends ActionBarActivity {

    TinyDB tinyDB;
    EditText eNoteTitle;
    EditText eNote;
    String noteTitle;
    String note;
    String date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity4);

        tinyDB = new TinyDB(getApplicationContext());
        eNoteTitle = (EditText) findViewById(R.id.editTextnotetitle);
        eNote = (EditText) findViewById(R.id.editTextnote);

        Intent intent = getIntent();
        date = intent.getStringExtra(MainActivity.DATE);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity4, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_savenote) {
            saveNote();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void saveNote() {
        noteTitle = eNoteTitle.getText().toString();
        note = eNote.getText().toString();
        tinyDB.putString("title"+date, noteTitle);
        tinyDB.putString("note"+date, note);
        Toast.makeText(getApplicationContext(), "Note saved", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity4.this, MainActivity2.class);
        intent.putExtra(MainActivity.DATE, date);
        startActivity(intent);
    }
}
