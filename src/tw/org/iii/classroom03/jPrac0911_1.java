package tw.org.iii.classroom03;

public class jPrac0911_1 {

	public static void main(String[] args) {

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

