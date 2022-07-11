import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Random extends JFrame{
	
	ImageIcon Background= new ImageIcon(getClass().getClassLoader().getResource("003.jpg"));
	
	JFrame f = new JFrame("융다방 키오스크"); 
	public static String Random = "증정품 없음"; //다른 클래스에서 사용하기 위한 전역변수 선언
	int num = 0; //while문을 위한 num
	
	Random(){
		
		JPanel Back = new JPanel() { //프레임 이미지 background만들기 위해 판넬생성
	    public void paintComponent(Graphics g) {
	    g.drawImage(Background.getImage(),0, 0,null);
	    setOpaque(false);           //그림을 표시하게 설정
	    super.paintComponent(g);} };
	        
	    f.setContentPane(Back);    //프레임을 background로 바꿈
		f.setTitle("융다방 키오스크"); //제목설정
        f.setSize(800, 600);      //사이즈설정
        f.setVisible(true);       //창을 화면에 나타낼 것인지설정
        f.setResizable(false);    //창고정
        f.setLayout(null);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        
		//버튼세개
        JButton button0 = new JButton("PUSH");//버튼추가
		button0.setBounds(500,200,100,40);    //버튼 위치 및 크기설정
		f.add(button0);
		
		JButton button1 = new JButton("ORDER");
		button1.setBounds(600,480,130,40);    
		f.add(button1);
		JButton button2 = new JButton("BACK");
		button2.setBounds(50,480,130,40);
		f.add(button2);
		
		button2.addActionListener(new MyActionListener3());
		button1.addActionListener(new MyActionListener4());
		button0.addActionListener(new MyActionListener5());
		
		
	}
	

	class MyActionListener3 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			if (b.getText().equals("BACK")) {
				Menu.totalPrice =0;
				Menu.order_list = "";
			new Menu();
			f.setVisible(false);}}}
	
	class MyActionListener4 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			if (b.getText().equals("ORDER")) {
				
			new Payment();
			f.setVisible(false);}}}
	
	class MyActionListener5 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			if (b.getText().equals("PUSH")) { //push버튼 누를시
				
				if(num == 0) {
					String[] items = {"꽝", "아메리카노", "쿠키", "재방문 시 천원 할인"};
					int nums= (int) (Math.random()*4); //랜덤인덱스 받기
					Random = items[nums];             //배열안에 랜덤값을 변수안에 넣기
					num = 1;
					
					JLabel op = new JLabel(Random); //라벨링
					f.add(op);                     //프레임에 라벨링 추가
					op.setBounds(300, 205, 200,30);//절대위치지정
					op.setFont(op.getFont().deriveFont(18.0f)); //글씨 크기지정
					}
			}}}

	 public static void main(String[] args) {	
		 Random R = new Random();
	    }
	
}
