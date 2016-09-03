package tw.org.iii.classroom03;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

//在為軟上面 : 副檔名只是用來開啟檔案的關聯
//能不能把檔案砍掉 要看 這個檔案 所在的目錄 有沒有可寫 可執行 的權限 
// 在微軟上感覺不到 因為 進到微軟時 都會給你最高權限

public class IOfileTest01 {

	public static void main(String[] args) {
		// TODO 自動產生的方法 Stub

		//java_io_File_practice();
		//java_io_File_practice02();
		//mkdir_func_practice();
		//listRoots_func_practice();
		//FileInputStream_class_practice();
		//FileReader_class_practice();
		FileOutputStream_class_practice();
		
	} // main( )

	public static void FileOutputStream_class_practice()
	{
		File f1 = new File("dir1/Brad03.txt");
		try {
			//FileOutputStream fout = new FileOutputStream(f1);
			// Brad03.txt原本是沒建立的檔案,在 new FileOutputStream() 到 obj.close()之間
			// 電腦自己幫你建檔
			// 指標 指到 檔案最開始的地方把原檔清掉 資料從指標的地方寫下去
			
			FileOutputStream fout = new FileOutputStream(f1,true);
			// 指標 指到 檔案的尾端  不會把原檔清掉 資料從指標的地方寫下去
			
			fout.write("Hello,Brad02\n".getBytes()); // 把物件轉成byte陣列 讓它傳送出去
			
			// 微軟上 最好用 \r\n做換列  UNIX用 \n即可換列
			//fout.append(); // 根本沒有這種方法可呼叫 考java認證考試  考題會出現這玩意來騙考生
			
			fout.flush(); // 沖乾淨  Buffer 或 Stream 內的資料 到 file內
			// 做本機存取時 沒 加 flush沒關係  但做 網路資料傳例時 會出現 少資料的情況 因為 沒沖乾淨 到 file內
			fout.close();
			System.out.println("沒有出現例外"); //
		} catch (Exception e) {
			// TODO 自動產生的 catch 區塊
			//e.printStackTrace();
		}
	}
	public static void FileReader_class_practice()
	{	// FileReader  專門用來讀字元  單純讀文字檔 
		// Read class 的源頭 是 inputStream
		File f1 = new File("dir1/Brad01.txt");
		try {
			FileReader reader = new FileReader(f1);
			int c;
			while( (c = reader.read()) != -1 )
			{
				System.out.print((char)c);
			}
			reader.close();
		} catch (Exception e) {
			// TODO 自動產生的 catch 區塊
			//e.printStackTrace();
		}
	}
	
	// ftp傳檔時會問你用 ASCII傳(FileReader 較快) 或是 binary傳(FileInputStream)
	
	public static void FileInputStream_class_practice()
	{	// FileInputStream 用在處理 各式檔案,用他去讀文字檔要另外寫邏輯去處理文字檔
		File f1 = new File("dir1/Brad01.txt");
		long len = f1.length();
		try{
			FileInputStream fin = new FileInputStream(f1);
			
//			int c1 = fin.read();	// read()函數   如果 讀到Stream結尾 會回傳 -1
//			System.out.println(c1); // 這是一個byte的資料 會印出ASCII碼
//			System.out.println((char)c1); // 強制轉型
			
			//----------處理中文--------
//			int c ;
//			byte[] temp = new byte[3];
//			while( (c = fin.read()) != -1 )	// read()函數   如果 讀到Stream結尾 會回傳 -1
//			{
//				System.out.print((char)c);// 中文字占3個byte,但一次只讀一個byte所以中文字會讀出亂碼
			
			// TODO  這裡 弄清楚一下
//				System.out.print(new String(temp,0,c)); // 從0開始 到第c個
//				// Big5    2^16=65536 這個數量 小於 中文字的總數量
//				// UTF-8   2^24	
//			}
		
			//----------處理中文 和   其他各式檔案?--------
			int c ;
			byte[] temp = new byte[(int)len]; // 陣列的 index最大只有到int
			// int 的範圍 2^x=4億多 = 4GB 分正負號 2GB 所以不要開大於 2GB的 檔     大於2GB 要用迴圈分批讀
			fin.read(temp);
			System.out.println(new String(temp));
			
			fin.close();
			//System.out.println("沒有拋出例外"); // 前面有發生例外 就會直接跳到catch不會執行這列code
		}
		catch(FileNotFoundException fe){ System.out.println(fe.toString()); }
		catch(IOException fe)			{ System.out.println(fe.toString()); }
		
	}
	public static void listRoots_func_practice()
	{
		File[] roots = File.listRoots();
		for(File root :roots) // 左手邊是元素的型別
		{
			System.out.println(root.getAbsolutePath()); // 顯示有幾個根目錄 ?
		}
	}
	public static void mkdir_func_practice()
	{
//		File dir2 = new File("dir1/dir2");
//		if(!dir2.exists())
//		{
//			if(dir2.mkdir()) // 如果父目錄不存在 不幫你建立父目錄
//			{
//				System.out.println("dir2已建立");
//			}
//		}
		
		File dir2 = new File("dir1/dir3/dir4/dir5/dir6");
		if(!dir2.exists())
		{
			if(dir2.mkdirs()) // 如果父目錄不存在 幫你建立父目錄
			{
				System.out.println("dir6已建立");
			}
		}
	}
	public static void java_io_File_practice02()
	{
		//File f1 = new File(".");
		//System.out.println(f1.getAbsolutePath()); // 取得你現在的所在目錄
		// 兩點 走去 你現在目錄的上一層
		// 一點 走去 你現在所位在的目錄 (就是原地踏步的意思)
		
		//File f1 = new File("./dir1");
		//if(f1.exists())			System.out.println("f1有存在");
		
		// Windows可允許 檔案 目錄(資料夾) 主檔名 同名稱  但  UNIX不允許
		
//		File f1 = new File("dir1/Brad01.txt"); // 如果已知道 是用相對路徑 不key ./  也可以
//		if(f1.isDirectory())	System.out.println("f1是目錄");
//		if(f1.isFile())			System.out.println("f1是檔案");
		
		File f1 = new File("dir1/Brad02.txt");
		if(f1.isFile())
		{
			System.out.println("f1是檔案");
		}
		else
		{ 
			try {
				if(f1.createNewFile())
				{
					System.out.println("建檔成功");
				}
				else
				{	// 在讀寫過程中發生非預期的例外
					System.out.println("發生預期中的例外");
				}
			} catch (IOException e) {
				// TODO 自動產生的 catch 區塊
				//e.printStackTrace();
				System.out.println(e.toString());
			}
		}
	}
	public static void java_io_File_practice()
	{
//		System.out.println(File.pathSeparator);
//		System.out.println(File.pathSeparatorChar);
//		System.out.println(File.separator);
//		System.out.println(File.separatorChar);
		
		
		
		//java.io.File f1 = new java.io.File("c:\king"); // 這會編譯失敗
		java.io.File f1 = new java.io.File("c:\test"); // 這會編譯成功 但結果是錯的  因為 電腦會看成 字串 "c:" tab鍵 "est"
		File f2 = new File("c:\\king"); // 電腦看到單根斜線 就以為是跳脫字元, 用兩根斜線代表原本斜線的意思
		// File f2 = new File("c:/king"); // 把斜線轉到 跟 UNIX一樣使用正斜線    就可以不用打兩根反斜線
		// 大部分的作業系統 都是使用 正斜線 只是
		
		if( f1.exists() )
		{
			System.out.println("f1存在");
		}
		else
		{
			System.out.println("f1不存在");	
		}
	}
	
} // class
