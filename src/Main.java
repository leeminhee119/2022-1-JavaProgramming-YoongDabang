import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Main extends JFrame{

	 ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource("001.jpg")); 
	 //exe���Ϸ� export�� �̹��� ���ϵ� �ҷ��� �� �ֵ��� getClass()�Լ��� �̿�
   
 
	    //�̹��� ������ �ҷ�����
    
    	JFrame f = new JFrame("���ٹ� Ű����ũ"); 
    	
    	static boolean Takeout = false;
    	
    	Main() {
    		
        JPanel background = new JPanel() { //������ �̹��� background����� ���� �ǳڻ���
        public void paintComponent(Graphics g) {
        g.drawImage(image.getImage(),0, 0, null);
        setOpaque(false);                 //�׸��� ǥ���ϰ� ����
        super.paintComponent(g);} };
        
        f.setContentPane(background);//�������� background�� �ٲ�
        f.setTitle("���ٹ� Ű����ũ");   //������
        f.setSize(800, 600);        //�������
        f.setVisible(true);         //â�� ȭ�鿡 ��Ÿ�� ����������
        f.setResizable(false);      //â����
        f.setLayout(null);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        
        
		
		JButton button = new JButton("����");
		button.setBounds(480,480,130,40);
		f.add(button); //��ư �߰�
		button.addActionListener(new MyActionListener0());
		JButton button2 = new JButton("����ũ�ƿ�");//��ư�߰�
		button2.setBounds(180,480,130,40);      //��ư ��ġ �� ũ�⼳��
		f.add(button2); 
		button2.addActionListener(new MyActionListener());
		JButton button3 = new JButton(""); //������������
		f.add(button3);
		button3.setBounds(770,10,10,10);
		button3.addActionListener(new MyActionListener1());
		
		
		
		
		
		 
    }
    	
	class MyActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			if (b.getText().equals("����ũ�ƿ�")) {
				Takeout = true;}
				
			new Menu();
			f.setVisible(false);}}
	
	class MyActionListener0 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			if (b.getText().equals("����")) {
				
				
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
