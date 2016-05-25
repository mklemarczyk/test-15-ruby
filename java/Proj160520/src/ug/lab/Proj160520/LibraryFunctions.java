package ug.lab.Proj160520;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class LibraryFunctions {

  private Connection getConnection() throws SQLException {
	  return DriverManager.getConnection("jdbc:h2:mem:test","sa","");
  }
 
  public int HowManyBooks() throws SQLException {
	Statement stmt = getConnection().createStatement();
	ResultSet rs = stmt.executeQuery("SELECT * FROM Books;");
	int howBooks = 0;
	while(rs.next()){
		howBooks++;
	}
	getConnection().close();
	return howBooks;
  }
  
}
