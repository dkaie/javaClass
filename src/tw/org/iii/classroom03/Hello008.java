package tw.org.iii.classroom03;

public class Hello008 {

	public static void main(String[] args) {
		
		LogicalPractice();	// println(字元) , 邏輯運算子
		SwitchPractice();	// Switch多選判斷式
		Switch_month();		// Switch"疊在一起"
		final_Var_Practice(); // final後的變數使用
		
	} // main

	public static void LogicalPractice()
	{
//		int a = 10, b = 3;
//		int c = 012; // 以0開頭的數字為8進制 0x開頭的是16進制
		// System.out.println(c); // 8或16進制丟入println, println會用10進制顯示
		
		// --a; // 這列code運算前 先做 a-1
		// a--; // 這列code運算完後 才做 a-1
		// System.out.println(--a); // 這列code運算前 先做 a-1
		
		int a = 10, b = 3;
		int c = a & b;
//		 System.out.println(c);		
		
		
		if(--a >= 10 & b++ <= 3)
		{	// && 左右兩邊都 需/為 布林值
			// 一個&或|  是二進位運算 所以 & 兩側的 布林判斷都會去執行
			// 二個& 是邏輯運算 所以 && 左側的 布林判斷為false 右側就不執行了
			// || 的左側 若為 true，右側好像不會去執行
			System.out.println("OK:a="+a+",b="+b);
		}
		else
		{
			System.out.println("XX:a="+a+",b="+b);
		}		
	} // LogicalPractice()
	
	public static void SwitchPractice()
	{
		int dir = 10;
		final int b = 9;
		switch(dir)
		{
			default:
				System.out.println("X");
				// break;
			case 1:
				System.out.println("A");
				break; // 執行到 break會直接跳到 switch{ }外面
			case 10:
				System.out.println("B");
				break;
			case b+2:
				System.out.println("C");
				break;

		}
	} // void SwitchPractice()
	
	public static void Switch_month()
	{
		int month = (int)(Math.random()*12+1);
		System.out.println(month);
		switch(month)
		{
			case 1:		case 3:		case 5:		case 7:		case 8:		case 10:		case 12:
				System.out.println("31");
				break;

			case 4:		case 6:		case 9:		case 11:
				System.out.println("30");
				break;
			case 2:
				System.out.println("28");
				break;
			default:
				System.out.println("XX");
				break;
		}
	} // void Switch_month()
	
	public static void final_Var_Practice()
	{
		
		// TODO 有空聽一下 10508201041 看看 被 final後的變數 老師是怎樣描述他的特性
		int dir = 5;
		final int STOP = 1; 
		final int LEFT = 2; 
		final int RIGHT = 3; 
		final int UP = 4; 
		final int DOWN = 5;
		switch(dir)
		{
			case STOP:
				System.out.println("S");
				break;
			case LEFT:
				System.out.println("→");
				break;
			case UP:
				System.out.println("↑");
				break;
			case DOWN:
				System.out.println("↓");
				break;
			default:
				System.out.println("X");
				break;
		}	
	} // void final_Var_Practice()
	
} // class Hello008
