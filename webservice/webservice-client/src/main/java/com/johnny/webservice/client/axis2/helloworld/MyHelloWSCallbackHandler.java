
/**
 * MyHelloWSCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.2  Built on : May 02, 2016 (05:55:18 BST)
 */

    package com.johnny.webservice.client.axis2.helloworld;

    /**
     *  MyHelloWSCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class MyHelloWSCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public MyHelloWSCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public MyHelloWSCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for sayHello method
            * override this method for handling normal response from sayHello operation
            */
           public void receiveResultsayHello(
                    com.johnny.webservice.client.axis2.helloworld.SayHelloResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from sayHello operation
           */
            public void receiveErrorsayHello(java.lang.Exception e) {
            }
                


    }
    