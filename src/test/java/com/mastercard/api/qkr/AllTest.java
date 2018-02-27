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

import com.mastercard.api.core.*;
import com.mastercard.api.core.exception.*;
import com.mastercard.api.core.model.*;
import com.mastercard.api.core.security.*;
import com.mastercard.api.core.security.oauth.OAuthAuthentication;
import com.mastercard.api.core.security.mdes.MDESCryptography;
import com.mastercard.api.core.security.installments.InstallmentCryptography;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

import utils.BaseTest;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AllTest {

	@Before
	public void setUp() {
		ApiConfig.setDebug(true);
		ApiConfig.setSandbox(true);
		//ApiConfig.setEnvironment(Environment.SANDBOX)


		try {
			BaseTest.resetAuthentication();

      String consumerKey = "8t0FW9gUOZiwEWrTUP3PKpw2KEaBecadSJ75UcqD61467422!edf9eaffc20c41a1a6664ac5550d725c0000000000000000";   // You should copy this from "My Keys" on your project page e.g. UTfbhDCSeNYvJpLL5l028sWL9it739PYh6LU5lZja15xcRpY!fd209e6c579dc9d7be52da93d35ae6b6c167c174690b72fa
       String keyAlias = "keyalias";   // For production: change this to the key alias you chose when you created your production key
       String keyPassword = "keystorepassword";   // For production: change this to the key alias you chose when you created your production key
       InputStream is = new FileInputStream("/Users/dekaizhang/Projects/sdk-generator/QkrOpenAPITest-1519617044-sandbox.p12"); // e.g. /Users/yourname/project/sandbox.p12 | C:\Users\yourname\project\sandbox.p12
       ApiConfig.setAuthentication(new OAuthAuthentication(consumerKey, is, keyAlias, keyPassword));   // You only need to set this once
       ApiConfig.setDebug(true);   // Enable http wire logging
       ApiConfig.setSandbox(true); // For production: use ApiConfig.setSandbox(false);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Test public void test_128_Test__prodGroup__id__get() throws Exception {
		//

		System.out.print("ERROR===============>" + BaseTest.resolveResponseValue("getMerchant.list[0].outlets[0].prodGroupSummaries[0].id"));
		RequestMap map = new RequestMap();
		map.set("id", 9148);
		ProdGroup response = ProdGroup.read("123456", map);

		List<String> ignoreAsserts = new ArrayList<String>();
		ignoreAsserts.add("locatedScanId");
		ignoreAsserts.add("merchantId");
		ignoreAsserts.add("merchantLocId");
		ignoreAsserts.add("products[0].id");
		ignoreAsserts.add("products[0].mediumImageUrl");
		ignoreAsserts.add("products[0].variants[0].amountMinorUnits");
		ignoreAsserts.add("products[0].variants[0].id");
		ignoreAsserts.add("products[0].variants[0].sku");
		ignoreAsserts.add("products[0].variants[0].isDefault");
		ignoreAsserts.add("title");
		ignoreAsserts.add("merchantName");
		ignoreAsserts.add("products[0].smallDescription");
		ignoreAsserts.add("products[0].name");
		ignoreAsserts.add("products[0].description");
		ignoreAsserts.add("products[0].variants[0].stockLevel");
		ignoreAsserts.add("products[0].category");
		ignoreAsserts.add("id");
		ignoreAsserts.add("merchantWideImageUrl");

		BaseTest.assertEqual(ignoreAsserts, response, "merchantLocId", "143043");
		BaseTest.assertEqual(ignoreAsserts, response, "title", "my menu");
		BaseTest.assertEqual(ignoreAsserts, response, "merchantName", "OpenApi sdk-gen test");
		BaseTest.assertEqual(ignoreAsserts, response, "products[0].smallDescription", "");
		BaseTest.assertEqual(ignoreAsserts, response, "products[0].name", "tea");
		BaseTest.assertEqual(ignoreAsserts, response, "products[0].description", "");
		BaseTest.assertEqual(ignoreAsserts, response, "products[0].id", "143053");
		BaseTest.assertEqual(ignoreAsserts, response, "products[0].variants[0].isDefault", "true");
		BaseTest.assertEqual(ignoreAsserts, response, "products[0].variants[0].amountMinorUnits", "200");
		BaseTest.assertEqual(ignoreAsserts, response, "products[0].variants[0].currency", "AUD");
		BaseTest.assertEqual(ignoreAsserts, response, "products[0].variants[0].id", "143054");
		BaseTest.assertEqual(ignoreAsserts, response, "products[0].variants[0].priority", "0");
		BaseTest.assertEqual(ignoreAsserts, response, "products[0].variants[0].sku", "ba01dafe-efbf-4d4b-af34-10d06497351d");
		BaseTest.assertEqual(ignoreAsserts, response, "products[0].variants[0].stockLevel", "N");
		BaseTest.assertEqual(ignoreAsserts, response, "products[0].allowPurchaseNote", "true");
		BaseTest.assertEqual(ignoreAsserts, response, "products[0].category", "drink");
		BaseTest.assertEqual(ignoreAsserts, response, "products[0].shippingAddressRequired", "true");
		BaseTest.assertEqual(ignoreAsserts, response, "products[0].mediumImageUrl", "https://d1wfs5jdtdt7am.cloudfront.net/mss/product-placeholder.png");
		BaseTest.assertEqual(ignoreAsserts, response, "transactionType", "BUY");
		BaseTest.assertEqual(ignoreAsserts, response, "shippingRequired", "true");
		BaseTest.assertEqual(ignoreAsserts, response, "merchantId", "143035");
		BaseTest.assertEqual(ignoreAsserts, response, "ageRestrictedMessage", "To purchase this product, please confirm that you are over %d years of age.");
		BaseTest.assertEqual(ignoreAsserts, response, "locatedScanId", "143052");
		BaseTest.assertEqual(ignoreAsserts, response, "id", "143051");
		BaseTest.assertEqual(ignoreAsserts, response, "unitPricePreTax", "true");
		BaseTest.assertEqual(ignoreAsserts, response, "merchantWideImageUrl", "");

		BaseTest.putResponse("Test__prodGroup__id__get", response);

	}

}
