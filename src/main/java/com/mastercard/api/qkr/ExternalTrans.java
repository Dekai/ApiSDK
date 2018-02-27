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

public class ExternalTrans extends BaseObject  {

	private static Map<String, OperationConfig> operationConfigs;

	static {
		operationConfigs = new HashMap<String, OperationConfig>();
		operationConfigs.put("474af05e-0f32-4687-87fb-3a29c07b8a1a", new OperationConfig("/labs/proxy/qkr2/internal/api2/externalTrans", Action.create, Arrays.asList(""), Arrays.asList("")));
		operationConfigs.put("4a26e198-94a2-49bf-904d-ba08b5e9628d", new OperationConfig("/labs/proxy/qkr2/internal/api2/externalTrans", Action.query, Arrays.asList(""), Arrays.asList("")));
		operationConfigs.put("319ae648-766b-4116-9fcc-258e5c2440e9", new OperationConfig("/labs/proxy/qkr2/internal/api2/externalTrans/{id}", Action.read, Arrays.asList(""), Arrays.asList("")));
	}

	public ExternalTrans() {
	}

	public ExternalTrans(BaseObject o) {
		putAll(o);
	}

	public ExternalTrans(RequestMap requestMap) {
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
	 * Creates a <code>ExternalTrans</code> object
	 *
	 * @param       map a map of parameters to create a <code>ExternalTrans</code> object
	 *
	 * @return      a ExternalTrans object.
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public static ExternalTrans create(RequestMap map)
		throws ApiException {

		return create(null, map);
	}

	/**
	 * Creates a <code>ExternalTrans</code> object
	 *
	 * @param       auth Authentication object overriding <code>ApiConfig.setAuthentication(authentication)</code>
	 * @param       map a map of parameters to create a <code>ExternalTrans</code> object
	 *
	 * @return      a ExternalTrans object.
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public static ExternalTrans create(Authentication auth, RequestMap map)
		throws ApiException {

		return new ExternalTrans(BaseObject.executeOperation(auth, "474af05e-0f32-4687-87fb-3a29c07b8a1a", new ExternalTrans(map)));
	}











	/**
	 * Query / Retrieve a <code>ExternalTrans</code> object
	 *
	 * @param       query a map of query parameters
	 *
	 * @return      a ExternalTrans object
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public static ExternalTrans query(RequestMap query)
		throws ApiException {

		return query(null, query);
	}

	/**
	 * Query / Retrieve a <code>ExternalTrans</code> object
	 *
	 * @param       auth Authentication object overriding <code>ApiConfig.setAuthentication(authentication)</code>
	 * @param       query a map of query parameters
	 *
	 * @return      a ExternalTrans object
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public static ExternalTrans query(Authentication auth, RequestMap query)
		throws ApiException {

		ExternalTrans val = new ExternalTrans();
		if (query != null)  val.putAll(query);
		return new ExternalTrans(BaseObject.executeOperation(auth, "4a26e198-94a2-49bf-904d-ba08b5e9628d", val));
	}




	/**
	 * Retrieve a <code>ExternalTrans</code> object
	 *
	 * @param       id the id of the <code>ExternalTrans</code> object to retrieve
	 *
	 * @return      a ExternalTrans object
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public static ExternalTrans read(String id)
		throws ApiException {

		return read(null, id, null);
	}

	/**
	 * Retrieve a <code>ExternalTrans</code> object
	 *
	 * @param       id the id of the <code>ExternalTrans</code> object to retrieve
	 * @param       map a map of additional parameters
	 *
	 * @return      a ExternalTrans object
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public static ExternalTrans read(String id, RequestMap map)
		throws ApiException {

		return read(null, id, map);
	}

	/**
	 * Retrieve a <code>ExternalTrans</code> object
	 *
	 * @param       auth Authentication object overriding <code>ApiConfig.setAuthentication(authentication)</code>
	 * @param       id the id of the <code>ExternalTrans</code> object to retrieve
	 *
	 * @return      a ExternalTrans object
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public static ExternalTrans read(Authentication auth, String id)
		throws ApiException {

		return read(auth, id, null);
	}

	/**
	 * Retrieve a <code>ExternalTrans</code> object
	 *
	 * @param       auth Authentication object overriding <code>ApiConfig.setAuthentication(authentication)</code>
	 * @param       id the id of the <code>ExternalTrans</code> object to retrieve
	 * @param       map a map of additional parameters
	 *
	 * @return      a ExternalTrans object
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public static ExternalTrans read(Authentication auth, String id, RequestMap map)
		throws ApiException {

		ExternalTrans val = new ExternalTrans();
		if (id != null) val.put("id", id);
		if (map != null)  val.putAll(map);
		return new ExternalTrans(BaseObject.executeOperation(auth, "319ae648-766b-4116-9fcc-258e5c2440e9", val));
	}

}


