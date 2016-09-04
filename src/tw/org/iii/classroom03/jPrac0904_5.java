package tw.org.iii.classroom03;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;



public class jPrac0904_5 {

	public static void main(String[] args) {
		// TODO 自動產生的方法 Stub
		
		// ======= http 教學 ================
		
		// URL -->   http://主機名稱或ip:埠號/資源
		//         要進行一個對話  跟  主機名稱 對話  
		
		// http port預設為 80
		
		try {
			//URL url = new URL("http://www.iii.org.tw");
			//URL url = new URL("http://www.iii.org.tw/assets/images/information-news/image005.jpg");
			URL url = new URL("http://www.pdfmyurl.com/?url=http://tw.yahoo.com");
			HttpURLConnection conn = (HttpURLConnection)url.openConnection(); // 骨子裡是進行 Http 所以可以把它轉型回http
			// 它可以這樣轉型  但目前不是這個型別 
			// 如果出現class cast 代表 類別轉型失敗  去看看 有沒有 import成功
			// 寫 安卓 的程式碼  安卓官方也是建議用 這個類別 URLConnection
			
			conn.connect();
			// 以上三列處理 三方交握
			
			// 處理串流  把資料灌進來
			//-------------------測試 抓 資策會官網的頁面原始碼-----------------------
//			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//			String line;
//			while( (line = reader.readLine()) != null )
//			{
//				System.out.println(line);
//			}
//			
//			reader.close();
			
			//------------------測試 抓 資策會官網 網頁上的一張圖片------------------------
			InputStream in = conn.getInputStream(); // 因為不是文字資料 所以用這個
			// 如果是文字資料 用 reader writer 較適當
			//FileOutputStream fout = new FileOutputStream("upload/brad2.jpg");
			FileOutputStream fout = new FileOutputStream("upload/brad3.pdf");
			int b;
			while( (b = in.read()) != -1 )
			{
				fout.write(b);
			}
			
			fout.flush();
			fout.close();
			in.close();
			System.out.println("接收完成");
		} catch (Exception e) {
			// TODO 自動產生的 catch 區塊
			//e.printStackTrace();
			System.out.println(e.toString());
		}
	}// main

}
