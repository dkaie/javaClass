package tw.org.iii.classroom03;

public class LoopPractice {

	public static void main(String[] args) {
		// TODO 自動產生的方法 Stub
		
		//ForPractice01();
		//ForPractice02();
		MultiplyTable();
	} // main
	
	public static void MultiplyTable()
	{
		for(int k=0; k<2 ;k++)
		{	for(int j=1; j<=9 ;j++)
			{	for(int i=2; i<=5; i++)
				{
					int newi = i+k*4;
					int r = newi * j;
					System.out.print(newi +"x"+ j +"="+ r+"\t");
					// \t 相當於按下實體鍵盤的 tab鍵  cnosole輸出 會 8 16 24這樣跳 
					//	在程式編輯器中 則是4格 			
				}
				System.out.println();
			}
			System.out.println("---------------------------------------------");
		}
		
	} // void ForPractice03()
	public static void ForPractice02()
	{
		int i = 0;
		for(System.out.println("Hello"); ; System.out.println("--------"))
		{
			System.out.println(i++);
		}
	}
	public static void ForPractice01()
	{
		
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
	
	

} // class
