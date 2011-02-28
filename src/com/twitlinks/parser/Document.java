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

import java.util.Date;

/**
 * @version 1.0
 */
public class Document {
	
	/** a tweet */
	private String text;
	
	/** time at which the tweet was generated */
	private Date creationTime; 
	
	/** location where the tweet was generated */
	private Location location; 
	
	/** a user who generated the tweet */
	private String source;
	
	/** user's id*/
	private long sourceId;
	
	/** id of user to whom a tweet was directed at*/
	private long destinationId;

	public Document(String text, Date creationTime, Location location,
			String source, long sourceId, long destinationId) {
		this.text = text;
		this.creationTime = creationTime;
		this.location = location;
		this.source = source;
		this.sourceId = sourceId;
		this.destinationId = destinationId;
	}

	/**
	 * Gets the text in a tweet
	 * @return tweet text
	 */
	public String getText() {
		return text;
	}
	
	/**
	 * Gets the creation time of a tweet
	 * @return <code>Date</code> object.
	 */
	public Date getCreationTime() {
		return creationTime;
	}

	/**
	 * Gets the location at which the tweet was generated
	 * @return <code>Location</code> object
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * Gets the user name of the person who generated the tweet
	 * @return <code>String</code> object - a username
	 */
	public String getSouce() {
		return source;
	}

	/**
	 * Gets the user id of the person who generated the tweet
	 * @return user id
	 */
	public long getSourceId() {
		return sourceId;
	}

	/**
	 * Gets the user name of the person to whom the tweet was directed at
	 * @return user id
	 */
	public long getDestinationId() {
		return destinationId;
	}

	@Override
	public String toString() {
		return "text: " + getText() + "\n"
				+ "creation time: " + getCreationTime() + "\n" + "location: "
				+ getLocation() + "\n" + "source :" + getSouce() + "\n"
				+ "source id: " + getSourceId() + "\n" + "destination id" + getDestinationId();
	}
}
