package ie.wit.medRecord.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Matt_ on 09/03/2017.
 */

public class DBDesigner extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "medicalDB";
    private static final int DATABASE_VERSION =2;
    private static String DATABASE_CREATE_TABLE_PATIENTS =
            "create table patients"
            + "(id integer primary key autoincrement,"
            + "name text not null,"
            + "gender text not null,"
            + "age integer not null,"
            + "address text not null,"
            + "illness text not null,"
            + "medication text not null);";

    private static String DATABASE_CREATE_TABLE_DOCTORS =
            "create table doctors "
            + "(did integer primary key autoincrement,"
            + "name text not null,"
            + "gender text not null,"
            + "age integer not null,"
            + "field text not null,"
            + "lengthservice text not null);";



    public DBDesigner (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE_TABLE_PATIENTS);
        database.execSQL( DATABASE_CREATE_TABLE_DOCTORS );

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DBDesigner.class.getName(),
        "Upgrading database from version " + oldVersion +
        "to" + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS patients");
        db.execSQL("DROP TABLE IF EXISTS doctors");

        onCreate(db);
    }
}
