package ug.lab.project2;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ug.lab.project2.ConnectionStatus;
import ug.lab.project2.MalformedRecipientException;
import ug.lab.project2.MessageService;
import ug.lab.project2.SendingStatus;

public class MockitoTest {

	@Mock
	private MessageService mockService;
	private Messenger msg;
	
	private final String VALID_SERVER = "inf.ug.edu.pl";
	private final String INVALID_SERVER = "inf.ug.edu.eu";
	private final String INVALID_SERVER2 = "xxx";

	private final String VALID_MESSAGE = "some message";
	private final String INVALID_MESSAGE = "ab";
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		msg = new Messenger(mockService);
	}

	@After
	public void tearDown() throws Exception {
		mockService = null;
		msg = null;
	}

	@Test
	public void checkConnectionValidServer() {
		when(mockService.checkConnection(VALID_SERVER)).thenReturn(ConnectionStatus.SUCCESS);
		int result = msg.testConnection(VALID_SERVER);
		assertEquals(0, result);
		verify(mockService).checkConnection(VALID_SERVER);
	}
	
	@Test
	public void checkFailureConnectionValidServer() {
		when(mockService.checkConnection(VALID_SERVER)).thenReturn(ConnectionStatus.FAILURE);
		int result = msg.testConnection(VALID_SERVER);
		assertEquals(1, result);
		verify(mockService).checkConnection(VALID_SERVER);
	}

	@Test
	public void checkConnectionInvalidServer() {
		when(mockService.checkConnection(INVALID_SERVER)).thenReturn(ConnectionStatus.FAILURE);
		int result = msg.testConnection(INVALID_SERVER);
		assertEquals(1, result);
		verify(mockService).checkConnection(INVALID_SERVER);
	}
	
	@Test
	public void checkConnectionNoServer() {
		when(mockService.checkConnection(null)).thenReturn(ConnectionStatus.FAILURE);
		int result = msg.testConnection(null);
		assertEquals(1, result);
		verify(mockService).checkConnection(null);
	}
	
	@Test
	public void sendValidServerAndValidMessage() throws MalformedRecipientException {
		when(mockService.send(VALID_SERVER, VALID_MESSAGE)).thenReturn(SendingStatus.SENT);
		int result = msg.sendMessage(VALID_SERVER, VALID_MESSAGE);
		assertEquals(0, result);
		verify(mockService).send(VALID_SERVER, VALID_MESSAGE);
	}
	
	@Test
	public void sendErrorValidServerAndValidMessage() throws MalformedRecipientException {
		when(mockService.send(VALID_SERVER, VALID_MESSAGE)).thenReturn(SendingStatus.SENDING_ERROR);
		int result = msg.sendMessage(VALID_SERVER, VALID_MESSAGE);
		assertEquals(1, result);
		verify(mockService).send(VALID_SERVER, VALID_MESSAGE);
	}

	@Test
	public void sendInvalidServerAndValidMessage() throws MalformedRecipientException {
		when(mockService.send(INVALID_SERVER2, VALID_MESSAGE)).thenThrow(new MalformedRecipientException());
		int result = msg.sendMessage(INVALID_SERVER2, VALID_MESSAGE);
		assertEquals(2, result);
		verify(mockService).send(INVALID_SERVER2, VALID_MESSAGE);
	}

	@Test
	public void sendValidServerAndInvalidMessage() throws MalformedRecipientException {
		when(mockService.send(VALID_SERVER, INVALID_MESSAGE)).thenThrow(new MalformedRecipientException());
		int result = msg.sendMessage(VALID_SERVER, INVALID_MESSAGE);
		assertEquals(2, result);
		verify(mockService).send(VALID_SERVER, INVALID_MESSAGE);
	}
	
	@Test
	public void sendNoServerAndValidMessage() throws MalformedRecipientException {
		when(mockService.send(null, VALID_MESSAGE)).thenThrow(new MalformedRecipientException());
		int result = msg.sendMessage(null, VALID_MESSAGE);
		assertEquals(2, result);
		verify(mockService).send(null, VALID_MESSAGE);
	}
	
	@Test
	public void sendValidServerAndNoMessage() throws MalformedRecipientException {
		when(mockService.send(VALID_SERVER, null)).thenThrow(new MalformedRecipientException());
		int result = msg.sendMessage(VALID_SERVER, null);
		assertEquals(2, result);
		verify(mockService).send(VALID_SERVER, null);
	}
}
