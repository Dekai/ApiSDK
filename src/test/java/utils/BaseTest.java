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

package utils;

import com.mastercard.api.core.ApiConfig;
import com.mastercard.api.core.model.RequestMap;
import com.mastercard.api.core.security.Authentication;
import com.mastercard.api.core.security.oauth.OAuthAuthentication;
import org.junit.Assert;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.util.*;

public class BaseTest {
	private static final Logger log = Logger.getLogger(BaseTest.class);

	public static Map<String, RequestMap> responses = new HashMap<String, RequestMap>();
	public static Map<String, OAuthAuthentication> authentications = new HashMap<String, OAuthAuthentication>();

	static {
		try {
			authentications.put("default", new OAuthAuthentication("L5BsiPgaF-O3qA36znUATgQXwJB6MRoMSdhjd7wt50c97279!50596e52466e3966546d434b7354584c4975693238513d3d", new FileInputStream("mcapi_sandbox_key.p12"), "test", "password"));
			authentications.put("default2", new OAuthAuthentication("rJWlVy-B-8Tfa5k0raxXy_BgKIfUx41sYT9CMdBod8885a33!50383044ee074864822d99b0a0295aa30000000000000000", new FileInputStream("sandbox9_sandbox.p12"), "sandbox9", "keystorepassword"));
			authentications.put("send_1", new OAuthAuthentication("-mzBAF1UFssV7H1VDrJuXQ45AZlkmfNEoMUxocsGae1f9f59!cba9cef300b64e3e812698fd7a8b6bff0000000000000000", new FileInputStream("send_sdk_ci_1_sandbox.p12"), "keyalias", "keystorepassword"));
			authentications.put("send_2", new OAuthAuthentication("3nSpMB_IjYzyLhUbK37cHsYHVy7b3goCk1Q1DEinb60951d6!1b1af7c5aa1a4d5792ee9e707f9b87d60000000000000000", new FileInputStream("send_sdk_ci_2_sandbox.p12"), "keyalias", "keystorepassword"));
			authentications.put("send_3", new OAuthAuthentication("qPG4eNdxSW2pT1M5YdsyBoQs1CeyYmQ2JvYL2qq_a2b027f3!c6350fb087cc4df58700e117636e16c90000000000000000", new FileInputStream("send_sdk_ci_3_sandbox.p12"), "sandbox7", "keystorepassword"));
			authentications.put("qkr_1", new OAuthAuthentication("gdk9qb4mbHh-ATX7pHkMgEhw_3EJSh6TgqJjbHpN77a6a0d8!05aca79910084b36afa0574d3b87e2360000000000000000", new FileInputStream("qkr29Aug_sandbox.p12"), "keyalias", "keystorepassword"));
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void putResponse(String name, RequestMap response) {
		responses.put(name, response);
	}

	public static Object resolveResponseValue(String overrideValue) {

		//arizzini: if plain value, return it.
		if (overrideValue.startsWith("val:")) {
			return overrideValue.substring(4);
		} else {
			int i = overrideValue.indexOf(".");

			String name = overrideValue.substring(0, i);
			String key = overrideValue.substring(i + 1);

			RequestMap response = responses.get(name);

			Object value = null;

			if (response != null) {
				value = response.get(key);
			}
			else {
				log.error("No response entry found for example " + name);
			}

			return value;
		}

	}

	/**
	 * Get the actual value from the response map and asserts its value against the expected value
	 *
	 * @param ignoreAsserts - list of keys to ignore assert for
	 * @param response - the response map
	 * @param key - the key to get from the response map and assert
	 * @param expectedValue - the expected value
	 */
	public static void assertEqual(List<String> ignoreAsserts, RequestMap response, String key, Object expectedValue) {
		//Assert.assertTrue(response.containsKey(key));

		if (!ignoreAsserts.contains(key)) {

			Assert.assertTrue(response.get(key).toString().equalsIgnoreCase(expectedValue.toString()));
		}
	}

	public static void setAuthentication(String keyId) throws Exception {
		Authentication authentication = authentications.get(keyId);

		if (keyId == null) {
			throw new Exception("No authentication found for keyId: " + keyId);
		}

		ApiConfig.setAuthentication(authentication);
	}

	public static void resetAuthentication() throws Exception {
		setAuthentication("default");
	}
}