package tw.org.iii.classroom03;

public class testException {

	public static void main(String[] args) {
		// 
		// 可被拋出來的東西有兩種  error & Exception
		// error 可被丟出 但無法處理 ??
		
		// 例外分兩大類
		// RuntimeException 執行階段的例外   執行階段才會發生
		// Checked Exception(這個英文只是個名稱 ) 事先檢查好的例外     非 Runtime  隨時都有可能發生      所以在coding就要預防
		
		int a = 10, b = 0;
		int[] c = {1, 2, 3};
		try
		{
			System.out.println(  a / b  );
			System.out.println( c[3] );
		}
		catch(ArithmeticException ae)
		{	// 如果有 數學列外發生 ae物件 會捕捉到 
			// 會重發生例外 的那列 程式碼 拋出例外 而 那列以下的程式碼就不會被執行了
			System.out.println("發生ArithmeticException");
			// 例外的子類別在程式碼中要在父類別之前
		} // catch ArithmeticException
		catch(ArrayIndexOutOfBoundsException e2)
		{
			System.out.println("發生ArrayIndexOutOfBoundsException");
			// 例外的子類別在程式碼中要在父類別之前
			// ArithmeticException類別 和 ArrayIndexOutOfBoundsException類別是旁系親屬關係
			// 
		} // catch ArrayIndexOutOfBoundsException
		catch(RuntimeException re)
		{	// 只要是執行階段發生的例外狀況 管他是 數學還是陣列的例外 這邊都會捕捉
			// 但會沒辦法很精確的知道 是發生哪一型的例外
			System.out.println("發生RuntimeException");
			// 例外的父類別在程式碼中要殿後
		}

		// 例外捕捉完了 沒事了 繼續跑下一列程式碼
		System.out.println("OK");
	} // main
}
