package tw.org.iii.classroom03;

// 一個 java檔 會有一個主類別 前面 掛 public主類別
// ，主類別名稱須和 java主檔名相同

//這個 java檔  會用到  Bike.java

public class javaPrac0827_2 {

	public static void main(String[] args) {
 
//		testUseClass();				// 這個有呼叫 Bike類別的 靜態變數 來測試使用
//		testGetNumberFormString();	// 測試使用 subString()函數
//		testString();				// 測試在字串的尾巴加掛字串

		// XXX proj08 父類別建構子呼叫的應用
	//	Brad301 obj1 = new Brad301((short)2); // 他會去找一個 最接近 能自動轉型的建構子來用
		// 以目前的情況來看 第2個建構子的 int輸入 最接近 short，所以電腦會選第2個建構子來用
		Brad302 obj2 = new Brad302("3");

	} // main
	
	public static void testString()
	{
		//-------- 理論上 已宣告 的字串變數 的內容 無法被改變 --------------------------
		String a = "0123";
		System.out.println(a.concat("jack")); // 加上字串 但不會改變原內容
		System.out.println(a); // 經過上列程式碼後 ,a內的字串未被改變
		System.out.println(a.replace('2', 'k'));
		System.out.println(a); // 經過上列程式碼後 ,a內的字串未被改變
		
		//----下列測試可以改變  已宣告的字串變數的內容 -----
		StringBuffer sb1 = new StringBuffer();
//		sb1.append("abc"); // 加上字串 會改變元內容
//		System.out.println(sb1);
//		sb1.append("def");
//		System.out.println(sb1);
		
		System.out.println(sb1.capacity()); // 計算電腦配給Buffer的大小
		sb1.append("12345678912345678");
		System.out.println(sb1.capacity()); // 超過預設配的16大小，印出來的結果點腦配給34大小，16的兩倍在多一點點空間給你用
		
		
	}
	
	public static void testGetNumberFormString()
	{
		String test = "0123456789";
		System.out.println(test.substring(2, 7));	
	}
	
	public static void testUseClass()
	{
		// TODO 有空這裡聽一下 看看當時是不是有甚麼 要筆記沒寫到的
		
		System.out.println(Bike.count);
		
		Bike myBike = new Bike();
		Bike urBike = new Bike();
		System.out.println(myBike.count);
		System.out.println(urBike.count);
	} // static void testUseClass()

} // public class javaPrac0827_2 ==> 主類別

class Brad301 extends Object
{
//	Brad301()
//	{
//		System.out.println("A");
//	}
	Brad301(int a)
	{
		// 如果這個類別只有這個建構子，那其實這列藏了一個  呼叫super();
		System.out.println("B");
	}
//	Brad301(byte b)
//	{
//		System.out.println("C");
//	}
} // class Brad301

class Brad302 extends Brad301
{	// 類別沒定義建構子，會拿 父類別 無傳參數的建構子當 為其為一的建構式  ， 但如果 子類別有建 建構式，則前面敘述不成立
	// 建構式實作的第一道敘述 會呼叫  父類別 無傳參數的建構子，其實就是呼叫  super();
	// java中只要能產生物件實體，他的祖宗八代(父類別 祖父類別 曾祖父......)都會在記憶體中
	// 所以java的效能並不好，C語言的效能較好，java贏在跨平台
	Brad302()
	{
		super(1);
		System.out.println("D");
	}
	Brad302(int a)
	{
		this(); // this() 會呼叫本類別中 無傳參數的建構式
		System.out.println("E");
	}
	Brad302(String b){
		this(1);
		System.out.println("F");
	}
	
} // class Brad302



