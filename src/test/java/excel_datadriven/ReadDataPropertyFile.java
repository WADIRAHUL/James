package excel_datadriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class ReadDataPropertyFile {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/commondata.properties");
		Properties cd = new Properties();
		cd.load(fis);
		String actiTimeUrl = cd.getProperty("url");
		System.out.println("actiTimeUrl: "+actiTimeUrl);
		String actiTimeUsername = cd.getProperty("username");
		System.out.println("actiTimeUsername: "+actiTimeUsername);
		String actiTimePassword = cd.getProperty("password");
		System.out.println("actiTimePassword: "+actiTimePassword);
	}
}
