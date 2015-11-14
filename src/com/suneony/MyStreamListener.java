package com.suneony;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.DatabaseMetaData;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale.Category;
import java.util.zip.GZIPOutputStream;

import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;

import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;

public class MyStreamListener implements StatusListener{
	private String lastDateString=null;
	private GZIPOutputStream gzipOutputStream=null;
	private String savePath=null;
	private BufferedWriter fileNameWriter=null;
	public MyStreamListener(){
		lastDateString="";
		savePath=".\\";
	}
	public MyStreamListener(String savePath){
		lastDateString="";
		this.savePath=savePath;
	}
	
	private int count=0;
	public void onException(Exception exception) {
		
	}

	public void onDeletionNotice(StatusDeletionNotice notice) {
		
	}

	public void onScrubGeo(long arg0, long arg1) {
		
	}

	public void onStallWarning(StallWarning warning) {
		
	}

	public void onStatus(Status status) {
		String currentDateString=(new SimpleDateFormat("yyyy-MM-dd-HH")).format(status.getCreatedAt());
		if(!lastDateString.equals(currentDateString)){
			try {
				if(this.gzipOutputStream!=null){
					this.gzipOutputStream.flush();
					this.gzipOutputStream.close();
					fileNameWriter=new BufferedWriter(new FileWriter(new File("./transmission.txt")));
					fileNameWriter.write("statuses."+lastDateString+".zip");
					fileNameWriter.flush();
					fileNameWriter.close();
				}
				lastDateString=currentDateString;
				System.out.println(this.savePath+"statuses."+currentDateString+".zip");
				this.gzipOutputStream=new GZIPOutputStream(new BufferedOutputStream(new FileOutputStream(this.savePath+"statuses."+currentDateString+".zip",true)));
				this.gzipOutputStream.write(status.toString().getBytes());
				this.gzipOutputStream.write("\r\n".getBytes());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}else{
			try {
				this.gzipOutputStream.write(status.toString().getBytes());
				this.gzipOutputStream.write("\r\n".getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	public void onTrackLimitationNotice(int arg) {
		
	}
	
}
