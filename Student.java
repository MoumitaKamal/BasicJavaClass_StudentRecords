/***********************************************************
  *Title: Student Class 
  * 
  *Description: Contains student information (name, ID, email ID, student account password, and sections the student is enrolled in). 
  *Date: August 2015
  * 
  *Author: Moumita Kamal
  ***********************************************************/

public class Student{
    // declare public variables 
    public String name;        
    public int sid;            // student ID
    
    // declare prvate variables
    private String email;       
    private String password;    
    private int section;        // stores section number 
    
    // get set methods to access private data
    public void setEmail(String e) {
        email = e;
    }
    public String getEmail() {
        return email;
    }
    
    public void setPass(String p) {
        password = p;
    }
    public String getPass() {
        return password;
    }
    
    public void setSec(int s) {
        section = s;
    }
    public int getSec() {
        return section;
    }
}