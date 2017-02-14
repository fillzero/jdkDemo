package cn.tk.java.io;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileDeconstructor {

	
	public static String javaConvert(String fileString) throws IOException{
		String regex = "(((public|private|protected)\\s*)?(static\\s*)?(final\\s*)?class\\s+([\\w\\<\\>\\,\\?]+)\\s+(extends\\s+([\\w\\<\\>\\,\\?]+) )?\\s*(implements\\s+(([\\w\\<\\>\\,\\?]+)\\,)?([\\w\\<\\>\\,\\?]+))?)\\s*\\{";
		Pattern realPattern = Pattern.compile(regex, Pattern.DOTALL);
		Matcher matcher = realPattern.matcher(fileString);
		if(matcher.find()){
			String matchString = matcher.group(1);
			StringBuffer matchStringBuffer = new StringBuffer(matchString);
			matchStringBuffer.deleteCharAt(matchStringBuffer.length() - 1);
			String newMatchString = matchString;
			StringBuffer sb = new StringBuffer();
			if(matchString.contains("implements")){
				if(matchString.contains("Serializable")){
					sb.append(fileString);
				}else{
					newMatchString += ",java.io.Serializable {\r\n\t\r\n\tprivate static final long serialVersionUID = 1L;\r\n\t";
					matcher.appendReplacement(sb, newMatchString);
					matcher.appendTail(sb);
				}
			}else{
				newMatchString += " implements java.io.Serializable {\r\n\t\r\n\tprivate static final long serialVersionUID = 1L;\r\n\t";
				matcher.appendReplacement(sb, newMatchString);
				matcher.appendTail(sb);
			}
			return sb.toString();
		}else{
			return fileString;
		}
	}
	
	public static void main(String[] args){

	}
}
