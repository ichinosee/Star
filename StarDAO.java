//作成途中

package la.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sun.jdi.connect.spi.Connection;

import la.bean.StarBean;

public class StarDAO {
	private Connection con;

	public StarDAO() throws DAOException{
		getConnection();
	}

	public String SveStar(StarBean star)
	throws DAOException{
		if(con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			int code = 0;
			String sql = "SELECT nextval('customer_code_seq')";
			st = con.preparedStatement(sql);
			rs = st.executeQuery();
			if(rs.next()) {
				code = rs.getInt(1);
			}

			rs.close();
			st.close();

			
			sql = "INSERT INTO star VALUES(?, ?)";
			st = con.preparedStatement(sql);

			st.setInt(1, code);
			st.setString(2, star.star());

			st.executeUpdate();
			st.close();

		}
	}


	private void getConnection() throws DAOException{
		try {
			Class.forName("org.postgresql.Driver");

			String url = "jdbc:postgresql:nose";
			String user = "student";
			String pass = "himitu";

			con = DriverManager.getConnection(url, user, pass);
		}catch(Exception e) {
			e.printStackTrace();
			throw new DAOException("接続に失敗しました");
		}

	}

	private void close() throws SQLException {
		if(con != null) {
			con.close();
			con = null;
		}
	}

}
