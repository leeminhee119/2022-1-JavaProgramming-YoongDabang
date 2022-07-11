import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.GridLayout;

public class Soldout extends JFrame{ //관리자 클래스

	JFrame f=new JFrame("관리자 화면");
	JButton button[] = new JButton[18];
	String namecopy [] = { "아메리카노", "스위트라떼", "카페모카", "밀크티", "초코라떼", "녹차", "마카롱", "치즈케이크", "크로플" };
	int pricecopy[] =  {3000, 4500, 3500, 4000, 4000, 4000, 2000, 5000, 5500 };
	
	Soldout(){
		
		
		
		for (int i = 0; i<9; i++) {
			button[i] = new JButton(namecopy[i] + " 품절");
			f.add(button[i]);
		}
	
		button[9] = new JButton("초기화");
		button[9].setBackground(new Color (255,128,0));
		f.add(button[9]);
		
		button[0].addActionListener(new MyActionListener0());
		button[1].addActionListener(new MyActionListener1());
		button[2].addActionListener(new MyActionListener2());
		button[3].addActionListener(new MyActionListener3());
		button[4].addActionListener(new MyActionListener4());
		button[5].addActionListener(new MyActionListener5());
		button[6].addActionListener(new MyActionListener6());
		button[7].addActionListener(new MyActionListener7());
		button[8].addActionListener(new MyActionListener8());
		button[9].addActionListener(new MyActionListener9());
		
		
		f.setTitle("관리자 화면"); // 제목설정
		f.setSize(500, 500); // 사이즈설정
		f.setVisible(true); // 창을 화면에 나타낼 것인지설정
		f.setResizable(false); // 창고정
		f.setLayout(new GridLayout(0, 3));
		
		JLabel A = new JLabel("<html>품절상품 이미 있을시 <br>초기화 후에 다시 삭제 필요<html>");
		f.add(A);

	}
	
	
		 class MyActionListener0 implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton)e.getSource();
				if (b.getText().equals("아메리카노 품절")) {
					//Menu.soldout[0] = "아메리카노";
					Menu.price[0]=0;
					}}}
		 
		 class MyActionListener1 implements ActionListener{
				public void actionPerformed(ActionEvent e) {
					JButton b = (JButton)e.getSource();
					if (b.getText().equals("스위트라떼 품절")) {
						//Menu.soldout[1] = "스위트라떼";
						Menu.price[1]=0;
						}}}

		 class MyActionListener2 implements ActionListener{
				public void actionPerformed(ActionEvent e) {
					JButton b = (JButton)e.getSource();
					if (b.getText().equals("카페모카 품절")) {
						//Menu.soldout[2] = "카페모카";
						Menu.price[2]=0;
						}}}
		 class MyActionListener3 implements ActionListener{
				public void actionPerformed(ActionEvent e) {
					JButton b = (JButton)e.getSource();
					if (b.getText().equals("밀크티 품절")) {
						//Menu.soldout[3] = "밀크티";
						Menu.price[3]=0;
						}}}
		 class MyActionListener4 implements ActionListener{
				public void actionPerformed(ActionEvent e) {
					JButton b = (JButton)e.getSource();
					if (b.getText().equals("초코라떼 품절")) {
						//Menu.soldout[4] = "초코라떼";
						Menu.price[4]=0;
						}}}
		 
		 class MyActionListener5 implements ActionListener{
				public void actionPerformed(ActionEvent e) {
					JButton b = (JButton)e.getSource();
					if (b.getText().equals("녹차 품절")) {
						//Menu.soldout[5] = "녹차";
						Menu.price[5]=0;
						}}}
		 class MyActionListener6 implements ActionListener{
				public void actionPerformed(ActionEvent e) {
					JButton b = (JButton)e.getSource();
					if (b.getText().equals("마카롱 품절")) {
						//Menu.soldout[6] = "마카롱";
						Menu.price[6]=0;
						}}}
		 
		 class MyActionListener7 implements ActionListener{
				public void actionPerformed(ActionEvent e) {
					JButton b = (JButton)e.getSource();
					if (b.getText().equals("치즈케이크 품절")) {
						//Menu.soldout[7] = "치즈케이크";
						Menu.price[7]=0;
						}}}
		 
		 class MyActionListener8 implements ActionListener{
				public void actionPerformed(ActionEvent e) {
					JButton b = (JButton)e.getSource();
					if (b.getText().equals("크로플 품절")) {
						//Menu.soldout[8] = "크로플";
						Menu.price[8] = 0;
						}}}
		 
		 
				class MyActionListener9 implements ActionListener {
					public void actionPerformed(ActionEvent e) {
						JButton b = (JButton) e.getSource();
						if (b.getText().equals("초기화")) {
							Menu.price = pricecopy.clone();
							Menu.Menu_name = namecopy.clone();
						}
					}
				}

			

				
        public static void main(String[] args) {
    		// TODO Auto-generated method stub
        	Soldout out = new Soldout();
        	
        	
	}

}
