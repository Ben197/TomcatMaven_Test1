package n.bp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SQLInterface1 {
	
	private Connection connection = null;
	private String kleur = "";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SQLInterface1 sqlint1 = new SQLInterface1();
		sqlint1.setConnection();
		
	}
	
	public void setExternalConnection()
	{
	
	
		if(connection == null)
		{
			this.setConnection();
			
		}
	}
	
	
	public void setConnection() {

		try {
			
			Connection connection = DriverManager.getConnection("jdbc:mariadb://accmdb01.bpittens.nl:3306/DB?user=mariadb&password=mBwahlbs1967#");
			System.out.println("geslaagd");
			// 
			
		} catch (SQLException e) {
			System.out.println(e.toString());
		} catch (Exception e) {
			System.out.println(e.toString());
			
		} finally {

			/*try {
				if (this.connection != null) {
					this.connection.close();
				}
			} catch (final SQLException sqe) {
				System.out.println(sqe.toString()); 
			}*/
		}
		
	}
	
	public String getkleur() {

			Statement stmt = null;
			String query = "Select * from KLEURTABEL";
			
			try {
				stmt = this.connection.createStatement();
				 ResultSet rs = stmt.executeQuery(query);
			        
			        while (rs.next()) {
			        	kleur = rs.getString("KLEUR");
			        }
			        	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	       
		return kleur;
	}
	
	public void sluitConnectie()
	{
		try {
		if (this.connection != null) {
			this.connection.close();
			System.out.println("connectie weer gesloten");
		}
		} catch (final SQLException sqe) {
			System.out.println(sqe.toString()); 
		}
	}


}






		
 


