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

public class CartItem extends BaseObject  {

	private static Map<String, OperationConfig> operationConfigs;

	static {
		operationConfigs = new HashMap<String, OperationConfig>();
		operationConfigs.put("358f0fb0-fa9f-425e-b390-db41a9368408", new OperationConfig("/labs/proxy/qkr2/internal/api2/cartItem", Action.create, Arrays.asList(""), Arrays.asList("X-Auth-Token")));
		operationConfigs.put("99c4a692-f9fe-411c-b78f-5e6ac5c9f90c", new OperationConfig("/labs/proxy/qkr2/internal/api2/cartItem/{id}", Action.delete, Arrays.asList(""), Arrays.asList("X-Auth-Token")));
		operationConfigs.put("9eea740f-db7e-449d-9b5b-7bfbc8b6c421", new OperationConfig("/labs/proxy/qkr2/internal/api2/cartItem/{id}", Action.update, Arrays.asList(""), Arrays.asList("X-Auth-Token")));
	}

	public CartItem() {
	}

	public CartItem(BaseObject o) {
		putAll(o);
	}

	public CartItem(RequestMap requestMap) {
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
	 * Creates a <code>CartItem</code> object
	 *
	 * @param       map a map of parameters to create a <code>CartItem</code> object
	 *
	 * @return      a CartItem object.
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public static CartItem create(RequestMap map)
		throws ApiException {

		return create(null, map);
	}

	/**
	 * Creates a <code>CartItem</code> object
	 *
	 * @param       auth Authentication object overriding <code>ApiConfig.setAuthentication(authentication)</code>
	 * @param       map a map of parameters to create a <code>CartItem</code> object
	 *
	 * @return      a CartItem object.
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public static CartItem create(Authentication auth, RequestMap map)
		throws ApiException {

		return new CartItem(BaseObject.executeOperation(auth, "358f0fb0-fa9f-425e-b390-db41a9368408", new CartItem(map)));
	}









	/**
	 * Deletes a <code>CartItem</code> object.
	 *
	 * @return      a CartItem object.
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public CartItem delete()
		throws ApiException {

		BaseObject object = BaseObject.executeOperation(null, "99c4a692-f9fe-411c-b78f-5e6ac5c9f90c", this);
		this.clear();
		this.putAll(object);
		return this;
	}

	/**
	 * Deletes a <code>CartItem</code> object.
	 *
	 * @param       auth Authentication object overriding <code>ApiConfig.setAuthentication(authentication)</code>
	 *
	 * @return      a CartItem object.
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public CartItem delete(Authentication auth)
		throws ApiException {

		BaseObject object = BaseObject.executeOperation(auth, "99c4a692-f9fe-411c-b78f-5e6ac5c9f90c", this);
		this.clear();
		this.putAll(object);
		return this;
	}

	/**
	 * Deletes a <code>CartItem</code> object.
	 *
	 * @param       id the id of the object to delete
	 *
	 * @return      a CartItem object.
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public static CartItem delete(String id)
		throws ApiException {

		return delete(null, id);
	}

	/**
	 * Deletes a <code>CartItem</code> object
	 *
	 * @param       auth Authentication object overriding <code>ApiConfig.setAuthentication(authentication)</code>
	 * @param       id  the id of the object to delete
	 *
	 * @return      a CartItem object.
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public static CartItem delete(Authentication auth, String id)
		throws ApiException {

		CartItem object = new CartItem(new RequestMap("id", id));
		return object.delete(auth);
	}

	/**
	 * Deletes a <code>CartItem</code> object
	 *
	 * @param       id the id of the object to delete
	 * @param       map a map of additional parameters
	 *
	 * @return      a CartItem object.
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public static CartItem delete(String id, RequestMap map)
		throws ApiException {

		return delete(null, id, map);
	}

	/**
	 * Deletes a <code>CartItem</code> object
	 *
	 * @param       auth Authentication object overriding <code>ApiConfig.setAuthentication(authentication)</code>
	 * @param       id  the id of the object to delete
	 * @param       map a map of additional parameters
	 *
	 * @return      a CartItem object.
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public static CartItem delete(Authentication auth, String id, RequestMap map)
		throws ApiException {

		CartItem object = new CartItem(new RequestMap("id", id));
		if (map != null)  object.putAll(map);
		return object.delete(auth);
	}




	/**
	 * Update a <code>CartItem</code> object.
	 *
	 * @return      a CartItem object.
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public CartItem update()
		throws ApiException {

		BaseObject object = BaseObject.executeOperation(null, "9eea740f-db7e-449d-9b5b-7bfbc8b6c421", this);
		this.putAll(object);
		return this;
	}

	/**
	 * Update a <code>CartItem</code> object.
	 *
	 * @param       auth Authentication object overriding <code>ApiConfig.setAuthentication(authentication)</code>
	 *
	 * @return      a CartItem object.
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public CartItem update(Authentication auth)
		throws ApiException {

		BaseObject object = BaseObject.executeOperation(auth, "9eea740f-db7e-449d-9b5b-7bfbc8b6c421", this);
		this.putAll(object);
		return this;
	}




}


