package tw.org.iii.classroom03;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

// javaPrac0828_1 的物件實體 is a JFrame
// JFrame做出來的物件實體 is a avaPrac0828_1 ==> 這句是錯的 
// 以上概念是多型的概念

//javaPrac0828_1 的物件實體 have a JButton 物件實體? open save exit

public class javaPrac0903_1 extends JFrame {

	private JButton open, save, exit;
	private JTextArea edit;
	
	//TODO 這裡聽一下 錄影  10509031338
	private File openFile;
	
	// 子類別不寫建構子  會使用 父類別的 無傳參數建構子
	public javaPrac0903_1()
	{
		//"如果"建構子內啥都沒寫，則 第一列這裡藏了一個 super();
		super("My Window App");
		
		open = new JButton("Open"); // open是一個 Button物件，就是一個button的意思啦
		save = new JButton("Save");
		exit = new JButton("Exit");
		edit = new JTextArea(); // 要new出來 才有物件實體
		
		JScrollPane jsp = new JScrollPane(edit); // 自己去看 API  JScrollPane有一個建構子的輸入參數是給你放 元件的
		// JScrollPane 可以有 Scroll Bar的功能
		// 老師說不要用 JScrollBar 因為你用了就得自己去關聯  ScrollBar拖曳到哪 資料顯示到哪
		
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
		add(jsp, BorderLayout.CENTER);
		
		open.addActionListener(new ActionListener() {
			// 內部匿名實作該介面的物件實體 把該方法實作出來
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自動產生的方法 Stub
				doOpen();
			}
		});
		
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自動產生的方法 Stub
				doSave();
			}
		});
		
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自動產生的方法 Stub
				doExit();
			}
		});
		
		setSize(640,480);
		setVisible(true); // 是否 看得見 視窗
		setDefaultCloseOperation(EXIT_ON_CLOSE); // 結束程式，不執行這列 視窗式會消失沒錯 但還在記憶體內跑
			
	} // 建構子
	private void doExit()
	{
		
	}
	private void doSave()
	{
		if( openFile != null )
		{
			try {
				FileWriter writer = new FileWriter(openFile);
				
				writer.write(edit.getText());
				
				writer.flush();
				writer.close();
				//JOptionPane  save OK
			} catch (IOException e) {
			}
		}
	} // doSave
	private void doOpen()
	{
		JFileChooser jfc = new JFileChooser();
		if( jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION )
		{	// 判斷有沒有 選擇檔案
			// showOpenDialog方法   會回傳 int 以表示 檔案選擇的狀況   所以 APPROVE_OPTION 應該是類似像 列舉 那樣的格式
			// showOpenDialog方法 的輸入參數 好像是填入父容器
			// 這個是java自己做的OpenDialog
			// 要微軟的OpenDialog 也可以呼叫 Windows的API
			openFile = jfc.getSelectedFile(); // 這傢伙 好像 自己會去接收 看 JFileChooser回傳的東西 ?  
			//System.out.println(openFile.getAbsolutePath());
			readFile();
		}
	} // doOpen( )

	private void readFile()
	{
		try {
			FileReader reader = new FileReader(openFile);
			
			int c;
			while( (c = reader.read()) != -1 )
			{
				edit.append("" + (char)c);
			}
			reader.close();
		} catch (Exception e) {

		}
	}
	public static void main(String[] args) {
		// TODO 自動產生的方法 Stub
		// 因為它本身是static? 所以自己會去做一個載入的動作(載啥?)
		
		// TODO 這裡不懂
		new javaPrac0903_1();
	} // main

	
} // class javaPrac0828_1








