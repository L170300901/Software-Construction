package exam;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JPanel;
public class paint extends JPanel implements MouseListener {

	Vector<Point> vf = new Vector<Point>();
	Vector<Point> vs = new Vector<Point>();
	Vector<Point> text = new Vector<Point>();
	Vector<String> text11 = new Vector<String>();
	Vector<String> select = new Vector<String>();
	Vector<String> linetype = new Vector<String>();
	Vector<Color> colorchois = new Vector<Color>();
	Point firstP = null;
	Point secondP = null;
	Point textP = null;
	Color color = Color.black;
	int click = 0;

	String chois = "�簢��";
	String type = "������";
	String data = "";

	boolean textcheck = false;
	boolean check = false;
	int stroke = 3;

	paint() {

		addMouseListener(this);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

		/*
		 * startP = e.getPoint(); endP = e.getPoint(); vs.add(startP);
		 * ve.add(endP); repaint();
		 */
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		// System.out.println("���콺 ��ư ����������");

		if (textcheck) {
			textP = e.getPoint();
			text.addElement(textP);
			text11.addElement(data);
			//System.out.println(textP);
			textcheck = false;
			repaint();

		} else {

			if (click == 0) {
				firstP = e.getPoint();
				click++;
			} else if (click == 1) {
				secondP = e.getPoint();

				vf.add(firstP);
				vs.add(secondP);
				select.add(chois);
				linetype.add(type);
				colorchois.add(color);

				firstP = null;
				secondP = null;
				click = 0;
				check = true;
				repaint();
			}
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		// System.out.println("���콺 ��ư ������");

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(color);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(stroke, BasicStroke.CAP_ROUND, 0));

		g.setColor(color.black);  //�۾����� ������
		g.setFont(new Font("�������", Font.CENTER_BASELINE, 30));  //�۾�ũ��� ��Ʈ
		for (int i = 0; i < text.size(); i++) {
			Point x = text.elementAt(i);
			String t = text11.elementAt(i);
			g.drawString(t, (int) x.getX(), (int) x.getY());
		}

		textP = null;

		for (int i = 0; i < vs.size(); i++) {

			if (check) {

				Point s = vf.elementAt(i);
				Point e = vs.elementAt(i);
				String chois = select.elementAt(i);
				Color c = colorchois.elementAt(i);
				String t = linetype.elementAt(i);
				g.setColor(c);

				if (chois.equals("�簢��")) {

					if (t.equals("������")) {

						if (((int) s.getX() < (int) e.getX())
								&& ((int) s.getY() < (int) e.getY())) { // ������
																		// �Ʒ�
							g.drawRect((int) s.getX(), (int) s.getY(),
									(int) e.getX() - (int) s.getX(),
									(int) e.getY() - (int) s.getY());
						} else if (((int) s.getX() < (int) e.getX())
								&& ((int) s.getY() > (int) e.getY())) { // ������ ��
							g.drawRect((int) s.getX(), (int) e.getY(),
									(int) e.getX() - (int) s.getX(),
									Math.abs((int) e.getY() - (int) s.getY()));
						} else if (((int) s.getX() > (int) e.getX())
								&& ((int) s.getY() > (int) e.getY())) { // ������
							g.drawRect((int) e.getX(), (int) e.getY(),
									(int) s.getX() - (int) e.getX(),
									(int) s.getY() - (int) e.getY());
						} else { // ���ʾƷ�
							g.drawRect((int) e.getX(), (int) s.getY(),
									(int) s.getX() - (int) e.getX(),
									(int) e.getY() - (int) s.getY());
						}

					} else if (t.equals("ä���")) {

						if (((int) s.getX() < (int) e.getX())
								&& ((int) s.getY() < (int) e.getY())) { // ������
																		// �Ʒ�
							g.fillRect((int) s.getX(), (int) s.getY(),
									(int) e.getX() - (int) s.getX(),
									(int) e.getY() - (int) s.getY());
						} else if (((int) s.getX() < (int) e.getX())
								&& ((int) s.getY() > (int) e.getY())) { // ������ ��
							g.fillRect((int) s.getX(), (int) e.getY(),
									(int) e.getX() - (int) s.getX(),
									Math.abs((int) e.getY() - (int) s.getY()));
						} else if (((int) s.getX() > (int) e.getX())
								&& ((int) s.getY() > (int) e.getY())) { // ������
							g.fillRect((int) e.getX(), (int) e.getY(),
									(int) s.getX() - (int) e.getX(),
									(int) s.getY() - (int) e.getY());
						} else { // ���ʾƷ�
							g.fillRect((int) e.getX(), (int) s.getY(),
									(int) s.getX() - (int) e.getX(),
									(int) e.getY() - (int) s.getY());
						}

					}

				} else if (chois.equals("Ÿ��")) {

					if (t.equals("������")) {
						if (((int) s.getX() < (int) e.getX())
								&& ((int) s.getY() < (int) e.getY())) { // ������
																		// �Ʒ�
							g.drawOval((int) s.getX(), (int) s.getY(),
									(int) e.getX() - (int) s.getX(),
									(int) e.getY() - (int) s.getY());
						} else if (((int) s.getX() < (int) e.getX())
								&& ((int) s.getY() > (int) e.getY())) { // ������ ��
							g.drawOval((int) s.getX(), (int) e.getY(),
									(int) e.getX() - (int) s.getX(),
									Math.abs((int) e.getY() - (int) s.getY()));
						} else if (((int) s.getX() > (int) e.getX())
								&& ((int) s.getY() > (int) e.getY())) { // ������
							g.drawOval((int) e.getX(), (int) e.getY(),
									(int) s.getX() - (int) e.getX(),
									(int) s.getY() - (int) e.getY());
						} else { // ���ʾƷ�
							g.drawOval((int) e.getX(), (int) s.getY(),
									(int) s.getX() - (int) e.getX(),
									(int) e.getY() - (int) s.getY());
						}
					} else if (t.equals("ä���")) {
						if (((int) s.getX() < (int) e.getX())
								&& ((int) s.getY() < (int) e.getY())) { // ������
																		// �Ʒ�
							g.fillOval((int) s.getX(), (int) s.getY(),
									(int) e.getX() - (int) s.getX(),
									(int) e.getY() - (int) s.getY());
						} else if (((int) s.getX() < (int) e.getX())
								&& ((int) s.getY() > (int) e.getY())) { // ������ ��
							g.fillOval((int) s.getX(), (int) e.getY(),
									(int) e.getX() - (int) s.getX(),
									Math.abs((int) e.getY() - (int) s.getY()));
						} else if (((int) s.getX() > (int) e.getX())
								&& ((int) s.getY() > (int) e.getY())) { // ������
							g.fillOval((int) e.getX(), (int) e.getY(),
									(int) s.getX() - (int) e.getX(),
									(int) s.getY() - (int) e.getY());
						} else { // ���ʾƷ�
							g.fillOval((int) e.getX(), (int) s.getY(),
									(int) s.getX() - (int) e.getX(),
									(int) e.getY() - (int) s.getY());
						}
					}
				} else if (chois.equals("�ձٻ簢��")) {

					if (t.equals("������")) {
						if (((int) s.getX() < (int) e.getX())
								&& ((int) s.getY() < (int) e.getY())) { // ������
																		// �Ʒ�
							g.drawRoundRect((int) s.getX(), (int) s.getY(),
									(int) e.getX() - (int) s.getX(),
									(int) e.getY() - (int) s.getY(), 30, 30);
						} else if (((int) s.getX() < (int) e.getX())
								&& ((int) s.getY() > (int) e.getY())) { // ������ ��
							g.drawRoundRect((int) s.getX(), (int) e.getY(),
									(int) e.getX() - (int) s.getX(),
									Math.abs((int) e.getY() - (int) s.getY()),
									30, 30);
						} else if (((int) s.getX() > (int) e.getX())
								&& ((int) s.getY() > (int) e.getY())) { // ������
							g.drawRoundRect((int) e.getX(), (int) e.getY(),
									(int) s.getX() - (int) e.getX(),
									(int) s.getY() - (int) e.getY(), 30, 30);
						} else { // ���ʾƷ�
							g.drawRoundRect((int) e.getX(), (int) s.getY(),
									(int) s.getX() - (int) e.getX(),
									(int) e.getY() - (int) s.getY(), 30, 30);
						}
					} else if (t.equals("ä���")) {
						if (((int) s.getX() < (int) e.getX())
								&& ((int) s.getY() < (int) e.getY())) { // ������
																		// �Ʒ�
							g.fillRoundRect((int) s.getX(), (int) s.getY(),
									(int) e.getX() - (int) s.getX(),
									(int) e.getY() - (int) s.getY(), 30, 30);
						} else if (((int) s.getX() < (int) e.getX())
								&& ((int) s.getY() > (int) e.getY())) { // ������ ��
							g.fillRoundRect((int) s.getX(), (int) e.getY(),
									(int) e.getX() - (int) s.getX(),
									Math.abs((int) e.getY() - (int) s.getY()),
									30, 30);
						} else if (((int) s.getX() > (int) e.getX())
								&& ((int) s.getY() > (int) e.getY())) { // ������
							g.fillRoundRect((int) e.getX(), (int) e.getY(),
									(int) s.getX() - (int) e.getX(),
									(int) s.getY() - (int) e.getY(), 30, 30);
						} else { // ���ʾƷ�
							g.fillRoundRect((int) e.getX(), (int) s.getY(),
									(int) s.getX() - (int) e.getX(),
									(int) e.getY() - (int) s.getY(), 30, 30);
						}
					}

				} else if (chois.equals("����")) {
					g.drawLine((int) s.getX(), (int) s.getY(), (int) e.getX(),
							(int) e.getY());
				}

			}
		}

	}
}
