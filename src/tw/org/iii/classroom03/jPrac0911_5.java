package tw.org.iii.classroom03;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class jPrac0911_5 extends JFrame{

	// 版面都在這裡設定
	
	// 這裡指是提供一個結構,這部份課的重點老師 放在 MyPainter.java
	private MyPainter painter;
	private JButton clear;
	public jPrac0911_5()
	{
		setLayout(new BorderLayout());
		
		// 上面配一個 JPanel
		clear = new JButton("clear");
		JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT));
		top.add(clear);
		add(top, BorderLayout.NORTH);
		
		painter = new MyPainter();
		add(painter, BorderLayout.CENTER);
		
		setSize(800,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setupEvent();
	}
	private void setupEvent()
	{
		clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自動產生的方法 Stub
				doClear();
			}
		});
	}
	
	// 清除 是 MyPainter類別在做的
	private void doClear()
	{
		painter.clear();
	}
	public static void main(String[] args) {
		//  自動產生的方法 Stub
		new jPrac0911_5();
	} // void main()

} // class jPrac0911_5
