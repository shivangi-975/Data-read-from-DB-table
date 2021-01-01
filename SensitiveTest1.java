// prg to read data from DB table

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;


public class SensitiveTest1
{
	public static void main(String args[])
	{
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loaded");
			 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
			System.out.println("connection established");
			st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			System.out.println("statement prepared");
			rs=st.executeQuery("select * from student");
			System.out.println("query executed");
			int cnt=0;
			
			while(rs.next())
			{
			System.out.print(rs.getString(1)+"\t");
			System.out.print(rs.getString(2)+"\t");
			System.out.print(rs.getString(3)+"\t");
             if(cnt==2)
			Thread.currentThread().sleep(40000);

			System.out.println();
			cnt++;

			}//while

			System.out.println("Resultset is processed");
			rs.close();
			st.close();
			con.close();
		}//try
		catch(ClassNotFoundException cnf)
		{
			cnf.printStackTrace();
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}//main
}//class

