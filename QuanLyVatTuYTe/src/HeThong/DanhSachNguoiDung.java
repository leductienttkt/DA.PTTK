package HeThong;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.DropMode;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import Class.Database;
import Class.NGUOIDUNG;

import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DanhSachNguoiDung implements ActionListener {

	private JPanel contentPane;
	private JTable tableLayout;
	Vector<String> title =  new Vector();
	Vector<Object> listUser = new Vector();
	DefaultTableModel model;
	JButton btnEdit, btnAddNew, btnDelete,btnRefresh;
	int soCot = 0;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DanhSachNguoiDung frame = new DanhSachNguoiDung();
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
	public DanhSachNguoiDung(JPanel contentPane) {
		/*this.setVisible(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(DanhSachNguoiDung.class.getResource("/images/1441360438_list-alt.png")));
		setTitle("DanhSachNguoiDung");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600 , 430);
		setResizable(false);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);*/
		
		
		tableLayout = new JTable();
			tableLayout.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			//disable kéo thả các cột
			tableLayout.getTableHeader().setReorderingAllowed(false);
			tableLayout.setSelectionBackground(Color.CYAN);


			JScrollPane tableResult = new JScrollPane(tableLayout);
				tableResult.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				tableResult.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
				tableResult.setBounds(10, 11, 864, 460);
				contentPane.add(tableResult);
			
			String getUser = "Select * from NGUOIDUNG order by Quyen ASC";
			Database db = new Database();
			ResultSet rs = db.getData(getUser);
				try {
					ResultSetMetaData rsmd = rs.getMetaData();
					soCot = rsmd.getColumnCount();
					 System.out.println("Số cột: "+soCot);
					for(int i=1;i<=soCot;i++){
						title.add(rsmd.getColumnLabel(i));
					}
					
					while(rs.next()){
						Vector<String> row = new Vector<String>();
						for (int i = 1; i <= soCot; i++) {
							row.add(rs.getString(i));
						}
						listUser.add(row);
					}
					rs.close();
					model = new DefaultTableModel(listUser, title);
					model.fireTableDataChanged();
					tableLayout.setModel(model);
					
					JPanel pnExecute = new JPanel();
					pnExecute.setBounds(10, 465, 864, 50);
					contentPane.add(pnExecute);
					pnExecute.setLayout(null);
					
					btnEdit = new JButton("Chỉnh sửa");
						btnEdit.setBounds(60, 7, 154, 41);
						btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 14));
						btnEdit.addActionListener(this);
						btnEdit.setIcon(new ImageIcon(DanhSachNguoiDung.class.getResource("/images/user1_edit.png")));
						pnExecute.add(btnEdit);
					
					btnAddNew = new JButton("Thêm mới");
						btnAddNew.setBounds(280, 7, 154, 41);
						btnAddNew.setIcon(new ImageIcon(DanhSachNguoiDung.class.getResource("/images/user_red_add2.png")));
						btnAddNew.setFont(new Font("Tahoma", Font.PLAIN, 14));
						btnAddNew.addActionListener(this);
						pnExecute.add(btnAddNew);
					
					btnDelete = new JButton("Xóa");
						btnDelete.setBounds(500, 7, 109, 41);
						btnDelete.setIcon(new ImageIcon(DanhSachNguoiDung.class.getResource("/images/1441002676_DeleteRed.png")));
						btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
						btnDelete.addActionListener(this);
						pnExecute.add(btnDelete);
						
					btnRefresh = new JButton("Cập nhật");
						btnRefresh.setBounds(684, 7, 112, 41);
						pnExecute.add(btnRefresh);
						btnRefresh.addActionListener(this);
						btnRefresh.setIcon(new ImageIcon(DanhSachNguoiDung.class.getResource("/images/refresh.png")));

					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			TableColumnModel colModel = tableLayout.getColumnModel();
				colModel.getColumn(0).setMinWidth(120);
				colModel.getColumn(1).setMinWidth(250);
				colModel.getColumn(2).setMinWidth(250);
				colModel.getColumn(3).setMinWidth(120);
				colModel.getColumn(4).setMinWidth(120);
			
			
	}
	
	
	@Override
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource() == btnEdit){
			int row = tableLayout.getSelectedRow();
			if(row>=0){
				
				NGUOIDUNG user = new NGUOIDUNG(tableLayout.getValueAt(row, 1).toString(),tableLayout.getValueAt(row, 2).toString(), tableLayout.getValueAt(row, 3).toString());
				 new ChinhSuaNguoiDung(user);
				
			} else JOptionPane.showMessageDialog(null,"Phải chọn 1 bản ghi");
			
		}
		else if(ae.getSource() == btnAddNew){
			new ThemMoiNguoiDung();
		} else if(ae.getSource() == btnDelete){
			int row = tableLayout.getSelectedRow();
			if(row>=0){
				int confirmDelete = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa tài khoản: "+tableLayout.getValueAt(row, 1).toString()+" ???");
				if(confirmDelete == JOptionPane.YES_OPTION){
					String deleteUser = "Delete from NGUOIDUNG where TaiKhoan=N'"+tableLayout.getValueAt(row, 1).toString()+"'";
					System.out.println(deleteUser);
					int kq = new Database().saveData(deleteUser);
					JOptionPane.showMessageDialog(null, "Kết quả xóa tài khoản "+tableLayout.getValueAt(row, 1).toString()+ " là: "
							+((kq!=-1)?" Thành công": "Thất bại"));
				}
				
			} else JOptionPane.showMessageDialog(null,"Phải chọn 1 bản ghi");
		}
		else if(ae.getSource() == btnRefresh){
			listUser.clear();
			String getListUsers = "Select * from NGUOIDUNG order by Quyen ASC";
			ResultSet rs = new Database().getData(getListUsers);
			try {
				while(rs.next()){
					Vector<String> row1 = new Vector<>();
					for(int i=1; i<=soCot ; i++) row1.add(rs.getString(i));
					listUser.add(row1);
				}
				rs.close();
				model = new DefaultTableModel(listUser, title);
				model.fireTableDataChanged();
				tableLayout.setModel(model);

				TableColumnModel colModel = tableLayout.getColumnModel();
				colModel.getColumn(0).setMinWidth(120);
				colModel.getColumn(1).setMinWidth(250);
				colModel.getColumn(2).setMinWidth(250);
				colModel.getColumn(3).setMinWidth(120);
				colModel.getColumn(4).setMinWidth(120);
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
