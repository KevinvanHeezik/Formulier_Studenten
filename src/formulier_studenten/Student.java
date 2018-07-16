package formulier_studenten;

import java.sql.*;

public class Student {

    public static String COMMA = "; ";

    String id;
    String medestudent;
    String overig;

    void update(Connection conn) throws Exception {
        String query = "UPDATE klassenindeling.studenten SET Medestudent = ?, Overig = ? WHERE Studenten_Nummer = ?;";

        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setString(3, id);
        preparedStmt.setString(2, overig);
        preparedStmt.setString(1, medestudent);

        preparedStmt.executeUpdate();
    }

    @Override
    public String toString() {
        return id + COMMA + overig + COMMA + medestudent;
    }
}
