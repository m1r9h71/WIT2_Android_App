package ie.wit.medRecord.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ie.wit.medRecord.Database.DBDesigner;
import ie.wit.medRecord.Database.DBManager;
import ie.wit.medRecord.R;

public class editPatient extends Base {
    public EditText newname;
    public EditText oldname;
    public Button butedit;
   public DBManager db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_edit_patient );
        Toolbar toolbar = (Toolbar) findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );
        db = new DBManager(this);
        FloatingActionButton fab = (FloatingActionButton) findViewById( R.id.fab );
        fab.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make( view, "Replace with your own action", Snackbar.LENGTH_LONG )
                        .setAction( "Action", null ).show();

            }
        } );


        newname = (EditText) findViewById( R.id.newname );
        newname.setOnClickListener( new View.OnClickListener() {
            public void onClick(View view) {

            }
        } );

        oldname = (EditText) findViewById( R.id.oldname );


        butedit = (Button) findViewById( R.id.butedit );
        butedit.setOnClickListener( new View.OnClickListener() {
            public void onClick(View view) {
                editButtonPressed();
            }
        });

    }

        public void editButtonPressed () {

                String old_name = oldname.getText().toString();
                String new_name =  newname.getText().toString();
            if (butedit != null) {
                if (!old_name.equals( "" ) && !new_name.equals( "" ) ){
                    db.update_patient( old_name, new_name );
                    Toast.makeText( this, "Patient Name Updated", Toast.LENGTH_SHORT ).show();
                }else Toast.makeText( this, "Please Enter New And Old Patient Names!", Toast.LENGTH_SHORT ).show();
            }
        }
}
