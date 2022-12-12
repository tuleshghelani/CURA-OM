package org.om.Service;

import org.om.Model.Temp1;

import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Table1DataSave {

    public void dataStore(List<Temp1> temp1) {
        String url = "jdbc:postgresql://database-1.cultd7iwyred.ap-south-1.rds.amazonaws.com:5432/postgres";
        String user = "postgres";
        String password = "postgres";

        System.out.println("Inside datastore()");

        try (Connection con = DriverManager.getConnection(url, user, password)) {
            Statement st = con.createStatement();
            String sql
                    = "INSERT INTO public.\"Temp1\" (\"RegisterID\", \"RegisterName\", \"QueryID\", \"QueryName\", \"PublishAsAdhocSurvey\", \"isPagingEnabled\") " +
                    " VALUES (?, ?, ?, ?, ?, ?);\n";

            PreparedStatement pstmt;
            pstmt = con.prepareStatement(sql);
            final int batchSize = 5000;
            int count = 0;
            System.out.println("pstmt : "+ pstmt);

            for (int i = 0; i < 1; i++) {

                System.out.println("temp : "+temp1.get(0).getQueryName());
                pstmt.setInt(1, temp1.get(i).getRegisterID());
                pstmt.setString(2, temp1.get(i).getRegisterName());
                pstmt.setInt(3, temp1.get(i).getQueryID());
                pstmt.setString(4, temp1.get(i).getQueryName());
                pstmt.setInt(5, temp1.get(i).getPublishAsAdhocSurvey());
                pstmt.setBoolean(6, temp1.get(i).getPagingEnabled());
                pstmt.addBatch();
                count++;

                if (count % batchSize == 0) {
                    System.out.println("Commit the batch");
                    pstmt.executeBatch();
                }
                pstmt.executeBatch();

            }
        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(Table1DataSave.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }

    }

}
