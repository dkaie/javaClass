package tw.org.iii.classroom03;


//主類別程式名稱 必須和 主檔名相同
public class javaPrac0828_5 {

	public static void main(String[] args) {
		// 
		
		//  final 的變數只能給值一次
		//final int d = 10; // d是區域變數。宣告在 方法/實作 中的都是區域變數
		final int d ; // d是區域變數
		d = 12;
		System.out.println(Brad376.a); // a是static的東西
	}

}
interface Brad371 {void m1();}
interface Brad372 {void m2();}
class Brad373 implements Brad371, Brad372
{	// 介面可以多個，但每個介面開出來的規格，你都要去實作到
	public void m1(){}
	public void m2(){}
}
interface Brad374 extends Brad371
{	// 介面繼承介面
	void m3();
}
interface Brad375 extends Brad371,Brad372
{	// 介面的繼承觀念跟類別不一樣，可以多個 ，java中好像都是單一繼承
	
	// 介面除了方法外 也可有屬性
	// interface本身沒有安全性的 所以介面的東西都是public
	int a = 10;// 介面沒有 其他 機會/做法/方式方法  可以做初始化動作  所以屬性必須給初值
	// a的性值 為 public 及 final 及 static
	void m3();// m3的性值 為 public
}
class Brad376 implements Brad375
{	// 因為介面繼承介面的關係 所以 Brad371開的m1規格，Brad372開的m2規格，你都要實作到
	
	int b; // 物件的屬性
	final int c ; // final 的變數只能給值一次  c是物件的屬性
	// c的值要嘛在宣告實就給值，要嘛在建構子給值，因為物件的建構子只會被執行一次，剛好符合 final只能給值一次的要求
	
	Brad376(){c=12;}
	@Override
	public void m1() {
		// 
		b++;
		//a = 1;	// 因為在介面中的屬性 有 public 及 final 及 static的性值
					// ，其中 final的性值導致 這裡不可再設定 a
	}

	@Override
	public void m2() {
		// 
		
	}

	@Override
	public void m3() {
		// 
		
	}
	
}


