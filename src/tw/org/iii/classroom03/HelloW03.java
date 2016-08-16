package tw.org.iii.classroom03;

public class HelloW03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TypeTest();
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

		int YearC = 2016;
		// 計算 閏年
		if ((YearC % 4) == 0) {
			if ((YearC % 100) == 0) {
				System.out.println("不是閏年");
			}
			else {
				if((YearC % 400) == 0){
					System.out.println("是閏年");
				}
				else{
					System.out.println("不是閏年");
				}
			}
		} 
		else {
			System.out.println("不是閏年");
		}

		

		System.exit(0); // 傳回給作業系統 0 表示正常結束 沒事

	} // main()

	public static void TypeTest() {
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
		var1 = 12.3F; // 加上F代表示福點數
		var2 = 12.3;
		double var3 = -10, var4 = 0;
		// System.out.println(var3/var4); // 這是指除以一個很接近0的數
	} // TypeTest()
} // class
