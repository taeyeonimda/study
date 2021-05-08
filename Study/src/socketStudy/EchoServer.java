package socketStudy;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(Integer.parseInt(args[0]));
		System.out.println(serverSocket + ":서버 소켓 생성");

		while (true) {
			Socket socket = serverSocket.accept();

			InputStream inputStream = socket.getInputStream();
			OutputStream outputStream = socket.getOutputStream();
			byte[] buf = new byte[1024];
			int count;

			while ((count = inputStream.read(buf)) != -1) {
				outputStream.write(buf, 0, count);
				System.out.write(buf, 0, count);
			}
			outputStream.close();
			serverSocket.close();
			
			System.out.println(socket +":연결종료");
		}
	}
}
