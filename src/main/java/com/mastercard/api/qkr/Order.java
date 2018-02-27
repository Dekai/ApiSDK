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

public class Order extends BaseObject  {

	private static Map<String, OperationConfig> operationConfigs;

	static {
		operationConfigs = new HashMap<String, OperationConfig>();
		operationConfigs.put("bad916c9-636f-4449-8a35-4198e436a5c2", new OperationConfig("/labs/proxy/qkr2/internal/api2/order/pat", Action.create, Arrays.asList(""), Arrays.asList("")));
		operationConfigs.put("28921df1-9fe3-4209-822d-d4df89240665", new OperationConfig("/labs/proxy/qkr2/internal/api2/order/pat/{id}", Action.delete, Arrays.asList(""), Arrays.asList("")));
		operationConfigs.put("72faf2de-01a8-4ac2-8bea-53f1ca9fa915", new OperationConfig("/labs/proxy/qkr2/internal/api2/order/pat/{id}", Action.read, Arrays.asList(""), Arrays.asList("")));
		operationConfigs.put("bae31f64-883a-4fe5-9581-6097e21bd893", new OperationConfig("/labs/proxy/qkr2/internal/api2/order/pat/{id}", Action.update, Arrays.asList(""), Arrays.asList("")));
	}

	public Order() {
	}

	public Order(BaseObject o) {
		putAll(o);
	}

	public Order(RequestMap requestMap) {
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
	 * Creates a <code>Order</code> object
	 *
	 * @param       map a map of parameters to create a <code>Order</code> object
	 *
	 * @return      a Order object.
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public static Order create(RequestMap map)
		throws ApiException {

		return create(null, map);
	}

	/**
	 * Creates a <code>Order</code> object
	 *
	 * @param       auth Authentication object overriding <code>ApiConfig.setAuthentication(authentication)</code>
	 * @param       map a map of parameters to create a <code>Order</code> object
	 *
	 * @return      a Order object.
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public static Order create(Authentication auth, RequestMap map)
		throws ApiException {

		return new Order(BaseObject.executeOperation(auth, "bad916c9-636f-4449-8a35-4198e436a5c2", new Order(map)));
	}









	/**
	 * Deletes a <code>Order</code> object.
	 *
	 * @return      a Order object.
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public Order delete()
		throws ApiException {

		BaseObject object = BaseObject.executeOperation(null, "28921df1-9fe3-4209-822d-d4df89240665", this);
		this.clear();
		this.putAll(object);
		return this;
	}

	/**
	 * Deletes a <code>Order</code> object.
	 *
	 * @param       auth Authentication object overriding <code>ApiConfig.setAuthentication(authentication)</code>
	 *
	 * @return      a Order object.
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public Order delete(Authentication auth)
		throws ApiException {

		BaseObject object = BaseObject.executeOperation(auth, "28921df1-9fe3-4209-822d-d4df89240665", this);
		this.clear();
		this.putAll(object);
		return this;
	}

	/**
	 * Deletes a <code>Order</code> object.
	 *
	 * @param       id the id of the object to delete
	 *
	 * @return      a Order object.
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public static Order delete(String id)
		throws ApiException {

		return delete(null, id);
	}

	/**
	 * Deletes a <code>Order</code> object
	 *
	 * @param       auth Authentication object overriding <code>ApiConfig.setAuthentication(authentication)</code>
	 * @param       id  the id of the object to delete
	 *
	 * @return      a Order object.
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public static Order delete(Authentication auth, String id)
		throws ApiException {

		Order object = new Order(new RequestMap("id", id));
		return object.delete(auth);
	}

	/**
	 * Deletes a <code>Order</code> object
	 *
	 * @param       id the id of the object to delete
	 * @param       map a map of additional parameters
	 *
	 * @return      a Order object.
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public static Order delete(String id, RequestMap map)
		throws ApiException {

		return delete(null, id, map);
	}

	/**
	 * Deletes a <code>Order</code> object
	 *
	 * @param       auth Authentication object overriding <code>ApiConfig.setAuthentication(authentication)</code>
	 * @param       id  the id of the object to delete
	 * @param       map a map of additional parameters
	 *
	 * @return      a Order object.
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public static Order delete(Authentication auth, String id, RequestMap map)
		throws ApiException {

		Order object = new Order(new RequestMap("id", id));
		if (map != null)  object.putAll(map);
		return object.delete(auth);
	}







	/**
	 * Retrieve a <code>Order</code> object
	 *
	 * @param       id the id of the <code>Order</code> object to retrieve
	 *
	 * @return      a Order object
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public static Order read(String id)
		throws ApiException {

		return read(null, id, null);
	}

	/**
	 * Retrieve a <code>Order</code> object
	 *
	 * @param       id the id of the <code>Order</code> object to retrieve
	 * @param       map a map of additional parameters
	 *
	 * @return      a Order object
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public static Order read(String id, RequestMap map)
		throws ApiException {

		return read(null, id, map);
	}

	/**
	 * Retrieve a <code>Order</code> object
	 *
	 * @param       auth Authentication object overriding <code>ApiConfig.setAuthentication(authentication)</code>
	 * @param       id the id of the <code>Order</code> object to retrieve
	 *
	 * @return      a Order object
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public static Order read(Authentication auth, String id)
		throws ApiException {

		return read(auth, id, null);
	}

	/**
	 * Retrieve a <code>Order</code> object
	 *
	 * @param       auth Authentication object overriding <code>ApiConfig.setAuthentication(authentication)</code>
	 * @param       id the id of the <code>Order</code> object to retrieve
	 * @param       map a map of additional parameters
	 *
	 * @return      a Order object
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public static Order read(Authentication auth, String id, RequestMap map)
		throws ApiException {

		Order val = new Order();
		if (id != null) val.put("id", id);
		if (map != null)  val.putAll(map);
		return new Order(BaseObject.executeOperation(auth, "72faf2de-01a8-4ac2-8bea-53f1ca9fa915", val));
	}


	/**
	 * Update a <code>Order</code> object.
	 *
	 * @return      a Order object.
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public Order update()
		throws ApiException {

		BaseObject object = BaseObject.executeOperation(null, "bae31f64-883a-4fe5-9581-6097e21bd893", this);
		this.putAll(object);
		return this;
	}

	/**
	 * Update a <code>Order</code> object.
	 *
	 * @param       auth Authentication object overriding <code>ApiConfig.setAuthentication(authentication)</code>
	 *
	 * @return      a Order object.
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public Order update(Authentication auth)
		throws ApiException {

		BaseObject object = BaseObject.executeOperation(auth, "bae31f64-883a-4fe5-9581-6097e21bd893", this);
		this.putAll(object);
		return this;
	}




}


