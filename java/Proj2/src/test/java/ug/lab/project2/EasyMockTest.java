package ug.lab.project2;

import static org.junit.Assert.*;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ug.lab.project2.ConnectionStatus;
import ug.lab.project2.MalformedRecipientException;
import ug.lab.project2.MessageService;
import ug.lab.project2.SendingStatus;

public class EasyMockTest {

	private MessageService mockService;
	private Messenger msg;
	
	private final String VALID_SERVER = "inf.ug.edu.pl";
	private final String INVALID_SERVER = "inf.ug.edu.eu";
	private final String INVALID_SERVER2 = "xxx";

	private final String VALID_MESSAGE = "some message";
	private final String INVALID_MESSAGE = "ab";
	
	@Before
	public void setUp() throws Exception {
		mockService = EasyMock.createMock(MessageService.class);
		msg = new Messenger(mockService);
	}

	@After
	public void tearDown() throws Exception {
		mockService = null;
		msg = null;
	}

	@Test
	public void checkConnectionValidServer() {
		EasyMock.expect(mockService.checkConnection(VALID_SERVER)).andReturn(ConnectionStatus.SUCCESS);
		EasyMock.replay(mockService);
		int result = msg.testConnection(VALID_SERVER);
		assertEquals(0, result);
		EasyMock.verify(mockService);
	}
	
	@Test
	public void checkFailureConnectionValidServer() {
		EasyMock.expect(mockService.checkConnection(VALID_SERVER)).andReturn(ConnectionStatus.FAILURE);
		EasyMock.replay(mockService);
		int result = msg.testConnection(VALID_SERVER);
		assertEquals(1, result);
		EasyMock.verify(mockService);
	}

	@Test
	public void checkConnectionInvalidServer() {
		EasyMock.expect(mockService.checkConnection(INVALID_SERVER)).andReturn(ConnectionStatus.FAILURE);
		EasyMock.replay(mockService);
		int result = msg.testConnection(INVALID_SERVER);
		assertEquals(1, result);
		EasyMock.verify(mockService);
	}
	
	@Test
	public void checkConnectionNoServer() {
		EasyMock.expect(mockService.checkConnection(null)).andReturn(ConnectionStatus.FAILURE);
		EasyMock.replay(mockService);
		int result = msg.testConnection(null);
		assertEquals(1, result);
		EasyMock.verify(mockService);
	}
	
	@Test
	public void sendValidServerAndValidMessage() throws MalformedRecipientException {
		EasyMock.expect(mockService.send(VALID_SERVER, VALID_MESSAGE)).andReturn(SendingStatus.SENT);
		EasyMock.replay(mockService);
		int result = msg.sendMessage(VALID_SERVER, VALID_MESSAGE);
		assertEquals(0, result);
		EasyMock.verify(mockService);
	}
	
	@Test
	public void sendErrorValidServerAndValidMessage() throws MalformedRecipientException {
		EasyMock.expect(mockService.send(VALID_SERVER, VALID_MESSAGE)).andReturn(SendingStatus.SENDING_ERROR);
		EasyMock.replay(mockService);
		int result = msg.sendMessage(VALID_SERVER, VALID_MESSAGE);
		assertEquals(1, result);
		EasyMock.verify(mockService);
	}

	@Test
	public void sendInvalidServerAndValidMessage() throws MalformedRecipientException {
		EasyMock.expect(mockService.send(INVALID_SERVER2, VALID_MESSAGE)).andThrow(new MalformedRecipientException());
		EasyMock.replay(mockService);
		int result = msg.sendMessage(INVALID_SERVER2, VALID_MESSAGE);
		assertEquals(2, result);
		EasyMock.verify(mockService);
	}

	@Test
	public void sendValidServerAndInvalidMessage() throws MalformedRecipientException {
		EasyMock.expect(mockService.send(VALID_SERVER, INVALID_MESSAGE)).andThrow(new MalformedRecipientException());
		EasyMock.replay(mockService);
		int result = msg.sendMessage(VALID_SERVER, INVALID_MESSAGE);
		assertEquals(2, result);
		EasyMock.verify(mockService);
	}
	
	@Test
	public void sendNoServerAndValidMessage() throws MalformedRecipientException {
		EasyMock.expect(mockService.send(null, VALID_MESSAGE)).andThrow(new MalformedRecipientException());
		EasyMock.replay(mockService);
		int result = msg.sendMessage(null, VALID_MESSAGE);
		assertEquals(2, result);
		EasyMock.verify(mockService);
	}
	
	@Test
	public void sendValidServerAndNoMessage() throws MalformedRecipientException {
		EasyMock.expect(mockService.send(VALID_SERVER, null)).andThrow(new MalformedRecipientException());
		EasyMock.replay(mockService);
		int result = msg.sendMessage(VALID_SERVER, null);
		assertEquals(2, result);
		EasyMock.verify(mockService);
	}
}
