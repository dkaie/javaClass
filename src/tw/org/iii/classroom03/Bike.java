package tw.org.iii.classroom03;
// Object-oriented practice
public class Bike {
	// 類別不是讓你去執行的 類別是在定義的
	
	// Field
	private double speed; // 把屬性設為私有的 封裝起來
	
	// 慣例 : 通常建構式會定義在屬性和其他的方法之間
	//Constructor
	Bike()
	{	// java的建構式 沒有傳回值 所以不須加 void
		//，如果加上 void則變成一個和建構式相同名稱的普通方法
		// 建構子的名稱和類別名稱一模一樣(大小寫嚴格區分 所以要相同)
		speed = 1;
		System.out.println("Bike():"+speed);
		// 如果沒寫建構式，會用父類別預設的建構式
		// 建構式只有在new的當時被做一次，之後不會在被叫到
		// 建構式 通常用來處理物件的初始屬性
	}
	
	// Method
	void upSpeed()
	{
		speed = speed<1?1:speed*1.2;
//		if(speed<1) speed=1;
//		else		speed=speed*1.2;
	}
	// 函數命名慣例 : 動詞 介係詞 小寫 寫前面  名詞?首字大寫
	void downSpeed()
	{
		speed = speed<1?1:speed*0.7;
	}
	
	double getSpeed()
	{	// 想存取已被封裝的屬性 可透過方法
		return speed;
	}
	
	// 加上這段後 直接 print 物件 ，不會印出 物件在記憶體的位址 反而會印出這段回傳的字串
	// 這段有一大部份源自於 String類別中的 toString()方法
	@Override
	public String toString()
	{
		return"hello bike";
	}
	
} // class Bike
