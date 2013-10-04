/**
 * 
 */
package com.vikasing;

import java.util.concurrent.*;

/**
 * @author vksing3
 *
 */
public class CB {
	private final static int THREADS = Runtime.getRuntime().availableProcessors();
    private static ExecutorService executor = Executors.newFixedThreadPool(THREADS);
	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		
        Future<Object> future = executor.submit(new Callable<Object>() {
            public Object call() {
                // query the API (via HttpURLConnection, HTTP Client, commons http, etc)
                // map the API to POJOs (jaxb, JSON mappers, etc)
            	try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		System.out.println("Interface time: "+System.nanoTime());
                return "Interface time: "+Long.toString(System.nanoTime());
            }
        });
		System.out.println("first "+System.nanoTime());
		TryCB tryCB = new TryCB() {			
			@Override
			public String printTime() {				
				return "Interface time: "+Long.toString(System.nanoTime());
			}
		};
		System.out.println("sec "+System.nanoTime());
		//System.out.println(tryCB.printTime());
		future.get(5, TimeUnit.SECONDS);
	}
	public void invokeApi(String path) throws InterruptedException, ExecutionException, TimeoutException {

 
       // Object result = future.get(5, TimeUnit.SECONDS);
        // do stuff with result
    }
}
