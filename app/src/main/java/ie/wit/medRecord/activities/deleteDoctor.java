package ie.wit.medRecord.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ie.wit.medRecord.Database.DBManager;
import ie.wit.medRecord.R;

public class deleteDoctor extends Base {
    public EditText delDoc;
    public Button docDelete;
    public DBManager db;

    public void init() {
        delDoc = (EditText)findViewById( R.id.delDocName ) ;
        docDelete = (Button) findViewById( R.id.docDelete );
        docDelete.setOnClickListener( new View.OnClickListener() {
            public void onClick(View view) {
                deleteButtonClicked();
            }
        } );
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_delete_doctor );
        init();
        db = new DBManager( this );

    }

    public void deleteButtonClicked() {
        String deleteDoc = delDoc.getText().toString();

        if(docDelete != null) {
            if(!deleteDoc.equals( "" )){
                db.delete_doctor( deleteDoc );
                Toast.makeText( this, "Doctor Deleted!", Toast.LENGTH_SHORT ).show();
            }else Toast.makeText( this, "Please Type A Doctor's Name!", Toast.LENGTH_SHORT ).show();
        }
    }
}
