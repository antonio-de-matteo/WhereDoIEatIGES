package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.PersonaBean;
import bean.PreferitiBean;
import server.DriverManagerConnectionPool;

public class PreferitiDAO {
	
	public synchronized void doSave(PreferitiBean p) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "insert into preferiti" 
				+ " (personaUsername, attivitaIDAttivita) values (?, ?)";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, p.getPersonaUsername());
			preparedStatement.setInt(2, p.getAttivitaIDAttivita());
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
		this.doSaveSelection(p);
		
	}
	public void doSaveSelection(PreferitiBean p) {
	}

	public synchronized PreferitiBean doRetrieveByKey(int idPref){
		 
		 Connection conn = null;
		 PreparedStatement ps = null;
		 try {
			PreferitiBean p = new PreferitiBean(); 
			conn = DriverManagerConnectionPool.getConnection();
			ps = conn.
					prepareStatement("SELECT * FROM wheredoieat.preferiti WHERE idPref = ? ");
			ps.setInt(1, idPref);
					
			ResultSet res = ps.executeQuery();

			// 4. Prendi il risultato
			if(res.next())
			{
				p.setIdPref(res.getInt("idPref"));
				p.setPersonaUsername(res.getString("personaUsername"));
				p.setAttivitaIDAttivita(res.getInt("attivitaIDAttivita"));
				return p;
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
	
	
	public synchronized boolean doDelete(int idPref) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "delete from preferiti" + " where idPref = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, idPref);

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
	
	public synchronized void doUpdate(PreferitiBean p) throws SQLException {

		Connection connection = null;
	PreparedStatement preparedStatement = null;
	
	String updateSQL ="UPDATE preferiti"+
            " SET personaUsername= ?, attivitaIDAttivita=? WHERE idPref=? ";
	try {
		connection = DriverManagerConnectionPool.getConnection();
		preparedStatement = connection.prepareStatement(updateSQL);
		preparedStatement.setString(1, p.getPersonaUsername());
		preparedStatement.setInt(2, p.getAttivitaIDAttivita());
		preparedStatement.setInt(3, p.getIdPref());
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
	
	public synchronized ArrayList<PreferitiBean> doRetrieveAll() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<PreferitiBean> p = new ArrayList<PreferitiBean>();

		String selectSQL = "SELECT * FROM preferiti;";
		
		

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				PreferitiBean bean = new PreferitiBean();
				bean.setIdPref(rs.getInt("idPref"));
				bean.setPersonaUsername(rs.getString("personaUsername"));
				bean.setAttivitaIDAttivita(rs.getInt("attivitaIDAttivita"));
				p.add(bean);
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
		return p;
	}
	
	
}
