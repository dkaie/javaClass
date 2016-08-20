package tw.org.iii.classroom03;
import javax.swing.JOptionPane;

public class inputbox_Pract {

	public static void main(String[] args) {
		// TODO 自動產生的方法 Stub
		String strYear = 
				JOptionPane.showInputDialog("Year");
		String strMonth = 
				JOptionPane.showInputDialog("Month");
		int intYear = Integer.parseInt(strYear);
		System.out.println(intYear + "/" + strMonth);
	}

}
