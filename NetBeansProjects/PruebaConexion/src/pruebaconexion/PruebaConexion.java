package pruebaconexion;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class PruebaConexion {

    public static void main(String[] args) {
   
        try {
          
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1/bicicleterias","root","root");
            
                System.out.println("exito");
            
                Statement s = c.createStatement();
                
                
                ResultSet res = s.executeQuery("select * from bicicleteria where cantVentas >180;");
                while(res.next()) {
                    
                    System.out.print(res.getString("idbicicleteria"));
                    System.out.println("\r");
                    System.out.print(res.getString("ganancias"));
                    System.out.println("\r");
                }
//                    
                
//                int res = s.executeUpdate("insert into bicicleteria values (3,0,0)");
//                System.out.println("Retrono: "+res); 
                
        } catch (Exception e) {
            System.out.println("no pudo conectarse");
        }
        
    }
    
}
