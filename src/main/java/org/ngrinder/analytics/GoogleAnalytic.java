/* 
 * Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 */
package org.ngrinder.analytics;

import java.util.UUID;

import org.ngrinder.http.MeasureProtocolRequest;


/**
 * This class  for sending data to google analytics 
 *
 * @author maoyb
 */
public class GoogleAnalytic {

	private final static String CLIENT_ID = UUID.randomUUID().toString();

	private MeasureProtocolRequest measureProtocolRequest;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.ngrinder.http.MeasureProtocolRequest#MeasureProtocolRequest()
	 */
	public GoogleAnalytic(String appName, String trackingCode) {
		measureProtocolRequest = new MeasureProtocolRequest(appName, trackingCode, CLIENT_ID);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.ngrinder.http.MeasureProtocolRequest#MeasureProtocolRequest()
	 */
	public GoogleAnalytic(String appName, String appVersion, String trackingCode) {
		measureProtocolRequest = new MeasureProtocolRequest(appName, appVersion, trackingCode, CLIENT_ID);
	}
	
	/**
	 * Send statistic data to Google Analytics
	 * 
	 * @param Name
	 * @param value
	 */
	public boolean sendStaticDataToUA(String name, String value) {
		return measureProtocolRequest.execRequest(name, value);
	}

	/**
	 * Send statistic data to Google Analytics
	 * 
	 * @param Name
	 * @param value
	 */
	public boolean sendStaticDataToUA(String name, Integer value) {
		return measureProtocolRequest.execRequest(name, String.valueOf(value));
	}
	
	public MeasureProtocolRequest getMeasureProtocolRequest() {
		return measureProtocolRequest;
	}

}
