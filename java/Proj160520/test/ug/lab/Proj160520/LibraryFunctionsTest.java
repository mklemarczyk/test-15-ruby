package ug.lab.Proj160520;


import java.io.File;
import java.sql.*;
import org.dbunit.DatabaseTestCase;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.junit.Test;

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

}
