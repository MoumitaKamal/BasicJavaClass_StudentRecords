/***********************************************************
 *Title: Student Records Main 

 *Description: Driver class for student records program
 
 *Author: Moumita Kamal
 ***********************************************************/

import java.util.*;
public class Main {
    public static void main (String[]args) {
        Scanner mk=new Scanner(System.in);
        StudentRecords records = new StudentRecords();                       // create new student record object
        
        while(true){
            System.out.println("Press 's' if you are a student,'t' if you are a teacher and 'X' to end the session:");
            String ans=mk.nextLine();
            if(ans.equals("s") || ans.equals("S")){                          // users = Student
                System.out.println("Do you want to register? y/n");
                String reply=mk.nextLine();
                if(reply.equals("y") || reply.equals("Y")){
                    records.register();                                      // register student
                }
                else if(reply.equals("n") || reply.equals("N")) {
                    System.out.println("Do you want to log in? y/n");
                    String login=mk.nextLine();
                    if(login.equals("y") || login.equals("Y")){
                        records.login();                                     // redirect to student account log in
                    }else if(login.equals("n") || login.equals("N")) {
                        break;
                    }else {
                        System.err.println("invalid input");                 // input validation
                    }
                }else {
                    System.err.println("invalid input");                     // input validation
                }
            }else if(ans.equals("t") || ans.equals("T")) {                   // users = Faculty 
                System.out.println("Press 1 to see student list for section 01, 2 to see section 02 and 3 to see section 03");
                int print=mk.nextInt();
                mk.nextLine();
                if(print==1 || print==2 || print==3) {
                    records.display(print);                                  // display student list for that section
                }else {
                    System.err.println("invalid input");                     // input validation
                }
                
            }else if(ans.equals("x") || ans.equals("X")) {                   // exit program
                System.out.println("Have a nice day!");
                break;
            }else {
                System.err.println("invalid input. Try again:");
            }
        }
    }
}