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

public class PosPayment extends BaseObject  {

	private static Map<String, OperationConfig> operationConfigs;

	static {
		operationConfigs = new HashMap<String, OperationConfig>();
		operationConfigs.put("54e11a0f-c537-4665-b7f7-064240338095", new OperationConfig("/labs/proxy/qkr2/internal/api2/posPayment/pat", Action.create, Arrays.asList(""), Arrays.asList("X-Auth-Token")));
	}

	public PosPayment() {
	}

	public PosPayment(BaseObject o) {
		putAll(o);
	}

	public PosPayment(RequestMap requestMap) {
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
	 * Creates a <code>PosPayment</code> object
	 *
	 * @param       map a map of parameters to create a <code>PosPayment</code> object
	 *
	 * @return      a PosPayment object.
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public static PosPayment create(RequestMap map)
		throws ApiException {

		return create(null, map);
	}

	/**
	 * Creates a <code>PosPayment</code> object
	 *
	 * @param       auth Authentication object overriding <code>ApiConfig.setAuthentication(authentication)</code>
	 * @param       map a map of parameters to create a <code>PosPayment</code> object
	 *
	 * @return      a PosPayment object.
	 *
	 * @throws      ApiException - which encapsulates the http status code and the error return by the server
	 */
	public static PosPayment create(Authentication auth, RequestMap map)
		throws ApiException {

		return new PosPayment(BaseObject.executeOperation(auth, "54e11a0f-c537-4665-b7f7-064240338095", new PosPayment(map)));
	}






}


