package tw.org.iii.classroom03;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class jPrac0911_5 extends JFrame{

	// 版面都在這裡設定
	
	// 這裡指是提供一個結構,這部份課的重點老師 放在 MyPainter.java
	private MyPainter painter;
	private JButton clear, undo, redo,save;
	public jPrac0911_5()
	{
		setLayout(new BorderLayout());
		
		// 上面配一個 JPanel
		clear = new JButton("clear");
		undo = new JButton("undo");
		redo = new JButton("redo");
		save = new JButton("save");
		JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT));
		top.add(clear);top.add(undo);top.add(redo);top.add(save);
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
		undo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自動產生的方法 Stub
				doUndo();
			}
		});
		redo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自動產生的方法 Stub
				doRedo();
			}
		});
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自動產生的方法 Stub
				doSave();
			}
		});
	}
	
	// 清除 是 MyPainter類別在做的
	private void doClear()
	{
		painter.clear();
	}
	private void doUndo()
	{
		painter.undo();
	}
	private void doRedo()
	{
		painter.redo();
	}
	private void doSave()
	{
		// http://stackoverflow.com/questions/5655908/export-jpanel-graphics-to-png-or-gif-or-jpg
		// 這段 是老師 示範 去 stackoverflow爬文時 順便 copy下來的程式碼段
		BufferedImage bi = new BufferedImage(
				painter.getSize().width, 
				painter.getSize().height, 
				BufferedImage.TYPE_INT_ARGB); 
		Graphics g = bi.createGraphics();
		//this.paint(g);  //this == JComponent
		// this指的是 jPrac0911_5類別  所以 轉成圖片時 連 Button也會存進去  因為 Button在jPrac0911_5類別內
		painter.paint(g); // 使用這列 存圖片時 就只會存 painter上的東西
		
		
		
		g.dispose();
		try
		{
			ImageIO.write(bi,"png",new File("dir1/test.png"));
			}
		catch (Exception e) 
		{}
	}
	public static void main(String[] args) {
		//  自動產生的方法 Stub
		new jPrac0911_5();
	} // void main()

} // class jPrac0911_5
