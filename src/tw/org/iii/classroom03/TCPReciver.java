package tw.org.iii.classroom03;

import java.io.IOException;
import java.net.ServerSocket;

public class TCPReciver {

	public static void main(String[] args) {
		// TODO 自動產生的方法 Stub
		try {
			ServerSocket server = new ServerSocket(7777); // 作交握動作
			System.out.println("before");
			server.accept();
			System.out.println("after");
			server.close();
			System.out.println("接收成功");
		} catch (IOException e) {
			// TODO 自動產生的 catch 區塊
			//e.printStackTrace();
		}
	}

}
