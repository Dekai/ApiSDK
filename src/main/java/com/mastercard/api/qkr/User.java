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

public class User extends BaseObject  {

	private static Map<String, OperationConfig> operationConfigs;

	static {
		operationConfigs = new HashMap<String, OperationConfig>();
		operationConfigs.put("2b19e925-87d8-4bee-9d0a-76f14b9bd348", new OperationConfig("/labs/proxy/qkr2/internal/api2/user", Action.create, Arrays.asList(""), Arrays.asList("X-Auth-Token")));
		operationConfigs.put("d86ef8a7-a655-42ae-ac40-0e4c23a16a74", new OperationConfig("/labs/proxy/qkr2/internal/api2/user", Action.query, Arrays.asList(""), Arrays.asList("X-Auth-Token")));
		operationConfigs.put("14e52990-b041-4446-8f16-0e6a561db655", new OperationConfig("/labs/proxy/qkr2/internal/api2/user", Action.update, Arrays.asList(""), Arrays.asList("X-Auth-Token")));
	}

	public User() {
	}

	public User(BaseObject o) {
		putAll(o);
	}

	public User(RequestMap requestMap) {
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
	 * Creates a <code>User</code> object
	 *
	 * @param       map a map of parameters to create a <code>User</code> object
	 *
	 * @return      a User object.
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public static User create(RequestMap map)
		throws ApiException {

		return create(null, map);
	}

	/**
	 * Creates a <code>User</code> object
	 *
	 * @param       auth Authentication object overriding <code>ApiConfig.setAuthentication(authentication)</code>
	 * @param       map a map of parameters to create a <code>User</code> object
	 *
	 * @return      a User object.
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public static User create(Authentication auth, RequestMap map)
		throws ApiException {

		return new User(BaseObject.executeOperation(auth, "2b19e925-87d8-4bee-9d0a-76f14b9bd348", new User(map)));
	}











	/**
	 * Query / Retrieve a <code>User</code> object
	 *
	 * @param       query a map of query parameters
	 *
	 * @return      a User object
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public static User query(RequestMap query)
		throws ApiException {

		return query(null, query);
	}

	/**
	 * Query / Retrieve a <code>User</code> object
	 *
	 * @param       auth Authentication object overriding <code>ApiConfig.setAuthentication(authentication)</code>
	 * @param       query a map of query parameters
	 *
	 * @return      a User object
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public static User query(Authentication auth, RequestMap query)
		throws ApiException {

		User val = new User();
		if (query != null)  val.putAll(query);
		return new User(BaseObject.executeOperation(auth, "d86ef8a7-a655-42ae-ac40-0e4c23a16a74", val));
	}

	/**
	 * Update a <code>User</code> object.
	 *
	 * @return      a User object.
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public User update()
		throws ApiException {

		BaseObject object = BaseObject.executeOperation(null, "14e52990-b041-4446-8f16-0e6a561db655", this);
		this.putAll(object);
		return this;
	}

	/**
	 * Update a <code>User</code> object.
	 *
	 * @param       auth Authentication object overriding <code>ApiConfig.setAuthentication(authentication)</code>
	 *
	 * @return      a User object.
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public User update(Authentication auth)
		throws ApiException {

		BaseObject object = BaseObject.executeOperation(auth, "14e52990-b041-4446-8f16-0e6a561db655", this);
		this.putAll(object);
		return this;
	}




}


