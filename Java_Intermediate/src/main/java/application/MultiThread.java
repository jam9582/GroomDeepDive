package application;

/*
두 개의 스레드를 생성하고, 각 스레드에서 고유의 작업을 수행하도록 구현합니다.
두 개의 스레드가 동시에 실행되는 것을 확인합니다.
결과물로 두 개의 스레드가 동시에 실행되는 것을 보여주는 스크린샷을 제출합니다.
 */

public class MultiThread {
    public static void main(String[] args) {

        Thread thread1 = new Thread(
                () -> { /* 여기서 람다식을 쓴게 implemets Runnable을 쓴 것
                자바에서는 기본적으로 다중상속이 불가능하지만, 이러면 다중상속 가능
                이거 대신에 Thread 상속으로도 대치할 수 있지만, 이러면 덜 유연해져서 implements Runnable 이 실무에서 선호됨
                */
                    for (int i=0 ; i<5 ; i++){
                        System.out.println("Thread 1 실행됨: " + i);
                        try {
                            Thread.sleep(500); // 이거 쓰면 cmd + enter로 exception 던져줘야함
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
        );
        // thread1.setPriority(Thread.MAX_PRIORITY); 이러면 thread1이 thread2보다 우선순위로 실행됨
        // setPriority(int 1~10) 으로 우선순위 부여 가능, 숫자 클수록 우선시됨


        Thread thread2 = new Thread(
                () -> {
                    for (int i=0 ; i<5 ; i++){
                        System.out.println("Thread 2 실행됨: " + i);
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
        );

        thread1.start();
        thread2.start();

        try {
            thread1.join(); // 해당 스레드가 종료될 때까지 현재 스레드를 멈추는 것, main 메서드가 thread1이 끝날때까지 기다리는 것
            thread2.join(); // start 2개 다 하고 그 뒤에 join을 2개 하면, 운에 따라 console 실행이 누가 먼저 될지 결정됨
            // 1.start; 1.join; 2.start; 2.join; 이러면 실행 순서 고정을 시킬 순 있지만 멀티 스레드가 아니게 됨
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("모든 스레드 종료됨");

    }
}