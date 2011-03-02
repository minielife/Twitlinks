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
import java.util.UUID;

/**
 * @author raunak
 * @version 1.0
 */
public class Document {

	/** Unique ID for document */
	private String uuid;

	/** a tweet */
	private String text;

	/** time at which the tweet was generated */
	private Date creationTime;

	/** a user who generated the tweet */
	private String source;

	/** user's id */
	private String sourceId;

	/** id of user to whom a tweet was directed at */
	private String destinationId;

	/**
	 * Constructs a <code>Document</code> using the passed parameters.
	 * <strong>Note:</strong> Each document gets assigned a unique identifier
	 * upon creation.
	 * 
	 * @param text
	 *            - a tweet message
	 * @param creationTime
	 *            - time at which the tweet was generated
	 * @param source
	 *            - name of user who generated the tweet
	 * @param sourceId
	 *            - id of user who generated the tweet
	 * @param destinationId
	 *            - id of user to whom a tweet was directed at
	 */
	public Document(String text, Date creationTime, String source,
			String sourceId, String destinationId) {
		this.uuid = UUID.randomUUID().toString();
		this.text = text;
		this.creationTime = creationTime;
		this.source = source;
		this.sourceId = sourceId;
		this.destinationId = destinationId;
	}

	/**
	 * Get the unique Id
	 * 
	 * @return <code>String</code> uuid.
	 */
	public String getUUID() {
		return uuid;
	}

	/**
	 * Gets the text in a tweet
	 * 
	 * @return tweet text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Gets the creation time of a tweet
	 * 
	 * @return <code>Date</code> object.
	 */
	public Date getCreationTime() {
		return creationTime;
	}

	/**
	 * Gets the user name of the person who generated the tweet
	 * 
	 * @return <code>String</code> object - a username
	 */
	public String getSouce() {
		return source;
	}

	/**
	 * Gets the user id of the person who generated the tweet
	 * 
	 * @return user id
	 */
	public String getSourceId() {
		return sourceId;
	}

	/**
	 * Gets the user name of the person to whom the tweet was directed at
	 * 
	 * @return user id
	 */
	public String getDestinationId() {
		return destinationId;
	}

	@Override
	public String toString() {
		return "doc id: " + getUUID() + "\n" + "text: " + getText() + "\n"
				+ "creation time: " + getCreationTime() + "\n" + "source :"
				+ getSouce() + "\n" + "source id: " + getSourceId() + "\n"
				+ "destination id: " + getDestinationId();
	}
}
