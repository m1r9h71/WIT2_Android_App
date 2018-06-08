package ie.wit.medRecord.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.content.Context;
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
import ie.wit.medRecord.models.Doctor;

public class listDoctors extends Base {
    public DBManager db;
    DoctorAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_doctors_list);
        ListView listview = (ListView) findViewById( R.id.doctorsListView );
        db = new DBManager( this );
        db.open();
        adapter = new DoctorAdapter(this, db.getAllDoc());
        listview.setAdapter( adapter );
        db.close();

    }
}

class DoctorAdapter extends ArrayAdapter<Doctor>
{
    private Context context;
    public List<Doctor> doctorList;
    public DoctorAdapter(Context context, List<Doctor> doctorList)
    {
        super(context, R.layout.activity_list_doctors, doctorList);
        this.context = context;
        this.doctorList = doctorList;
    }
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = (LayoutInflater)
                context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        View view = inflater.inflate( R.layout.activity_list_doctors, parent, false);
        Doctor doctor = doctorList.get( position );
        TextView name = (TextView) view.findViewById( R.id.doctorNameTextView );
        TextView details = (TextView) view.findViewById( R.id.doctorDetailsTextView );
        name.setText( "Doctor: " + doctor.getName());
        details.setText( "Age: " + doctor.getAge()+ "\nField: " + doctor.getField() + "\nLength Of Service: " + doctor.getLengthService());
        return view;
    }
}
