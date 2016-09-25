package tw.org.iii.classroom03;

public class OCJP_41 {

	public static void main(String[] args) {
		// TODO 自動產生的方法 Stub
		Integer i1 = 128; // 在 127之前的數字 運算前後指標都會指向同一個位址  超過127  運算後 會指向 另一個位址
		// 這個和 String pull是很類似的觀念
		Integer i2 = i1;
		System.out.println(i1);
		System.out.println(i2);
		System.out.println(i1==i2);
		System.out.println(i1.equals(i2));
		
		i1++; i2++;
		System.out.println(i1);
		System.out.println(i2);
		System.out.println(i1==i2);
		System.out.println(i1.equals(i2));
	}

}
