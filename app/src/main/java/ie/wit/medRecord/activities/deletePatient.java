package ie.wit.medRecord.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import ie.wit.medRecord.Database.DBDesigner;
import ie.wit.medRecord.Database.DBManager;
import ie.wit.medRecord.R;
import ie.wit.medRecord.models.Patient;

public class deletePatient extends Base {
    public Button delete;
    public EditText deleteText;
    public DBManager db;
    public void init() {


        deleteText = (EditText) findViewById( R.id.deleteText );
        delete=(Button)
                findViewById(R.id.delete);

        delete.setOnClickListener(new View.OnClickListener()

        {
            public void onClick (View view){
                deleteButtonPressed();
            }
        }

        );
    }





        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_delete_patient);
            init();
            db = new DBManager(this);



        }
    public void deleteButtonPressed() {
        String deletetext = deleteText.getText().toString();

        if (delete != null){
            if (!deletetext.equals( "" )) {
                db.delete_patient( deletetext );
                Toast.makeText( this, "Patient Deleted", Toast.LENGTH_SHORT ).show();
            }else Toast.makeText( this, "Please Enter A Patient Name!", Toast.LENGTH_SHORT ).show();
        }
    }

    }
