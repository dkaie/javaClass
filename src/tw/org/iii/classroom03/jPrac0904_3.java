package tw.org.iii.classroom03;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class jPrac0904_3 {

	// 這個是在作 UDP ?
	// 接收 封包
	public static void main(String[] args) {
		// TODO 自動產生的方法 Stub
		
		
		//while(true)
		{	// 迴圈是老師設為一直接收同學的封包
			
			byte[] buf = new byte[1024]; // 自己游封包大小決定要配多大震列 
			
			try {
				DatagramSocket socket = new DatagramSocket(8888);
				DatagramPacket packet = new DatagramPacket(buf, buf.length);
				
				System.out.println("before");
					
				socket.receive(packet);
				
				System.out.println("after");
				socket.close();
				InetAddress urip = 	packet.getAddress();
				byte[] data = packet.getData(); // 用封包取得相關資料
				//  收多少 封包 長度
				int len = packet.getLength();
				
				System.out.println("接收成功 +" + urip.getHostAddress()+":"+new String(data,0,len));
			} catch (Exception e) {
				// TODO 自動產生的 catch 區塊
				//e.printStackTrace();
				System.out.println(e.toString());
			}
		
		} // while
	}// main

}
