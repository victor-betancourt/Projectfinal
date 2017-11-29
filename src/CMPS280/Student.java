package CMPS280;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Student extends Person {

    public Student() {

    }

    public Student(String name, String DaysOffered, String Course) {
        super(name, DaysOffered, Course);
    }


    public void Export_Students(ArrayList<Student> StudentsArrayList) throws IOException {

        String Names = "C:/Users/john/Desktop/CodeBankRepository/PRJ280/INFO/Student.csv";
        File Student_info = new File(Names);
        PrintWriter PrintStudentInfo = new PrintWriter(Student_info);

        for (int i = 0; i < 1; i++) {
            PrintStudentInfo.print(StudentsArrayList);
        }
        PrintStudentInfo.close();

    }

    public void assign_to_students(ArrayList<Student> StudentsArrayList, ArrayList<Student> TutorsArrayList) {

        String[] Search_Student = new String[StudentsArrayList.size()];
        Search_Student = StudentsArrayList.toArray(Search_Student);

        String[] Search_Tutors = new String[TutorsArrayList.size()];
        Search_Tutors = TutorsArrayList.toArray(Search_Tutors);

        for (int i = 0; i < Search_Student.length; i++) {
            System.out.println(Search_Student[i].intern());
        }

    }

}
