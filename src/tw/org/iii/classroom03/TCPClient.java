package tw.org.iii.classroom03;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class TCPClient {

	public static void main(String[] args) {
		// TODO 自動產生的方法 Stub
		try
		{
			Socket socket = new Socket(InetAddress.getByName("10.2.24.106"),7777);
			//Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),7777); // 送封包到自己的電腦
			// 電腦測不到127.0.0.1  核心驅動 或 服務有問題  沒有TCP的服務
			// tcp封包 送出  要求 port跟我講話
			// 寫回圈 port改放變數  可以掃描port  看 哪個會回 哪個不回   UNIX可用nmap只令去掃  用這個程式掃很慢 因為要掃 65536個
			// 如果我連過去 他願意聽  才有跟我講話的機會
			socket.close();
		}
		catch(IOException e)
		{
			// 拋出例外 表示port沒人 不跟你講話
		}
	}

}
