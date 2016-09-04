package tw.org.iii.classroom03;

import java.util.HashSet;

public class jPrac0904_6 {

	public static void main(String[] args) {
		// TODO 自動產生的方法 Stub
		Set_class_practice();
												
	} // main

	public static void Set_class_practice()
	{
		HashSet set = new HashSet();
		// 只能放物件 資料 不能放 基本型別
		set.add(12); //  12已經       整數 型別 auto-boxing 封箱成   new Integer的物件實體
		set.add("brad");
		set.add(12.3);
		set.add(12);
		set.add("brad");
		set.add(12);
		set.add(false);
		set.add("brad");
		set.add(new Bike());
		set.add(new Bike());
		System.out.println(set);
		System.out.println(set.size());
	} // Set_class_practice( )
	
	
} // class
