/* 
 * Copyright (c) 2011 Twitlinks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package com.twitlinks.parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author raunak
 * @version 1.0
 */
public class Parser extends Thread {

	/** Current thread sleep time */
	private static int WAIT = 1000;

	/** Minimum length a thread can go to sleep for. 1 second */
	private static final int MINWAIT = 1000; // 1 SECOND

	/** Maximum length a thread can go to sleep for. 15 Minutes */
	private static final int MAXWAIT = 900000;

	/**
	 * Holds a list of <code>Document</code> objects in a queue. The crawler can
	 * pull approximately 120 tweets/second.
	 */
	public static BlockingQueue<Document> documents = new ArrayBlockingQueue<Document>(
			300);

	/**
	 * A specialized pattern to parse date with the format
	 * "Wed Feb 16 13:57:26 GMT 2011"
	 */
	private static DateFormat formatter = new SimpleDateFormat(
			"EEE, d MMM yyyy HH:mm:ss Z");

	/**
	 * Creates a <code>Document</code> object from a given input.
	 * 
	 * @param input
	 *            A <code>String</code> representation of the document.
	 * @return A <code>Document</code> object.
	 * 
	 * @throws ParseException
	 */
	private Document createDocument(String input) throws ParseException {
		String[] tokens = input.split("\t");
		return new Document(tokens[1], formatter.parse(tokens[2]), tokens[5],
				tokens[6], tokens[7]);
	}

	public void run() {
		String line = null;
		boolean success = false;
		BufferedReader bufferedReader = null;

		// TODO: Connect it to crawler
		try {
			bufferedReader = new BufferedReader(new FileReader(
					"dataset_10k.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		while (true) {

			try {
				while ((line = bufferedReader.readLine()) != null) {
					try {
						success = documents.offer(createDocument(line));
						if (!success) { // Blocking Queue is full. Increase the
										// waiting time.
							try {
								if (Parser.WAIT < Parser.MAXWAIT) {
									Parser.WAIT = Parser.WAIT * 2;
								}
								Thread.sleep(WAIT);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						} else if (Parser.WAIT > Parser.MINWAIT) {
							Parser.WAIT = Parser.WAIT - Parser.MINWAIT;
						}
					} catch (ParseException pe) {
						pe.printStackTrace();
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
