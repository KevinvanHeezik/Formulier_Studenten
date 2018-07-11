package formulier_studenten;

import java.sql.*;

public class Formulier_Studenten {

    Connection conn;

    public static void main(String[] args) {

        Formulier_Studenten formulier = new Formulier_Studenten();

        formulier.getConnection();
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

            student.stud_nr = "0954321";
            student.voornaam = "Jan Smit";
            student.tussenvoegsel = "Volendam";
            student.achternaam = "HAVO";
            student.geboortedatum = Date.valueOf("1990-5-31");
            student.geslacht = "M";
            student.nationaliteit = "Nederlands";
            
            student.insert(conn);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
