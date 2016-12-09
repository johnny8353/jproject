/**
 * CMS_APP_SyncContractInfoServiceHttpBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.johnny.monitor.business.webservice.cms;

public class CMS_APP_SyncContractInfoServiceHttpBindingStub extends org.apache.axis.client.Stub implements com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoServicePortType {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[21];
        _initOperationDesc1();
        _initOperationDesc2();
        _initOperationDesc3();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getShipmentsDtails");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP_SyncContractInfoRequest"), com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoRequest.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP12_GetShipmentsDtailsResponse"));
        oper.setReturnClass(com.johnny.monitor.business.webservice.cms.CMS_APP12_GetShipmentsDtailsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "out"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getReceiptOutline");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP_SyncContractInfoRequest"), com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoRequest.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP10_GetReceiptOutlineResponse"));
        oper.setReturnClass(com.johnny.monitor.business.webservice.cms.CMS_APP10_GetReceiptOutlineResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "out"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getConDeliveryTermsInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP_SyncContractInfoRequest"), com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoRequest.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP04_GetConDeliveryTermsInfoResponse"));
        oper.setReturnClass(com.johnny.monitor.business.webservice.cms.CMS_APP04_GetConDeliveryTermsInfoResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "out"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getCustomerConInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP_SyncContractInfoRequest"), com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoRequest.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP08_GetCustomerConInfoResponse"));
        oper.setReturnClass(com.johnny.monitor.business.webservice.cms.CMS_APP08_GetCustomerConInfoResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "out"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getReceiptInfoList");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP_SyncContractInfoRequest"), com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoRequest.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP10_GetReceiptInfoListResponse"));
        oper.setReturnClass(com.johnny.monitor.business.webservice.cms.CMS_APP10_GetReceiptInfoListResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "out"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getContractOutline");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP_SyncContractInfoRequest"), com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoRequest.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP14_GetContractOutlineResponse"));
        oper.setReturnClass(com.johnny.monitor.business.webservice.cms.CMS_APP14_GetContractOutlineResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "out"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getProjectToContractSum");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP_ContractInfoRequest"), com.johnny.monitor.business.webservice.cms.CMS_APP_ContractInfoRequest.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP17_GetPrjContractInfoResponse"));
        oper.setReturnClass(com.johnny.monitor.business.webservice.cms.CMS_APP17_GetPrjContractInfoResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "out"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getContractPayTermsInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP_SyncContractInfoRequest"), com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoRequest.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP03_GetContractPayTermsInfoResponse"));
        oper.setReturnClass(com.johnny.monitor.business.webservice.cms.CMS_APP03_GetContractPayTermsInfoResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "out"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getShipmentsOutline");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP_SyncContractInfoRequest"), com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoRequest.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP11_GetShipmentsInfoListResponse"));
        oper.setReturnClass(com.johnny.monitor.business.webservice.cms.CMS_APP11_GetShipmentsInfoListResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "out"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getContractMainInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP_SyncContractInfoRequest"), com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoRequest.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP13_GetContractMainInfoResponse"));
        oper.setReturnClass(com.johnny.monitor.business.webservice.cms.CMS_APP13_GetContractMainInfoResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "out"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getAfterSalesTermsInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP_SyncContractInfoRequest"), com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoRequest.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP05_GetAfterSalesTermsInfoResponse"));
        oper.setReturnClass(com.johnny.monitor.business.webservice.cms.CMS_APP05_GetAfterSalesTermsInfoResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "out"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getShipmentsInfoList");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP_SyncContractInfoRequest"), com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoRequest.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP11_GetShipmentsInfoListResponse"));
        oper.setReturnClass(com.johnny.monitor.business.webservice.cms.CMS_APP11_GetShipmentsInfoListResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "out"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getContractStatusList");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP18_SyncContractInfoRequest"), com.johnny.monitor.business.webservice.cms.CMS_APP18_SyncContractInfoRequest.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP18_GetContractStatusListResponse"));
        oper.setReturnClass(com.johnny.monitor.business.webservice.cms.CMS_APP18_GetContractStatusListResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "out"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("searchContractInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP_SyncContractInfoRequest"), com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoRequest.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP01_SearchContractInfoResponse"));
        oper.setReturnClass(com.johnny.monitor.business.webservice.cms.CMS_APP01_SearchContractInfoResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "out"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[13] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getContractProgressInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP_SyncContractInfoRequest"), com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoRequest.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP06_GetContractProgressInfoResponse"));
        oper.setReturnClass(com.johnny.monitor.business.webservice.cms.CMS_APP06_GetContractProgressInfoResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "out"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[14] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getInvoiceOutline");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP_SyncContractInfoRequest"), com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoRequest.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP09_GetInvoiceOutlineResponse"));
        oper.setReturnClass(com.johnny.monitor.business.webservice.cms.CMS_APP09_GetInvoiceOutlineResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "out"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[15] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getRoleMember");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP_SyncContractInfoRequest"), com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoRequest.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP15_GetRoleMemberResponse"));
        oper.setReturnClass(com.johnny.monitor.business.webservice.cms.CMS_APP15_GetRoleMemberResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "out"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[16] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getProjectToContractList");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP_ContractInfoRequest"), com.johnny.monitor.business.webservice.cms.CMS_APP_ContractInfoRequest.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP17_GetPrjContractInfoResponse"));
        oper.setReturnClass(com.johnny.monitor.business.webservice.cms.CMS_APP17_GetPrjContractInfoResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "out"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[17] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getInvoiceInfoList");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP_SyncContractInfoRequest"), com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoRequest.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP09_GetInvoiceInfoListResponse"));
        oper.setReturnClass(com.johnny.monitor.business.webservice.cms.CMS_APP09_GetInvoiceInfoListResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "out"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[18] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getPrjContractInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP_SyncContractInfoRequest"), com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoRequest.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP07_GetPrjContractInfoResponse"));
        oper.setReturnClass(com.johnny.monitor.business.webservice.cms.CMS_APP07_GetPrjContractInfoResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "out"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[19] = oper;

    }

    private static void _initOperationDesc3(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getContractBasicInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP_SyncContractInfoRequest"), com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoRequest.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP02_GetContractBasicInfoResponse"));
        oper.setReturnClass(com.johnny.monitor.business.webservice.cms.CMS_APP02_GetContractBasicInfoResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "out"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[20] = oper;

    }

    public CMS_APP_SyncContractInfoServiceHttpBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public CMS_APP_SyncContractInfoServiceHttpBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public CMS_APP_SyncContractInfoServiceHttpBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "ArrayOfCMS_APP01_OutputItem");
            cachedSerQNames.add(qName);
            cls = com.johnny.monitor.business.webservice.cms.CMS_APP01_OutputItem[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP01_OutputItem");
            qName2 = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP01_OutputItem");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "ArrayOfCMS_APP03_OutputItem");
            cachedSerQNames.add(qName);
            cls = com.johnny.monitor.business.webservice.cms.CMS_APP03_OutputItem[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP03_OutputItem");
            qName2 = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP03_OutputItem");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "ArrayOfCMS_APP04_OutputItem");
            cachedSerQNames.add(qName);
            cls = com.johnny.monitor.business.webservice.cms.CMS_APP04_OutputItem[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP04_OutputItem");
            qName2 = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP04_OutputItem");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "ArrayOfCMS_APP05_OutputItem");
            cachedSerQNames.add(qName);
            cls = com.johnny.monitor.business.webservice.cms.CMS_APP05_OutputItem[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP05_OutputItem");
            qName2 = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP05_OutputItem");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "ArrayOfCMS_APP06_OutputItem");
            cachedSerQNames.add(qName);
            cls = com.johnny.monitor.business.webservice.cms.CMS_APP06_OutputItem[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP06_OutputItem");
            qName2 = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP06_OutputItem");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "ArrayOfCMS_APP07_OutputItem");
            cachedSerQNames.add(qName);
            cls = com.johnny.monitor.business.webservice.cms.CMS_APP07_OutputItem[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP07_OutputItem");
            qName2 = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP07_OutputItem");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "ArrayOfCMS_APP08_OutputItem");
            cachedSerQNames.add(qName);
            cls = com.johnny.monitor.business.webservice.cms.CMS_APP08_OutputItem[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP08_OutputItem");
            qName2 = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP08_OutputItem");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "ArrayOfCMS_APP09_OutputItem");
            cachedSerQNames.add(qName);
            cls = com.johnny.monitor.business.webservice.cms.CMS_APP09_OutputItem[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP09_OutputItem");
            qName2 = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP09_OutputItem");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "ArrayOfCMS_APP10_OutputItem");
            cachedSerQNames.add(qName);
            cls = com.johnny.monitor.business.webservice.cms.CMS_APP10_OutputItem[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP10_OutputItem");
            qName2 = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP10_OutputItem");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "ArrayOfCMS_APP11_OutputItem");
            cachedSerQNames.add(qName);
            cls = com.johnny.monitor.business.webservice.cms.CMS_APP11_OutputItem[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP11_OutputItem");
            qName2 = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP11_OutputItem");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "ArrayOfCMS_APP12_OutputItem");
            cachedSerQNames.add(qName);
            cls = com.johnny.monitor.business.webservice.cms.CMS_APP12_OutputItem[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP12_OutputItem");
            qName2 = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP12_OutputItem");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "ArrayOfCMS_APP13_OutputItem");
            cachedSerQNames.add(qName);
            cls = com.johnny.monitor.business.webservice.cms.CMS_APP13_OutputItem[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP13_OutputItem");
            qName2 = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP13_OutputItem");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "ArrayOfCMS_APP15_OutputItem");
            cachedSerQNames.add(qName);
            cls = com.johnny.monitor.business.webservice.cms.CMS_APP15_OutputItem[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP15_OutputItem");
            qName2 = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP15_OutputItem");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "ArrayOfCMS_APP17_OutputItem");
            cachedSerQNames.add(qName);
            cls = com.johnny.monitor.business.webservice.cms.CMS_APP17_OutputItem[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP17_OutputItem");
            qName2 = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP17_OutputItem");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "ArrayOfCMS_APP18_OutputItem");
            cachedSerQNames.add(qName);
            cls = com.johnny.monitor.business.webservice.cms.CMS_APP18_OutputItem[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP18_OutputItem");
            qName2 = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP18_OutputItem");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP01_OutputItem");
            cachedSerQNames.add(qName);
            cls = com.johnny.monitor.business.webservice.cms.CMS_APP01_OutputItem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP01_SearchContractInfoResponse");
            cachedSerQNames.add(qName);
            cls = com.johnny.monitor.business.webservice.cms.CMS_APP01_SearchContractInfoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP02_GetContractBasicInfoResponse");
            cachedSerQNames.add(qName);
            cls = com.johnny.monitor.business.webservice.cms.CMS_APP02_GetContractBasicInfoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP02_OutputItem");
            cachedSerQNames.add(qName);
            cls = com.johnny.monitor.business.webservice.cms.CMS_APP02_OutputItem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP03_GetContractPayTermsInfoResponse");
            cachedSerQNames.add(qName);
            cls = com.johnny.monitor.business.webservice.cms.CMS_APP03_GetContractPayTermsInfoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP03_OutputItem");
            cachedSerQNames.add(qName);
            cls = com.johnny.monitor.business.webservice.cms.CMS_APP03_OutputItem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP04_GetConDeliveryTermsInfoResponse");
            cachedSerQNames.add(qName);
            cls = com.johnny.monitor.business.webservice.cms.CMS_APP04_GetConDeliveryTermsInfoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP04_OutputItem");
            cachedSerQNames.add(qName);
            cls = com.johnny.monitor.business.webservice.cms.CMS_APP04_OutputItem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP05_GetAfterSalesTermsInfoResponse");
            cachedSerQNames.add(qName);
            cls = com.johnny.monitor.business.webservice.cms.CMS_APP05_GetAfterSalesTermsInfoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP05_OutputItem");
            cachedSerQNames.add(qName);
            cls = com.johnny.monitor.business.webservice.cms.CMS_APP05_OutputItem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP06_GetContractProgressInfoResponse");
            cachedSerQNames.add(qName);
            cls = com.johnny.monitor.business.webservice.cms.CMS_APP06_GetContractProgressInfoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP06_OutputItem");
            cachedSerQNames.add(qName);
            cls = com.johnny.monitor.business.webservice.cms.CMS_APP06_OutputItem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP07_GetPrjContractInfoResponse");
            cachedSerQNames.add(qName);
            cls = com.johnny.monitor.business.webservice.cms.CMS_APP07_GetPrjContractInfoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP07_OutputItem");
            cachedSerQNames.add(qName);
            cls = com.johnny.monitor.business.webservice.cms.CMS_APP07_OutputItem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP08_GetCustomerConInfoResponse");
            cachedSerQNames.add(qName);
            cls = com.johnny.monitor.business.webservice.cms.CMS_APP08_GetCustomerConInfoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP08_OutputItem");
            cachedSerQNames.add(qName);
            cls = com.johnny.monitor.business.webservice.cms.CMS_APP08_OutputItem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP09_GetInvoiceInfoListResponse");
            cachedSerQNames.add(qName);
            cls = com.johnny.monitor.business.webservice.cms.CMS_APP09_GetInvoiceInfoListResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP09_GetInvoiceOutlineResponse");
            cachedSerQNames.add(qName);
            cls = com.johnny.monitor.business.webservice.cms.CMS_APP09_GetInvoiceOutlineResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP09_OutputItem");
            cachedSerQNames.add(qName);
            cls = com.johnny.monitor.business.webservice.cms.CMS_APP09_OutputItem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP10_GetReceiptInfoListResponse");
            cachedSerQNames.add(qName);
            cls = com.johnny.monitor.business.webservice.cms.CMS_APP10_GetReceiptInfoListResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP10_GetReceiptOutlineResponse");
            cachedSerQNames.add(qName);
            cls = com.johnny.monitor.business.webservice.cms.CMS_APP10_GetReceiptOutlineResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP10_OutputItem");
            cachedSerQNames.add(qName);
            cls = com.johnny.monitor.business.webservice.cms.CMS_APP10_OutputItem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP11_GetShipmentsInfoListResponse");
            cachedSerQNames.add(qName);
            cls = com.johnny.monitor.business.webservice.cms.CMS_APP11_GetShipmentsInfoListResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP11_OutputItem");
            cachedSerQNames.add(qName);
            cls = com.johnny.monitor.business.webservice.cms.CMS_APP11_OutputItem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP12_GetShipmentsDtailsResponse");
            cachedSerQNames.add(qName);
            cls = com.johnny.monitor.business.webservice.cms.CMS_APP12_GetShipmentsDtailsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP12_OutputItem");
            cachedSerQNames.add(qName);
            cls = com.johnny.monitor.business.webservice.cms.CMS_APP12_OutputItem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP13_GetContractMainInfoResponse");
            cachedSerQNames.add(qName);
            cls = com.johnny.monitor.business.webservice.cms.CMS_APP13_GetContractMainInfoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP13_OutputItem");
            cachedSerQNames.add(qName);
            cls = com.johnny.monitor.business.webservice.cms.CMS_APP13_OutputItem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP14_GetContractOutlineResponse");
            cachedSerQNames.add(qName);
            cls = com.johnny.monitor.business.webservice.cms.CMS_APP14_GetContractOutlineResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP14_OutputItem");
            cachedSerQNames.add(qName);
            cls = com.johnny.monitor.business.webservice.cms.CMS_APP14_OutputItem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP15_GetRoleMemberResponse");
            cachedSerQNames.add(qName);
            cls = com.johnny.monitor.business.webservice.cms.CMS_APP15_GetRoleMemberResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP15_OutputItem");
            cachedSerQNames.add(qName);
            cls = com.johnny.monitor.business.webservice.cms.CMS_APP15_OutputItem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP17_GetPrjContractInfoResponse");
            cachedSerQNames.add(qName);
            cls = com.johnny.monitor.business.webservice.cms.CMS_APP17_GetPrjContractInfoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP17_OutputItem");
            cachedSerQNames.add(qName);
            cls = com.johnny.monitor.business.webservice.cms.CMS_APP17_OutputItem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP18_GetContractStatusListResponse");
            cachedSerQNames.add(qName);
            cls = com.johnny.monitor.business.webservice.cms.CMS_APP18_GetContractStatusListResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP18_OutputItem");
            cachedSerQNames.add(qName);
            cls = com.johnny.monitor.business.webservice.cms.CMS_APP18_OutputItem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP18_SyncContractInfoRequest");
            cachedSerQNames.add(qName);
            cls = com.johnny.monitor.business.webservice.cms.CMS_APP18_SyncContractInfoRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP_ContractInfoRequest");
            cachedSerQNames.add(qName);
            cls = com.johnny.monitor.business.webservice.cms.CMS_APP_ContractInfoRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "CMS_APP_SyncContractInfoRequest");
            cachedSerQNames.add(qName);
            cls = com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public com.johnny.monitor.business.webservice.cms.CMS_APP12_GetShipmentsDtailsResponse getShipmentsDtails(com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoRequest in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "getShipmentsDtails"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.johnny.monitor.business.webservice.cms.CMS_APP12_GetShipmentsDtailsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.johnny.monitor.business.webservice.cms.CMS_APP12_GetShipmentsDtailsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.johnny.monitor.business.webservice.cms.CMS_APP12_GetShipmentsDtailsResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.johnny.monitor.business.webservice.cms.CMS_APP10_GetReceiptOutlineResponse getReceiptOutline(com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoRequest in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "getReceiptOutline"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.johnny.monitor.business.webservice.cms.CMS_APP10_GetReceiptOutlineResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.johnny.monitor.business.webservice.cms.CMS_APP10_GetReceiptOutlineResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.johnny.monitor.business.webservice.cms.CMS_APP10_GetReceiptOutlineResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.johnny.monitor.business.webservice.cms.CMS_APP04_GetConDeliveryTermsInfoResponse getConDeliveryTermsInfo(com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoRequest in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "getConDeliveryTermsInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.johnny.monitor.business.webservice.cms.CMS_APP04_GetConDeliveryTermsInfoResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.johnny.monitor.business.webservice.cms.CMS_APP04_GetConDeliveryTermsInfoResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.johnny.monitor.business.webservice.cms.CMS_APP04_GetConDeliveryTermsInfoResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.johnny.monitor.business.webservice.cms.CMS_APP08_GetCustomerConInfoResponse getCustomerConInfo(com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoRequest in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "getCustomerConInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.johnny.monitor.business.webservice.cms.CMS_APP08_GetCustomerConInfoResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.johnny.monitor.business.webservice.cms.CMS_APP08_GetCustomerConInfoResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.johnny.monitor.business.webservice.cms.CMS_APP08_GetCustomerConInfoResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.johnny.monitor.business.webservice.cms.CMS_APP10_GetReceiptInfoListResponse getReceiptInfoList(com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoRequest in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "getReceiptInfoList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.johnny.monitor.business.webservice.cms.CMS_APP10_GetReceiptInfoListResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.johnny.monitor.business.webservice.cms.CMS_APP10_GetReceiptInfoListResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.johnny.monitor.business.webservice.cms.CMS_APP10_GetReceiptInfoListResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.johnny.monitor.business.webservice.cms.CMS_APP14_GetContractOutlineResponse getContractOutline(com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoRequest in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "getContractOutline"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.johnny.monitor.business.webservice.cms.CMS_APP14_GetContractOutlineResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.johnny.monitor.business.webservice.cms.CMS_APP14_GetContractOutlineResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.johnny.monitor.business.webservice.cms.CMS_APP14_GetContractOutlineResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.johnny.monitor.business.webservice.cms.CMS_APP17_GetPrjContractInfoResponse getProjectToContractSum(com.johnny.monitor.business.webservice.cms.CMS_APP_ContractInfoRequest in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "getProjectToContractSum"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.johnny.monitor.business.webservice.cms.CMS_APP17_GetPrjContractInfoResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.johnny.monitor.business.webservice.cms.CMS_APP17_GetPrjContractInfoResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.johnny.monitor.business.webservice.cms.CMS_APP17_GetPrjContractInfoResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.johnny.monitor.business.webservice.cms.CMS_APP03_GetContractPayTermsInfoResponse getContractPayTermsInfo(com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoRequest in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "getContractPayTermsInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.johnny.monitor.business.webservice.cms.CMS_APP03_GetContractPayTermsInfoResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.johnny.monitor.business.webservice.cms.CMS_APP03_GetContractPayTermsInfoResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.johnny.monitor.business.webservice.cms.CMS_APP03_GetContractPayTermsInfoResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.johnny.monitor.business.webservice.cms.CMS_APP11_GetShipmentsInfoListResponse getShipmentsOutline(com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoRequest in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "getShipmentsOutline"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.johnny.monitor.business.webservice.cms.CMS_APP11_GetShipmentsInfoListResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.johnny.monitor.business.webservice.cms.CMS_APP11_GetShipmentsInfoListResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.johnny.monitor.business.webservice.cms.CMS_APP11_GetShipmentsInfoListResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.johnny.monitor.business.webservice.cms.CMS_APP13_GetContractMainInfoResponse getContractMainInfo(com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoRequest in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "getContractMainInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.johnny.monitor.business.webservice.cms.CMS_APP13_GetContractMainInfoResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.johnny.monitor.business.webservice.cms.CMS_APP13_GetContractMainInfoResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.johnny.monitor.business.webservice.cms.CMS_APP13_GetContractMainInfoResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.johnny.monitor.business.webservice.cms.CMS_APP05_GetAfterSalesTermsInfoResponse getAfterSalesTermsInfo(com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoRequest in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "getAfterSalesTermsInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.johnny.monitor.business.webservice.cms.CMS_APP05_GetAfterSalesTermsInfoResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.johnny.monitor.business.webservice.cms.CMS_APP05_GetAfterSalesTermsInfoResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.johnny.monitor.business.webservice.cms.CMS_APP05_GetAfterSalesTermsInfoResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.johnny.monitor.business.webservice.cms.CMS_APP11_GetShipmentsInfoListResponse getShipmentsInfoList(com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoRequest in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "getShipmentsInfoList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.johnny.monitor.business.webservice.cms.CMS_APP11_GetShipmentsInfoListResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.johnny.monitor.business.webservice.cms.CMS_APP11_GetShipmentsInfoListResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.johnny.monitor.business.webservice.cms.CMS_APP11_GetShipmentsInfoListResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.johnny.monitor.business.webservice.cms.CMS_APP18_GetContractStatusListResponse getContractStatusList(com.johnny.monitor.business.webservice.cms.CMS_APP18_SyncContractInfoRequest in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "getContractStatusList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.johnny.monitor.business.webservice.cms.CMS_APP18_GetContractStatusListResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.johnny.monitor.business.webservice.cms.CMS_APP18_GetContractStatusListResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.johnny.monitor.business.webservice.cms.CMS_APP18_GetContractStatusListResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.johnny.monitor.business.webservice.cms.CMS_APP01_SearchContractInfoResponse searchContractInfo(com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoRequest in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "searchContractInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.johnny.monitor.business.webservice.cms.CMS_APP01_SearchContractInfoResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.johnny.monitor.business.webservice.cms.CMS_APP01_SearchContractInfoResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.johnny.monitor.business.webservice.cms.CMS_APP01_SearchContractInfoResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.johnny.monitor.business.webservice.cms.CMS_APP06_GetContractProgressInfoResponse getContractProgressInfo(com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoRequest in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[14]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "getContractProgressInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.johnny.monitor.business.webservice.cms.CMS_APP06_GetContractProgressInfoResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.johnny.monitor.business.webservice.cms.CMS_APP06_GetContractProgressInfoResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.johnny.monitor.business.webservice.cms.CMS_APP06_GetContractProgressInfoResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.johnny.monitor.business.webservice.cms.CMS_APP09_GetInvoiceOutlineResponse getInvoiceOutline(com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoRequest in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[15]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "getInvoiceOutline"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.johnny.monitor.business.webservice.cms.CMS_APP09_GetInvoiceOutlineResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.johnny.monitor.business.webservice.cms.CMS_APP09_GetInvoiceOutlineResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.johnny.monitor.business.webservice.cms.CMS_APP09_GetInvoiceOutlineResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.johnny.monitor.business.webservice.cms.CMS_APP15_GetRoleMemberResponse getRoleMember(com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoRequest in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[16]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "getRoleMember"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.johnny.monitor.business.webservice.cms.CMS_APP15_GetRoleMemberResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.johnny.monitor.business.webservice.cms.CMS_APP15_GetRoleMemberResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.johnny.monitor.business.webservice.cms.CMS_APP15_GetRoleMemberResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.johnny.monitor.business.webservice.cms.CMS_APP17_GetPrjContractInfoResponse getProjectToContractList(com.johnny.monitor.business.webservice.cms.CMS_APP_ContractInfoRequest in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[17]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "getProjectToContractList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.johnny.monitor.business.webservice.cms.CMS_APP17_GetPrjContractInfoResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.johnny.monitor.business.webservice.cms.CMS_APP17_GetPrjContractInfoResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.johnny.monitor.business.webservice.cms.CMS_APP17_GetPrjContractInfoResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.johnny.monitor.business.webservice.cms.CMS_APP09_GetInvoiceInfoListResponse getInvoiceInfoList(com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoRequest in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[18]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "getInvoiceInfoList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.johnny.monitor.business.webservice.cms.CMS_APP09_GetInvoiceInfoListResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.johnny.monitor.business.webservice.cms.CMS_APP09_GetInvoiceInfoListResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.johnny.monitor.business.webservice.cms.CMS_APP09_GetInvoiceInfoListResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.johnny.monitor.business.webservice.cms.CMS_APP07_GetPrjContractInfoResponse getPrjContractInfo(com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoRequest in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[19]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "getPrjContractInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.johnny.monitor.business.webservice.cms.CMS_APP07_GetPrjContractInfoResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.johnny.monitor.business.webservice.cms.CMS_APP07_GetPrjContractInfoResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.johnny.monitor.business.webservice.cms.CMS_APP07_GetPrjContractInfoResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.johnny.monitor.business.webservice.cms.CMS_APP02_GetContractBasicInfoResponse getContractBasicInfo(com.johnny.monitor.business.webservice.cms.CMS_APP_SyncContractInfoRequest in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[20]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://appwebservice.contractstatus.cms.zte.com", "getContractBasicInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.johnny.monitor.business.webservice.cms.CMS_APP02_GetContractBasicInfoResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.johnny.monitor.business.webservice.cms.CMS_APP02_GetContractBasicInfoResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.johnny.monitor.business.webservice.cms.CMS_APP02_GetContractBasicInfoResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
