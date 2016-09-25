package tw.org.iii.classroom03;
//第一道敘述 寫出  package name 所在位置

public class HelloW {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		// FIXME bug here
		// XXX
			
		// 
		System.out.println("Hello WWW111111");
		//10509081945測試更改
		System.out.println("ok");
		
		long c = 12; // 基本型別 會自動轉型(Autoboxing)
		//Long a = 12; // Long不是基本型別  12是屬於int  所以會錯 ,   assign 12L(這樣就是long的型態)就會對了
		Integer b = 12;
		
		
		
	}
	
	public static void main(String[][][] args) {
		
	}
	public static String main(String[][] args) {
		return "hello";
	}
	
	
	
	
}
class AAA extends Thread
{
	@Override
	public void run() {
		// TODO 自動產生的方法 Stub
		super.run();
	}
}

class OCJP271
{
	//int m1(){return 1;}
	
	Object m1(){return "";}
	
}
class OCJP272 extends OCJP271
{
	//long m1(){return 1;}
	// 方法名稱 參數一樣  override 基本型別的傳回值要相同  包括 void
	
	// String is a Object  物件型別 存在於 is a 關係
	String m1(){return "";}
}

