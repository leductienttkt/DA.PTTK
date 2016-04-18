package HeThong;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Class.Database;
import Class.NGUOIDUNG;
import Class.ThuVienChung;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;

public class ThayDoiMatKhau extends JFrame implements ActionListener, ItemListener{

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtOldPassword;
	private JPasswordField txtNewPassword;
	private JPasswordField txtRepeatPassword;
	JCheckBox checkBoxEncode;
	JButton btnSave, btnCancel;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThayDoiMatKhau frame = new ThayDoiMatKhau(new NGUOIDUNG("LeD", "123456","User"));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public ThayDoiMatKhau(NGUOIDUNG user) {
		this.setVisible(true);
		setTitle("Thay đổi mật khẩu");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ThayDoiMatKhau.class.getResource("/images/edit_password.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500,370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
			label.setIcon(new ImageIcon(ThayDoiMatKhau.class.getResource("/images/preferences_desktop_user_password.png")));
			label.setBounds(10, 11, 140, 320);
			contentPane.add(label);
		
		JPanel panel = new JPanel();
			panel.setBounds(160, 11, 324, 320);
			contentPane.add(panel);
			panel.setLayout(null);
		
		JLabel lbUsername = new JLabel("Tên người dùng");
			lbUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lbUsername.setBounds(10, 30, 127, 25);
			panel.add(lbUsername);
		
		txtUsername = new JTextField();
			txtUsername.setEditable(false);
			txtUsername.setColumns(10);
			txtUsername.setBounds(147, 32, 157, 25);
			txtUsername.setText(user.getTaiKhoan());
			panel.add(txtUsername);
		
		JLabel lbOldPassword = new JLabel("Mật khẩu");
			lbOldPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lbOldPassword.setBounds(10, 66, 127, 25);
			panel.add(lbOldPassword);
		
		txtOldPassword = new JPasswordField();
			txtOldPassword.setEchoChar('*');
			txtOldPassword.setEditable(false);
			txtOldPassword.setBounds(147, 68, 157, 25);
			txtOldPassword.setText(user.getMatKhau());
			panel.add(txtOldPassword);
		
		checkBoxEncode = new JCheckBox("Mã hóa mật khẩu");
			checkBoxEncode.setBounds(147, 100, 157, 23);
			checkBoxEncode.addItemListener(this);
			panel.add(checkBoxEncode);
		
		JLabel lbNewPassword = new JLabel("Mật khẩu mới");
			lbNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lbNewPassword.setBounds(10, 137, 127, 25);
			panel.add(lbNewPassword);
		
		txtNewPassword = new JPasswordField();
			txtNewPassword.setEchoChar('*');
			txtNewPassword.setBounds(147, 139, 157, 25);
			panel.add(txtNewPassword);
		
		JLabel lbRepeatPassword = new JLabel("Nhập lại mật khẩu");
			lbRepeatPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lbRepeatPassword.setBounds(10, 173, 127, 25);
			panel.add(lbRepeatPassword);
			
		txtRepeatPassword = new JPasswordField();
			txtRepeatPassword.setEchoChar('*');
			txtRepeatPassword.setBounds(147, 175, 157, 25);
			panel.add(txtRepeatPassword);
		
		JLabel lbRole = new JLabel("Quyền");
			lbRole.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lbRole.setBounds(10, 211, 127, 25);
			panel.add(lbRole);

		JLabel Role = new JLabel("");
			Role.setFont(new Font("Tahoma", Font.BOLD, 13));
			Role.setBounds(147, 211, 157, 25);
			Role.setText(user.getQuyen());
			panel.add(Role);
		
		btnSave = new JButton("Lưu");
			btnSave.setIcon(new ImageIcon(ThayDoiMatKhau.class.getResource("/images/1441002692_Save.png")));
			btnSave.setHorizontalAlignment(SwingConstants.LEFT);
			btnSave.addActionListener(this);
			btnSave.setBounds(10, 260, 127, 32);
			panel.add(btnSave);
		
		btnCancel = new JButton("Hủy bỏ");
			btnCancel.setIcon(new ImageIcon(ThayDoiMatKhau.class.getResource("/images/cancel.png")));
			btnCancel.setHorizontalAlignment(SwingConstants.LEFT);
			btnCancel.setBounds(177, 260, 127, 32);
			btnCancel.addActionListener(this);
			panel.add(btnCancel);
	}
	
	
	@Override
	public void itemStateChanged(ItemEvent ie){
		if(checkBoxEncode.isSelected()) txtOldPassword.setEchoChar((char)0);
		else txtOldPassword.setEchoChar('*');
	}
	
	
	@Override
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource() == btnCancel){
			this.dispose();
		} else if(ae.getSource() == btnSave){
			//Kiểm tra có thay đổi mật khẩu
			String oldPass = String.valueOf(txtOldPassword.getPassword());
			String newPass = String.valueOf(txtNewPassword.getPassword());
			String repeatPass = String.valueOf(txtRepeatPassword.getPassword());
			String error = "";
			
			if(newPass.equals("") && repeatPass.equals("")){
				JOptionPane.showMessageDialog(null,"Không thay đổi mật khẩu");
				this.dispose();
			}
			else{
				//Kiểm tra mật khẩu có hợp lệ
				if(ThuVienChung.isValidateInput(newPass) && ThuVienChung.isValidateInput(repeatPass)){
					//Kiểm tra maxlength
					if(ThuVienChung.isOverMaxLength(newPass) || ThuVienChung.isOverMaxLength(repeatPass)){
						error= "Mật khẩu quá dài";
					} else if(repeatPass.equals(oldPass)) error = "Mật khẩu mới không được trùng với mật khẩu cũ !!!";
				}else error = "Mật khẩu không hợp lệ !!!";
			}
			
			//nếu không có lỗi, thực hiện cập nhật mật khẩu
			if(error.equals("")){
				String update = "Update NGUOIDUNG set MatKhau=N'"+newPass+"' where TaiKhoan=N'"+txtUsername.getText()+"'";
				Database db = new Database();
				int kq = db.saveData(update);
				System.out.println(update);
				JOptionPane.showMessageDialog(null, "Kết quả cập nhật: "+((kq!=-1)?"Thành công":"Thất bại"));
				if(kq!=-1) this.dispose();
			} else {
				JOptionPane.showMessageDialog(null, error);
			}
		}
	}
}
