import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Payment {

	ImageIcon Background= new ImageIcon(getClass().getClassLoader().getResource("004.jpg"));
	JFrame f=new JFrame("융다방 키오스크"); 
	String total_Label;
	
	Payment(){
		
		JPanel Back = new JPanel() { //프레임 이미지 background만들기 위해 판넬생성
	    public void paintComponent(Graphics g) {
	    g.drawImage(Background.getImage(),0, 0, null);
	    setOpaque(false); //그림을 표시하게 설정
	    super.paintComponent(g);} };
	        
	    f.setContentPane(Back);   //프레임을 background로 바꿈
		f.setTitle("융다방 키오스크");//제목설정
        f.setSize(800, 600);     //사이즈설정
        f.setVisible(true);     //창을 화면에 나타낼 것인지설정
        f.setResizable(false);  //창고정
        f.setLayout(null);     //레이아웃 null(절대위치 설정할거라서)
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        
        
        //테이크 아웃 할인
       if(Main.Takeout == true) {
    	  Menu.totalPrice -=1000;
    	  total_Label = "주문금액 :   "+ Menu.totalPrice+"원 (Take out - 1000)";
    	  Main.Takeout= false;}
       else total_Label = "주문금액 :   "+ Menu.totalPrice;
        
       //주문금액 
        JLabel op = new JLabel(total_Label); //라벨링
		f.add(op);                          //프레임에 라벨링 추가
		op.setBounds(280, 150, 350,30);    //절대위치지정
		op.setFont(op.getFont().deriveFont(18.0f)); //글씨 크기지정
		
		// 랜덤이벤트 문자열에 추가
		if(Random.Random.equals("꽝")|Random.Random=="증정품 없음") { //꽝 당첨시 내역에 미기재
				}
		else Menu.order_list += Random.Random+" 증정";
		
		//문자열 JLabel에 맞게 변환
        String st = "<html>"+ Menu.order_list+"</html>";
        st = st.replaceAll("\n", "<br>");
		
		
		JLabel ol = new JLabel(st);     //라벨링
		f.add(ol);                      //프레임에 라벨링 추가
		ol.setBounds(380, 185, 400,100);//절대위치지정
		ol.setFont(ol.getFont().deriveFont(18.0f)); //글씨 크기지정
		
		JLabel o = new JLabel("주문내역 : "); //라벨링
		f.add(o);                          //프레임에 라벨링 추가
		o.setBounds(280, 180, 150,30);     //절대위치지정
		o.setFont(o.getFont().deriveFont(18.0f)); //글씨 크기지정
		
		JButton button0 = new JButton("CARD");//버튼추가
		f.add(button0);
		button0.setBounds(600,480,130,40);   //버튼 위치 및 크기설정
		button0.addActionListener(new MyActionListener0());
		
		JButton button1 = new JButton("BACK");//버튼추가
		f.add(button1);
		button1.setBounds(50,480,130,40);    //버튼 위치 및 크기설정
		button1.addActionListener(new MyActionListener1());
		
		
		
	}	
	
	class MyActionListener0 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			if (b.getText().equals("CARD")) {
				JFrame new_f = new JFrame();
				new_f.setTitle("결제완료");   //제목설정
				new_f.setSize(400,200);    //사이즈설정
				new_f.setVisible(true);    //창을 화면에 나타낼 것인지설정
				new_f.setResizable(false); //창고정
				new_f.setLayout(null);     //레이아웃 null(절대위치 설정할거라서)
				
				JLabel card_m = new JLabel("<html>결제가 완료되었습니다.<br> 카드를 제거해주세요<html>"); //라벨링
				new_f.add(card_m);                //프레임에 라벨링 추가
				card_m.setBounds(110, 40, 200,80);//절대위치지정
				card_m.setFont(card_m.getFont().deriveFont(15.0f)); //글씨 크기지정
				
			}
	}}
	
	class MyActionListener1 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			if (b.getText().equals("BACK")) {
				Menu.totalPrice = 0;
				Menu.order_list = "";
				
			new Menu();
			f.setVisible(false);}}}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Payment p = new Payment();
}}
