package kasnplugin.views;

import java.io.IOException;

public class OpenExplorer {
	
	public void openExp(String loc){
		Runtime runt  = Runtime.getRuntime();
		try {
			runt.exec("explorer"+" "+loc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
