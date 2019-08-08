package com.example.paytmpayment;

import com.paytm.pgsdk.PaytmOrder;

import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.ShortName;



@ShortName("PaytmOrder")
@Author("smm")
public class PaytmOrderWrapper extends AbsObjectWrapper<PaytmOrder>  {
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
    // private PaytmOrder obj;


    public void Initialize(BA ba , anywheresoftware.b4a.objects.collections.Map param) {
        _initialize(ba,  param);

    }

    @Hide
    public void _initialize(final BA ba,anywheresoftware.b4a.objects.collections.Map param) {
        this.ba = ba;


        // obj = new PaytmOrder(new java.util.HashMap<String, String>());
        java.util.HashMap<String, String> copy = new java.util.HashMap<String, String>(B4AMapToJMapString(param));
        PaytmOrder obj = new PaytmOrder(copy);
        this.setObject(obj);




    }





}

