package ie.wit.medRecord.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.FileNotFoundException;
import java.io.IOException;

import ie.wit.medRecord.FileHandling.FileHandling;
import ie.wit.medRecord.R;

public class mainMenu extends Base {



    public Button butadd;
    public Button butdel;
    public Button butEdit;
    public Button butList;
    public void init() {

        butadd = (Button) findViewById(R.id.butadd);
        butadd.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent addPatient = new Intent(mainMenu.this, ie.wit.medRecord.activities.addPatient.class);
                startActivity(addPatient);
            }
        });

        butdel = (Button) findViewById(R.id.butdel);
        butdel.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent deletePatient = new Intent(mainMenu.this, ie.wit.medRecord.activities.deletePatient.class);
                startActivity(deletePatient);
            }
        });


        butEdit = (Button) findViewById(R.id.butedit);
       butEdit.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                Intent editPatient = new Intent(mainMenu.this, ie.wit.medRecord.activities.editPatient.class);
                startActivity(editPatient);

            }
        });

        butList = (Button) findViewById(R.id.butlist);
        butList.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                Intent listPatient = new Intent(mainMenu.this, ie.wit.medRecord.activities.listPatients.class);
                startActivity(listPatient);
            }
        });
    }

        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main_menu);
            init();
        }
    }
