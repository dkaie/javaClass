package tw.org.iii.classroom03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sun.crypto.provider.RC2Parameters;

public class jPrac0925_1 {

	public static void main(String[] args) {

		// 之前寫的 IO 資料沒有格式 是一個個存進去的  ==>  序列
		
		// 1. Load dirver(新版的java有點做異動  有可能新版的 不用做這動作  適用於java去載入其他的驅動程式 一樣的做法)
		try {
			//Class.forName("Driver name"); // 載入驅動程式
			Class.forName("com.mysql.jdbc.Driver"); // 如果連其他的 SQL 要用他們的driver名稱
			// 若未把驅動程式的路徑帶給專案(就是沒做連結) 一樣會找不到driver 資料庫不會跟你溝通
			System.out.println("找到driver");
		} catch (ClassNotFoundException e) {
			// Not Found Driver	
			System.out.println("找不到");
		}
		
		// 2. Create Connection
		
		// 只要能建構 Connection介面     就可連線了  
		// 伺服器玩的昰通訊協定  所以沒有在分作業系統
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/iii?" +
                    										"user=root&password=root");
			// 這就是 位址的資源的定位    URL
			//									jdbc來跟sql server講話  (冒號)  主機名稱 (port 預設3306)  資料庫名稱
			//System.out.println("connection success");
			
			// 3. SQL => Statement Object  產生Statement
			Statement stmt =  conn.createStatement();

			// 4. extect Statement   執行Statement
//			stmt.executeLargeUpdate("INSERT INTO cust (cname,tel,birthday)" +
//					 "VALUES ('Brad','123','1999-01-01')");			
			//System.out.println("傳送 success");
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM cust");
			While(rs.next());
			{
				String id = rs.getString("id");
				String cname = rs.getString("");
				String tel = rs.getString("");
				String birthday = rs.getString("");
				
				System.out.println(id+":");
			}
			
			// 剛剛在設定資料庫時  id是為了要讓它自動遞增 所以設 int 其他都設字串型別
			conn.close();
			
			
			
		} catch (SQLException e) {
			System.out.println("sql error");
		}
		


	} // main

	private static void While(boolean next) {
		// TODO 自動產生的方法 Stub
		
	}

} // class
