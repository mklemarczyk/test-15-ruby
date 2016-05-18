package ug.lab.proj160518;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.SQLException;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.h2.jdbcx.JdbcDataSource;
import org.h2.tools.RunScript;
import static org.junit.Assert.assertEquals;
import org.junit.*;

public class H2DatabaseTest {

	public static final String JDBC_DRIVER = org.h2.Driver.class.getName();
	public static final String JDBC_URL = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
	public static final String USER = "sa";
	public static final String PASSWORD = "";

	@BeforeClass
	public static void createSchema() throws Exception {
		RunScript.execute(JDBC_URL, USER, PASSWORD, "SQLScripts/scheme.sql", StandardCharsets.UTF_8, false);
	}

	@Before
	public void importDataSet() throws Exception {
		IDataSet dataSet = readDataSet();
		cleanlyInsert(dataSet);
	}

	protected IDataSet readDataSet() throws Exception {
		return new FlatXmlDataSet(new File("IDataSets/dataset.xml"));
	}

	protected void cleanlyInsert(IDataSet dataSet) throws Exception {
		IDatabaseTester databaseTester = new JdbcDatabaseTester(JDBC_DRIVER, JDBC_URL, USER, PASSWORD);
		databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
		databaseTester.setDataSet(dataSet);
		databaseTester.onSetup();
	}

	@Test
	public void findsAndReadsExistingPersonByFirstName() throws Exception {
		PersonRepository repository = new PersonRepository(dataConnection());
		Person charlie = repository.findPersonByFirstName("Charlie");
		repository.closeConnection();
		assertEquals("Charlie", charlie.getName());
	}

	@Test
	public void findsAndReadsExistingPersonByLastName() throws Exception {
		PersonRepository repository = new PersonRepository(dataConnection());
		Person charlie = repository.findPersonByLastName("Foo");
		repository.closeConnection();
		assertEquals("Foo", charlie.getLastName());
	}

	@Test
	public void findsAndReadsExistingPersonByAge() throws Exception {
		PersonRepository repository = new PersonRepository(dataConnection());
		Person charlie = repository.findPersonByAge(42);
		repository.closeConnection();
		assertEquals(42, charlie.getAge());
	}

	@Test
	public void returnsNullWhenPersonCannotBeFound() throws Exception {
		PersonRepository repository = new PersonRepository(dataConnection());
		Person charlie = repository.findPersonByFirstName("iDoNotExist");
		repository.closeConnection();
		assertEquals(null, charlie);
	}

	@Test
	public void insertNewPerson() throws Exception {
		PersonRepository repository = new PersonRepository(dataConnection());
		assertEquals(true, repository.insertPerson("Marta", "Walensa", 24));

		Person newPerson = repository.findPersonByFirstName("Marta");
		repository.closeConnection();

		assertEquals("Marta", newPerson.getName());
	}

	@Test
	public void updatePerson() throws Exception {
		PersonRepository repository = new PersonRepository(dataConnection());
		Person charlie = repository.findPersonByFirstName("Charlie");
		charlie.setName("Tomas");
		repository.updatePerson(charlie);

		Person charlieNew1 = repository.findPersonByFirstName("Charlie");
		Person charlieNew2 = repository.findPersonByFirstName("Tomas");

		repository.closeConnection();

		assertEquals(null, charlieNew1);
		assertEquals("Tomas", charlieNew2.getName());
	}

	@Test
	public void deletePerson() throws Exception {
		PersonRepository repository = new PersonRepository(dataConnection());
		Person charlie = repository.findPersonByFirstName("Charlie");
		repository.deletePerson(charlie);

		Person charlieNew1 = repository.findPersonByFirstName("Charlie");

		repository.closeConnection();

		assertEquals(null, charlieNew1);
	}

	@Test(expected = NullPointerException.class)
	public void findsWithoutConnection() throws Exception {
		PersonRepository repository = new PersonRepository((Connection) null);
		Person charlie = repository.findPersonByAge(42);
		repository.closeConnection();
		assertEquals(42, charlie.getAge());
	}

	protected Connection dataConnection() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		JdbcDataSource dataSource = new JdbcDataSource();
		dataSource.setURL(JDBC_URL);
		dataSource.setUser(USER);
		dataSource.setPassword(PASSWORD);
		return dataSource.getConnection();
	}

}
