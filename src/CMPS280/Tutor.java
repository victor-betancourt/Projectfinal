package CMPS280;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Tutor extends Person {

    ArrayList<Student> Student_match_tutor = new ArrayList<Student>();

    public Tutor(){

    }

    public Tutor(String name, String DaysOffered, String Course) {
        super(name, DaysOffered, Course);
    }

    public int convertStringToInt(String Subject){
        if(Subject.length() < 3){
            System.out.println("too small");
            return 0;
        }
        int numCode = (int)((Subject.charAt(0) - 97) * Math.pow(26,2) + (Subject.charAt(1) -97) * Math.pow(26,1) + (Subject.charAt(2) -97)+ Math.pow(26, 0));
        return numCode;
    }

    public void Export_Tutorinfo(ArrayList<Tutor> TutorsArrayList) throws IOException {

        String Name = "INFO/Tutor.csv";
        File Tutor_info = new File(Name);
        PrintWriter PrintTutorInfo = new PrintWriter(Tutor_info);

        for (int i = 0; i < 1; i++) {
            PrintTutorInfo.print(TutorsArrayList.toString());
        }
        PrintTutorInfo.close();
    }

    public ArrayList<Student> getStudent_match_tutor() {
        return Student_match_tutor;
    }


    public void setStudent_match_tutor(Student student_match_tutor) {
        Student_match_tutor.add(student_match_tutor);
    }

    public void ShowTutorsClient (ArrayList<Tutor> TutorsArrayList){
        for (int i = 0; i < TutorsArrayList.size(); i++){
            System.out.println(TutorsArrayList.get(i).getName() + TutorsArrayList.get(i).getStudent_match_tutor().toString());
        }
    }



}
