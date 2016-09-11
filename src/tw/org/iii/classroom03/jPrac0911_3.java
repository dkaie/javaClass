package tw.org.iii.classroom03;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;

public class jPrac0911_3 {

	public static void main(String[] args) {
		//  自動產生的方法 Stub
		String answer = createAnswerV2(4);
		System.out.println(answer);	
		} // main
	
	static String createAnswer(int n)
	{
		
		// 利用 Set 不重複 沒有順序性(不代表亂數)的特性  作猜數字遊戲 產生 4位數 不重複的謎底 字串
		
		HashSet<Integer> set = new HashSet<>();
		while(set.size() < n)
		{
			set.add((int)(Math.random()*10));
		}
		StringBuffer sb = new StringBuffer(n); // 你不指定量  電腦預設給你16的capacity 但沒用到就浪費了
		// 已經泛型整數了 所以 foreach內就是整數
		for(Integer i:set) sb.append(i);
		return sb.toString();
	} // createAnswer(int n)
	
	
	//----------- 測試使用 Collections類別的 static shuffle方法 ----------------
	static String createAnswerV2(int n)
	{
		LinkedList<Integer> list = new LinkedList<>();
		for(int i=0 ; i<10; i++) list.add(i);
		// list.add(i,i)  可以這樣寫@@ ?  第0碼放第0個位置,第1碼放第1個位置  ?
		
		Collections.shuffle(list);
		StringBuffer sb = new StringBuffer(n);
		
		for (int i=0;i<n ;i++) sb.append(list.get(i));
		return sb.toString();
	} // createAnswerV2(int n)
} // class
