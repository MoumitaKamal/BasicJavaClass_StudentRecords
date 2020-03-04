/***********************************************************
 *Title: Student Records Class 

 *Description: Contains the different methods of the student records class. 
 
 *Author: Moumita Kamal
 ***********************************************************/

import java.util.*;
public class StudentRecords {
    Scanner mk=new Scanner(System.in);
    static int maxLimit=15;                                                        //maximum limit of total students
    Student [] student; 
    int studentNum;
    int[]seats= {5,5,5};                                                           // number of students allowed in each section
    int secSelection=0;                                                            // number of the section selected by student
    
    boolean idCheck=false, emailCheck=false; 
    
    public StudentRecords() {
        studentNum=0;
        student= new Student[maxLimit];
    }
    
    public void register() {                                                       // takes in student info and registers student by creating student account
        if(studentNum <= maxLimit){                                                // check if seats are available (i.e. if max student limit is reached)
            student[studentNum]=new Student(); 
            System.out.println("Name: ");
            student[studentNum].name=mk.nextLine();
            System.out.println("Student id: ");
            while(true){                                                           // check for duplicate ID
                int temp=mk.nextInt();
                mk.nextLine();
                checkId(temp);
                if(idCheck==true){
                    System.out.println("id address already exists.. enter again: ");
                    idCheck=false;
                }
                else {
                    student[studentNum].sid=temp;
                    break;
                }
            }
            System.out.println("Email id: ");
            while(true){                                                            // check for duplicate emails
                String temp=mk.nextLine();
                checkEmail(temp);
                if(emailCheck==true){
                    System.out.println("email address already exists.. enter again: ");
                    emailCheck=false;
                }
                else {
                    student[studentNum].email=temp;
                    break;
                }
            }
            System.out.println("Password: ");
            student[studentNum].password=mk.nextLine();
            System.out.println("you are successfully registered! you can now log in to your account.");
            maxLimit--;
            studentNum++;
            login();                                                                // redirect to student account
        }else {
            System.err.println("Sorry. No seats available right now. :(");
        }
    }
    
    public void login() {                                                           // log in to student account to register for classes
        boolean check=false;
        System.out.println("please enter your email adress: ");
        String email=mk.nextLine();
        String pass="";
        for(int c=0; c<studentNum; c++) {
            if(student[c].email.equals(email)) {                                    // check if email is correct
                check=true;
                System.out.println("enter password: ");
                pass=mk.nextLine();
                if(student[c].password.equals(pass)) {                              // check if password is correct
                    System.out.println("Login successfull!\n");
                    System.err.println("1.Section-01    Sunday: 12:30pm-2:00pm    "+seats[0]+" seats remaining \n"
                                           +"2.Section-02    Sunday: 2:30pm-4:00pm     "+seats[1]+" seats remaining\n"
                                           +"3.Section-03    Sunday: 5:30pm-7:00pm     "+seats[2]+" seats remaining");
                    System.out.println("\nenter 1 for section 01, 2 for section 02 and 3 for section 03");
                    secSelection=mk.nextInt();
                    if(student[c].section==0){                                      // check if already enrolled
                        if(secSelection==1 || secSelection==2 || secSelection==3) { // input validation
                            if(seats[secSelection-1]>0) {                           // check seat availability
                                student[c].section=secSelection;
                                System.out.println("congratulations! you are enrolled in section 0"+secSelection+"\n");
                                seats[secSelection-1]--;
                            }else {
                                System.err.println("Sorry! no seats available in section0"+secSelection+"\n");
                            }
                        }else {
                            System.err.println("invalid input\n");
                        }
                    }else {
                        System.err.println("Sorry! you are already enrolled into one section\n");
                    }
                    mk.nextLine();
                    break;
                }else {
                    System.err.println("Wrong password! try again\n");
                    login();                                                         // redirect to login
                }
            }
        }
        if(check==false) {
            System.err.println("no match found! redirecting...");
            /*System.err.println("no match found! \n haven't registered yet? press 'y' to register now or 'n' to try again.\n");
            String tmp=mk.nextLine();
            if(tmp=="y" || tmp=="Y") {
                register();
            }else if(tmp=="n" || tmp=="N") {
                login();
            }*/
        }
    }
    
    public void display(int x) {                                                     // displays the student list for each section 
        if(seats[x-1]==5) {
            System.err.println("No students enrolled yet into section-0"+x);
        }else {
            System.out.println("\n section-0"+x+"\n============");
            for(int c=0; c<studentNum; c++) {
                if(student[c].section==x) {
                    System.out.println("Name: "+student[c].name+"   SID: "+student[c].sid);
                }
            }
        }
        System.out.println();
    }
    
    public boolean checkId(int i) {                                                  // checks student ID
        for(int c=0; c<studentNum; c++) {
            if(student[c].sid==i) {
                idCheck=true;
                break;
            }
        }
        return idCheck;
    }
    
    public boolean checkEmail(String e) {                                            // checks student email
        for(int c=0; c<studentNum; c++) {
            if(student[c].email.equals(e)) {
                emailCheck=true;
                break;
            }
        }
        return emailCheck;
    }
}

