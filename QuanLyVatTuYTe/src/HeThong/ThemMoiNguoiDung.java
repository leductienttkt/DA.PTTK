package HeThong;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Class.Database;
import Class.ThuVienChung;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class ThemMoiNguoiDung extends JFrame implements ActionListener, ItemListener {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JPasswordField txtRepeatPassword;
	JComboBox comboBoxRole;
	JCheckBox checkboxEncode;
	JButton btnAdd,btnCancel;
	private JLabel lbIDStaff;
	private JTextField txtIDStaff;

	/**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemMoiNguoiDung frame = new ThemMoiNguoiDung();
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
	public ThemMoiNguoiDung() {
		this.setVisible(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ThemMoiNguoiDung.class.getResource("/images/user1_add2.png")));
		setTitle("Thêm mới người dùng");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
			label.setIcon(new ImageIcon(ThemMoiNguoiDung.class.getResource("/images/add_user.png")));
			label.setBounds(10, 11, 140, 320);
			contentPane.add(label);
			
		JPanel panel = new JPanel();
			panel.setBounds(160, 11, 314, 320);
			contentPane.add(panel);
			panel.setLayout(null);
		
		JLabel lbUsername = new JLabel("Tên người dùng");
			lbUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lbUsername.setBounds(10, 40, 115, 25);
			panel.add(lbUsername);
		
		JLabel lbPass = new JLabel("Mật khẩu");
			lbPass.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lbPass.setBounds(10, 76, 115, 25);
			panel.add(lbPass);
		
		JLabel lbReapeatPass = new JLabel("Nhập lại mật khẩu");
			lbReapeatPass.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lbReapeatPass.setBounds(10, 156, 115, 25);
			panel.add(lbReapeatPass);
		
		JLabel lbRole = new JLabel("Quyền");
			lbRole.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lbRole.setBounds(10, 192, 115, 25);
			panel.add(lbRole);
		
		txtUsername = new JTextField();
			txtUsername.setBounds(135, 42, 169, 25);
			panel.add(txtUsername);
			txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
			txtPassword.setEchoChar('*');
			txtPassword.setBounds(135, 78, 169, 25);
			panel.add(txtPassword);
		
		txtRepeatPassword = new JPasswordField();
			txtRepeatPassword.setEchoChar('*');
			txtRepeatPassword.setBounds(135, 160, 169, 25);
			panel.add(txtRepeatPassword);
		
		checkboxEncode = new JCheckBox("Mã hóa mật khẩu");
			checkboxEncode.setBounds(135, 110, 169, 23);
			checkboxEncode.addItemListener(this);
			panel.add(checkboxEncode);
		
		comboBoxRole = new JComboBox();
			comboBoxRole.setModel(new DefaultComboBoxModel(new String[] {"User", "Admin"}));
			comboBoxRole.setBounds(135, 196, 169, 25);
			panel.add(comboBoxRole);
		
		btnAdd = new JButton("Thêm mới");
			btnAdd.setIcon(new ImageIcon(ThemMoiNguoiDung.class.getResource("/images/user_red_add2.png")));
			btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnAdd.addActionListener(this);
			btnAdd.setHorizontalAlignment(SwingConstants.LEFT);
			btnAdd.setBounds(10, 277, 153, 32);
			panel.add(btnAdd);
		
		btnCancel = new JButton("Hủy bỏ");
			btnCancel.setIcon(new ImageIcon(ThemMoiNguoiDung.class.getResource("/images/1441002676_DeleteRed.png")));
			btnCancel.setHorizontalAlignment(SwingConstants.LEFT);
			btnCancel.addActionListener(this);
			btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnCancel.setBounds(181, 277, 123, 32);
			panel.add(btnCancel);
			
			lbIDStaff = new JLabel("Mã Nhân Viên");
			lbIDStaff.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lbIDStaff.setBounds(10, 228, 115, 25);
			panel.add(lbIDStaff);
			
			txtIDStaff = new JTextField();
			txtIDStaff.setBounds(135, 232, 169, 25);
			panel.add(txtIDStaff);
			txtIDStaff.setColumns(10);
	}
	
	
	@Override
	public void itemStateChanged(ItemEvent ie){
		if(checkboxEncode.isSelected()){
			txtPassword.setEchoChar((char)0);
		} else txtPassword.setEchoChar('*');
	}
	
	
	@Override
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource() == btnCancel){
			this.dispose();
		} else if(ae.getSource() == btnAdd){
			Database db = new Database();
			String username = txtUsername.getText();
			String newPass = String.valueOf(txtPassword.getPassword());
			String repeatPass = String.valueOf(txtRepeatPassword.getPassword());
			String idStaff = txtIDStaff.getText();
			String error = "";
			
			
			//Kiểm tra password hợp lệ
			if(ThuVienChung.isValidateInput(newPass) && ThuVienChung.isValidateInput(repeatPass)){
				//Kiểm tra maxlength
				if(ThuVienChung.isOverMaxLength(newPass) || ThuVienChung.isOverMaxLength(repeatPass)){
					error="Mật khẩu quá dài";
				} else{
					if(!newPass.equals(repeatPass)) error="Mật khẩu không trùng khớp";
				}
			} else error ="Mật khẩu không hợp lệ";
			
			//Kiểm tra mã nhân viên Hợp lệ??
			if(ThuVienChung.isValidateInput(idStaff)){
				//Kiểm tra mã nhân viên tồn tại
				String checkExist = "Select * from NHANVIEN where MaNhanVien='"+idStaff+"'";
				ResultSet rs = db.getData(checkExist);
				try {
					if(!rs.next()){
						error="Không tồn tại nhân viên có mã: "+idStaff;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else error="Mã nhân viên không hợp lệ";
			
			//Kiểm tra username hợp lệ
			if(!username.equals("")){
				if(ThuVienChung.isValidateInput(username)){
					//Kiểm tra maxlength
					if(ThuVienChung.isOverMaxLength(username)){
						error ="Tài khoản quá dài";
					} else{
						//Kiểm tra tài khoản tồn tại ???
						ResultSet rs = db.getData("Select * from NGUOIDUNG where TaiKhoan=N'"+username+"'");
						try {
							if(rs.next()){
								error = "Tài khoản đã tồn tại";
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				} else error ="Tài khoản không hợp lệ";
			} else error = "Tên người dùng là bắt buộc";
			
			
			//Thực hiện thêm mới nếu không có lỗi
			if(error.equals("")){
				String add = "Insert into NGUOIDUNG(TaiKhoan,MatKhau,Quyen,MaNhanVien) values( "
						+"N'"+username+"', '"+newPass+"','"+comboBoxRole.getSelectedItem()+"'"
						+", '"+idStaff+"' )" ;
				System.out.println(add);
				int kq = db.saveData(add);
				JOptionPane.showMessageDialog(null, "Kết quả Thêm mới nhân viên : " + ((kq!=-1)?" Thành công":"Không thành công"));
				this.dispose();
			} else{
				JOptionPane.showMessageDialog(null, error);
			}
		}
	}
	
	
}
