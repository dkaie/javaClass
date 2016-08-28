package tw.org.iii.classroom03;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

// javaPrac0828_1 的物件實體 is a JFrame
// JFrame做出來的物件實體 is a avaPrac0828_1 ==> 這句是錯的 
// 以上概念是多型的概念

//javaPrac0828_1 的物件實體 have a JButton 物件實體? open save exit

public class javaPrac0828_1 extends JFrame implements ActionListener{

	private JButton open, save, exit;
	private JTextArea edit;
	private int count;
	
	// 子類別不寫建構子  會使用 父類別的 無傳參數建構子
	public javaPrac0828_1()
	{
		//"如果"建構子內啥都沒寫，則 第一列這裡藏了一個 super();
		super("My Window App");
		
		open = new JButton("Open"); // open是一個 Button物件，就是一個button的意思啦
		save = new JButton("Save");
		exit = new JButton("Exit");
		edit = new JTextArea(); // 要new出來 才有物件實體
		
		setLayout(new BorderLayout());
		JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT)); // 這只是個區域變數 無繼承 實作介面的關係 ?
		// 使用JPanel類別來 做版面配置
		
		// TODO 這裡不懂
		//setLayout(new FlowLayout()); // 方法(new出物件實體)
		//setLayout(new FlowLayout(FlowLayout.RIGHT)); // 靠右側
		//add(open); add(save); add(exit);
		
		top.add(open); top.add(save); top.add(exit);
		add(top, BorderLayout.NORTH);
		// 把 JPanel物件"top" 加入到視窗內(視窗是位在class javaPrac0828_1內嗎)，且擺設在北側(上面的意思)
		add(edit, BorderLayout.CENTER);
		
		setSize(640,480);
		setVisible(true); // 是否 看得見 視窗
		setDefaultCloseOperation(EXIT_ON_CLOSE); // 結束程式，不執行這列 視窗式會消失沒錯 但還在記憶體內跑
		
		open.addActionListener(this); // 我本人來幫你聽 聽到後 觸發actionPerformed方法
		// 增加一個傾聽動作 的方法(隨時監控的意思?)
		save.addActionListener(this); 
		open.addActionListener(new MyListener()); // 寫在外部的類別
		open.addActionListener(new tw.org.iii.classroom03.MyListener());//內部類別
		// 這個是指  tw.org.iii.classroom03 package 內的 javaPrac0828_1.java的外部類別MyListener
		open.addActionListener(new ActionListener() {
			// 內部類別
			// 我寫一個類別 讓他去實作 你再把他new出來
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自動產生的方法 Stub
				doOpen();
			}
		});
		// 當場在這裡 產生一個 有實作介面的物件實體
		
	} // 建構子
	
	// 因為他是內部類別 可以存取外部類別的屬性和方法 寫到這裡來叫好維護
	private void doOpen()
	{
		System.out.println("InnerListener。當場在這裡 產生一個 有實作介面的物件實體");
	}
	
	
	public static void main(String[] args) {
		// TODO 自動產生的方法 Stub
		// 因為它本身是static? 所以自己會去做一個載入的動作(載啥?)
		
		// TODO 這裡不懂
		new javaPrac0828_1();
	} // main

	

	
	//內部類別最接近 主類別? 所以會先呼叫 內部類別MyListener 沒有在去叫外部類別MyListener
	
	//---------- 內部類別(start) --------------
	class MyListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自動產生的方法 Stub
			System.out.println("MyListener 內部類別被呼叫 + "+count++);
			// 內部類別 可存取外部類別的屬性和方法
		}	
	} // class MyListener
	//---------- 內部類別(end) --------------
	
	
	// 這個函數 是因為 要用到 button的 addActionListener方法
	// ，而addActionListener方法 需要 主類別 去implements ActionListener介面
	// ，而ActionListener介面 的實作 是靠actionPerformed方法
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO 自動產生的方法 Stub
		// ActionEvent宣告出的 event 可以判斷 是哪個物件 叫用了這個方法
		//if(event.getSource() == open)
		if(event.getSource().equals(open)) // 只要是物件 都可以使用 equals()方法
			System.out.println("open");
		//else if(event.getSource() == save)
		else if(save.equals(event.getSource()))
			System.out.println("save");
	}

} // class javaPrac0828_1


class MyListener implements ActionListener
{
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自動產生的方法 Stub
		System.out.println("MyListener 外部類別被呼叫 +");
		// 如果這個類別想存取 別人類別的屬性或方法 只能靠參數傳遞來達成
	}	
} // class MyListener





