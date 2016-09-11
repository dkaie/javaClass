package tw.org.iii.classroom03;

import java.util.HashMap;

public class jPrac0911_6 {

	public static void main(String[] args) {
		// 自動產生的方法 Stub
//		HashMap<String,String> map = new HashMap<>();
//		map.put("username", "Brad");
//		map.put("stage", "3");
//		map.put("gender", "male");
//		System.out.println(map.get("username"));
		
		// 這樣寫是要搞得好像有陣列的感覺
		HashMap<Integer,String> map = new HashMap<>();
		map.put(0, "Brad");
		map.put(1, "3");
		map.put(7, "male");
		// 透過這方式 作一個mapping的對應   
		// 兩個參數 都要是物件  物件 對應到 物件
		System.out.println(map.get(7)); // 動靜態陣列 都無法像這樣叫用
		
	} // main

}
