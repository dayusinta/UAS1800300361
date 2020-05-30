package com.aa183.sinta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class TampilData extends AppCompatActivity {

    ListView mListView;
    ArrayList<Model> mList;
    RecordListAdapter mAdapter = null;
    DatabaseHelper myDb;

    ImageView imageViewIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_data);
        myDb = new DatabaseHelper(this);

        mListView = findViewById(R.id.listView);
        mList = new ArrayList<>();
        mAdapter = new RecordListAdapter(this, R.layout.row, mList);
        mListView.setAdapter(mAdapter);

        Cursor cursor = myDb.getAllData();
        mList.clear();
        while (cursor.moveToNext()){
            String id = cursor.getString(0);
            String negara = cursor.getString(1);
            String presiden = cursor.getString(2);
            String benua = cursor.getString(3);
            String populasi = cursor.getString(4);

            mList.add(new Model(id, negara, presiden, benua, populasi));
        }
        mAdapter.notifyDataSetChanged();
        if (mList.size() == 0) {
            Toast.makeText(this, "No Data Available", Toast.LENGTH_SHORT).show();
        }
    }
    public void Pindah2(View view) {
        Intent intent = new Intent(TampilData.this, MainActivity.class);
        startActivity(intent);
    }
}
