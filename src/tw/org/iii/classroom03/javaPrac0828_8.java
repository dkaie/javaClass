package tw.org.iii.classroom03;

//呼叫的堆疊觀念 call stack
public class javaPrac0828_8 {

	public static void main(String[] args) 
	{
		// TODO 自動產生的方法 Stub
		Brad433 obj1 = new Brad433();
		// step 4. 因為用到Brad433類別 所以 main() 也須處理 throw的情況
		// 法1     如果在 main 後 接上 throws Exception也可  JVM會處理   較沒人這樣用
		// 法2     加上 try catch
		try{
		obj1.m3();
		}catch(Exception e){}
		
	}
}
class Brad431
{
	void m1() throws Exception
	{	// step 1. 這個範例的源頭算是在這  因為有拋出例外 所以 函數 須宣告例外
		throw new Exception();
	}
}
class Brad432 extends Brad431
{
	void m2() throws Exception
	{	// step 2. 因為 叫用了父類別的 方法   所以 子類別的 函數 須跟者宣告例外
		m1();
	}
}
class Brad433 extends Brad432
{
	void m3() throws Exception
	{	// step 3. 因為 叫用了父類別的 方法   所以 子類別的 函數 須跟者宣告例外
		m2();
	}
}

