package Class;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	public Connection conn=null;
	public Database(){
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://localhost\\SQLEXPRESS;database=QuanLyVatTuYTe";
			String user = "sa";
			String pass = "06082301";
			conn = DriverManager.getConnection(url, user, pass);
			
		}catch(Exception e){
			System.out.println("Error is: "+e.getMessage());
		}
	}
	
	//getData
	public ResultSet getData(String sql){
		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			return rs;
		} catch (SQLException e) {
			System.out.println("Error getData : "+e.getMessage());
			return null;
		}
	}
	
	//saveData
	public int saveData(String sql){
		int kq=-1;
		try{
			Statement stm = conn.createStatement();
			kq = stm.executeUpdate(sql);
			
		}catch(Exception e){
			System.out.println("Error Save Data : "+e.getMessage());
		}
		return kq;
	}
}
