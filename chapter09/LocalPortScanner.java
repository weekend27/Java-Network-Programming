import java.io.IOException;
import java.net.ServerSocket;

public class LocalPortScanner {

	@SuppressWarnings({ "unused", "resource" })
	public static void main(String[] args) {
		
		for (int port = 1; port <= 65535; port++) {
			try {
				// 如果这个端口已经有服务器在运行，则失败，进入catch块
				ServerSocket server = new ServerSocket(port);
			} catch (IOException ex) {
				System.out.println(ex.getMessage());
				System.out.println("There is a server on port " + port + "."); 
			}
		}

	}

}
