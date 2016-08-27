package tw.org.iii.classroom03;

import javax.swing.JOptionPane;

public class GuessNumber {

	public static void main(String[] args) {
		// TODO 自動產生的方法 Stub
	
		// 產生謎底
		String answer = crateAnswer(3);
		System.out.println(answer);
		
		boolean isWINNER = false;
		for(int i=0; i<3; i++)
		{	// 迴圈3次 所以只能猜3次		
			// 開始猜
			String guess = JOptionPane.showInputDialog("猜吧");
			// showInputDialog會回傳使用者輸入的字傳給 字串變數guess
			
			//比對
			if(guess.equals(answer))
			{	// equals()在比對字串內的字元是否相同	
				// 對了 => 恭喜
				JOptionPane.showMessageDialog(null, "恭喜"); // 沒有父容器 所以填入null
				isWINNER = true;
				break;
			}
			else
			{	// 錯了 => 提示1A2B
				String result = checkAB(answer, guess);
				JOptionPane.showMessageDialog(null, guess+":"+result);
			}
			
		} // for
		if(!isWINNER)	JOptionPane.showMessageDialog(null, "hi 魯蛇 \n答案是"+ answer);
	} // main
	static String checkAB(String a, String g)
	{
		int A, B; A = B = 0;
		for(int i=0; i<g.length(); i++)
		{
			if(g.charAt(i) == a.charAt(i)) // 如果g中的第i碼 是否等於 a中的第i碼
			{
				A++;
			}
			else if( a.indexOf(  g.charAt(i)  ) != -1 ) // g中的第i碼存在於a字串中
			{	// java API文件中有說 indexOf找不到字串中的字元的話 會回傳 -1
				B++;
			}
		}
		return A + "A" + B +"B";
	} // static String checkAB(String a, String g)
	static String crateAnswer(int n)
	{	// 隨機產生n個數字
		// 加上static的方法   不是物件方法    為共同擁有的方法  105/08/21 15:05
		
		// 以下源自於撲克牌發牌程式的 洗牌程式碼段
		int[] poker = new int[n]; // 初值 全都為0
		int rand;
		boolean isOK = true;
		for(int i=0; i<poker.length; i++)
		{	// i表示發到第幾張牌
			
			//---------第2種檢查機制寫法    start----------
			do
			{	rand = (int)(Math.random()*10);
				//檢查機制
				for(int j=0; j<i; j++)
				{	// 假設i=7，表示發到第7張牌，這裡的迴圈就檢查0~6張牌
					isOK = true;
					if(poker[i] == rand)
					{
						isOK = false;
						break;
					}
				}
			}while(!isOK);
			
			poker[i] = rand;
		//	System.out.println(poker[i]); // 計算程式碼段 時 這邊先註解掉 因為 System.out也會耗時
		} // for(int i=0; i<poker.length; i++)
		String ret="";
		for(int v : poker) ret += v;
		// java方便的地方 電腦自己會 做完運算後 在幫你轉成字串加上去 你不用像C系列語言 還要數值轉字串
		// 任何資料 寫出來後 型別已經確定了 ==> 強型別 ?
		return ret ;
		// return "734";
	} // static String crateAnswer(int n)

} // class
