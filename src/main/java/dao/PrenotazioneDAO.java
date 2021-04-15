package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.PrenotazioneBean;
import server.DriverManagerConnectionPool;

public class PrenotazioneDAO {
	
	public synchronized void doSave(PrenotazioneBean p) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "insert into prenotazione" 
				+ " (data, ora, numPosti, personaUsername, attivitaIDAttivita) values (?, ?, ?, ?, ?)";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, p.getData());
			preparedStatement.setInt(2, p.getOra());
			preparedStatement.setInt(3, p.getNumPosti());
			preparedStatement.setString(4, p.getPersonaUsername());
			preparedStatement.setInt(5, p.getAttivitaIDAttivita());
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
	public void doSaveSelection(PrenotazioneBean p) {
	}

	public synchronized PrenotazioneBean doRetrieveByKey(int idPren){
		 
		 Connection conn = null;
		 PreparedStatement ps = null;
		 try {
			PrenotazioneBean p = new PrenotazioneBean(idPren); 
			conn = DriverManagerConnectionPool.getConnection();
			ps = conn.
					prepareStatement("SELECT * FROM wheredoieat.prenotazione WHERE idPren = ?");
			ps.setInt(1, idPren);
					
			ResultSet res = ps.executeQuery();

			// 4. Prendi il risultato
			if(res.next())
			{
				p.setIdPren(res.getInt("idPren"));
				p.setData(res.getString("data"));
				p.setOra(res.getInt("ora"));
				p.setNumPosti(res.getInt("numPosti"));
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
	
	
	public synchronized boolean doDelete(int idPren) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "delete from prenotazione" + " where idPren = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, idPren);

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
	
	public synchronized void doUpdate(PrenotazioneBean p) throws SQLException {

		Connection connection = null;
	PreparedStatement preparedStatement = null;
	
	String updateSQL ="UPDATE prenotazione"+
            " SET idPren= ?, data=?, ora=?, numPosti=? , personaUsername=?, attivitaIDAttivita=? WHERE idPren=?";
	try {
		connection = DriverManagerConnectionPool.getConnection();
		preparedStatement = connection.prepareStatement(updateSQL);
		preparedStatement.setInt(1, p.getIdPren());
		preparedStatement.setString(2, p.getData());
		preparedStatement.setInt(3, p.getOra());
		preparedStatement.setInt(4, p.getNumPosti());
		preparedStatement.setString(5, p.getPersonaUsername());
		preparedStatement.setInt(6, p.getAttivitaIDAttivita());
		preparedStatement.setInt(7, p.getIdPren());
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
	
	public synchronized ArrayList<PrenotazioneBean> doRetrieveAll() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<PrenotazioneBean> p = new ArrayList<PrenotazioneBean>();

		String selectSQL = "SELECT * FROM prenotazione;";
		
		

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				PrenotazioneBean bean = new PrenotazioneBean();
				bean.setIdPren(rs.getInt("idPren"));
				bean.setData(rs.getString("data"));
				bean.setOra(rs.getInt("ora"));
				bean.setNumPosti(rs.getInt("numPosti"));
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
	
	public synchronized int doRetrieveByOra(int ora,int id, String data) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
        int ris = 0;
		ArrayList<PrenotazioneBean> p = new ArrayList<PrenotazioneBean>();

		String selectSQL = "SELECT sum(numPosti) FROM prenotazione WHERE ora= ? AND attivitaIDAttivita= ? AND data= ?";
		
		

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setInt(1, ora);
            preparedStatement.setInt(2, id);
            preparedStatement.setString(3, data);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
	            ris=rs.getInt("sum(numPosti)");
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
		return ris;
	}
	
	public ArrayList<PrenotazioneBean> doRetrieveByUser(String user) throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ArrayList<PrenotazioneBean> ret=new ArrayList<PrenotazioneBean>();
		String selectSQL = "select * from prenotazione where personaUsername= ?";
       
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1,user);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				PrenotazioneBean bean=new PrenotazioneBean();
				bean.setIdPren(rs.getInt("idPren"));
				bean.setData(rs.getString("data"));
				bean.setOra(rs.getInt("ora"));
				bean.setNumPosti(rs.getInt("numPosti"));
				bean.setPersonaUsername(rs.getString("personaUsername"));
				bean.setAttivitaIDAttivita(rs.getInt("attivitaIDAttivita"));
				
				ret.add(bean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return ret;
	}
	
	
}
