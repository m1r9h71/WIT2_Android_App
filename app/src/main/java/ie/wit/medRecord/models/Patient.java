package ie.wit.medRecord.models;


import android.widget.Spinner;
import android.widget.TextView;

import static android.R.attr.id;

/**
 * Created by Matt_ on 21/02/2017.
 */

public class Patient extends Person {
    public String address;
    public String illness;
    public String medication;
    public int id;
    public Patient(String name, String gender, int age, String address, String illness, String medication)
    {
        super(name, gender, age);
        this.address = address;
        this.illness = illness;
        this.medication = medication;

    }

    public Patient()
    {

    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getIllness() {
        return illness;
    }
    public void setIllness(String illness) {
        this.illness = illness;
    }

    public String getMedication() {
        return medication;
    }
    public void setMedication(String medication) {
        this.medication = medication;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
       this.id =id;

    }

    public String toString() {
        return "Patient information : ID: " + id + "Name: " + name + " Gender: " + gender
                + " Age: " + age + " Address: " + address + " Illness Details: " + illness + " Medication Details: " + medication +  "\n";
    }
}
