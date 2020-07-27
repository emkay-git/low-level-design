package mohit.learn.java;

import mohit.learn.java.lock.Resources;

public class Main {

    public static void main(String[] args) throws InterruptedException{

        Resources rs = new Resources();

//        rs.setResources(10);
//        rs.printResource();
        new Thread(() -> {
            rs.printResource();
            try {
                rs.setResources(12);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            rs.printResource();
        });

        new Thread(() -> {
            rs.printResource();
            try {
                rs.setResources(13);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            rs.printResource();
        });


        // testing reentrant with custom mutex
        new Thread(() -> {
            try {
                rs.recursiveResource(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // testing read write locks
        new Thread(() -> {
            try {
                rs.frequentReadResource();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"Read 1").start();
        new Thread(() -> {
            try {
                rs.frequentReadResource();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"Read 4").start();
        // testing read write locks

        new Thread(() -> {
            try {
                rs.writeResource();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"Write 1").start();
        Thread.sleep(5000);
        new Thread(() -> {
            try {
                rs.frequentReadResource();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"Read 2").start();

    }
}
