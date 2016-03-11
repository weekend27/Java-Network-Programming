import java.net.InetAddress;
import java.net.UnknownHostException;

public class MyAddress {
	
	public static void main(String[] args) {
		try {
			InetAddress address = InetAddress.getLocalHost();
			System.out.println(address);		// 返回：ztb3/192.168.12.24
		} catch (UnknownHostException e) {
			System.out.println("Could not find this computer's address.");
		}
	}
	
}
