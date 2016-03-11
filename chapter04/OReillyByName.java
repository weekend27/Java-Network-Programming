import java.net.InetAddress;
import java.net.UnknownHostException;

public class OReillyByName {

	public static void main(String[] args) {
		try {
			// 显示www.oreilly.com的地址
			InetAddress address = InetAddress.getByName("www.oreilly.com");
			System.out.println(address);		// 返回结果： www.oreilly.com/104.118.136.220
			
			// 获取一个主机的所有地址
			InetAddress[] addresses = InetAddress.getAllByName("www.oreilly.com");
			for (InetAddress addr : addresses) {
				System.out.println(addr);
			}
			
		} catch (UnknownHostException e) {
			System.out.println("Could not find www.oreilly.com");
		}
	}

}
