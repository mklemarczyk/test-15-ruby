package ug.lab.project2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MessageAppTest {

	private MessageService mockService;
	private Messenger messenger;

	private final String VALID_SERVER = "inf.ug.edu.pl";
	private final String INVALID_SERVER = "inf.ug.edu.eu";
	private final String INVALID_SERVER2 = "xxx";

	private final String VALID_MESSAGE = "some message";
	private final String INVALID_MESSAGE = "ab";
	
	@Before
	public void setUp() throws Exception {
		mockService = new MessageServiceMock();
		messenger = new Messenger(mockService);
	}

	@After
	public void tearDown() throws Exception {
		mockService = null;
		messenger = null;
	}

	@Test
	public void checkConnectionValidServer() {
		int result = messenger.testConnection(VALID_SERVER);
		assertEquals(0, result);
	}
	
	@Test
	public void checkFailureConnectionValidServer() {
		int result = messenger.testConnection(INVALID_SERVER);
		assertEquals(1, result);
	}

	@Test
	public void checkConnectionInvalidServer() {
		int result = messenger.testConnection(INVALID_SERVER2);
		assertEquals(1, result);
	}
	
	@Test
	public void checkConnectionNoServer() {
		int result = messenger.testConnection(null);
		assertEquals(1, result);
	}
	
	@Test
	public void sendValidServerAndValidMessage() throws MalformedRecipientException {
		int result = messenger.sendMessage(VALID_SERVER, VALID_MESSAGE);
		assertEquals(0, result);
	}
	
	@Test
	public void sendErrorInvalidServerAndValidMessage() throws MalformedRecipientException {
		int result = messenger.sendMessage(INVALID_SERVER, VALID_MESSAGE);
		assertEquals(1, result);
	}

	@Test
	public void sendInvalidServerAndValidMessage() throws MalformedRecipientException {
		int result = messenger.sendMessage(INVALID_SERVER2, VALID_MESSAGE);
		assertEquals(2, result);
	}

	@Test
	public void sendValidServerAndInvalidMessage() throws MalformedRecipientException {
		int result = messenger.sendMessage(VALID_SERVER, INVALID_MESSAGE);
		assertEquals(2, result);
	}
	
	@Test
	public void sendNoServerAndValidMessage() throws MalformedRecipientException {
		int result = messenger.sendMessage(null, VALID_MESSAGE);
		assertEquals(2, result);
	}
	
	@Test
	public void sendValidServerAndNoMessage() throws MalformedRecipientException {
		int result = messenger.sendMessage(VALID_SERVER, null);
		assertEquals(2, result);
	}
}
