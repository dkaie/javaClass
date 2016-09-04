package tw.org.iii.classroom03;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {

	public static void main(String[] args) {
		// TODO 自動產生的方法 Stub
		
		//-------------------------傳送封包(字串)--------------------------------
//		try
//		{
//			//Socket socket = new Socket(InetAddress.getByName("10.2.24.106"),7777);
//			Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),7777); // 送封包到自己的電腦
//			// 電腦測不到127.0.0.1  核心驅動 或 服務有問題  沒有TCP的服務
//			// tcp封包 送出  要求 port跟我講話
//			// 寫回圈 port改放變數  可以掃描port  看 哪個會回 哪個不回   UNIX可用nmap只令去掃  用這個程式掃很慢 因為要掃 65536個
//			// 如果我連過去 他願意聽  才有跟我講話的機會
//			
//			OutputStream out =  socket.getOutputStream();
//			// 的到一個輸出串流
//			
//			out.write("hello 上課中".getBytes());
//			
//			out.flush();
//			out.close();
//			socket.close();
//		}
//		catch(IOException e)
//		{
//			// 拋出例外 表示port沒人 不跟你講話
//		}

		
//		//-----------------------------傳送封包(檔案)------------------------------------		
//		// 1. read from local filesystem
//		// HDD讀取的速度 和網路傳送的速度不同  通常HDD較快  所以資料會塞車在 交流道(socket?)那邊  
//		//long start = System.currentTimeMillis();
//		try {
//			Socket client = new Socket(InetAddress("127.0.0.1"),6666); // 取得三方交握 
//			//Socket client = new Socket(InetAddress("10.2.24.106"),6666); // 取得三方交握  
//
//			// 如果沒發生例外
//			// 從socket取得輸出串流
//			OutputStream out = client.getOutputStream();
//			BufferedOutputStream bout = new BufferedOutputStream(out); // 可以把上一列寫到這個參數裡面
//			// 把輸入串流接進來?
//			
//			BufferedInputStream bin = new BufferedInputStream(new FileInputStream("dir1/coffee.jpg"));
//			//讀圖片檔到 buffer中 ?
//			
//			int b;
//			while( (b = bin.read()) != -1 )
//			{	// b在記憶體中 剛從硬碟送來的資料
//				bout.write(b); // 讀進來 1 byte的資料 就送一個出去
//			}	
//			bin.close();
//			bout.flush();
//			bout.close();
//			client.close();
//			System.out.println("send finish !!");
//		} catch (Exception e) {
//			// TODO 自動產生的 catch 區塊
//			//e.printStackTrace();
//			System.out.println("Client exception:"+e.toString());
//		}
//		//System.out.println(System.currentTimeMillis() - start);
		
		
		//-----------------------------22222 傳送封包(檔案)------------------------------------		
		// 1. read from local filesystem
		// HDD讀取的速度 和網路傳送的速度不同  通常HDD較快  所以資料會塞車在 交流道(socket?)那邊  
		//long start = System.currentTimeMillis();
		try {
			File sendFile = new File("dir1/coffee.jpg");
			byte[] sendBuf = new byte[(int)sendFile.length()]; // 資料一次全部塞入陣列
			
			// 將那一大筆資料送出
			BufferedInputStream bin = new BufferedInputStream(new FileInputStream(sendFile));
			//讀圖片檔到 buffer中 ?
			
			bin.read(sendBuf);
			bin.close();
			
			// 2. send by TCP
			
			Socket client = new Socket(java.net.InetAddress.getByName("127.0.0.1"),6666);
			
			BufferedOutputStream bout = new BufferedOutputStream(client.getOutputStream());
			bout.write(sendBuf); // 下達 送出 指令
			bout.flush();
			bout.close();
			client.close();
			
			System.out.println("send finish !!");
		} catch (Exception e) {
			// TODO 自動產生的 catch 區塊
			//e.printStackTrace();
			System.out.println("Client exception:"+e.toString());
		}
		//long nowtime = System.currentTimeMillis() - start;
		
		
		
		
	}//main

	private static String InetAddress(String string) {
		// TODO 自動產生的方法 Stub
		return null;
	}

}
