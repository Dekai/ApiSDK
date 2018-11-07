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

public class Trans extends BaseObject  {

	private static Map<String, OperationConfig> operationConfigs;

	static {
		operationConfigs = new HashMap<String, OperationConfig>();
		operationConfigs.put("7371f682-3855-42bc-ba91-782c68607a1b", new OperationConfig("/labs/proxy/qkr2/internal/api2/trans", Action.create, Arrays.asList(""), Arrays.asList("X-Auth-Token")));
		operationConfigs.put("88af88d2-a737-4c86-b65b-38509fc8b566", new OperationConfig("/labs/proxy/qkr2/internal/api2/trans", Action.query, Arrays.asList("from","to"), Arrays.asList("X-Auth-Token")));
		operationConfigs.put("eb7bd15a-4619-4ba3-bd7f-f506f3435023", new OperationConfig("/labs/proxy/qkr2/internal/api2/trans/{id}", Action.read, Arrays.asList(""), Arrays.asList("X-Auth-Token")));
		operationConfigs.put("a14632ae-0743-4839-81bd-7260a7b52333", new OperationConfig("/labs/proxy/qkr2/internal/api2/trans/{id}", Action.update, Arrays.asList(""), Arrays.asList("X-Auth-Token")));
	}

	public Trans() {
	}

	public Trans(BaseObject o) {
		putAll(o);
	}

	public Trans(RequestMap requestMap) {
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
	 * Creates a <code>Trans</code> object
	 *
	 * @param       map a map of parameters to create a <code>Trans</code> object
	 *
	 * @return      a Trans object.
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public static Trans create(RequestMap map)
		throws ApiException {

		return create(null, map);
	}

	/**
	 * Creates a <code>Trans</code> object
	 *
	 * @param       auth Authentication object overriding <code>ApiConfig.setAuthentication(authentication)</code>
	 * @param       map a map of parameters to create a <code>Trans</code> object
	 *
	 * @return      a Trans object.
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public static Trans create(Authentication auth, RequestMap map)
		throws ApiException {

		return new Trans(BaseObject.executeOperation(auth, "7371f682-3855-42bc-ba91-782c68607a1b", new Trans(map)));
	}











	/**
	 * Query / Retrieve a <code>Trans</code> object
	 *
	 * @param       query a map of query parameters
	 *
	 * @return      a Trans object
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public static Trans query(RequestMap query)
		throws ApiException {

		return query(null, query);
	}

	/**
	 * Query / Retrieve a <code>Trans</code> object
	 *
	 * @param       auth Authentication object overriding <code>ApiConfig.setAuthentication(authentication)</code>
	 * @param       query a map of query parameters
	 *
	 * @return      a Trans object
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public static Trans query(Authentication auth, RequestMap query)
		throws ApiException {

		Trans val = new Trans();
		if (query != null)  val.putAll(query);
		return new Trans(BaseObject.executeOperation(auth, "88af88d2-a737-4c86-b65b-38509fc8b566", val));
	}




	/**
	 * Retrieve a <code>Trans</code> object
	 *
	 * @param       id the id of the <code>Trans</code> object to retrieve
	 *
	 * @return      a Trans object
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public static Trans read(String id)
		throws ApiException {

		return read(null, id, null);
	}

	/**
	 * Retrieve a <code>Trans</code> object
	 *
	 * @param       id the id of the <code>Trans</code> object to retrieve
	 * @param       map a map of additional parameters
	 *
	 * @return      a Trans object
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public static Trans read(String id, RequestMap map)
		throws ApiException {

		return read(null, id, map);
	}

	/**
	 * Retrieve a <code>Trans</code> object
	 *
	 * @param       auth Authentication object overriding <code>ApiConfig.setAuthentication(authentication)</code>
	 * @param       id the id of the <code>Trans</code> object to retrieve
	 *
	 * @return      a Trans object
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public static Trans read(Authentication auth, String id)
		throws ApiException {

		return read(auth, id, null);
	}

	/**
	 * Retrieve a <code>Trans</code> object
	 *
	 * @param       auth Authentication object overriding <code>ApiConfig.setAuthentication(authentication)</code>
	 * @param       id the id of the <code>Trans</code> object to retrieve
	 * @param       map a map of additional parameters
	 *
	 * @return      a Trans object
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public static Trans read(Authentication auth, String id, RequestMap map)
		throws ApiException {

		Trans val = new Trans();
		if (id != null) val.put("id", id);
		if (map != null)  val.putAll(map);
		return new Trans(BaseObject.executeOperation(auth, "eb7bd15a-4619-4ba3-bd7f-f506f3435023", val));
	}


	/**
	 * Update a <code>Trans</code> object.
	 *
	 * @return      a Trans object.
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public Trans update()
		throws ApiException {

		BaseObject object = BaseObject.executeOperation(null, "a14632ae-0743-4839-81bd-7260a7b52333", this);
		this.putAll(object);
		return this;
	}

	/**
	 * Update a <code>Trans</code> object.
	 *
	 * @param       auth Authentication object overriding <code>ApiConfig.setAuthentication(authentication)</code>
	 *
	 * @return      a Trans object.
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public Trans update(Authentication auth)
		throws ApiException {

		BaseObject object = BaseObject.executeOperation(auth, "a14632ae-0743-4839-81bd-7260a7b52333", this);
		this.putAll(object);
		return this;
	}




}


