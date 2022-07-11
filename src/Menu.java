import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Menu extends JFrame {

	ClassLoader cl = this.getClass().getClassLoader();
//	JFrame f = new JFrame("���ٹ� Ű����ũ");
	ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource("002.jpg"));

	public static int totalPrice = 0;
	static String order_list = ""; // �ֹ����� �޾ƿ� string
	int ordernum[] = new int[9];
	static int price[] = { 3000, 4500, 3500, 4000, 4000, 4000, 2000, 5000, 5500 };
	static String[] Menu_name = { "�Ƹ޸�ī��", "����Ʈ��", "ī���ī", "��ũƼ", "���ڶ�", "����", "��ī��", "ġ������ũ", "ũ����" };
	static String[] soldout = { "", "", "", "", "", "", "", "", "", "" };

	Menu() {
		setTitle("�޴� ����");

		JPanel Back = new JPanel() { // ������ �̹��� background����� ���� �ǳڻ���
			public void paintComponent(Graphics g) {
				g.drawImage(image.getImage(), 0, 0, null);
				setOpaque(false); // �׸��� ǥ���ϰ� ����
				super.paintComponent(g);
			}
		};

		// �������� background�� �ٲ�
		setContentPane(Back);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// ������
		JLabel A = new JLabel("COFFEE"); // �󺧸�
		JLabel B = new JLabel("NON-COFFEE");
		JLabel C = new JLabel("DESERT");
		add(A);
		A.setBounds(35, 35, 100, 30); // ������ġ����
		add(B);
		B.setBounds(35, 200, 100, 30);
		add(C);
		C.setBounds(35, 360, 100, 30);

		// �޴��̸�,���� 1��
		JLabel[] menuLabel = new JLabel[9];
		JLabel[] priceLabel = new JLabel[9];
		JLabel[] menuImages = new JLabel[9];

		// ǰ��ó��
		for (int j = 0; j < 9; j++) {
			if (price[j] == 0) {
				Menu_name[j] = "";
				switch (j) {
				case 0:
					Menu_name[0] = Menu_name[1];
					Menu_name[1] = Menu_name[2];
					Menu_name[2] = "";
					price[0] = price[1];
					price[1] = price[2];
					price[2] = 0;
					break;
				case 1:
					Menu_name[1] = Menu_name[2];
					Menu_name[2] = "";
					price[1] = price[2];
					price[2] = 0;
					break;
				case 2:
					Menu_name[2] = "";
					price[2] = 0;
					break;
				case 3:
					Menu_name[3] = Menu_name[4];
					Menu_name[4] = Menu_name[5];
					Menu_name[5] = "";
					price[3] = price[4];
					price[4] = price[5];
					price[5] = 0;
					break;
				case 4:
					Menu_name[4] = Menu_name[5];
					Menu_name[5] = "";
					price[4] = price[5];
					price[5] = 0;
					break;
				case 5:
					Menu_name[5] = "";
					price[5] = 0;
					break;
				case 6:
					Menu_name[6] = Menu_name[7];
					Menu_name[7] = Menu_name[8];
					Menu_name[8] = "";
					price[6] = price[7];
					price[7] = price[8];
					price[8] = 0;
					break;
				case 7:
					Menu_name[7] = Menu_name[8];
					Menu_name[8] = "";
					price[7] = price[8];
					price[8] = 0;
					break;
				case 8:
					Menu_name[8] = "";
					price[8] = 0;
					break;

				}

			}
		}

		// double check
		for (int i = 0; i < 7; i += 3) {
			int j = i + 1;
			if (price[i] == 0) {
				Menu_name[i] = Menu_name[j];
				Menu_name[j] = "";
				price[i] = price[j];
				price[j] = 0;

			}
		}

		int x = 125; // ��
		int y = 65;

		int xx = 35; // �̹���
		int yy = 65;

		for (int i = 0; i < Menu_name.length; i++) {

			if (price[i] != 0) {
				menuLabel[i] = new JLabel(Menu_name[i]);
				add(menuLabel[i]);
				menuLabel[i].setBounds(x, y, 65, 26);

				menuImages[i] = new JLabel(
						new ImageIcon(getClass().getClassLoader().getResource(Menu_name[i] + "(���簢��).jpg")));
				add(menuImages[i]);
				menuImages[i].setBounds(xx, yy, 80, 80);

				priceLabel[i] = new JLabel(Integer.toString(price[i]));
				add(priceLabel[i]);
				priceLabel[i].setBounds(x, y + 20, 60, 25);
			}

			if (i % 3 == 2) { // �ε��� 2, 5, 8
				x = 125; // JLabel
				y += 165;

				xx = 35; // �̹���
				yy += 165;
			}

			else { // �ε��� 0, 1, 3, 4, 6, 7
				x += 190;
				xx += 185;
			}
		}

		// ���ι�ư �ΰ�
		JButton button2 = new JButton("BACK");
		button2.setBounds(625, 40, 100, 40);
		add(button2);
		button2.addActionListener(new MyActionListener2());// �׼Ǹ����� �߰�

		JButton button = new JButton("ORDER"); // ��ư�߰�
		button.setBounds(625, 480, 100, 40); // ��ư ��ġ �� ũ�⼳��
		add(button);
		button.addActionListener(new MyActionListener3());// �׼Ǹ����� �߰�

		SpinnerModel americano_v = new SpinnerNumberModel(0, // initial value
				0, // minimum value
				30, // maximum value
				1); // step
		SpinnerModel sweetlatte_v = new SpinnerNumberModel(0, 0, 30, 1);
		SpinnerModel cafemocha_v = new SpinnerNumberModel(0, 0, 30, 1);
		SpinnerModel milktea_v = new SpinnerNumberModel(0, 0, 30, 1);
		SpinnerModel chocolatte_v = new SpinnerNumberModel(0, 0, 30, 1);
		SpinnerModel greentea_v = new SpinnerNumberModel(0, 0, 30, 1);
		SpinnerModel macaron_v = new SpinnerNumberModel(0, 0, 30, 1);
		SpinnerModel cheesecake_v = new SpinnerNumberModel(0, 0, 30, 1);
		SpinnerModel croffle_v = new SpinnerNumberModel(0, 0, 30, 1);

		// JSpinner (-���ڿ� �ִ���� ������ ���� �ڵ�)

		JSpinner americano_s = new JSpinner(americano_v);
		JSpinner sweetlatte_s = new JSpinner(sweetlatte_v);
		JSpinner cafemocha_s = new JSpinner(cafemocha_v);
		JSpinner milktea_s = new JSpinner(milktea_v);
		JSpinner chocolatte_s = new JSpinner(chocolatte_v);
		JSpinner greentea_s = new JSpinner(greentea_v);
		JSpinner macaron_s = new JSpinner(macaron_v);
		JSpinner cheesecake_s = new JSpinner(cheesecake_v);
		JSpinner croffle_s = new JSpinner(croffle_v);

		americano_s.addChangeListener(new SpinnerListener0());
		sweetlatte_s.addChangeListener(new SpinnerListener1());
		cafemocha_s.addChangeListener(new SpinnerListener2());
		milktea_s.addChangeListener(new SpinnerListener3());
		chocolatte_s.addChangeListener(new SpinnerListener4());
		greentea_s.addChangeListener(new SpinnerListener5());
		macaron_s.addChangeListener(new SpinnerListener6());
		cheesecake_s.addChangeListener(new SpinnerListener7());
		croffle_s.addChangeListener(new SpinnerListener8());

		americano_s.setBounds(125, 110, 50, 30);
		sweetlatte_s.setBounds(320, 110, 50, 30);
		cafemocha_s.setBounds(500, 110, 50, 30);
		milktea_s.setBounds(125, 275, 50, 30);
		chocolatte_s.setBounds(315, 275, 50, 30);
		greentea_s.setBounds(500, 275, 50, 30);
		macaron_s.setBounds(125, 445, 50, 30);
		cheesecake_s.setBounds(315, 445, 50, 30);
		croffle_s.setBounds(500, 445, 50, 30);

		for (int i = 0; i < 9; i++) {
			if (price[i] == 0) {
				continue;
			} else {
				switch (i) {
				case 0:
					add(americano_s);
					break;
				case 1:
					add(sweetlatte_s);
					break;
				case 2:
					add(cafemocha_s);
					break;
				case 3:
					add(milktea_s);
					break;
				case 4:
					add(chocolatte_s);
					break;
				case 5:
					add(greentea_s);
					break;
				case 6:
					add(macaron_s);
					break;
				case 7:
					add(cheesecake_s);
					break;
				case 8:
					add(croffle_s);
					break;
				}
			}
		}

		setLayout(null);

		setSize(800, 600);
		setVisible(true);

	}

	void total() {

		// total price ���ϱ�
		for (int i = 0; i < ordernum.length; i++) {
			totalPrice += ordernum[i] * price[i];
		}

		// �ֹ����� �޾ƿ���
		for (int i = 0; i < ordernum.length; i++) {
			if (ordernum[i] != 0) {
				order_list += Menu_name[i] + " " + ordernum[i] + "�� " + ordernum[i] * price[i] + "��\n";
				;
			}
		}

	}

	class SpinnerListener0 implements ChangeListener {
		public void stateChanged(ChangeEvent evt) {
			JSpinner spinner = (JSpinner) evt.getSource();
			ordernum[0] = (int) spinner.getValue();
		}
	}

	class SpinnerListener1 implements ChangeListener {
		public void stateChanged(ChangeEvent evt) {
			JSpinner spinner = (JSpinner) evt.getSource();
			ordernum[1] = (int) spinner.getValue();
		}
	}

	class SpinnerListener2 implements ChangeListener {
		public void stateChanged(ChangeEvent evt) {
			JSpinner spinner = (JSpinner) evt.getSource();
			ordernum[2] = (int) spinner.getValue();
		}
	}

	class SpinnerListener3 implements ChangeListener {
		public void stateChanged(ChangeEvent evt) {
			JSpinner spinner = (JSpinner) evt.getSource();
			ordernum[3] = (int) spinner.getValue();
		}
	}

	class SpinnerListener4 implements ChangeListener {
		public void stateChanged(ChangeEvent evt) {
			JSpinner spinner = (JSpinner) evt.getSource();
			ordernum[4] = (int) spinner.getValue();
		}
	}

	class SpinnerListener5 implements ChangeListener {
		public void stateChanged(ChangeEvent evt) {
			JSpinner spinner = (JSpinner) evt.getSource();
			ordernum[5] = (int) spinner.getValue();
		}
	}

	class SpinnerListener6 implements ChangeListener {
		public void stateChanged(ChangeEvent evt) {
			JSpinner spinner = (JSpinner) evt.getSource();
			ordernum[6] = (int) spinner.getValue();
		}
	}

	class SpinnerListener7 implements ChangeListener {
		public void stateChanged(ChangeEvent evt) {
			JSpinner spinner = (JSpinner) evt.getSource();
			ordernum[7] = (int) spinner.getValue();
		}
	}

	class SpinnerListener8 implements ChangeListener {
		public void stateChanged(ChangeEvent evt) {
			JSpinner spinner = (JSpinner) evt.getSource();
			ordernum[8] = (int) spinner.getValue();
		}
	}

	class MyActionListener2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton) e.getSource();
			if (b.getText().equals("BACK")) {
				new Main();
				setVisible(false);
			}
		}
	}

	class MyActionListener3 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton) e.getSource();
			if (b.getText().equals("ORDER")) {
				total();
				if (totalPrice != 0) {
					new Random();
					setVisible(false);
				} else {
					setVisible(true);
					JFrame new_f = new JFrame();
					new_f.setTitle("ERROR"); // ������
					new_f.setSize(400, 200); // �������
					new_f.setVisible(true); // â�� ȭ�鿡 ��Ÿ�� ����������
					new_f.setResizable(false); // â����
					new_f.setLayout(null); // ���̾ƿ� null(������ġ �����ҰŶ�)

					JLabel menu_e = new JLabel("<html>�޴��� ���õ��� �ʾҽ��ϴ�.<br> �޴��� ������ �ּ���!<html>"); // �󺧸�
					new_f.add(menu_e); // �����ӿ� �󺧸� �߰�
					menu_e.setBounds(110, 40, 200, 80);// ������ġ����
					menu_e.setFont(menu_e.getFont().deriveFont(15.0f)); // �۾� ũ������

				}

			}
		}
	}

	public static void main(String[] args) {
		Menu frame = new Menu();

	}
}