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

public class Card extends BaseObject  {

	private static Map<String, OperationConfig> operationConfigs;

	static {
		operationConfigs = new HashMap<String, OperationConfig>();
		operationConfigs.put("03b649fa-64c8-43a3-8135-0833f927e7f0", new OperationConfig("/labs/proxy/qkr2/internal/api2/card", Action.create, Arrays.asList(""), Arrays.asList("X-Auth-Token")));
		operationConfigs.put("82fc950a-17fd-4fa2-9336-1011a6673515", new OperationConfig("/labs/proxy/qkr2/internal/api2/card/{id}", Action.delete, Arrays.asList(""), Arrays.asList("X-Auth-Token")));
		operationConfigs.put("7763aa29-2d41-4061-90fc-56fc9b338554", new OperationConfig("/labs/proxy/qkr2/internal/api2/card", Action.query, Arrays.asList(""), Arrays.asList("X-Auth-Token")));
		operationConfigs.put("9860fbf1-2871-46cd-ba4a-732519c67e65", new OperationConfig("/labs/proxy/qkr2/internal/api2/card/{id}", Action.read, Arrays.asList(""), Arrays.asList("X-Auth-Token")));
		operationConfigs.put("81445247-e2c5-40bf-84c8-070e82b2d2ca", new OperationConfig("/labs/proxy/qkr2/internal/api2/card/{id}", Action.update, Arrays.asList(""), Arrays.asList("X-Auth-Token")));
	}

	public Card() {
	}

	public Card(BaseObject o) {
		putAll(o);
	}

	public Card(RequestMap requestMap) {
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
	 * Creates a <code>Card</code> object
	 *
	 * @param       map a map of parameters to create a <code>Card</code> object
	 *
	 * @return      a Card object.
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public static Card create(RequestMap map)
		throws ApiException {

		return create(null, map);
	}

	/**
	 * Creates a <code>Card</code> object
	 *
	 * @param       auth Authentication object overriding <code>ApiConfig.setAuthentication(authentication)</code>
	 * @param       map a map of parameters to create a <code>Card</code> object
	 *
	 * @return      a Card object.
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public static Card create(Authentication auth, RequestMap map)
		throws ApiException {

		return new Card(BaseObject.executeOperation(auth, "03b649fa-64c8-43a3-8135-0833f927e7f0", new Card(map)));
	}









	/**
	 * Deletes a <code>Card</code> object.
	 *
	 * @return      a Card object.
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public Card delete()
		throws ApiException {

		BaseObject object = BaseObject.executeOperation(null, "82fc950a-17fd-4fa2-9336-1011a6673515", this);
		this.clear();
		this.putAll(object);
		return this;
	}

	/**
	 * Deletes a <code>Card</code> object.
	 *
	 * @param       auth Authentication object overriding <code>ApiConfig.setAuthentication(authentication)</code>
	 *
	 * @return      a Card object.
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public Card delete(Authentication auth)
		throws ApiException {

		BaseObject object = BaseObject.executeOperation(auth, "82fc950a-17fd-4fa2-9336-1011a6673515", this);
		this.clear();
		this.putAll(object);
		return this;
	}

	/**
	 * Deletes a <code>Card</code> object.
	 *
	 * @param       id the id of the object to delete
	 *
	 * @return      a Card object.
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public static Card delete(String id)
		throws ApiException {

		return delete(null, id);
	}

	/**
	 * Deletes a <code>Card</code> object
	 *
	 * @param       auth Authentication object overriding <code>ApiConfig.setAuthentication(authentication)</code>
	 * @param       id  the id of the object to delete
	 *
	 * @return      a Card object.
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public static Card delete(Authentication auth, String id)
		throws ApiException {

		Card object = new Card(new RequestMap("id", id));
		return object.delete(auth);
	}

	/**
	 * Deletes a <code>Card</code> object
	 *
	 * @param       id the id of the object to delete
	 * @param       map a map of additional parameters
	 *
	 * @return      a Card object.
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public static Card delete(String id, RequestMap map)
		throws ApiException {

		return delete(null, id, map);
	}

	/**
	 * Deletes a <code>Card</code> object
	 *
	 * @param       auth Authentication object overriding <code>ApiConfig.setAuthentication(authentication)</code>
	 * @param       id  the id of the object to delete
	 * @param       map a map of additional parameters
	 *
	 * @return      a Card object.
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public static Card delete(Authentication auth, String id, RequestMap map)
		throws ApiException {

		Card object = new Card(new RequestMap("id", id));
		if (map != null)  object.putAll(map);
		return object.delete(auth);
	}








	/**
	 * Query / Retrieve a <code>Card</code> object
	 *
	 * @param       query a map of query parameters
	 *
	 * @return      a Card object
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public static Card query(RequestMap query)
		throws ApiException {

		return query(null, query);
	}

	/**
	 * Query / Retrieve a <code>Card</code> object
	 *
	 * @param       auth Authentication object overriding <code>ApiConfig.setAuthentication(authentication)</code>
	 * @param       query a map of query parameters
	 *
	 * @return      a Card object
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public static Card query(Authentication auth, RequestMap query)
		throws ApiException {

		Card val = new Card();
		if (query != null)  val.putAll(query);
		return new Card(BaseObject.executeOperation(auth, "7763aa29-2d41-4061-90fc-56fc9b338554", val));
	}




	/**
	 * Retrieve a <code>Card</code> object
	 *
	 * @param       id the id of the <code>Card</code> object to retrieve
	 *
	 * @return      a Card object
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public static Card read(String id)
		throws ApiException {

		return read(null, id, null);
	}

	/**
	 * Retrieve a <code>Card</code> object
	 *
	 * @param       id the id of the <code>Card</code> object to retrieve
	 * @param       map a map of additional parameters
	 *
	 * @return      a Card object
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public static Card read(String id, RequestMap map)
		throws ApiException {

		return read(null, id, map);
	}

	/**
	 * Retrieve a <code>Card</code> object
	 *
	 * @param       auth Authentication object overriding <code>ApiConfig.setAuthentication(authentication)</code>
	 * @param       id the id of the <code>Card</code> object to retrieve
	 *
	 * @return      a Card object
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public static Card read(Authentication auth, String id)
		throws ApiException {

		return read(auth, id, null);
	}

	/**
	 * Retrieve a <code>Card</code> object
	 *
	 * @param       auth Authentication object overriding <code>ApiConfig.setAuthentication(authentication)</code>
	 * @param       id the id of the <code>Card</code> object to retrieve
	 * @param       map a map of additional parameters
	 *
	 * @return      a Card object
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public static Card read(Authentication auth, String id, RequestMap map)
		throws ApiException {

		Card val = new Card();
		if (id != null) val.put("id", id);
		if (map != null)  val.putAll(map);
		return new Card(BaseObject.executeOperation(auth, "9860fbf1-2871-46cd-ba4a-732519c67e65", val));
	}


	/**
	 * Update a <code>Card</code> object.
	 *
	 * @return      a Card object.
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public Card update()
		throws ApiException {

		BaseObject object = BaseObject.executeOperation(null, "81445247-e2c5-40bf-84c8-070e82b2d2ca", this);
		this.putAll(object);
		return this;
	}

	/**
	 * Update a <code>Card</code> object.
	 *
	 * @param       auth Authentication object overriding <code>ApiConfig.setAuthentication(authentication)</code>
	 *
	 * @return      a Card object.
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public Card update(Authentication auth)
		throws ApiException {

		BaseObject object = BaseObject.executeOperation(auth, "81445247-e2c5-40bf-84c8-070e82b2d2ca", this);
		this.putAll(object);
		return this;
	}




}


