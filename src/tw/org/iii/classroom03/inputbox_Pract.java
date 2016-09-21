package tw.org.iii.classroom03;
import javax.swing.JOptionPane;

public class inputbox_Pract {

	public static void main(String[] args) {
		
		// 輸入對話盒 練習
		
		String	strYear	 = JOptionPane.showInputDialog("Year");
		String	strMonth = JOptionPane.showInputDialog("Month");
		int		intYear	 = Integer.parseInt(strYear);
		// parseInt( )
		// 將字元串參數作為有符號的十進制整數進行解析。
		// 除了第一個字元可以是用來表示負值的 ASCII 減號 '-' ('\u002D') 外
		// ，字元串中的字元都必須是十進制數字。返回得到的整數值
		// ，就好像將該參數和進制 10 作為參數賦予 parseInt(java.lang.String, int) 方法一樣。 
		
		System.out.println(intYear + "/" + strMonth);
	}

}
