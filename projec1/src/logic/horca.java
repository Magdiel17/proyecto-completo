/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 *
 * @author MAGDIEL
 */
public class horca {
    private int cantMovientos = 11;

    String mostrarPalabras[];//Guarda la letra que digit el usuario
    public Scanner in = new Scanner(System.in);// se inicia el Scanner para leer entrada de palabras
    String[] letras;// almanece las letras cuando se desarma la palabra
    String vectorAnimales[] = new String[8]; // Almacena las palabras del arreglo
    String vectorAutos[] = new String[8];
    String vectorDeportes[] = new String[8];
    String vectorPaises[] = new String[8];
    public String opcion;//Variable estatica de tipo entero llamada opcion, maneja el menú.
    // public  Scanner in = new Scanner(System.in);  // Sentencia de Scanner para leer lo que el usuario ingresa en el teclado
    String[] palabrasAzar;

    public void Menu() {
        try {
            do {
                System.out.println("1- Elija una categoria.");
                System.out.println("2- Iniciar Juego.");
                System.out.println("3- Salir.");
                opcion = in.next();// maneja las opciones del menú capura si digita 1,2,3.

                switch (opcion) {
                    case "1":
                        System.out.println("Favor ingrese la categoria en la que desea cargar las palabras.");
                        System.out.println("4- Animales.");
                        System.out.println("5- Autos.");
                        System.out.println("6- Paises.");
                        System.out.println("7- Deportes.");
                        opcion = in.next();
                        // carga las palabras en el arreglo antes de iniciar el juego
                        palabrasAzar = agregarPalabrasVector(opcion);
                        if (palabrasAzar != null) {
                            System.out.println("Palabras Cargadas.");
                        } else {
                            System.out.println("Palabras No Cargadas.");
                        }
                        break;
                    case "2":
                        int numAzar = saberPalabraRamdoom();//guarda el numero que se tomo al azar
                        jugar(palabrasAzar[numAzar]);//
                        break;
                    case "3":
                        break;
                    default:
                        break;
                }

            } while (!opcion.equals("3"));//Termina el menú 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Digite solo los numeros 1,2 y  3 en el menú" + e);
        }
    }

    // Metodo para agrgar cargar as palabras a jugar
    public String[] agregarPalabrasVector(String categoria) {
        String vector[];
        switch (categoria) {
            case "4":
                vectorAnimales[0] = "perro";
                vectorAnimales[1] = "gato";
                vectorAnimales[2] = "pato";
                vectorAnimales[3] = "ganzo";
                vectorAnimales[4] = "caballo";
                vectorAnimales[5] = "conejo";
                vectorAnimales[6] = "zorro";
                vectorAnimales[7] = "ballena";
                vector = vectorAnimales;
                break;
            case "5":
                vectorAutos[0] = "toyota";
                vectorAutos[1] = "audi";
                vectorAutos[2] = "bmv";
                vectorAutos[3] = "nissan";
                vectorAutos[4] = "suzuki";
                vectorAutos[5] = "chevrolet";
                vectorAutos[6] = "ferrari";
                vectorAutos[7] = "jaguar";
                vector = vectorAnimales;
                break;
            case "6":
                vectorDeportes[0] = "futbol";
                vectorDeportes[1] = "tennis";
                vectorDeportes[2] = "beseball";
                vectorDeportes[3] = "basketball";
                vectorDeportes[4] = "rugby";
                vectorDeportes[5] = "volleyball";
                vectorDeportes[6] = "gimnasia";
                vectorDeportes[7] = "ciclismo";
                vector = vectorAnimales;
                break;
            case "7":
                vectorPaises[0] = "costarica";
                vectorPaises[1] = "alemania";
                vectorPaises[2] = "nigeria";
                vectorPaises[3] = "panama";
                vectorPaises[4] = "estadosunidos";
                vectorPaises[5] = "siria";
                vectorPaises[6] = "afganistan";
                vectorPaises[7] = "inglaterra";
                vector = vectorAnimales;
                break;
            default:
                vector = null;
                break;
        }
        return vector;
    }

    //Metodo que averigua la palabra.

    public int saberPalabraRamdoom() {
        Random oRandom = new Random();// se crea el random para elegir palabras aleatorias del arreglo
        int numAdiv = oRandom.nextInt(7);//elige la palabra de acuerdo al indice
        return numAdiv;//retorna la palabra seleccionada
    }

    public void jugar(String palabraSeleccionada) {
        int vidas = 11; //variable que maneja las vidas
        boolean ganado = false;
        boolean letraEncontrada = false;
        letras = new String[palabraSeleccionada.length()];
        //Guardar lo que queremos mostrar en mantalla
        mostrarPalabras = new String[palabraSeleccionada.length()];
        String letraUsuario;//almacena la letra que digita el usuario
        //Cargamos linaes vacias
        for (int i = 0; i < palabraSeleccionada.length(); i++)//ciclo que le da los campos en giones de acuerdo con las letras que tenga la palabra
        {
            mostrarPalabras[i] = "_ ";
        }
        //Cargamos el arreglo Letras con cada letra de la palabra seleccionada
        for (int i = 0; i < palabraSeleccionada.length(); i++) {
            //captura cada caracter de la variable string y lo almacena en el arreglo Letras
            letras[i] = String.valueOf(palabraSeleccionada.charAt(i));
        }
        System.out.println("*** Letras de la palabra a jugar ***");
        for (int i = 0; i < palabraSeleccionada.length(); i++) {
            //nos muestra en consola las letras que se han adivinado
            System.out.print(mostrarPalabras[i] + " ");
        }
        do {
            if (vidas > 0) {
                System.out.println("");
                System.out.println("*** Favor ingresar una letra ***");
                letraUsuario = in.next();//
               
                for (int i = 0; i < palabraSeleccionada.length(); i++) {
                    if (letraUsuario.equals(letras[i])) {
                        //System.out.println(letraUsuario);
                        mostrarPalabras[i] = letraUsuario;
                        letraEncontrada = true;
                    } else {
                        if (mostrarPalabras[i].equals("_ ")) {
                            mostrarPalabras[i] = "_ ";
                        }
                    }
                    System.out.print(mostrarPalabras[i]);
                }
                //Consulta si encontró o no la letra
                if (letraEncontrada == false) {
                    vidas--;
                } else {
                    letraEncontrada = false;
                }
                System.out.println("");
                System.out.println("vidas restantes " + vidas);
                System.out.println("");
                if (consultaJuegoGanado()) {
                    ganado = true;
                    System.out.println("ganaste");
                }
            } else {
                System.out.println("has perdido");
                ganado = true;
            }
        } while (ganado != true);
    }

    private boolean consultaJuegoGanado() {
        boolean valor = true;
        //consulto letras de la palabra seleccionada con mostrarPalabra
       
        for (int i = 0; i < mostrarPalabras.length; i++) {
            //captura cada caracter de la variable string y lo almacena en el arreglo Letras
            if (!letras[i].equals(mostrarPalabras[i])) {
                valor = false;
            }
        }
        return valor;
    } 
}
