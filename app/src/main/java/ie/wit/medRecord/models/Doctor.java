package ie.wit.medRecord.models;


/**
 * Created by Matt_ on 21/02/2017.
 */

public class Doctor extends Person {
    public String field;
    public int lengthService;
    //public String listOfPatients;
    public Doctor(String name, String gender, int age, String field, int  lengthService)
    {
        super(name, gender, age);
        this.field = field;
        this.lengthService = lengthService;
        //this.listOfPatients = listOfPatients;
    }

    public String getField() {
        return  field;
    }

    public void setField() {
        this.field = field;
    }

    public int getLengthService() {
        return lengthService;
    }

    public void setLengthService() {
        this.lengthService = lengthService;
    }

    /*public String getListOfPatients() {return listOfPatients;}

    public void setListOfPatients() {this.listOfPatients = listOfPatients;}*/

    public Doctor() {

    }

    public String toString() {
        return "Doctor Information: Name: " + name + " Gender: " + gender + " Age: " + age
                + " Field Of Speciality: " + field  + "\n";
    }
}
//+ " Length Of Service: " + lengthService