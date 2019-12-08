// https://leetcode.com/problems/print-foobar-alternately
class FooBar {
    private int n;
    // we declare that this variable will be updated by multiple threads
    private volatile int index = 1;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            while(index != 1) { Thread.yield(); } // just make the thing sleep
        	  // printFoo.run() outputs "foo". Do not change or remove this line.
        	  printFoo.run();
            index = 2;
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            while(index != 2) { Thread.yield(); } // just make the thing sleep
            // printBar.run() outputs "bar". Do not change or remove this line.
        	  printBar.run();
            index = 1;
        }
    }
}