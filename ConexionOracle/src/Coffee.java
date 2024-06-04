import java.sql.*;

public class Coffee 
{
	private Connection conn;
	private ResultSet rs;
	private Statement st;
	private PreparedStatement pst;
	
	public Coffee()
	{
		try
		{
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "123456*/*");
			st = conn.createStatement();
			pst = null;
			rs = null;
		}catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			if(conn != null){				
				conn.close();
			}
		}catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void clear()
	{
		try {
			if (rs != null) {
				rs.close();
			}
			if (pst != null) {
				pst.close();
			}
			if (st != null) {
				st.close();
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	public void showCoffee() {
		String query = "SELECT * FROM sys.COFFEES";
		try {
			rs = st.executeQuery(query);
			while (rs.next())
			{
				System.out.println("Nombre: " + rs.getString("COF_NAME"));
				System.out.println("ID Proveedor: " + rs.getInt("SUP_ID"));
				System.out.println("Precio: " + rs.getDouble("PRICE"));
				System.out.println("Ventas: " + rs.getInt("SALES"));
				System.out.println("Total: " + rs.getInt("TOTAL"));
				System.out.println("-------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			clear();
		}
	}
}
