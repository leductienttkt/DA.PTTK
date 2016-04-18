package HeThong;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Class.NGUOIDUNG;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

public class ThongTinNguoiDung extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtUsername,txtRole;
	private JPasswordField txtPass;
	private JButton btnEdit, btnCancel;
	private static NGUOIDUNG user;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					user = new NGUOIDUNG("lea","123456", "User");
					ThongTinNguoiDung frame = new ThongTinNguoiDung(user);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ThongTinNguoiDung(NGUOIDUNG user) {
		setType(Type.POPUP);
		setResizable(false);
		setTitle("Thông tin người dùng\r\n");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ThongTinNguoiDung.class.getResource("/images/1441359778_elementary_school.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 370);
		this.setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(10, 11, 140, 320);
			ImageIcon icon = new ImageIcon(ThongTinNguoiDung.class.getResource("/images/stock_people.png"));
			Image iconImage = icon.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT);
			icon = new ImageIcon(iconImage);
			label.setIcon(new ImageIcon(ThongTinNguoiDung.class.getResource("/images/stock_people.png")));
			contentPane.add(label);
			
			JPanel panel = new JPanel();
				panel.setBounds(160, 11, 324, 320);
				contentPane.add(panel);
				panel.setLayout(null);
			
			JPanel form = new JPanel();
				form.setBounds(10, 0, 314, 320);
				panel.add(form);
				form.setLayout(null);
			
			JLabel lbUsername = new JLabel("Tên người dùng");
				lbUsername.setBounds(10, 53, 115, 23);
				form.add(lbUsername);
				lbUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
			
			JLabel lblMatKhau = new JLabel("Mật khẩu");
				lblMatKhau.setBounds(10, 89, 115, 25);
				form.add(lblMatKhau);
				lblMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 14));
			
			JLabel lbRole = new JLabel("Quyền");
				lbRole.setBounds(10, 151, 115, 25);
				form.add(lbRole);
				lbRole.setFont(new Font("Tahoma", Font.PLAIN, 14));
			
			txtUsername = new JTextField();
				txtUsername.setEditable(false);
				txtUsername.setText(user.getTaiKhoan());
				txtUsername.setBounds(135, 53, 169, 25);
				form.add(txtUsername);
				txtUsername.setColumns(10);
			
			txtPass = new JPasswordField();
				txtPass.setEditable(false);
				txtPass.setEchoChar('*');
				txtPass.setText(user.getMatKhau());
				txtPass.setBounds(135, 89, 169, 25);
				form.add(txtPass);
			
			JCheckBox checkboxEncode = new JCheckBox("Mã hóa mật khẩu");
				checkboxEncode.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						if(checkboxEncode.isSelected()){
							txtPass.setEchoChar((char)0);
						}else{
							txtPass.setEchoChar('*');
						}
						
					}
				});
				checkboxEncode.setBounds(135, 121, 169, 23);
				form.add(checkboxEncode);

			
			txtRole = new JTextField();
				txtRole.setEditable(false);
				txtRole.setFont(new Font("Tahoma", Font.BOLD, 14));
				txtRole.setBounds(135, 151, 169, 25);
				txtRole.setText(user.getQuyen());
				form.add(txtRole);
				txtRole.setColumns(10);
			
			btnEdit = new JButton("Chỉnh sửa");
				btnEdit.setHorizontalAlignment(SwingConstants.LEFT);
				btnEdit.setIcon(new ImageIcon(ThongTinNguoiDung.class.getResource("/images/1441002954_Modify.png")));
				btnEdit.setBounds(10, 227, 122, 32);
					btnEdit.addActionListener(this);
				form.add(btnEdit);
			
			btnCancel = new JButton("Thoát");
				btnCancel.setHorizontalAlignment(SwingConstants.LEFT);
				btnCancel.setIcon(new ImageIcon(ThongTinNguoiDung.class.getResource("/images/1441002712_exit.png")));
				btnCancel.setBounds(187, 227, 105, 32);
					btnCancel.addActionListener(this);
				form.add(btnCancel);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == btnEdit){
			new ChinhSuaNguoiDung(user);
		}
		else if(e.getSource() == btnCancel){
			this.dispose();
		}
	}
	
}
