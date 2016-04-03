package ug.lab.project2;

import ug.lab.project2.ConnectionStatus;
import ug.lab.project2.MalformedRecipientException;
import ug.lab.project2.MessageService;
import ug.lab.project2.SendingStatus;

public class MessageServiceMock implements MessageService {

	private final String VALID_SERVER = "inf.ug.edu.pl";
	private final String INVALID_SERVER = "inf.ug.edu.eu";
	private final String INVALID_SERVER2 = "xxx";

	private final String VALID_MESSAGE = "some message";
	private final String INVALID_MESSAGE = "ab";

	@Override
	public ConnectionStatus checkConnection(String server) {
		if(server == VALID_SERVER)
			return ConnectionStatus.SUCCESS;
		if(server == INVALID_SERVER2)
			return ConnectionStatus.FAILURE;
		return ConnectionStatus.FAILURE;
	}

	@Override
	public SendingStatus send(String server, String message) throws MalformedRecipientException {
		if(server == VALID_SERVER && message == VALID_MESSAGE)
			return SendingStatus.SENT;
		if(server == INVALID_SERVER && message == VALID_MESSAGE)
			return SendingStatus.SENDING_ERROR;
		if(server == INVALID_SERVER2 || message == INVALID_MESSAGE)
			throw new MalformedRecipientException();
		throw new MalformedRecipientException();
	}

}
