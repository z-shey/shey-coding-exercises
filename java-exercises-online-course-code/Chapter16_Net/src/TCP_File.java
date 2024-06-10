import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCP_File {
    @Test
    public void client() throws IOException {
        // 1. create socket
        InetAddress inetAddress = InetAddress.getByName("192.168.10.8");
        int port = 8869;
        Socket socket = new Socket(inetAddress, port);

        // 2. create files object and FileInputStream object
        File file = new File("01.jpg");
        FileInputStream fileInputStream = new FileInputStream(file);
        // 3. 输出流
        OutputStream os = socket.getOutputStream();
        byte[] buffer = new byte[1024];
        int len;
        while ((len = fileInputStream.read(buffer)) != -1) {
            os.write(buffer, 0, len);
        }
        // 4. close

        os.close();
        fileInputStream.close();
        socket.close();
    }

    @Test
    public void server() throws IOException {
        // 1. create ServerSocket
        int port = 8869;
        ServerSocket serverSocket = new ServerSocket(port);

        // 2. accept
        Socket socket = serverSocket.accept();
        // 3. 输入流
        InputStream is = socket.getInputStream();
        // 4. File实例 文件输出流
        File file = new File("copy.jpg");
        FileOutputStream fos = new FileOutputStream(file);

        // 5. 读写
        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1) {
            fos.write(buffer, 0, len);
        }
        System.out.println("OK");
        // 6. 关闭

        fos.close();
        is.close();
        socket.close();
        serverSocket.close();
    }
}
