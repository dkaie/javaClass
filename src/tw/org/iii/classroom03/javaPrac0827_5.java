package tw.org.iii.classroom03;

public class javaPrac0827_5 {

	public static void main(String[] args) {
		// 
		Brad332 obj1 = new Brad332();
		obj1.m1();
		obj1.m1(1);
		obj1.m2();
	}

}
class Brad331
{
	int a; // 這傢伙是 this.a
	void m1(){System.out.println("Brad331:m1()被呼叫");a++;}
}
class Brad332 extends Brad331
{
	int a;
//	void m1()
//	{	
//		System.out.println("Brad332:m1()被呼叫"); // 子類別再額外增加新功能	
//		super.m1(); // 呼叫父類別的方法
//	}
	
	//void m1(int b)
	void m1(int a) // 區域變數的a
	{
		super.m1();
		a++; // 會抓"距離"最近的a來使用，"距離"的遠近為 : 區域變數 < 子類別 < 父類別
		System.out.println("Brad332:m1(int)被呼叫 + a="  + a);
		System.out.println("Brad332:m1(int)被呼叫 + this.a="  + this.a);
		// 這個this.a是物件的屬性，因為Brad332繼承Brad331所以 如果 Brad332沒有宣告 int a; 的話 
		// 就會用Brad331的a ??
	}
//	int m1(int a)
//	{	// 多型 看的是傳數參數 個數 型別  而跟 回傳型別無關   所以這種寫法是錯的
//	}
	void m2(){System.out.println("Brad332:m2()被呼叫");}
}
