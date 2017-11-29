package CMPS280;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int menuOption;
        new Menu();
    }

    /* What I basically did here was take Parth's main switch case and turned it into a scanner
       input interface. I noticed the Student and Tutor class had methods that we could keep in this
       class and it would do the same thing.
       *** Right now I'm still working on how to validate email inputs.
       ** Also numbers 3-4 in the menu are not working currently, I haven't set them up yet.
       ** Entering 5 for now quits the system, but we need another menu item to assign students to tutors.
     */
    private int menuOption;
    private Scanner sc;
    //private Assemble ob;
    Tutor Tobject2 = new Tutor();
    //System.out.println(Tobject2.convertStringToInt("chem"));
    Student Sobject = new Student();
    ArrayList<Tutor> tutorsArrayList = new ArrayList<Tutor>();
    Tutor Tobject = new Tutor();
    ArrayList<Student> studentsArrayList = new ArrayList<Student>();

    public Menu() throws IOException {
        //menuOption = "";
        sc = new Scanner(System.in);
        //ob = new Assemble();


        System.out.println("Welcome to the Tutor Management System");
        System.out.println("------------------------------------------------");

        menu();


    }

    public void menu() throws IOException {
        System.out.println();
        System.out.println("Please enter what you would like to do:");
        System.out.println("1. Add Students ");
        System.out.println("2. Add Tutors");
        System.out.println("3. Export Tutors to a CSV");
        System.out.println("4. Export Students to csv");
        System.out.println("5. Assign Students to Tutors");
        System.out.println("6. Display Which Tutor's and Client");
        System.out.println("7. Exit the Program");

        //boolean input_is_not_valid = true;

        do {
            System.out.print("Select action: ");
            while (!sc.hasNextInt()) {
                System.out.println("Not a valid option! Please enter a number");
                sc.next();
            }
            menuOption = sc.nextInt();
            if (menuOption == 1) {
                Add_StudentInfo(studentsArrayList);

            } else if (menuOption == 2) {
                createTutor(tutorsArrayList);

            } else if (menuOption == 3) {
                Tobject.Export_Tutorinfo(tutorsArrayList);

            } else if (menuOption == 4) {
                Sobject.Export_Students(studentsArrayList);

            } else if (menuOption == 5) {
                assignToStudents(studentsArrayList, tutorsArrayList);

            } else if (menuOption == 6) {
                Tobject.ShowTutorsClient(tutorsArrayList);

            }else if (menuOption == 7) {
                System.out.println("Thank you for using the Tutor Management System");
                System.out.println();
                System.exit(0);
                sc.close();
            } else {
                System.out.println("INVALID INPUT. PLEASE TRY AGAIN");
                System.out.println();
            }
        } while (menuOption != 7);

        System.out.println();
        //while(menuOption > 0 && menuOption != 5) {
        //    sub_menu(menuOption);
        // }
    }

    public void createTutor(ArrayList<Tutor> TutorsArrayList) throws IOException {
        System.out.println("Enter the number of Tutors you wish to create");
        sc = new Scanner(System.in);
        while (!sc.hasNextInt()) {
            System.out.println("That's not a number! Please the number of Tutors you wish to create");
            sc.next();
        }
        int NumberOfTutors = sc.nextInt();

        for (int i = 0; i < NumberOfTutors; i++) {
            System.out.println("Enter the Tutor's Name: ");
            while (!sc.hasNext("[a-zA-Z]+")) {
                System.out.println("That's not a name!");
                sc.next();
            }
            String Tutor_name = sc.next().toUpperCase();
            if (Tutor_name.equals("EXIT")) {
                menu();
                break;
            }
            System.out.println("Enter the Tutor's Email");
            //Pattern ptr = Pattern.compile("^(.+)@(.+)$");
            //while (!ptr.matcher(sc.next()).matches()){
            //   System.out.println("That's not a name!");
            //    sc.next();
            //}
            String Tutor_email = sc.next().toUpperCase();
            if (Tutor_email.equals("EXIT")) {
                menu();
                break;
            }
            System.out.println("Enter the Tutor's Course");
            while (!sc.hasNext("[a-zA-Z0-9]*")) {
                System.out.println("That's not a valid course name!");
                sc.next();
            }
            String Tutor_Course = sc.next().toUpperCase();
            if (Tutor_Course.equals("EXIT")) {
                menu();
                break;
            }
            TutorsArrayList.add(i, new Tutor(Tutor_name, Tutor_email, Tutor_Course));
            Collections.sort(TutorsArrayList, (a, b) -> a.getName().compareToIgnoreCase(b.getName()));
            if (i < NumberOfTutors) {
                System.out.println("\n Tutor created... ");
                System.out.println("-------------------------------------------------------------");
            }

            if (i == NumberOfTutors) {
                sc.close();
            }
        }
        menu();
    }

    public void Add_StudentInfo(ArrayList<CMPS280.Student> StudentsArrayList) throws IOException {
        System.out.println("Enter the number of Students you wish to create");
        while (!sc.hasNextInt()) {
            System.out.println("That's not a number! Please the number of Tutors you wish to create");
            sc.next();
        }
        int NumberOfStudents = sc.nextInt();

        for (int i = 0; i < NumberOfStudents; ++i) {
            System.out.println("Enter the Student's Name");
            while (!sc.hasNext("[a-zA-Z]+")) {
                System.out.println("That's not a name!");
                sc.next();
            }
            String Student_Name = sc.next().toUpperCase();
            if (Student_Name.equals("EXIT")) {
                menu();
                break;
            }
            System.out.println("Enter the Student's Email");
            String Student_Email = sc.next().toUpperCase();
            if (Student_Email.equals("EXIT")) {
                menu();
                break;
            }
            System.out.println("Enter the Students's Course");
            while (!sc.hasNext("[a-zA-Z0-9]*")) {
                System.out.println("That's not a valid course name!");
                sc.next();
            }
            String Student_Course = sc.next().toUpperCase();
            if (Student_Course.equals("EXIT")) {
                menu();
                break;
            }
            StudentsArrayList.add(i, new CMPS280.Student(Student_Name, Student_Email, Student_Course));
            Collections.sort(StudentsArrayList, (a, b) -> a.getName().compareToIgnoreCase(b.getName()));


            if (i < NumberOfStudents) {
                System.out.println("\n Student created... ");
                System.out.println("-------------------------------------------------------------");
            }
            if (i == NumberOfStudents) {
                break;
            }

        }
        menu();
        System.out.println(StudentsArrayList);
    }

    public static void assignToStudents(ArrayList<Student> StudentsArrayList, ArrayList<Tutor> TutorsArrayList) {

        for (int i = 0; i < StudentsArrayList.size(); i++) {
            for (int j = 0; j < TutorsArrayList.size(); j++) {
                if ((TutorsArrayList.get(i)).getCourse().equals((StudentsArrayList.get(j)).getCourse())) {
                    (TutorsArrayList.get(i)).setStudent_match_tutor(StudentsArrayList.get(j));
                }

            }
        }
    }
}
