package tw.org.iii.classroom03;

public class javaPrac0828_2 {

	public static void main(String[] args) {
		// TODO 自動產生的方法 Stub
		Brad354 car = new Brad354();
		Brad352 tire1 = new Brad352();
		
		// TODO 這列宣告的類別 是寫錯的 去看老師是用哪個類別
		Brad354 tire2 = new Brad354(); 
		
		// TODO 這裡不懂
		car.m1(tire1);
	}

}
interface Brad351
{	// 只要視這種介面都要實作出方法 ?
	// java中的 介面 就算沒有加 存取修飾字 全部都是 public 以及他裡面所定義的方法也是public
	void m1(); // 沒有實作 也沒有定義 只給你開規格?
	void m2();
}
class Brad352 implements Brad351
{
	// class Brad352 打算實現 實作 interface Brad351的東西
	
	// 這不是子類別 因為不是繼承關係  是實作關係
	
	// 既然此類別實作了 Brad351介面  那 介面中有開的規格 在此類別中 你都要實作出來 要不然會出錯
	
	// 只要看到大括號就是有實作
	// 因為介面訂出的方法 是public 你沒有辦法找到其他 給更多權限的修飾字 所以只好下public
	public void m1(){  System.out.println("Brad352:m1 被呼叫");  }	
	public void m2(){  System.out.println("Brad352:m2 被呼叫");  }	
	void m3(){  System.out.println("Brad352:m3 被呼叫");  }	
}
class Brad353 implements Brad351
{
	public void m1(){  System.out.println("Brad353:m1 被呼叫");  }	
	public void m2(){  System.out.println("Brad353:m2 被呼叫");  }	
	void m4(){  System.out.println("Brad353:m4 被呼叫");  }	
}
class Brad354
{
	void m1(Brad351 obj1)
	{
		// 我希望 擁有我想要的功能 的物件實體傳遞給我
		obj1.m1();
		obj1.m2();
	}
}

