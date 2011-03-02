package com.twitlinks;

import java.text.ParseException;

import com.twitlinks.parser.Parser;

public class Main {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		new Parser().start();
		new Consumer().start();
	}
}
