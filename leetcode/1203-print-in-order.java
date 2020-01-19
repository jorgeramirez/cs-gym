class Foo {
    volatile int index = 1;

    public Foo() {}

    public void first(Runnable printFirst) throws InterruptedException {
        while (index != 1) {
            Thread.yield();
        }

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        index = 2;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (index != 2) {
            Thread.yield();
        }

        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        index = 3;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (index != 3) {
            Thread.yield();
        }

        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
