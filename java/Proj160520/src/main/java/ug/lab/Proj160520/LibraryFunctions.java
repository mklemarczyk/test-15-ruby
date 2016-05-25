package ug.lab.Proj160520;

import java.sql.*;
import ug.lab.Proj160520.Models.Author;
import ug.lab.Proj160520.Models.Book;

public class LibraryFunctions {

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:h2:mem:test", "sa", "");
	}

	public int HowManyBooks() throws SQLException {
		Statement stmt = getConnection().createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM Books;");
		int howBooks = 0;
		while (rs.next()) {
			howBooks++;
		}
		getConnection().close();
		return howBooks;
	}

	public Book FindBook(String title, int year) throws SQLException {
		PreparedStatement stmt = getConnection().prepareStatement("SELECT id_book, title, year FROM Books WHERE title=? AND year=?;");
		stmt.setString(1, title);
		stmt.setInt(2, year);
		ResultSet rs = stmt.executeQuery();
		Book result = null;
		if (rs.next()) {
			result = new Book(rs.getInt(1), rs.getString(2), rs.getInt(3));
		}
		getConnection().close();
		return result;
	}

	public Author FindAuthor(String firstname, String lastname) throws SQLException {
		PreparedStatement stmt = getConnection().prepareStatement("SELECT id_author, firstname, lastname FROM Authors WHERE firstname=? AND lastname=?;");
		stmt.setString(1, firstname);
		stmt.setString(2, lastname);
		ResultSet rs = stmt.executeQuery();
		Author result = null;
		if (rs.next()) {
			result = new Author(rs.getInt(1), rs.getString(2), rs.getString(3));
		}
		getConnection().close();
		return result;
	}

	public boolean DeleteBook(String title, int year) throws SQLException {
		if (FindBook(title, year) != null) {
			PreparedStatement stmt = getConnection().prepareStatement("DELETE FROM Books WHERE title=? AND year=?;");
			stmt.setString(1, title);
			stmt.setInt(2, year);
			int rs = stmt.executeUpdate();
			getConnection().close();
			return rs > 0;
		}
		return false;
	}

	public boolean DeleteAuthor(String firstname, String lastname) throws SQLException {
		if (FindAuthor(firstname, lastname) != null) {
			PreparedStatement stmt = getConnection().prepareStatement("DELETE FROM Authors WHERE firstname=? AND lastname=?;");
			stmt.setString(1, firstname);
			stmt.setString(2, lastname);
			int rs = stmt.executeUpdate();
			getConnection().close();
			return rs > 0;
		}
		return false;
	}

	public boolean Insert(String firstname, String lastname, String title, int year) throws SQLException {
		Author author = FindAuthor(firstname, lastname);
		Book book = FindBook(title, year);
		if (author == null) {
			PreparedStatement stmt = getConnection().prepareStatement("INSERT INTO Authors(firstname, lastname) VALUES (?, ?);");
			stmt.setString(1, firstname);
			stmt.setString(2, lastname);
			stmt.executeUpdate();
			getConnection().close();
			author = FindAuthor(firstname, lastname);
		}
		if (book == null) {
			PreparedStatement stmt = getConnection().prepareStatement("INSERT INTO Books(title, year) VALUES (?, ?);");
			stmt.setString(1, title);
			stmt.setInt(2, year);
			stmt.executeUpdate();
			getConnection().close();
			book = FindBook(title, year);
		}
		PreparedStatement stmt = getConnection().prepareStatement("INSERT INTO Books_has_authors(Authors_id_author, Books_id_book) VALUES (?, ?);");
		stmt.setInt(1, author.getId_author());
		stmt.setInt(2, book.getId_book());
		int rs = stmt.executeUpdate();
		getConnection().close();
		return rs > 0;
	}

}
