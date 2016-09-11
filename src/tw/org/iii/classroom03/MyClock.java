package tw.org.iii.classroom03;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

public class MyClock extends JLabel{
	
	// 時間週期       時間到了要做甚麼事       時間控制交給timer
	
	private Timer timer;
	public MyClock()
	{
		timer = new Timer();
		timer.schedule(new MyTask(), 0,500); // 0.5秒做一次
	} // 建構子
	
	private class MyTask extends TimerTask
	{
		@Override
		public void run() {
			// 時間到了就做事
			Calendar now = Calendar.getInstance();
			int hh = now.get(Calendar.HOUR_OF_DAY);
			int mm = now.get(Calendar.MINUTE);
			int ss = now.get(Calendar.SECOND);
			setText(hh+":"+mm+":"+ss);
		}
		
	} // class MyTask
} // class MyClock

