package servidor;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerSocketThread extends Thread {
	private final Socket socket;
	
	public ServerSocketThread (Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		//TODO
		super.run();
		try {
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			DataInputStream in = new DataInputStream(socket.getInputStream());
			Float tempC = in.readFloat(); 
			Float tempF = (float) (tempC * 1.8 + 32);
			out.writeFloat(tempF);
			out.flush();
			out.close();
			in.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
