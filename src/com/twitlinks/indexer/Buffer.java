package com.twitlinks.indexer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import com.twitlinks.Document;

public class Buffer {
	/**
	 * A list of unprocessed <code>Document</code> objects in a queue.
	 */
	public static BlockingQueue<Document> documentQueue = new ArrayBlockingQueue<Document>(
			300);

	/**
	 * A list of tokenised <code>Document</code> object in a queue.
	 */
	public static BlockingQueue<Document> tokenisedQueue = new ArrayBlockingQueue<Document>(
			300);

	/**
	 * A list of normalised <code>Document</code> object in a queue.
	 */
	public static BlockingQueue<Document> normalisedQueue = new ArrayBlockingQueue<Document>(
			300);

	/**
	 * A list of <code>Document</code> object without stop words in a queue.
	 */
	public static BlockingQueue<Document> stopWordQueue = new ArrayBlockingQueue<Document>(
			300);

	/**
	 * A list of <code>Document</code> object with stemmed tokens in a queue.
	 */
	public static BlockingQueue<Document> stemmingQueue = new ArrayBlockingQueue<Document>(
			300);
}
