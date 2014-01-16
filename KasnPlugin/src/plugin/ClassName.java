package plugin;

import java.util.ArrayList;
import java.util.Iterator;

public class ClassName {
	public String classFile;
	public String zipFile;
	public String path;
	
	public ClassName(String cFile, String zFile, String location)
	{
		classFile = cFile;
		zipFile = zFile;
		path = location;
	}
	
	public String toString(){
		return classFile+";"+zipFile+";"+path;
	}
}

