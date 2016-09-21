package tw.org.iii.classroom03;

import java.util.Arrays;

public class ArrayPractiec02 {

	public static void main(String[] args) {

		//ArrayIndexTypeTest();		// 一些陣列的規則說明//
		//MultyDimensionArray();	// 多維陣列
		//TwoDimensionArray();		// 二維陣列
		//foreachPractice01();		// for each
		pokerShuffle();				// XXX 撲克牌 洗牌 發牌(for迴圈版)
		//---------------1050821 AM-------------------
		ForWhilePractice();			// while練習
			
	} // main
	public static void ForWhilePractice()
	{
		int i=0, sum=0, n = 100 ;
//		while(i<10)
//		{
//			System.out.println(i++);
//		}
//		
//		for(;i<10;)
//		{
//			System.out.println(i++);
//		}

		while(i<=n)
		{
			sum+=i++;
		}
		System.out.println("1+2+3+...+n = "+sum);
			
	} // ForWhilePractice()
	
	public static void pokerShuffle()
	{
		int[] poker = new int[52]; // 初值 全都為0
		int rand;
		boolean isOK = true;
		long begin = System.currentTimeMillis();
		
		//===================洗牌==============================
		
		for(int i=0; i<poker.length; i++)
		{	// i表示發到第幾張牌
			
			//---------第2種檢查機制寫法    start----------
			do
			{	rand = (int)(Math.random()*52);
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
				
//			//---------第1種檢查機制寫法    start----------
//			for(int j=0; j<i; j++)
//			{	// 假設i=7，表示發到第7張牌，這裡的迴圈就檢查0~6張牌
//				boolean isOK = true;
//				if(poker[i] == rand)
//				{
//					isOK = false;
//					break;
//				}
//			}
//			if(!isOK)
//			{
//				i--; // 因為回到for會有i++，所以這裡先做一個i--
//				continue; // 以下的程式碼不做，Run下一輪的for迴圈
//			}
			//----------第1種檢查機制寫法    end-------------
			
			poker[i] = rand;
		//	System.out.println(poker[i]); // 計算程式碼段 時 這邊先註解掉 因為 System.out也會耗時
		} // for(int i=0; i<poker.length; i++)
	//	System.out.println(System.currentTimeMillis() - begin);
		
		//======================發牌 => 發到4個玩家手上===============================
		System.out.println("---------------------------------------");
		int[][] player = new int[4][13];
		for(int i=0; i<poker.length; i++)
		{
			player[i%4][i/4] = poker[i];
		}
//		for(int v:player[0])
//		{	// 看 第0家 玩家 手上拿到的牌
//			System.out.println(v);
//		}
		//=========================理牌 => 攤牌====================================
		String[] suit = {"黑桃","紅心","方塊","梅花"};
		String[] value = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		//card%13  // 數字
		//card/13	//花色
		for(int[]cards:player)
		{	
			Arrays.sort(cards);
			for(int card:cards)
			{	
				// -------數字轉撲克牌花色的寫法2  start------------------------
				System.out.print(suit[card/13]+value[card%13]+"\t");
			
				// -------數字轉撲克牌花色的寫法1  start------------------------
//				switch(card/13)
//				{
//					case 0:
//						System.out.print("黑桃"+((card%13)+1)+"\t");
//						break;
//					case 1:
//						System.out.print("紅心"+((card%13)+1)+"\t");
//						break;
//					case 2:
//						System.out.print("方塊"+((card%13)+1)+"\t");
//						break;
//					case 3:
//						System.out.print("梅花"+((card%13)+1)+"\t");
//						break;
//				} // switch(card/13)
				// -------數字轉撲克牌花色的寫法1  end------------------------
				
				//System.out.print(card+"\t");
			}
			System.out.println();
		}
		
	} // pokerShuffle()
	
	public static void foreachPractice01()
	{
		int[] a = {1,2,3,4,5};
		int[][] b = {{1,2},{3,4,5},{6,7,8,9}};
//		int[][][] c = 	{
//							{{1,1},{2,2,2}},
//							{{3,3,3},{,}},
//							{{,},{,}}
//						};
		int[][][] c = new int[2][2][1];
		// c[0] = {{},{}};
		c[0][0][0] = 1;
		c[0][1][0] = 2;
		c[1][0][0] = 3;
		c[1][1][0] = 4;
		
		System.out.println("--------a陣列---------");
		// for-each 跑a陣列裡面的每一個元素 把元素拿出來放在v 去玩v 只玩值 只玩值的話用這個比較方便
		for(int v: a)
		{ // a裡面的元素是整數
			System.out.println(v);
		}
		
		System.out.println("------b陣列-----------");
		for(int[] v1 :b)
		{	// b看下去的第一層元素內內的是一為陣列 所以要用一為陣列v1來接
			for(int v2: v1)
			{
				System.out.println(v2);
			}
			System.out.println("+++++++++第2層結束線--");
		}
		
		System.out.println("------c陣列-----------");
		for(int[][] v1 :c)
		{	
			for(int[] v2: v1)
			{
				for(int v3: v2)
				System.out.println(v3);
				System.out.println("##########-第3層結束線--");
			}
			System.out.println("+++++++++第2層結束線--");
		}
		
	} // foreachPractice01()
	
	public static void TwoDimensionArray()
	{	// 師:多維是一個維度中還有一個維度
		int[][] a;
		int[] b[];
		int c[][];
		int[] d = new int[2];
		int e = 2;
		a = new int[3][2];
		b = new int[4][];
		b[0] = new int[2];
		b[1] = new int[3];
		// c = new int[][3];
		
		// 本身已new出物件實體 又重新指向(new的意思)，老師說這點會有點忌諱
		// java的資源 垃圾處理機制 要等 CPU有空才會去處理 
		int[] f = {1,2,3,4};
		System.out.println(f);
		for(int i=0; i<f.length; i++)
		{
			System.out.println(f[i]);
		}
		System.out.println("--------------------------------");
		f = new int[3];
		System.out.println(f);
		for(int i=0; i<f.length; i++)
		{
			System.out.println(f[i]);
		}
		
	}// TwoDimensionArray()
	
	public static void MultyDimensionArray()
	{	// 師:多維是一個維度中還有一個維度
		int[][] a;
		int[] b[];
		int c[][];
		a = new int[3][2];
		double[][][] f = new double[1][2][3];
		System.out.println(f);
		System.out.println(a.length);
		System.out.println(a[1].length);
		System.out.println(a[1][0]);
	}
	
	public static void ArrayIndexTypeTest()
	{
		int[] a;
		// byte b = 1; // byte的數值都會自動轉型成int
		int b = 1; // 只要是int正數都可以拿來當陣列的index用 可用數字的範圍大小約21億多(2GB大小) (21億個數字可用)
		a = new int[b]; // 陣列內的index只能放int byte，若是其他型別要強制轉型成int
	} // void ArrayIndexTypeTest()
	
	
	
} // class
