package tw.org.iii.classroom03;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

public class jPrac0904_6 {

	public static void main(String[] args) {
		// 
		//Set_class_practice();
		List_class_practice();
											
	} // main

	
	public static void List_class_practice()
	{
		// 如果要操作的元素 常常 作 新增 移除  使用 LinkList類別
		// 元素放上去後 不太會異動 用 ArrayList類別 可以異動 但效能不會較佳
		LinkedList list = new LinkedList();
		list.add(12);
		list.add("brad");
		list.add("brad");
		list.add(12);
		list.add(2,"iii"); // 排在 第2個位置 其他人須往後退
		//list.add(7,34); // 如果 list 的大小只有5 你要放到第7個位置  會拋出 index超出範圍的例外
	
		System.out.println(list.size());
		System.out.println(list);
		System.out.println(list.get(4)); // 取得第4個元素的資料
		list.remove(4); // 拿掉第4個元素的資料
		System.out.println(list);
		
		System.out.println("--------------以下是老師有叫我們寫 但他沒寫的-----------------");
		for(Object obj : list)
		{	// foreach適合 那種 你不知道有多少空間 但全部跑光光
			System.out.println(obj.toString());
		}
		
	}
	
	public static void Set_class_practice()
	{
		//HashSet set = new HashSet(); // 不會排序
		
		TreeSet set = new TreeSet(); // 會排序
		// 如果放入 不同型別 的物件進去  他會不能排序  轉型失敗   拋出例外  
		
		//
		
		// 只能放物件 資料 不能放 基本型別
//		set.add(12); //  12已經       整數 型別 auto-boxing 封箱成   new Integer的物件實體
//		set.add("brad");
//		set.add(12.3);
//		set.add(12);
//		set.add("brad");
//		set.add(12);
//		set.add(false);
//		set.add("brad");
//		set.add(new Bike());
//		set.add(new Bike());
		
		//產生樂透號碼
		while(set.size() < 6)
		{
			set.add((int)(Math.random()*49+1));
		}
		// 應用 Set類別不重複的特性 產生 任意六個 1~49的數字
		
		System.out.println(set);
		System.out.println(set.size());
		System.out.println("---------拿出元素 1--------------");
		
		Iterator it = set.iterator(); // 這就是迭代這好像會把資料 從Set 一個接一個拉出來  拿到Iterator的物件實體
		while( it.hasNext() ) // 看看有沒有下一個
		{
			Object obj = it.next(); // 跑完這列 物件也不能用了  通常會再把 物件null掉 (因為資料被拿完了? 還是因為指標 指不回來?)
			System.out.println((Integer)obj); // 因為上面寫 產生 樂透號碼的 程式 我們知道 是 int 所以這裡把它轉型成Integer
		}
		
		System.out.println("----------拿出元素 2-------------");
		for(Object obj: set)
		{
			System.out.println((Integer)obj);
		}
		
		
		
	} // Set_class_practice( )
	
	
} // class
