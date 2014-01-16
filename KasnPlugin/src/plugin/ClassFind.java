package plugin;

import java.io.*;
import java.util.jar.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Display;


public class ClassFind {
	
	protected String dir, className;
//	private ArrayList<ClassName> contents;
	private TableViewer viewer;
	
	
	public ClassFind(){
			
	}
	
	public void setDir(String dir){
		
		this.dir = dir;
	}
	
	public void setClassName(String str){
		className = str;
	}
	
	private void setContents(ClassName str){
		
		final ClassName st = str;
		
		Display.getDefault().asyncExec(new Runnable(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try{
					viewer.add(st);
				}
				catch(Exception e){
					
				}
			}
		});
		
		
	}
	
	public void setViewer(TableViewer tv){
		viewer = tv;
	}
	
//	private ArrayList<ClassName> getContents(){
//		return contents;
//	}
		
	public void visitDir() {
		// TODO Auto-generated method stub
//		contents = new ArrayList<ClassName>();
		File file = new File(dir);
		visitAllDirsAndFiles(file, className);
//		return getContents();
		
	}

	private String[] fileFilter(String filters, File dir){
		Filter nf = new Filter(filters);
		return dir.list(nf);
	}
	
	
	private void visitAllDirsAndFiles(File dir , String className) {
		if (dir.isDirectory()) {    
//			System.out.println(dir.toString());
			String[] jarFiles = fileFilter("jar", dir);
			ClassName content;
			if(jarFiles.length!=0)
				for(int i=0; i<jarFiles.length; i++){
					content = null;
					content = findClass(dir , jarFiles[i] , className);
					if(content!=null)
						setContents(content);
				}
			
			String[] zipFiles = fileFilter("zip" , dir);
			if(zipFiles.length!=0)
				for(int i=0; i<zipFiles.length; i++){
					content = null;
					content = findClass(dir , zipFiles[i] , className);
					if(content!=null)
						setContents(content);
				}	
		
	        String[] children = dir.list();
	        for (int i=0; i<children.length; i++) {
	                visitAllDirsAndFiles(new File(dir, children[i]) , className);
	        }
	    }
		 
	 }
	
	

	private ClassName findClass(File dir , String fileName , String className) {

		File destDir = new File(dir , fileName);
		ClassName fileInfo= null;
		String temp = null;
		String temp1 = null;
		try {
			JarFile jarFile = new JarFile(destDir);

			Enumeration<JarEntry> e=jarFile.entries();

			while(e.hasMoreElements()){
				temp = e.nextElement().toString();
				temp1 = temp.substring(temp.lastIndexOf('/')+1); 
				if(temp1.contentEquals(className)){
					fileInfo = new ClassName(temp,fileName,dir.toString());
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		} 
		return fileInfo;
	}
	
	
	
	
	
}

