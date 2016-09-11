package tw.org.iii.classroom03;

public class jPrac0911_7 {

	public static void main(String[] args) {
		// 程式要去應付使用者的要求 所以 程式會去開很多個處理程序 
		// 稱之為 fork(耙子) (想像 耙子的每個尖頭 都做一樣的事,就是分身的意思 )
		// zombie process(殭屍行程) 程序已結束了 但仍存在記憶體中 程式設計師 程式沒寫好
		
		// 一個程序會有多個執行緒 ?
		
		// 類別  要有 執行緒的生命特徵, 一定要繼承 Thread類別
		// 產生物件
		Brad681 obj1 = new Brad681("第A個物件");
		Brad681 obj2 = new Brad681("第B個物件");
		
		// 你可以去舞台旁邊等候   給CPU候選    不是程式設計師決定的  決定權在CPU手上
		// 睡醒後 一樣去舞台旁等候    給CPU候選
		obj1.start(); // 要表現出生命特徵  須呼叫start方法,所以這列執行下去 會有跑到 run() 函數
		//obj1.start(); // 因為 執行緒生命只有一條,所以start()太多次 會出現例外
		//obj1.start();
		
		obj2.start();
		// 加上 thread.sleep() 就可以很清楚的看到 obj1 obj2會同時執行 
		
		
	}// main

}// class
class Brad681 extends Thread
{	// Brad681為一個 thread
	// 表現在 override run方法內
	// TODO 10509111403 看一下老師怎看快捷鍵的
	private String name;
	Brad681(String name)
	{
		this.name = name;
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
				Thread.sleep(100); // 叫 thread睡0.1秒 
				// 有可能會在睡覺 途中 收到 Interrupte 所以須加例外
			} catch (InterruptedException e) {
				// 睡到一半被人吵醒  會來這
			}
		}
		//--------------執行緒生命結束 物件還在-----------
	} // run( )
	
}
