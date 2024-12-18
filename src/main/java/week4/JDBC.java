package week4;

/**
 *  Spring Data JPA[Hibernate[JDBC]]
 *
 *  JDBC
 *
 *  1. SQL injection:
 *      usernameVar: 'xxx'
 *      passwordVar: " '..' ;or true' "
 *      "select ... from ... where username = " + usernameVar + " and password = " + passwordVar
 *
 *      select ... from ... where username = xxx and password =  " '..' ;or true' ";
 *
 *  2.  no connection pool
 *  3.  no object mapping
 *  4.  no centralized query language
 *  5.  no dynamic query builder
 *  6.  no cache
 *
 *  List<Student> students
 *  for(Student student: students) {
 *      Teacher teacher = student.getTeacher();
 *  }
 *
 *
 *

public class SelectExample {
   static final String DB_URL = "jdbc:mysql://localhost/TUTORIALSPOINT";
   static final String USER = "guest";
   static final String PASS = "guest123";
   static final String QUERY = "SELECT id, first, last, age FROM Employees";

   public static void main(String[] args) {
      // Open a connection
      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(QUERY);) {
         // Extract data from result set
         while (rs.next()) {
            // Retrieve by column name
            System.out.print("ID: " + rs.getInt("id"));
            System.out.print(", Age: " + rs.getInt("age"));
            System.out.print(", First: " + rs.getString("first"));
            System.out.println(", Last: " + rs.getString("last"));
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
            ..
     }
   }
}

 Tomorrow
 Spring data jpa
 Hibernate



 */
