package tw.org.iii.classroom03;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class jPrac0903_2 {

	public static void main(String[] args) {
		// TODO 自動產生的方法 Stub
		Student s1 = new Student(new Pokemon(), "Dave", 90, 50, 75);
		Student s2 = new Student(new Pokemon(), "Tony", 80, 70, 45);
		
//		System.out.println(s1.calTotal());
//		System.out.println(s1.calAvg());
		
		try {
			ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream("dir1/student.brad"));
			
			// 這裡就發生 例外 電腦 想寫 卻沒寫出去 所已jPrac0903_3.java執行時發生
			//java.io.WriteAbortedException
			//java.io.NotSerializableException
			
			oout.writeObject(s1); // 沒有 implements Serializable 這列發生例外
			oout.writeObject(s2);
			
			oout.flush();
			oout.close();
			
		} catch (IOException e) {
			// TODO 自動產生的 catch 區塊
			//e.printStackTrace();
			System.out.println(e.toString());
		}
		// 任何一個物件 要被序列化前  要可被實作敘列化
		
	} // main

} // class jPrac0903_2

//-------------------物件序列化------------------

// 把資料一個個拉出去   序列化 物件的屬性而已
// 一個物件跟另一個物件不一樣  差別只在屬性而已

class Student implements Serializable
{
	// Serializable 序列化       這玩意 自己去看 API會發現  沒有 要實作 的方法  10509031530
	// 所以 只需 宣告 即可       implements Serializable即可
	
	// 這個類別 如果有一個物件的話 物件也要實作序列化  而 String早就做過 序列化了
	// 序列化 可繼承?  父類別序列化過 子類別就可不做序列化 ?
	
	
	int ch;
	//transient int eng; // 被標註了transient  這個屬性不會被序列化  有這個屬性 但會以 0 計算  如果是物件型別  解序列化回來 屬性值會是null
	int eng;
	int math;
	String name;
	Pokemon pm;
	Student(Pokemon pm, String name, int ch, int eng, int math)
	{
		this.name = name;
		this.ch = ch; this.eng = eng; this.math = math;
		this.pm = pm;
	}
	double calTotal(){return ch+eng+math;}
	double calAvg(){return calTotal()/3.0;}
} // class Student
class Pokemon implements Serializable
{

}