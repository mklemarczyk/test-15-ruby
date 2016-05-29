import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.h2.jdbcx.JdbcDataSource;


public class PersonRepository {

	private Connection conn;
	private Person personTemp;
	private Statement stmt;
	
	public PersonRepository(JdbcDataSource jdbcDataSource) throws SQLException{
		conn = jdbcDataSource.getConnection();
	}

	public Person findPersonByFirstName(String name) throws SQLException {
		stmt = null;
		stmt = conn.createStatement();
		String query = "SELECT * FROM PERSON WHERE NAME LIKE '" + name + "';";
		ResultSet set = stmt.executeQuery(query);
		  if(!set.next()){
			  personTemp = null;
			  
		  }
		  else{
			  personTemp = new Person();
			  personTemp.setNAME(set.getString(2));
			  personTemp.setLAST_NAME(set.getString(3));
		  }
		return personTemp;
	}

	public void closeConnection() throws SQLException {
		conn.close();
	}

}
