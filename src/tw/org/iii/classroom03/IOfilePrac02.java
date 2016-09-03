package tw.org.iii.classroom03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class IOfilePrac02 {

	public static void main(String[] args) {
		// TODO 自動產生的方法 Stub
		FileInputStream fin;
		try {	
			//-------------Stream 串接---------------
			fin = new FileInputStream("dir1/staff.csv");	
			InputStreamReader irs = new InputStreamReader(fin);
			BufferedReader br = new BufferedReader(irs);
			
			//irs的物件實體 is a Reader類別
			//TODO  這裡聽一下錄影  10509031430
			// 寫java的網際網路程式碼段時  只有InputStream/OutputStream  沒有Reader/Writer 所以要用  串接  來寫 

			String line = br.readLine();
			String[] row = line.split(","); // 用逗號來做為分割符號
			//System.out.println(row.length); // 印出看有幾個資料項
			for(String data : row)
			{
				System.out.println(data);
			}
			
//			String line;
//			while( (line = br.readLine()) != null )
//			{	// readLine() 不會傳回 尾巴的符號(換列符號)
//				
//			}
					
			fin.close();
		} 
		catch (Exception e) {
			// TODO 自動產生的 catch 區塊
			//e.printStackTrace();
		}
	}// main

}//class
