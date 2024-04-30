import java.util.ArrayList;
import java.util.Scanner;

/**
 * @autor: Andreina Romero
 * DNI: 95808038
 * Comisión: 23595
 */

/**
 * Crearemos un ATM - OnlineBanking
 * Se creará un Menú Principal donde el usuario podrá registrarse e iniciar sesión
 * y un menú usuario donde en cada una de sus opciones podra volver al menu inicial y salida
 * Podrá mostrar en pantalla Los Datos del usuario, Saldo Ficticio (Saldo disponible)
 * Una Opción de registro de usuarios para Transferencia y transferencias y otra de pago on line.
 * Se podrá ingresar en el sistema con usuario y clave teniendo 3 limites de intento.
 * en caso de superar los limites el sistema se cerrará.
 * se podrá revisar los datos de los usuarios registrados para transferencias a traves del DNI
 * y al final realizará un conteo regresivo para la salida del sistema con advertencia de extraer tarjeta
 */

public class ATMBanking {
//Zona de Metodos
public static void menu1(int opcion){
    // Diseño del menu de opciones
    System.out.println("*** BIG BANK ***");
    System.out.println("*** BIENVENIDO ATM & OnLine Banking***");
    System.out.println("1- Registre su usuario. ");
    System.out.println("2- Inicie Sesión. ");
    System.out.println("3- Salir.");
}

public static void menuUsuario(int opcion1) {
    
    System.out.println("1- Consulta tus datos y Saldo disponible. ");
    System.out.println("2- Registro de Usuario a Transferir.");
    System.out.println("3- Transferencia de Saldo.");
    System.out.println("4- Registro de Servicios.");
    System.out.println("5- Pago de servicios. ");
    System.out.println("6- Lista de Usuarios Registrados.");
    System.out.println("7- Salir del Sistema.");
}

    // Saldo
public static double saldo = 100000.00;
private static String dni1;


public static void transferencia (double valor){
 // procedimiento
  saldo -= valor;
}

public static void pago (double valorpago){
 // procedimiento
  saldo -= valorpago;
}
    
    public static void main(String[] args) throws InterruptedException {
        //Declaración de Variables
        String clave =""; 
        String claveControl="";
        String usr ="";
        String usrControl=""; 
        String aliasIngresado="";  
        String alias1 = "";     
        String usrTransferencia="";
        String apellido = "";
        String op = "";
        String mialias;
        String apellido1 ="";
        int opcion, opcion1, contador, seg;
        double monto, pago;

        // Declaracion e instanciacion de los objetos teclado y AL
        ArrayList<String> usuarios = new ArrayList<String>();
        ArrayList<String> nrosdni = new ArrayList<String>();
        ArrayList<String> servicios = new ArrayList<String>();
        Scanner teclado;  
        
        // Procesos
        opcion=0;
        contador = 0;
        opcion1 = 0;
        seg = 5;
        mialias=".BigBank";
                        
        // Instanciación del objeto Scanner.
        teclado = new Scanner(System.in);
            
        do {
            menu1(opcion);
            
            // Inicialización de salida entrada para las opciones
            opcion = teclado.nextInt();
            teclado.nextLine(); //Limpieza de Buffer.

        // Proceso mediante switch
        switch (opcion) { //Aca Inicia el Menú Principal
            case 1: // Se realiza registro de usuario a través del ingreso por teclado.
                System.out.println("");
                System.out.println("BIENVENIDO A SU REGISTRO EN EL SISTEMA.");
                System.out.println("Indique su nombre de usuario: ");
                usrControl=teclado.nextLine();
                System.out.println("Bien ahora indique su apellido: ");  
                apellido1 = teclado.nextLine();                 
                System.out.println("Ingrese una clave para su usuario: ");
                claveControl=teclado.nextLine();
                System.out.println("** El Registro se ha realizado con éxito** ");
                System.out.println("Indique la opción que desee realizar para continuar: ");                                   
                continue;                    
            case 2: // Se realiza el Inicio de Sesión.
                while (contador<=3) {              
                    System.out.println("INICIO DE SESIÓN");   
                    System.out.println("Indique su nombre de usuario: (Respetando Mayúsculas y Minúsculas) ");
                    usr = teclado.nextLine();
                    System.out.println("Ingrese su clave de acceso: ");
                    clave = teclado.nextLine();
                    
                    if (usr.equals(usrControl) && clave.equals(claveControl)) {// se compara el usuario ingresado con el registrado
                        contador=4;
                        System.out.println("***BIENVENIDO AL SISTEMA***");
                        System.out.println("");
                        System.out.println("Hola "+usr+".");
                       
                    }else { 
                        // Empieza el conteo de datos erroneos
                        ++contador;
                        System.out.println("El Usuario o la contraseña son incorrectos.");
                        System.out.println("Intente nuevamente");

                        if (contador==3) { // Se cuentan los 3 intentos de clave o usuarios incorrectos y te devuelve al menú inicial
                            System.out.println("Lo siento fallaste los 3 intentos. ");
                            System.out.println("*** EL SISTEMA TE HA BLOQUEADO ***");
                            System.out.println("Contacte a un Asesor del Banco");
                            System.out.println("No Olvide retirar su tarjeta");
                            System.out.println("Hasta Pronto...");
                            System.exit(0);   
                        }                                                           
                       
                    }        
                    
                }            
                do {
                        //Desde aca se valida el Usuario y entramos al menú interno de usuario. 
                        if (usr.equals(usrControl) && clave.equals(claveControl)) {
                            System.out.println("Indique la opción que desea realizar. ");  
                            
                            //inicializacion de entrada salida para las opciones del menú
                            menuUsuario(opcion1);
                            opcion1=teclado.nextInt();
                            teclado.nextLine();//Limpieza de buffer
                
                            switch (opcion1) { // menú de usuario menuUsuario   
                                case 1: //Consulta del Saldo y Datos
                                    System.out.println("Hola "+usr );
                                    System.out.println("Tu alias es: ");
                                    String aliasUsr = usrControl+"."+apellido1+mialias;
                                    System.out.println(aliasUsr);
                                    String cbu = "0024142898432";
                                    System.out.println("Su Número de CBU es: "+cbu);
                                    System.out.println("El Saldo disponible en su cuenta es: "+saldo);
                                    System.out.println();
                                    break;
                                case 2: //Registro de usuarios para transferencias  
                                    do {
                                        System.out.println(" **Registro de usuario a Transferir** ");
                                        System.out.println("");
                                        System.out.println("Indique un apodo para almacenar el usuario: ");
                                        String usuario = teclado.nextLine();
                                        usuarios.add(usuario);
                                        System.out.println("Indique Nombre de la Persona a Transferir: ");
                                        usrTransferencia = teclado.nextLine(); 
                                        System.out.println("Indique ahora el Apellido del Usuario");
                                        apellido = teclado.nextLine();            
                                        System.out.println("Indique ahora el númmero del DNI del Usuario");
                                        dni1 = teclado.nextLine();
                                        nrosdni.add(dni1);
                                        System.out.println("Indique el Alias:");
                                        alias1 = teclado.nextLine();
                                        System.out.println("Confirme los datos ingresados: ");
                                        System.out.println("");
                                        System.out.println("El Apodo Ingresado es: "+usuario);
                                        System.out.println("Nombre: "+usrTransferencia);
                                        System.out.println("Apellido: "+apellido);
                                        System.out.println("Nro de DNI: "+dni1);
                                        System.out.println("Alias: "+alias1+mialias);
                                           
                                        do {
                                            System.out.println("¿Que opción desea realizar?");  
                                            System.out.println("1. Volver a registrar otro usuario.");
                                            System.out.println("2. Confirmar los datos ingresados.");
                                            op = teclado.nextLine();                         
                                        } while(!(op.equalsIgnoreCase("1") || op.equalsIgnoreCase("2")));

                                        
                                    } while (op.equalsIgnoreCase("1")); 
                                    break;

                                case 3: // Transferencia de saldo
                                    do {
                                        System.out.println("Ingrese el Alias a Transferir");
                                        aliasIngresado = teclado.nextLine();
                                        System.out.println("Ingrese el Monto a Transferir:");
                                        monto = teclado.nextDouble();
                                        teclado.nextLine();//Limpieza de buffer

                                        if (aliasIngresado.equals(alias1)) {
                                            System.out.println("DATOS DE TRANSFERENCIA: ");
                                            System.out.println("");
                                            System.out.println("Nombre: "+usrTransferencia);
                                            System.out.println("Apellido: "+apellido);
                                            System.out.println("DNI: "+dni1);
                                            System.out.println("Alias: "+aliasIngresado+mialias);
                                            System.out.println("");

                                            do {
                                                System.out.println("¿Verifique si los datos ingresados son correctos?");
                                                System.out.println("¿Desea Continuar? S/N");
                                                op= teclado.nextLine();
                                            } while (!(op.equalsIgnoreCase("s") || op.equalsIgnoreCase("n") ));

                                        } else {
                                            System.out.println("El alias que ingresaste no esta registrado");
                                        }
                                            
                                        if (aliasIngresado.equals(alias1)) {
                                            saldo-=monto;
                                            System.out.println("El Saldo transferido es: "+monto); 
                                            System.out.println("Su saldo actual es: "+saldo);                                           
                                        }
                                        
                                    }while(!(op.equalsIgnoreCase("s") || op.equalsIgnoreCase("n") ));
                                    break;
                                case 4: //Registro de servicios a pagar
                                     do {    
                                        System.out.println("Hola "+usr);
                                        System.out.println("Indique el nombre del servicio que desea Pagar: ");
                                        String item = teclado.nextLine();
                                        servicios.add(item);
                                        //BLOQUE DE REPETIR PROCESO
                                         do{
                                            System.out.println("¿Desea registrar otro servicio?(S/N)");
                                            op = teclado.nextLine();
                                        }while(!(op.equalsIgnoreCase("s") || op.equalsIgnoreCase("n") ));

                                    }while(op.equalsIgnoreCase("s"));
                                      
                                    break;    
                                case 5: //Pago de servicios  
                                    // Habilitamos variables que nos ayudaran en la busqueda
                                    String encontrado ="";
                                    String noEncontrado ="";

                                    // Instruccion de entrada salida para activar buscador
                                    System.out.println("Los servicios registrados para pagos son:  "+(servicios));
                                    String nombreservicio = teclado.nextLine();

                                    for(String servicio:servicios){
                                        if(servicio.contains(nombreservicio)){
                                            encontrado = servicio;
                                        }else{
                                            noEncontrado = nombreservicio;
                                        }
                                    }
                                    if(!encontrado.isEmpty()){
                                        System.out.println("Este servicio se encuentra habilitado para el Pago. "+encontrado);
                                    }else if(!noEncontrado.isEmpty()){
                                        System.out.println("El Servicio que ingresaste no se encuentra en el sistema. "+noEncontrado);
                                    } 

                                    if (nombreservicio.equalsIgnoreCase(encontrado)) {
                                        System.out.println("Ingrese el monto a pagar: ");
                                        pago = teclado.nextDouble();
                                        teclado.nextLine();
                                        saldo -= pago;
                                        System.out.println("El Pago ha sido realizado con éxito.");
                                        System.out.println("Tu saldo actual es: "+saldo);                                        
                                    }
                                    
                                break;

                                case 6:
                                    do{
                                    System.out.println("¿Desea consultar usuario por Apodo? S/N");
                                    op = teclado.nextLine();
                                        if (op.equalsIgnoreCase("s")) {
                                            System.out.println("EL Listado de Usuarios registrados para Transferencias por Apodo es: ");
                                            for(String usuario : usuarios){
                                                System.out.println(usuario);
                                            }
                                        } 
                                    System.out.println("¿Desea consultar usuario por Nro de DNI? S/N"); 
                                    op = teclado.nextLine();
                                       if (op.equalsIgnoreCase("s")) {
                                            System.out.println("EL Listado de Usuarios registrados para Transferencias por DNI es: ");
                                            for(String dni1 : nrosdni){
                                                System.out.println(dni1);
                                            }
                                        } 
                                    }while(!(op.equalsIgnoreCase("s") || op.equalsIgnoreCase("n") ));   
                                   

                                break;
                                 
                                case 7: // Salir del Sistema   
                                    System.out.println("*** "  +usr+ "***");
                                    System.out.println("***ESTAS SALIENDO DEL SISTEMA***");
                                    System.out.println("*** NO OLVIDES RETIRAR TU TARJETA ***");
                                    System.exit(0);
                                    break;
                    
                                default:
                                System.out.println("La opción que ingresaste no existe...");
                                break;
                             }
                        }   
                        //BLOQUE DE REPETIR PROCESO
                        do{
                            System.out.println("¿Desea seguir en el Sistema?(S/N)");
                            op = teclado.nextLine();
                        }while(!(op.equalsIgnoreCase("s") || op.equalsIgnoreCase("n") ));

                    }while (op.equalsIgnoreCase("s"));

                case 3:
                  System.out.println("Espere 5 Segundos mientras el sistema cierra correctamente");
                    seg--;                                       
                    System.out.println((seg--));
                    Thread.sleep(1000);    
                    System.out.println((seg--)); 
                    Thread.sleep(1000); 
                    System.out.println((seg--)); 
                    Thread.sleep(1000); 
                    System.out.println((seg--));
                    Thread.sleep(1000);  
                    System.out.println((seg--)); 
                    Thread.sleep(1000); 
                    System.out.println("");       
                    System.out.println("**EL SISTEMA HA CERRADO CORRECTAMENTE.**");                                
                    System.out.println("Nos vemos pronto "+usrControl);
                    System.out.println("**** RETIRE SU TARJETA ****");
                    System.exit(0);
                    break;
        
                default:
                System.out.println("La opción que ingresaste es incorrecta.");
                System.out.println("Intenta nuevamente");
                break;
            }
                                
        
        }while(opcion !=3);
        System.exit(0);

        teclado.close();          
    }
        
   
}  





