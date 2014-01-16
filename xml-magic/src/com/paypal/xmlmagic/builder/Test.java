package com.paypal.xmlmagic.builder;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Properties;

import com.jamesmurty.utils.XMLBuilder;

public class Test {
	
	Properties outputProperties;
	
	public static void main(String[] args) {
		try{
			System.out.println("Started");
			Test test = new Test();
			test.buildXML();
			test.writeXML();
			System.out.println("Ended");
		} catch(Exception ex){
			System.out.println("Exception caught");
		}
		
	}

	public void buildXML() throws Exception{
		XMLBuilder builder = XMLBuilder.create("Projects")
				.e("java-xmlbuilder").a("language", "Java").a("scm", "SVN")
					.e("Location").a("type", "URL")
						.t("http://code.google.com/p/java-xmlbuilder")
					.up()
				.up()
				.e("JetS3t").a("language", "Java").a("scm", "CVS")
					.e("Location").a("type", "URL")
					.t("http://jets3t.s3.com/index.html");
		builder.asString(outputProperties);
	}

	public void writeXML() throws Exception{
		
//		OutputStreamWriter writer = new OutputStreamWriter(new )
		
		PrintStream stream = new PrintStream(new ByteArrayOutputStream());
		System.out.print(outputProperties.toString());
//		stream.flush();
		
	}
	
}
