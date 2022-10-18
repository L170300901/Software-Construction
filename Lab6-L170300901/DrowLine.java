package exam;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class DrowLine extends JFrame implements ActionListener, ItemListener,
		KeyListener {

	JFileChooser chooser;
	JColorChooser colorchooser;
	paint panel = new paint();
	JLabel imageLabel = new JLabel();
	JButton butt;
	JTextField tf;

	DrowLine() {

		init();

		setTitle("exam");
		setSize(500, 500); // â ũ��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ������v Ȱ��ȭ
		setVisible(true); // ȭ�鿡 ���̱�
		// ��ũ�� ������ ������ screenSize�� ����
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		// �������� ȭ�� �߰����� ������ ��
		setLocation((screenSize.width - 500) / 2, (screenSize.height - 500) / 2);

	}

	public static void main(String[] args) {
		// JFrame.setDefaultLookAndFeelDecorated(true);
		DrowLine drow = new DrowLine();
	}

	public void init() {


		butt = new JButton("Ȯ��");
		butt.addActionListener(this);

		tf = new JTextField(20);
		tf.addKeyListener(this);

		JPanel base = new JPanel();
		base.setLayout(new BorderLayout());
		JPanel p1 = new JPanel();
		p1.setLayout(new BorderLayout());
		JMenuBar menu = new JMenuBar();
		JMenu file = new JMenu("����");
		JMenu draw = new JMenu("�׸���");
		JMenu color = new JMenu("����");

		JMenuItem menu1 = new JMenuItem("���׸�");
		JMenuItem menu2 = new JMenuItem("����");
		JMenuItem menu3 = new JMenuItem("����");
		JMenuItem menu4 = new JMenuItem("����");
		JMenuItem menu5 = new JMenuItem("�簢��");
		JMenuItem menu6 = new JMenuItem("Ÿ��");
		JMenuItem menu7 = new JMenuItem("�ձٻ簢��");
		JMenuItem menu8 = new JMenuItem("����");
		JMenuItem menu9 = new JMenuItem("������");
		JMenuItem menu10 = new JMenuItem("ä���");

		menu1.addActionListener(this);
		menu2.addActionListener(this);
		menu3.addActionListener(this);
		menu4.addActionListener(this);
		menu5.addActionListener(this);
		menu6.addActionListener(this);
		menu7.addActionListener(this);
		menu8.addActionListener(this);
		menu9.addActionListener(this);
		menu10.addActionListener(this);


		menu.add(file);
		file.add(menu1);
		file.add(menu2);
		file.add(menu3);
		file.add(menu4);

		menu.add(draw);
		draw.add(menu5);
		draw.add(menu6);
		draw.add(menu7);
		draw.add(menu8);

		menu.add(color);
		color.add(menu9);
		color.add(menu10);

		p1.add("Center", menu);
		p1.add("East", tf);

		base.add("North", p1);

		panel.add(imageLabel);
		add("North", base);
		add("Center", panel);
		add("South",butt);
		butt.setVisible(false);

	}

	@Override
	public void actionPerformed(ActionEvent e) { // �׼��̺�Ʈ
		Object obj = e.getSource();
		String gac = e.getActionCommand();


		/*if ((JButton) obj == butt) {
			String text = tf.getText();
			panel.data=text;
			tf.setText("");


		}*/



		if (gac.equals("���׸�")) {

			imageLabel.setIcon(null);
			panel.vf.removeAllElements();
			panel.vs.removeAllElements();
			panel.text.removeAllElements();
			panel.text11.removeAllElements();
			panel.select.removeAllElements();
			panel.linetype.removeAllElements();
			panel.colorchois.removeAllElements();
			panel.repaint();


		} else if (gac.equals("����")) {
			chooser = new JFileChooser();

			FileNameExtensionFilter filter = new FileNameExtensionFilter(
					"JPG & GIF Images", "jpg", "gif");
			chooser.setFileFilter(filter);
			int ret = chooser.showOpenDialog(null);
			if (ret != JFileChooser.APPROVE_OPTION) {
				JOptionPane.showMessageDialog(null, "������ �������� �ʾҽ��ϴ�", "���",
						JOptionPane.WARNING_MESSAGE);
				return;
			}
			String filePath = chooser.getSelectedFile().getPath();
			imageLabel.setIcon(new ImageIcon(filePath));
			pack();

		} else if (gac.equals("����")) {
			JOptionPane.showMessageDialog(this, "����Ǿ����ϴ�.",
					"����", JOptionPane.INFORMATION_MESSAGE);

		} else if (gac.equals("����")) {
			System.exit(0);

		} else if (gac.equals("�簢��")) {
			panel.chois ="�簢��";

		} else if (gac.equals("Ÿ��")) {
			panel.chois ="Ÿ��";

		} else if (gac.equals("�ձٻ簢��")) {
			panel.chois ="�ձٻ簢��";

		} else if (gac.equals("����")) {
			panel.chois ="����";

		} else if (gac.equals("������")) {

			panel.type="������";
			colorchooser = new JColorChooser();

			Color selectedColor = colorchooser.showDialog(null, "Color",
					Color.YELLOW);
			panel.color = selectedColor;

		} else if (gac.equals("ä���")) {
			panel.type="ä���";
			Color selectedColor = colorchooser.showDialog(null, "Color",
					Color.YELLOW);
			panel.color = selectedColor;

		}

	}

	@Override
	public void itemStateChanged(ItemEvent arg0) { // �޺��ڽ� ���°� ���Ҷ����� ȣ���
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 10) { // ���Ͱ� ������
			String text = tf.getText();
			panel.data=text;
			tf.setText("");
			panel.textcheck = true;
		}
	}


}
