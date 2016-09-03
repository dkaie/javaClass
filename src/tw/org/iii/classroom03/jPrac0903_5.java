package tw.org.iii.classroom03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class jPrac0903_5 {

	public static void main(String[] args) {
		// TODO 自動產生的方法 Stub
		System.out.println("-------------序列化---------------");
		Brad573 obj = new Brad573();
		try {
			ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream("dir1/Brad57"));
			// 副檔名的作用在 微軟的OS中  開啟檔案的關聯  當看到 .doc 關聯表就會 關聯到 Microsoft Office
			// 供拿到檔案的人 知道這個檔案的作用是做啥的
			// 所以 老師才會說 副檔名較不重視
			oout.writeObject(obj);
			oout.flush();
			oout.close();
			System.out.println("-------------序列化 完成---------------");
		} catch (IOException e) {
			// TODO 自動產生的 catch 區塊
			//e.printStackTrace();
		}
		
		System.out.println("-------------解序列化---------------");
		ObjectInputStream oin;
		try {
			oin = new ObjectInputStream(new FileInputStream("dir1/brad57"));
			Brad573 obj2 = (Brad573)oin.readObject();
			
			oin.close();
			System.out.println("-------------解序列化 完成---------------");
		} catch (Exception e) {
			// TODO 自動產生的 catch 區塊
			//e.printStackTrace();
		}
	}//main

}

//TODO 這裡可以考慮看一下錄影
// 雖然 子類別已序列化  但 父類別無序列化  則 解序列化時 會去 實作父類別? 會去跑父類別的建構子   10509031645這裡聲音會很小聲
// 如果父類別 序列化 解序列化回來時  父子類別 都不會在去實作?不去跑建構子?





class Brad571
{
	Brad571()
	{
		System.out.println("Brad571建構子已建立");
	}
}
class Brad572 extends Brad571
{
	Brad572()
	{
		System.out.println("Brad572建構子已建立");
	}
}
class Brad573 extends Brad572 implements Serializable
{
	Brad573()
	{
		System.out.println("Brad573建構子已建立");
	}
}