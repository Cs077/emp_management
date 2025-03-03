package employee_doa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import employee_bo.EmployeeBo;

public class EmployeeDoa {
	public static Connection getConnection() {
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emp?useSSL=false&allowPublicKeyRetrieval=true","root","Ch@25678");
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	public static int empDataInsert(EmployeeBo eb) {
		int status=0;
		try {
		Connection con=EmployeeDoa.getConnection();
		String sql="insert into empls(name,email)values(?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, eb.getName());
		ps.setString(2,eb.getEmail());
		
		status=ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	public static int empDataDeletion(int id1) {
		int status=0;
		try {
			Connection con=EmployeeDoa.getConnection();
			String sql="delete from empls where id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id1);
			status=ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	public static int empDataUpdate(EmployeeBo eb3) {
		int status=0;
		try {
			Connection con=EmployeeDoa.getConnection();
			String sql="update empls set name=?,email=? where id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, eb3.getName());
			ps.setString(2, eb3.getEmail());
			ps.setInt(3,eb3.getId());
			status=ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	public static int empDataFetch(EmployeeBo eb4) {
		int status=0;
		try {
			Connection con=EmployeeDoa.getConnection();
			String sql="select * from empls";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	

}