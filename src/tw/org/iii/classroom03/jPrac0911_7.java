package tw.org.iii.classroom03;

public class jPrac0911_7 {

	// 執行緒在玩得是任務的事  時間不是我們的重點
	
	public static void main(String[] args) {
		// 程式要去應付使用者的要求 所以 程式會去開很多個處理程序 
		// 稱之為 fork(耙子) (想像 耙子的每個尖頭 都做一樣的事,就是分身的意思 )
		// zombie process(殭屍行程) 程序已結束了 但仍存在記憶體中 程式設計師 程式沒寫好
		
		// 一個程序會有多個執行緒 ?
		
		// 類別  要有 執行緒的生命特徵, 一定要繼承 Thread類別
		// 產生物件
		//Brad681 obj1 = new Brad681("第A個物件");
		//Brad681 obj2 = new Brad681("第B個物件");
		Brad681 obj1 = new Brad681("第A個物件",200);
		Brad681 obj2 = new Brad681("第B個物件",100);
		Brad682 obj3 = new Brad682("第B個物件",150);
		Thread t3 = new Thread(obj3);// 把 Runnable obj3 拿去建構出  t3 Thread
		// 可參考 上課筆記的 10509111540.png
		
		// 你可以去舞台旁邊等候   給CPU候選    不是程式設計師決定的  決定權在CPU手上
		// 睡醒後 一樣去舞台旁等候    給CPU候選
		obj1.start(); // 要表現出生命特徵  須呼叫start方法,所以這列執行下去 會有跑到 run() 函數
		//obj1.start(); // 因為 執行緒生命只有一條,所以start()太多次 會出現例外
		//obj1.start();
		
		obj2.start();
		// 加上 thread.sleep() 就可以很清楚的看到 obj1 obj2會同時執行 
		
		//obj3.start(); // obj3物件不是執行緒,所以沒有start( )方法可呼叫
		t3.start();
		
		try {
			obj2.join();
		} catch (InterruptedException e) {
		}
		// 在等 B ,B沒做完 不能做下一列
		System.out.println("main");
	}// main

}// class



class Brad681 extends Thread
{	
	// 用繼承Thread的寫法後  就不能再繼承其他類別
	
	//Brad681物件實體 為一個Thread物件
	
	private String name;
	private int delay;
	Brad681(String name,int delay)
	{
		this.name = name;
		this.delay = delay;
	}
	
	// Brad681為一個 thread,表現在 override run方法內
	// ,如果寫在其他方法,那只是個物件方法
	// 所以如果 程式碼 要表現出 有執行緒的生命特徵  就要寫再 override run()方法  內
	// TODO (已解決) 10509111403    錄影檔時間 0:43:14
	
	// 底下這些好像是 在key完類別 繼承 Thread類別後
	// 在類別內 打 "run" 再 Alt+/  會跳出框框    選  run   然後電腦就幫你寫好下面這段
	@Override
	public void run()
	{
		//---------------執行緒生命開始----------------
		
		// super.run();  // 老師:這個要寫不寫沒關係 因為裡面是空的
		
		//第1個 i 和 第2個i 執行的間隔時間  會大於等於 下方的 0.1秒
		
		for(int i =0 ; i< 10 ; i++)
		{	
			System.out.println(name +":"+i);
			try {
				//Thread.sleep(100); // 叫 thread睡0.1秒 
				Thread.sleep(delay); // 叫 thread睡0.1秒 
				// 有可能會在睡覺 途中 收到 Interrupte 所以須加例外
			} catch (InterruptedException e) {
				// 睡到一半被人吵醒  會來這
			}
		}
		//--------------執行緒生命結束 物件還在-----------
	} // run( )
	
}



class Brad682 implements Runnable
{	
	// 課本常見的 第二種 執行緒的 處理模式
	// Brad682這個類別做出來的 物件實體不是執行緒 , 因為繼承Object 實作Runnable方法
	// 因為Runnable有定義, 所以有 run( )方法 ,但沒有start( )方法 
	
	// 使用 implement Runable介面 之後 可以寫成 執行緒的做法 又可在繼承其他類別
	//他不是執行緒  他做出的物件實體沒有start()
	// 擴充性高 : 這個可以 再 繼承 其他類別
	
	// Brad681為一個 thread
	// 表現在 override run方法內
	// TODO 1050922晚自習聽到這     1050911 15:37    錄影檔時間 2:17:21
	// Runnable介面  看看要不要 聽一下錄影檔 
	private String name;
	private int delay;
	Brad682(String name,int delay)
	{
		this.name = name;
		this.delay = delay;
	}
	@Override
	public void run()
	{
		//---------------執行緒生命開始----------------
		//第1個 i 和 第2個i 執行的間隔時間  會大於等於 下方的 0.1秒
		
		for(int i =0 ; i< 10 ; i++)
		{	
			System.out.println(name +":"+i);
			try {
				//Thread.sleep(100); // 叫 thread睡0.1秒 
				Thread.sleep(delay); // 叫 thread睡0.1秒 
				// 有可能會在睡覺 途中 收到 Interrupte 所以須加例外
			} catch (InterruptedException e) {
				// 睡到一半被人吵醒  會來這
			}
		}
		//--------------執行緒生命結束 物件還在-----------
	} // run( )
	
}
