package Project2GUI;

import java.util.*;

import javax.naming.spi.DirStateFactory.Result;

import java.io.*;
import static java.lang.System.*;
import java.sql.*;

public class P2backend 
{
    public static void main (String [] args)
    {

    }
    //result is distinct user ids
    public static ResultSet users() throws Exception
    {
        Connection conn = null;
        String teamNumber = "15";
        String sectionNumber = "903";
        String dbName = "csce315" + sectionNumber + "_" + teamNumber + "db";
        String dbConnectionString = "jdbc:postgresql://csce-315-db.engr.tamu.edu/" + dbName;
        String userName = "csce315" + sectionNumber + "_" + teamNumber + "user";
        String userPassword = "gigem";
        ResultSet result;
       //Connecting to the database 
       try {
           conn = DriverManager.getConnection(dbConnectionString,userName, userPassword);
        } catch (Exception e) {
           e.printStackTrace();
           System.err.println(e.getClass().getName()+": "+e.getMessage());
           System.exit(0);
        }
   
        System.out.println("Opened database successfully");
         //create a statement object
        Statement userStmt = conn.createStatement();
        String grabUsers = "select distinct(customerid) from ratings;";
        result = userStmt.executeQuery(grabUsers);


        try {
            conn.close();
            System.out.println("Connection Closed.");
        } catch(Exception e) {
            System.out.println("Connection NOT Closed.");
        }//end try catch
     //end main
     return result;
   }//end Class

    public static ResultSet contentviewerWatch(String User, String month, String year) throws Exception
    {
        Connection conn = null;
           String teamNumber = "15";
           String sectionNumber = "903";
           String dbName = "csce315" + sectionNumber + "_" + teamNumber + "db";
           String dbConnectionString = "jdbc:postgresql://csce-315-db.engr.tamu.edu/" + dbName;
           String userName = "csce315" + sectionNumber + "_" + teamNumber + "user";
           String userPassword = "gigem";
      
          //Connecting to the database 
          try {
              Class.forName("org.postgresql.Driver");
              conn = DriverManager.getConnection(dbConnectionString,userName, userPassword);
           } catch (Exception e) {
              e.printStackTrace();
              System.err.println(e.getClass().getName()+": "+e.getMessage());
              System.exit(0);
           }
      
           System.out.println("Opened database successfully");
            //create a statement object
            Statement WatchStmt = conn.createStatement();
            String getWatchHistory = 
            "select customerid, daterating, a.titleid, b.originaltitle from ratings a inner join titles b on a.titleid = b.titleid" + 
            " where customerid = \'" + User + "\' and daterating > (date \'" + year + "-" + month + "-01\') and daterating < (date \'" + year + "-" + month + "-28\') order by daterating desc, originaltitle limit 10;";
            //"select customerid, daterating, a.titleid, b.originaltitle from ratings a inner join titles b on a.titleid = b.titleid;";
             ResultSet result = WatchStmt.executeQuery(getWatchHistory);
        
        try {
            conn.close();
            System.out.println("Connection Closed.");
          } catch(Exception e) {
            System.out.println("Connection NOT Closed.");
          }//end try catch
        //end main
        return result;
      }//end Class

    public static ResultSet contentanalyst(String month, String year) throws Exception {
        Connection conn = null;
        String teamNumber = "15";
        String sectionNumber = "903";
        String dbName = "csce315" + sectionNumber + "_" + teamNumber + "db";
        String dbConnectionString = "jdbc:postgresql://csce-315-db.engr.tamu.edu/" + dbName;
        String userName = "csce315" + sectionNumber + "_" + teamNumber + "user";
        String userPassword = "gigem";
        ResultSet result;
       //Connecting to the database 
       try {
           conn = DriverManager.getConnection(dbConnectionString,userName, userPassword);
        } catch (Exception e) {
           e.printStackTrace();
           System.err.println(e.getClass().getName()+": "+e.getMessage());
           System.exit(0);
        }
   
        System.out.println("Opened database successfully");
         //create a statement object
        Statement userStmt = conn.createStatement();
        String getWatchHistory = 
        "select originaltitle, count(b.titleid) from titles a inner join ratings b on a.titleid = b.titleid"
        + " where daterating > (date \'" + year + "-" + month + "-01\') and daterating < (date \'" + year + "-" + month + "-28\') "
        + "group by originaltitle order by count(b.titleid) desc";
        result = userStmt.executeQuery(getWatchHistory);


        try {
            conn.close();
            System.out.println("Connection Closed.");
        } catch(Exception e) {
            System.out.println("Connection NOT Closed.");
        }//end try catch
     //end main
     return result;
    }
}