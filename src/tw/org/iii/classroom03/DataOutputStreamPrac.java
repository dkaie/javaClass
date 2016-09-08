package tw.org.iii.classroom03;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class DataOutputStreamPrac {

	// 上午教的檔案 I/O 都是 做 byte型態  這裡 有 各種數值型態
	
	public static void main(String[] args) {
		// 
		
		int a = 123;
		boolean b = true;
		double c =12.3;
		try {
			DataOutputStream dout = new DataOutputStream(new FileOutputStream("dir1/data.dat"));
			// 老師說副檔名叫啥不重要
			
			dout.writeInt(123);
			//dout.writeInt(456); // 這是自己家來測試用的 看看會不會覆蓋過 或接在尾巴  老師沒有講這列
			dout.writeBoolean(b);
			dout.writeDouble(c);

			dout.flush();
			dout.close();
		} catch (Exception e) {

		}
	}// main

}//class
