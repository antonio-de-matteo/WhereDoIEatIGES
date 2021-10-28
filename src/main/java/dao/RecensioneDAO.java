package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.RecensioneBean;
import server.DriverManagerConnectionPool;

public class RecensioneDAO {
	
	public synchronized void doSave(RecensioneBean r) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "insert into recensione" 
				+ " (valutazione, commento, personaUsername, attivitaIDAttivita) values (?, ?, ?, ?)";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, r.getValutazione());
			preparedStatement.setString(2, r.getCommento());
			preparedStatement.setString(3, r.getPersonaUsername());
			preparedStatement.setInt(4, r.getAttivitaIDAttivita());
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
		this.doSaveSelection(r);
		
	}
	public void doSaveSelection(RecensioneBean r) {
	}

	public synchronized RecensioneBean doRetrieveByKey(int id){
		 
		 Connection conn = null;
		 PreparedStatement ps = null;
		 try {
			RecensioneBean r = new RecensioneBean(); 
			conn = DriverManagerConnectionPool.getConnection();
			ps = conn.
					prepareStatement("SELECT * FROM wheredoieat.recensione WHERE idRecensione = ?");
			ps.setInt(1,  id);
					
			ResultSet res = ps.executeQuery();

			// 4. Prendi il risultato
			if(res.next())
			{
				r.setIdRecensione(res.getInt("idRecensione"));
				r.setValutazione(res.getInt("valutazione"));
				r.setCommento(res.getString("commento"));
				r.setPersonaUsername(res.getString("personaUsername"));
				r.setAttivitaIDAttivita(res.getInt("attivitaIDAttivita"));
				
				return r;
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

		String deleteSQL = "delete from recensione" + " where idRecensione = ?";

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
	
	public synchronized void doUpdate(RecensioneBean r) throws SQLException {

		Connection connection = null;
	PreparedStatement preparedStatement = null;
	
	String updateSQL ="UPDATE recensione"+
            " SET valutazione= ?, commento=?, personaUsername=?, attivitaIDAttivita=? WHERE personaUsername=? AND attivitaIDAttivita = ?";
	try {
		connection = DriverManagerConnectionPool.getConnection();
		preparedStatement = connection.prepareStatement(updateSQL);
		preparedStatement.setInt(1, r.getValutazione());
		preparedStatement.setString(2, r.getCommento());
		preparedStatement.setString(3, r.getPersonaUsername());
		preparedStatement.setInt(4, r.getAttivitaIDAttivita());
		preparedStatement.setString(5, r.getPersonaUsername());
		preparedStatement.setInt(6, r.getAttivitaIDAttivita());

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
	
	public synchronized ArrayList<RecensioneBean> doRetrieveAll(int idAtt) throws SQLException {
		Connection conn = null;
		 PreparedStatement ps = null;
		 ArrayList<RecensioneBean> r= new ArrayList<RecensioneBean>();
		 try {
			conn = DriverManagerConnectionPool.getConnection();
			ps = conn.
					prepareStatement("SELECT * FROM wheredoieat.recensione WHERE attivitaIDAttivita = ?");
			ps.setInt(1,  idAtt);
					
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				RecensioneBean bean = new RecensioneBean();
				bean.setIdRecensione(rs.getInt("idRecensione"));
				bean.setValutazione(rs.getInt("valutazione"));
				bean.setCommento(rs.getString("commento"));
				bean.setPersonaUsername(rs.getString("personaUsername"));
				bean.setAttivitaIDAttivita(rs.getInt("attivitaIDAttivita"));

				r.add(bean);
			}

		} finally {
			try {
				if (ps != null)
					ps.close();
			} finally {
				if (conn != null)
					conn.close();
			}
		}
		return r;
	}
	
	public synchronized ArrayList<RecensioneBean> doRetriveByUser(String user) throws SQLException {

		Connection connection = null;
	PreparedStatement preparedStatement = null;
	ArrayList<RecensioneBean> ret = new ArrayList<RecensioneBean>();
	String selectSQL ="SELECT * FROM wheredoieat.recensione WHERE personaUsername = ?" ;
	try {
		connection = DriverManagerConnectionPool.getConnection();
		preparedStatement = connection.prepareStatement(selectSQL);
		preparedStatement.setString(1,user);

		ResultSet rs = preparedStatement.executeQuery();

		while (rs.next()) {
			RecensioneBean bean=new RecensioneBean();
			bean.setValutazione(rs.getInt("valutazione"));
			bean.setCommento(rs.getString("commento"));
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


    public ArrayList<RecensioneBean> doRetriveByOwner(String user) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ArrayList<RecensioneBean> ret = new ArrayList<RecensioneBean>();
		String selectSQL ="SELECT * FROM wheredoieat.recensione WHERE attivitaIDAttivita IN (SELECT idAttivita FROM wheredoieat.attivita WHere personaUsername=?)" ;
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1,user);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				RecensioneBean bean=new RecensioneBean();
				bean.setValutazione(rs.getInt("valutazione"));
				bean.setCommento(rs.getString("commento"));
				bean.setPersonaUsername(rs.getString("personaUsername"));
				bean.setAttivitaIDAttivita(rs.getInt("attivitaIDAttivita"));


				ret.add(bean);
			}

		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return ret;
    }
}
