package ie.wit.medRecord.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ie.wit.medRecord.R;

public class LogIn extends AppCompatActivity {
    public EditText username;
    public EditText password;
    public Button ok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_log_in );

        username = (EditText)findViewById( R.id.username );
        username.setOnClickListener( new View.OnClickListener(){
            public void onClick(View view) {

            }
        } );

        password = (EditText) findViewById( R.id.password );
        password.setOnClickListener( new View.OnClickListener(){
            public void onClick(View view) {

            }
        } );

        ok = (Button) findViewById( R.id.ok );
        ok.setOnClickListener( new View.OnClickListener(){
            public void onClick(View view) {
                okButtonClicked();
            }
        } );
    }

    public void okButtonClicked(){
        if (ok != null) {
                username.getText().toString();
                String Password = password.getText().toString();
            if (!username.getText().equals( "" ) && !password.getText().equals( "" )) {
                if (Password.equals( "Admin" ) || Password.equals( "admin" )) {
                    Intent doctorMain = new Intent(LogIn.this, ie.wit.medRecord.activities.DoctorMain.class);
                    startActivity(doctorMain);
                }else if (Password.equals( "Doctor" ) || Password.equals( "doctor" )){
                    Intent mainMenu = new Intent(LogIn.this, ie.wit.medRecord.activities.mainMenu.class);
                    startActivity( mainMenu );

                }else Toast.makeText( this, "Please Fill In The Information Correctly  " + username.getText() , Toast.LENGTH_SHORT ).show();
            }
        }
    }
}
