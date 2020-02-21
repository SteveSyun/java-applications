package multithread;

import java.util.concurrent.Semaphore;

class MultithreadingDemo extends Thread 
{ 
	public static int a=0;
	static int b=10;
    Semaphore sem; 
    
    public MultithreadingDemo(Semaphore sem)  
    { 
        this.sem = sem; 
    } 
  
    
    public void run() 
    { 
        try
        { 

            // Displaying the thread that is running 
        	sem.acquire();
        	a = a + 1;
        	b= b+1;
        	// thread 11, a = 1,
        	// thread 12, a = 2, 
        	// thread 13, a = 3, 
            System.out.println ("Thread " + 
            		Thread.currentThread().getId() + " " + a +
                  " is running"); 
            sem.release();
  
        } 
        catch (Exception e) 
        { 
            // Throwing an exception 
            System.out.println ("Exception is caught"); 
        } 
    } 
} 

// Main Class 
public class threads 
{ 
    public static void main(String[] args) 
    { 
    
        Semaphore sem = new Semaphore(1); 
        int n = 8; // Number of threads 
        for (int i=0; i<8; i++) 
        { 
            MultithreadingDemo object = new MultithreadingDemo(sem); 
            object.start(); 
        } 
    } 
} 
