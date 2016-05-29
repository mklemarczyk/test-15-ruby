import static org.junit.Assert.*;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;

import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.h2.jdbcx.JdbcDataSource;
import org.h2.tools.RunScript;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class XmlDatabaseTest {

	public static final String JDBC_DRIVER = org.h2.Driver.class.getName();
	public static final String JDBC_URL = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
	public static final String USER = "sa";
	public static final String PASSWORD = "";
	
	
	@BeforeClass
	public static void createSchema() throws Exception {
		RunScript.execute(JDBC_URL, USER, PASSWORD, "SQLScripts/scheme.sql",StandardCharsets.UTF_8, false);
	}
	
	@Before
	public void importDataSet() throws Exception {
		IDataSet dataSet = readDataSet();
		cleanlyInsert(dataSet);
	}

	private IDataSet readDataSet() throws Exception {
		return new FlatXmlDataSet(new File("IDataSets/dataset.xml"));
	}
	
	private void cleanlyInsert(IDataSet dataSet) throws Exception {
		IDatabaseTester databaseTester = new JdbcDatabaseTester(JDBC_DRIVER,JDBC_URL,USER,PASSWORD);
		databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
		databaseTester.setDataSet(dataSet);
		databaseTester.onSetup();
	}

	@Test
	public void findsAndReadsExistingPersonByFirstName() throws Exception {
		PersonRepository repository = new PersonRepository(dataSource());
		Person charlie = repository.findPersonByFirstName("Charlie");
		repository.closeConnection();
		assertEquals(charlie.getNAME(), "Charlie");
	}
	
	@Test
	public void returnsNullWhenPersonCannotBeFound() throws Exception {
		PersonRepository repository = new PersonRepository(dataSource());
		Person charlie = repository.findPersonByFirstName("iDoNotExist");
		repository.closeConnection();
		assertEquals(charlie, null);
	}
	
	private JdbcDataSource dataSource() throws SQLException{
		JdbcDataSource dataSource = new JdbcDataSource();
		dataSource.setURL(JDBC_URL);
		dataSource.setUser(USER);
		dataSource.setPassword(PASSWORD);
		return dataSource;
	}
	
}
