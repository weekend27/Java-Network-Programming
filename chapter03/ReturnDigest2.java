package network.chapter03;

import javax.xml.bind.DatatypeConverter;

public class ReturnDigest2{

	public static void main(String[] args) throws InterruptedException {
		ReturnDigest[] digests = new ReturnDigest[args.length];
		
		for (int i = 0; i < args.length; ++i) {
			digests[i] = new ReturnDigest(args[i]);
			digests[i].start();
		}
		Thread.sleep(100);
		for (int i = 0; i < args.length; ++i) {
			StringBuffer result = new StringBuffer(args[i]);
			result.append(": ");
			byte[] digest = digests[i].getDigest();
			result.append(DatatypeConverter.printHexBinary(digest));
			
			System.out.println(result);
		}
	}

}
