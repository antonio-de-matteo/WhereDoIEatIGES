package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.FotoBean;
import bean.PersonaBean;
import server.DriverManagerConnectionPool;

public class FotoDAO {
	
	public synchronized void doSave(FotoBean f) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "insert into wheredoieat.foto" 
				+ " (foto, attivitaIDattivita) values (?, ?)";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, f.getFoto());
			preparedStatement.setInt(2, f.getAttivitaIDAttivita());
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
		this.doSaveSelection(f);
		
	}
	public void doSaveSelection(FotoBean f) {
	}

	public synchronized FotoBean doRetrieveByKey(String foto){
		 
		 Connection conn = null;
		 PreparedStatement ps = null;
		 try {
			FotoBean f = new FotoBean(foto); 
			conn = DriverManagerConnectionPool.getConnection();
			ps = conn.
					prepareStatement("SELECT * FROM wheredoieat.foto WHERE foto = ?");
			ps.setString(1, foto);
					
			ResultSet res = ps.executeQuery();

			// 4. Prendi il risultato
			if(res.next())
			{
				f.setFoto(res.getString("foto"));
				f.setAttivitaIDAttivita(res.getInt("attivitaIDattivita"));
		
				return f;
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
	
	
	public synchronized boolean doDelete(String foto) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "delete from foto" + " where foto = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setString(1, foto);

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
	
	public synchronized void doUpdate(FotoBean f, String path) throws SQLException {

		Connection connection = null;
	PreparedStatement preparedStatement = null;
	
	String updateSQL ="UPDATE Foto"+
            " SET foto= ?, attivitaIDattivita=? WHERE foto=?";
	try {
		connection = DriverManagerConnectionPool.getConnection();
		preparedStatement = connection.prepareStatement(updateSQL);
		preparedStatement.setString(1, f.getFoto());
		preparedStatement.setInt(2, f.getAttivitaIDAttivita());
		preparedStatement.setString(3, path);
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
	
	public synchronized ArrayList<FotoBean> doRetrieveAll() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<FotoBean> f = new ArrayList<FotoBean>();

		String selectSQL = "SELECT * FROM foto;";
		
		

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				FotoBean bean = new FotoBean();
				bean.setFoto(rs.getString("foto"));
				bean.setAttivitaIDAttivita(rs.getInt("attivitaIDattivita"));
				f.add(bean);
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
		return f;
	}
	
	public synchronized ArrayList<FotoBean> doRetrieveGroupby() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<FotoBean> f = new ArrayList<FotoBean>();

		String selectSQL = "SELECT * FROM foto GROUP BY attivitaIDattivita;";
		
		

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				FotoBean bean = new FotoBean();
				bean.setFoto(rs.getString("foto"));
				bean.setAttivitaIDAttivita(rs.getInt("attivitaIDattivita"));
				f.add(bean);
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
		return f;
	}
	
	public synchronized ArrayList<FotoBean> doRetrieveByAttivita(int id){
		 
		 Connection conn = null;
		 PreparedStatement ps = null;
		 try {
			ArrayList<FotoBean> fList=new ArrayList<FotoBean>();
			conn = DriverManagerConnectionPool.getConnection();
			ps = conn.
					prepareStatement("SELECT * FROM wheredoieat.foto WHERE attivitaIDAttivita = ?");
			ps.setInt(1, id);
					
			ResultSet res = ps.executeQuery();

			// 4. Prendi il risultato
			while(res.next())
			{
				FotoBean f = new FotoBean();
				f.setFoto(res.getString("foto"));
				f.setAttivitaIDAttivita(res.getInt("attivitaIDattivita"));
		
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
