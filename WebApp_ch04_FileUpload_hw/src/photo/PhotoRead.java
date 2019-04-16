package photo;

import java.sql.*;
import java.io.*;

class PhotoRead {

        static {
            try {
                 Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            } catch (Exception e) {
                 e.printStackTrace();
            }
        }
        
        public static void main(String argv[]) {
                Connection con = null;
                Statement stmt = null;
                ResultSet rs = null;
                String url = "jdbc:oracle:thin:@localhost:1521:XE";
                String userid = "CA107";
                String passwd = "123456";
                
                try {
                        con = DriverManager.getConnection(url, userid, passwd);
                        System.out.println("Retrieve some data from the database...");
                        stmt = con.createStatement();
                        rs = stmt.executeQuery("SELECT * from emp_photo");
                        System.out.println("Received results:");

                        while (rs.next()) {
                           String empNo = rs.getString("empno").trim(); //��쫬�O��char, ���X��Ʈ�, �`�Ntrim()�h���i�઺�Ů�
                           String photo_format = rs.getString("photo_format");
                           InputStream in = rs.getBinaryStream("picture");
                            //InputStream rs.getBinaryStream(String columnName)  throws SQLException           
                            //InputStream rs.getBinaryStream(int columnIndex) throws SQLException
			  
                           File file = new File("picReaded", empNo + "." + photo_format); //�۹���|-picReaded
                           //������|, Ĵ�p File file = new File("x:\\aa\\bb\\picReaded", empNo + "." + photo_format);
                           OutputStream out = new FileOutputStream(file);
				
                           byte[] buffer = new byte[4 * 1024];
                           int len = 0;
                           while ((len = in.read(buffer)) != -1) {
                             out.write(buffer, 0, len);
                           }
				
                           in.close();
                           out.close();

                           System.out.print(" EMPNO = " + empNo);
                           System.out.print(", PHOTO_FORMAT = " + photo_format);
                           System.out.println(", �ɮ׿�X���| = " + file.getPath());
                       }

                       rs.close();
                       stmt.close();

               } catch (Exception e) {
                      e.printStackTrace();
               } finally {
                    try {
                      con.close();
                    } catch (SQLException e) {
                    }
               }
        }
}