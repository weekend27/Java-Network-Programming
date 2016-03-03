import java.net.*;
import java.text.*;
import java.util.Date;
import java.util.TimeZone;
import java.util.Calendar;
import java.io.*;

public class Time {

  private static final String HOSTNAME = "time.nist.gov";

  public static void main(String[] args) throws IOException, ParseException {
    Date d = Time.getDateFromNetwork();
    System.out.println("It is " + d);
  }

  public static Date getDateFromNetwork() throws IOException, ParseException {
    // 时间协议设置时间起点为1900年， Java Date类起始于1970年。利用这个数字在它们之间进行转换

    // long differenceBetweenEpochs = 2208988800L;

    // 上述数字可以通过下面的代码进行计算

    TimeZone gmt = TimeZone.getTimeZone("GMT");
    Calendar epoch1900 = Calendar.getInstance(gmt);
    epoch1900.set(1900, 01, 01, 00, 00, 00);
    long epoch1900ms = epoch1900.getTime().getTime();
    Calendar epoch1970 = Calendar.getInstance(gmt);
    epoch1970.set(1970, 01, 01, 00, 00, 00);
    long epoch1970ms = epoch1970.getTime().getTime();

    long differenceInMS = epoch1970ms - epoch1900ms;
    long differenceBetweenEpochs = differenceInMS / 1000;


    Socket socket = null;
    try {
      socket = new Socket(HOSTNAME, 37);
      socket.setSoTimeout(15000);

      InputStream raw = socket.getInputStream();

      long secondsSince1900 = 0;
      for (int i = 0; i < 4; i++) {
        secondsSince1900 = (secondsSince1900 << 8) | raw.read();
      }

      long secondsSince1970 = secondsSince1900 - differenceBetweenEpochs;
      long msSince1970 = secondsSince1970 * 1000;
      Date time = new Date(msSince1970);

      return time;
    } finally {
      try {
        if (socket != null) {
          socket.close();
        }
      } catch (IOException ex) {}
    }

  }

}
