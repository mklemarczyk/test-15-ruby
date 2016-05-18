package ug.lab.proj160518;

import java.io.File;
import java.sql.*;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Before;
import org.junit.BeforeClass;

public class HsqlDatabaseTest extends H2DatabaseTest {

	public static final String JDBC_DRIVER = org.h2.Driver.class.getName();
	public static final String JDBC_URL = "jdbc:hsqldb:mem:test";
	public static final String USER = "sa";
	public static final String PASSWORD = "";

	@BeforeClass
	public static void createSchema() throws Exception {
		//RunScript.execute(JDBC_URL, USER, PASSWORD, "SQLScripts/scheme.sql", StandardCharsets.UTF_8, false);
		String jdbc_driver_string = "org.hsqldb.jdbcDriver";
		String database_url_string = "jdbc:hsqldb:mem:test";
		String userid = "sa";
		String pwd = "";
		Class.forName("org.hsqldb.jdbcDriver").newInstance();
		Connection conn = DriverManager.getConnection(database_url_string, userid, pwd);
		PreparedStatement stmt = conn.prepareStatement("CREATE TABLE PERSON ( id int identity primary key, firstName varchar, lastName varchar, age smallint);");
		stmt.executeUpdate();
	}

	@Before
	@Override
	public void importDataSet() throws Exception {
		IDataSet dataSet = readDataSet();
		cleanlyInsert(dataSet);
	}

	@Override
	protected IDataSet readDataSet() throws Exception {
		return new FlatXmlDataSet(new File("IDataSets/dataset.xml"));
	}

	@Override
	protected void cleanlyInsert(IDataSet dataSet) throws Exception {
		IDatabaseTester databaseTester = new JdbcDatabaseTester(JDBC_DRIVER, JDBC_URL, USER, PASSWORD);
		databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
		databaseTester.setDataSet(dataSet);
		databaseTester.onSetup();
	}

	@Override
	protected Connection dataConnection() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		String jdbc_driver_string = "org.hsqldb.jdbcDriver";
		String database_url_string = "jdbc:hsqldb:mem:test";
		String userid = "sa";
		String pwd = "";
		Class.forName(jdbc_driver_string).newInstance();
		return DriverManager.getConnection(database_url_string, userid, pwd);
	}

}
