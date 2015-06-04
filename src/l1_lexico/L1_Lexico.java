package l1_lexico;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class L1_Lexico {

    private static final String nombreFichero = "datos.txt";
    
    public static void main(String[] args) {
        ArrayList<ANFD_E> anfd_es = new ArrayList<ANFD_E>(); //Creamos el arreglo de objetos ANFD (cada uno será un qx)
	ArrayList<ANFD_E> anfd_esu = new ArrayList<ANFD_E>(); //Creamos el arreglo de objetos ANFD (cada uno será un qx)
        File fichero = new File(nombreFichero); //Inicializamos el archivo
	Scanner s = null;
        int a; 
        int inicial_q=999, inicial_r=999;
        int terminal_q=999, terminal_r=999;
        String line, temporal, concatenar="NO", tipo_concatenacion="Q*R";
        try {
            s = new Scanner(fichero);
            System.out.println("Datos Iniciales: ");
            System.out.println("-------------------------------------");
            while (s.hasNextLine()){
                String linea = s.nextLine();     
                if(linea.contains("q")&&!linea.contains("#")){ //Si la línea contiene un hashtag la omitiremos
                    String [] cortarString = linea.split("/"); //cortamos la línea entre los / y la metemos a un arreglo String
                    ANFD_E anfd_e = new ANFD_E(); //Creamos el qx
                    
                    //Insertando en anfd_e las iteraciones con 0
                    temporal = cortarString[1]; //pasamos a una variable temporal el extracto de 0
                    String [] concero = cortarString[1].split(","); // cortamos el bloque separando las iteraciones en 0 
                    if(!temporal.contains("&")){ //Si el extracto contiene & significa que no posee ninguna iteación
                        for(int pos=0; pos<concero.length ; pos++){ //hacemos un for para guardar las iteraciones en posiciones distintas del listado
                            anfd_e.setCero(pos,Integer.parseInt(concero[pos])); //Ingresamos la iteración extraída en la posición que da el for
                            if(pos<concero.length){ //Si llegamos al último...
                                anfd_e.setCero(pos+1,999); //Grabamos un 99 en la última posición para comprobar que no exite un nuevo término
                            }
                        }
                    }else{
                        anfd_e.setCero(0,999); //Si no había ninguna iteración insertamos el 999 para dejar constancia de ello
                    }
                    
                    //Insertando en anfd_e las iteraciones con 1
                    temporal = cortarString[2]; //pasamos a una variable temporal el extracto de 1
                    String [] conuno = cortarString[2].split(","); // cortamos el bloque separando las iteraciones en 0 
                    if(!temporal.contains("&")){ //Si el extracto contiene & significa que no posee ninguna iteación
                        for(int pos=0; pos<conuno.length ; pos++){ //hacemos un for para guardar las iteraciones en posiciones distintas del listado
                            anfd_e.setUno(pos,Integer.parseInt(conuno[pos])); //Ingresamos la iteración extraída en la posición que da el for
                            if(pos<conuno.length){ //Si llegamos al último...
                                anfd_e.setUno(pos+1,999); //Grabamos un 99 en la última posición para comprobar que no exite un nuevo término
                            }
                        }
                    }else{
                        anfd_e.setUno(0,999); //Si no había ninguna iteración insertamos el 999 para dejar constancia de ello
                    }
                    
                    //Insertando en anfd_e las iteraciones con vacio
                    temporal = cortarString[3]; //pasamos a una variable temporal el extracto de vacios
                    String [] convacio = cortarString[3].split(","); // cortamos el bloque separando las iteraciones vacias
                    if(!temporal.contains("&")){ //Si el extracto contiene & significa que no posee ninguna iteación
                        for(int pos=0; pos<convacio.length ; pos++){ //hacemos un for para guardar las iteraciones en posiciones distintas del listado
                            anfd_e.setVacio(pos,Integer.parseInt(convacio[pos])); //Ingresamos la iteración extraída en la posición que da el for
                            if(pos<convacio.length){ //Si llegamos al último...
                                anfd_e.setVacio(pos+1,999); //Grabamos un 99 en la última posición para comprobar que no exite un nuevo término
                            }
                        }
                    }else{
                        anfd_e.setVacio(0,999); //Si no había ninguna iteración insertamos el 999 para dejar constancia de ello
                    }
                    anfd_es.add(anfd_e); //Se añade el qX al arreglo de q's
                }
                //LEctura de ANFD-E para concatenar
                if(linea.contains("r")&&!linea.contains("#")){ //Si la línea contiene un hashtag la omitiremos
                    String [] cortarString = linea.split("/"); //cortamos la línea entre los / y la metemos a un arreglo String
                    ANFD_E anfd_eu = new ANFD_E(); //Creamos el qx
                    
                    //Insertando en anfd_e las iteraciones con 0
                    temporal = cortarString[1]; //pasamos a una variable temporal el extracto de 0
                    String [] concero = cortarString[1].split(","); // cortamos el bloque separando las iteraciones en 0 
                    if(!temporal.contains("&")){ //Si el extracto contiene & significa que no posee ninguna iteación
                        for(int pos=0; pos<concero.length ; pos++){ //hacemos un for para guardar las iteraciones en posiciones distintas del listado
                            anfd_eu.setCero(pos,Integer.parseInt(concero[pos])); //Ingresamos la iteración extraída en la posición que da el for
                            if(pos<concero.length){ //Si llegamos al último...
                                anfd_eu.setCero(pos+1,999); //Grabamos un 99 en la última posición para comprobar que no exite un nuevo término
                            }
                        }
                    }else{
                        anfd_eu.setCero(0,999); //Si no había ninguna iteración insertamos el 999 para dejar constancia de ello
                    }
                    
                    //Insertando en anfd_e las iteraciones con 1
                    temporal = cortarString[2]; //pasamos a una variable temporal el extracto de 1
                    String [] conuno = cortarString[2].split(","); // cortamos el bloque separando las iteraciones en 0 
                    if(!temporal.contains("&")){ //Si el extracto contiene & significa que no posee ninguna iteación
                        for(int pos=0; pos<conuno.length ; pos++){ //hacemos un for para guardar las iteraciones en posiciones distintas del listado
                            anfd_eu.setUno(pos,Integer.parseInt(conuno[pos])); //Ingresamos la iteración extraída en la posición que da el for
                            if(pos<conuno.length){ //Si llegamos al último...
                                anfd_eu.setUno(pos+1,999); //Grabamos un 99 en la última posición para comprobar que no exite un nuevo término
                            }
                        }
                    }else{
                        anfd_eu.setUno(0,999); //Si no había ninguna iteración insertamos el 999 para dejar constancia de ello
                    }
                    
                    //Insertando en anfd_e las iteraciones con vacio
                    temporal = cortarString[3]; //pasamos a una variable temporal el extracto de vacios
                    String [] convacio = cortarString[3].split(","); // cortamos el bloque separando las iteraciones vacias
                    if(!temporal.contains("&")){ //Si el extracto contiene & significa que no posee ninguna iteación
                        for(int pos=0; pos<convacio.length ; pos++){ //hacemos un for para guardar las iteraciones en posiciones distintas del listado
                            anfd_eu.setVacio(pos,Integer.parseInt(convacio[pos])); //Ingresamos la iteración extraída en la posición que da el for
                            if(pos<convacio.length){ //Si llegamos al último...
                                anfd_eu.setVacio(pos+1,999); //Grabamos un 99 en la última posición para comprobar que no exite un nuevo término
                            }
                        }
                    }else{
                        anfd_eu.setVacio(0,999); //Si no había ninguna iteración insertamos el 999 para dejar constancia de ello
                    }
                    anfd_esu.add(anfd_eu); //Se añade el qX al arreglo de q's
                }
                if(linea.contains("Q F")&&!linea.contains("#")){
                    String [] arregloterminal = linea.split("/");
                    terminal_q  = Integer.parseInt(arregloterminal[1]);
                    //System.out.println("El Terminal para Q es:"+terminal_q);
                }
                if(linea.contains("R F")&&!linea.contains("#")){
                    String [] arregloterminal = linea.split("/");
                    terminal_r  = Integer.parseInt(arregloterminal[1]);
                    //System.out.println("El Terminal para R es:"+terminal_r);
                }
                if(linea.contains("Q I")&&!linea.contains("#")){
                    String [] arregloterminal = linea.split("/");
                    inicial_q  = Integer.parseInt(arregloterminal[1]);
                    //System.out.println("El Inicial para Q es:"+inicial_q);
                }
                if(linea.contains("R I")&&!linea.contains("#")){
                    String [] arregloterminal = linea.split("/");
                    inicial_r  = Integer.parseInt(arregloterminal[1]);
                    //System.out.println("El Inicial para R es:"+inicial_r);
                }
                if(linea.contains("Respuesta")&&!linea.contains("#")){
                    String [] arregloterminal = linea.split("/");
                    concatenar  = arregloterminal[1];
                    System.out.println("Usuario solicita Concatenación: "+concatenar);
                }
                if(linea.contains("Concatenacion")&&!linea.contains("#")&&concatenar.contains("SI")){
                    String [] arregloterminal = linea.split("/");
                    tipo_concatenacion  = arregloterminal[1];
                    System.out.println("Tipo de Concatenación: "+tipo_concatenacion);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("el archivo no pudo ser leído, verifique la ruta  " + nombreFichero);
	} finally{
            try {
		if (s != null)
                    s.close();
			} catch (Exception e2) {
                    e2.printStackTrace();
		}
	}
        
        if(concatenar.contains("SI")){
            System.out.println("\nSe procederá con la concatenación del ANFD-e...");
            Concatenar_ANFD_E(anfd_es, anfd_esu, inicial_q, inicial_r, terminal_q, terminal_r, tipo_concatenacion);
            if(tipo_concatenacion.contains("Q+R")){
                terminal_q=terminal_q+anfd_esu.size()+2;
                System.out.println("\n\nNuevo terminal: "+terminal_q);
            }else{
                terminal_q=terminal_q+anfd_esu.size();
                System.out.println("\n\nNuevo terminal: "+terminal_q);
            }
        }
        
        
        ArrayList<ANFD> anfds = new ArrayList<ANFD>(); //Creamos el arreglo de objetos ANFD (cada uno será una letra del ANFD)
        ANFD anfd = new ANFD(); //Creamos la primera letra (A1)
        anfd.setPuntero_elemento(0); //Seteamos el puntero de la primera letra (A1) en 0 
        anfd.setElemento(0,0); //Introducimos en el AFND que A1 contiene a q0
        anfd.setElemento(1,999); //Introducimos en el AFND que el elemento 1 del ANFD letra A1 es el final (999)
        anfds = Construir_ANFD(anfd_es, anfds, anfd);
        anfds = Nuevos_Elementos(anfds, anfd_es,0);

        //Impresión ANFD
        System.out.println("\n\nElementos del ANFD");
        int x,y=0;
        for(x=0; x<anfds.size(); x++){
            System.out.print("\nA"+x+"--> ");
            ANFD impresion = anfds.get(x);
            while(impresion.getElemento(y) != 999){
                System.out.print("q"+impresion.getElemento(y)+",");
                y++;
            }
            y=0;
        }
        System.out.println("\n\nAFD:\n");
        System.out.println("Ax-->  0 |  1");
        System.out.print("--------------");
        for(x=0; x<anfds.size(); x++){
            System.out.print("\nA"+x+"--> ");
            ANFD impresion = anfds.get(x);
            if(impresion.getCero(0)!=999){    
                System.out.print("A"+impresion.getCero(0));
            }else{
                System.out.print("  ");
            }
            if(impresion.getUno(0)!=999){ 
                System.out.print(" | A"+impresion.getUno(0));
            }else{
                System.out.print(" |");
            }
        }
        System.out.println("");
        
        Minimizar_AFD(anfds, terminal_q);
        
    }    
    
    public static ArrayList<ANFD> Construir_ANFD(ArrayList<ANFD_E> anfd_es, ArrayList<ANFD> anfds, ANFD anfd){       
        while(anfd.getElemento(anfd.getPuntero_elemento())!=999){
            //System.out.println("Le mando q"+anfd.getElemento(anfd.getPuntero_elemento()));
            anfd = Insertar_Vacios_ANFD(anfd_es, anfd, anfd.getElemento(anfd.getPuntero_elemento()));
            //System.out.println("Ahora iré con q"+anfd.getElemento(anfd.getPuntero_elemento()));
        }
        anfd = Ordenar_Elementos_ANFD(anfd);
        int iguales=1;
        anfds.add(anfd); //Se añade la letra X al arreglo de ANFD
        return anfds;
    }
    
    public static ArrayList<ANFD> Construir_ANFD_Ceros(ArrayList<ANFD_E> anfd_es, ArrayList<ANFD> anfds, ANFD anfd){       
        while(anfd.getElemento(anfd.getPuntero_elemento())!=999){
            //System.out.println("Le mando q"+anfd.getElemento(anfd.getPuntero_elemento()));
            anfd = Insertar_Vacios_ANFD(anfd_es, anfd, anfd.getElemento(anfd.getPuntero_elemento()));
            //System.out.println("Ahora iré con q"+anfd.getElemento(anfd.getPuntero_elemento()));
        }
        anfd = Ordenar_Elementos_ANFD(anfd);
        int iguales=1;
        //Validación ANFD desde aquí
        for(int x=0; x<anfd_es.size(); x++){
            ANFD comparar = anfds.get(x);
            int y=0;
            iguales=1; //Partimos de la premisa de que son iguales
            while(comparar.getElemento(y)!=999 || anfd.getElemento(y)!=999){
                if(comparar.getElemento(y)!=anfd.getElemento(y)) iguales=0;
            }
            if(comparar.getElemento(y)==999 && anfd.getElemento(y)==999) iguales=0;
            if(iguales==1) x=1000;
        }
        //Validación ANFD hasta aquí
        if(iguales==0){
            anfds.add(anfd); //Se añade la letra X al arreglo de ANFD
        }else{
            
        }
        return anfds;
    }
    
    public static ANFD Insertar_Vacios_ANFD(ArrayList<ANFD_E> anfd_es, ANFD anfd, int p_anfd_e){
    //inserta_vacio_anfd recorre todas las posiciones vacías de un qx y las copia en una letra dada
        ANFD_E anfd_e = anfd_es.get(p_anfd_e); //obtenemos el qx según la posición de cont
        int contador = 0; //para recorrer el ANFD-E
        int puntero = 0; //para saber en qué posición se deben insertar los vacíos
        int vacio; //guarda el qx que será insertado en el AFND
        int temp = 0;
        int seinserta;
        while(anfd.getElemento(puntero)!=999){
            puntero++;
        }
        while(anfd_e.getVacio(contador)!=999){ //Con este while recorremos cada posición vacía de una letra del ANFD-E
            vacio = anfd_e.getVacio(contador); //Obtenemos un elemento vacío dada una posición para una letra del ANFD-E
            seinserta = 1;
            while(anfd.getElemento(temp)!=999){
                if(anfd.getElemento(temp)==vacio){ //Si el ítem está 
                    seinserta = 0; //valida que posteriormente no se insertará
                }
                temp++;
            }
            temp=0;
            if(seinserta==1){
                anfd.setElemento(puntero,vacio); //Mandamos el elemento vacío obtenido del ANFD-E al ANFD
                anfd.setElemento(puntero+1,999); //Mandamos el elemento vacío obtenido del ANFD-E al ANFD
                puntero++;  //Sumamos al contador que nos permite insetar en la próxima posición de 0
                //System.out.println("Insertamos q"+vacio);
            }
                contador++; //Sumamos al contador que nos permite revisar la siguiente posición del AFND-E

        }
        anfd.setPuntero_elemento(anfd.getPuntero_elemento()+1);
        
        return anfd;
    }
    
    public static ANFD Ordenar_Elementos_ANFD(ANFD anfd){
int i, j, aux;
    for(i=0;anfd.getElemento(i)<999;i++){
        for(j=0;anfd.getElemento(j)<999;j++){
            if(anfd.getElemento(j+1)<anfd.getElemento(j)){
                aux=anfd.getElemento(j+1); 
                anfd.setElemento(j+1, anfd.getElemento(j));
                anfd.setElemento(j,aux);
            }
        }
    }      
    return anfd;
}
    
    public static ArrayList<ANFD> Nuevos_Elementos(ArrayList<ANFD> anfds, ArrayList<ANFD_E> anfd_es, int puntero_anfds){
    int iguales=1;
    int x=0,y;
    
//Con Cero
    ANFD temporal_cero = new ANFD(); //Creamos un ANFD temporal, esto porque si al final vemos que no se repite lo incluiremos
    ANFD anfd = anfds.get(puntero_anfds); //Obtengo el puntero que vamos a analizar (letra)
    int contador_anfd = 0; //Usado para recorrer el ANFD desde el cual hacemos la iteración con 0
    int contador_temp = 0;
    temporal_cero.setElemento(0, 999); //Definimos que el temporal no tiene elementos todavía, si llega al final así no será agregado
    anfd.setCero(0, 999);    
    anfd.setUno(0, 999);
    
    while(anfd.getElemento(contador_anfd)!=999){ //Permite crear los elementos del nuevo A a partir de transiciones con 0
        ANFD_E anfd_e = anfd_es.get(anfd.getElemento(contador_anfd)); 
        if(anfd_e.getCero(0)!=999){
            temporal_cero.setElemento(contador_temp, anfd_e.getCero(0));
            temporal_cero.setElemento(contador_temp+1, 999);
            contador_temp++;
        }
        contador_anfd++;
    }
    
    if(temporal_cero.getElemento(0)!=999){

    while(temporal_cero.getElemento(temporal_cero.getPuntero_elemento())!=999){ //Agrega los vacíos
            //System.out.println("Le mando q"+temporal_cero.getElemento(temporal_cero.getPuntero_elemento()));
            temporal_cero = Insertar_Vacios_ANFD(anfd_es, temporal_cero, temporal_cero.getElemento(temporal_cero.getPuntero_elemento()));
            //System.out.println("Ahora iré con q"+temporal_cero.getElemento(temporal_cero.getPuntero_elemento()));
    }
    temporal_cero = Ordenar_Elementos_ANFD(temporal_cero);

        temporal_cero.setCero(0, 999);
        temporal_cero.setUno(0, 999);
        
    //Validación ANFD desde aquí
        int sale=0;
        x=0;
        while(x!=anfds.size() && sale==0){
            ANFD comparar = anfds.get(x);
            y=0;
            iguales=0;
            while(comparar.getElemento(y)!=999 && temporal_cero.getElemento(y)!=999){
                if(comparar.getElemento(y)==temporal_cero.getElemento(y)) iguales++;
                 y++;
            }
            if(comparar.getElemento(y)==999 && temporal_cero.getElemento(y)==999) iguales++;
            if(iguales==y+1)sale=1;
            x++;
 
        }
        
        //Validación ANFD hasta aquí
        if(sale==0){
            anfd.setCero(0, anfds.size());
            anfd.setCero(1, 999); 
            anfds.add(temporal_cero); //Añadimos el Temporal al anfd
        }else{
            anfd.setCero(0,x-1);
            anfd.setCero(1,999);
        }
        }
    
        
        //Con Uno
        ANFD temporal_uno = new ANFD(); //Creamos un ANFD temporal, esto porque si al final vemos que no se repite lo incluiremos
        anfd = anfds.get(puntero_anfds); //Obtengo el puntero que vamos a analizar (letra)
        contador_anfd = 0;
        contador_temp = 0;
        temporal_uno.setElemento(0, 999); //Definimos que el temporal no tiene elementos todavía, si llega al final así no será agregado
        
        while(anfd.getElemento(contador_anfd)!=999){
        ANFD_E anfd_e = anfd_es.get(anfd.getElemento(contador_anfd));
            if(anfd_e.getUno(0)!=999){
                temporal_uno.setElemento(contador_temp, anfd_e.getUno(0));
                temporal_uno.setElemento(contador_temp+1, 999);
                contador_temp++;
            }
            contador_anfd++;
        }
        
        if(temporal_uno.getElemento(0)!=999){
        
        while(temporal_uno.getElemento(temporal_uno.getPuntero_elemento())!=999){
        //System.out.println("Le mando q"+temporal_uno.getElemento(temporal_uno.getPuntero_elemento()));
        temporal_uno = Insertar_Vacios_ANFD(anfd_es, temporal_uno, temporal_uno.getElemento(temporal_uno.getPuntero_elemento()));
        //System.out.println("Ahora iré con q"+temporal_uno.getElemento(temporal_uno.getPuntero_elemento()));
        }
        temporal_uno = Ordenar_Elementos_ANFD(temporal_uno);
        temporal_uno.setUno(0, 999);
        temporal_uno.setCero(0, 999);
          
        //Validación ANFD desde aquí
        int sale=0;
        x=0;
        while(x!=anfds.size() && sale==0){
            ANFD comparar = anfds.get(x);
            y=0;
            iguales=0;
            while(comparar.getElemento(y)!=999 && temporal_uno.getElemento(y)!=999){
                if(comparar.getElemento(y)==temporal_uno.getElemento(y)) iguales++;
                y++;
            }
            if(comparar.getElemento(y)==999 && temporal_uno.getElemento(y)==999) iguales++;
            if(iguales==y+1)sale=1;
            x++;
        
        }
        
        //Validación ANFD hasta aquí
        if(sale==0){
            anfd.setUno(0, anfds.size());
            anfd.setUno(1, 999); 
            anfds.add(temporal_uno); //Añadimos el Temporal al anfd
        
        
        }else{
            anfd.setUno(0,x-1);
            anfd.setUno(1,999);
        } 
        }
    puntero_anfds++;
    
    if(puntero_anfds!=anfds.size()) Nuevos_Elementos(anfds, anfd_es,puntero_anfds);
    
    return anfds;
}

    public static ArrayList<ANFD> Minimizar_AFD(ArrayList<ANFD> anfds, int terminal){
    int grupo[] = new int [anfds.size()];
    int grupo_temp[] = new int [anfds.size()];
    ANFD anfd = new ANFD();
    List<Integer> minimo = new ArrayList();
    List<Integer> terminales = new ArrayList();
    int comprobacion[] = new int [anfds.size()];
    int temp[] = new int [anfds.size()];
    int x=0,y;
    int contiene=0;
    int siga=1;
    int iteracion=0;
    //Recorremos los elementos del arreglo ANFD buscando el terminal
    while(x != anfds.size()){

        anfd = anfds.get(x);
        y=0;
        contiene=0;
        while(anfd.getElemento(y)!=999){
            if(anfd.getElemento(y)==terminal)contiene=1;
            y++;
        }
        if(contiene==1){
            grupo[x]=2;
            terminales.add(x);
        }else{
            grupo[x]=1;
        }
        x++;
    }
    
    //Impresión Grupos iniciales
    System.out.println("\nIteracion P"+iteracion+":");
    for(x=0; x<anfds.size();x++){
        System.out.println("A"+x+"--> Grupo"+grupo[x]);
    }
    iteracion++;    
    //P0
    while(siga!=0){
        System.out.println("\nIteracion P"+iteracion+":");
        x=0;
    while(x != anfds.size()){ //itera enlos AFD para generar sus comprobaciones   
        anfd = anfds.get(x);
        if(anfd.getCero(0)!=999){
            comprobacion[x]=grupo[anfd.getCero(0)]*10;
        }
        if(anfd.getUno(0)!=999){
            comprobacion[x]=comprobacion[x]+grupo[anfd.getUno(0)];
        }
        x++;
    }
    //Genera grupos
    x=1;   y=0;
    grupo[0]=1;
    int contador=0;
    int grup=0;
    grupo_temp=grupo;
    while(x != anfds.size()){    
        y=0;
        contador=0;
        while(x!=y){
            if((comprobacion[x]==comprobacion[y])&&(grupo[x]==grupo[y])){
                grupo_temp[x]=grupo[y];
                contador=1;
            }
            y++;
        } 
        if(contador==0){
            grup++;
            grupo_temp[x]=grup;
        }
        x++;
    }
    grupo=grupo_temp;
    x=0;
    while(x != anfds.size()){ 
        System.out.println("A"+x+"--> Grupo"+grupo[x]+" ("+comprobacion[x]+")");
        x++;
    }
    //Comprobación del grupo actual con el anterior
    x=0;
    siga=0;
    while(x != anfds.size()){
        if(temp[x]==grupo[x])siga++;
        x++;
    }
    if(siga==anfds.size()){
        siga=0;
    }else{
        siga=1;
    }
    temp=grupo;
    iteracion++;
    }
    
    //Iteracion para eliminar los elementos duplicados y así obtener el mínimo
    iteracion=1;
    x=0;
    while(x!=grupo.length){
        minimo.add(grupo[x]);
        x++;
    }
    //while(iteracion!=0){
    System.out.println("\nEliminación de Elementos:");
        x=minimo.size()-1;
        while(x!=0){
            y=x-1;
            while(y!=0){
                if(minimo.get(x)==minimo.get(y)){
                    int a=0;
                    while(a!=anfds.size()){
                        anfd = anfds.get(a);
                        if(anfd.getCero(0)==x)anfd.setCero(0,y);
                        if(anfd.getUno(0)==x)anfd.setUno(0,y);
                        a++;
                    }  
                    a=0;

                    while(a!=anfds.size()-1){
                        anfd = anfds.get(a);
                        if(anfd.getCero(0)>x&&anfd.getCero(0)!=999){
                            anfd.setCero(0,anfd.getCero(0)-1);
                        }
                        if(anfd.getUno(0)>x&&anfd.getUno(0)!=999){
                            anfd.setUno(0,anfd.getUno(0)-1);
                        }
                        a++;
                    }                    
                    anfds.remove(x); 
                    
                    minimo.remove(x);
                    for (a=terminales.size()-1;a>=0;a--){
                        if(terminales.get(a)==x)terminales.remove(a);
                        if(terminales.get(a)>x)terminales.set(a,terminales.get(a)-1);
                    
                    }

                    System.out.println("Eliminación de A"+x);
                    y=1;
                }
                /*                if(x<anfds.size()){
                int v=x;
                while(v!=anfds.size()){
                anfd = anfds.get(v);
                if(anfd.getCero(0)!=999){
                anfd.setCero(0, anfd.getCero(0)-1);
                }
                if(anfd.getUno(0)!=999){
                anfd.setUno(0, anfd.getUno(0)-1);
                }
                v++;
                }
                }*/
                y--;
            }
            x--;  
        }
    //}
        System.out.println("\nAFD Mínimo:\n");
        System.out.println("Ax-->  0 |  1");
        System.out.print("--------------");
        for(x=0; x<anfds.size(); x++){
            System.out.print("\nA"+x+"--> ");
            ANFD impresion = anfds.get(x);
            if(impresion.getCero(0)!=999){    
                System.out.print("A"+impresion.getCero(0));
            }else{
                System.out.print("  ");
            }
            if(impresion.getUno(0)!=999){ 
                System.out.print(" | A"+impresion.getUno(0));
            }else{
                System.out.print(" |");
            }
        }
        System.out.print("\n\n");
        x=0;
        System.out.print("Terminales: ");
        while(x<terminales.size()){
            System.out.print(terminales.get(x)+",");
            x++;
        }
        System.out.print("\n\n");
    return anfds;  
}

    public static ArrayList<ANFD_E> Concatenar_ANFD_E(ArrayList<ANFD_E> anfd_es, ArrayList<ANFD_E> anfd_esu, int inicial_q, int inicial_r, int terminal_q, int terminal_r, String tipo_concatenacion){
    ANFD_E anfd_e = new ANFD_E(); 
    ANFD_E anfd_eu = new ANFD_E(); 
    int cont=0,x=0;
    int largo = anfd_es.size();
    if(tipo_concatenacion.contains("Q+R")){
        System.out.println(tipo_concatenacion);
        anfd_e.setCero(0, 999);
        anfd_e.setUno(0, 999);
        anfd_e.setVacio(0, inicial_q+1);
        anfd_e.setVacio(1, inicial_r+1+largo);
        anfd_e.setVacio(2, 999);
        anfd_es.add(0, anfd_e);
        
        cont++;
        while(cont!=anfd_es.size()){
            anfd_e = anfd_es.get(cont);
            if(anfd_e.getCero(0)!=999){
                anfd_e.setCero(0, anfd_e.getCero(0)+1);
            }
            if(anfd_e.getUno(0)!=999){
                anfd_e.setUno(0, anfd_e.getUno(0)+1);
            }
            x=0;
            while(anfd_e.getVacio(x)!=999){
                if(anfd_e.getVacio(0)!=999){
                    anfd_e.setVacio(x, anfd_e.getVacio(x)+1);
                }
                x++;
            }
            cont++;
        }
        cont=0;
        while(cont!=anfd_esu.size()){
            anfd_eu = anfd_esu.get(cont);
            if(anfd_eu.getCero(0)!=999){
                anfd_eu.setCero(0, anfd_eu.getCero(0)+largo+1);
            }
            if(anfd_eu.getUno(0)!=999){
                anfd_eu.setUno(0, anfd_eu.getUno(0)+largo+1);
            }
            x=0;
            while(anfd_eu.getVacio(x)!=999){
                if(anfd_eu.getVacio(0)!=999){
                    anfd_eu.setVacio(x, anfd_eu.getVacio(x)+largo+1);
                }
                x++;
            }
            anfd_es.add(anfd_eu);
            cont++;
        }
        anfd_e = new ANFD_E();
        anfd_e.setCero(0, 999);
        anfd_e.setUno(0, 999);
        anfd_e.setVacio(0, 999);
        anfd_es.add(anfd_e);
        anfd_e = anfd_es.get(terminal_q);
        cont=0;
        while(anfd_e.getVacio(cont)!=999){
            cont++;
        }
        anfd_e.setVacio(cont-1,anfd_es.size()-1);
        anfd_e.setVacio(cont,999);
        anfd_e = anfd_es.get(terminal_r+largo+1);
        cont=0;
        while(anfd_e.getVacio(cont)!=999){
        cont++;
        }
        anfd_e.setVacio(cont,anfd_es.size()-1);
        anfd_e.setVacio(cont+1,999);

    }else{

        while(cont!=anfd_esu.size()){
            anfd_eu = anfd_esu.get(cont);
            if(anfd_eu.getCero(0)!=999){
                anfd_eu.setCero(0, anfd_eu.getCero(0)+largo);
            }
            if(anfd_eu.getUno(0)!=999){
                anfd_eu.setUno(0, anfd_eu.getUno(0)+largo);
            }
            x=0;
            while(anfd_eu.getVacio(x)!=999){
                if(anfd_eu.getVacio(0)!=999){
                    anfd_eu.setVacio(x, anfd_eu.getVacio(x)+largo);
                }
                x++;
            }
            anfd_es.add(anfd_eu);
            cont++;

        }
        anfd_e = anfd_es.get(terminal_q);
        cont=0;
        
        while(anfd_e.getVacio(cont)!=999){
            cont++;
        }
        anfd_e.setVacio(cont,inicial_r+largo);
        anfd_e.setVacio(cont+1,999);
    }
    cont=0;
    System.out.println("\nANFD-e Concatenado");
    System.out.print("\nqx--> 0 \t 1 \t vacio");
    System.out.print("\n---------------------------------------");
    while(cont!=anfd_es.size()){
        System.out.print("\nq"+cont+"-->");
        anfd_e = anfd_es.get(cont);
        x=0;
        if(anfd_e.getCero(x)!=999){
            System.out.print("(0):"+anfd_e.getCero(x));
        }else{
            System.out.print("(0):  ");
        }
        if(anfd_e.getUno(x)!=999){
            System.out.print("\t(1):"+anfd_e.getUno(x));
        }else{
            System.out.print("\t(1): ");
        }
        System.out.print("\t(e):");
        while(anfd_e.getVacio(x)!=999){
            System.out.print(anfd_e.getVacio(x)+",");
            x++;
        }
        cont++;
    }
return anfd_es;
}

}
    
