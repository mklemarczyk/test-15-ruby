package ug.lab.project2;

public class Messenger {

	private MessageService ms;

	public Messenger(MessageService ms) {
		this.ms = ms;
	}

	public int testConnection(String server) {
		if(ms.checkConnection(server) == ConnectionStatus.SUCCESS)
			return 0;
		return 1;
	}

	public int sendMessage(String server, String message) {
		int result = -1;
		
		try{
			SendingStatus status = ms.send(server, message);
			
			switch(status){
			case SENT:
				result = 0;
				break;
			case SENDING_ERROR:
				result = 1;
				break;
			}
		}
		catch(MalformedRecipientException ex) {
			result = 2;
		}
		return result;
	}
}
