package tw.org.iii.classroom03;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.channels.DatagramChannel;

public class jPrac0904_2 {
	
	// 這個是在作 UDP ?
	// sender 封包
	public static void main(String[] args) {
		// TODO 自動產生的方法 Stub
		
		
		int i=0;
		
		while(true)
		{ 
		
			String data = "hello i'm 134";
			byte[] sendData = data.getBytes();
			try
			{
				DatagramSocket socket = new DatagramSocket();
				// 使用不需指定 ip port的方法
			
				DatagramPacket packet = 
						new DatagramPacket(sendData,
								sendData.length,
								InetAddress.getByName("10.2.24.106"),
								8888);
				// 10.2.24.255  255會對整個網域廣播
				
				// port 小於 1024的不要用  通常都是大家 所 well know 眾所皆知 大家認定的
				// 80網業伺服器  53 dns  25 smtp  23 BBS  110 OUTLOOK 22 ssh  20 21FTP   443網路芳鄰
				
				socket.send(packet); // 送出封包
				socket.close();
				System.out.println("傳送成功");
			}
			catch(SocketException e)
			{
				
			}
			catch(UnknownHostException e)
			{
				
			} catch (IOException e) {
				// TODO 自動產生的 catch 區塊
				//e.printStackTrace();
			}
		} // while

	}// main


	
	
}
