package la.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sun.jdi.connect.spi.Connection;

import la.bean.StarBean;


//作成途中
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
	}

	private void getConnection() throws DAOException{

	}

}
