package com.sun.vip;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        RpcClient rpcClient = new RpcClient();
        IHelloService iHelloService = rpcClient.clientProxy(IHelloService.class,"localhost",8080);
        iHelloService.sayHello("mic");
    }
}
