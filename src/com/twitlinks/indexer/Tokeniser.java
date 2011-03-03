package com.twitlinks.indexer;

import com.twitlinks.Document;

public class Tokeniser extends Thread{

	@Override
	public void run(){
		while(true){
			if(Buffer.documentQueue.peek() != null){
//				Document document = Buffer.documentQueue.poll();
				
//				String text = document.getText();
//				tokens = tokenize string;
//				document.setTokens(tokens)
//				Buffer.normalisedQueue.offer(document);
				
			}
			
			
		}
	}
}
