package formulier_studenten;

import java.sql.*;
import java.util.*;

public class Formulier_Studenten {

    Connection conn;

    public static void main(String[] args) {

        Formulier_Studenten formulier = new Formulier_Studenten();
        
        //formulier.getID();
        formulier.getConnection();
        //System.out.println(getID());
        
         
    }
    
    public static String getID(){
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Student nummer");
        String id = scanner.nextLine();
        System.out.println("Student nummer is " + id);
        return id;
    }
    
    public static String getMedestudent(){
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Medestudent");
        String medestudent = scanner.nextLine();
        System.out.println("Medestudent is " + medestudent);
        return medestudent;
    } 
    
    public static String getOverig(){
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Overig");
        String overig = scanner.nextLine();
        System.out.println("Overig is " + overig);
        return overig;
    }

    public void getConnection() {
        try {
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/klassenindeling";
            String username = "root";
            String password = "root";
            Class.forName(driver);

            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected");
            
            Student student = new Student();
            
            student.id = getID();
            student.medestudent = getMedestudent();
            student.overig = getOverig();
            
            student.insert(conn);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
