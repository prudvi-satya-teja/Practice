//import java.sql.*;
//
//public class JDBCConnector {
//    public static void main(String[] args) {
//
//        /*
//            import packages
//            load the driver
//            register the driver
//            create connection
//            create statement
//            execute statement
//            close connection
//         */
//
//        try {
//
//           // Class.forName("com.mysql.cj.jdbc.Driver");
//
//            String url = "jdbc:mysql://localhost:3306/springboot";
//            String username = "root";
//            String password = "3495";
//
//            Connection conn = DriverManager.getConnection(url, username, password);
////            System.out.println("Connection established");
//
//            int id = 49;
//            String name = "shoes";
//            double price = 150;
//
//            String sql = "insert into product values(?,?,?)";
//
//            PreparedStatement stmt = conn.prepareStatement(sql);
//            stmt.setInt(1, id);
//            stmt.setString(2, name);
//            stmt.setDouble(3, price);
//
//            boolean rs = stmt.execute();
//
//            System.out.println(rs);
//
////            ResultSetMetaData rsmd = rs.getMetaData();
//
//            // Printing the data from the table
////            int columnCount = rsmd.getColumnCount();
////            for(int i=1; i<=columnCount; i++) {
////                System.out.print(rsmd.getColumnName(i) + "  - ");
////            }
//
////            System.out.println();
////
////            while(rs.next()) {
////                for(int i=1; i<=columnCount; i++) {
////                    System.out.print(rs.getObject(i) + "  -   ");
////                }
////                System.out.println();
////            }
//
//
//            // insert the data into the table
//
//
//            conn.close();
//            System.out.println("Connection closed");
//
//        }
//        catch (Exception e) {
//            System.out.println(e);
//        }
//    }
//}


import java.sql.*;

public class JDBCConnector {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/springboot";
            String name = "root";
            String password = "3495";

            Connection conn = DriverManager.getConnection(url, name, password);

            String sql = "select * from product";

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.print(rs.getString(1));
                System.out.print(rs.getString(2));
                System.out.println(rs.getString(3));
            }
            conn.close();
        }
        catch(Exception e) {
            System.out.println("Exception: "  + e.getMessage());
        }


    }
}