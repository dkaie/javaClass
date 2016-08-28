package tw.org.iii.classroom03;

public class javaPrac0828_3 {

	public static void main(String[] args) {
		// TODO 自動產生的方法 Stub
		
		// String 這個 東西 比較特別 可不new 直接 送 雙引號進 變數
		// String 會有一個叫 String Pool的東西 ，只要看到雙引號，叫把雙引號夾的字串 丟到 String Pool
		// ，

		
		String a = "Brad";
		String b = "Brad";
		String c = new String("Brad");
		String d = new String("Brad");
		
		// 比物件的話 用 等號 做相比 ，在String類別內 equals()方法已經被改寫程 用來比字串是否相等 而非物件是否相等
		
		if(a.equals(c))	System.out.println("OK");
	//	if(a == b)	System.out.println("OK");
		else		System.out.println("XX");
	}

}
