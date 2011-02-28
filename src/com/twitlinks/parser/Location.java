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

/**
 * @version 1.0
 */
public class Location {
	
	//Should it be stored as radian? Better for performing distance calculations
	private double latitude;
	private double longitude;
	
	public Location(double latitude, double longitude){
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	/**
	 * @return latitude
	 */
	public double getLatitude(){
		return latitude;
	}
	
	/**
	 * @return longitude
	 */
	public double getLongitude(){
		return longitude;
	}
	
	@Override
	public String toString(){
		return "{" + getLatitude() + "," + getLongitude() + "}";
	}
}
