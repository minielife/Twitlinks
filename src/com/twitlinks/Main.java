package com.twitlinks;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.twitlinks.parser.Document;
import com.twitlinks.parser.Location;

public class Main {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		String str = "Wed, 16 Feb 2011 13:57:14 +0000";
		DateFormat formatter = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
		Date date = (Date)formatter.parse(str);
		
		Location loc = new Location(4.24353, 5.353069);
		
		Document d = new Document("this is a test tweet", date, loc, "raunak", 593857398, 938573);
		System.out.println(d);
	}
}
