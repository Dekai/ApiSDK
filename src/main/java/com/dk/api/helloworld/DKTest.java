package com.dk.api.helloworld;

import com.mastercard.api.core.ApiConfig;
import com.mastercard.api.core.exception.ApiException;
import com.mastercard.api.core.model.Environment;
import com.mastercard.api.core.model.RequestMap;
import com.mastercard.api.core.model.map.CaseInsensitiveSmartMap;
import com.mastercard.api.core.model.map.SmartMap;
import com.mastercard.api.core.security.oauth.OAuthAuthentication;
import com.mastercard.api.qkr.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DKTest {
    public static void main(String[] args) {
        initializeSandboxSdk();
//        initializeProdSdk();
//        initializeStageSdk();
//        initializeStageSBXSdk();
        try {
//                getSecurityQuestion();
//            getCountry();
//            UserSession userSession = getUserSession();
//             String accessToken = userSession.get("accessToken.token").toString();
            String merchantId = queryMerchants();
//            String prodGroupId = getMerchant(merchantId);
//            getProductGroup(prodGroupId);
//            getMachine("Mzl3mGWnYy");
//              createVendingSession(accessToken);
//            deleteVendingSession(accessToken);
//            createPosOrder();
//            updatePosOrder();
//            queryCard(accessToken);
//            String accessToken = createNotionalUser();
//            getUser(accessToken);
//            postUserImage();
//            deleteUserImage();
            //SNG school - 410727
//            createBeneficiary(accessToken, "410727");
//            createLightbox(accessToken);
        } catch (Exception ex) {
            if (ex instanceof ApiException) {
                ApiException e = (ApiException) ex;
                System.err.println("HttpStatus: " + e.getHttpStatus());
                System.err.println("Message: " + e.getMessage());
                System.err.println("ReasonCode: " + e.getReasonCode());
                System.err.println("Source: " + e.getSource());
            } else {
                ex.printStackTrace();
            }
        }

    }

    static void initializeSandboxSdk() {
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

    static void initializeStageSdk() {
        try {
            String consumerKey = "jQUlxdpHDwJ006khkmND8COn751MnXFAaWwHDo3id34aaa9f!12c71766fc35473a965292b5863ceec20000000000000000";   // You should copy this from "My Keys" on your project page e.g. UTfbhDCSeNYvJpLL5l028sWL9it739PYh6LU5lZja15xcRpY!fd209e6c579dc9d7be52da93d35ae6b6c167c174690b72fa
            String keyAlias = "ProdAlias";   // For production: change this to the key alias you chose when you created your production key
            String keyPassword = "Qwerty12";   // For production: change this to the key alias you chose when you created your production key
            InputStream is = new FileInputStream("ProdAlias-production.p12"); // e.g. /Users/yourname/project/sandbox.p12 | C:\Users\yourname\project\sandbox.p12
            ApiConfig.setAuthentication(new OAuthAuthentication(consumerKey, is, keyAlias, keyPassword));   // You only need to set this once
            ApiConfig.setDebug(true);   // Enable http wire logging
//            ApiConfig.setSandbox(true); // For production: use ApiConfig.setSandbox(false);
            ApiConfig.setEnvironment(Environment.STAGE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static void initializeStageSBXSdk() {
        try {
            String consumerKey = "dDZ4EkHRHE4vBRK2BvHbZaO22uNMcbYFLQ_oJOSN16840b80!85919e54b3b145efa79ba2f7f3758e920000000000000000";   // You should copy this from "My Keys" on your project page e.g. UTfbhDCSeNYvJpLL5l028sWL9it739PYh6LU5lZja15xcRpY!fd209e6c579dc9d7be52da93d35ae6b6c167c174690b72fa
            String keyAlias = "SBXAlias";   // For production: change this to the key alias you chose when you created your production key
            String keyPassword = "Qwerty12";   // For production: change this to the key alias you chose when you created your production key
            InputStream is = new FileInputStream("Stage_SBXAlias-sandbox.p12"); // e.g. /Users/yourname/project/sandbox.p12 | C:\Users\yourname\project\sandbox.p12
            ApiConfig.setAuthentication(new OAuthAuthentication(consumerKey, is, keyAlias, keyPassword));   // You only need to set this once
            ApiConfig.setDebug(true);   // Enable http wire logging
            ApiConfig.setSandbox(true); // For production: use ApiConfig.setSandbox(false);
            ApiConfig.setEnvironment(Environment.STAGE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static void initializeProdSdk() {
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

    static String createNotionalUser() throws ApiException {
        RequestMap map = new RequestMap();
        map.put("externalUserId", "abce123");

        User user = User.create(map);

        String userId = user.get("internalAccountId").toString();
        String accessToken = user.get("accessToken.token").toString();

        System.out.println("User Id" + userId);
        System.out.println("accessToken" + accessToken);

        return accessToken;
    }

    static void getUser(String accessToken) throws ApiException{
        RequestMap map = new RequestMap();
        map.set("X-Auth-Token", accessToken);

        User user = User.query(map);

        System.out.println("User Notional" + user.get("notional").toString());
    }

    static UserSession getUserSession() throws ApiException {
        RequestMap map = new RequestMap();
        map.set("emailAddress", "dekai.zhang@gmail.com");
        map.set("password", "qwerty12");
        UserSession response = UserSession.create(map);

        return response;
    }

    static void getCountry() throws ApiException {
        Country response = Country.read("HK");
        System.out.println(response);
    }

    static void getSecurityQuestion() throws ApiException {
        RequestMap map = new RequestMap();
        SecurityQuestion response = SecurityQuestion.query(map);
        System.out.println(response.get("list[0].text"));
    }

    static String queryMerchants() throws ApiException {
        RequestMap map = new RequestMap();

        Merchant response = Merchant.query(map);
        System.out.println("list[0].id-->" + response.get("list[0].id")); // list[0].id-->143035
        System.out.println("list[0].pricesSetPretax-->" + response.get("list[0].pricesSetPretax")); // list[0].pricesSetPretax-->false
        System.out.println("list[0].category-->" + response.get("list[0].category")); // list[0].category-->Cafe
        System.out.println("list[0].taxCalculationsEnabled-->" + response.get("list[0].taxCalculationsEnabled")); // list[0].taxCalculationsEnabled-->false
        System.out.println("list[0].imageUrl-->" + response.get("list[0].imageUrl")); // list[0].imageUrl-->
        System.out.println("list[0].defaultCurrency-->" + response.get("list[0].defaultCurrency")); // list[0].defaultCurrency-->USD
        System.out.println("list[0].name-->" + response.get("list[0].name")); // list[0].name-->OpenApi sdk-gen test
        System.out.println("list[0].outlets[0].imageUrl-->" + response.get("list[0].outlets[0].imageUrl")); // list[0].outlets[0].imageUrl-->
        System.out.println("list[0].outlets[0].payAtTable-->" + response.get("list[0].outlets[0].payAtTable")); // list[0].outlets[0].payAtTable-->false
        System.out.println("list[0].outlets[0].isOpen-->" + response.get("list[0].outlets[0].isOpen")); // list[0].outlets[0].isOpen-->true
        System.out.println("list[0].outlets[0].id-->" + response.get("list[0].outlets[0].id")); // list[0].outlets[0].id-->143042
        System.out.println("list[0].outlets[0].address-->" + response.get("list[0].outlets[0].address")); // list[0].outlets[0].address-->lalal, some city, Alabama
        System.out.println("list[0].outlets[0].name-->" + response.get("list[0].outlets[0].name")); // list[0].outlets[0].name-->lalal
        System.out.println("list[0].outlets[0].longitude-->" + response.get("list[0].outlets[0].longitude")); // list[0].outlets[0].longitude-->1.0
        System.out.println("list[0].outlets[0].merchantId-->" + response.get("list[0].outlets[0].merchantId")); // list[0].outlets[0].merchantId-->143035
        System.out.println("list[0].outlets[0].latitude-->" + response.get("list[0].outlets[0].latitude")); // list[0].outlets[0].latitude-->1.0
        System.out.println("list[0].outlets[0].prodGroupSummaries[0].id-->" + response.get("list[0].outlets[0].prodGroupSummaries[0].id")); // list[0].outlets[0].prodGroupSummaries[0].id-->143051
        System.out.println("list[0].outlets[0].prodGroupSummaries[0].totalCount-->" + response.get("list[0].outlets[0].prodGroupSummaries[0].totalCount")); // list[0].outlets[0].prodGroupSummaries[0].totalCount-->1
        System.out.println("list[0].outlets[0].prodGroupSummaries[0].name-->" + response.get("list[0].outlets[0].prodGroupSummaries[0].name")); // list[0].outlets[0].prodGroupSummaries[0].name-->my menu

        return response.get("list[0].id").toString();
    }

    static String getMerchant(String merchantId) throws ApiException {
        Merchant response = Merchant.read(merchantId);

        System.out.println("id-->" + response.get("id")); // id-->143035
        System.out.println("pricesSetPretax-->" + response.get("pricesSetPretax")); // pricesSetPretax-->false
        System.out.println("category-->" + response.get("category")); // category-->Cafe
        System.out.println("taxCalculationsEnabled-->" + response.get("taxCalculationsEnabled")); // taxCalculationsEnabled-->false
        System.out.println("imageUrl-->" + response.get("imageUrl")); // imageUrl-->
        System.out.println("defaultCurrency-->" + response.get("defaultCurrency")); // defaultCurrency-->USD
        System.out.println("name-->" + response.get("name")); // name-->OpenApi sdk-gen test
        System.out.println("outlets[0].imageUrl-->" + response.get("outlets[0].imageUrl")); // outlets[0].imageUrl-->
        System.out.println("outlets[0].payAtTable-->" + response.get("outlets[0].payAtTable")); // outlets[0].payAtTable-->false
        System.out.println("outlets[0].isOpen-->" + response.get("outlets[0].isOpen")); // outlets[0].isOpen-->true
        System.out.println("outlets[0].id-->" + response.get("outlets[0].id")); // outlets[0].id-->143042
        System.out.println("outlets[0].address-->" + response.get("outlets[0].address")); // outlets[0].address-->lalal, some city, Alabama
        System.out.println("outlets[0].name-->" + response.get("outlets[0].name")); // outlets[0].name-->lalal
        System.out.println("outlets[0].longitude-->" + response.get("outlets[0].longitude")); // outlets[0].longitude-->1.0
        System.out.println("outlets[0].merchantId-->" + response.get("outlets[0].merchantId")); // outlets[0].merchantId-->143035
        System.out.println("outlets[0].latitude-->" + response.get("outlets[0].latitude")); // outlets[0].latitude-->1.0
        System.out.println("outlets[0].prodGroupSummaries[0].id-->" + response.get("outlets[0].prodGroupSummaries[0].id")); // outlets[0].prodGroupSummaries[0].id-->143051
        System.out.println("outlets[0].prodGroupSummaries[0].totalCount-->" + response.get("outlets[0].prodGroupSummaries[0].totalCount")); // outlets[0].prodGroupSummaries[0].totalCount-->1
        System.out.println("outlets[0].prodGroupSummaries[0].name-->" + response.get("outlets[0].prodGroupSummaries[0].name")); // outlets[0].prodGroupSummaries[0].name-->my menu

        return response.get("outlets[0].prodGroupSummaries[0].id").toString();
    }

    static void getProductGroup(String id) throws ApiException {
        ProdGroup response = ProdGroup.read(id);

        System.out.println("shippingRequired-->"+response.get("shippingRequired")); // shippingRequired-->true
        System.out.println("ageRestrictedMessage-->"+response.get("ageRestrictedMessage")); // ageRestrictedMessage-->To purchase this product, please confirm that you are over %d years of age.
        System.out.println("merchantLocId-->"+response.get("merchantLocId")); // merchantLocId-->143043
        System.out.println("id-->"+response.get("id")); // id-->143051
        System.out.println("transactionType-->"+response.get("transactionType")); // transactionType-->BUY
        System.out.println("title-->"+response.get("title")); // title-->my menu
        System.out.println("merchantName-->"+response.get("merchantName")); // merchantName-->OpenApi sdk-gen test
        System.out.println("merchantId-->"+response.get("merchantId")); // merchantId-->143035
        System.out.println("unitPricePreTax-->"+response.get("unitPricePreTax")); // unitPricePreTax-->true
        System.out.println("locatedScanId-->"+response.get("locatedScanId")); // locatedScanId-->143052
        System.out.println("products[0].id-->"+response.get("products[0].id")); // products[0].id-->143053
        System.out.println("products[0].category-->"+response.get("products[0].category")); // products[0].category-->drink
        System.out.println("products[0].description-->"+response.get("products[0].description")); // products[0].description-->
        System.out.println("products[0].name-->"+response.get("products[0].name")); // products[0].name-->tea
        System.out.println("products[0].smallDescription-->"+response.get("products[0].smallDescription")); // products[0].smallDescription-->
        System.out.println("products[0].shippingAddressRequired-->"+response.get("products[0].shippingAddressRequired")); // products[0].shippingAddressRequired-->true
        System.out.println("products[0].variants[0].id-->"+response.get("products[0].variants[0].id")); // products[0].variants[0].id-->143054
        System.out.println("products[0].variants[0].isDefault-->"+response.get("products[0].variants[0].isDefault")); // products[0].variants[0].isDefault-->true
        System.out.println("products[0].variants[0].priority-->"+response.get("products[0].variants[0].priority")); // products[0].variants[0].priority-->0
        System.out.println("products[0].variants[0].amountMinorUnits-->"+response.get("products[0].variants[0].amountMinorUnits")); // products[0].variants[0].amountMinorUnits-->200
        System.out.println("products[0].variants[0].sku-->"+response.get("products[0].variants[0].sku")); // products[0].variants[0].sku-->ba01dafe-efbf-4d4b-af34-10d06497351d
        System.out.println("products[0].variants[0].stockLevel-->"+response.get("products[0].variants[0].stockLevel")); // products[0].variants[0].stockLevel-->N
        System.out.println("products[0].variants[0].currency-->"+response.get("products[0].variants[0].currency")); // products[0].variants[0].currency-->false
        System.out.println("products[0].mediumImageUrl-->"+response.get("products[0].mediumImageUrl")); // products[0].mediumImageUrl-->https://d1wfs5jdtdt7am.cloudfront.net/mss/product-placeholder.png
        System.out.println("products[0].allowPurchaseNote-->"+response.get("products[0].allowPurchaseNote")); // products[0].allowPurchaseNote-->true
        System.out.println("merchantWideImageUrl-->"+response.get("merchantWideImageUrl")); // merchantWideImageUrl-->
    }

    static void getMachine(String id) throws ApiException {
        Machine response = Machine.read(id);

        out(response, "hasExpressCheckoutPermission"); //-->true
        out(response, "merchantId"); //-->10019
        out(response, "currency"); //-->SGD
        out(response, "model"); //-->Auresys
        out(response, "merchantCountry"); //-->SG

    }

    static void getCards(String token) throws ApiException {
        RequestMap map = new RequestMap();
        map.set("X-Auth-Token", token);

        Card response = Card.query(map);
        System.out.print("Card response =" + response);
    }


    static void createVendingSession(String token) throws ApiException {
        RequestMap map = new RequestMap();
        map.set("machineId", "3Q0qoPPYkg");
        map.set("X-Auth-Token", token);
        map.set("cardId", "from-addCard");
        VendingSession response = VendingSession.create(map);

        out(response, "sessionRefId"); //-->vendingSession_sessionRefId_123
        out(response, "sessionStatus"); //-->Engaged
        out(response, "id"); //-->vendingSession_123
    }

    static void deleteVendingSession(String token) throws ApiException {
        RequestMap map = new RequestMap();
        map.set("X-Auth-Token", token);
        VendingSession response = VendingSession.delete("from-createVendingSession", map);
    }

    static void createPosOrder() throws ApiException {
        RequestMap map = new RequestMap();
        map.set("shortReference", "1234");
        map.set("outletId", "1234");
        PosOrder response = PosOrder.create(map);
    }

    static void updatePosOrder() throws ApiException {
        RequestMap map = new RequestMap();
        map.set("id", "from-createPosOrder");
        map.set("order.reference", "qkr_reference");
        map.set("order.amounts.autoServiceChargeMinorUnits", "0");
        map.set("order.amounts.amountDueMinorUnits", "1000");
        map.set("order.amounts.discounts[0].amount", 0);
        map.set("order.amounts.discounts[0].code", "");
        map.set("order.amounts.discounts[0].quantity", 0);
        map.set("order.amounts.discounts[0].name", "");
        map.set("order.amounts.discounts[0].type", "");
        map.set("order.amounts.otherServiceChargeMinorUnits", "0");
        map.set("order.amounts.payments[0].amount", 0);
        map.set("order.amounts.payments[0].code", "payment_code_123");
        map.set("order.amounts.payments[0].paymentType", "qkr");
        map.set("order.amounts.subtotalMinorUnits", "0");
        map.set("order.amounts.tipPaidMinorUnits", "0");
        map.set("order.amounts.paymentMinorUnits", "0");
        map.set("order.amounts.taxMinorUnits", "0");
        map.set("order.shouldAutoCharge", false);
        map.set("order.isOrderClosed", false);
        map.set("order.menuItems[0].isDiscounted", true);
        map.set("order.menuItems[0].groupName", "menuItem_GroupName");
        map.set("order.menuItems[0].isRefunded", false);
        map.set("order.menuItems[0].itemCode", "itemCode_123");
        map.set("order.menuItems[0].priceMinorUnits", 0);
        map.set("order.menuItems[0].isCondiment", true);
        map.set("order.menuItems[0].name", "Latte");
        map.set("order.menuItems[0].description", "string");
        map.set("order.menuItems[0].originalPriceMinorUnits", 0);
        PosOrder response = new PosOrder(map).update();

        out(response, "message"); //-->Update successfully
    }

    static void queryCard(String accessToken) throws ApiException{
        RequestMap map = new RequestMap();
        map.set("X-Auth-Token", accessToken);

        Card response = Card.query(map);

        out(response,"list");
    }

    static void postUserImage() throws Exception {

        RequestMap map = new RequestMap();
        map.set("image", "iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAADUlEQVR42mP8z/C/HgAGgwJ/lK3Q6wAAAABJRU5ErkJggg==");
        map.set("format", "PNG");
        map.set("email", "dekai.zhang@gmail.com");
        UserImage response = UserImage.create(map);

    }

    static void createBeneficiary(String token, String merchantId) throws Exception{
        Map beneficiaryCustomerFiled = new HashMap();
        beneficiaryCustomerFiled.put("bcfdName", "Year");
        beneficiaryCustomerFiled.put("bcfdValue", "2013");

        Map beneficiaryCustomerFiled1 = new HashMap();
        beneficiaryCustomerFiled1.put("bcfdName", "Class");
        beneficiaryCustomerFiled1.put("bcfdValue", "P1");

        List beneficiaryCustomFieldValues = new ArrayList();
        beneficiaryCustomFieldValues.add(beneficiaryCustomerFiled);
        beneficiaryCustomFieldValues.add(beneficiaryCustomerFiled1);

        RequestMap map = new RequestMap();
        map.set("firstName", "YY");
        map.set("lastName", "Zhang");
        map.set("gender", "F");
//        map.set("beneficiaryCustomFieldValues[0].bcfdValue", "1");
//        map.set("beneficiaryCustomFieldValues[0].bcfdName", "Year");
        map.set("beneficiaryCustomFieldValues", beneficiaryCustomFieldValues);
        map.set("X-Auth-Token", token);
        map.set("merchantId", merchantId);
        Beneficiary response = Beneficiary.create(map);
        System.out.print(response);
    }

    static void createLightbox(String accessToken) throws Exception{

        RequestMap map = new RequestMap();
        map.set("X-Auth-Token", accessToken);
        map.set("countryOfResidence", "US");
        map.set("action", "SIGN_FORM");
        map.set("callbackUrl", "apiapp://qkrLightbox");
        map.set("merchantId", "410727");
        map.set("formId", "410770");
        map.set("beneficiaryId", "414619");

        Lightbox response = Lightbox.create(map);
        System.out.print(response.get("url"));
    }

    static void LBX_SignForm(RequestMap map) {
        map.set("action", "SIGN_FORM");
        map.set("callbackUrl", "apiapp://qkrLightbox");
        map.set("merchantId", "410727");
        map.set("formId", "410770");
        map.set("beneficiaryId", "414619");
    }

    static void deleteUserImage() throws Exception {
        RequestMap map = new RequestMap();
        UserImage response = UserImage.delete("dekai.zhang@yahoo.com");

    }

    public static void out(SmartMap response, String key) {
        System.out.println(key+"-->"+response.get(key));
    }

    public static void out(Map<String,Object> map, String key) {
        System.out.println(key+"--->"+map.get(key));
    }

    public static void err(String message) {
        System.err.println(message);
    }
}
