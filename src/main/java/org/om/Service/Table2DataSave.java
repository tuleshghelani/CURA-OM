package org.om.Service;

import org.joda.time.DateTime;
import org.om.Model.Temp2;
import org.om.config.PostgresConnection;

import java.sql.*;
import java.util.List;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Table2DataSave {
    public void dataStore(List<Temp2> temp2) {
        TimeZone.setDefault(TimeZone.getTimeZone("Etc/IST"));

        PostgresConnection postgresConnection=new PostgresConnection();
        Connection con= null;

        try {
            con = postgresConnection.connection();
            Statement st = con.createStatement();

            String sql
                    = "INSERT INTO public.temp2 (\"Period\", \"Created_date\")\n" +
                    "VALUES ( ?, ?);\n";

            PreparedStatement pstmt;
            pstmt = con.prepareStatement(sql);
            final int batchSize = 5000;
            int count = 0;
            System.out.println("pstmt : "+ pstmt);

            for (int i = 0; i < 1; i++) {

                System.out.println("temp : "+temp2.get(0).getPeriod());
                pstmt.setString(1, temp2.get(i).getPeriod());
                pstmt.setTimestamp(2, temp2.get(i).getCreatedDate());
                /*pstmt.setInt(3, temp2.get(i).getQueryID());
                pstmt.setString(4, temp2.get(i).getQueryName());
                pstmt.setInt(5, temp2.get(i).getPublishAsAdhocSurvey());
                pstmt.setBoolean(6, temp2.get(i).getPagingEnabled());*/
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
