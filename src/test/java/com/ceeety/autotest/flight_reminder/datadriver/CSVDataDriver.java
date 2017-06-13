package com.ceeety.autotest.flight_reminder.datadriver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.Logger;

import com.ceeety.autotest.flight_reminder.testcases.LoginTest;

public class CSVDataDriver implements Iterator<Object[]> {
	private static Logger logger = Logger.getLogger(CSVDataDriver.class); 
	private BufferedReader br;
	private ArrayList<String> dataList = new ArrayList<String>();
	int row;
	int col;
	int curRowNo;
	String[] columnName;

	public CSVDataDriver(String classname) {
		try {
			int dotNum = classname.indexOf(".");

			if (dotNum > 0) {
				classname = classname.substring(classname.lastIndexOf(".") + 1, classname.length());
			}
			String path = System.getProperty("user.dir") + "\\src\\test\\resources\\data\\" + classname + "Data.csv";
			logger.info("filePath"+path);
			File file = new File(path);
			br = new BufferedReader(new FileReader(file));
			while(br.ready()){
				dataList.add(br.readLine());
				this.row++;
			}
			String[] str=dataList.get(0).split(",");
			col=str.length;
			columnName=new String[col];
			//取列名
			for(int i=0;i<col;i++){
				columnName[i]=str[i];
			}
			curRowNo++;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean hasNext() {
		if(row==0||curRowNo>=row){
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return false;
		}else{
			return true;
		}
		
	}

	public Object[] next() {
		Map<String,String> s=new TreeMap<String,String>();
        String csvCell[]=dataList.get(curRowNo).split(",");
        for(int i=0;i<this.col;i++){
            s.put(columnName[i], csvCell[i]);           
        }
        Object[] d=new Object[1];
        d[0]=s;
        this.curRowNo++;
        return d;
	}
	
    public void remove() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("remove unsupported");
    }

}
