package tw.org.iii.classroom03;
// package的觀念  目錄結構 ，  會用相同的目錄結構放在你的目錄端  所以有一個國際慣例  用各個開發者所屬的網域名稱倒過來寫
// 第一道敘述就是說明我所在的package，沒有就是預設? 預設啥? 10508200914

public class HelloW03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TypePractice();
		// =================================================
		boolean var5 = true;
		boolean var6 = false;
		// System.out.println(var5);
		// 帶有 static 的 不用物件實體
		double test = Math.random();
		System.out.println(test);
		// int Score = (int)(test*(100+1)); // 製造0~100的random
		// 0~100間有連續101個 個數
		// int Score = (int)(test*6+1); // 1~6
		// int Score = (int)(test*30+40); // 40~69
		// int Score = (int)Math.random()*101; // 會先把Math.random拿去轉型
		int Score = (int) (Math.random() * 101);
		System.out.println(Score);

		// java內可作單列敘述句
		// 在IDE中 按下 Ctrl+Shift+F可幫忙做縮排 Format的意思
		// Macbook是按 Command+Shift+F
		// 一個完整的if else結構 一定會Run一塊 而且只會跑Run一塊
		// 完整是指包括 else
		// if (Score >= 90) {
		// System.out.println(" A Pass");
		// } else if (Score >= 80) {
		// System.out.println(" B Pass");
		// } else if (Score >= 70) {
		// System.out.println(" C Pass");
		// } else if (Score >= 60) {
		// System.out.println(" D Pass");
		// } else {
		// System.out.println("E");
		// }
		//System.out.println("Down");

		// 這種寫法和 if(a && b || c) 相比 效能沒較差 時間複雜度都是N
		// 以這個演算法來說 除以4的時候 就處理掉大部分的int數字了
		// 巢狀的寫法 可能 比較好閱讀
		// if(a && b || c)的寫法 較精簡
		
		int YearC = 2016;
		// 計算 閏年
		if ((YearC % 4) == 0) 
		{
			if ((YearC % 100) == 0) 
			{
				// System.out.println("不是閏年");
				
				// 西元年分除以4可整除但除以100不可整除，為閏年。
				
				if((YearC % 400) == 0)
				{	// 西元年分除以400可整除，為閏年。  29天
					System.out.println("是閏年");
				}
				else
				{	// 28天
					System.out.println("不是閏年");
				}
				
			}
			else 
			{	// 29天
				System.out.println("是閏年?");
			}
		} 
		else 
		{	// 西元年分除以4不可整除，為平年。  這裡老師說28天 是指二月有28天
			System.out.println("不是閏年");
		}

		

		System.exit(0); // 傳回給作業系統 0 表示正常結束 沒事

	} // main()

	public static void TypePractice() {
		// char �d��O 2^16
		char v1 = 'a';
		char v2 = 98; // ASCII : b
		char v3 = '資';
		// System.out.println(v1);
		// System.out.println(v2);
		// System.out.println(v3);
		// ======================================
		byte 體重 = 80;
		System.out.println("我的體重:" + 體重);

		int v4 = v1 + v2;
		// char byte int short 運算後的結果為int
		// long 運算後的結果為 long
		// System.out.println(v4);
		// =================================================
		float var1;
		double var2;
		var1 = 12;
		var1 = 12.3F; // 加上F代表示浮點數
		var2 = 12.3;
		double var3 = -10, var4 = 0;
		// System.out.println(var3/var4); // 這是指除以一個很接近0的數
	} // TypeTest()
} // class
