import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Payment {

	ImageIcon Background= new ImageIcon(getClass().getClassLoader().getResource("004.jpg"));
	JFrame f=new JFrame("���ٹ� Ű����ũ"); 
	String total_Label;
	
	Payment(){
		
		JPanel Back = new JPanel() { //������ �̹��� background����� ���� �ǳڻ���
	    public void paintComponent(Graphics g) {
	    g.drawImage(Background.getImage(),0, 0, null);
	    setOpaque(false); //�׸��� ǥ���ϰ� ����
	    super.paintComponent(g);} };
	        
	    f.setContentPane(Back);   //�������� background�� �ٲ�
		f.setTitle("���ٹ� Ű����ũ");//������
        f.setSize(800, 600);     //�������
        f.setVisible(true);     //â�� ȭ�鿡 ��Ÿ�� ����������
        f.setResizable(false);  //â����
        f.setLayout(null);     //���̾ƿ� null(������ġ �����ҰŶ�)
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        
        
        //����ũ �ƿ� ����
       if(Main.Takeout == true) {
    	  Menu.totalPrice -=1000;
    	  total_Label = "�ֹ��ݾ� :   "+ Menu.totalPrice+"�� (Take out - 1000)";
    	  Main.Takeout= false;}
       else total_Label = "�ֹ��ݾ� :   "+ Menu.totalPrice;
        
       //�ֹ��ݾ� 
        JLabel op = new JLabel(total_Label); //�󺧸�
		f.add(op);                          //�����ӿ� �󺧸� �߰�
		op.setBounds(280, 150, 350,30);    //������ġ����
		op.setFont(op.getFont().deriveFont(18.0f)); //�۾� ũ������
		
		// �����̺�Ʈ ���ڿ��� �߰�
		if(Random.Random.equals("��")|Random.Random=="����ǰ ����") { //�� ��÷�� ������ �̱���
				}
		else Menu.order_list += Random.Random+" ����";
		
		//���ڿ� JLabel�� �°� ��ȯ
        String st = "<html>"+ Menu.order_list+"</html>";
        st = st.replaceAll("\n", "<br>");
		
		
		JLabel ol = new JLabel(st);     //�󺧸�
		f.add(ol);                      //�����ӿ� �󺧸� �߰�
		ol.setBounds(380, 185, 400,100);//������ġ����
		ol.setFont(ol.getFont().deriveFont(18.0f)); //�۾� ũ������
		
		JLabel o = new JLabel("�ֹ����� : "); //�󺧸�
		f.add(o);                          //�����ӿ� �󺧸� �߰�
		o.setBounds(280, 180, 150,30);     //������ġ����
		o.setFont(o.getFont().deriveFont(18.0f)); //�۾� ũ������
		
		JButton button0 = new JButton("CARD");//��ư�߰�
		f.add(button0);
		button0.setBounds(600,480,130,40);   //��ư ��ġ �� ũ�⼳��
		button0.addActionListener(new MyActionListener0());
		
		JButton button1 = new JButton("BACK");//��ư�߰�
		f.add(button1);
		button1.setBounds(50,480,130,40);    //��ư ��ġ �� ũ�⼳��
		button1.addActionListener(new MyActionListener1());
		
		
		
	}	
	
	class MyActionListener0 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			if (b.getText().equals("CARD")) {
				JFrame new_f = new JFrame();
				new_f.setTitle("�����Ϸ�");   //������
				new_f.setSize(400,200);    //�������
				new_f.setVisible(true);    //â�� ȭ�鿡 ��Ÿ�� ����������
				new_f.setResizable(false); //â����
				new_f.setLayout(null);     //���̾ƿ� null(������ġ �����ҰŶ�)
				
				JLabel card_m = new JLabel("<html>������ �Ϸ�Ǿ����ϴ�.<br> ī�带 �������ּ���<html>"); //�󺧸�
				new_f.add(card_m);                //�����ӿ� �󺧸� �߰�
				card_m.setBounds(110, 40, 200,80);//������ġ����
				card_m.setFont(card_m.getFont().deriveFont(15.0f)); //�۾� ũ������
				
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
