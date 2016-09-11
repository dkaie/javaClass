package tw.org.iii.classroom03;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;


// 這個 是 複製於 老師的 Brad70的範例程式


// TODO 約 16:30 老師開始示範

public class jPrac0911_9 extends JFrame {
	public jPrac0911_9() {
		setLayout(new BorderLayout());
		add(new GameView(), BorderLayout.CENTER);

		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private class GameView extends JPanel {
		private Timer timer;
		private LinkedList<Ball> balls;

		GameView() {
			balls = new LinkedList<>(); 
			timer = new Timer();
			timer.schedule(new TimerTask() {
				@Override
				public void run() {
					repaint();
				}
			}, 0, 40); // 這裡 類似像 人眼在看的 視覺頻率
			// TODO 16:55
			addMouseListener(new MyMouse());
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(Color.red);
			for (Ball ball : balls){
				g2d.fillOval(ball.x-15, ball.y-15, 30, 30);
				// 原本是想說 可能是 圓形的左上角座標 所以 減掉 圓形 寬高的一半 不過 這樣做 好像 會導致 球超出 及 沒碰到邊界
			}
		}

		class MyMouse extends MouseAdapter {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				Ball ball = new Ball(e.getX(), e.getY());
				timer.schedule(ball, 1000, 60); // 球的 移動頻率
				balls.add(ball);
			}

		}

		class Ball extends TimerTask {
			int x, y, dx, dy;

			Ball(int x, int y) {
				dx = dy = 4; // 球 每次的移動距離
				this.x = x;
				this.y = y;
			}

			@Override
			public void run() {
				
				//---------碰到牆壁 的反彈 判斷----------
				if (x<0 || x+30>getWidth()){
					dx *= -1;
				}
				if (y<0 || y+30 > getHeight()){
					dy *= -1;
				}
				
				// 加上差值 (以便更新座標位置)
				x += dx;
				y += dy;
			}
		}
	}

	public static void main(String[] args) {
		new jPrac0911_9();
	}

}
