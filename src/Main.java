import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Main extends JFrame{

	 ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource("001.jpg")); 
	 //exe파일로 export시 이미지 파일도 불러올 수 있도록 getClass()함수를 이용
   
 
	    //이미지 변수에 불러오기
    
    	JFrame f = new JFrame("융다방 키오스크"); 
    	
    	static boolean Takeout = false;
    	
    	Main() {
    		
        JPanel background = new JPanel() { //프레임 이미지 background만들기 위해 판넬생성
        public void paintComponent(Graphics g) {
        g.drawImage(image.getImage(),0, 0, null);
        setOpaque(false);                 //그림을 표시하게 설정
        super.paintComponent(g);} };
        
        f.setContentPane(background);//프레임을 background로 바꿈
        f.setTitle("융다방 키오스크");   //제목설정
        f.setSize(800, 600);        //사이즈설정
        f.setVisible(true);         //창을 화면에 나타낼 것인지설정
        f.setResizable(false);      //창고정
        f.setLayout(null);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        
        
		
		JButton button = new JButton("매장");
		button.setBounds(480,480,130,40);
		f.add(button); //버튼 추가
		button.addActionListener(new MyActionListener0());
		JButton button2 = new JButton("테이크아웃");//버튼추가
		button2.setBounds(180,480,130,40);      //버튼 위치 및 크기설정
		f.add(button2); 
		button2.addActionListener(new MyActionListener());
		JButton button3 = new JButton(""); //관리자페이지
		f.add(button3);
		button3.setBounds(770,10,10,10);
		button3.addActionListener(new MyActionListener1());
		
		
		
		
		
		 
    }
    	
	class MyActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			if (b.getText().equals("테이크아웃")) {
				Takeout = true;}
				
			new Menu();
			f.setVisible(false);}}
	
	class MyActionListener0 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			if (b.getText().equals("매장")) {
				
				
			new Menu();
			f.setVisible(false);}}}
	
	
	class MyActionListener1 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			if (b.getText().equals("")) {
				
				
			new Soldout();
			}}}
			
    
    public static void main(String[] args) {	
        Main frame = new Main();
    }}
