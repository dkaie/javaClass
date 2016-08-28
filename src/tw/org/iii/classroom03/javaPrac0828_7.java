package tw.org.iii.classroom03;

import java.lang.instrument.IllegalClassFormatException;

import javax.xml.datatype.DatatypeConfigurationException;

import sun.security.util.PropertyExpander.ExpandException;

public class javaPrac0828_7 {

	public static void main(String[] args) {
		// TODO 自動產生的方法 Stub
		Bird b1 = new Bird();
		try
		{
			b1.setLeg(12);
			System.out.println(b1.leg);
		}
		catch(RuntimeException re)
		{
			System.out.println("鳥不可能超過2隻腳");
		}
		
		Brad421 obj1 = new Brad421();
		try		{		obj1.m1(2);		}
		catch(IllegalClassFormatException ie)	{		}
		catch(DatatypeConfigurationException de)	{		}
		
		Brad422 obj2 = new Brad422();
		obj2.m1(0);
		
		
	} // main
} // class

class Bird
{
	int leg;
	void setLeg(int n)
	{
		if(n < 0 || n > 2)
			throw new RuntimeException(); // 拋出例外      throw-->拋的意思
		leg = n;
	}
} // class

class Brad421
{
	void m1(int n) throws IllegalClassFormatException, DatatypeConfigurationException
	{ 	// 使用 throw來處理例外  須先說明會拋出什麼樣的例外
		// 宣告的會加s   throws    用來拋的沒加s throw
		if(n<0)
		{
			throw new IllegalClassFormatException();
		}
		else if(n > 100)
		{
			throw new DatatypeConfigurationException();
		}
	} // void m1()
} // class
class Brad422 extends Brad421
{	// override 覆寫?  : 父子類別 方法的 名稱 輸入參數 相同?
//	void m1(int n) throws IllegalClassFormatException, DatatypeConfigurationException,ExpandException
//	{	// override 子類別拋出的例外   父類別沒定的例外自己不能亂創   且例外數量 須比父類別 小於等於 甚至沒有
//		//super.m1(2);  // 有這列  子類別一定要加例外?
//	}
	
//	try{}
//	catch(){}
	
//	try{}
//	catch(){}
//	finally{}   // finally在做結構收尾的事
	
//	try{}
//	finally{}
	void m1(int n) 	
	{
		int a = 10, b = 0;
		try
		{
			int c = a/b;
			//return;  // 讀到 return 好像是因為 會回傳 參數 所以 在這列 好像就會跳出函數 以下的不做
		}
		catch(RuntimeException re)
		{	
			System.out.println("catch");
			//return;
		}
		finally
		{
			// 確保整個結構 的完整性  確保最後要做的事一定會被執行  在離開(函數?)之前一定要做的動作
			System.out.println("final");
		}
		System.out.println("OK");
	}
} // class



