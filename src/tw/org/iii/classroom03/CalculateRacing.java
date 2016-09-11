package tw.org.iii.classroom03;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CalculateRacing extends JFrame{
	// 文字版 的 賽馬  : 具有生命特徵的 多個執行緒  表現出來
	
	private JButton go;
	private JLabel[] lanes;
	private int rank;
	private Car[] cars;
	public CalculateRacing() {
	
		
		setLayout(new GridLayout(9,1));
		
		add(go = new JButton("GO!"));
		lanes = new JLabel[8];
		for(int i =0; i< lanes.length; i++)
		{
			add(lanes[i] = new JLabel((i+1)+"."));
		}
		
		// 多個執行緒 有同時執行的感覺
		
		setSize(1024,480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		go.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自動產生的方法 Stub
				go();
			}
		});
	}
	private void go()
	{
		rank =1;
		// 把他們叫初 來 在起跑點 等候CPU來執行你
		cars = new Car[8];
		
		// 底下的迴圈就算寫在一起 也不會有 說 先到跑到 先起跑的問題
		
		//清跑道
		for(int i =0; i< lanes.length; i++)
		{
			lanes[i].setText((i+1)+".");
		}
		
		for(int i =0; i<cars.length; i++)
			cars[i] = new Car(i); // 哪台車就在哪一道
		
		for(int i =0; i<cars.length; i++)
			cars[i].start();
	}
	private class Car extends Thread
	{
		private int whichLane;
		Car(int n )
		{
			whichLane = n;  // 哪台車在 哪條跑道 在建構子中決定
		}
		// TODO 10509111436 怎麼快捷鍵 ?
		@Override
		public void run()
		{
			for(int i=0 ; i< 100; i++)
			{	// i=99是做最後一步
				lanes[whichLane].setText(
					lanes[whichLane].getText() + ">" ); // 一次畫一個">"符號
				if(i==99)
				{
//					lanes[whichLane].setText(
//							lanes[whichLane].getText() + rank++ ); // 跑到終點後顯示名次
					lanes[whichLane].setText(
							lanes[whichLane].getText() + "WINNER" );
					stopGame();
					break; // 對 第1名的執行緒 做 break
				}
				try {
					//Thread.sleep(50+(int)(Math.random()*150)); // 範圍在50~190之間
					Thread.sleep((int)(Math.random()*200)); // 範圍在0~200之間
				} catch (InterruptedException e) {
					break; // 對第2名以後的執行緒做 break
				}
			} // for
			
		} // void run()
		
	} // class Car
	private void stopGame()
	{
		for(int i=0;i<cars.length; i++)
		{
			cars[i].interrupt(); // 下中斷 訊號 不讓其他執行緒 跑 
		}
	}
	public static void main(String[] args) {
		
		new CalculateRacing();
	}

} // class CalculateRacing
