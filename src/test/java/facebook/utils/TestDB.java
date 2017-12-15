package facebook.utils;

import java.io.IOException;
import java.sql.ResultSet;

public class TestDB {

	public static void main(String[] args) throws IOException {
	
		Orclconn orcl = new Orclconn( );
		
		orcl.OpenDBConnection();
		
		
		ResultSet list = orcl.RunQuery("Select * from tab");
		
		System.out.println(list);

	}

}

