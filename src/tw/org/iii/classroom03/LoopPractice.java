package tw.org.iii.classroom03;

public class LoopPractice {

	public static void main(String[] args) {
		
//		ForPractice01();		// 無窮迴圈
//		ForPractice02();		// 迴圈條件內寫程式碼
//		MultiplyTable();		// XXX proj03 九九乘法表 三層迴圈
//		prime_numbe_check00();	// 這個玩意很像是複製老師教的程式碼 再自己改 沒寫完成的
//		prime_numbe_check01();	// 質數判斷 v1.0
//		prime_numbe_check02();	// 1~100排成
//		forLoopPractice05();	// 幼稚園等級的 for + if練習
		LoopLabel();			// 迴圈標籤  很像 GOTO的東西
//		forLoopPractice07();	// continue
//		NotUseArray();			// 用switch寫 骰子1~6
//		ArrayPractice();		// 基礎陣列練習
//		ModifyToArray();		// XXX proj04 用Array寫 骰子1~6
		lead_dice();			// 灌鉛骰子
//		lead_dice_teacher();	// 灌鉛骰子(老師公布的寫法)
		
	} // main
	
	public static void ForPractice01()
	{
		// TODO (已解決)有空可以聽一下 看老師怎麼講無窮迴圈的  1050820 12:10	
		// 典型的無窮迴圈寫法 好像是for裡面沒寫都視為 true的樣子
//		for(;;)
//		{
//			//System.out.println(i++);
//		}
		
//		for(int i = 0; i < 10; i++ )
//		{
//			System.out.println(i);
//		}
		//System.out.println("game over");		
	}
	
	public static void ForPractice02()
	{
		int i = 0;
		// 以下是一個無窮迴圈
		for(System.out.println("Hello"); ; System.out.println("--------"))
		{
			System.out.println(i++);
		}
		
		// 老師說for小括號內的三個參數都跟計數器沒有關係
		// 老師說如果 有聽過 for迴圈是計數器的觀念 , 則此觀念在java內不適用
		// 手寫筆記中老師在這有對for迴圈的執行做5步驟說明
		// 老師說 步驟1一定會執行到,有可能執行步驟1 2完後就跳出迴圈了
	}
	
	public static void MultiplyTable()
	{
		for(int k=0; k<2 ;k++)
		{	
			for(int j=1; j<=9 ;j++)
			{	for(int i=2; i<=5; i++)
				{
					int newi = i+k*4;
					int r = newi * j;
					System.out.print(newi +"x"+ j +"="+ r+"\t");
					// \t 相當於按下實體鍵盤的 tab鍵  cnosole輸出 會 8 16 24這樣跳 
					//	在程式編輯器中 則是4格 			
				}
				System.out.println(); // 換列
			}
			System.out.println("---------------------------------------------");
		}
		
	} // void MultiplyTable()
	
	public static void prime_numbe_check02()
	{
		for(int i=1; i<=100; i++)
		{
			// 質數判斷
			boolean isOK = true;
			for(int k = 2; k<i; k++)
			{	
				if(i % k == 0) // 整除 就不是質數
					isOK = false;
			}
			//System.out.print(i+"\t");
			System.out.print(i + (isOK?"*":" ") +"\t");
			if (i % 10 == 0) // 每逢10 20 30
				System.out.println();	// 換列	
		}
	} // void prime_numbe_check02()
	
	public static void prime_numbe_check01()
	{
		for(int j=0; j<10 ;j++)
		{	
			for(int i=1; i<=10; i++)
			{
				int v = j*10+i; // 製造1~100的數字
				// 判斷是否為質數
				boolean isOK = true;
				for(int k = 2; k<=v/2; k++)
				{	// TODO 有空聽一下 10508201432
					// 老師有提到 比質數 不用全部比 只需要比一半 ==> 這是數學邏輯問題 自己有空慢慢想
					// 所以for迴圈的判斷式 除以2
					if(v % k == 0)
					{	// 餘數等於0， 整除，就不是質數
						isOK = false;
						break; // 讀到break 會離開 他所在的迴圈結構
					}
				}
				System.out.print(v + (isOK?"*":" ") + "\t"); // 三元運算式 ==>  判斷式?:
			}
			System.out.println();
		}
	} // void prime_numbe_check01()
	
	public static void prime_numbe_check00()
	{
		for(int j=0; j<10 ;j++)
		{	
			for(int i=1; i<=10; i++)
			{
				int v = j*10+i;
				System.out.print(v+"\t");
			}
			System.out.println();
		}		
	} // void prime_numbe_check00()
	
	public static void forLoopPractice05()
	{
		for(int i=0; i<10; i++)
		{
			System.out.println(i);
			if(i==7)
			{
				break;
			}
		}

	} // void forLoopPractice05()	
	
	public static void LoopLabel()
	{
		OutsideFor: // 把外圈加一個label 迴圈標籤
		for(int j=3; j>0; j--)
		{	for(int i=0; i<3; i++)
			{
				System.out.println(i+";"+j);
				if(i==1)
					break OutsideFor;
			}
		}

	} // void forLoopPractice6()
	
	public static void ArrayPractice()
	{
		int[] a; // java官方建議這種寫法
		int b[];
		a = new int[4]; // new 是用來產生配置出物件的空間
		// new完後就完成初始化，int byte long short char 預設值為0
		// double預設為0.0 ，boolean預設為false
		for(int i=0; i<a.length; i++ )
		{
			System.out.println(a[i]);
		}
		System.out.println("---------------------------------------------");
		int[] d = new int[3];
		int[] e = new int[]{1,2,3,5,7};
		for(int i=0; i<e.length; i++)
		{
			System.out.println(e[i]);
		}
		System.out.println("---------------------------------------------");
		int[] f = {1,2,3,5,7};
		
		for(int i=0; i<f.length; i++)
		{
			System.out.println(f[i]);
		}
		
	} // void ArrayPractice()
	
	public static void lead_dice_teacher()
	{	// 灌鉛的骰子，跑9個點數，7~9的機率灌到4~6
		int[] p = new int[9]; // p內部都已經初始化為0了
		double rate=0, aa=0, total = 77777;

		for(int i=0; i<total; i++)
		{
			int point = (int)(Math.random()*9); // 0~8的亂數
			p[point>=6?point-3:point]++;
		}
		for(int i=0; i<6; i++)
		{
			aa = p[i];
			rate = aa/total;
			System.out.println((i+1)+":"+p[i]+" ("+rate+")");
			
		}
	} // void lead_dice_teacher()
	
	public static void lead_dice()
	{	// 灌鉛的骰子，跑9個點數，7~9的機率灌到4~6
		int[] p = new int[9]; // p內部都已經初始化為0了
		double rate=0, aa=0, total = 77777;

		for(int i=0; i<total; i++)
		{
			int point = (int)(Math.random()*9); // 0~8的亂數
			p[point]++;
		}
		p[3]+=p[6];
		p[4]+=p[7];
		p[5]+=p[8];
		for(int i=0; i<6; i++)
		{
			aa = p[i];
			rate = aa/total;
			System.out.println((i+1)+":"+p[i]+" ("+rate+")");
			
		}
	} // void lead_dice()
	
	public static void ModifyToArray()
	{	// 用陣列記錄 骰子1~6的出現次數
		int[] p = new int[6]; // p內部都已經初始化為0了
		
		for(int i=0; i<100; i++)
		{
			int point = (int)(Math.random()*6); // 0~5的亂數
			p[point]++;
		}
		for(int i=0; i<p.length; i++)
		{
			System.out.println((i+1)+":"+p[i]);
		}
	} // void ModifyToArray()
	
	public static void NotUseArray()
	{	// 用變數記錄 骰子1~6的出現次數
		int p1, p2, p3, p4, p5, p6;
		p1 = p2 = p3 = p4 = p5 = p6 = 0;
		
		for(int i=0; i<100; i++)
		{
			int point = (int)(Math.random()*6+1); // 1~6的亂數
			switch(point)
			{
				case 1:	p1++; break;
				case 2:	p2++; break;
				case 3:	p3++; break;
				case 4:	p4++; break;
				case 5:	p5++; break;
				case 6:	p6++; break;
			}
		}
		System.out.println("1: " + p1);
		System.out.println("2: " + p2);
		System.out.println("3: " + p3);
		System.out.println("4: " + p4);
		System.out.println("5: " + p5);
		System.out.println("6: " + p6);
		
	} // void NotUseArray()
	
	public static void forLoopPractice07()
	{
		for(int i=0; i<10; i++)
		{	// 印出奇數
			if(i%2==0)
			{
				continue; // 只要看到他 這圈以下的程式碼通通不要再做，換下一圈
			}
			System.out.println(i);
		}
	}


} // class
