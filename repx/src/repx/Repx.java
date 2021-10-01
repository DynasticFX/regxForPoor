package repx;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Repx {

	public static void main(String[] args) {
		int pattern = 0;
		String argstring = args[1];
		for(char arg : argstring.toCharArray()) {
			switch(arg) {
			case 'e':
				pattern |= Pattern.CANON_EQ;
				break;
			case 'i':
				pattern |= Pattern.CASE_INSENSITIVE;
				break;
			case 'c':
				pattern |= Pattern.COMMENTS;
				break;
			case 'd':
				pattern |= Pattern.DOTALL;
				break;
			case 'l':
				pattern |= Pattern.LITERAL;
				break;
			case'm':
				pattern |= Pattern.MULTILINE;
				break;
			case 'u':
				pattern |= Pattern.UNICODE_CASE;
				break;
			case 'x':
				pattern |= Pattern.UNIX_LINES;
				break;
			}
		}
		String path = args[0];
		String regextext = convertFileToStringBuilder(path).toString();
		
	}
	public static StringBuilder convertFileToStringBuilder(String path ) {
		StringBuilder content = new StringBuilder();
	    String line;
		try {
			
			BufferedReader br = new BufferedReader(new FileReader(path));
			try {
				while ((line = br.readLine()) != null) {
				    content.append(line);
				    content.append(System.lineSeparator());
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		} catch (FileNotFoundException e) {
			System.out.println("layer 8 problem detected... Shuting down...!");
			e.printStackTrace();
		}
		return content;
		
	}
	// Hier musst du noch den inhalt der file übergeben, und das erstellte Pattern der Main Methode 
	public static String regexMagic(String input, int pattern) {
		Pattern p1 = Pattern.compile("u", Pattern.CASE_INSENSITIVE);
		Matcher m1 = p1.matcher("Berufsschule"); 
		String s1 = m1.replaceAll("a"); 
		Pattern p2 = Pattern.compile("[0-9][^0-9]*"); 
		Matcher m2 = p2.matcher("8tung, ein Text"); 
		boolean b2 = m2.matches();
		Pattern p3 = Pattern.compile("\\b\\S*a\\S*\\b");
		Matcher m3 = p3.matcher("Peter Paul Mary");
		while(m3.find())
		{
		 System.out.println(m3.group());
		}
		return "";

	}

}
