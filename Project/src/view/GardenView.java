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
				String imagePath = "C:\\Users\\lee\\Documents\\카카오톡 받은 파일\\텃밭사진\\텃밭안내.jpg";

				// 이미지 아이콘 생성
				ImageIcon imageIcon = new ImageIcon(imagePath);

				// JLabel 생성 및 이미지 아이콘 설정
				JLabel label = new JLabel(imageIcon);

				// JDialog 생성 및 설정
				JDialog dialog = new JDialog();
				dialog.setTitle("Image Popup");
				dialog.setModal(true);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.getContentPane().add(label);
				dialog.pack();
				dialog.setLocationRelativeTo(null); // 중앙에 위치하도록 설정
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
		btnNewButton_1.setFont(new Font("나눔고딕", Font.BOLD, 15));
		btnNewButton_1.setBounds(1005, 10, 121, 106);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(GardenView.class.getResource("/image/텃밭1.jpg")));
		lblNewLabel.setBounds(39, 171, 172, 193);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(GardenView.class.getResource("/image/텃밭2.jpg")));
		lblNewLabel_1.setBounds(243, 171, 172, 193);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("New label");
		lblNewLabel_1_1.setIcon(new ImageIcon(GardenView.class.getResource("/image/텃밭4.jpg")));
		lblNewLabel_1_1.setBounds(651, 171, 199, 193);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(GardenView.class.getResource("/image/텃밭3.jpg")));
		lblNewLabel_2.setBounds(447, 171, 172, 193);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(GardenView.class.getResource("/image/텃밭5.jpg")));
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

		btnNewButton_2 = new JButton("예약하기");
		btnNewButton_2.setBounds(78, 467, 97, 23);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					GardenDAO gardenDAO = new GardenDAO();

					// 캘린더 다이얼로그 생성
					JDialog calendarDialog = new JDialog();
					calendarDialog.setTitle("날짜 선택");
					calendarDialog.setModal(true);
					calendarDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					calendarDialog.setBounds(100, 100, 300, 300);
					calendarDialog.getContentPane().setLayout(new BorderLayout());

					// 캘린더 패널 생성
					JPanel calendarPanel = new JPanel();
					calendarPanel.setLayout(new BorderLayout());

					// 캘린더 컴포넌트 생성
					JCalendar calendar = new JCalendar();
					calendarPanel.add(calendar, BorderLayout.CENTER);

					// 확인 버튼 생성
					JButton confirmButton = new JButton("확인");
					calendarPanel.add(confirmButton, BorderLayout.SOUTH);

					// 확인 버튼 클릭 시 선택한 날짜 가져오기
					confirmButton.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							LocalDate selectedDate = calendar.getDate().toInstant().atZone(ZoneId.systemDefault())
									.toLocalDate();
							LocalDate startDate = selectedDate; // 선택한 날짜를 시작일로 설정
							LocalDate endDate = startDate.plusDays(90); // 텃밭 사용 종료일을 시작일로부터 14일 후로 설정

							// 당일 예약 불가능한지 확인
							LocalDate today = LocalDate.now();
							if (selectedDate.isEqual(today)) {
								JOptionPane.showMessageDialog(null, "당일 예약은 불가능합니다. 다른 날짜를 선택해주세요.", "예약 불가",
										JOptionPane.WARNING_MESSAGE);
								return;
							}

							// 당일 이전 예약 불가능한지 확인
							if (selectedDate.isBefore(today)) {
								JOptionPane.showMessageDialog(null, "당일 이전 예약은 불가능합니다. 다른 날짜를 선택해주세요.", "예약 불가",
										JOptionPane.WARNING_MESSAGE);
								return;
							}

							// 텃밭 예약 정보 생성
							GardenVO gardenVO = new GardenVO();
							int 예약_코드 = 0;
							gardenVO.setBookingcode(예약_코드);
							gardenVO.setBdate(selectedDate.toString()); // 텃밭 예약 날짜를 설정해야 함
							gardenVO.setBstart(startDate.toString()); // 텃밭 사용 시작일을 선택한 날짜로 설정
							gardenVO.setBend(endDate.toString()); // 텃밭 사용 종료일을 설정해야 함
							gardenVO.setBcheck("텃밭 대여 여부"); // 텃밭 대여 여부를 설정해야 함
							int 회원_코드 = 12;
							gardenVO.setMembercode(회원_코드); // 회원 코드를 설정해야 함
							int 텃밭_코드 = 2;
							gardenVO.setGardencode(텃밭_코드);

							// 예약 정보 추가
							try {
								gardenDAO.insertBooking(gardenVO);
							} catch (Exception e1) {
								e1.printStackTrace();
							}

							// 예약 완료 메시지 또는 작업 완료 후 필요한 동작 수행
							JOptionPane.showMessageDialog(null, "예약 후 사용기간은 3개월입니다." + "\n" + "결제는 현장결제입니다.", "예약 알림",
									JOptionPane.INFORMATION_MESSAGE);

							// 예약 완료 메시지 및 동작 수행
							int choice = JOptionPane.showOptionDialog(null, "예약을 하시겠습니까?", "예약 확인",
									JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
							if (choice == JOptionPane.YES_OPTION) {
								// 예약 완료
								JOptionPane.showMessageDialog(null, "예약이 완료되었습니다.", "예약 완료",
										JOptionPane.INFORMATION_MESSAGE);
								btnNewButton_2.setEnabled(false); // 예약하기 버튼 비활성화
							} else {
								// 예약 취소
								JOptionPane.showMessageDialog(null, "예약이 취소되었습니다.", "예약 취소",
										JOptionPane.INFORMATION_MESSAGE);
							}

							// 캘린더 다이얼로그 닫기
							calendarDialog.dispose();
						}
					});

					// 캘린더 다이얼로그에 캘린더 패널 추가
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

					// 캘린더 다이얼로그 생성
					JDialog calendarDialog = new JDialog();
					calendarDialog.setTitle("날짜 선택");
					calendarDialog.setModal(true);
					calendarDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					calendarDialog.setBounds(100, 100, 300, 300);
					calendarDialog.getContentPane().setLayout(new BorderLayout());

					// 캘린더 패널 생성
					JPanel calendarPanel = new JPanel();
					calendarPanel.setLayout(new BorderLayout());

					// 캘린더 컴포넌트 생성
					JCalendar calendar = new JCalendar();
					calendarPanel.add(calendar, BorderLayout.CENTER);

					// 확인 버튼 생성
					JButton confirmButton = new JButton("확인");
					calendarPanel.add(confirmButton, BorderLayout.SOUTH);

					// 확인 버튼 클릭 시 선택한 날짜 가져오기
					confirmButton.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							LocalDate selectedDate = calendar.getDate().toInstant().atZone(ZoneId.systemDefault())
									.toLocalDate();
							LocalDate startDate = selectedDate; // 선택한 날짜를 시작일로 설정
							LocalDate endDate = startDate.plusDays(90); // 텃밭 사용 종료일을 시작일로부터 14일 후로 설정

							// 당일 예약 불가능한지 확인
							LocalDate today = LocalDate.now();
							if (selectedDate.isEqual(today)) {
								JOptionPane.showMessageDialog(null, "당일 예약은 불가능합니다. 다른 날짜를 선택해주세요.", "예약 불가",
										JOptionPane.WARNING_MESSAGE);
								return;
							}

							// 당일 이전 예약 불가능한지 확인
							if (selectedDate.isBefore(today)) {
								JOptionPane.showMessageDialog(null, "당일 이전 예약은 불가능합니다. 다른 날짜를 선택해주세요.", "예약 불가",
										JOptionPane.WARNING_MESSAGE);
								return;
							}

							// 텃밭 예약 정보 생성
							GardenVO gardenVO = new GardenVO();
							int 예약_코드 = 0;
							gardenVO.setBookingcode(예약_코드);
							gardenVO.setBdate(selectedDate.toString()); // 텃밭 예약 날짜를 설정해야 함
							gardenVO.setBstart(startDate.toString()); // 텃밭 사용 시작일을 선택한 날짜로 설정
							gardenVO.setBend(endDate.toString()); // 텃밭 사용 종료일을 설정해야 함
							gardenVO.setBcheck("텃밭 대여 여부"); // 텃밭 대여 여부를 설정해야 함
							int 회원_코드 = 12;
							gardenVO.setMembercode(회원_코드); // 회원 코드를 설정해야 함
							int 텃밭_코드 = 3;
							gardenVO.setGardencode(텃밭_코드);

							// 예약 정보 추가
							try {
								gardenDAO.insertBooking(gardenVO);
							} catch (Exception e1) {
								e1.printStackTrace();
							}

							// 예약 완료 메시지 또는 작업 완료 후 필요한 동작 수행
							JOptionPane.showMessageDialog(null, "예약 후 사용기간은 3개월입니다." + "\n" + "결제는 현장결제입니다.", "예약 알림",
									JOptionPane.INFORMATION_MESSAGE);

							// 예약 완료 메시지 및 동작 수행
							int choice = JOptionPane.showOptionDialog(null, "예약을 하시겠습니까?", "예약 확인",
									JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
							if (choice == JOptionPane.YES_OPTION) {
								// 예약 완료
								JOptionPane.showMessageDialog(null, "예약이 완료되었습니다.", "예약 완료",
										JOptionPane.INFORMATION_MESSAGE);
								btnNewButton_2_3.setEnabled(false); // 예약하기 버튼 비활성화
							} else {
								// 예약 취소
								JOptionPane.showMessageDialog(null, "예약이 취소되었습니다.", "예약 취소",
										JOptionPane.INFORMATION_MESSAGE);
							}

							// 캘린더 다이얼로그 닫기
							calendarDialog.dispose();
						}
					});

					// 캘린더 다이얼로그에 캘린더 패널 추가
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

					// 캘린더 다이얼로그 생성
					JDialog calendarDialog = new JDialog();
					calendarDialog.setTitle("날짜 선택");
					calendarDialog.setModal(true);
					calendarDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					calendarDialog.setBounds(100, 100, 300, 300);
					calendarDialog.getContentPane().setLayout(new BorderLayout());

					// 캘린더 패널 생성
					JPanel calendarPanel = new JPanel();
					calendarPanel.setLayout(new BorderLayout());

					// 캘린더 컴포넌트 생성
					JCalendar calendar = new JCalendar();
					calendarPanel.add(calendar, BorderLayout.CENTER);

					// 확인 버튼 생성
					JButton confirmButton = new JButton("확인");
					calendarPanel.add(confirmButton, BorderLayout.SOUTH);

					// 확인 버튼 클릭 시 선택한 날짜 가져오기
					confirmButton.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							LocalDate selectedDate = calendar.getDate().toInstant().atZone(ZoneId.systemDefault())
									.toLocalDate();
							LocalDate startDate = selectedDate; // 선택한 날짜를 시작일로 설정
							LocalDate endDate = startDate.plusDays(90); // 텃밭 사용 종료일을 시작일로부터 14일 후로 설정

							// 당일 예약 불가능한지 확인
							LocalDate today = LocalDate.now();
							if (selectedDate.isEqual(today)) {
								JOptionPane.showMessageDialog(null, "당일 예약은 불가능합니다. 다른 날짜를 선택해주세요.", "예약 불가",
										JOptionPane.WARNING_MESSAGE);
								return;
							}

							// 당일 이전 예약 불가능한지 확인
							if (selectedDate.isBefore(today)) {
								JOptionPane.showMessageDialog(null, "당일 이전 예약은 불가능합니다. 다른 날짜를 선택해주세요.", "예약 불가",
										JOptionPane.WARNING_MESSAGE);
								return;
							}

							// 텃밭 예약 정보 생성
							GardenVO gardenVO = new GardenVO();
							int 예약_코드 = 0;
							gardenVO.setBookingcode(예약_코드);
							gardenVO.setBdate(selectedDate.toString()); // 텃밭 예약 날짜를 설정해야 함
							gardenVO.setBstart(startDate.toString()); // 텃밭 사용 시작일을 선택한 날짜로 설정
							gardenVO.setBend(endDate.toString()); // 텃밭 사용 종료일을 설정해야 함
							gardenVO.setBcheck("텃밭 대여 여부"); // 텃밭 대여 여부를 설정해야 함
							int 회원_코드 = 12;
							gardenVO.setMembercode(회원_코드); // 회원 코드를 설정해야 함
							int 텃밭_코드 = 4;
							gardenVO.setGardencode(텃밭_코드);

							// 예약 정보 추가
							try {
								gardenDAO.insertBooking(gardenVO);
							} catch (Exception e1) {
								e1.printStackTrace();
							}

							// 예약 완료 메시지 또는 작업 완료 후 필요한 동작 수행
							JOptionPane.showMessageDialog(null, "예약 후 사용기간은 3개월입니다." + "\n" + "결제는 현장결제입니다.", "예약 알림",
									JOptionPane.INFORMATION_MESSAGE);

							// 예약 완료 메시지 및 동작 수행
							int choice = JOptionPane.showOptionDialog(null, "예약을 하시겠습니까?", "예약 확인",
									JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
							if (choice == JOptionPane.YES_OPTION) {
								// 예약 완료
								JOptionPane.showMessageDialog(null, "예약이 완료되었습니다.", "예약 완료",
										JOptionPane.INFORMATION_MESSAGE);
								btnNewButton_2_1.setEnabled(false); // 예약하기 버튼 비활성화
							} else {
								// 예약 취소
								JOptionPane.showMessageDialog(null, "예약이 취소되었습니다.", "예약 취소",
										JOptionPane.INFORMATION_MESSAGE);
							}

							// 캘린더 다이얼로그 닫기
							calendarDialog.dispose();
						}
					});

					// 캘린더 다이얼로그에 캘린더 패널 추가
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

					// 캘린더 다이얼로그 생성
					JDialog calendarDialog = new JDialog();
					calendarDialog.setTitle("날짜 선택");
					calendarDialog.setModal(true);
					calendarDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					calendarDialog.setBounds(100, 100, 300, 300);
					calendarDialog.getContentPane().setLayout(new BorderLayout());

					// 캘린더 패널 생성
					JPanel calendarPanel = new JPanel();
					calendarPanel.setLayout(new BorderLayout());

					// 캘린더 컴포넌트 생성
					JCalendar calendar = new JCalendar();
					calendarPanel.add(calendar, BorderLayout.CENTER);

					// 확인 버튼 생성
					JButton confirmButton = new JButton("확인");
					calendarPanel.add(confirmButton, BorderLayout.SOUTH);

					// 확인 버튼 클릭 시 선택한 날짜 가져오기
					confirmButton.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							LocalDate selectedDate = calendar.getDate().toInstant().atZone(ZoneId.systemDefault())
									.toLocalDate();
							LocalDate startDate = selectedDate; // 선택한 날짜를 시작일로 설정
							LocalDate endDate = startDate.plusDays(90); // 텃밭 사용 종료일을 시작일로부터 14일 후로 설정

							// 당일 예약 불가능한지 확인
							LocalDate today = LocalDate.now();
							if (selectedDate.isEqual(today)) {
								JOptionPane.showMessageDialog(null, "당일 예약은 불가능합니다. 다른 날짜를 선택해주세요.", "예약 불가",
										JOptionPane.WARNING_MESSAGE);
								return;
							}

							// 당일 이전 예약 불가능한지 확인
							if (selectedDate.isBefore(today)) {
								JOptionPane.showMessageDialog(null, "당일 이전 예약은 불가능합니다. 다른 날짜를 선택해주세요.", "예약 불가",
										JOptionPane.WARNING_MESSAGE);
								return;
							}

							// 텃밭 예약 정보 생성
							GardenVO gardenVO = new GardenVO();
							int 예약_코드 = 0;
							gardenVO.setBookingcode(예약_코드);
							gardenVO.setBdate(selectedDate.toString()); // 텃밭 예약 날짜를 설정해야 함
							gardenVO.setBstart(startDate.toString()); // 텃밭 사용 시작일을 선택한 날짜로 설정
							gardenVO.setBend(endDate.toString()); // 텃밭 사용 종료일을 설정해야 함
							gardenVO.setBcheck("텃밭 대여 여부"); // 텃밭 대여 여부를 설정해야 함
							int 회원_코드 = 12;
							gardenVO.setMembercode(회원_코드); // 회원 코드를 설정해야 함
							int 텃밭_코드 = 5;
							gardenVO.setGardencode(텃밭_코드);

							// 예약 정보 추가
							try {
								gardenDAO.insertBooking(gardenVO);
							} catch (Exception e1) {
								e1.printStackTrace();
							}

							// 예약 완료 메시지 또는 작업 완료 후 필요한 동작 수행
							JOptionPane.showMessageDialog(null, "예약 후 사용기간은 3개월입니다." + "\n" + "결제는 현장결제입니다.", "예약 알림",
									JOptionPane.INFORMATION_MESSAGE);

							// 예약 완료 메시지 및 동작 수행
							int choice = JOptionPane.showOptionDialog(null, "예약을 하시겠습니까?", "예약 확인",
									JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
							if (choice == JOptionPane.YES_OPTION) {
								// 예약 완료
								JOptionPane.showMessageDialog(null, "예약이 완료되었습니다.", "예약 완료",
										JOptionPane.INFORMATION_MESSAGE);
								btnNewButton_2_2.setEnabled(false); // 예약하기 버튼 비활성화
							} else {
								// 예약 취소
								JOptionPane.showMessageDialog(null, "예약이 취소되었습니다.", "예약 취소",
										JOptionPane.INFORMATION_MESSAGE);
							}

							// 캘린더 다이얼로그 닫기
							calendarDialog.dispose();
						}
					});

					// 캘린더 다이얼로그에 캘린더 패널 추가
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

					// 캘린더 다이얼로그 생성
					JDialog calendarDialog = new JDialog();
					calendarDialog.setTitle("날짜 선택");
					calendarDialog.setModal(true);
					calendarDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					calendarDialog.setBounds(100, 100, 300, 300);
					calendarDialog.getContentPane().setLayout(new BorderLayout());

					// 캘린더 패널 생성
					JPanel calendarPanel = new JPanel();
					calendarPanel.setLayout(new BorderLayout());

					// 캘린더 컴포넌트 생성
					JCalendar calendar = new JCalendar();
					calendarPanel.add(calendar, BorderLayout.CENTER);

					// 확인 버튼 생성
					JButton confirmButton = new JButton("확인");
					calendarPanel.add(confirmButton, BorderLayout.SOUTH);

					// 확인 버튼 클릭 시 선택한 날짜 가져오기
					confirmButton.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							LocalDate selectedDate = calendar.getDate().toInstant().atZone(ZoneId.systemDefault())
									.toLocalDate();
							LocalDate startDate = selectedDate; // 선택한 날짜를 시작일로 설정
							LocalDate endDate = startDate.plusDays(90); // 텃밭 사용 종료일을 시작일로부터 14일 후로 설정

							// 당일 예약 불가능한지 확인
							LocalDate today = LocalDate.now();
							if (selectedDate.isEqual(today)) {
								JOptionPane.showMessageDialog(null, "당일 예약은 불가능합니다. 다른 날짜를 선택해주세요.", "예약 불가",
										JOptionPane.WARNING_MESSAGE);
								return;
							}

							// 당일 이전 예약 불가능한지 확인
							if (selectedDate.isBefore(today)) {
								JOptionPane.showMessageDialog(null, "당일 이전 예약은 불가능합니다. 다른 날짜를 선택해주세요.", "예약 불가",
										JOptionPane.WARNING_MESSAGE);
								return;
							}
							// 텃밭 예약 정보 생성
							GardenVO gardenVO = new GardenVO();
							int 예약_코드 = 0;
							gardenVO.setBookingcode(예약_코드);
							gardenVO.setBdate(selectedDate.toString()); // 텃밭 예약 날짜를 설정해야 함
							gardenVO.setBstart(startDate.toString()); // 텃밭 사용 시작일을 선택한 날짜로 설정
							gardenVO.setBend(endDate.toString()); // 텃밭 사용 종료일을 설정해야 함
							gardenVO.setBcheck("텃밭 대여 여부"); // 텃밭 대여 여부를 설정해야 함
							int 회원_코드 = 12;
							gardenVO.setMembercode(회원_코드); // 회원 코드를 설정해야 함
							int 텃밭_코드 = 6;
							gardenVO.setGardencode(텃밭_코드);

							// 예약 정보 추가
							try {
								gardenDAO.insertBooking(gardenVO);
							} catch (Exception e1) {
								e1.printStackTrace();
							}

							// 예약 완료 메시지 또는 작업 완료 후 필요한 동작 수행
							JOptionPane.showMessageDialog(null, "예약 후 사용기간은 3개월입니다." + "\n" + "결제는 현장결제입니다.", "예약 알림",
									JOptionPane.INFORMATION_MESSAGE);

							// 예약 완료 메시지 및 동작 수행
							int choice = JOptionPane.showOptionDialog(null, "예약을 하시겠습니까?", "예약 확인",
									JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
							if (choice == JOptionPane.YES_OPTION) {
								// 예약 완료
								JOptionPane.showMessageDialog(null, "예약이 완료되었습니다.", "예약 완료",
										JOptionPane.INFORMATION_MESSAGE);
								btnNewButton_2_4.setEnabled(false); // 예약하기 버튼 비활성화
							} else {
								// 예약 취소
								JOptionPane.showMessageDialog(null, "예약이 취소되었습니다.", "예약 취소",
										JOptionPane.INFORMATION_MESSAGE);
							}

							// 캘린더 다이얼로그 닫기
							calendarDialog.dispose();
						}
					});

					// 캘린더 다이얼로그에 캘린더 패널 추가
					calendarDialog.getContentPane().add(calendarPanel);
					calendarDialog.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});

		JButton bookingbtn = new JButton("\uB098\uC758\uC608\uC57D\uD604\uD669");
		bookingbtn.setFont(new Font("나눔고딕", Font.BOLD, 15));
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
				textField.setText("텃밭 명 : " + garden1.getGaddr());
				textField_1.setText("텃밭 대여료 : " + garden1.getGprice());
				textField_2.setText("텃밭 평수 : " + garden1.getGsize());
				if (gardens.size() > 1) {
					GardenVO garden2 = gardens.get(1);
					textField_3.setText("텃밭 명 : " + garden2.getGaddr());
					textField_4.setText("텃밭 대여료 : " + garden2.getGprice());
					textField_5.setText("텃밭 평수 : " + garden2.getGsize());
				}

				if (gardens.size() > 2) {
					GardenVO garden3 = gardens.get(2);
					textField_6.setText("텃밭 명 : " + garden3.getGaddr());
					textField_7.setText("텃밭 대여료 : " + garden3.getGprice());
					textField_8.setText("텃밭 평수 : " + garden3.getGsize());
				}

				if (gardens.size() > 3) {
					GardenVO garden4 = gardens.get(3);
					textField_9.setText("텃밭 명 : " + garden4.getGaddr());
					textField_10.setText("텃밭 대여료 : " + garden4.getGprice());
					textField_11.setText("텃밭 평수 : " + garden4.getGsize());
				}

				if (gardens.size() > 4) {
					GardenVO garden5 = gardens.get(4);
					textField_12.setText("텃밭 명 : " + garden5.getGaddr());
					textField_13.setText("텃밭 대여료 : " + garden5.getGprice());
					textField_14.setText("텃밭 평수 : " + garden5.getGsize());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}