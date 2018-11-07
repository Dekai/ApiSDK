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

public class Cart extends BaseObject  {

	private static Map<String, OperationConfig> operationConfigs;

	static {
		operationConfigs = new HashMap<String, OperationConfig>();
		operationConfigs.put("b6ff9ec8-035e-4e8e-8421-c6abd1faa7f7", new OperationConfig("/labs/proxy/qkr2/internal/api2/cart/{id}", Action.delete, Arrays.asList(""), Arrays.asList("X-Auth-Token")));
		operationConfigs.put("4b7e7849-bf77-4a83-b969-2ebd1a443b45", new OperationConfig("/labs/proxy/qkr2/internal/api2/cart", Action.query, Arrays.asList(""), Arrays.asList("X-Auth-Token")));
		operationConfigs.put("0ab995a2-b8f5-4538-a437-e43872dab4b2", new OperationConfig("/labs/proxy/qkr2/internal/api2/cart/{id}", Action.read, Arrays.asList(""), Arrays.asList("X-Auth-Token")));
	}

	public Cart() {
	}

	public Cart(BaseObject o) {
		putAll(o);
	}

	public Cart(RequestMap requestMap) {
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
	 * Deletes a <code>Cart</code> object.
	 *
	 * @return      a Cart object.
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public Cart delete()
		throws ApiException {

		BaseObject object = BaseObject.executeOperation(null, "b6ff9ec8-035e-4e8e-8421-c6abd1faa7f7", this);
		this.clear();
		this.putAll(object);
		return this;
	}

	/**
	 * Deletes a <code>Cart</code> object.
	 *
	 * @param       auth Authentication object overriding <code>ApiConfig.setAuthentication(authentication)</code>
	 *
	 * @return      a Cart object.
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public Cart delete(Authentication auth)
		throws ApiException {

		BaseObject object = BaseObject.executeOperation(auth, "b6ff9ec8-035e-4e8e-8421-c6abd1faa7f7", this);
		this.clear();
		this.putAll(object);
		return this;
	}

	/**
	 * Deletes a <code>Cart</code> object.
	 *
	 * @param       id the id of the object to delete
	 *
	 * @return      a Cart object.
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public static Cart delete(String id)
		throws ApiException {

		return delete(null, id);
	}

	/**
	 * Deletes a <code>Cart</code> object
	 *
	 * @param       auth Authentication object overriding <code>ApiConfig.setAuthentication(authentication)</code>
	 * @param       id  the id of the object to delete
	 *
	 * @return      a Cart object.
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public static Cart delete(Authentication auth, String id)
		throws ApiException {

		Cart object = new Cart(new RequestMap("id", id));
		return object.delete(auth);
	}

	/**
	 * Deletes a <code>Cart</code> object
	 *
	 * @param       id the id of the object to delete
	 * @param       map a map of additional parameters
	 *
	 * @return      a Cart object.
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public static Cart delete(String id, RequestMap map)
		throws ApiException {

		return delete(null, id, map);
	}

	/**
	 * Deletes a <code>Cart</code> object
	 *
	 * @param       auth Authentication object overriding <code>ApiConfig.setAuthentication(authentication)</code>
	 * @param       id  the id of the object to delete
	 * @param       map a map of additional parameters
	 *
	 * @return      a Cart object.
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public static Cart delete(Authentication auth, String id, RequestMap map)
		throws ApiException {

		Cart object = new Cart(new RequestMap("id", id));
		if (map != null)  object.putAll(map);
		return object.delete(auth);
	}








	/**
	 * Query / Retrieve a <code>Cart</code> object
	 *
	 * @param       query a map of query parameters
	 *
	 * @return      a Cart object
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public static Cart query(RequestMap query)
		throws ApiException {

		return query(null, query);
	}

	/**
	 * Query / Retrieve a <code>Cart</code> object
	 *
	 * @param       auth Authentication object overriding <code>ApiConfig.setAuthentication(authentication)</code>
	 * @param       query a map of query parameters
	 *
	 * @return      a Cart object
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public static Cart query(Authentication auth, RequestMap query)
		throws ApiException {

		Cart val = new Cart();
		if (query != null)  val.putAll(query);
		return new Cart(BaseObject.executeOperation(auth, "4b7e7849-bf77-4a83-b969-2ebd1a443b45", val));
	}




	/**
	 * Retrieve a <code>Cart</code> object
	 *
	 * @param       id the id of the <code>Cart</code> object to retrieve
	 *
	 * @return      a Cart object
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public static Cart read(String id)
		throws ApiException {

		return read(null, id, null);
	}

	/**
	 * Retrieve a <code>Cart</code> object
	 *
	 * @param       id the id of the <code>Cart</code> object to retrieve
	 * @param       map a map of additional parameters
	 *
	 * @return      a Cart object
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public static Cart read(String id, RequestMap map)
		throws ApiException {

		return read(null, id, map);
	}

	/**
	 * Retrieve a <code>Cart</code> object
	 *
	 * @param       auth Authentication object overriding <code>ApiConfig.setAuthentication(authentication)</code>
	 * @param       id the id of the <code>Cart</code> object to retrieve
	 *
	 * @return      a Cart object
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public static Cart read(Authentication auth, String id)
		throws ApiException {

		return read(auth, id, null);
	}

	/**
	 * Retrieve a <code>Cart</code> object
	 *
	 * @param       auth Authentication object overriding <code>ApiConfig.setAuthentication(authentication)</code>
	 * @param       id the id of the <code>Cart</code> object to retrieve
	 * @param       map a map of additional parameters
	 *
	 * @return      a Cart object
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public static Cart read(Authentication auth, String id, RequestMap map)
		throws ApiException {

		Cart val = new Cart();
		if (id != null) val.put("id", id);
		if (map != null)  val.putAll(map);
		return new Cart(BaseObject.executeOperation(auth, "0ab995a2-b8f5-4538-a437-e43872dab4b2", val));
	}

}


