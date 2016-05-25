package ug.lab.Proj160520;

import java.io.File;
import java.sql.*;
import org.dbunit.DatabaseTestCase;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.junit.Test;
import ug.lab.Proj160520.Models.Author;
import ug.lab.Proj160520.Models.Book;

public class LibraryFunctionsTest extends DatabaseTestCase {

	private Connection jdbcConnection;
	private FlatXmlDataSet loadedDataSet;

	@Override
	protected IDatabaseConnection getConnection() throws Exception {
		Class.forName("org.h2.Driver");
		jdbcConnection = DriverManager.getConnection("jdbc:h2:mem:test", "sa", "");
		SetupDatabase.Setup();
		DatabaseConnection result = new DatabaseConnection(jdbcConnection);
		//result.getConfig().setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new H2DataTypeFactory());
		return result;
	}

	@Override
	protected IDataSet getDataSet() throws Exception {
		loadedDataSet = new FlatXmlDataSet(new File("IDataSets/dbunitData.xml"));
		return loadedDataSet;
	}

	@Test
	public void testHowManyBooks() throws SQLException {
		LibraryFunctions function = new LibraryFunctions();
		int result = function.HowManyBooks();
		assertEquals(result, 2);
	}

	@Test
	public void testFindBookExists() throws SQLException {
		LibraryFunctions function = new LibraryFunctions();
		Book result = function.FindBook("W pustyni i w puszczy", 2000);
		assertNotNull(result);
	}

	@Test
	public void testFindBookNotExists() throws SQLException {
		LibraryFunctions function = new LibraryFunctions();
		Book result = function.FindBook("W pustyni", 2000);
		assertNull(result);
	}

	@Test
	public void testFindAuthorExists() throws SQLException {
		LibraryFunctions function = new LibraryFunctions();
		Author result = function.FindAuthor("Henryk", "Sienkiewicz");
		assertNotNull(result);
	}

	@Test
	public void testFindAuthorNotExists() throws SQLException {
		LibraryFunctions function = new LibraryFunctions();
		Author result = function.FindAuthor("Henryk", "Kwiatkowski");
		assertNull(result);
	}

	@Test
	public void testDeleteBookExists() throws SQLException {
		LibraryFunctions function = new LibraryFunctions();
		boolean result = function.DeleteBook("W pustyni i w puszczy", 2000);
		assertTrue(result);
	}

	@Test
	public void testDeleteBookNotExists() throws SQLException {
		LibraryFunctions function = new LibraryFunctions();
		boolean result = function.DeleteBook("W pustyni", 2000);
		assertFalse(result);
	}

	@Test
	public void testDeleteAuthorExists() throws SQLException {
		LibraryFunctions function = new LibraryFunctions();
		boolean result = function.DeleteAuthor("Henryk", "Sienkiewicz");
		assertTrue(result);
	}

	@Test
	public void testDeleteAuthorNotExists() throws SQLException {
		LibraryFunctions function = new LibraryFunctions();
		boolean result = function.DeleteAuthor("Henryk", "Kwiatkowski");
		assertFalse(result);
	}

	@Test
	public void testInsertNewBookWithNewAuthor() throws SQLException {
		LibraryFunctions function = new LibraryFunctions();
		boolean result = function.Insert("Adam", "Malysz", "Narty", 2001);
		assertTrue(result);
	}

	@Test
	public void testInsertNewAuthor() throws SQLException {
		LibraryFunctions function = new LibraryFunctions();
		boolean result = function.Insert("Adam", "Kozlowski", "Narty", 2001);
		assertTrue(result);
	}

	@Test
	public void testInsertNewBook() throws SQLException {
		LibraryFunctions function = new LibraryFunctions();
		boolean result = function.Insert("Adam", "Malysz", "Google", 2015);
		assertTrue(result);
	}

	@Test
	public void testInsertNullWithNewAuthor_Error() {
		LibraryFunctions function = new LibraryFunctions();
		try {
			function.Insert("Tomasz", "Trichnos", null, 2001);
			fail("should not reach this, expected SQL Exception");
		} catch (Exception ex) {
			assertTrue(true);
		}
	}

	@Test
	public void testInsertNullWithNewBook_Error() {
		LibraryFunctions function = new LibraryFunctions();
		try {
			function.Insert(null, null, "Slowo", 2001);
			fail("should not reach this, expected Null Pointer Exception");
		} catch (Exception ex) {
			assertTrue(true);
		}
	}

}
