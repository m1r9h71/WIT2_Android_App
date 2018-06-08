package ie.wit.medRecord.activities;

/**
 * Created by Matt_ on 25/02/2017.
 */
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

import ie.wit.medRecord.Database.DBManager;
import ie.wit.medRecord.models.Doctor;
import ie.wit.medRecord.models.Patient;

public class Base extends AppCompatActivity {
    public ArrayList<Patient>  patientList = new ArrayList<Patient>();
    public ArrayList<Doctor> doctorList = new ArrayList<>(  );
        public Base()
        {
            Patient defaultPatient = new Patient(  "Matt Hoing", "Male", 45, "31 Dominic Place, Waterford City", "Epilepsy", "Tegretol 400mg" );
        }
    protected void onDestroy() {
        super.onDestroy();
    }

    
}




