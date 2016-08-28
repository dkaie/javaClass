package tw.org.iii.classroom03;

public class castingAndCall {

	public static void main(String[] args) {
		// TODO 自動產生的方法 Stub
		Brad401 obj1 = new Brad401(); // 宣告為父類別  由父類別做出物件實體
		Brad402 obj2 = new Brad402(); // 宣告為子類別  由子類別做出物件實體
		Brad401 obj3 = new Brad402(); // 宣告為父類別  由子類別做出物件實體
		//Brad402 obj4 = new Brad401(); // 宣告為子類別  由父類別做出物件實體
		obj1.m1();
		obj2.m1();
		obj3.m1();
		//obj3.m2();
	}

}
class Brad401
{
	int a = 1;
	void m1(){System.out.println("Brad401():m1()被呼叫+"+a);}
}
class Brad402 extends Brad401
{
	int a = 2;
	void m1(){System.out.println("Brad402():m1()被呼叫+"+a);}
	void m2(){System.out.println("Brad402():m2()被呼叫");}
}

