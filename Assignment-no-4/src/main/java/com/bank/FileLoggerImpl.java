package com.bank;

import java.io.FileOutputStream;
import java.io.PrintStream;

import com.example.demo.AssignmentNo4Application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class FileLoggerImpl implements Logger{
	
	@Value("${logFilePath}")
	private String logFilePath;
	
	public FileLoggerImpl() {
		this.logFilePath = "mylog.txt";
	}
	
	public String getLogFilePath() {
		return logFilePath;
		
	}
	
	public void setLogFilePath(String logFilePath) {
		this.logFilePath = logFilePath;
	}
	
	
	
	@Override
	public void log(String message) {
		System.out.println("File : " + message);
		try(FileOutputStream fout = new FileOutputStream(logFilePath,true)){
			try(PrintStream pout = new PrintStream(fout)){
				pout.print(message);
			}
		}
		 catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
