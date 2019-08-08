package com.example.paytmpayment;

import com.paytm.pgsdk.PaytmClientCertificate;

import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.ShortName;



@ShortName("PaytmClientCertificate")
@Author("smm")
public class PaytmClientCertificateWrapper extends AbsObjectWrapper<PaytmClientCertificate>  {


    private BA ba;
    private PaytmClientCertificate obj;


    public void Initialize(BA ba ,String inPassword, String inFileName) {
        _initialize(ba, inPassword, inFileName);

    }

    @Hide
    public void _initialize(final BA ba,String inPassword, String inFileName) {
        this.ba = ba;


        obj = new PaytmClientCertificate(inPassword,inFileName);
        this.setObject(obj);




    }





}

