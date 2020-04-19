public class Main {

    static volatile char str = 'A';

//    Создать три потока, каждый из которых выводит определенную букву (A, B и C) 5 раз (порядок – ABСABСABС). Используйте wait/notify/notifyAll.

    public static void main(String[] args) {
        Object lock = new Object();
        class MyThread implements Runnable {
            private char firstChar;
            private char nextChar;

            public MyThread(char firstChar, char nextChar) {
                this.firstChar = firstChar;
                this.nextChar = nextChar;
            }
            @Override
            public void run() {
                synchronized (lock) {
                    for (int i = 0; i < 5; i++) {
                        try {
                            while (str != firstChar) {
                                lock.wait();
                            }
                            System.out.print(firstChar);
                            str = nextChar;
                            lock.notifyAll();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        new Thread(new MyThread('A', 'B')).start();
        new Thread(new MyThread('B', 'C')).start();
        new Thread(new MyThread('C', 'A')).start();
    }
}