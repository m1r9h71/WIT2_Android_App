package ie.wit.medRecord.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ie.wit.medRecord.Database.DBManager;
import ie.wit.medRecord.R;

public class editDoctor extends Base {
    public EditText oldDocName;
    public EditText newName;
    public Button editDoc;
    public DBManager db;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_edit_doctor );
        db = new DBManager(this);
        oldDocName = (EditText) findViewById(R.id.oldDocName);

        newName = (EditText) findViewById( R.id.newName );

        editDoc = (Button) findViewById( R.id.editDoc );
        editDoc.setOnClickListener( new View.OnClickListener(){
            public void onClick(View view) {
                editDoctorButtonClicked();
            }
        } );
        }

        public void editDoctorButtonClicked() {
            String old_name = oldDocName.getText().toString();
            String new_name = newName.getText().toString();
            if (editDoc != null) {
                if (!old_name.equals( "" ) && !new_name.equals( "" )) {
                    Log.v( "", oldDocName.getText().toString() );
                    Log.v( "", newName.getText().toString());
                    db.update_doctor(old_name, new_name);
                    Toast.makeText( this, "Doctor Details Updated", Toast.LENGTH_SHORT ).show();
                }else Toast.makeText( this, "Please Enter Old Doctor Name And New Doctor Name!", Toast.LENGTH_SHORT ).show();
            }
        }

    }

