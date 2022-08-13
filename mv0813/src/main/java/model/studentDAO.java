package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class studentDAO {
	public boolean addArray(student[] array) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "1234");
			for (student s : array) {
				PreparedStatement st = conn.prepareStatement("insert into classicmodels.student(username,age)values(?,?)");
				st.setString(1, s.getName());
				st.setInt(2, s.getAge());
				int r = st.executeUpdate();
				if(r==0)
					return false;
			}
			conn.close();
			return true;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return false;
	}
}
