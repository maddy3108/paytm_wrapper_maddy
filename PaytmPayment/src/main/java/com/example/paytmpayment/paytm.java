package com.example.paytmpayment;

import android.os.Bundle;
import android.util.AttributeSet;

import com.paytm.pgsdk.PaytmPGService;
import com.paytm.pgsdk.PaytmPaymentTransactionCallback;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ActivityObject;
import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.DependsOn;
import anywheresoftware.b4a.BA.Events;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BA.Version;
@Version(0.05f)
@ShortName("PaytmNew")
@Author("smm")
@Events(values={"_someuierroroccurred(inErrorMessage As String)","_ontransactionresponse(inResponse As Map)","_networknotavailable","_clientauthenticationfailed( inErrorMessage As String)","_onerrorloadingwebpage(iniErrorCode As Int ,  inErrorMessage As String,  inFailingUrl As String)","_onbackpressedcanceltransaction","_ontransactioncancel( inErrorMessage As String,inResponse As  Map )"})

@DependsOn(values={"pgplussdk-1.3.3.aar"})
@ActivityObject
public class paytm  {


    @SuppressWarnings("unchecked")

    java.util.Map<String, String> B4AMapToJMap(anywheresoftware.b4a.objects.collections.Map map) {
        return (java.util.Map)map.getObject();
    }
    java.util.Map<String, Object> B4AMapToJMapStringObject(anywheresoftware.b4a.objects.collections.Map map) {
        return (java.util.Map)map.getObject();
    }
    java.util.Map<String, String> B4AMapToJMapString(anywheresoftware.b4a.objects.collections.Map map) {
        return (java.util.Map)map.getObject();
    }
    anywheresoftware.b4a.objects.collections.Map JMapToB4AMap(java.util.Map<String, String> map) {
        anywheresoftware.b4a.objects.collections.Map m = new anywheresoftware.b4a.objects.collections.Map();
        m.Initialize();
        m.getObject().putAll(map);
        return m;
    }



    private BA ba;
    private PaytmPGService  Service;
    private String eventName;

    public void Initialize(BA ba , String EventName ,boolean testing) /* throws NoSuchAlgorithmException,NoSuchProviderException,NoSuchPaddingException */ {

        _initialize(ba,  EventName, testing);

    }

    @Hide
    public void _initialize(final BA ba,String EventName ,boolean testing) /* throws NoSuchAlgorithmException,NoSuchProviderException,NoSuchPaddingException */ {
        this.ba = ba;
        this.eventName = EventName.toLowerCase(BA.cul);



        if (testing){
            Service = PaytmPGService.getStagingService();
        }
        else{
            Service = PaytmPGService.getProductionService();
        }





        if (eventName.length()>0) {
            //set some listener click .. etc
            // getObject().

        }
    }




    public void InitiatePayment(PaytmOrderWrapper order,PaytmClientCertificateWrapper cert){
        if (cert.IsInitialized()) {
            Service.initialize(order.getObject(), cert.getObject());
        }
        else{
            Service.initialize(order.getObject(), null);
        }

        Service.startPaymentTransaction(ba.activity, true, true, new PaytmPaymentTransactionCallback() {
            /*Call Backs*/
            public void someUIErrorOccurred(String inErrorMessage) {

                ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_someuierroroccurred", true, new Object[]{inErrorMessage});
            }
            public void onTransactionResponse(Bundle inResponse) {
                anywheresoftware.b4a.objects.collections.Map mr = new anywheresoftware.b4a.objects.collections.Map();
                mr.Initialize();

                java.util.Set<String> keys = inResponse.keySet();
                for (String key : keys) {


                    mr.getObject().put(key,inResponse.get(key));
                }

                ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_ontransactionresponse", true, new Object[]{mr});
            }
            public void networkNotAvailable() {

                ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_networknotavailable", true, new Object[0]);
            }
            public void clientAuthenticationFailed(String inErrorMessage) {

                ba.raiseEventFromDifferentThread(this, null, 0, eventName + "_clientauthenticationfailed", true, new Object[]{inErrorMessage});
            }
            public void onErrorLoadingWebPage(int iniErrorCode, String inErrorMessage, String inFailingUrl) {


                ba.raiseEventFromDifferentThread(this, null, 0,eventName+"_onerrorloadingwebpage" , true, new Object[]{iniErrorCode,inErrorMessage,inFailingUrl});
            }
            public void onBackPressedCancelTransaction() {

                ba.raiseEventFromDifferentThread(this, null, 0,eventName+"_onbackpressedcanceltransaction" , true, new Object[0] );

            }
            public void onTransactionCancel(String inErrorMessage, Bundle inResponse) {
                anywheresoftware.b4a.objects.collections.Map mrr = new anywheresoftware.b4a.objects.collections.Map();
                mrr.Initialize();

                java.util.Set<String> keys = inResponse.keySet();
                for (String key : keys) {


                    mrr.getObject().put(key,inResponse.get(key));
                }

                ba.raiseEventFromDifferentThread(this, null, 0,eventName+"_ontransactioncancel" , true, new Object[]{inErrorMessage,mrr});

            }
        });
    }



}

