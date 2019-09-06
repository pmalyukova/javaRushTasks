package com.javarush.task.task17.task1706;

/* 
Синхронизированный президент
*/

public class Solution {
    public static void main(String[] args) {
        OurPresident expectedPresident = OurPresident.getOurPresident();
        OurPresident ourPresident = OurPresident.getOurPresident();
        System.out.println(expectedPresident == ourPresident );
    }

//    public static class OurPresident {
//        static {
//            synchronized(OurPresident.class){
//                president = new OurPresident();
//            }
//        }
//        private static OurPresident president;
//
//        private OurPresident() {
//        }
//
//        public static OurPresident getOurPresident() {
//            return president;
//        }
//    }

}
