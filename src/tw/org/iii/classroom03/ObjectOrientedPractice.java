package tw.org.iii.classroom03;

// 這個 java檔  會用到  Bike.java

public class ObjectOrientedPractice {

	public static void main(String[] args) {
		
		//propertyPractice();	// 類別宣告練習
		ooPractice();			// XXX proj05 類別宣告練習  首度使用 別的java檔內的類別
		StringPractice();		// 類別   字串   練習
		
	} // main

	
	public static void StringPractice()
	{
		Bike b1 = new Bike();
		String s1 = new String();
		String s2 = new String(new byte[]{97,98,99,100});
		String s3 = "Hello World"; // 沒有new，但物件確實是存在，因為JVM做的
		String s4 = new String("hello world");
		System.out.println(b1);
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s1.length());
		System.out.println(s4.length());
		System.out.println("Hello world".length());
		// length : 陣列在建構時，你就賦予他這項屬性，但字串則是看你給幾個字元，再用方法去計算長度
		// 所以陣列的長度是呼叫屬性，  字串的長度則是呼叫方法		
	}
	
	public static void ooPractice()
	{
		Bike b1 = new Bike();
		Bike b2 = new Bike();
		
		// TODO 有空這裡聽一下  下面的註解寫到一半   1050821 PM查看看
		System.out.println(b1);// 的類別物件實體在記憶體的位址(參考位址)
		System.out.println(b2);
	}
	
	public static void propertyPractice()
	{	
		Bike myBike, urBike;
		myBike = new Bike(); // 在new的同時，就已經配給初值了，所以物件的屬性有初值了
		urBike = new Bike();
		System.out.println(myBike.getSpeed());
		System.out.println(urBike.getSpeed());
		System.out.println("-----------------------");

		for(int i=0; i<14; i++)
		{
			myBike.upSpeed();
		}
		System.out.println("myBike:"+myBike.getSpeed());
	}
	
	
} // class
