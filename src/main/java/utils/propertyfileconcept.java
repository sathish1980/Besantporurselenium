package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class propertyfileconcept {
	
	String filepath=System.getProperty("user.dir")+"//input//env.properties";
	public void propertyconcepts() throws IOException
	{
		File f = new File(filepath);
		FileInputStream FI = new FileInputStream(f);
		Properties p = new Properties();
		p.load(FI);
		System.out.println(p.getProperty("name"));
		System.out.println(p.getProperty("age"));
		int newval=Integer.parseInt(p.getProperty("age"));
		
		System.out.println(p.getProperty("email"));
		p.setProperty("education", "B.tech");
		System.out.println(p.getProperty("education"));
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		propertyfileconcept p = new propertyfileconcept();
		p.propertyconcepts();
	}

}
