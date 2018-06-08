package ie.wit.medRecord.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.RadioGroup;
import android.widget.Toast;

import ie.wit.medRecord.Database.DBManager;
import ie.wit.medRecord.R;
import ie.wit.medRecord.models.Patient;

import static android.R.attr.id;

public class addPatient extends Base {


    public EditText Names;
    public RadioGroup Genders;
    public NumberPicker Ages;
    public EditText Addresses;
    public EditText Illnesses;
    public EditText Medications;
    public Button add;
    public DBManager db;



    public void init() {


        add = (Button) findViewById( R.id.add );
        add.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addButtonPressed( );
            }
        } );

        Names = (EditText) findViewById( R.id.patientName );
        Names.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {

            }
        } );


        Genders = (RadioGroup) findViewById( R.id.gender );
        Genders.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {


                }
            }
        } );

        Ages = (NumberPicker) findViewById( R.id.agePicker );
        Ages.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        } );


        Addresses = (EditText) findViewById( R.id.address );
        Addresses.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        } );

        Illnesses = (EditText) findViewById( R.id.illness );
        Illnesses.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        } );

        Medications = (EditText) findViewById( R.id.medication );
        Medications.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        } );


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        db = new DBManager(this);
        setContentView( R.layout.activity_add_patient );
        init();
        Ages.setMaxValue( 100 );
        Ages.setMinValue( 1 );
        Ages.setValue( 1 );


    }
    public void addButtonPressed() {


        if (add != null) {

            String nametext = Names.getText().toString();
            String genderId = Genders.getCheckedRadioButtonId() == R.id.gender ? "Male" : "Female";
            int ageAmount = Ages.getValue();
            String addresstext = Addresses.getText().toString();
            String illnesstext = Illnesses.getText().toString();
            String medtext = Medications.getText().toString();
            Patient pat = new Patient( nametext, genderId, ageAmount, addresstext, illnesstext, medtext );
            patientList.add(pat);
           //db.getId();
            //Log.v("Database ID: ", String.valueOf( db.getId() ) );
            if (!nametext.equals( "" ) && !genderId.equals( "" ) && !addresstext.equals( "" ) && !illnesstext.equals( "" ) && !medtext.equals( "" )) {
                Toast.makeText( this, "Patient Added", Toast.LENGTH_SHORT ).show();
                db.open();
                db.add( pat );
                Log.v( "", db.getAll().toString() );
                db.close();
            }else Toast.makeText( this, "Please Enter Information", Toast.LENGTH_SHORT ).show();

        }


    }


}








