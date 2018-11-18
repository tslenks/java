// package com.variables; // pas besoin si on est dans une ligne de commande et déjà dans le dossier concerné

class Variables {
    public static void main(String[] args) {
        /*variableType();
        System.out.println("========*****========");
        handleChar();
        System.out.println("========*****========");
        typeCasting();
        System.out.println("========*****========");
        threeDarrays();*/

        int[] arraya = {1,2};
        go(arraya);
        System.out.println("array[1] after call method:: " + arraya[1]);
        System.out.println("========*****========");
        byte b = 22;
        // go(22);
        go(b); // because byte is not in any go method parameter, the jvm search a method with the next larger size which is short
        System.out.println("========*****========");
    }

    static void go(int[] array){
        System.out.println("array[0] :: " + array[0]);
        System.out.println("array[1] :: " + array[1]);
        array[1] = 22; // pass by value
    }

    static void go(int i) {
        System.out.println("go (int i)");            
    }

    static void go(short i) {
        System.out.println("go (short s)");            
    }

    static void  handleChar(){
        char cr = 'A' ;
        char cr1 = 65 ;
        char cr2 = '\u0041'; // 4 * 16 power 1 + 1 * 16 power 0
        char cr3 = 0x41; // // 4 * 16 power 1 + 1 * 16 power 0
        char cr4 = 0b01000001; // Decimal representing the 65 decimal value
        // All this variables will print the 'A' value
        System.out.println("CharLetter :: " + cr);
        System.out.println("CharDecimal :: " + cr1); // will represent the char not the litteral value
        System.out.println("CharUnicode :: " + cr2);  
        System.out.println("CharHexadecimal :: " + cr3);
        System.out.println("CharBinary :: " + cr4);
    }

    static void variableType() {
        byte b = 100;
        int y = 0x0041;// hexadécimal
        int z = 0b01000001; // (java 7) binary
        int s = 1_23_456; // (java 7) for readability
        int o = 0101 ; // octal
        long ae = 10000000;
        float f = 123.4f;// doit se terminer par les f ou F
        int intChar = 'A'; // holds the decimal 65

        System.out.println("Byte :: " +b);
        System.out.println("intHex :: " +  y);
        System.out.println("Binary :: " + z);
        System.out.println("Readability :: "+ s);
        System.out.println("Octal ::" + o);        
        System.out.println("float ::" + f);  
    }

    static void threeDarrays() {
            // Here we can remove the [][][] to get a simple way to declare an array
            int [][][] unitSold = 
                new int[][][] {
                    // New York
                    {
                        {0,0,0,0},   // Janv
                        {0,0,0,0},   // Fev
                        {0,0,0,0},   // Mars
                        {0,850,0,0}, // April
                    },
                    // San Fransisco
                    {
                        {0,0,0,0},   // Janv
                        {0,0,0,0},   // Fev
                        {0,0,0,0},   // Mars
                        {0,0,0,0}, // April
                    },
                    {
                        {0,0,0,0},   // Janv
                        {0,0,0,0},   // Fev
                        {0,0,0,0},   // Mars
                        {0,0,0,0},  // April
                    },
                    {
                        {0,0,0,0},   // Janv
                        {0,0,0,0},   // Fev
                        {0,0,0,0},   // Mars
                        {0,0,0,0}, // April
                    }
            };
            System.out.println("3DArrays elt unitSold[0][3][1]  :: " + unitSold[0][3][1]);  
    }

    static void typeCasting () {
        System.out.println("Conversion explicite");  
        long y = 42;
        int x = (int) y; // erreur de compilation si on ne met pas un cast ==> error: incompatible types: possible lossy conversion from long to int

        // Information loss due to conversion
        byte narrowdByte = (byte)  123456; // but if the value is 127, it is fine because it is the max range of the byte
        System.out.println("Information loss ==>" + narrowdByte);  

        // Valeur tronquée
        int  iTruncated = (int) 0.9;
        System.out.println("Truncated ==>" + iTruncated);  

        // Implicit cast
        y = x;

        // Implicit cast
        char cChar = 'A';
        int iInt = cChar; // on aura la valeur en int de A qui est 65  (widening from byte --> int followed by narrowing form int --> char)
        // (élargissement de l'octet -> int suivi d'un rétrécissement de l'int -> caractère)
        System.out.println("Implicit cast ==>" + iInt);  

    }
}