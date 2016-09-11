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
	public CalculateRacing() {
	
		
		setLayout(new GridLayout(9,1));
		
		add(go = new JButton("GO!"));
		lanes = new JLabel[8];
		for(int i =0; i< lanes.length; i++)
		{
			add(lanes[i] = new JLabel((i+1)+"."));
		}
		
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
		// 把他們叫初 來 在起跑點 等候CPU來執行你
		Car[] cars = new Car[8];
		
		// 底下的迴圈就算寫在一起 也不會有 說 先到跑到 先起跑的問題
		
		
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
			{
				lanes[whichLane].setText
						(
								lanes[whichLane].setText() + ">"
						); // 一次畫一點
			}
		} // void run()
		
	} // class Car
	public static void main(String[] args) {
		
		new CalculateRacing();
	}

} // class CalculateRacing
