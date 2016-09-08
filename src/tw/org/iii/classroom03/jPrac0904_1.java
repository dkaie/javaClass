package tw.org.iii.classroom03;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class jPrac0904_1 {

	public static void main(String[] args) {
		// 
		try {
			//InetAddress ip = InetAddress.getByName("www.microsoft.com");// 會得到 dns回報給你的 IP
			//InetAddress ip = InetAddress.getByName("10.2.24.3");// 這是資策會的內部IP 會收到 10.2.24.3
			//InetAddress ip = InetAddress.getByName("8.8.8.8");// 這是google架的dns 會收到 8.8.8.8
			InetAddress[] ips = InetAddress.getAllByName("www.hinet.com");
			// 把可能的IP一次全撈回來
			for(InetAddress ip : ips)
			{	System.out.println(ip.getHostAddress());
			}
			// 字串內打的是 IP 不要加 http 那是URL 裡面不要打 URL
		//	System.out.println(ip.getHostAddress()); // 找主機位址
			// 會得到 dns回報給你的 IP
			
			//任何一組公眾IP只會在一個網路設備上使用
			// 一個網路設備上 可以有多個IP位址
			// dns分流  因為這站 太大站 很多人來問 IP 所以負責網路的dns 會分別回報不同的主機 給人  已達到分流
			// 輪詢
			
			// 如果是記錄log 的程式碼  try catch會做的比較細
			// 可用log記錄使用者的操作資訊 以方便日後的除錯 否則使用者不太可能會詳細告訴你 他是如何操作你寫的程式
			
		} catch (UnknownHostException e) {
			// 
			//e.printStackTrace();
			System.out.println("找不到主機位址");
			// 看IP的合理性 下手 去產生 例外   只檢查 0~255   不合理 就拋例外
		}
	}//main

}// class
