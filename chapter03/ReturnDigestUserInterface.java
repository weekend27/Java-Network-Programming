package network.chapter03;

import javax.xml.bind.DatatypeConverter;

public class ReturnDigestUserInterface {

	public static void main(String[] args) {
		for (String filename : args) {
			ReturnDigest dr = new ReturnDigest(filename);
			dr.start();
			
			StringBuilder result = new StringBuilder(filename);
			result.append(": ");
			byte[] digest = dr.getDigest();
			result.append(DatatypeConverter.printHexBinary(digest));   // nullpointer exception
			System.out.println(result);
		}
	}

}
