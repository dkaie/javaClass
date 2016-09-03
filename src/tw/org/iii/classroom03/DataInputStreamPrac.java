package tw.org.iii.classroom03;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class DataInputStreamPrac {

	// 上午教的檔案 I/O 都是 做 byte型態  這裡 有 各種數值型態
	
	public static void main(String[] args) {
		// TODO 自動產生的方法 Stub
		try {
			DataInputStream din = new DataInputStream(new FileInputStream("dir1/data.dat"));
			// 老師說副檔名叫啥不重要
			
			int data1 = din.readInt();
			boolean data2 = din.readBoolean();
			double data3 = din.readDouble();
			
			// 資料的輸出入 讀出入 好像要照順序  以下這樣寫可執行 但會讀亂碼
			//boolean data3 = din.readBoolean();
			//double data2 = din.readDouble();
			
			din.close();
			System.out.println(data1);
			System.out.println(data2);
			System.out.println(data3);
		} catch (Exception e) {

		}
	}// main

}//class
