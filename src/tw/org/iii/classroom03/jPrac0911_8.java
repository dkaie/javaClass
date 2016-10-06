package tw.org.iii.classroom03;

import java.util.Timer;
import java.util.TimerTask;

public class jPrac0911_8 {

	// 一個 timer 可以做多個任務
	
	// 1050911 15:43    錄影檔時間 2:23:52
	
	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new MyTask1(), 3000); // 3秒後執行
		// 這種工作 排在 背景執行緒 去做 所以通常不會結束?
		
		timer.schedule(new MyTask2(timer), 1000,1000); // 第一次1秒 之後 每間隔1秒做一次

	}// main

}// class
class MyTask1 extends TimerTask
{

	@Override
	public void run() {
		System.out.println("MyTaks1");
		
	}
	
}// class MyTask1
class MyTask2 extends TimerTask
{
	private int i;
	private Timer timer;
	MyTask2(Timer timer){this.timer = timer;}
	@Override
	public void run() {
		System.out.println("MyTaks2"+i++);
		if(i>10)
			timer.cancel();// 不呼叫cancel()的話 會被認為是在執行中 即使根本沒在工作
			// TimerTask 可已取消各自單獨的任務
	}
	
}// class MyTask1
