package ug.lab.proj160518;

import java.sql.*;

public class PersonRepository {

	private Connection conn;

	public PersonRepository(Connection dataConnection) throws SQLException {
		conn = dataConnection;
	}

	public Person findPersonByFirstName(String firstName) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM PERSON WHERE firstName LIKE ?;");
		stmt.setString(1, firstName);

		ResultSet set = stmt.executeQuery();

		Person personTemp;
		if (!set.next()) {
			personTemp = null;

		} else {
			personTemp = new Person(set.getInt(1));
			personTemp.setName(set.getString(2));
			personTemp.setLastName(set.getString(3));
			personTemp.setAge(set.getInt(4));
		}
		return personTemp;
	}

	public Person findPersonByLastName(String lastName) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM PERSON WHERE lastName LIKE ?;");
		stmt.setString(1, lastName);

		ResultSet set = stmt.executeQuery();

		Person personTemp;
		if (!set.next()) {
			personTemp = null;

		} else {
			personTemp = new Person(set.getInt(1));
			personTemp.setName(set.getString(2));
			personTemp.setLastName(set.getString(3));
			personTemp.setAge(set.getInt(4));
		}
		return personTemp;
	}

	public Person findPersonByAge(Integer name) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM PERSON WHERE age LIKE ?;");
		stmt.setInt(1, name);

		ResultSet set = stmt.executeQuery();

		Person personTemp;
		if (!set.next()) {
			personTemp = null;

		} else {
			personTemp = new Person(set.getInt(1));
			personTemp.setName(set.getString(2));
			personTemp.setLastName(set.getString(3));
			personTemp.setAge(set.getInt(4));
		}
		return personTemp;
	}

	public boolean insertPerson(String firstName, String lastName, Integer name) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("INSERT INTO PERSON(firstName, lastName, age) VALUES(?, ?, ?);");
		stmt.setString(1, firstName);
		stmt.setString(2, lastName);
		stmt.setInt(3, name);

		return stmt.executeUpdate() == 1;
	}

	public boolean updatePerson(Person person) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("UPDATE PERSON SET firstName=?, lastName=?, age=? WHERE id=?;");
		stmt.setString(1, person.getName());
		stmt.setString(2, person.getLastName());
		stmt.setInt(3, person.getAge());
		stmt.setInt(4, person.getId());

		return stmt.executeUpdate() == 1;
	}

	public boolean deletePerson(Person person) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("DELETE FROM PERSON WHERE firstName=? AND lastName=? AND age=?;");
		stmt.setString(1, person.getName());
		stmt.setString(2, person.getLastName());
		stmt.setInt(3, person.getAge());

		return stmt.executeUpdate() == 1;
	}

	public void closeConnection() throws SQLException {
		conn.close();
	}

}
