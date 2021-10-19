package dao;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.PersonaBean;
import server.DriverManagerConnectionPool;

public class PersonaDAO {
	class GFG {
		public byte[] getSHA(String input) throws NoSuchAlgorithmException {
			// Static getInstance method is called with hashing SHA
			MessageDigest md = MessageDigest.getInstance("SHA-256");

			// digest() method called
			// to calculate message digest of an input
			// and return array of byte
			return md.digest(input.getBytes(StandardCharsets.UTF_8));
		}

		public String toHexString(byte[] hash) {
			// Convert byte array into signum representation
			BigInteger number = new BigInteger(1, hash);

			// Convert message digest into hex value
			StringBuilder hexString = new StringBuilder(number.toString(16));

			// Pad with leading zeros
			while (hexString.length() < 32) {
				hexString.insert(0, '0');
			}

			return hexString.toString();
		}
	}
	
	public synchronized void doSave(PersonaBean p) throws SQLException, NoSuchAlgorithmException {

		GFG gfg = new GFG();
		String s1 = "MisterSessa69";
		System.out.println("\n" + s1 + " : " + gfg.toHexString(gfg.getSHA(s1)));
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "insert into persona" 
				+ " (username, nome, cognome , email, telefono, citta, tipo, comune, password) values (?, ?, ?, ?, ?, ?, ?, ?, sha(?))";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, p.getUsername());
			preparedStatement.setString(2, p.getNome());
			preparedStatement.setString(3, p.getCognome());
			preparedStatement.setString(4, p.getEmail());
			preparedStatement.setString(5, p.getTelefono());
			preparedStatement.setString(6, p.getCitta());
			preparedStatement.setInt(7, p.getTipo());
			preparedStatement.setString(8, p.getComune());
			preparedStatement.setString(9, p.getPassword());
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
	public void doSaveSelection(PersonaBean p) {
	}

	public synchronized PersonaBean doRetrieveByKey(String username){
		 
		 Connection conn = null;
		 PreparedStatement ps = null;
		 try {
			PersonaBean p = new PersonaBean(username); 
			conn = DriverManagerConnectionPool.getConnection();
			ps = conn.
					prepareStatement("SELECT * FROM wheredoieat.persona WHERE username = ?");
			ps.setString(1, username);
					
			ResultSet res = ps.executeQuery();

			// 4. Prendi il risultato
			if(res.next())
			{
				p.setUsername(res.getString("username"));
				p.setNome(res.getString("nome"));
				p.setCognome(res.getString("cognome"));
				p.setEmail(res.getString("email"));
				p.setTelefono(res.getString("telefono"));
				p.setCitta(res.getString("citta"));
				p.setTipo(res.getInt("tipo"));
				p.setComune(res.getString("comune"));
				p.setPassword(res.getString("password"));
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
	
	
	
	
	public synchronized void doUpdate(PersonaBean p) throws SQLException {

		Connection connection = null;
	PreparedStatement preparedStatement = null;
	
	String updateSQL ="UPDATE persona"+
            " SET username= ?, nome=?, cognome=?, email=? , telefono=?, citta=?, tipo=?, comune=?, password=? WHERE username=?";
	try {
		connection = DriverManagerConnectionPool.getConnection();
		preparedStatement = connection.prepareStatement(updateSQL);
		preparedStatement.setString(1, p.getUsername());
		preparedStatement.setString(2, p.getNome());
		preparedStatement.setString(3, p.getCognome());
		preparedStatement.setString(4, p.getEmail());
		preparedStatement.setString(5, p.getTelefono());
		preparedStatement.setString(6, p.getCitta());
		preparedStatement.setInt(7, p.getTipo());
		preparedStatement.setString(8, p.getComune());
		preparedStatement.setString(9, p.getPassword());
		preparedStatement.setString(10, p.getUsername());
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
	
	public synchronized boolean doDelete(String usr) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "delete from persona" + " where username = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setString(1, usr);

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
	
	public synchronized ArrayList<PersonaBean> doRetrieveAll() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<PersonaBean> p = new ArrayList<PersonaBean>();

		String selectSQL = "SELECT * FROM persona;";
		
		

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				PersonaBean bean = new PersonaBean();
				
				
				bean.setUsername(rs.getString("username"));
				bean.setNome(rs.getString("nome"));
				bean.setCognome(rs.getString("cognome"));
				bean.setEmail(rs.getString("email"));
				bean.setTelefono(rs.getString("telefono"));
				bean.setCitta(rs.getString("citta"));
				bean.setTipo(rs.getInt("tipo"));
				bean.setComune(rs.getString("comune"));
				bean.setPassword(rs.getString("password"));
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
	
	public synchronized PersonaBean doRetrieveByLogin(String username, String password){
		 
		 Connection conn = null;
		 PreparedStatement ps = null;
		 try {
			PersonaBean p = new PersonaBean(username); 
			conn = DriverManagerConnectionPool.getConnection();
			ps = conn.
					prepareStatement("SELECT * FROM wheredoieat.persona WHERE username = ? AND password = sha(?)");
			ps.setString(1, username);
			ps.setString(2, password);
					
			ResultSet res = ps.executeQuery();

			// 4. Prendi il risultato
			if(res.next())
			{
				p.setUsername(res.getString("username"));
				p.setNome(res.getString("nome"));
				p.setCognome(res.getString("cognome"));
				p.setEmail(res.getString("email"));
				p.setTelefono(res.getString("telefono"));
				p.setCitta(res.getString("citta"));
				p.setTipo(res.getInt("tipo"));
				p.setComune(res.getString("comune"));
				p.setPassword(res.getString("password"));
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
	
	public synchronized PersonaBean doRetrieveByEmail(String email){
		 
		 Connection conn = null;
		 PreparedStatement ps = null;
		 try {
			PersonaBean p = new PersonaBean(email); 
			conn = DriverManagerConnectionPool.getConnection();
			ps = conn.
					prepareStatement("SELECT * FROM wheredoieat.persona WHERE email = ?");
			ps.setString(1, email);
					
			ResultSet res = ps.executeQuery();

			// 4. Prendi il risultato
			if(res.next())
			{
				p.setUsername(res.getString("username"));
				p.setNome(res.getString("nome"));
				p.setCognome(res.getString("cognome"));
				p.setEmail(res.getString("email"));
				p.setTelefono(res.getString("telefono"));
				p.setCitta(res.getString("citta"));
				p.setTipo(res.getInt("tipo"));
				p.setComune(res.getString("comune"));
				p.setPassword(res.getString("password"));
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

































































































































































































































































































































}
