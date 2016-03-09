import java.io.IOException;
import java.net.ServerSocket;

public class RamdomPort {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(0);
			System.out.println("There is a server running on port " + server.getLocalPort());
			System.out.println(server.toString());
			server.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
