package tw.org.iii.classroom03;

public class IDcard {

	//private String id = "A123456789"; // 把他封裝起來(定為private) 以免此(身分證字號)屬性被其他物件更改
	// 這裡的 id 是物件的屬性
	//------------ 上面是產生身分證字號 寫法1在用的，下面是產生身分證字號 寫法2在用的 ---------------
	private String id = null;
	
	
	static String check = "ABCDEFGHJKLMNPQRSTUVXYWZIO";
	
	IDcard()
	{
		this(  (int)(Math.random()*2)==0  ,  (int)(Math.random()*26)  );
	}
	IDcard(boolean gender)
	{
		this(  gender , (int)(Math.random()*26)  );
	}
	IDcard(int area)
	{
		this(   (int)(Math.random()*2)==0  ,  area  );
	}
	IDcard(boolean gender, int area)
	{	// 產生身分證字號
		
//		String c0 = check.substring(area, area-1);
//		String c1 = gender?"1":"2";
//		String c2 = "" + ; // 在java中 String加只會拿來運算? 所以可以做數值加字串?
		// 在java裡面，字串只有加的運算，沒有其他，字串相加，他會把裡面的運算轉成字串，所以字串加整數，結果也會轉成字串
		// ，兩個運算子裡面只要有一個是字串，運算後的結果就會都轉成字串
		
		//--------------產生身分證字號 寫法1---------------
		// 以身分證總共11碼來說，產生前面兩個數字碼
		// 以身分證總共10碼來說，產生前面的英文字碼
		id = check.substring(area, area+1); // 產生ID的第一個英文字母
		// 這裡已經配一個記憶體空間給 id變數
		
		// 以身分證總共10碼來說，產生第一個數字碼
		id += gender?"1":"2"; // 產生ID的第一個數字
		// 這裡又配一個記憶體空間給 id變數( 這段好像是在 1050827 下午3點~4點講的)
		
		// 這裡再配7個記憶體空間給 id變數
		// 以身分證總共10碼來說，隨機產生第2~8個數字碼
		for(int i = 0; i<7; i++)
			id += (int)(Math.random()*10) ; // 產生 ID的 第?個數字 ?
		
		// 以身分證總共10碼來說，第9個數字碼,用迴圈一個個去跑,一定會有一個符合
		for(int i=0; i<10; i++)
			if(isRight( id + i )) // 呼叫isRight()函數來驗證,產生出來的身分證字號正不正確
			{
				id = id + i;
				break;
			}
		
		//---------------產生身分證字號 寫法2------------------------------------
		StringBuffer temp = new StringBuffer(  check.substring(area, area+1)  );
		temp.append( gender?"1":"2" );
		for(int i = 0; i<7; i++)
			temp.append( (int)(Math.random()*10) );
		
		for(int i=0; i<10; i++)
			if(isRight( temp.toString() + i )) // 因為 temp是StringBuffer類別，所以要先轉成 Sting 再來做 if判斷
			{
				id = temp.append(i).toString();
				break;
			}
		
	} // IDcard(boolean gender, int area)
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
		{	// TODO 前測試
			
			int n12 = check.indexOf(testId.charAt(0))+10;
			int n1 = n12/10;
			int n2 = n12%10;
			
			int n3,n4,n5,n6,n7,n8,n9,n10,n11;
			int[] n3t011 = new int[9];
			for(int i=0; i<9; i++)
				n3t011[i] = Integer.parseInt(testId.substring(i+1,i+2)); // parseInt()是用來把字串轉換成整數的函式
			// 建立維基百科的身分證字號規則中的n3~n11
			
			int total = n1*1 +
						n2*9 +
						n3t011[0]*8 + 
						n3t011[1]*7 + 
						n3t011[2]*6 + 
						n3t011[3]*5 + 
						n3t011[4]*4 + 
						n3t011[5]*3 + 
						n3t011[6]*2 + 
						n3t011[7]*1 + 
						n3t011[8]*1;
			
			ret = total % 10 == 0;
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
