package CMPS280;

import java.util.Arrays;

public class Person {
    private String Name;
    private String DaysOffered;
    private String Course;

    public String getCourse() {
        return Course;
    }

    public void setCourse(String course) {
        Course = course;
    }

    public Person() {

    }

    public Person(String NewName, String DaysOffered, String NewCourse) {
        this.Name = NewName;
        this.DaysOffered = DaysOffered;
        this.Course = NewCourse;

    }
	/*@Override
	public String tocsvString(){
		 String csvRow = "";
		    for (String value : Arrays.asList(Name,DaysOffered,Course)) {
		        String processed = value;
		        if (value.contains("\"") || value.contains(",")) {
		            processed = "\"" + value.replaceAll("\"", "\"\"") + "\"";
		        }
		        csvRow += "," + processed;
		    }
		    return csvRow.substring(1);
	}*/



    public String toString() {
        // Override the default toString() method and return a custom String
        // instead.
        return (this.Name + this.DaysOffered + this.Course);
    }


    public String getName() {
        return this.Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDaysOffered() {
        return DaysOffered;
    }

    public void setDaysOffered(String email) {
        this.DaysOffered = email;
    }
}
