package tw.org.iii.classroom03;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPReciver {

	public static void main(String[] args) {
		// TODO 自動產生的方法 Stub
		
		//-----------------------------接收封包(字串)------------------------------------	
//		try {
//			ServerSocket server = new ServerSocket(7777); // 作交握動作
//			// 物件實體
//			
//			System.out.println("before");
//			//TODO 10509041303聽一下
//			Socket socket = server.accept(); // 回應對方 三方交握    傳回socket  10509041303聽一下
//			InputStream oin = socket.getInputStream();
//			// 無法直接建構物件實體  在方法中告訴你 這是一個 inputStream 可能透過子類別去實作的  13:20
//			
//			InputStreamReader irs = new InputStreamReader(oin);
//			BufferedReader reader = new BufferedReader(irs);
//				
//			int c;
//			StringBuffer sb = new StringBuffer();// 10509041312聽一下
//			//while( (c = oin.read()) != -1 )
//			while( (c = reader.read()) != -1 )
//			{
//				sb.append((char)c);
//			}
//			InetAddress urip =  socket.getInetAddress();
//			
//			// 抽象類別 也可有物件實體  只是看怎麼實作出來  但沒辦法用 new的就是了
//			// 如果要傳文字資料 最好用 Reader 和 Writer較佳
//			
//			System.out.println("after");
//			server.close();
//			System.out.println("接收成功");
//			
//			
//			System.out.println(urip.getHostAddress()+":"+ sb); // 印出 封包的ip 和封包的內容
//			
//		} catch (IOException e) {
//			// TODO 自動產生的 catch 區塊
//			//e.printStackTrace();
//		}
		
		
		//-----------------------------接收封包(檔案)------------------------------------	
		// 只要不是傳字串的都是 傳binary ?
		
		try {
			ServerSocket server = new ServerSocket(6666); // 作交握動作

			Socket socket = server.accept(); // 回應對方 三方交握    傳回socket  10509041303聽一下
			BufferedInputStream bin = new BufferedInputStream(socket.getInputStream());
			
			// 開始把資料灌進來  一個byte 一個byte的讀進來  放在變數(記憶體)中
			
			BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream("upload/brad.jpg"));
			int b;
			while( (b = bin.read()) != -1 )
			{
				bout.write(b);
			}
			
			bout.flush();
			bin.close();
			server.close();
			System.out.println("Reciver OK !!");
			
		} catch (IOException e) {
			// TODO 自動產生的 catch 區塊
			//e.printStackTrace();
			System.out.println("Server exception:"+e.toString());
		}
		
	} // main

}
