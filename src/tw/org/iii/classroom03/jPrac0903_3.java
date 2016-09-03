package tw.org.iii.classroom03;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class jPrac0903_3 {

	public static void main(String[] args) {
		// TODO 自動產生的方法 Stub
		
		//------------解序列化----------------
		
		
		try {
			ObjectInputStream oin = new ObjectInputStream(new FileInputStream("dir1/student.brad"));
			
			Object obj1 = oin.readObject(); // 這會傳回一個物件
			Student s1 = (Student)obj1; // 他骨子裡就是Student 只是在序列化過程中 用  Object來看待他  所以這裡再轉型回來
			// 10509031542
			
			Student s2 = (Student)(oin.readObject());
			
			oin.close();
			System.out.println(s1.name+":"+s1.calTotal());
			System.out.println(s2.name+":"+s2.calTotal());
			
		}
//			catch (IOException | ClassNotFoundException e) {
//			// 沒有 父子類別關係的 例外類別 可以使用 或  邏輯運算子
//			
//			// TODO 自動產生的 catch 區塊
//			//e.printStackTrace();
//			
//			System.out.println("hello asdfg");
//		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	} // main

} // class
