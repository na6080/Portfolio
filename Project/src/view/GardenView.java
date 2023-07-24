package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JCalendar;

import model.GardenDAO;
import model.rec.GardenVO;

public class GardenView extends JFrame {

	JPanel contentPane;
	JTextField textField;
	JTextField textField_1;
	JTextField textField_2;
	JTextField textField_3;
	JTextField textField_4;
	JTextField textField_5;
	JTextField textField_6;
	JTextField textField_7;
	JTextField textField_8;
	JTextField textField_9;
	JTextField textField_10;
	JTextField textField_11;
	JTextField textField_12;
	JTextField textField_13;
	JTextField textField_14;
	JButton btnNewButton_2;
	static int pk;
	static String nick;
	static int point;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GardenView frame = new GardenView(pk, nick, point);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GardenView(int pk, String nick, int point) {
		this.pk = pk;
		this.nick = nick;
		this.point = point;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1154, 646);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton_3 = new JButton("\uD143\uBC2D\uC774\uC6A9\uC548\uB0B4");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String imagePath = "C:\\Users\\lee\\Documents\\īī���� ���� ����\\�Թ����\\�Թ�ȳ�.jpg";

				// �̹��� ������ ����
				ImageIcon imageIcon = new ImageIcon(imagePath);

				// JLabel ���� �� �̹��� ������ ����
				JLabel label = new JLabel(imageIcon);

				// JDialog ���� �� ����
				JDialog dialog = new JDialog();
				dialog.setTitle("Image Popup");
				dialog.setModal(true);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.getContentPane().add(label);
				dialog.pack();
				dialog.setLocationRelativeTo(null); // �߾ӿ� ��ġ�ϵ��� ����
				dialog.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(12, 10, 187, 106);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton = new JButton("\uB098 \uB9E4\uC778\uD398\uC774\uC9C0\uB2E4");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainHomeView mainhomeview = new MainHomeView(pk, nick, point);
				mainhomeview.setVisible(true);
			}
		});
		btnNewButton.setBounds(510, 10, 172, 106);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\uB9C8\uC774\uD398\uC774\uC9C0");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MyPageView mypageview = new MyPageView(pk, nick, point);
				mypageview.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("�������", Font.BOLD, 15));
		btnNewButton_1.setBounds(1005, 10, 121, 106);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(GardenView.class.getResource("/image/�Թ�1.jpg")));
		lblNewLabel.setBounds(39, 171, 172, 193);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(GardenView.class.getResource("/image/�Թ�2.jpg")));
		lblNewLabel_1.setBounds(243, 171, 172, 193);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("New label");
		lblNewLabel_1_1.setIcon(new ImageIcon(GardenView.class.getResource("/image/�Թ�4.jpg")));
		lblNewLabel_1_1.setBounds(651, 171, 199, 193);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(GardenView.class.getResource("/image/�Թ�3.jpg")));
		lblNewLabel_2.setBounds(447, 171, 172, 193);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(GardenView.class.getResource("/image/�Թ�5.jpg")));
		lblNewLabel_3.setBounds(874, 171, 199, 193);
		contentPane.add(lblNewLabel_3);

		textField = new JTextField();
		textField.setText("\uD143\uBC2D \uC8FC\uC18C : \r\n");
		textField.setBounds(68, 374, 116, 21);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setText("\uD143\uBC2D \uB300\uC5EC\uB8CC : ");
		textField_1.setBounds(68, 405, 116, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setText("\uD143\uBC2D \uD3C9\uC218:\r\n\r\n");
		textField_2.setBounds(68, 436, 116, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setText("\uD143\uBC2D \uC8FC\uC18C : \r\n");
		textField_3.setColumns(10);
		textField_3.setBounds(269, 374, 116, 21);
		contentPane.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setText("\uD143\uBC2D \uB300\uC5EC\uB8CC : ");
		textField_4.setColumns(10);
		textField_4.setBounds(269, 405, 116, 21);
		contentPane.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setText("\uD143\uBC2D \uD3C9\uC218:\r\n\r\n");
		textField_5.setColumns(10);
		textField_5.setBounds(269, 438, 116, 21);
		contentPane.add(textField_5);

		textField_6 = new JTextField();
		textField_6.setText("\uD143\uBC2D \uC8FC\uC18C : \r\n");
		textField_6.setColumns(10);
		textField_6.setBounds(468, 374, 116, 21);
		contentPane.add(textField_6);

		textField_7 = new JTextField();
		textField_7.setText("\uD143\uBC2D \uB300\uC5EC\uB8CC : ");
		textField_7.setColumns(10);
		textField_7.setBounds(468, 405, 116, 21);
		contentPane.add(textField_7);

		textField_8 = new JTextField();
		textField_8.setText("\uD143\uBC2D \uD3C9\uC218:\r\n\r\n");
		textField_8.setColumns(10);
		textField_8.setBounds(468, 438, 116, 21);
		contentPane.add(textField_8);
		textField_9 = new JTextField();
		textField_9.setText("\uD143\uBC2D \uC8FC\uC18C : \r\n");
		textField_9.setColumns(10);
		textField_9.setBounds(693, 374, 116, 21);
		contentPane.add(textField_9);

		textField_10 = new JTextField();
		textField_10.setText("\uD143\uBC2D \uB300\uC5EC\uB8CC : ");
		textField_10.setColumns(10);
		textField_10.setBounds(693, 405, 116, 21);
		contentPane.add(textField_10);
		textField_11 = new JTextField();
		textField_11.setText("\uD143\uBC2D \uD3C9\uC218:\r\n\r\n");
		textField_11.setColumns(10);
		textField_11.setBounds(693, 436, 116, 21);
		contentPane.add(textField_11);

		textField_12 = new JTextField();
		textField_12.setText("\uD143\uBC2D \uC8FC\uC18C : \r\n");
		textField_12.setColumns(10);
		textField_12.setBounds(920, 374, 116, 21);
		contentPane.add(textField_12);

		textField_13 = new JTextField();
		textField_13.setText("\uD143\uBC2D \uB300\uC5EC\uB8CC : ");
		textField_13.setColumns(10);
		textField_13.setBounds(920, 405, 116, 21);
		contentPane.add(textField_13);

		textField_14 = new JTextField();
		textField_14.setText("\uD143\uBC2D \uD3C9\uC218:\r\n\r\n");
		textField_14.setColumns(10);
		textField_14.setBounds(920, 436, 116, 21);
		contentPane.add(textField_14);

		btnNewButton_2 = new JButton("�����ϱ�");
		btnNewButton_2.setBounds(78, 467, 97, 23);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					GardenDAO gardenDAO = new GardenDAO();

					// Ķ���� ���̾�α� ����
					JDialog calendarDialog = new JDialog();
					calendarDialog.setTitle("��¥ ����");
					calendarDialog.setModal(true);
					calendarDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					calendarDialog.setBounds(100, 100, 300, 300);
					calendarDialog.getContentPane().setLayout(new BorderLayout());

					// Ķ���� �г� ����
					JPanel calendarPanel = new JPanel();
					calendarPanel.setLayout(new BorderLayout());

					// Ķ���� ������Ʈ ����
					JCalendar calendar = new JCalendar();
					calendarPanel.add(calendar, BorderLayout.CENTER);

					// Ȯ�� ��ư ����
					JButton confirmButton = new JButton("Ȯ��");
					calendarPanel.add(confirmButton, BorderLayout.SOUTH);

					// Ȯ�� ��ư Ŭ�� �� ������ ��¥ ��������
					confirmButton.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							LocalDate selectedDate = calendar.getDate().toInstant().atZone(ZoneId.systemDefault())
									.toLocalDate();
							LocalDate startDate = selectedDate; // ������ ��¥�� �����Ϸ� ����
							LocalDate endDate = startDate.plusDays(90); // �Թ� ��� �������� �����Ϸκ��� 14�� �ķ� ����

							// ���� ���� �Ұ������� Ȯ��
							LocalDate today = LocalDate.now();
							if (selectedDate.isEqual(today)) {
								JOptionPane.showMessageDialog(null, "���� ������ �Ұ����մϴ�. �ٸ� ��¥�� �������ּ���.", "���� �Ұ�",
										JOptionPane.WARNING_MESSAGE);
								return;
							}

							// ���� ���� ���� �Ұ������� Ȯ��
							if (selectedDate.isBefore(today)) {
								JOptionPane.showMessageDialog(null, "���� ���� ������ �Ұ����մϴ�. �ٸ� ��¥�� �������ּ���.", "���� �Ұ�",
										JOptionPane.WARNING_MESSAGE);
								return;
							}

							// �Թ� ���� ���� ����
							GardenVO gardenVO = new GardenVO();
							int ����_�ڵ� = 0;
							gardenVO.setBookingcode(����_�ڵ�);
							gardenVO.setBdate(selectedDate.toString()); // �Թ� ���� ��¥�� �����ؾ� ��
							gardenVO.setBstart(startDate.toString()); // �Թ� ��� �������� ������ ��¥�� ����
							gardenVO.setBend(endDate.toString()); // �Թ� ��� �������� �����ؾ� ��
							gardenVO.setBcheck("�Թ� �뿩 ����"); // �Թ� �뿩 ���θ� �����ؾ� ��
							int ȸ��_�ڵ� = 12;
							gardenVO.setMembercode(ȸ��_�ڵ�); // ȸ�� �ڵ带 �����ؾ� ��
							int �Թ�_�ڵ� = 2;
							gardenVO.setGardencode(�Թ�_�ڵ�);

							// ���� ���� �߰�
							try {
								gardenDAO.insertBooking(gardenVO);
							} catch (Exception e1) {
								e1.printStackTrace();
							}

							// ���� �Ϸ� �޽��� �Ǵ� �۾� �Ϸ� �� �ʿ��� ���� ����
							JOptionPane.showMessageDialog(null, "���� �� ���Ⱓ�� 3�����Դϴ�." + "\n" + "������ ��������Դϴ�.", "���� �˸�",
									JOptionPane.INFORMATION_MESSAGE);

							// ���� �Ϸ� �޽��� �� ���� ����
							int choice = JOptionPane.showOptionDialog(null, "������ �Ͻðڽ��ϱ�?", "���� Ȯ��",
									JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
							if (choice == JOptionPane.YES_OPTION) {
								// ���� �Ϸ�
								JOptionPane.showMessageDialog(null, "������ �Ϸ�Ǿ����ϴ�.", "���� �Ϸ�",
										JOptionPane.INFORMATION_MESSAGE);
								btnNewButton_2.setEnabled(false); // �����ϱ� ��ư ��Ȱ��ȭ
							} else {
								// ���� ���
								JOptionPane.showMessageDialog(null, "������ ��ҵǾ����ϴ�.", "���� ���",
										JOptionPane.INFORMATION_MESSAGE);
							}

							// Ķ���� ���̾�α� �ݱ�
							calendarDialog.dispose();
						}
					});

					// Ķ���� ���̾�α׿� Ķ���� �г� �߰�
					calendarDialog.getContentPane().add(calendarPanel);
					calendarDialog.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});

		JButton btnNewButton_2_3 = new JButton("\uC608\uC57D \uD558\uAE30\r\n");
		btnNewButton_2_3.setBounds(279, 469, 97, 23);
		contentPane.add(btnNewButton_2_3);
		btnNewButton_2_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					GardenDAO gardenDAO = new GardenDAO();

					// Ķ���� ���̾�α� ����
					JDialog calendarDialog = new JDialog();
					calendarDialog.setTitle("��¥ ����");
					calendarDialog.setModal(true);
					calendarDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					calendarDialog.setBounds(100, 100, 300, 300);
					calendarDialog.getContentPane().setLayout(new BorderLayout());

					// Ķ���� �г� ����
					JPanel calendarPanel = new JPanel();
					calendarPanel.setLayout(new BorderLayout());

					// Ķ���� ������Ʈ ����
					JCalendar calendar = new JCalendar();
					calendarPanel.add(calendar, BorderLayout.CENTER);

					// Ȯ�� ��ư ����
					JButton confirmButton = new JButton("Ȯ��");
					calendarPanel.add(confirmButton, BorderLayout.SOUTH);

					// Ȯ�� ��ư Ŭ�� �� ������ ��¥ ��������
					confirmButton.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							LocalDate selectedDate = calendar.getDate().toInstant().atZone(ZoneId.systemDefault())
									.toLocalDate();
							LocalDate startDate = selectedDate; // ������ ��¥�� �����Ϸ� ����
							LocalDate endDate = startDate.plusDays(90); // �Թ� ��� �������� �����Ϸκ��� 14�� �ķ� ����

							// ���� ���� �Ұ������� Ȯ��
							LocalDate today = LocalDate.now();
							if (selectedDate.isEqual(today)) {
								JOptionPane.showMessageDialog(null, "���� ������ �Ұ����մϴ�. �ٸ� ��¥�� �������ּ���.", "���� �Ұ�",
										JOptionPane.WARNING_MESSAGE);
								return;
							}

							// ���� ���� ���� �Ұ������� Ȯ��
							if (selectedDate.isBefore(today)) {
								JOptionPane.showMessageDialog(null, "���� ���� ������ �Ұ����մϴ�. �ٸ� ��¥�� �������ּ���.", "���� �Ұ�",
										JOptionPane.WARNING_MESSAGE);
								return;
							}

							// �Թ� ���� ���� ����
							GardenVO gardenVO = new GardenVO();
							int ����_�ڵ� = 0;
							gardenVO.setBookingcode(����_�ڵ�);
							gardenVO.setBdate(selectedDate.toString()); // �Թ� ���� ��¥�� �����ؾ� ��
							gardenVO.setBstart(startDate.toString()); // �Թ� ��� �������� ������ ��¥�� ����
							gardenVO.setBend(endDate.toString()); // �Թ� ��� �������� �����ؾ� ��
							gardenVO.setBcheck("�Թ� �뿩 ����"); // �Թ� �뿩 ���θ� �����ؾ� ��
							int ȸ��_�ڵ� = 12;
							gardenVO.setMembercode(ȸ��_�ڵ�); // ȸ�� �ڵ带 �����ؾ� ��
							int �Թ�_�ڵ� = 3;
							gardenVO.setGardencode(�Թ�_�ڵ�);

							// ���� ���� �߰�
							try {
								gardenDAO.insertBooking(gardenVO);
							} catch (Exception e1) {
								e1.printStackTrace();
							}

							// ���� �Ϸ� �޽��� �Ǵ� �۾� �Ϸ� �� �ʿ��� ���� ����
							JOptionPane.showMessageDialog(null, "���� �� ���Ⱓ�� 3�����Դϴ�." + "\n" + "������ ��������Դϴ�.", "���� �˸�",
									JOptionPane.INFORMATION_MESSAGE);

							// ���� �Ϸ� �޽��� �� ���� ����
							int choice = JOptionPane.showOptionDialog(null, "������ �Ͻðڽ��ϱ�?", "���� Ȯ��",
									JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
							if (choice == JOptionPane.YES_OPTION) {
								// ���� �Ϸ�
								JOptionPane.showMessageDialog(null, "������ �Ϸ�Ǿ����ϴ�.", "���� �Ϸ�",
										JOptionPane.INFORMATION_MESSAGE);
								btnNewButton_2_3.setEnabled(false); // �����ϱ� ��ư ��Ȱ��ȭ
							} else {
								// ���� ���
								JOptionPane.showMessageDialog(null, "������ ��ҵǾ����ϴ�.", "���� ���",
										JOptionPane.INFORMATION_MESSAGE);
							}

							// Ķ���� ���̾�α� �ݱ�
							calendarDialog.dispose();
						}
					});

					// Ķ���� ���̾�α׿� Ķ���� �г� �߰�
					calendarDialog.getContentPane().add(calendarPanel);
					calendarDialog.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});

		JButton btnNewButton_2_1 = new JButton("\uC608\uC57D \uD558\uAE30\r\n");
		btnNewButton_2_1.setBounds(478, 469, 97, 23);
		contentPane.add(btnNewButton_2_1);
		btnNewButton_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					GardenDAO gardenDAO = new GardenDAO();

					// Ķ���� ���̾�α� ����
					JDialog calendarDialog = new JDialog();
					calendarDialog.setTitle("��¥ ����");
					calendarDialog.setModal(true);
					calendarDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					calendarDialog.setBounds(100, 100, 300, 300);
					calendarDialog.getContentPane().setLayout(new BorderLayout());

					// Ķ���� �г� ����
					JPanel calendarPanel = new JPanel();
					calendarPanel.setLayout(new BorderLayout());

					// Ķ���� ������Ʈ ����
					JCalendar calendar = new JCalendar();
					calendarPanel.add(calendar, BorderLayout.CENTER);

					// Ȯ�� ��ư ����
					JButton confirmButton = new JButton("Ȯ��");
					calendarPanel.add(confirmButton, BorderLayout.SOUTH);

					// Ȯ�� ��ư Ŭ�� �� ������ ��¥ ��������
					confirmButton.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							LocalDate selectedDate = calendar.getDate().toInstant().atZone(ZoneId.systemDefault())
									.toLocalDate();
							LocalDate startDate = selectedDate; // ������ ��¥�� �����Ϸ� ����
							LocalDate endDate = startDate.plusDays(90); // �Թ� ��� �������� �����Ϸκ��� 14�� �ķ� ����

							// ���� ���� �Ұ������� Ȯ��
							LocalDate today = LocalDate.now();
							if (selectedDate.isEqual(today)) {
								JOptionPane.showMessageDialog(null, "���� ������ �Ұ����մϴ�. �ٸ� ��¥�� �������ּ���.", "���� �Ұ�",
										JOptionPane.WARNING_MESSAGE);
								return;
							}

							// ���� ���� ���� �Ұ������� Ȯ��
							if (selectedDate.isBefore(today)) {
								JOptionPane.showMessageDialog(null, "���� ���� ������ �Ұ����մϴ�. �ٸ� ��¥�� �������ּ���.", "���� �Ұ�",
										JOptionPane.WARNING_MESSAGE);
								return;
							}

							// �Թ� ���� ���� ����
							GardenVO gardenVO = new GardenVO();
							int ����_�ڵ� = 0;
							gardenVO.setBookingcode(����_�ڵ�);
							gardenVO.setBdate(selectedDate.toString()); // �Թ� ���� ��¥�� �����ؾ� ��
							gardenVO.setBstart(startDate.toString()); // �Թ� ��� �������� ������ ��¥�� ����
							gardenVO.setBend(endDate.toString()); // �Թ� ��� �������� �����ؾ� ��
							gardenVO.setBcheck("�Թ� �뿩 ����"); // �Թ� �뿩 ���θ� �����ؾ� ��
							int ȸ��_�ڵ� = 12;
							gardenVO.setMembercode(ȸ��_�ڵ�); // ȸ�� �ڵ带 �����ؾ� ��
							int �Թ�_�ڵ� = 4;
							gardenVO.setGardencode(�Թ�_�ڵ�);

							// ���� ���� �߰�
							try {
								gardenDAO.insertBooking(gardenVO);
							} catch (Exception e1) {
								e1.printStackTrace();
							}

							// ���� �Ϸ� �޽��� �Ǵ� �۾� �Ϸ� �� �ʿ��� ���� ����
							JOptionPane.showMessageDialog(null, "���� �� ���Ⱓ�� 3�����Դϴ�." + "\n" + "������ ��������Դϴ�.", "���� �˸�",
									JOptionPane.INFORMATION_MESSAGE);

							// ���� �Ϸ� �޽��� �� ���� ����
							int choice = JOptionPane.showOptionDialog(null, "������ �Ͻðڽ��ϱ�?", "���� Ȯ��",
									JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
							if (choice == JOptionPane.YES_OPTION) {
								// ���� �Ϸ�
								JOptionPane.showMessageDialog(null, "������ �Ϸ�Ǿ����ϴ�.", "���� �Ϸ�",
										JOptionPane.INFORMATION_MESSAGE);
								btnNewButton_2_1.setEnabled(false); // �����ϱ� ��ư ��Ȱ��ȭ
							} else {
								// ���� ���
								JOptionPane.showMessageDialog(null, "������ ��ҵǾ����ϴ�.", "���� ���",
										JOptionPane.INFORMATION_MESSAGE);
							}

							// Ķ���� ���̾�α� �ݱ�
							calendarDialog.dispose();
						}
					});

					// Ķ���� ���̾�α׿� Ķ���� �г� �߰�
					calendarDialog.getContentPane().add(calendarPanel);
					calendarDialog.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});

		JButton btnNewButton_2_2 = new JButton("\uC608\uC57D \uD558\uAE30\r\n");
		btnNewButton_2_2.setBounds(703, 467, 97, 23);
		contentPane.add(btnNewButton_2_2);
		btnNewButton_2_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					GardenDAO gardenDAO = new GardenDAO();

					// Ķ���� ���̾�α� ����
					JDialog calendarDialog = new JDialog();
					calendarDialog.setTitle("��¥ ����");
					calendarDialog.setModal(true);
					calendarDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					calendarDialog.setBounds(100, 100, 300, 300);
					calendarDialog.getContentPane().setLayout(new BorderLayout());

					// Ķ���� �г� ����
					JPanel calendarPanel = new JPanel();
					calendarPanel.setLayout(new BorderLayout());

					// Ķ���� ������Ʈ ����
					JCalendar calendar = new JCalendar();
					calendarPanel.add(calendar, BorderLayout.CENTER);

					// Ȯ�� ��ư ����
					JButton confirmButton = new JButton("Ȯ��");
					calendarPanel.add(confirmButton, BorderLayout.SOUTH);

					// Ȯ�� ��ư Ŭ�� �� ������ ��¥ ��������
					confirmButton.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							LocalDate selectedDate = calendar.getDate().toInstant().atZone(ZoneId.systemDefault())
									.toLocalDate();
							LocalDate startDate = selectedDate; // ������ ��¥�� �����Ϸ� ����
							LocalDate endDate = startDate.plusDays(90); // �Թ� ��� �������� �����Ϸκ��� 14�� �ķ� ����

							// ���� ���� �Ұ������� Ȯ��
							LocalDate today = LocalDate.now();
							if (selectedDate.isEqual(today)) {
								JOptionPane.showMessageDialog(null, "���� ������ �Ұ����մϴ�. �ٸ� ��¥�� �������ּ���.", "���� �Ұ�",
										JOptionPane.WARNING_MESSAGE);
								return;
							}

							// ���� ���� ���� �Ұ������� Ȯ��
							if (selectedDate.isBefore(today)) {
								JOptionPane.showMessageDialog(null, "���� ���� ������ �Ұ����մϴ�. �ٸ� ��¥�� �������ּ���.", "���� �Ұ�",
										JOptionPane.WARNING_MESSAGE);
								return;
							}

							// �Թ� ���� ���� ����
							GardenVO gardenVO = new GardenVO();
							int ����_�ڵ� = 0;
							gardenVO.setBookingcode(����_�ڵ�);
							gardenVO.setBdate(selectedDate.toString()); // �Թ� ���� ��¥�� �����ؾ� ��
							gardenVO.setBstart(startDate.toString()); // �Թ� ��� �������� ������ ��¥�� ����
							gardenVO.setBend(endDate.toString()); // �Թ� ��� �������� �����ؾ� ��
							gardenVO.setBcheck("�Թ� �뿩 ����"); // �Թ� �뿩 ���θ� �����ؾ� ��
							int ȸ��_�ڵ� = 12;
							gardenVO.setMembercode(ȸ��_�ڵ�); // ȸ�� �ڵ带 �����ؾ� ��
							int �Թ�_�ڵ� = 5;
							gardenVO.setGardencode(�Թ�_�ڵ�);

							// ���� ���� �߰�
							try {
								gardenDAO.insertBooking(gardenVO);
							} catch (Exception e1) {
								e1.printStackTrace();
							}

							// ���� �Ϸ� �޽��� �Ǵ� �۾� �Ϸ� �� �ʿ��� ���� ����
							JOptionPane.showMessageDialog(null, "���� �� ���Ⱓ�� 3�����Դϴ�." + "\n" + "������ ��������Դϴ�.", "���� �˸�",
									JOptionPane.INFORMATION_MESSAGE);

							// ���� �Ϸ� �޽��� �� ���� ����
							int choice = JOptionPane.showOptionDialog(null, "������ �Ͻðڽ��ϱ�?", "���� Ȯ��",
									JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
							if (choice == JOptionPane.YES_OPTION) {
								// ���� �Ϸ�
								JOptionPane.showMessageDialog(null, "������ �Ϸ�Ǿ����ϴ�.", "���� �Ϸ�",
										JOptionPane.INFORMATION_MESSAGE);
								btnNewButton_2_2.setEnabled(false); // �����ϱ� ��ư ��Ȱ��ȭ
							} else {
								// ���� ���
								JOptionPane.showMessageDialog(null, "������ ��ҵǾ����ϴ�.", "���� ���",
										JOptionPane.INFORMATION_MESSAGE);
							}

							// Ķ���� ���̾�α� �ݱ�
							calendarDialog.dispose();
						}
					});

					// Ķ���� ���̾�α׿� Ķ���� �г� �߰�
					calendarDialog.getContentPane().add(calendarPanel);
					calendarDialog.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});

		JButton btnNewButton_2_4 = new JButton("\uC608\uC57D \uD558\uAE30\r\n");
		btnNewButton_2_4.setBounds(930, 467, 97, 23);
		contentPane.add(btnNewButton_2_4);
		btnNewButton_2_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					GardenDAO gardenDAO = new GardenDAO();

					// Ķ���� ���̾�α� ����
					JDialog calendarDialog = new JDialog();
					calendarDialog.setTitle("��¥ ����");
					calendarDialog.setModal(true);
					calendarDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					calendarDialog.setBounds(100, 100, 300, 300);
					calendarDialog.getContentPane().setLayout(new BorderLayout());

					// Ķ���� �г� ����
					JPanel calendarPanel = new JPanel();
					calendarPanel.setLayout(new BorderLayout());

					// Ķ���� ������Ʈ ����
					JCalendar calendar = new JCalendar();
					calendarPanel.add(calendar, BorderLayout.CENTER);

					// Ȯ�� ��ư ����
					JButton confirmButton = new JButton("Ȯ��");
					calendarPanel.add(confirmButton, BorderLayout.SOUTH);

					// Ȯ�� ��ư Ŭ�� �� ������ ��¥ ��������
					confirmButton.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							LocalDate selectedDate = calendar.getDate().toInstant().atZone(ZoneId.systemDefault())
									.toLocalDate();
							LocalDate startDate = selectedDate; // ������ ��¥�� �����Ϸ� ����
							LocalDate endDate = startDate.plusDays(90); // �Թ� ��� �������� �����Ϸκ��� 14�� �ķ� ����

							// ���� ���� �Ұ������� Ȯ��
							LocalDate today = LocalDate.now();
							if (selectedDate.isEqual(today)) {
								JOptionPane.showMessageDialog(null, "���� ������ �Ұ����մϴ�. �ٸ� ��¥�� �������ּ���.", "���� �Ұ�",
										JOptionPane.WARNING_MESSAGE);
								return;
							}

							// ���� ���� ���� �Ұ������� Ȯ��
							if (selectedDate.isBefore(today)) {
								JOptionPane.showMessageDialog(null, "���� ���� ������ �Ұ����մϴ�. �ٸ� ��¥�� �������ּ���.", "���� �Ұ�",
										JOptionPane.WARNING_MESSAGE);
								return;
							}
							// �Թ� ���� ���� ����
							GardenVO gardenVO = new GardenVO();
							int ����_�ڵ� = 0;
							gardenVO.setBookingcode(����_�ڵ�);
							gardenVO.setBdate(selectedDate.toString()); // �Թ� ���� ��¥�� �����ؾ� ��
							gardenVO.setBstart(startDate.toString()); // �Թ� ��� �������� ������ ��¥�� ����
							gardenVO.setBend(endDate.toString()); // �Թ� ��� �������� �����ؾ� ��
							gardenVO.setBcheck("�Թ� �뿩 ����"); // �Թ� �뿩 ���θ� �����ؾ� ��
							int ȸ��_�ڵ� = 12;
							gardenVO.setMembercode(ȸ��_�ڵ�); // ȸ�� �ڵ带 �����ؾ� ��
							int �Թ�_�ڵ� = 6;
							gardenVO.setGardencode(�Թ�_�ڵ�);

							// ���� ���� �߰�
							try {
								gardenDAO.insertBooking(gardenVO);
							} catch (Exception e1) {
								e1.printStackTrace();
							}

							// ���� �Ϸ� �޽��� �Ǵ� �۾� �Ϸ� �� �ʿ��� ���� ����
							JOptionPane.showMessageDialog(null, "���� �� ���Ⱓ�� 3�����Դϴ�." + "\n" + "������ ��������Դϴ�.", "���� �˸�",
									JOptionPane.INFORMATION_MESSAGE);

							// ���� �Ϸ� �޽��� �� ���� ����
							int choice = JOptionPane.showOptionDialog(null, "������ �Ͻðڽ��ϱ�?", "���� Ȯ��",
									JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
							if (choice == JOptionPane.YES_OPTION) {
								// ���� �Ϸ�
								JOptionPane.showMessageDialog(null, "������ �Ϸ�Ǿ����ϴ�.", "���� �Ϸ�",
										JOptionPane.INFORMATION_MESSAGE);
								btnNewButton_2_4.setEnabled(false); // �����ϱ� ��ư ��Ȱ��ȭ
							} else {
								// ���� ���
								JOptionPane.showMessageDialog(null, "������ ��ҵǾ����ϴ�.", "���� ���",
										JOptionPane.INFORMATION_MESSAGE);
							}

							// Ķ���� ���̾�α� �ݱ�
							calendarDialog.dispose();
						}
					});

					// Ķ���� ���̾�α׿� Ķ���� �г� �߰�
					calendarDialog.getContentPane().add(calendarPanel);
					calendarDialog.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});

		JButton bookingbtn = new JButton("\uB098\uC758\uC608\uC57D\uD604\uD669");
		bookingbtn.setFont(new Font("�������", Font.BOLD, 15));
		bookingbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					GardenbookingView gardenbooking = new GardenbookingView(pk, nick, point);
					gardenbooking.setVisible(true);
				} catch (Exception e2) {
					// TODO: handle exception
				}
				dispose();
			}
		});
		bookingbtn.setBounds(872, 10, 121, 106);
		contentPane.add(bookingbtn);
		try {
			GardenDAO gardenDAO = new GardenDAO();
			ArrayList<GardenVO> gardens = gardenDAO.getAllGardens();
			if (!gardens.isEmpty()) {
				GardenVO garden1 = gardens.get(0);
				textField.setText("�Թ� �� : " + garden1.getGaddr());
				textField_1.setText("�Թ� �뿩�� : " + garden1.getGprice());
				textField_2.setText("�Թ� ��� : " + garden1.getGsize());
				if (gardens.size() > 1) {
					GardenVO garden2 = gardens.get(1);
					textField_3.setText("�Թ� �� : " + garden2.getGaddr());
					textField_4.setText("�Թ� �뿩�� : " + garden2.getGprice());
					textField_5.setText("�Թ� ��� : " + garden2.getGsize());
				}

				if (gardens.size() > 2) {
					GardenVO garden3 = gardens.get(2);
					textField_6.setText("�Թ� �� : " + garden3.getGaddr());
					textField_7.setText("�Թ� �뿩�� : " + garden3.getGprice());
					textField_8.setText("�Թ� ��� : " + garden3.getGsize());
				}

				if (gardens.size() > 3) {
					GardenVO garden4 = gardens.get(3);
					textField_9.setText("�Թ� �� : " + garden4.getGaddr());
					textField_10.setText("�Թ� �뿩�� : " + garden4.getGprice());
					textField_11.setText("�Թ� ��� : " + garden4.getGsize());
				}

				if (gardens.size() > 4) {
					GardenVO garden5 = gardens.get(4);
					textField_12.setText("�Թ� �� : " + garden5.getGaddr());
					textField_13.setText("�Թ� �뿩�� : " + garden5.getGprice());
					textField_14.setText("�Թ� ��� : " + garden5.getGsize());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}