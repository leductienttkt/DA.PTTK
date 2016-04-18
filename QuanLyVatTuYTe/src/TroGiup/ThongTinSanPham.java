package TroGiup;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JTextArea;

public class ThongTinSanPham extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThongTinSanPham frame = new ThongTinSanPham();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public ThongTinSanPham() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ThongTinSanPham.class.getResource("/images/information.png")));
		this.setResizable(false);
		this.setVisible(true);
		setTitle("Thông tin sản phẩm");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500 , 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ThongTinSanPham.class.getResource("/images/info.png")));
		label.setBounds(10, 63, 140, 268);
		contentPane.add(label);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(160, 63, 324, 268);
		contentPane.add(panel);
		
		JLabel lbVersion = new JLabel("Version: ");
		lbVersion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbVersion.setBounds(10, 11, 127, 25);
		panel.add(lbVersion);
		
		JLabel lbLicense = new JLabel("Bản quyền thuộc về :");
		lbLicense.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbLicense.setBounds(10, 47, 141, 25);
		panel.add(lbLicense);
		
		JLabel lbAddress = new JLabel("Địa chỉ : ");
		lbAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbAddress.setBounds(10, 118, 127, 25);
		panel.add(lbAddress);
		
		JLabel lbNumberPhone = new JLabel("SĐT : ");
		lbNumberPhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbNumberPhone.setBounds(10, 183, 127, 25);
		panel.add(lbNumberPhone);
		
		JLabel lbEmail = new JLabel("Email : ");
		lbEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbEmail.setBounds(10, 219, 127, 25);
		panel.add(lbEmail);
		
		JLabel Version = new JLabel("1.0");
		Version.setHorizontalAlignment(SwingConstants.LEFT);
		Version.setBounds(157, 11, 157, 25);
		panel.add(Version);
		
		JLabel NumberPhone = new JLabel("");
		NumberPhone.setBounds(157, 183, 157, 25);
		panel.add(NumberPhone);
		
		JLabel Email = new JLabel("");
		Email.setBounds(157, 219, 157, 25);
		panel.add(Email);
		
		JTextArea txtrNhmSinhVin = new JTextArea();
		txtrNhmSinhVin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtrNhmSinhVin.setWrapStyleWord(true);
		txtrNhmSinhVin.setLineWrap(true);
		txtrNhmSinhVin.setEditable(false);
		txtrNhmSinhVin.setText("Nhóm sinh viên khóa 12T, trường Đại Học Bách Khoa Đại Học Đà Nẵng");
		txtrNhmSinhVin.setBounds(161, 50, 153, 58);
		panel.add(txtrNhmSinhVin);
		
		JTextArea txtrNguynLng = new JTextArea();
		txtrNguynLng.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtrNguynLng.setWrapStyleWord(true);
		txtrNguynLng.setText("54 Nguyễn Lương Bằng, quận Liên Chiểu, tp Đà Nẵng");
		txtrNguynLng.setLineWrap(true);
		txtrNguynLng.setEditable(false);
		txtrNguynLng.setBounds(157, 121, 153, 52);
		panel.add(txtrNguynLng);
		
		JLabel lblNewLabel = new JLabel("PHẦN MỀM QUẢN LÝ VẬT TƯ Y TẾ");
		lblNewLabel.setForeground(new Color(148, 0, 211));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 474, 41);
		contentPane.add(lblNewLabel);
	}
}
