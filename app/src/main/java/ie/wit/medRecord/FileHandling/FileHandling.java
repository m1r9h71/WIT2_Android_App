package ie.wit.medRecord.FileHandling;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import ie.wit.medRecord.FileHandling.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import ie.wit.medRecord.models.Patient;
import ie.wit.medRecord.models.Person;
import ie.wit.medRecord.activities.Base;

import static android.R.attr.data;
import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Matt_ on 01/03/2017.
 */

public class FileHandling {
    File myFile = new File("C:/Users/Matt_/AndroidStudioProjects/MedRecord/app/src/main/java/ie/wit/medRecord/FileHandling/people.dat");
  //File myFile = Environment.getExternalStorageDirectory();

    ObjectOutputStream oos;
    ObjectInputStream ois;
    int size =0;

    //write ArrayList to file

   public  void writeToFile(ArrayList<Patient> devices, int size) throws FileNotFoundException, IOException {
        oos = new ObjectOutputStream(new FileOutputStream(myFile));
        oos.writeInt(size);
        oos.writeObject(devices);
        oos.close();
    }



    //read in from ArrayList

    public  ArrayList<Patient> readInFile() throws FileNotFoundException, IOException, ClassNotFoundException {
        ArrayList<Patient> temp = null;
        ois = new ObjectInputStream(new FileInputStream(myFile));
        size = ois.readInt();
        temp = (ArrayList<Patient>) ois.readObject();
        ois.close();
        return temp;
    }
}
