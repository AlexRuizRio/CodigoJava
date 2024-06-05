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
			conn.setAutoCommit(false);
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
	 public void buscarCafePorNombre(String nombre) {
	        String query = "SELECT * FROM sys.COFFEES WHERE COF_NAME = ?";
	        try {
	            pst = conn.prepareStatement(query);
	            pst.setString(1, nombre);
	            rs = pst.executeQuery();
	            if (rs.next()) {
	                System.out.println("Nombre: " + rs.getString("COF_NAME"));
	                System.out.println("ID Proveedor: " + rs.getInt("SUP_ID"));
	                System.out.println("Precio: " + rs.getDouble("PRICE"));
	                System.out.println("Ventas: " + rs.getInt("SALES"));
	                System.out.println("Total: " + rs.getInt("TOTAL"));
	            } else {
	                System.out.println("No se encontró el café: " + nombre);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            clear();
	        }
	    }
	 public void insertarCafe(String nombre, int supId, double precio, int ventas, int total) {
	        String query = "INSERT INTO sys.COFFEES (COF_NAME, SUP_ID, PRICE, SALES, TOTAL) VALUES (?, ?, ?, ?, ?)";
	        try {
	            pst = conn.prepareStatement(query);
	            pst.setString(1, nombre);
	            pst.setInt(2, supId);
	            pst.setDouble(3, precio);
	            pst.setInt(4, ventas);
	            pst.setInt(5, total);
	            pst.executeUpdate();
	            System.out.println("Café insertado: " + nombre);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	        	clear();
	        }
	    }
	 public void borrarCafe(String nombre) {
	        String query = "DELETE FROM sys.COFFEES WHERE COF_NAME = ?";
	        try {
	            pst = conn.prepareStatement(query);
	            pst.setString(1, nombre);
	            int filas = pst.executeUpdate();
	            if (filas > 0) {
	                System.out.println("Café borrado: " + nombre);
	            } else {
	                System.out.println("No se encontró el café: " + nombre);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	        	clear();
	        }
	    }

	    public void mostrarCafesPorProveedor(int supId) {
	        String query = "SELECT sys.COFFEES.*, sys.SUPPLIERS.* FROM sys.COFFEES JOIN sys.SUPPLIERS ON sys.COFFEES.SUP_ID = sys.SUPPLIERS.SUP_ID WHERE sys.COFFEES.SUP_ID = ?";
	        try {
	            pst = conn.prepareStatement(query);
	            pst.setInt(1, supId);
	            rs = pst.executeQuery();
	            while (rs.next()) {
	                System.out.println("Nombre: " + rs.getString("COF_NAME"));
	                System.out.println("ID Proveedor: " + rs.getInt("SUP_ID"));
	                System.out.println("Precio: " + rs.getDouble("PRICE"));
	                System.out.println("Ventas: " + rs.getInt("SALES"));
	                System.out.println("Total: " + rs.getInt("TOTAL"));
	                System.out.println("Proveedor: " + rs.getString("SUP_NAME"));
	                System.out.println("Calle: " + rs.getString("STREET"));
	                System.out.println("Ciudad: " + rs.getString("CITY"));
	                System.out.println("Estado: " + rs.getString("STATE"));
	                System.out.println("Código Postal: " + rs.getString("ZIP"));
	                System.out.println("-----------");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	        	clear();
	        }
	    }
	    public void actualizarPrecioCafe(String nombre, double nuevoPrecio) {
	        String query = "UPDATE sys.COFFEES SET PRICE = ? WHERE COF_NAME = ?";
	        try {
	            pst = conn.prepareStatement(query);
	            pst.setDouble(1, nuevoPrecio);
	            pst.setString(2, nombre);
	            pst.executeUpdate();
	            System.out.println("Precio actualizado para el café: " + nombre);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	        	clear();
	        }
	    }

	    public void manejarTransaccion() {
	        try {
	            insertarCafe("Natural", 101, 9.99, 100, 200);
	            actualizarPrecioCafe("Natural", 10.99);
	            borrarCafe("Natural");

	            conn.commit();
	            System.out.println("Transacción completada exitosamente.");

	        } catch (SQLException e) {
	            try {

	                conn.rollback();
	                System.out.println("Transacción revertida.");
	            } catch (SQLException ex) {
	                ex.printStackTrace();
	            }
	            e.printStackTrace();
	        } finally {
	        	clear();
	        }
	    }
}
