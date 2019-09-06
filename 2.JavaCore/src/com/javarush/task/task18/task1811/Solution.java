package com.javarush.task.task18.task1811;

/* 
Wrapper (Decorator)
*/

public class Solution {

    public static void main(String[] args) {
        new Thread(new DecoratorRunnableImpl(new DecoratorMyRunnableImpl(new RunnableImpl()))).start();
    }

    public static class RunnableImpl implements Runnable {
        @Override
        public void run() {
            System.out.println("RunnableImpl body");
        }
    }

    public static class DecoratorRunnableImpl implements Runnable {
        private Runnable component;

        public DecoratorRunnableImpl(Runnable component) {
            this.component = component;
        }

        @Override
        public void run() {
            System.out.print("DecoratorRunnableImpl body ");
            component.run();
        }
    }

    public static class DecoratorMyRunnableImpl implements Runnable{ //унаследоваться от того же интерфейса, что и оригинал;
        private Runnable component; //создать переменную класса типа этого интерфейса (это называется композиция)

        public DecoratorMyRunnableImpl(Runnable component) { //в конструкторе ее инициализировать;
            this.component = component;
        }

        @Override
        public void run() {
            System.out.print("DecoratorMyRunnableImpl body ");
            component.run();//реализовать интерфейс, вызывая в методе аналогичный метод оригинала
                            // (это называется делегирование) с добавлением дополнительного функционала (суть обертки).
        }
    }

}
