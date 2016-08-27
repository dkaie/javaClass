package tw.org.iii.classroom03;

public class IDcard {

	private String id = "A123456789"; // 把他封裝起來(定為private) 以免此(身分證字號)屬性被其他物件更改
	// 這裡的 id 是物件的屬性
	
	IDcard(String id)
	{	// 產生物件實體後的初始化動作
		this.id = id; // this指的是這個類別(目前所在的類別?)
	} // 建構子 建構式
	
	
	String getId()
	{	// 傳回身分證字串
		return id;
	}
	
	boolean getGender()
	{	// 傳回性別
		return id.charAt(1) == '1';
	}
	
	String getArea()
	{	// 傳回地區
		return "台中市";
	}
	
	static boolean isRight(String testId)
	{	// 驗證身分證字號是否正確
		boolean ret  = false;
		// if(preCheck(testId)) // ==> 這是還沒用正規表達式前的思維，所以會用到這列
		
		//if(testId.matches("^A$")) // ==> 開頭&結尾都是A ==> "A"只有這才會對  "A1"這會錯
		// 中括號代表一個字元    [字元集合]=>取一個字元(只會取一個字元?)
		// 大括號代表前面的東西出現的次數
		
		// "^09[0-9]{2}-[0-9]{3}-[0-9]{3}$" ==> 0912-123-456 ==> 上課自己練的 手機號碼 的正規表達式
		// "^09[0-8][0-9]-[0-9]{6}$" ==> 0912-123456 ==> 上課老師寫的 手機號碼 的正規表達式
		
		if(testId.matches("^[A-Za-z][12][0-9]{8}$"))
		{	// TODO 前測試完成
			ret = true;
		}
		else
		{
			ret = false;
		}
		return ret;
	}
	
	static boolean preCheck(String testId)
	{
		boolean isOK = false;
		
		//------------------- 沒用正規表示法的寫法 --------------------
//		if(
//				(testId.length() == 10) &&
//				( ('A'>= testId.charAt(0)) && ( testId.charAt(0) <= 'Z')  )&&
//				( ('a'>= testId.charAt(0)) && ( testId.charAt(0) <= 'z')  )&&
//				//("ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(testId.charAt(0)))&&
//				( testId.charAt(0)=='1' || testId.charAt(0)=='2' )&&
//				( true )
//				)
//		{	// 字串長度為10
//			// 第一個位置為A~Z
//			// 第二碼為1或2
//			// 3~10碼需為0~9
//			
//		}
		
		//------------------- 用正規表示法的寫法 --------------------
		if(testId.matches(""))
		{
			isOK = true;
		}
			return isOK;
	} // boolean preCheck(String testId)
	
	
} // class IDcard
