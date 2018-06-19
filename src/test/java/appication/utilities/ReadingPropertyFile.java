package appication.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import com.google.common.collect.Lists;
import com.google.common.io.Files;
import com.sun.org.apache.xpath.internal.functions.Function;

public class ReadingPropertyFile {

	public static Properties prop = new Properties();
	public static Properties enabled = new Properties();
	List<String> result;
	
	public void readPriorityPropertyFile() throws IOException{

		//Create an object of File Input Stream Class
		//Import Property file

		try{
			FileInputStream ip = new FileInputStream("src"+File.separator+"test"+File.separator+"java"+File.separator+"application"+File.separator+"configuration"+File.separator+"priority.properties");
			prop.load(ip);			
			System.out.println("Priorities are loaded");	
		}

		catch(FileNotFoundException e){
			System.out.println("File does not exist in the specified location");
		}
		
	}
	
	public void readTestCaseEnablePropertyFile() throws IOException{

		//Create an object of File Input Stream Class
		//Import Property file

		try{

			FileInputStream ip1 = new FileInputStream("src"+File.separator+"test"+File.separator+"java"+File.separator+"application"+File.separator+"configuration"+File.separator+"enabled.properties");
			enabled.load(ip1);			
		
			System.out.println("Test Case execution are Enabled/Disabled");
		}

		catch(FileNotFoundException e){

			System.out.println("File does not exist in the specified location");
		}
		
	}

}
