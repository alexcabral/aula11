package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	
	/**
	 * Converte String para java.util.Date retornando a data em formato dd/MM/yyyy
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static Date StrToDate(String data) throws Exception {
		
		if (data == null || data.equals(""))
			return null;
        Date date = null;
        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            date = (java.util.Date)formatter.parse(data);
        } catch (ParseException e) {            
            throw e;
        }
        return date;
	}
	
	
	/**
	 * Converte String para java.sql.Date
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static java.sql.Date StrToSQLDate(String data) throws Exception{
		if (data == null || data.equals(""))
			return null;
		
		java.sql.Date sqlDate;
		try {
			sqlDate=new java.sql.Date(DateUtil.StrToDate(data).getTime());
		} catch (Exception e){
			throw e;
		}
		
		return sqlDate;
	}
	
	public static java.sql.Date dateToSqlDate(Date data) throws Exception {
		if (data == null)
			return null;
		
		java.sql.Date sqlDate;
		try {
			sqlDate=new java.sql.Date(data.getTime());
		} catch (Exception e){
			throw e;
		}
		
		return sqlDate;
	}
	

}
