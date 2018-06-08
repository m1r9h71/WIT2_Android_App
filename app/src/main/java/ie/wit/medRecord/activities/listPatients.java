package ie.wit.medRecord.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import ie.wit.medRecord.Database.DBManager;
import ie.wit.medRecord.R;
import ie.wit.medRecord.models.Patient;

public class listPatients extends Base {
    public DBManager db;
    PatientAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_patients_list);
        ListView listView = (ListView) findViewById(R.id.patientsListView );
        super.onCreate( savedInstanceState );
        db = new DBManager(this);
        db.open();
        adapter = new PatientAdapter(this, db.getAll());
        listView.setAdapter( adapter );
        db.close();

    }
}

class PatientAdapter extends ArrayAdapter<Patient>
{
    private Context context;
    public List<Patient> patientList;
    public PatientAdapter(Context context, List<Patient> patientList)
    {
        super(context, R.layout.activity_list_patients, patientList);
        this.context = context;
        this.patientList = patientList;
    }
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.activity_list_patients, parent, false);
        Patient patient = patientList.get( position );
        TextView name = (TextView) view.findViewById( R.id.patientNameTextView);
        TextView details = (TextView) view.findViewById( R.id.patientDetailsTextView);
        name.setText("Patient: " + patient.getName());
        details.setText("Age: "+patient.getAge()+"\nMedication: "+patient.getMedication()
        +"\nIllness: "+patient.getIllness());

        return view;
    }
}