package com.twitlinks.indexer;

import com.twitlinks.Document;

public class Stemmer extends Thread{

	@Override
	public void run(){
		while(true){
			if(Buffer.normalisedQueue.peek() != null){
				Document document = Buffer.normalisedQueue.poll();
				
//				String text = document.getText();
//				tokens = stem tokens;
//				document.setTokens(tokens)
//				Buffer.stemmingQueue.offer(document);
				
			}
			
			
		}
	}
}
