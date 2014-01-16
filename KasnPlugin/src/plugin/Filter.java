package plugin;

import java.io.File;
import java.io.FilenameFilter;

public class Filter implements FilenameFilter {
  
	protected String pattern;
	
	public Filter (String str) {
		
		pattern = str;
		
	}
  
	public boolean accept (File dir, String name) {
    
		return name.toLowerCase().endsWith(pattern.toLowerCase());
	  
	}
     
}
