package tw.org.iii.java2;

import tw.org.iii.classroom03.Bike;

// class的修飾字只有 public 和  不加存取修飾字 兩種

//              存取範圍大小							存取範圍大小
// public		全世界								大
// protected	相同package可存取，繼承之子類別也可以存取		中 稍大
// 沒有加存取修飾字	相同package可存取						中
// private		只有本類別可用							小

class testClass021 extends Bike
{
	// 因為 Bike2 的類別  為 "沒加存取修飾字" 又是在 不同package，所以無法繼承Bike2
	void myUpSpeed()
	{
		// super.upSpeed();
		upSpeed(); // 不加 super() 也可以
	}
}
class testClass022 extends testClass01 {

}