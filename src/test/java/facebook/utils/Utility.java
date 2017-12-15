package facebook.utils;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.serenitybdd.core.pages.WebElementFacade;

import org.apache.commons.lang3.StringUtils;

	public final class  Utility {

//		Wait method which will wait in Seconds as Param - This method is only for troubleshoot purpose
		public void waitInSeconds(int timeToWaitInSec) {
			try {
				Thread.sleep(timeToWaitInSec * 1000);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
		public String clickOnElemenByTextfromListElements(List<WebElementFacade> webelements, String Text) {
			String value = null;

			List<WebElementFacade> links = webelements;           
			for(int i=0;i<links.size();i++){

				if(links.get(i).getText().trim().equals(Text)) {
					value = links.get(i).getText().trim();
					links.get(i).click();
					break;
				}
			}
			
			return value;
		}
		
//		This function will return True if the String contains items
//		How to use it?
//		boolean value = stringContainsItemFromList(fld_Locator, {"word1", "word2", "word3"});
		
		public boolean stringContainsItemFromList(WebElementFacade WebElement, String[] items)
		{
			String inputStr = WebElement.getText();
		    for(int i = 0; i < items.length; i++)
		    {
		        if(!inputStr.contains(items[i].trim()))
		        {
		            return false;
		        }
		    }
		    return true;
		}
		
		public String convertArrayToString(String[] items) {
			StringBuilder resultStr = new StringBuilder();
			for (int i = 0; i < items.length; i++) {
			   if (i > 0) {
			      resultStr.append(" ");
			    }
			   resultStr.append(items[i]);
			}
			return StringUtils.join(resultStr).replace(" ", " ,");
		}
		
		public static String getCurrentDate() {
	        LocalDate date = LocalDate.now();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyy");
	        String text = date.format(formatter);
	        return text;

	    }
		
		public static String getCurrentDate(String format) {
	        LocalDate date = LocalDate.now();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
	        String text = date.format(formatter);
	        return text;

	    }
	    
	    public static String getCurrentTime() {
	        LocalDate date = LocalDate.now();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyy");
	        String text = date.format(formatter);
	        return text;

	    }
	    
	    public void printInfo(String message) {
	    	System.out.println("***********"+ message  + "***********");
	    	
	    }
	    
		public static int rand(int max) {
			Random r = new Random();
			return r.nextInt(max);
		}
		
	    
		public static String rand_numstr(int len) {
			StringBuilder str = new StringBuilder();
			for (int i = 0; i < len; i++) str.append(rand(10));
			return str.toString();
		}   
		
		private static String OS = System.getProperty("os.name").toLowerCase();
		public static boolean is_windows() { return OS.indexOf("win") >= 0; } 
		public static boolean is_unix() { return OS.indexOf("nux") >= 0; }

		//the biggest invention in Java-world since sliced-bread ;)
		public static <ARG> void say(ARG arg) { System.out.println(arg); }
		
		public static boolean match(String re, String str) {
			Pattern pat = Pattern.compile(re);
			Matcher m = pat.matcher(str);
			if (m.find()) return true;
				return false;
		}

		public static String match(String re, String str, int idx) {
			Pattern pat = Pattern.compile(re);
			Matcher m = pat.matcher(str);
			if (m.find()) return m.group(idx);
				return "";
		}
		
		public static String replace(String re, String str, String repl) {
			Pattern pat = Pattern.compile(re);
			Matcher m = pat.matcher(str);
			return m.replaceAll(repl);
		}
		
		
		//joins Iterable or Collection into a String
		public static <T> String join(String delimiter, Iterable<T> lst) {
			StringBuilder str = new StringBuilder();
			Iterator<T> it = lst.iterator();
			while ( it.hasNext() ) {
				str.append(it.next().toString());
				if (it.hasNext()) str.append(delimiter);
			}
			return str.toString();
		}
		
		//for Classes check if the value is SCALAR
		public static boolean is_scalar(Object var) {
		    if( (var instanceof Number) || (var instanceof String) || (var instanceof Boolean)) return true;
		    return false;
		}
//		
//		public static HashMap<Integer, ?> list2map(List lst) {
//			HashMap map = new HashMap();
//			for (int i=0; i < lst.size(); i++) {
//				map.put(i, lst.get(i));
//			}
//			return map;
//		}	
//		
//		public static String dump(List lst, String... offset) {
//			return dump(list2map(lst), offset);
//		}
//		
//		// Pretty print a LoL structure, for debugging purposes
//		public static String dump(Map m, String... offset) {
//			if (m == null) return "";
//		    StringBuilder rv = new StringBuilder();
//		    String delta = offset.length == 0 ? "" : offset[0];
//		    for( Entry e : (Set<Map.Entry>) m.entrySet() ) {
//		        rv.append( delta + e.getKey() + " : " );
//		        Object value = e.getValue();
//		        if( value instanceof Map ) rv.append( ">\n" + dump((Map) value, delta + "  ") ); 
//		        if( value instanceof Collection ) rv.append( "[" + join(",", (Collection) value) + "]\n" );
//		        if( is_scalar(value) ) rv.append( value +"\n" );
//		    } 
//		    return rv.toString();
//		} 
		
		public static String word_wrap(String str, int width, String ... args) {
			if (str == null) return null;
			String wrap_str = args.length > 0 ? args[0] : "\n";
			StringBuilder sb = new StringBuilder();
			for (int i=0; i <= str.length()/width; i ++) {
				int start = i * width;
				int end = (i+1) * width;
				end = end > str.length() ? str.length() : end;
				sb.append(str.substring(start, end) + wrap_str); 
			}
			return sb.toString();
		}	
		


		public static String rand_string(String characters, int len) {
			Random rng = new Random();
		    char[] text = new char[len];
		    for (int i = 0; i < len; i++) {
		        text[i] = characters.charAt(rng.nextInt(characters.length()));
		    }
		    return new String(text);
		}
		
		public static String rand_string(int len) {
			return rand_string("ABCDEFGHIJKLMNOPQRSTUVWXYZ",len);
		}
		
		public static String pad_left(String str, int n) { return String.format("%1$" + n + "s", str); }
		public static String pad_right(String str, int n) { return String.format("%1$-" + n + "s", str); }	
		public static String spaces(int cnt) { return (cnt == 0) ? "" : String.format("%"+ cnt +"s", ""); }



}
