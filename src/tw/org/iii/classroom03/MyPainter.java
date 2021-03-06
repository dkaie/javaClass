package tw.org.iii.classroom03;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.JPanel;

//public class MyPainter extends JPanel implements MouseListener,MouseMotionListener
public class MyPainter extends JPanel {
	//我繼承他 所以我也是視窗元件
	// TODO (已聽過)這段有得聽了 1050911 10:12~10:23  (大約是錄影檔的 1:09:28)
//	private LinkedList<HashMap<String,Integer>> line; // 這個只能存取 一條線上所有的點
	private LinkedList< LinkedList<HashMap<String,Integer>> > lines , recycle; // 這個才能存取 兩條線
	
	// TODO homework
	// homework : 把這裡存成 物件序列化   lines可以序列化  下次叫進來時 可以 undo 和redo動作   因為他是物件
	// 如何做 物件的指標 指向動作
	
	// 座標點 用 Hash value來代表 x y
	// 拿一個資料結構 準備做後續的事
	
	public MyPainter()
	{
		//super();
		// setBackground(Color.yellow); // 這個是老是用來測試  可改變 java視窗的背景顏色用的
		System.out.println("測試看建構子有沒有執行 這段是要配合測試看 PaintComponent有沒有自動執行");
		MyAdapter adapter = new MyAdapter(); // 針對滑鼠點下去取處理事情

		
		// addAncestorListener(listener) 前面的課 是用來偵測 按鈕(是指Button元件嗎?)按下去的動作 
		// 這堂課是希望偵測 滑鼠的動作
		// 因為這個類別繼承自 JPanel(這傢伙好像是在管 java window Form 有關的東西)
		// 所以老師教說我們要自己去 查java API 內的 JPanel那篇
		// 結果在 祖父類別 找到 addMouseListener()這個跟滑鼠有關的函數 
		
	//	addMouseListener(this);
	//	addMouseMotionListener(this); // 自己聽
		
		addMouseListener(adapter);
		addMouseMotionListener(adapter);
		
		lines = new LinkedList<>();
		recycle = new LinkedList<>();
	} // 建構子
	
	// Button 是 override過來的    所以大家的按鈕都是長那個樣子
	
	
	// 不是因為呼叫super(),所以 paintComponent() 才會執行       
	// paintComponent() 是一個 Component  父類別 在定義的時候   就去執行了他的畫面的長相 
	// 所以paintComponent() 我們沒呼叫 他也會自動去執行 ???

	@Override
	protected void paintComponent(Graphics g)
	{	// 元件外觀的呈現
		// 畫面的動作? 呈現?
		
		// 輸入參數是 父類別定義的   會傳遞一個 Graphics 的物件實體(繪圖的物件實體)
		
		// XXX 他是車子 骨子裡是法拉利  不轉型回來 會沒辦法用到這麼多的功能
		
		// java的官方文件表示  Graphics傳遞進去的 骨子裡是個 Graphics2D
		// 所以可以再用他之前 先轉型回來
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		
		// System.out.println("測試看我們沒呼叫 這段會不會自己出現");
		
		g2d.setColor(Color.BLUE);
		
		// 測試可否畫出圓
//		g2d.fillOval(0, 0, 30, 30);  // 前兩個為圓 被方形框起來  方形 在 視窗左上角的座標位置
//		g2d.drawOval(100,100,30,30);
		
		g2d.setStroke(new BasicStroke(4)); // 畫筆 4的粗細
		
		for(LinkedList<HashMap<String, Integer>> line: lines)
		{
			// 去查 lines 的相關程式碼段  lins可以有好幾條線
			
			for( int i=1; i<line.size(); i++ )
			{	//	 因為畫線段 所以從1開始計數  等一下 再作減1
				
				// 只有這個迴圈 只能有一個 畫線的空間 從頭畫到尾
				
				// 拿回 x y 點?
				HashMap<String, Integer> p0 = line.get(i-1); // 畫線段 起點
				HashMap<String, Integer> p1 = line.get(i); // 畫線段 終點
				int p0x = p0.get("x"), p0y = p0.get("y");
				int p1x = p1.get("x"), p1y = p1.get("y"); 	
				g2d.drawLine(p0x, p0y, p1x, p1y);		
			} // for
		} // for each
	} // void paintComponent()

	// 一個類別為抽象類別 但不一定要有 抽象方法  你找我建構 物件實體 你無聊  我期待子類別出現  你想override的自己去做
	// 但有 抽象方法的類別 必須為抽象類別

	// 這段是 implements MouseListener後 會出現紅色 底線 游標移到底線那裡 會跳出框框  選  叫電腦幫我們
	// 實作 未寫的 方法 ,然後就會跳出底下這堆了
//	@Override
//	public void mouseClicked(MouseEvent e) {	
//		System.out.println("Clicked"); // 滑鼠按下 移動(這樣就有改變位置的情況發生) 在放開 就不算 click
//	}
//	@Override
//	public void mouseEntered(MouseEvent e) {	
//	}
//	@Override
//	public void mouseExited(MouseEvent e) {	
//	}
//	@Override
//	public void mousePressed(MouseEvent e) {
//		System.out.println("Pressed");
//	}
//	@Override
//	public void mouseReleased(MouseEvent e) {	
//		System.out.println("Released");
//	}
//
//
//	@Override
//	public void mouseDragged(MouseEvent arg0) {
//		System.out.println("Dragged");
//	}
//	@Override
//	public void mouseMoved(MouseEvent arg0) {
//		System.out.println("Moved");	// 游標移動 他就抓取
//	}
	
	void clear()
	{
		lines.clear(); // 讓記憶體內沒有線可畫
		repaint(); // 把版面清乾淨
	}
	
	
	void undo()
	{	// 上一步
		
		// 當我要畫一條新線的時候 recycle內的東西要清掉,老師沒示範 叫我們自己寫
		
		if(lines.size() > 0)
		{
			recycle.add( lines.removeLast() ); // lines丟掉 recycle撿起來
			repaint();
		}
	}
	void redo()
	{	// 下一步
		
		// 當我要畫一條新線的時候 recycle內的東西要清掉,老師沒示範 叫我們自己寫
		
		if(recycle.size() > 0)
		{
			lines.add( recycle.removeLast() ); // recycle丟掉 lines撿起來
			repaint();
		}
		
	}
	private class MyAdapter extends MouseAdapter
	{	// java有  MouseAdapter的類別  這裡老師自己製作 這個類別
		// Adapter譯為變壓器 AC轉DC 所以這個 類別有轉換東西的意義
		
		@Override
		public void mouseDragged(MouseEvent e) {
			// 
			super.mouseDragged(e);
			//System.out.println("Dragged: "+e.getX()); // 測試 這個方法是否有效
			addPoint(e);
			// TODO (已解決)這裡聽一下 10509111143
			repaint(); // 做重畫的動作 第二個點要做repaint 
						// ,repaint()函數  是  MyPainter(JPanel)的方法  
						// ,而目前所位在的昰MouseAdapter類別,之所以可以叫用這個方法
						// ,是因為內部類別方便存取外部類別的屬性和方法
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// 
			super.mousePressed(e);
			
			// 按下滑鼠的同時  新增一個 可以儲存 畫一條線所需點 的空間	
			LinkedList<HashMap<String, Integer>> line = new LinkedList<>();
			lines.add(line);
			
			addPoint(e);
			
		}
		
		// 
		
		private void addPoint(MouseEvent e)
		{
			// 一個點是一個 HashMap ??
			HashMap<String,Integer> point = new HashMap<>();
			//point是區域變數 只活在這
			point.put("x", e.getX());
			point.put("y", e.getY());
			//line.add(point); // 把一個點指向過去  我就擁有一個點 ???
			
			// 把點加到 全部線裡面的最後那條線( LinkedList<HashMap<String, Integer>> )
			lines.getLast().add(point);
		}
		
	} // class MyAdapter
	
//	private class MyPoint
//	{	//  這個只是老師的初步想法 沒有要用  老師要用其他方法來做這件事
//		private int x,y;
//		void setXY(int   x ,int y)
//		{
//			this.x = x; this.y = y;
//		}
//	}
	
	
} // class MyPainter
