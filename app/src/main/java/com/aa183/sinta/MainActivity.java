package com.aa183.sinta;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    Spinner addBenua;
    EditText addNegara, addPresiden, addPopulasi, addid;
    Button btnadd;
    Button btnview;
    Button btnupdate;
    Button btndelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);

        addNegara = (EditText)findViewById(R.id.setNegara);
        addPresiden = (EditText)findViewById(R.id.setPresiden);
        addPopulasi = (EditText)findViewById(R.id.setPopulasi);
        addid = (EditText)findViewById(R.id.setId);
        addBenua = (Spinner)findViewById(R.id.setBenua);
        btnadd = (Button) findViewById(R.id.buttonSimpan);
        btnupdate = (Button) findViewById(R.id.buttonEdit) ;
        btndelete = (Button) findViewById(R.id.buttonDelete) ;

        AddData();
        UpdateData();
        DeleteData();

    }

    public void AddData(){
        btnadd.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(addNegara.getText().toString(),
                                addPresiden.getText().toString(),
                                addBenua.getSelectedItem().toString(),
                                addPopulasi.getText().toString());
                        if (isInserted == true)
                            Toast.makeText(MainActivity.this,"Data Inserted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this,"Data No tInserted", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void UpdateData(){
        btnupdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdated = myDb.updatedata(addid.getText().toString(),
                                addNegara.getText().toString(),
                                addPresiden.getText().toString(),
                                addBenua.getSelectedItem().toString(),
                                addPopulasi.getText().toString());
                        if (isUpdated == true)
                            Toast.makeText(MainActivity.this,"Data Updated", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this,"Data Not Updated", Toast.LENGTH_LONG).show();

                    }
                }
        );
    }

    public void DeleteData(){
        btndelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deletedRows = myDb.deleteData(addid.getText().toString());
                        if(deletedRows > 0)
                            Toast.makeText(MainActivity.this,"Data Deleted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this,"Data Not Deleted", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void Pindah(View view) {
        Intent intent = new Intent(MainActivity.this, TampilData.class);
        startActivity(intent);
    }
}
