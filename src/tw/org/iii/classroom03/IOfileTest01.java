package tw.org.iii.classroom03;

import java.io.File;
import java.io.IOException;

//在為軟上面 : 副檔名只是用來開啟檔案的關聯
//能不能把檔案砍掉 要看 這個檔案 所在的目錄 有沒有可寫 可執行 的權限 
// 在微軟上感覺不到 因為 進到微軟時 都會給你最高權限

public class IOfileTest01 {

	public static void main(String[] args) {
		// TODO 自動產生的方法 Stub

		//java_io_File_practice();
		//java_io_File_practice02();
		//java_io_File_practice03();
		File[] roots = File.listRoots();
		for(File root :roots) // 左手邊是元素的型別
		{
			System.out.println(root.getAbsolutePath()); // 顯示有幾個根目錄 ?
		}
		
		
	} // main( )

	public static void java_io_File_practice03()
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
