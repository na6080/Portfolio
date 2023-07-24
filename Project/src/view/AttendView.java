package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDayChooser;

import model.CustomerDAO;
import model.rec.CustomerVO;

public class AttendView extends JFrame {

	JPanel contentPane;
	JTextField textField;
	JPasswordField passwordField;

	private JButton attendanceButton;
	private JLabel statusLabel;
	private JCalendar calendar;

	private int attendanceCount;
	private LocalDate lastCheckedDate;
	private JButton btnmypageback;

	CustomerDAO dao;
	CustomerVO vo;

	ArrayList list;

	static int pk;
	static String nick;
	static int point;

	private boolean isAttendanceChecked;

	public AttendView(int pk, String nick, int point) {
		this.pk = pk;
		this.nick = nick;
		this.point = point;

		attendanceCount = 0;
		lastCheckedDate = LocalDate.now(ZoneId.of("Asia/Seoul"));

		attendanceButton = new JButton("�⼮üũ");
		attendanceButton.setFont(new Font("�������", Font.PLAIN, 15));
		attendanceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LocalDateTime currentDateTime = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
				LocalDate currentDate = currentDateTime.toLocalDate();
				LocalDate selectedDate = LocalDate.of(calendar.getYearChooser().getYear(),
						calendar.getMonthChooser().getMonth() + 1, calendar.getDayChooser().getDay());

				if (selectedDate.equals(currentDate)) {
					if (currentDateTime.getHour() >= 0 && currentDateTime.getHour() < 24) {
						if (!isAttendanceChecked) {
							attendanceCount++;
							statusLabel.setText("�⼮ �Ϸ�! �⼮ Ƚ��: " + attendanceCount);
							markCheckedDate(currentDate);
							lastCheckedDate = currentDate; // �⼮üũ�� ��¥ ����
							isAttendanceChecked = true;
							int earnedPoint = generateRandomPoint(); // ���� ����Ʈ ����
							// point += earnedPoint;
							JOptionPane.showMessageDialog(null, "�⼮�� �Ϸ�Ǿ����ϴ�. ����Ʈ " + earnedPoint + "���� ȹ���ϼ̽��ϴ�.", "�˸�",
									JOptionPane.INFORMATION_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(null, "�̹� �⼮üũ�� �ϼ̽��ϴ�.", "�˸�",
									JOptionPane.INFORMATION_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null, "�⼮üũ ������ �ð��� �ƴմϴ�.", "�˸�",
								JOptionPane.INFORMATION_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "���� ��¥�� �⼮üũ �����մϴ�.", "�˸�", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		statusLabel = new JLabel("\t\t\t\t\t\t\t\t�⼮ Ƚ��: 0");

		calendar = new JCalendar();
		calendar.setPreferredSize(new Dimension(800, 800)); // �޷� ũ�� ����
		calendar.getDayChooser().addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent e) {
				if ("day".equals(e.getPropertyName())) {
					LocalDate selectedDate = LocalDate.of(calendar.getYearChooser().getYear(),
							calendar.getMonthChooser().getMonth() + 1, (int) e.getNewValue());
					LocalDateTime selectedDateTime = LocalDateTime.of(selectedDate,
							LocalTime.now(ZoneId.of("Asia/Seoul")));
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
					if (selectedDateTime.isBefore(LocalDateTime.now(ZoneId.of("Asia/Seoul")))) {
						JOptionPane.showMessageDialog(null, "���� ��¥�� ������ �� �����ϴ�.", "���", JOptionPane.WARNING_MESSAGE);
						calendar.getDayChooser().setDay(lastCheckedDate.getDayOfMonth());
					} else if (selectedDateTime.isAfter(LocalDateTime.now(ZoneId.of("Asia/Seoul")))) {
						JOptionPane.showMessageDialog(null, "������ ��¥�� �⼮üũ�� �� �� �����ϴ�.", "�˸�",
								JOptionPane.INFORMATION_MESSAGE);
						calendar.getDayChooser().setDay(lastCheckedDate.getDayOfMonth());
					}
				}
			}
		});

		markCheckedDate(lastCheckedDate); // �̹� �⼮üũ�� ��¥�� ���׶�� ǥ��

		JPanel contentPane = (JPanel) getContentPane();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(attendanceButton, BorderLayout.NORTH);

		btnmypageback = new JButton("����������");
		btnmypageback.setFont(new Font("�������", Font.PLAIN, 15));
		btnmypageback.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				MyPageView MyPageView = new MyPageView(pk, nick, point);
				MyPageView.setVisible(true);

			}
		});

		JButton additionalButton = new JButton("Ȩ");
		additionalButton.setFont(new Font("�������", Font.PLAIN, 15));
		additionalButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// ��ư Ŭ�� �̺�Ʈ ó��
				dispose();
				MainHomeView MainHomeView = new MainHomeView(pk, nick, point);
				MainHomeView.setVisible(true);
			}
		});

		contentPane.add(additionalButton, BorderLayout.WEST);

		getContentPane().add(btnmypageback, BorderLayout.EAST);
		contentPane.add(statusLabel, BorderLayout.CENTER);
		contentPane.add(calendar, BorderLayout.SOUTH);
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("�⼮üũ��Ȳ");
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void markCheckedDate(LocalDate date) {
		JDayChooser dayChooser = calendar.getDayChooser();
		YearMonth yearMonth = YearMonth.of(date.getYear(), date.getMonthValue());
		int daysInMonth = yearMonth.lengthOfMonth();
		for (int i = 1; i <= daysInMonth; i++) {
			if (i == date.getDayOfMonth()) {
				dayChooser.setDay(i);
				break;
			}
		}
	}

	private int generateRandomPoint() {
		Random rand = new Random();
		int earnedPoint = rand.nextInt(11) + 10; // 10~20 ������ ���� ����Ʈ ����
		return earnedPoint;
	}

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					AttendView frame = new AttendView(pk, nick, point);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
