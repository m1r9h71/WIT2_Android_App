package ie.wit.medRecord.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ie.wit.medRecord.R;

public class searchPatient extends Base {

    public Button butBack3;
    public EditText listName;
    public Button search;
    public Editable name;
    //public personApp personapp;
    public void init() {
       butBack3 = (Button) findViewById( R.id.butBack3 );
        butBack3.setOnClickListener( new View.OnClickListener() {

            public void onClick(View v) {
                Intent searchPatient = new Intent( searchPatient.this, mainMenu.class );
                startActivity( searchPatient );
            }
        } );
        listName = (EditText) findViewById( R.id.searchName );
       listName.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v) {




           }
       } );
        search = (Button) findViewById( R.id.search );
        search.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                name = listName.getText();
                for (int i = 0; i < patientList.size(); i++) {
                    if (patientList.get( i ).toString().contains( name )) {

                        Toast.makeText(searchPatient.this,"The Patient Chosen is: " + patientList.get(i),Toast.LENGTH_LONG).show();
                        Log.v("",patientList.toString());
                    }

                }
            }
       });



    }

        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate( savedInstanceState );
            setContentView( R.layout.activity_search_patient );
            init();
            //personapp = (personApp)getApplication();

        }


    }

