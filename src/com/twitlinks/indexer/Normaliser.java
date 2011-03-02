package com.twitlinks.indexer;

import com.twitlinks.Document;

public class Normaliser extends Thread{

	@Override
	public void run(){
		while(true){
			if(Buffer.tokenisedQueue.peek() != null){
				Document document = Buffer.tokenisedQueue.poll();
				
//				String[] tokens = document.getTokens();
//				tokens = normalise tokens;
//				document.setTokens(tokens)
//				Buffer.normalisedQueue.offer(document);
				
			}
			
			
		}
	}
}
