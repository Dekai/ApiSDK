package com.dk.api.helloworld;

import com.mastercard.api.core.ApiConfig;
import com.mastercard.api.core.exception.ApiException;
import com.mastercard.api.core.model.RequestMap;
import com.mastercard.api.core.security.oauth.OAuthAuthentication;
import com.mastercard.api.qkr.Merchant;
import com.mastercard.api.qkr.ProdGroup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class DKTest {
    public static void main(String[] args) {
        initializeSdk();
        try {
            String merchantId = queryMerchants();
            String prodGroupId = getMerchant(merchantId);
            getProductGroup(prodGroupId);
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

    static void initializeSdk() {
        try {
            String consumerKey = "8t0FW9gUOZiwEWrTUP3PKpw2KEaBecadSJ75UcqD61467422!edf9eaffc20c41a1a6664ac5550d725c0000000000000000";   // You should copy this from "My Keys" on your project page e.g. UTfbhDCSeNYvJpLL5l028sWL9it739PYh6LU5lZja15xcRpY!fd209e6c579dc9d7be52da93d35ae6b6c167c174690b72fa
            String keyAlias = "keyalias";   // For production: change this to the key alias you chose when you created your production key
            String keyPassword = "keystorepassword";   // For production: change this to the key alias you chose when you created your production key
            InputStream is = new FileInputStream("QkrOpenAPITest-1519617044-sandbox.p12"); // e.g. /Users/yourname/project/sandbox.p12 | C:\Users\yourname\project\sandbox.p12
            ApiConfig.setAuthentication(new OAuthAuthentication(consumerKey, is, keyAlias, keyPassword));   // You only need to set this once
            ApiConfig.setDebug(true);   // Enable http wire logging
            ApiConfig.setSandbox(true); // For production: use ApiConfig.setSandbox(false);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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
}
