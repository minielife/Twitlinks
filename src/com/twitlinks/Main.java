package com.twitlinks;

import java.text.ParseException;

import com.twitlinks.indexer.Normaliser;
import com.twitlinks.indexer.Tokeniser;
import com.twitlinks.parser.Parser;

public class Main {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		new Parser().start();
		
//		Start two instance of tokeniser
//		new Tokeniser().start();
//		new Tokeniser().start();
		
//		Start two instance of normaliser
//		new Normaliser().start();
//		new Normaliser().start();
		
	}
}
