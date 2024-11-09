

public class ConnectJDBC
{ 
// database1 is the name of database you created
	private static final String url="jdbc:mysql://localhost:3306/:database1";
	
	// user and pwd is ur user name and password of oracle database
	private static final String user="root";
	private static final String pwd="welcome";
	public static void main(String ar[])
	{
		try{
		Connection con=DriverManager.getConnection(url,user,pwd);
		}
		Catch(SQLException e)
		{
			System.out.println("Fail to connect database");
		}
		
	}
}