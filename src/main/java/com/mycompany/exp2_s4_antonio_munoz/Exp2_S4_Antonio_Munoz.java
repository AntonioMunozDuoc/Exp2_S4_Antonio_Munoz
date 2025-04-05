package com.mycompany.exp2_s4_antonio_munoz;

import java.util.Scanner;

public class Exp2_S4_Antonio_Munoz {

    public static void main(String[] args) {
        //Declaramos la clase scanner
        Scanner scanner = new Scanner(System.in);
        
        //Variables a usar en el algoritmo
        int descuento = 0, edad, numeroAsiento, fila, seguir;
        double precioFilaA = 15000, precioFilaB = 12000, precioFilaC = 10000;
        boolean edadValida = false;
        
        //Lista con las filas de asientos
        String [] columnas  = {"   ", "|1|", "|2|", "|3|", "|4|", "|5|"};
        String [] filaA = {" A ", "|_|", "|_|", "|_|", "|_|", "|_|"};
        String [] filaB = {" B ", "|_|", "|_|", "|_|", "|_|", "|_|"};
        String [] filaC = {" C ", "|_|", "|_|", "|_|", "|_|", "|_|"};

        //Bienvenida del algoritmo
        System.out.println("Bienvenido al sistema de ventas de entradas del Teatro Moro");
        
        //Ingreso de edad del usuario para obtener descuento
        //Para efectos de la tarea se considerara a los mayores de 60 como adultos mayores
        //Y se considerara a los jovenes de 18 hacia abajo como estudiantes
        while (!edadValida){
            System.out.println("Por favor ingrese su edad:");
            edad = scanner.nextInt();
            if (edad >= 60 && edad <= 110) { 
                edadValida = true;
                descuento  = 15;
            }else if (edad <= 18 && edad >= 0) {
                edadValida = true;
                descuento  = 10;
            }else if (edad >= 19 && edad <= 59){
                edadValida = true;
            }else{
                System.out.println("La edad ingresada no es valida, vuelva a intentarlo");
            }
        }
        
        //Menu principal
        for (int opcionMenu = 0; opcionMenu != 2;) {
            System.out.println("=========================================================");
            System.out.println("Menu Principal");
            System.out.println("1 - Comprar");
            System.out.println("2 - Salir");
            System.out.println("Ingrese el número de la opcion que desea elegir");
            opcionMenu = scanner.nextInt();
            System.out.println("=========================================================");
            
            switch (opcionMenu){       
                case 1:
                    System.out.println("A continuacion le mostraremos una grafica con los asientos del teatro");
                    System.out.println("Donde |_| corresponde a los asientos vacios y |X| corresponde a los asientos en uso");
                    //Muestra grafica de asientos disponibles
                    for (int i = 0; i < 6; i++){
                        System.out.print(columnas[i]);
                    }
                    System.out.println("");
                    for (int i = 0; i < 6; i++){
                        System.out.print(filaA[i]);
                    }
                    System.out.println("");
                    for (int i = 0; i < 6; i++){
                        System.out.print(filaB[i]);
                    }
                    System.out.println("");
                    for (int i = 0; i < 6; i++){
                        System.out.print(filaC[i]);
                    }
                    System.out.println("");
                    
                        //Seleccion de la fila
                        System.out.println("Por favor seleccione la fila que desea comprar");
                        System.out.println("1- A   2- B   3- C");
                        fila = scanner.nextInt();
                        
                        if (fila < 4 && fila != 0) {
                            //Seleccion del numero de asiento
                             System.out.println("Ahora seleccione el número del asiento que desea comprar");
                            numeroAsiento = scanner.nextInt();
                            
                            if (numeroAsiento < 6 && numeroAsiento != 0){
                                
                                switch (fila){
                                    case 1:
                                        if (filaA[numeroAsiento] == "|X|"){
                                            System.out.println("El asiento seleccionado ya esta ocupado");
                                        }else{
                                            //Muestra de todos los datos relacionados a la compra fila A
                                             System.out.println("Usted eligio el asiento " + numeroAsiento + " de la fila A");
                                             System.out.println("El precio base de la entrada es $" + precioFilaA);
                                             System.out.println("Usted tiene un descuento de %" + descuento);
                                             System.out.println("El precio a pagar es $" + (precioFilaA - (precioFilaA * descuento / 100)));
                                             filaA[(numeroAsiento)] = "|X|";
                                        }
                                        break;

                                    case 2: 
                                        if (filaB[numeroAsiento] == "|X|"){
                                            System.out.println("El asiento seleccionado ya esta ocupado");
                                        }else{
                                            //Muestra de todos los datos relacionados a la compra fila B
                                            System.out.println("Usted eligio el asiento " + numeroAsiento + " de la fila B");
                                            System.out.println("El precio base de la entrada es $" + precioFilaB);
                                            System.out.println("Usted tiene un descuento de %" + descuento);
                                            System.out.println("El precio a pagar es $" + (precioFilaB - (precioFilaB * descuento / 100)));
                                            filaB[(numeroAsiento)] = "|X|";
                                        }
                                        break;
                                    case 3:
                                        if (filaC[numeroAsiento] == "|X|"){
                                            System.out.println("El asiento seleccionado ya esta ocupado");
                                        }else{
                                            //Muestra de todos los datos relacionados a la compra fila C
                                            System.out.println("Usted eligio el asiento " + numeroAsiento + " de la fila C");
                                            System.out.println("El precio base de la entrada es $" + precioFilaC);
                                            System.out.println("Usted tiene un descuento de %" + descuento);
                                            System.out.println("El precio a pagar es $" + (precioFilaC - (precioFilaC * descuento / 100)));
                                            filaC[(numeroAsiento)] = "|X|";
                                        }
                                        break;
                                }
                                //Pregunta si se desea continuar realizando compras o se desea salir del programa
                                System.out.println("¿Desea continuar comprando?");
                                System.out.println("1- Si   2-No");
                                seguir = scanner.nextInt();
                                if (seguir == 2){
                                    opcionMenu = 2;
                                }else if (seguir != 1){
                                    System.out.println("Opción invalida");
                                }
                            }else{
                                System.out.println("Opción no valida, intentelo nuevamente");
                            }

                        }else{
                            System.out.println("Opción no valida, intentelo nuevamente");
                        }  
                    
                    break;
                case 2:
                    System.out.println("Muchas gracias por su visita");
                    break;
                
                default:
                    System.out.println("Opción invalida, ingrese su respuesta nuevamente");
                    break;
            }
        }
       
    }
}
