package tw.org.iii.classroom03;

public class javaPrac0827_3 {

	public static void main(String[] args) {
		// 
	//	Brad321.m1(); // 只要有用到類別的東西 ??就被載入記憶體中???????
		
		Brad321 obj11 = new Brad321();
		Brad321 obj12 = new Brad321();
//		System.out.println("---------------");
//		Brad322 obj2 = new Brad322();
//		System.out.println("----------------");
//		Brad323 obj3 = new Brad323();
		
	} // main()

}
class Brad321
{	// 這段好像是在 10508271600講的
	int a = 12;
	
	{	// 這段為物件的程式區塊(code block)，會比建構子還先執行，寫法就是用大括號包起來
		System.out.println("brad321 程式區塊被呼叫 +" + ++a);
	}
	
//	static{	
//		System.out.println("brad321 hello   +" + ++a); // 這樣寫會有錯 因為 static不能有物件的東西存在(a就是物件的東西) 
//	}
	
	static{
		// static好像會更先被載入  
		//只要有用到類別的東西 static的程式區塊 就會被叫用到
		// static 的東西 會占用記憶體
		System.out.println("brad321 static被呼叫   +");
	}
	static void m1()
	{
		System.out.println("brad321 : m1");
	}
	
	// java格式上 建構子 不會回傳 ，一般的方法會做回傳
	// 建構子沒有在繼承，方法跟屬性才有繼承觀念
	
	// 一旦有 new就有物件了
	// 在做建構式之前 早就存在 物件實體 ，進建構子只是在初始化物件實體
	Brad321()
	{
		System.out.println("brad321()建構子被呼叫");
	}
}
class Brad322 extends Brad321
{
	Brad322()
	{
		// 這列有藏一個 super();
		System.out.println("brad322()建構子被呼");
	}
}
class Brad323 extends Brad322
{
	Brad323()
	{
		// 這列有藏一個 super();
		System.out.println("brad323()建構子被呼");
	}
}




