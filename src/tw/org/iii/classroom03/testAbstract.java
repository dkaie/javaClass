package tw.org.iii.classroom03;

public class testAbstract {

	public static void main(String[] args) {
		// TODO 自動產生的方法 Stub
		Brad391 obj1 = new Brad391();
		//Brad392 obj2 = new Brad392(); // 抽象類別無法做出物件實體
		
		Brad392 obj2 = new Brad393(); // 宣告為父類別 但由子類別做出來
		Brad393 obj3 = new Brad393();
		//obj2.m2(); // obj2沒有 m3()方法 因為是 Brad392 定義的
		//obj3.m3(); // obj3    有 m3()方法 因為是 Brad393 定義的
		Brad393 obj4 = (Brad393)obj2; // 強制轉型成Brad393     因為 Brad393骨子裡本身就是 Brad392 所以可以轉型
		obj4.m3(); // obj4    有 m3()方法 因為是 Brad393 定義的
	}

}
class Brad391
{
	void m1(){}
	void m2(){}
}
abstract class Brad392
{	// 類別內有 沒有具體定義的方法 ，該類別 需為 抽象類別
	// 肚子內沒有抽象方法 也可宣告成 抽象類別  我不打算讓你直接去建構  只讓你用子類別去做
	// 某項功能 不打算在父類別內定義  但 回傳和 輸入 父類別會說名  但子類別繼承後  子類別就要去實作
	// 介面 所有都是抽象方法
	
	// 抽象類別雖然無法做出物件實體 但仍可定義建構子  不過 建構子是給子類別用的
	Brad392(){  System.out.println("我是Brad392()");  }
	void m1(){  System.out.println("Brad392():m1()被呼叫");  }
	abstract void m2(); // 只做定義 而不做實作
}
class Brad393 extends Brad392
{
	void m2(){  System.out.println("Brad393():m2()被呼叫");  } // 實作(就是寫出大括號) 抽象類別Brad392  的抽象方法m2()
	void m3(){  System.out.println("Brad393():m3()被呼叫");  } // 子類別自己加的方法
}





