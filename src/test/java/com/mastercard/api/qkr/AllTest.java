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

import com.mastercard.api.core.ApiConfig;
import com.mastercard.api.core.model.Environment;
import com.mastercard.api.core.model.RequestMap;
import com.mastercard.api.core.security.oauth.OAuthAuthentication;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import utils.BaseTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AllTest {

     void initializeSandboxSdk() {
        try {
            String consumerKey = "8t0FW9gUOZiwEWrTUP3PKpw2KEaBecadSJ75UcqD61467422!edf9eaffc20c41a1a6664ac5550d725c0000000000000000";   // You should copy this from "My Keys" on your project page e.g. UTfbhDCSeNYvJpLL5l028sWL9it739PYh6LU5lZja15xcRpY!fd209e6c579dc9d7be52da93d35ae6b6c167c174690b72fa
            String keyAlias = "keyalias";   // For production: change this to the key alias you chose when you created your production key
            String keyPassword = "keystorepassword";   // For production: change this to the key alias you chose when you created your production key
            InputStream is = new FileInputStream("sandbox.p12"); // e.g. /Users/yourname/project/sandbox.p12 | C:\Users\yourname\project\sandbox.p12
            ApiConfig.setAuthentication(new OAuthAuthentication(consumerKey, is, keyAlias, keyPassword));   // You only need to set this once
            ApiConfig.setDebug(true);   // Enable http wire logging
            ApiConfig.setSandbox(true); // For production: use ApiConfig.setSandbox(false);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

     void initializeProdSdk() {
        try {
            String consumerKey = "8LXQYkg6nkGpvonzy5xdEumgPI9wFnaZPLoTcBKo508ccb70!fb525e23b2394e55a5a1e1cab4d4014c0000000000000000";   // You should copy this from "My Keys" on your project page e.g. UTfbhDCSeNYvJpLL5l028sWL9it739PYh6LU5lZja15xcRpY!fd209e6c579dc9d7be52da93d35ae6b6c167c174690b72fa
            String keyAlias = "QkrKeyAlias";   // For production: change this to the key alias you chose when you created your production key
            String keyPassword = "Qwerty12";   // For production: change this to the key alias you chose when you created your production key
            InputStream is = new FileInputStream("QkrKeyAlias-production.p12"); // e.g. /Users/yourname/project/sandbox.p12 | C:\Users\yourname\project\sandbox.p12
            ApiConfig.setAuthentication(new OAuthAuthentication(consumerKey, is, keyAlias, keyPassword));   // You only need to set this once
            ApiConfig.setDebug(true);   // Enable http wire logging
            ApiConfig.setSandbox(false); // For production: use ApiConfig.setSandbox(false);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

	@Before
	public void setUp() {
		ApiConfig.setDebug(true);
//		ApiConfig.setSandbox(true);
		ApiConfig.setEnvironment(Environment.PRODUCTION);


		try {
			BaseTest.resetAuthentication();
//
//      String consumerKey = "8t0FW9gUOZiwEWrTUP3PKpw2KEaBecadSJ75UcqD61467422!edf9eaffc20c41a1a6664ac5550d725c0000000000000000";   // You should copy this from "My Keys" on your project page e.g. UTfbhDCSeNYvJpLL5l028sWL9it739PYh6LU5lZja15xcRpY!fd209e6c579dc9d7be52da93d35ae6b6c167c174690b72fa
//       String keyAlias = "keyalias";   // For production: change this to the key alias you chose when you created your production key
//       String keyPassword = "keystorepassword";   // For production: change this to the key alias you chose when you created your production key
//       InputStream is = new FileInputStream("/Users/dekaizhang/Projects/sdk-generator/QkrOpenAPITest-1519617044-sandbox.p12"); // e.g. /Users/yourname/project/sandbox.p12 | C:\Users\yourname\project\sandbox.p12
//       ApiConfig.setAuthentication(new OAuthAuthentication(consumerKey, is, keyAlias, keyPassword));   // You only need to set this once
//       ApiConfig.setDebug(true);   // Enable http wire logging
//       ApiConfig.setSandbox(true); // For production: use ApiConfig.setSandbox(false);
            initializeProdSdk();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}



    @Test public void test_111_getMerchant() throws Exception {
        //


        RequestMap map = new RequestMap();
        Merchant response = Merchant.query(map);

        List<String> ignoreAsserts = new ArrayList<String>();
        ignoreAsserts.add("list[0].defaultCurrency");
        ignoreAsserts.add("list[0].imageUrl");
        ignoreAsserts.add("list[0].name");
        ignoreAsserts.add("list[0].outlets[0].payAtTable");
        ignoreAsserts.add("list[0].outlets[0].address");
        ignoreAsserts.add("list[0].outlets[0].latitude");
        ignoreAsserts.add("list[0].outlets[0].merchantId");
        ignoreAsserts.add("list[0].outlets[0].imageUrl");
        ignoreAsserts.add("list[0].outlets[0].name");
        ignoreAsserts.add("list[0].outlets[0].id");
        ignoreAsserts.add("list[0].outlets[0].longitude");
        ignoreAsserts.add("list[0].outlets[0].prodGroupSummaries[0].name");
        ignoreAsserts.add("list[0].outlets[0].prodGroupSummaries[0].id");
        ignoreAsserts.add("list[0].outlets[0].prodGroupSummaries[0].totalCount");
        ignoreAsserts.add("list[0].id");
        ignoreAsserts.add("list[0].category");

        BaseTest.assertEqual(ignoreAsserts, response, "list[0].defaultCurrency", "USD");
        BaseTest.assertEqual(ignoreAsserts, response, "list[0].imageUrl", "");
        BaseTest.assertEqual(ignoreAsserts, response, "list[0].taxCalculationsEnabled", "false");
        BaseTest.assertEqual(ignoreAsserts, response, "list[0].name", "OpenApi sdk-gen test");
        BaseTest.assertEqual(ignoreAsserts, response, "list[0].outlets[0].payAtTable", "false");
        BaseTest.assertEqual(ignoreAsserts, response, "list[0].outlets[0].address", "lalal, some city, Alabama");
        BaseTest.assertEqual(ignoreAsserts, response, "list[0].outlets[0].latitude", "1.0");
        BaseTest.assertEqual(ignoreAsserts, response, "list[0].outlets[0].isOpen", "true");
        BaseTest.assertEqual(ignoreAsserts, response, "list[0].outlets[0].merchantId", "143035");
        BaseTest.assertEqual(ignoreAsserts, response, "list[0].outlets[0].imageUrl", "");
        BaseTest.assertEqual(ignoreAsserts, response, "list[0].outlets[0].name", "lalal");
        BaseTest.assertEqual(ignoreAsserts, response, "list[0].outlets[0].id", "143042");
        BaseTest.assertEqual(ignoreAsserts, response, "list[0].outlets[0].longitude", "1.0");
        BaseTest.assertEqual(ignoreAsserts, response, "list[0].outlets[0].prodGroupSummaries[0].name", "my menu");
        BaseTest.assertEqual(ignoreAsserts, response, "list[0].outlets[0].prodGroupSummaries[0].id", "143051");
        BaseTest.assertEqual(ignoreAsserts, response, "list[0].outlets[0].prodGroupSummaries[0].totalCount", "1");
        BaseTest.assertEqual(ignoreAsserts, response, "list[0].id", "143035");
        BaseTest.assertEqual(ignoreAsserts, response, "list[0].category", "Cafe");
        BaseTest.assertEqual(ignoreAsserts, response, "list[0].pricesSetPretax", "false");

        BaseTest.putResponse("getMerchant", response);

    }




	@Test public void test_104_login() throws Exception {
		//
		
		
		RequestMap map = new RequestMap();
		map.set("emailAddress", "dekai.zhang@yahoo.com");
		map.set("password", "qwerty12");
		UserSession response = UserSession.create(map);

		List<String> ignoreAsserts = new ArrayList<String>();
		ignoreAsserts.add("accessToken.token");

		BaseTest.assertEqual(ignoreAsserts, response, "accessToken.expires", "1200");
		BaseTest.assertEqual(ignoreAsserts, response, "accessToken.token", "otk_NDQxN2E2ZTAtNjJkYy00M2ZjLWE1MGItNDMyYzdkYzQzNjM0");

		BaseTest.putResponse("login", response);
		
	}



	@Test public void test_131_Test__card_get() throws Exception {
		//


		RequestMap map = new RequestMap();
		map.set("X-Auth-Token", "from-login");
		map.set("X-Auth-Token", BaseTest.resolveResponseValue("login.accessToken.token"));
		Card response = Card.query(map);

		List<String> ignoreAsserts = new ArrayList<String>();


		BaseTest.putResponse("Test__card_get", response);

	}




	@Test public void test_136_createAuthPayment() throws Exception {
		//


		RequestMap map = new RequestMap();
		map.set("amount", 1000);
		map.set("outletId", "9146");
		map.set("cardId", "be10fa29-a787-4366-8a29-2e1573cc843c");
		map.set("X-Auth-Token", "from-login");
		map.set("X-Auth-Token", BaseTest.resolveResponseValue("login.accessToken.token"));
		map.set("cardId", BaseTest.resolveResponseValue("Test__card_get.list[0].id"));
		Auth response = Auth.create(map);

		List<String> ignoreAsserts = new ArrayList<String>();


		BaseTest.putResponse("createAuthPayment", response);

	}




    @Test public void test_138_createBeneficiary() throws Exception {
        //


        RequestMap map = new RequestMap();
        map.set("firstName", "John");
        map.set("lastName", "Smith");
        map.set("beneficiaryCustomFieldValues[0].bcfdValue", "1");
        map.set("beneficiaryCustomFieldValues[0].bcfdName", "Year");
        map.set("gender", "M");
        map.set("merchantId", "from-getMerchant");
        map.set("X-Auth-Token", "from-login");
        map.set("X-Auth-Token", BaseTest.resolveResponseValue("login.accessToken.token"));
        map.set("cardId", BaseTest.resolveResponseValue("addCard.id"));
        map.set("merchantId", BaseTest.resolveResponseValue("getMerchant.list[0].id"));
        Beneficiary response = Beneficiary.create(map);

        List<String> ignoreAsserts = new ArrayList<String>();
        ignoreAsserts.add("beneficiaryId");

        BaseTest.assertEqual(ignoreAsserts, response, "beneficiaryId", "9876");

        BaseTest.putResponse("createBeneficiary", response);

    }











    @Test public void test_139_getBeneficiary() throws Exception {
        //


        RequestMap map = new RequestMap();
        map.set("merchantId", "from-getMerchant");
        map.set("X-Auth-Token", "from-login");
        map.set("X-Auth-Token", BaseTest.resolveResponseValue("login.accessToken.token"));
        map.set("merchantId", BaseTest.resolveResponseValue("getMerchant.list[0].id"));
        Beneficiary response = Beneficiary.query(map);

        List<String> ignoreAsserts = new ArrayList<String>();
        ignoreAsserts.add("beneficiaryId");

        BaseTest.assertEqual(ignoreAsserts, response, "beneficiaries[0].firstName", "John");
        BaseTest.assertEqual(ignoreAsserts, response, "beneficiaries[0].lastName", "Smith");
        BaseTest.assertEqual(ignoreAsserts, response, "beneficiaries[0].gender", "M");

        BaseTest.putResponse("getBeneficiary", response);

    }


    @Test public void test_140_updateBeneficiary() throws Exception {
        //


        RequestMap map = new RequestMap();
        map.set("firstName", "Mike");
        map.set("lastName", "Smith");
        map.set("beneficiaryCustomFieldValues[0].bcfdValue", "1");
        map.set("beneficiaryCustomFieldValues[0].bcfdName", "Year");
        map.set("gender", "M");
        map.set("merchantId", "from-getMerchant");
        map.set("X-Auth-Token", "from-login");
        map.set("id", "from-createBeneficiary");
        map.set("X-Auth-Token", BaseTest.resolveResponseValue("login.accessToken.token"));
        map.set("id", BaseTest.resolveResponseValue("createBeneficiary.beneficiaryId"));
        map.set("merchantId", BaseTest.resolveResponseValue("getMerchant.list[0].id"));
        Beneficiary response = new Beneficiary(map).update();

        List<String> ignoreAsserts = new ArrayList<String>();
        ignoreAsserts.add("beneficiaryId");

        BaseTest.assertEqual(ignoreAsserts, response, "beneficiaryId", "1133");

        BaseTest.putResponse("updateBeneficiary", response);

    }










    @Test public void test_142_getBeneficiaryCustomField() throws Exception {
        //


        RequestMap map = new RequestMap();
        map.set("merchantId", "from.getMerchant");
        map.set("X-Auth-Token", "from-login");
        map.set("X-Auth-Token", BaseTest.resolveResponseValue("login.accessToken.token"));
        map.set("merchantId", BaseTest.resolveResponseValue("getMerchant.list[0].id"));
        BeneficiaryCustomField response = BeneficiaryCustomField.query(map);

        List<String> ignoreAsserts = new ArrayList<String>();
        ignoreAsserts.add("list[0].label");
        ignoreAsserts.add("list[0].type");
        ignoreAsserts.add("list[0].mandatory");
        ignoreAsserts.add("list[0].options[0]");

        BaseTest.assertEqual(ignoreAsserts, response, "list[0].label", "Year");
        BaseTest.assertEqual(ignoreAsserts, response, "list[0].type", "DROPDOWN");
        BaseTest.assertEqual(ignoreAsserts, response, "list[0].mandatory", "true");
        BaseTest.assertEqual(ignoreAsserts, response, "list[0].options[0]", "2015");

        BaseTest.putResponse("getBeneficiaryCustomField", response);

    }





    @Test public void test_143_getForm() throws Exception {
        //


        RequestMap map = new RequestMap();
        map.set("X-Auth-Token", "from-login");
        map.set("beneficiaryId", "334343");
        map.set("X-Auth-Token", BaseTest.resolveResponseValue("login.accessToken.token"));
        Form response = Form.read("168075", map);

        List<String> ignoreAsserts = new ArrayList<String>();
        ignoreAsserts.add("beneficiary.id");
        ignoreAsserts.add("formElements[0].id");
        ignoreAsserts.add("form.termsAndConditionsUrl");
        ignoreAsserts.add("form.id");
        ignoreAsserts.add("form.updatedDate");

        BaseTest.assertEqual(ignoreAsserts, response, "form.updatedDate", "1497584275785");
        BaseTest.assertEqual(ignoreAsserts, response, "formElements[0].type", "EmergencyContact");
        BaseTest.assertEqual(ignoreAsserts, response, "beneficiary.lastName", "Smith");
        BaseTest.assertEqual(ignoreAsserts, response, "beneficiary.firstName", "Mike");
        BaseTest.assertEqual(ignoreAsserts, response, "beneficiary.middleName", "");
        BaseTest.assertEqual(ignoreAsserts, response, "form.formName", "AU.m2.o1.d1.pg1.mi3");
        BaseTest.assertEqual(ignoreAsserts, response, "beneficiary.id", "1234");
        BaseTest.assertEqual(ignoreAsserts, response, "formElements[0].id", "123");
        BaseTest.assertEqual(ignoreAsserts, response, "formElements[0].required", "true");
        BaseTest.assertEqual(ignoreAsserts, response, "formElements[0].label", "Emergency Contact Name");
        BaseTest.assertEqual(ignoreAsserts, response, "form.formRequiresSignature", "false");
        BaseTest.assertEqual(ignoreAsserts, response, "form.isPaid", "false");
        BaseTest.assertEqual(ignoreAsserts, response, "form.termsAndConditionsUrl", "false");
        BaseTest.assertEqual(ignoreAsserts, response, "formElements[0].position", "0");
        BaseTest.assertEqual(ignoreAsserts, response, "form.id", "123456");
        BaseTest.assertEqual(ignoreAsserts, response, "beneficiary.gender", "M");
        BaseTest.assertEqual(ignoreAsserts, response, "formElements[0].value", "");

        BaseTest.putResponse("getForm", response);

    }


    @Test public void test_144_createFormSubmission() throws Exception {
        //


        RequestMap map = new RequestMap();
        map.set("formId", "168075");
        map.set("X-Auth-Token", "from-login");
        map.set("beneficiaryId", "from-createBeneficiary");
        map.set("formElements[0].id", "168076");
        map.set("formElements[0].value", "Form element value");
        map.set("X-Auth-Token", BaseTest.resolveResponseValue("login.accessToken.token"));
        map.set("beneficiaryId", BaseTest.resolveResponseValue("getBeneficiary.beneficiaries[0].id"));
        FormSubmission response = FormSubmission.create(map);

        List<String> ignoreAsserts = new ArrayList<String>();


        BaseTest.putResponse("createFormSubmission", response);

    }











    @Test public void test_145_getFormSubmission() throws Exception {
        //


        RequestMap map = new RequestMap();
        map.set("merchantId", "from-getMerchant");
        map.set("X-Auth-Token", "from-login");
        map.set("X-Auth-Token", BaseTest.resolveResponseValue("login.accessToken.token"));
        map.set("merchantId", BaseTest.resolveResponseValue("getMerchant.list[0].id"));
        FormSubmission response = FormSubmission.query(map);

        List<String> ignoreAsserts = new ArrayList<String>();
        ignoreAsserts.add("list[0].id");
        ignoreAsserts.add("list[0].submittedDate");
        ignoreAsserts.add("list[0].form.updatedDate");
        ignoreAsserts.add("list[0].beneficiaryId");

        BaseTest.assertEqual(ignoreAsserts, response, "list[0].id", "1234");
        BaseTest.assertEqual(ignoreAsserts, response, "list[0].form.formName", "AU.m2.o1.d1.pg1.mi3");
        BaseTest.assertEqual(ignoreAsserts, response, "list[0].beneficiaryName", "Mike Smith");
        BaseTest.assertEqual(ignoreAsserts, response, "list[0].prodGroupName", "AU.m2.o1.d1.pg1");
        BaseTest.assertEqual(ignoreAsserts, response, "list[0].form.id", "168075");
        BaseTest.assertEqual(ignoreAsserts, response, "list[0].beneficiaryId", "1234");
        BaseTest.assertEqual(ignoreAsserts, response, "list[0].merchantId", "9842");
        BaseTest.assertEqual(ignoreAsserts, response, "list[0].productDescription", "product");
        BaseTest.assertEqual(ignoreAsserts, response, "list[0].form.formRequiresSignature", "false");
        BaseTest.assertEqual(ignoreAsserts, response, "list[0].form.isPaid", "false");
        BaseTest.assertEqual(ignoreAsserts, response, "list[0].productImageUrl", "http://test.com/qkr/images/seeddata.png");
        BaseTest.assertEqual(ignoreAsserts, response, "list[0].merchantName", "AU.m2");
        BaseTest.assertEqual(ignoreAsserts, response, "list[0].paidBy", "false");
        BaseTest.assertEqual(ignoreAsserts, response, "list[0].productName", "AU.m2.o1.d1.pg1.mi3");
        BaseTest.assertEqual(ignoreAsserts, response, "list[0].submittedDate", "1525767162347");
        BaseTest.assertEqual(ignoreAsserts, response, "list[0].form.isConsentRequired", "true");
        BaseTest.assertEqual(ignoreAsserts, response, "list[0].form.updatedDate", "1525767162347");

        BaseTest.putResponse("getFormSubmission", response);

    }

    @Test public void test_149_postUserImage() throws Exception {
        //


        RequestMap map = new RequestMap();
        map.set("image", "iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAADUlEQVR42mP8z/C/HgAGgwJ/lK3Q6wAAAABJRU5ErkJggg==");
        map.set("format", "PNG");
        map.set("email", "dekai.zhang@gmail.com");
        UserImage response = UserImage.create(map);

        List<String> ignoreAsserts = new ArrayList<String>();


        BaseTest.putResponse("postUserImage", response);

    }









}
