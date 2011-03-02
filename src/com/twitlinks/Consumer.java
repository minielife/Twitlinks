package com.twitlinks;

import com.twitlinks.indexer.Buffer;

public class Consumer extends Thread{
	@Override
	public void run(){
		while(true){
			System.out.println(Buffer.documentQueue.size());
			if(Buffer.documentQueue.peek() != null){
				System.out.println(Buffer.documentQueue.poll().toString());
				Buffer.documentQueue.poll();
			} else {
				
			}
			try {
				Thread.sleep(10); //Time taken to process tokenisation? 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
