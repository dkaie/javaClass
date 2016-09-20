package tw.org.iii.classroom03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class IOfilePrac02 {

	public static void main(String[] args) {
		// 
		FileInputStream fin;
		try {	
			//-------------Stream 串接---------------
			fin = new FileInputStream("dir1/staff.csv");	
			InputStreamReader irs = new InputStreamReader(fin); // 去看java API 這個類別的父類別 是 Reader
			BufferedReader br = new BufferedReader(irs);
			// 把文字資料換成Reader 再來 readLine( )
			
			//irs的物件實體 is a Reader類別
			//TODO  (已解決)這裡聽一下錄影  10509031430
			// 寫java的網際網路程式碼段時  只有InputStream/OutputStream  沒有Reader/Writer 所以要用  串接  來寫 

			String line = br.readLine();
			String[] row = line.split(","); // 用逗號來做為分割符號,split()數入參數設計為可讓你用正規表達式來做切割字串
			//System.out.println(row.length); // 印出看有幾個資料項
			for(String data : row)
			{
				System.out.println(data);
			}
			
//			String line;
//			while( (line = br.readLine()) != null )
//			{	// readLine() 一次讀一列字串進來，不會傳回 尾巴的符號(換列符號)
//				// 去看java API 的java.io.BufferedReader 的 readLine() 裡面有寫 會回傳 null及不回傳換列符號
//			}
				
			// 因為是同一根管子(Stream) 所以 指要找 irs br fin 其中一個作 close() 即可
			fin.close();
		} 
		catch (Exception e) {
			// TODO 自動產生的 catch 區塊
			//e.printStackTrace();
		}
	}// main

}//class
