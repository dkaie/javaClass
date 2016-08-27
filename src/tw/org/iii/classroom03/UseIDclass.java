package tw.org.iii.classroom03;

public class UseIDclass {

	public static void main(String[] args) {
		// TODO 自動產生的方法 Stub

		getVar();
		
		
		
	} // main()

	
	public static void getVar()
	{
		IDcard id1 = new IDcard(true , 7);
		System.out.println(id1.getId());
		
		if(IDcard.isRight(  id1.getId()  ))
		{
			System.out.println("OK");
		}
		else
		{
			System.out.println("XX");
		}
		
//		IDcard myId = new IDcard("A123456789");
//		IDcard urId = new IDcard("B234567890");
//		
//		System.out.println(myId.getId());
//		System.out.println(myId.getGender()?"男生":"女生");
//		System.out.println(urId.getId());
//		System.out.println(urId.getGender()?"男生":"女生");
	} // void getVar
	
	
	
	
} // class
