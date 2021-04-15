package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.SuggerimentiBean;
import server.DriverManagerConnectionPool;

public class SuggerimentiDAO {
	
	public synchronized void doSave(SuggerimentiBean s) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "insert into suggerimenti" 
				+ " (titolo, testo, personaUsername) values (?, ?, ?)";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, s.getTitolo());
			preparedStatement.setString(2, s.getTesto());
			preparedStatement.setString(3, s.getPersonaUsername());

			preparedStatement.executeUpdate();

			connection.commit();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		this.doSaveSelection(s);
		
	}
	public void doSaveSelection(SuggerimentiBean s) {
	}

	public synchronized SuggerimentiBean doRetrieveByKey(int id){
		 
		 Connection conn = null;
		 PreparedStatement ps = null;
		 try {
			SuggerimentiBean s = new SuggerimentiBean(id); 
			conn = DriverManagerConnectionPool.getConnection();
			ps = conn.
					prepareStatement("SELECT * FROM wheredoieat.suggerimenti WHERE id = ?");
			ps.setInt(1, id);
					
			ResultSet res = ps.executeQuery();

			// 4. Prendi il risultato
			if(res.next())
			{
				s.setId(res.getInt("id"));
				s.setTitolo(res.getString("titolo"));
				s.setTesto(res.getString("testo"));
				s.setPersonaUsername(res.getString("personaUsername"));

				return s;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				DriverManagerConnectionPool.releaseConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	 }
	
	
	public synchronized boolean doDelete(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "delete from suggerimenti" + " where id = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, id);

			result = preparedStatement.executeUpdate();

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return (result != 0);
	}
	
	public synchronized void doUpdate(SuggerimentiBean s) throws SQLException {

		Connection connection = null;
	PreparedStatement preparedStatement = null;
	
	String updateSQL ="UPDATE suggerimenti"+
            " SET id= ?, titolo=?, testo=?, personaUsername=? WHERE id=?";
	try {
		connection = DriverManagerConnectionPool.getConnection();
		preparedStatement = connection.prepareStatement(updateSQL);
		preparedStatement.setInt(1, s.getId());
		preparedStatement.setString(2, s.getTitolo());
		preparedStatement.setString(3, s.getTesto());
		preparedStatement.setString(4, s.getPersonaUsername());
		preparedStatement.setInt(5, s.getId());
	    preparedStatement.executeUpdate();

	   connection.commit();
} finally {
	try {
		if (preparedStatement != null)
			preparedStatement.close();
	} finally {
		if (connection != null)
			connection.close();
}
} 
	}
	
	public synchronized ArrayList<SuggerimentiBean> doRetrieveAll() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<SuggerimentiBean> s = new ArrayList<SuggerimentiBean>();

		String selectSQL = "SELECT * FROM suggerimenti;";
		
		

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				SuggerimentiBean bean = new SuggerimentiBean();
				bean.setId(rs.getInt("id"));
				bean.setTitolo(rs.getString("titolo"));
				bean.setTesto(rs.getString("testo"));
				bean.setPersonaUsername(rs.getString("personaUsername"));
				s.add(bean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return s;
	}
	
	
}

