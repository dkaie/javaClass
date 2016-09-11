package tw.org.iii.classroom03;

public class jPrac0911_1 {

	public static void main(String[] args) {
		// 檔案尋訪 的 問題在  不知道何時才算找完     用遞迴  但判斷式沒做好會變無窮迴圈
		// 找是從目錄(資料夾)開始找   結束點是 沒有子目錄的結構
		// 如果找到 目錄(資料夾)  ,就呼叫 找目錄(資料夾)的程式碼段  (這動作就是遞迴)  ,否則就顯示 目錄類的檔案
		// 目錄結構的東西  呼叫 thisFile  
		
		// 上週課程複習
		// 只要是 Collection都可以 Foreach ?
		

	} // main

} // class

interface Brad641
{
	void m1();
}
interface Brad642 extends Brad641
{
	void m2();
}
interface Brad643 extends Brad641,Brad642
{	// 父類別只能繼承一個 ,但 介面可繼承多個
	void m3();
}
class Brad644 implements Brad643
{	// 強化有哪些東西我們必須去實作
	public void m1(){}
	public void m2(){}
	public void m3(){}
}

