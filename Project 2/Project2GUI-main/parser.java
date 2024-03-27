import java.io.*;
import java.util.*;
import java.util.Scanner;


import java.util.ArrayList;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
public class parser {
    public static String removeLastChar(String s) {
        return (s == null || s.length() == 0)
          ? null 
          : (s.substring(0, s.length() - 1));
    }

    public static ArrayList<ArrayList<String>> ratings() throws FileNotFoundException {
        ArrayList<ArrayList<String>> arrList = new ArrayList<ArrayList<String>>();
        
        Scanner sc = new Scanner(new File("customer_ratings.csv"), "UTF-8");

        sc.useDelimiter("\\t|\\n");

        // ignore header
        for (int j = 0; j < 4; j++) {
            sc.next();
        } 

        String s1, s2;
        while (sc.hasNext()) {
            ArrayList<String> inner = new ArrayList<String>(4);
            sc.next();
            s1 = sc.next();
            inner.add(s1);

            
            inner.add(sc.next());
            inner.add(sc.next());
            s2 = sc.next();
            inner.add(s2);
            arrList.add(inner);
        }

        sc.close();
        return arrList;
    }

    public static ArrayList<ArrayList<String>> titles() throws FileNotFoundException {
        ArrayList<ArrayList<String>> arrList = new ArrayList<ArrayList<String>>();
        ArrayList<String> dupeList = new ArrayList<String> ();
        Scanner sc = new Scanner(new File("titles.csv"), "UTF-8");
        
        
        sc.nextLine();
        
        String s1;
        while (sc.hasNextLine()) {      
            String s = sc.nextLine();   
            
            Scanner chopper = new Scanner(s);   
            chopper.useDelimiter("\\t");
            while(chopper.hasNext())
            {
            ArrayList<String> inner = new ArrayList<String>(8);
            chopper.next();
            String c1 = chopper.next();
            inner.add(c1);
            inner.add(chopper.next());
            inner.add(chopper.next());
            chopper.next();
            chopper.next();
            inner.add(chopper.next());
            inner.add(chopper.next());
            inner.add(chopper.next());
            inner.add(chopper.next());
            s1 = chopper.next();
            // s1 = removeLastChar(s1);
            inner.add(s1);
            if(dupeList.contains(c1))
            {
                break;
            }
            if(inner.get(1).equals("videoGame") || inner.get(1).equals("tvEpisode"))
            {
                break;
            }
            arrList.add(inner);
            dupeList.add(c1);
            }
        }
        
        sc.close();
        return arrList;
        /*
        ArrayList<ArrayList<String>> arrList = new ArrayList<ArrayList<String>>();
        Scanner sc = new Scanner(new File("titles.xls"), "UTF-8");
        sc.useDelimiter("\\t|\\n");

        // ignore header
        for (int j = 0; j < 10; j++) {
            sc.next();
        }

        
        String s1;
        while (sc.hasNext()) {            
            ArrayList<String> inner = new ArrayList<String>(8);
            sc.next();
            inner.add(sc.next());
            inner.add(sc.next());
            inner.add(sc.next());
            sc.next();
            sc.next();
            inner.add(sc.next());
            inner.add(sc.next());
            inner.add(sc.next());
            inner.add(sc.next());
            s1 = sc.next();
            s1 = removeLastChar(s1);
            inner.add(s1);

            arrList.add(inner);
        }
        
        sc.close();
        return arrList;*/
    }

    public static ArrayList<ArrayList<String>> principals() throws FileNotFoundException {
        ArrayList<ArrayList<String>> arrList = new ArrayList<ArrayList<String>>();
        Scanner sc = new Scanner(new File("principals.csv"), "UTF-8");
        
        sc.useDelimiter("\\t|\\n");

        // ignore header
        for (int j = 0; j < 5; j++) {
            sc.next();
        }
        
        String s1, category;
        while (sc.hasNext()) {
            ArrayList<String> inner = new ArrayList<String>(4);
            // skip dummy
            sc.next();

            // title id, nconst, category, job, character
            inner.add(sc.next());
            inner.add(sc.next());

            // if category, remove everything but director, actress, actor, self, and composer
            category = sc.next();
            if (!(category.equals("director") || category.equals("actor") 
                                              || category.equals("actress") 
                                              || category.equals("self")
                                              || category.equals("writer"))) {
                sc.next();
                sc.next();
                continue;
            }
            //inner.add(category);
            
            inner.add(category);
            inner.add(sc.next());
            s1 = sc.next();
            //s1 = removeLastChar(s1);
            //s1 = s1.replace("\"", "\'");
            //inner.add(s1);

            // add inner list to outer list
            arrList.add(inner);
        }
        
        sc.close();
        return arrList;
    }

    public static ArrayList<ArrayList<String>> names() throws FileNotFoundException {
        ArrayList<ArrayList<String>> arrList = new ArrayList<ArrayList<String>>();
        Scanner sc = new Scanner(new File("names.csv"), "UTF-8");
        
        sc.useDelimiter("\\t|\\n");

        // ignore header
        for (int j = 0; j < 5; j++) {
            sc.next();
        }
        
        String s1;
        while (sc.hasNext()) {
            ArrayList<String> inner = new ArrayList<String>(3);
            // skip dummy
            sc.next();

            // nconst, primaryName, birthyear, deathyear, primaryprofession
            inner.add(sc.next());
            inner.add(sc.next());
            sc.next();
            sc.next();

            // primaryprofession needs to be altered maybe
            s1 = sc.next();
            inner.add(s1);

            // add inner list to outer list
            arrList.add(inner);
        }
        
        sc.close();
        return arrList;
    }

    public static ArrayList<ArrayList<String>> crew() throws FileNotFoundException {
        ArrayList<ArrayList<String>> arrList = new ArrayList<ArrayList<String>>();
        Scanner sc = new Scanner(new File("crew.csv"), "UTF-8");
        
        sc.useDelimiter("\\t|\\n");

        // ignore header
        for (int j = 0; j < 3; j++) {
            sc.next();
        }
        
        String s1;
        while (sc.hasNext()) {
            ArrayList<String> inner = new ArrayList<String>(3);
            // skip dummy
            sc.next();

            // add data to inner list
            inner.add(sc.next());
            inner.add(sc.next());
            s1 = sc.next();
            // s1 = removeLastChar(s1);
            inner.add(s1);

            // add inner list to outer list
            
            arrList.add(inner);
        }
        
        sc.close();
        return arrList;
    }
    
    public static void jdbcpostgreSQL(ArrayList<ArrayList<String>> ratings, ArrayList<ArrayList<String>> titles, ArrayList<ArrayList<String>> principals, ArrayList<ArrayList<String>> names, ArrayList<ArrayList<String>> crews) {

        //Commands to run this script
        //This will compile all java files in this directory
        //javac *.java 
        //This command tells the file where to find the postgres jar which it needs to execute postgres commands, then executes the code
        //Windows: java -cp ".;postgresql-42.2.8.jar" jdbcpostgreSQL
        //Mac/Linux: java -cp ".:postgresql-42.2.8.jar" jdbcpostgreSQL
      
        //MAKE SURE YOU ARE ON VPN or TAMU WIFI TO ACCESS DATABASE
          //Building the connection with your credentials
          //TODO: update dbName, userName, and userPassword here
           Connection conn = null;
           String teamNumber = "15";
           String sectionNumber = "903";
           String dbName = "csce315" + sectionNumber + "_" + teamNumber + "db";
           String dbConnectionString = "jdbc:postgresql://csce-315-db.engr.tamu.edu/" + dbName;
           String userName = "csce315" + sectionNumber + "_" + teamNumber + "user";
           String userPassword = "gigem";
      
          //Connecting to the database 
          try {
              conn = DriverManager.getConnection(dbConnectionString,userName, userPassword);
           } catch (Exception e) {
              e.printStackTrace();
              System.err.println(e.getClass().getName()+": "+e.getMessage());
              System.exit(0);
           }
      
           System.out.println("Opened database successfully");
           

           try{
             //create a statement object
             Statement createRatingsStmt = conn.createStatement();
             String createRatings = "Create Table ratings(customerId varchar, rating numeric, daterating date, titleId varchar);";
             createRatingsStmt.executeUpdate(createRatings);
             PreparedStatement ps = conn.prepareStatement("insert into ratings VALUES(?, ?, ?, ?)");
             
             for (ArrayList<String> a : ratings)
             {
                 
                 //java.util.Date d = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH).parse(a.get(2));
                 ps.setString(1, a.get(0));
                 ps.setDouble(2, Double.parseDouble(a.get(1)));
                 ps.setDate(3,java.sql.Date.valueOf(a.get(2)));
                 ps.setString(4, a.get(3));
                 ps.addBatch();
                 ps.clearParameters();
             }
             int [] results = ps.executeBatch();
             Statement createTitlesStmt = conn.createStatement();
             String createTitles = "Create Table titles(titleId	varchar, titleType varchar, originalTitle varchar, runtimeMinutes numeric, genres varchar ARRAY, year numeric, averageRating numeric, numVotes numeric);";
             createTitlesStmt.executeUpdate(createTitles);
             PreparedStatement ps2 = conn.prepareStatement("insert into titles VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
             for(ArrayList<String> a : titles)
             {
                 ps2.setString(1, a.get(0));
                 ps2.setString(2, a.get(1));
                 ps2.setString(3, a.get(2));
                 ps2.setInt(4,(a.get(3).equals("")) ? 0 : Integer.parseInt(a.get(3)));
                 ps2.setObject(5, a.get(4).split(","));
                 ps2.setInt(6, Integer.parseInt(a.get(5)));
                 ps2.setDouble(7, Double.parseDouble(a.get(6)));
                 ps2.setInt(8, Integer.parseInt(a.get(7)));
                 ps2.addBatch();
                 ps2.clearParameters();
             }
             int [] results2 = ps2.executeBatch();
             Statement createPrincipalsStmt = conn.createStatement();
             String createPrincipals = "Create Table principals(titleId varchar, nconst varchar, category varchar, jobs varchar);";
             createPrincipalsStmt.executeUpdate(createPrincipals);
             PreparedStatement ps3 = conn.prepareStatement("insert into principals VALUES (?, ?, ?, ?)");
             for(ArrayList<String> a : principals)
             {
                ps3.setString(1, a.get(0));
                ps3.setString(2, a.get(1));
                ps3.setString(3, a.get(2));
                ps3.setString(4, a.get(3));
                ps3.addBatch();
                ps3.clearParameters();
             }
             int [] results3 = ps3.executeBatch();
             Statement createNamesStmt = conn.createStatement();
             String createNames = "Create Table names(nconst varchar, primaryName varchar, primaryprofession varchar array);";
             createNamesStmt.executeUpdate(createNames);
             PreparedStatement ps4 = conn.prepareStatement("insert into names VALUES (?, ?, ?);");
             for(ArrayList<String> a : names)
             {
                 ps4.setString(1, a.get(0));
                 ps4.setString(2, a.get(1));
                 ps4.setObject(3, a.get(2).split(","));
                 ps4.addBatch();
                 ps4.clearParameters();
             }
             int [] results4 = ps4.executeBatch();
             Statement createCrewsStmt = conn.createStatement();
             String createCrews = "Create Table crews(titleId varchar, directors varchar array, writers varchar array);";
             createCrewsStmt.executeUpdate(createCrews);
             PreparedStatement ps5 = conn.prepareStatement("insert into crews VALUES (?, ?, ?);");
             for (ArrayList<String> a : crews)
             {
                 ps5.setString(1, a.get(0));
                 ps5.setObject(2, a.get(1).split(","));
                 ps5.setObject(3, a.get(2).split(","));
                 ps5.addBatch();
                 ps5.clearParameters();
             }
             int [] results5 = ps5.executeBatch();


            } catch (Exception e){
             e.printStackTrace();
             System.err.println(e.getClass().getName()+": "+e.getMessage());
             System.exit(0);
         }
          
          //closing the connection
          try {
            conn.close();
            System.out.println("Connection Closed.");
          } catch(Exception e) {
            System.out.println("Connection NOT Closed.");
          }//end try catch
        //end main
      }//end Class
    
    public static void clean()
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
        conn = DriverManager.getConnection(dbConnectionString,userName, userPassword);
     } catch (Exception e) {
        e.printStackTrace();
        System.err.println(e.getClass().getName()+": "+e.getMessage());
        System.exit(0);
     }

     System.out.println("Opened database successfully");
     
     try{
       //create a statement object
       Statement stmt = conn.createStatement();
       String sqlStatement = "drop table ratings";
       int result = stmt.executeUpdate(sqlStatement);

       stmt = conn.createStatement();
       sqlStatement = "drop table titles";
       result = stmt.executeUpdate(sqlStatement);

       stmt = conn.createStatement();
       sqlStatement = "drop table principals";
       result = stmt.executeUpdate(sqlStatement);

       stmt = conn.createStatement();
       sqlStatement = "drop table names";
       result = stmt.executeUpdate(sqlStatement);

       stmt = conn.createStatement();
       sqlStatement = "drop table crews";
       result = stmt.executeUpdate(sqlStatement);

       stmt = conn.createStatement();
       sqlStatement = "drop table watchHistory";
       result = stmt.executeUpdate(sqlStatement);

       stmt = conn.createStatement();
       sqlStatement = "drop table searchHistory";
       result = stmt.executeUpdate(sqlStatement);

       stmt = conn.createStatement();
       sqlStatement = "drop table customerprofile";
       result = stmt.executeUpdate(sqlStatement);
   } catch (Exception e){
       e.printStackTrace();
       System.err.println(e.getClass().getName()+": "+e.getMessage());
       System.exit(0);
   }
    
    //closing the connection
    try {
      conn.close();
      System.out.println("Connection Closed.");
    } catch(Exception e) {
      System.out.println("Connection NOT Closed.");
    }//end try catch
    }
    public static void custom()
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
           conn = DriverManager.getConnection(dbConnectionString,userName, userPassword);
        } catch (Exception e) {
           e.printStackTrace();
           System.err.println(e.getClass().getName()+": "+e.getMessage());
           System.exit(0);
        }
   
        System.out.println("Opened database successfully");
        
        try{
          //create a statement object
          Statement stmt = conn.createStatement();
          String sqlStatement = "create table watchHistory(customerID varchar, movieID varchar, viewingDuration numeric);";
          int result = stmt.executeUpdate(sqlStatement);
   
          stmt = conn.createStatement();
          sqlStatement = "create table searchHistory(customerID varchar, queryTyped varchar, movieID varchar);";
          result = stmt.executeUpdate(sqlStatement);
   
          stmt = conn.createStatement();
          sqlStatement = "create table customerProfile(customerID varchar, username varchar, password varchar, customer_name varchar);";
          result = stmt.executeUpdate(sqlStatement);
      } catch (Exception e){
          e.printStackTrace();
          System.err.println(e.getClass().getName()+": "+e.getMessage());
          System.exit(0);
      }
       
       //closing the connection
       try {
         conn.close();
         System.out.println("Connection Closed.");
       } catch(Exception e) {
         System.out.println("Connection NOT Closed.");
       }//end try catch 
    }
    public static void main(String[] args) throws Exception {
        Scanner kbreader = new Scanner(System.in);
        System.out.println("Do you want to clean the database? Y/N");
        String answer = kbreader.nextLine();
        if(answer.equals("Y"))
        {
            clean();
        }
        ArrayList<ArrayList<String>> arrList1 = ratings();
        ArrayList<ArrayList<String>> arrList2 = titles();
        ArrayList<ArrayList<String>> arrList3 = principals();
        ArrayList<ArrayList<String>> arrList4 = names();
        ArrayList<ArrayList<String>> arrList5 = crew();
        
        // inefficient duplicate cleaning if wanted
        /*
        // clean crew duplicates
        ArrayList<ArrayList<String>> arrList_crew_temp = arrList_crew;
        System.out.println("Crew size: " + arrList_crew.size());
        for (int i = 0; i < arrList_crew.size(); i++) {
            for (int k = i; k < arrList_crew_temp.size(); k++) {
                if (arrList_crew.get(i).get(0) == arrList_crew_temp.get(k).get(0)) {
                    // delete in arrList_crew
                    arrList_crew.remove(i);
                }
            }
        }
        System.out.println("Crew size: " + arrList_crew.size() + "\n");
        
        // clean ratings duplicates
        ArrayList<ArrayList<String>> arrList_ratings_temp = arrList_ratings;
        System.out.println("Ratings size: " + arrList_ratings.size());
        for (int i = 0; i < arrList_ratings.size(); i++) {
            for (int k = i; k < arrList_ratings_temp.size(); k++) {
                if ((arrList_ratings.get(i).get(0) == arrList_ratings_temp.get(k).get(0)) && (arrList_ratings.get(i).get(2) == arrList_ratings_temp.get(k).get(2))) {
                    // delete in arrList_crew
                    arrList_ratings.remove(i);
                }
            }
        }
        System.out.println("Ratings size: " + arrList_ratings.size());
        
        // clean principals
        ArrayList<ArrayList<String>> arrList_principals_temp = arrList_principals;
        System.out.println("Principals size: " + arrList_principals.size());
        for (int i = 0; i < arrList_principals.size(); i++) {
            for (int k = i; k < arrList_principals_temp.size(); k++) {
                if ((arrList_principals.get(i).get(0) == arrList_principals_temp.get(k).get(0)) && (arrList_principals.get(i).get(1) == arrList_principals_temp.get(k).get(1))) {
                    // delete in arrList_crew
                    arrList_ratings.remove(i);
                }
            }
        }
        System.out.println("Principals size: " + arrList_principals.size());

        for (ArrayList<String> row : arrList_titles) {
            System.out.println(row);
        }

        // clean titles
        ArrayList<ArrayList<String>> arrList_titles_temp = arrList_titles;
        System.out.println("Titles size: " + arrList_titles.size());
        for (int i = 0; i < arrList_titles.size(); i++) {
            for (int k = i; k < arrList_titles_temp.size(); k++) {
                if ((arrList_titles.get(i).get(0) == arrList_titles_temp.get(k).get(0))) {
                    arrList_titles.remove(i);
                }
            }
        }
        System.out.println("Titles size: " + arrList_titles.size());

        // clean names
        ArrayList<ArrayList<String>> arrList_names_temp = arrList_names;
        System.out.println("Names size: " + arrList_names.size());
        for (int i = 0; i < arrList_names.size(); i++) {
            for (int k = i; k < arrList_names_temp.size(); k++) {
                if ((arrList_names.get(i).get(0) == arrList_names_temp.get(k).get(0))) {
                    arrList_names.remove(i);
                }
            }
        }
        System.out.println("Names size: " + arrList_names.size());
        */
        System.out.println("Do you want to populate the database? Y/N");
        answer = kbreader.nextLine();
        if (answer.equals("Y"))
        {
            jdbcpostgreSQL(arrList1, arrList2, arrList3, arrList4, arrList5);
        }
        System.out.println("Do you want to make the custom tables? Y/N");
        answer = kbreader.nextLine();
        if (answer.equals("Y"))
        {
            custom();
        }
        
        
    }
}
