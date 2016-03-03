import java.net.*;

public class SocketTest
{
    public static void printState(Socket socket)
    {
        System.out.println("isInputShutdown:" + socket.isInputShutdown());
        System.out.println("isOutputShutdown:" + socket.isOutputShutdown());
        System.out.println("isClosed:" + socket.isClosed());
        System.out.println("**********************************");
    }

    public static void main(String[] args) throws Exception
    {
        Socket socket = new Socket("www.baidu.com", 80);
        printState(socket);

        /*
        socket.shutdownInput();
        printState(socket);

        socket.shutdownOutput();
        printState(socket);
        */
        
        socket.close();
        printState(socket);
    }
}
