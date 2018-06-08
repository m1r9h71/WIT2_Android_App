package ie.wit.medRecord.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import ie.wit.medRecord.Database.DBManager;
import ie.wit.medRecord.R;
import ie.wit.medRecord.models.Doctor;

public class addDoctor extends Base {

    public EditText docName;
    public RadioGroup docGender;
    public RadioButton docMale;
    public RadioButton docFemale;
    public NumberPicker service;
    public NumberPicker docAge;
    public EditText field;
    public Button addDoc;
    public DBManager db;

    public void init() {
        docName = (EditText) findViewById( R.id.docName );
        docGender = (RadioGroup) findViewById( R.id.docGender );
        docMale = (RadioButton) findViewById( R.id.docMale );
        docFemale = (RadioButton) findViewById( R.id.docFemale );
        service = (NumberPicker) findViewById( R.id.service );
        docAge = (NumberPicker) findViewById( R.id.docAge );
        field = (EditText) findViewById( R.id.field );
        addDoc  = (Button) findViewById( R.id.addDoc );
        addDoc.setOnClickListener( new View.OnClickListener() {
            public void onClick(View view) {
                addDocButtonPressed();
            }
        } );
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        db = new DBManager(this);
        setContentView( R.layout.activity_add_doctor );
        init();
        docAge.setMaxValue( 100 );
        docAge.setMinValue( 1 );
        docAge.setValue( 1 );
        service.setMaxValue( 40 );
        service.setMinValue( 1 );
        service.setValue( 1 );

    }

        public void addDocButtonPressed() {
        if (addDoc != null) {
            String docname = docName.getText().toString();
            String docgender = docGender.getCheckedRadioButtonId()==R.id.docGender ? "Male":"Female";
            int docage = docAge.getValue();
            int serviced = service.getValue();
            String fields = field.getText().toString();
            Doctor doc = new Doctor( docname, docgender,docage,fields, serviced );
            doctorList.add(doc);
            if(!docname.equals( "" ) && !docgender.equals( "" ) && !fields.equals( "" )) {
                Toast.makeText( this, "Doctor Added", Toast.LENGTH_SHORT ).show();
                db.open();
                db.addDoc(doc);
                db.close();
            }else Toast.makeText( this, "Please Enter Doctor Details!", Toast.LENGTH_SHORT ).show();





        }
    }

}
