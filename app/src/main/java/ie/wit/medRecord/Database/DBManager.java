package ie.wit.medRecord.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import ie.wit.medRecord.models.Doctor;
import ie.wit.medRecord.models.Patient;

import static android.R.attr.id;

/**
 * Created by Matt_ on 09/03/2017.
 */

public class DBManager {
    private SQLiteDatabase database;
    private DBDesigner dbhelper;

    public DBManager(Context context) {dbhelper = new DBDesigner( context );}

    public void open() throws SQLException {
        database = dbhelper.getWritableDatabase();
    }

    public void close() {database.close();}

    public void add(Patient patient) {
        ContentValues values = new ContentValues();
        values.put("name", patient.getName());
        values.put("gender", patient.getGender());
        values.put("age", patient.getAge());
        values.put("address", patient.getAddress());
        values.put("illness", patient.getIllness());
        values.put("medication", patient.getMedication());


        database.insert("patients", null, values);
    }

    public List<Patient> getAll(){
        List<Patient> patientList = new ArrayList<>(  );
        Cursor cursor = database.rawQuery("SELECT * FROM patients", null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            Patient patient = toPatient(cursor);
            patientList.add(patient);
            cursor.moveToNext();
        }
        cursor.close();
        return patientList;
    }

    public void delete_patient(String name) {
        dbhelper.getWritableDatabase().delete("patients", "name ='" + name + "'", null);
    }


    public void update_patient(String old_name, String new_name) {
        dbhelper.getWritableDatabase().execSQL( "UPDATE patients SET name ='" + new_name + "' WHERE name ='" + old_name+ "'" );
    }

    public int getId() {
        return id;
    }
   /* public void delete(Patient patient) {

        database.delete(dbhelper.DATABASE_CREATE_TABLE_PATIENTS , dbhelper.COLUMN_ID + "=" + patient.getEmpId(), null);
    }*/

    public void addDoc(Doctor doctor) {
        ContentValues values = new ContentValues();
        values.put("name", doctor.getName());
        values.put("gender", doctor.getGender());
        values.put("age", doctor.getAge());
        values.put("field", doctor.getField());
        values.put("lengthservice", doctor.getLengthService());



        database.insert("doctors", null, values);
    }

    public List<Doctor> getAllDoc(){
        List<Doctor> doctorList = new ArrayList<>(  );
        Cursor cursor = database.rawQuery("SELECT * FROM doctors", null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            Doctor doctor = toDoctor(cursor);
            doctorList.add(doctor);
            cursor.moveToNext();
        }
        cursor.close();
        return doctorList;
    }

    public void delete_doctor(String name) {
        dbhelper.getWritableDatabase().delete("doctors", "name ='" + name + "'", null);
    }


    public void update_doctor(String old_name, String new_name) {
        dbhelper.getWritableDatabase().execSQL( "UPDATE doctors SET name ='" + new_name + "' WHERE name ='" + old_name + "'" );
    }





    private Patient toPatient(Cursor cursor) {
        Patient pojo = new Patient();
       // pojo.id = cursor.getInt( 0 );
        pojo.name = cursor.getString( 1 );
        pojo.gender = cursor.getString(2);
        pojo.age = cursor.getInt(3);
        pojo.address = cursor.getString( 4 );
        pojo.illness = cursor.getString( 5 );
        pojo.medication = cursor.getString( 6 );
        return pojo;
    }

    private Doctor toDoctor(Cursor cursor) {
        Doctor pojod = new Doctor();
        // pojo.id = cursor.getInt( 0 );
        pojod.name = cursor.getString( 1 );
        pojod.gender = cursor.getString(2);
        pojod.age = cursor.getInt(3);
        pojod.field = cursor.getString( 4 );
        pojod.lengthService = cursor.getInt( 5 );
        return pojod;
    }



    public void reset() {
        database.delete( "patients", null, null );
        database.delete( "doctors", null, null);

    }
}
