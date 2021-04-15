package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.FotoBean;
import bean.PersonaBean;
import bean.PiattiBean;
import server.DriverManagerConnectionPool;

public class PiattiDAO {
	
	public synchronized void doSave(PiattiBean p) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "insert into piatti" 
				+ " (piatto, descrizione, attivitaIDAttivita) values (?, ?, ?)";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, p.getPiatto());
			preparedStatement.setString(2, p.getDescrizione());
			preparedStatement.setInt(3, p.getAttivitaIDAttivita());
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
	public void doSaveSelection(PiattiBean p) {
	}

	public synchronized PiattiBean doRetrieveByKey(int idPiatto){
		 
		 Connection conn = null;
		 PreparedStatement ps = null;
		 try {
			PiattiBean p = new PiattiBean(idPiatto); 
			conn = DriverManagerConnectionPool.getConnection();
			ps = conn.
					prepareStatement("SELECT * FROM wheredoieat.piatti WHERE idPiatto = ?");
			ps.setInt(1, idPiatto);
					
			ResultSet res = ps.executeQuery();

			// 4. Prendi il risultato
			if(res.next())
			{
				p.setIdPiatto(res.getInt("idPiatto"));
				p.setPiatto(res.getString("piatto"));
				p.setDescrizione(res.getString("descrizione"));
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
	
	
	public synchronized boolean doDelete(int idPiatto) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "delete from piatti" + " where idPiatto = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, idPiatto);

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
	
	public synchronized void doUpdate(PiattiBean p) throws SQLException {

		Connection connection = null;
	PreparedStatement preparedStatement = null;
	
	String updateSQL ="UPDATE piatti"+
            " SET idPiatto= ?, piatto=?, descrizione=?, attivitaIDAttivita=? WHERE idPiatto=?";
	try {
		connection = DriverManagerConnectionPool.getConnection();
		preparedStatement = connection.prepareStatement(updateSQL);
		preparedStatement.setInt(1, p.getIdPiatto());
		preparedStatement.setString(2, p.getPiatto());
		preparedStatement.setString(3, p.getDescrizione());
		preparedStatement.setInt(4, p.getAttivitaIDAttivita());
		preparedStatement.setInt(5, p.getIdPiatto());
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
	
	public synchronized ArrayList<PiattiBean> doRetrieveAll() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<PiattiBean> p = new ArrayList<PiattiBean>();

		String selectSQL = "SELECT * FROM piatti;";
		
		

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				PiattiBean bean = new PiattiBean();
				bean.setIdPiatto(rs.getInt("idPiatto"));
				bean.setPiatto(rs.getString("piatto"));
				bean.setDescrizione(rs.getString("descrizione"));
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
	
	public synchronized ArrayList<PiattiBean> doRetrieveByAttivita(int id){
		 
		 Connection conn = null;
		 PreparedStatement ps = null;
		 try {
			ArrayList<PiattiBean> fList=new ArrayList<PiattiBean>();
			conn = DriverManagerConnectionPool.getConnection();
			ps = conn.
					prepareStatement("SELECT * FROM wheredoieat.piatti WHERE attivitaIDAttivita = ?");
			ps.setInt(1, id);
					
			ResultSet res = ps.executeQuery();

			// 4. Prendi il risultato
			while(res.next())
			{
				PiattiBean f = new PiattiBean();
				f.setIdPiatto(res.getInt("idPiatto"));
				f.setPiatto(res.getString("piatto"));
				f.setDescrizione(res.getString("descrizione"));
				f.setAttivitaIDAttivita(res.getInt("attivitaIDAttivita"));
		
				fList.add(f);
			}
			return fList;
			
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
	
}

