/*
 * Copyright 2016 MasterCard International.
 *
 * Redistribution and use in source and binary forms, with or without modification, are 
 * permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list of 
 * conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, this list of 
 * conditions and the following disclaimer in the documentation and/or other materials 
 * provided with the distribution.
 * Neither the name of the MasterCard International Incorporated nor the names of its 
 * contributors may be used to endorse or promote products derived from this software 
 * without specific prior written permission.
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY 
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES 
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT 
 * SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, 
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED
 * TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; 
 * OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER 
 * IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING 
 * IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF 
 * SUCH DAMAGE.
 *
 */

package com.mastercard.api.qkr;

import com.mastercard.api.core.exception.*;
import com.mastercard.api.core.model.*;
import com.mastercard.api.core.security.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Merchant extends BaseObject  {

	private static Map<String, OperationConfig> operationConfigs;

	static {
		operationConfigs = new HashMap<String, OperationConfig>();
		operationConfigs.put("72a40054-fffb-46d5-9200-1d7d04d10876", new OperationConfig("/labs/proxy/qkr2/internal/api2/merchant", Action.query, Arrays.asList("latitude","longitude","queryString"), Arrays.asList("")));
		operationConfigs.put("d50a0f2d-3990-4d5c-a42f-2156e2930d29", new OperationConfig("/labs/proxy/qkr2/internal/api2/merchant/{id}", Action.read, Arrays.asList(""), Arrays.asList("")));
	}

	public Merchant() {
	}

	public Merchant(BaseObject o) {
		putAll(o);
	}

	public Merchant(RequestMap requestMap) {
		putAll(requestMap);
	}

	@Override protected final OperationConfig getOperationConfig(String operationUUID) throws IllegalArgumentException{
		OperationConfig operationConfig = operationConfigs.get(operationUUID);

		if(operationConfig == null) {
			throw new IllegalArgumentException("Invalid operationUUID supplied: " + operationUUID);
		}

		return operationConfig;
	}

	@Override protected OperationMetadata getOperationMetadata() throws IllegalArgumentException {
		return new OperationMetadata(ResourceConfig.getInstance().getVersion(), ResourceConfig.getInstance().getHost(),
			ResourceConfig.getInstance().getContext(), ResourceConfig.getInstance().getJsonNative());
	}






	/**
	 * Query / Retrieve a <code>Merchant</code> object
	 *
	 * @param       query a map of query parameters
	 *
	 * @return      a Merchant object
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public static Merchant query(RequestMap query)
		throws ApiException {

		return query(null, query);
	}

	/**
	 * Query / Retrieve a <code>Merchant</code> object
	 *
	 * @param       auth Authentication object overriding <code>ApiConfig.setAuthentication(authentication)</code>
	 * @param       query a map of query parameters
	 *
	 * @return      a Merchant object
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public static Merchant query(Authentication auth, RequestMap query)
		throws ApiException {

		Merchant val = new Merchant();
		if (query != null)  val.putAll(query);
		return new Merchant(BaseObject.executeOperation(auth, "72a40054-fffb-46d5-9200-1d7d04d10876", val));
	}




	/**
	 * Retrieve a <code>Merchant</code> object
	 *
	 * @param       id the id of the <code>Merchant</code> object to retrieve
	 *
	 * @return      a Merchant object
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public static Merchant read(String id)
		throws ApiException {

		return read(null, id, null);
	}

	/**
	 * Retrieve a <code>Merchant</code> object
	 *
	 * @param       id the id of the <code>Merchant</code> object to retrieve
	 * @param       map a map of additional parameters
	 *
	 * @return      a Merchant object
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public static Merchant read(String id, RequestMap map)
		throws ApiException {

		return read(null, id, map);
	}

	/**
	 * Retrieve a <code>Merchant</code> object
	 *
	 * @param       auth Authentication object overriding <code>ApiConfig.setAuthentication(authentication)</code>
	 * @param       id the id of the <code>Merchant</code> object to retrieve
	 *
	 * @return      a Merchant object
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public static Merchant read(Authentication auth, String id)
		throws ApiException {

		return read(auth, id, null);
	}

	/**
	 * Retrieve a <code>Merchant</code> object
	 *
	 * @param       auth Authentication object overriding <code>ApiConfig.setAuthentication(authentication)</code>
	 * @param       id the id of the <code>Merchant</code> object to retrieve
	 * @param       map a map of additional parameters
	 *
	 * @return      a Merchant object
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public static Merchant read(Authentication auth, String id, RequestMap map)
		throws ApiException {

		Merchant val = new Merchant();
		if (id != null) val.put("id", id);
		if (map != null)  val.putAll(map);
		return new Merchant(BaseObject.executeOperation(auth, "d50a0f2d-3990-4d5c-a42f-2156e2930d29", val));
	}

}


