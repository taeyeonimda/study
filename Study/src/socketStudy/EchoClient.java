package socketStudy;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class EchoClient {
	public static void main(String[] args) throws IOException{
		Socket socket = null;
		socket = new Socket(args[0],Integer.parseInt(args[1]));
		
		System.out.println(socket+":연결됨");
		
		OutputStream outputStream =socket.getOutputStream();
		InputStream inputStream =socket.getInputStream();
		
		byte[] buf  = new byte[1024];
		int count;
		
		while((count = System.in.read(buf)) != -1)
		{
			outputStream.write(buf, 0 ,count);
			count = inputStream.read(buf);
			System.out.write(buf,0,count);
		}
		outputStream.close();
		
		System.out.println(socket+":연결종료");
		socket.close();
	}
}
