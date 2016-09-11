package tw.org.iii.classroom03;

import java.util.HashSet;
import java.util.LinkedList;

public class jPrac0911_2 {

	// 複習   泛型
	
	public static void main(String[] args) {
		//  動態陣列
		// 這個下去就是一個物件實體  會有函數  記憶體需載入函數
		HashSet<String> set = new HashSet<>();
		// 這個資料結構只能放什麼型別  一開始就講定
		set.add("Brad");
		
		LinkedList<Integer> list = new LinkedList<>();
		// 因為你給他泛型下去了  所以 只能 add整數型別
		list.add(12);
		
		// 靜態陣列
		//String[] a= new String[3];
				
	}// main
	


}

// 程式結構 都相同 只是型別不同 可用

//class Student
//{
//	Integer a,b,c;
//	Integer getScore()
//	{
//		return a+b+c;
//	}
//}

//class Student<E>
//{	//	 不一定要寫 E 其他 英文單字都可
//	E a,b,c;
//	E getScore()
//	{
//		return a+b+c;  // 這裡還要在做處理(好像是須處理回傳型別)
//	}
//}

class StudentV2
{
	Double a,b,c;
	Double getScore()
	{
		return a+b+c;
	}
}
