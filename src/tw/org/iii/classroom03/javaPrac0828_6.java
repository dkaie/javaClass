package tw.org.iii.classroom03;

public class javaPrac0828_6 {

	public static void main(String[] args) {
		// TODO 自動產生的方法 Stub

	}

}

class Brad381
{	// 父類別他的方法 存取修飾字
	
	//              存取範圍大小							存取範圍大小
	// public		全世界								大
	// protected	相同package可存取，繼承之子類別也可以存取		中 稍大
	// 沒有加存取修飾字	相同package可存取						中
	// private		只有本類別可用							小
	
	private void m1(){}
}
class Brad382 extends Brad381
{
	public void m1()
	{
		//super.m1();	
	} // 子類別m1()方法的修飾字 存取範圍 必須比父類別m1()方法的範圍大
	
	// override : 方法的  名稱 輸入參數個數 都一樣
}


