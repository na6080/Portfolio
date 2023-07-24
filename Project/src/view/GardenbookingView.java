package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;

import model.GardenbookingDAO;

public class GardenbookingView extends JFrame {

	JPanel contentPane;
	JTable bookingtable;
	JComboBox<String> comboBox; // JComboBox ���׸� Ÿ�� ����
	JScrollPane scrollPane;
	JPanel panel;

	// GardenbookingDAO ��ü ����
	GardenbookingDAO dao;

	// ���� ���̺� ��
	BookingTableModel bookingModel;
	static int pk;
	static String nick;
	static int point;

	final int MAX_CANCEL_COUNT = 3;
	final AtomicInteger cancelCount = new AtomicInteger(0);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GardenbookingView frame = new GardenbookingView(pk, nick, point);
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
	public GardenbookingView(int pk, String nick, int point) {
		this.pk = pk;
		this.nick = nick;
		this.point = point;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 793, 581);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		comboBox = new JComboBox<String>();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int selectedIndex = comboBox.getSelectedIndex();
				if (selectedIndex == 0) {
					// ���� ���� ��ȸ
					try {
						ArrayList<ArrayList<String>> data = dao.bookingSearch();
						bookingModel.setData(data);
						bookingModel.setColumnNames(new String[] { "�Թ��", "���೯¥", "��������", "��������", "�Ѵ뿩��" });
						bookingModel.fireTableStructureChanged();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
					// bookingtable�� ǥ��
					scrollPane.setViewportView(bookingtable);
					bookingtable.setVisible(true);
				}
			}
		});
		comboBox.setFont(new Font("�������", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "�Թ翹��" }));
		comboBox.setBounds(12, 60, 86, 49);
		contentPane.add(comboBox);

		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(12, 109, 753, 339);
		contentPane.add(scrollPane);

		bookingtable = new JTable();
		bookingtable.setForeground(new Color(0, 0, 0));
		scrollPane.setViewportView(bookingtable);

		JLabel remainingCancelLabel;
		remainingCancelLabel = new JLabel();
		remainingCancelLabel.setFont(new Font("�������", Font.BOLD, 17));
		remainingCancelLabel.setBounds(12, 460, 150, 20);
		contentPane.add(remainingCancelLabel);
		remainingCancelLabel.setText("���� ��� Ƚ��: " + (MAX_CANCEL_COUNT - cancelCount.get()));

		JButton searchButton = new JButton("�˻�");
		searchButton.setBounds(698, 61, 67, 49);
		contentPane.add(searchButton);
		searchButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// ���� ���� �˻�
				try {
					ArrayList<ArrayList<String>> data = dao.bookingSearch();
					bookingModel.setData(data);
					bookingModel.setColumnNames(new String[] { "�Թ��", "���೯¥", "��������", "��������", "�Ѵ뿩��" });
					bookingModel.fireTableStructureChanged();
					// bookingtable�� ǥ��
					scrollPane.setViewportView(bookingtable);
					bookingtable.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});

		JButton btnNewButton = new JButton("�������");
		btnNewButton.setBounds(559, 483, 97, 49);
		contentPane.add(btnNewButton);
		// ������� ��ư �̺�Ʈ �ڵ鷯 ����
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedIndex = bookingtable.convertRowIndexToModel(bookingtable.getSelectedRow());
				if (selectedIndex != -1) {
					// ���õ� ������ �ִ� ���
					try {
						// ���� ��� ���ǻ��� ǥ��
						String cautionMessage = "�� ���� ��\n" + "���� ��Ҵ� 3ȸ������ �����մϴ�.";
						JOptionPane.showMessageDialog(null, cautionMessage, "���ǻ���", JOptionPane.WARNING_MESSAGE);

						// ���� ��� Ȯ�� �޽��� ǥ��
						int confirm = JOptionPane.showConfirmDialog(null, "������ ����Ͻðڽ��ϱ�?", "���� ��� Ȯ��",
								JOptionPane.YES_NO_OPTION);
						if (confirm == JOptionPane.YES_OPTION) {
							synchronized (cancelCount) {
								if (cancelCount.get() < MAX_CANCEL_COUNT) {
									dao.cancelBooking(selectedIndex);
									// ���� ���� �ٽ� ��ȸ
									ArrayList<ArrayList<String>> data = dao.bookingSearch();
									bookingModel.setData(data);
									bookingModel.fireTableDataChanged(); // ������ ���� �˸� �߰�
									// �޽��� ǥ��
									JOptionPane.showMessageDialog(null, "������ ��ҵǾ����ϴ�.");
									cancelCount.incrementAndGet(); // ��� Ƚ�� ����
									remainingCancelLabel.setText("���� ��� Ƚ��: " + (MAX_CANCEL_COUNT - cancelCount.get()));
								} else {
									JOptionPane.showMessageDialog(null, "�� �̻� ����� �� �����ϴ�.");
								}
							}
						}
					} catch (Exception ex) {
						ex.printStackTrace();
						JOptionPane.showMessageDialog(null, "���� ��� �� ������ �߻��߽��ϴ�.");
					}
				} else {
					// ���õ� ������ ���� ���
					JOptionPane.showMessageDialog(null, "����� ������ �������ּ���.");
				}
			}
		});

		JButton btnNewButton_1 = new JButton("����");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					dispose();
					GardenView garden = new GardenView(pk, nick, point);
					garden.setVisible(true);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(668, 483, 97, 49);
		contentPane.add(btnNewButton_1);

		panel = new JPanel();
		panel.setBounds(12, 109, 753, 339);
		contentPane.add(panel);
		panel.setLayout(null);

		// GardenbookingDAO ��ü ����
		try {
			dao = new GardenbookingDAO();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "�����ͺ��̽� ���ῡ �����߽��ϴ�.");
			e.printStackTrace();
		}
		// ���� ���̺� �� �ʱ�ȭ
		bookingModel = new BookingTableModel();
		bookingtable.setModel(bookingModel);

		// �ʱ� ���¿����� bookingtable�� ǥ��
		scrollPane.setViewportView(bookingtable);
		bookingtable.setVisible(true);
	}

	// ���� ���̺� �� Ŭ����
	class BookingTableModel extends AbstractTableModel {
		private ArrayList<ArrayList<String>> data = new ArrayList<>();
		private String[] columnNames = { "�Թ��", "���೯¥", "��������", "��������", "�Ѵ뿩��" };

		public void setData(ArrayList<ArrayList<String>> data) {
			this.data = data;
			fireTableDataChanged(); // ������ ���� �˸� �߰�
		}

		@Override
		public int getColumnCount() {
			return columnNames.length;
		}

		@Override
		public int getRowCount() {
			return data.size();
		}

		@Override
		public Object getValueAt(int row, int col) {
			ArrayList<String> rowData = data.get(row);
			return rowData.get(col);
		}

		public String getColumnName(int col) {
			return columnNames[col];
		}

		public void setColumnNames(String[] columnNames) {
			this.columnNames = columnNames;
		}
	}
}
