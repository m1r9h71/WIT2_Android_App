package ie.wit.medRecord.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ie.wit.medRecord.R;

public class DoctorMain extends AppCompatActivity {

    public Button addDoctor;
    public Button listDoctor;
    public Button editDoctor;
    public Button deleteDoctor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_doctor_main );

        addDoctor = (Button) findViewById( R.id.addDoctor );
        addDoctor.setOnClickListener( new View.OnClickListener() {
            public void onClick(View view) {
                Intent addDoctor = new Intent( DoctorMain.this, ie.wit.medRecord.activities.addDoctor.class );
                startActivity( addDoctor );
            }
        });

      listDoctor = (Button) findViewById( R.id.listDoctor );
        listDoctor.setOnClickListener( new View.OnClickListener(){
            public void onClick(View view) {
                Intent listDoctor = new Intent( DoctorMain.this, ie.wit.medRecord.activities.listDoctors.class );
                startActivity( listDoctor );
            }
        } );

       editDoctor = (Button) findViewById( R.id.editDoctor );
        editDoctor.setOnClickListener( new View.OnClickListener(){
            public void onClick(View view){
                Intent editDoctor = new Intent( DoctorMain.this, ie.wit.medRecord.activities.editDoctor.class);
                startActivity( editDoctor );
            }
        } );

        deleteDoctor = (Button) findViewById( R.id.deleteDoctor );
        deleteDoctor.setOnClickListener( new View.OnClickListener() {
            public void onClick(View view) {
                Intent deleteDoctor = new Intent( DoctorMain.this, ie.wit.medRecord.activities.deleteDoctor.class);
                startActivity( deleteDoctor );
            }
        } );
    }
}
