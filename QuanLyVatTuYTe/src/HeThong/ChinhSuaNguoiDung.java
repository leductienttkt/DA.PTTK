package HeThong;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Class.Database;
import Class.NGUOIDUNG;
import Class.ThuVienChung;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;

public class ChinhSuaNguoiDung extends JFrame implements ActionListener,ItemListener{

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtOldPassword;
	private JPasswordField txtNewPassword;
	private JPasswordField txtRepeatPassword;
	private int resultEdit =-1;
	JCheckBox checkboxEncode;
	JButton btnSave, btnExit;
	JComboBox comboBoxRole;
	NGUOIDUNG userEdit;

	/**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChinhSuaNguoiDung frame = new ChinhSuaNguoiDung();
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
	public ChinhSuaNguoiDung(NGUOIDUNG user) {
		userEdit = user;
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ChinhSuaNguoiDung.class.getResource("/images/1441002954_Modify.png")));
		setTitle("Chỉnh sửa người dùng");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 370);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
			label.setIcon(new ImageIcon(ChinhSuaNguoiDung.class.getResource("/images/edit_user.png")));
			label.setBounds(10, 11, 140, 320);
			contentPane.add(label);
		
		JPanel panel = new JPanel();
			panel.setBounds(160, 11, 314, 320);
			contentPane.add(panel);
			panel.setLayout(null);
		
		JLabel lbUsername = new JLabel("Tên người dùng");
			lbUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lbUsername.setBounds(10, 34, 127, 25);
			panel.add(lbUsername);
		
		JLabel lbOldPass = new JLabel("Mật khẩu");
			lbOldPass.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lbOldPass.setBounds(10, 70, 127, 25);
			panel.add(lbOldPass);
		
		JLabel lbNewPass = new JLabel("Mật khẩu mới");
			lbNewPass.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lbNewPass.setBounds(10, 141, 127, 25);
			panel.add(lbNewPass);
		
		JLabel blRepeatPass = new JLabel("Nhập lại mật khẩu");
			blRepeatPass.setFont(new Font("Tahoma", Font.PLAIN, 14));
			blRepeatPass.setBounds(10, 177, 127, 25);
			panel.add(blRepeatPass);
			
		JLabel lbRole = new JLabel("Quyền");
			lbRole.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lbRole.setBounds(10, 215, 127, 25);
			panel.add(lbRole);
			
		txtUsername = new JTextField();
			txtUsername.setBounds(147, 36, 157, 25);
			txtUsername.setText(user.getTaiKhoan());
			panel.add(txtUsername);
			txtUsername.setColumns(10);
		
		txtOldPassword = new JPasswordField();
			txtOldPassword.setEditable(false);
			txtOldPassword.setEchoChar('*');
			txtOldPassword.setText(user.getMatKhau());
			txtOldPassword.setBounds(147, 72, 157, 25);
			panel.add(txtOldPassword);
		
		txtNewPassword = new JPasswordField();
			txtNewPassword.setEchoChar('*');
			txtNewPassword.setBounds(147, 143, 157, 25);
			panel.add(txtNewPassword);
		
		txtRepeatPassword = new JPasswordField();
			txtRepeatPassword.setEchoChar('*');
			txtRepeatPassword.setBounds(147, 179, 157, 25);
			panel.add(txtRepeatPassword);
		
		checkboxEncode = new JCheckBox("Mã hóa mật khẩu");
			checkboxEncode.addItemListener(this);
			checkboxEncode.setBounds(147, 104, 157, 23);
			panel.add(checkboxEncode);
		
		comboBoxRole = new JComboBox();
			comboBoxRole.setModel(new DefaultComboBoxModel(new String[] {"Admin", "User"}));
				if(user.getQuyen() == comboBoxRole.getItemAt(0)){
					comboBoxRole.setSelectedIndex(0);
				} else comboBoxRole.setSelectedIndex(1);
			comboBoxRole.setBounds(147, 217, 157, 25);
			panel.add(comboBoxRole);
		
		btnSave = new JButton("Lưu thông tin");
			btnSave.setHorizontalAlignment(SwingConstants.LEFT);
			btnSave.setIcon(new ImageIcon(ChinhSuaNguoiDung.class.getResource("/images/1441002692_Save.png")));
			btnSave.addActionListener(this);
			btnSave.setBounds(10, 264, 162, 32);
			panel.add(btnSave);
		
		btnExit = new JButton("Thoát");
			btnExit.setHorizontalAlignment(SwingConstants.LEFT);
			btnExit.setIcon(new ImageIcon(ChinhSuaNguoiDung.class.getResource("/images/1441002712_exit.png")));
			btnExit.addActionListener(this);
			btnExit.setBounds(201, 264, 103, 32);
			panel.add(btnExit);
	}
	
	@Override
	public void itemStateChanged(ItemEvent ie){
		if(checkboxEncode.isSelected()){
			txtOldPassword.setEchoChar((char) 0);
		} else txtOldPassword.setEchoChar('*');
	}
	
	@Override
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource() == btnExit){
			this.dispose();
		}else if(ae.getSource() == btnSave){
			Database db = new Database();
			
			String error="", oldPass, newPass,repeatPass, username;
				username = txtUsername.getText();
				oldPass = String.valueOf(txtOldPassword.getPassword());
				newPass = String.valueOf(txtNewPassword.getPassword());
				repeatPass  = String.valueOf(txtRepeatPassword.getPassword());
				
				//kiểm tra có thay đổi mật khẩu???
			if(!newPass.equals("") || !repeatPass.equals("")){
				/*System.out.println("Mật khẩu cũ: "+oldPass);
				System.out.println("Mật khẩu mới: "+newPass);
				System.out.println("Nhập lại mật khẩu: "+repeatPass);*/
				
				//Kiểm tra mật khẩu hợp lệ
				if(ThuVienChung.isValidateInput(newPass) && ThuVienChung.isValidateInput(repeatPass)){
					 if(ThuVienChung.isOverMaxLength(newPass) || ThuVienChung.isOverMaxLength(repeatPass)){
							error="Mật khẩu quá dài";
					} else
						//Kiểm tra có trùng với mật khẩu cũ
						if(newPass.equals(oldPass)){
							error="Mật khẩu mới không được trùng với mật khẩu cũ";
						}else{ //kiểm tra trùng khớp mật khẩu
							if(!newPass.equals(repeatPass)){
								error= "Mật khẩu không trùng khớp";
							}
						}
				} else error="Mật khẩu không hợp lệ";
			}
			
			//kiểm tra có thay đổi username
			if(txtUsername.getText().equals(userEdit.getTaiKhoan())){ //nếu không thay đổi
				
			} else{ //nếu có thay đổi, kiểm tra user đc thay đổi đã tồn tại trong CSDL chưa?

				//kiểm tra userName có hợp lệ
					if(ThuVienChung.isValidateInput(username)){
						if(ThuVienChung.isOverMaxLength(username)){
							error="Tài khoản quá dài";
						} else {
							String sql = "Select * from NGUOIDUNG where TaiKhoan =N'"+txtUsername.getText()+"'";
							ResultSet rs = db.getData(sql);
							try {
								if(rs.next()) error="Tài khoản đã tồn tại !!!";
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
				
					} else error ="Tài khoản không hợp lệ";
			}
			
			if(error.equals("")){ //nếu không có lỗi, thì thực hiện update User
				String update="";
				if(newPass.equals("")){
					update = "Update NGUOIDUNG set TaiKhoan=N'"+txtUsername.getText()+"' , Quyen='"+comboBoxRole.getSelectedItem()+"' where TaiKhoan=N'"+userEdit.getTaiKhoan()+"'" ;
				}
				else update = "Update NGUOIDUNG set TaiKhoan=N'"+txtUsername.getText()+"' ,"
						+ "MatKhau='"+newPass+"' , Quyen='"+comboBoxRole.getSelectedItem()+"' where TaiKhoan=N'"+userEdit.getTaiKhoan()+"'" ;
				System.out.println("SQL Update: "+update);
				resultEdit = db.saveData(update);
				System.out.println("Kết quả cập nhật: "+((resultEdit!=-1)?" Thành công":"Không thành công"));
				JOptionPane.showMessageDialog(null, "Kết quả cập nhật: "+((resultEdit!=-1)?" Thành công":"Không thành công"));
				this.dispose();
				
			} else{
				JOptionPane.showMessageDialog(null, error);
			}
		}
	}
	
	public int getResultEdit(){
		return resultEdit;
	}

}
