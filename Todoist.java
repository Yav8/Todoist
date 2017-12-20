import java.util.ArrayList;

/**
 * Clase que permite almacenar las tareas pendientes que tenemos por hacer
 */
public class Todoist {
    // Almacena nuestras tareas
    private ArrayList<String> tareas;
    private ArrayList<String> tareaCompletada;    
    /**
     * Constructor de la clase Todoist.
     */
    public Todoist() {
        tareas = new ArrayList<String>();
    }

    /**
     * Inserta una nueva tarea
     */
    public void addTarea(String nombreTarea) {
        tareas.add(nombreTarea);
    }

    /**
     * Muestra por pantalla todas las tareas existentes
     */
    public void mostrarTareas() {
        System.out.println("Tareas existentes");
        System.out.println(tareas);
    }

    /**
     * Devuelve el numero de tareas existentes
     */
    public int getNumeroDeTareasPendientes() {
        return tareas.size();
    }

    /**
     * Imprime por pantalla el numero de tareas pendientes
     */
    public void mostrarNumeroTareasPendientes() {
        System.out.println(tareas.size());
    }

    /**
     * Elimina la tarea que ocupa la posicion indicada como
     * parametro (empezando en 0). Devuelve true si elimina una 
     * tarea, false en caso contrario
     */
    public boolean eliminarTarea(int posicionTarea) {
        boolean valorADevolver = false;
        if(esValidoElIndice(posicionTarea)) {
            tareas.remove(posicionTarea);
            valorADevolver = true;
        }
        return valorADevolver;
    }

    /**
     * Metodo que comprueba si una posicion es valida y devuelve true
     * en caso afirmativo o false en otro caso.
     */
    public boolean esValidoElIndice(int indice) {
        boolean valorADevolver = false;
        if(indice >= 0 && indice < getNumeroDeTareasPendientes()){
            valorADevolver = true;
        }
        return valorADevolver;
    }

    /**
     * Metodo que devuelve true en caso de que haya tareas por hacer, 
     * false en otro caso
     */
    public boolean hayTareasPendientes() {
        boolean valorADevolver = false;
        if(getNumeroDeTareasPendientes() > 0) {
            valorADevolver = true;
        }
        return valorADevolver;
    }

    /**
     * Lo mismo que el metodo hayTareasPendientes pero resuelto en una linea
     */
    public boolean haTareasPendientes() {
        return (getNumeroDeTareasPendientes() > 0);
    }

    /**
     * Lo mismo que el metodo esValidoElIndice pero resuelto en una linea
     */
    public boolean esValidoElIndic(int indic) {
        return (indic >= 0 && indic < getNumeroDeTareasPendientes());
    }

    /**
     * Metodo que imprime todas las tareas existentes, una por linea.
     * El metodo imprime el numero de posicion de la tarea antes del
     * nombre de la tarea. Si la tarea está completada, entonces muestra
     * un "[X]" delante de la tarea; si no está completada muestra un "[ ]"
     */
    public void mostrarTareasNumeradas()
    {
        int numeroPosicion = 1;
        for (String tarea : tareas){
            if (tarea.substring(0,1).equals("$")) {
                System.out.println(numeroPosicion + ". [X] " + tarea.substring(1, tarea.length()));                
            }
            else {
                System.out.println(numeroPosicion + ". [ ] " + tarea);                 
            }

            numeroPosicion = numeroPosicion + 1;
        }
    }

    /**
     * Muestra solo las tareas en posiciones impares sin numero delante ni nada,
     * solo la tarea
     */
    public void mostrarTareasEnPosicionImpar() {
        int numeroPosicion = 1;
        for (String tarea : tareas){
            if (tarea.substring(0,1).equals("$")) {
                System.out.println(numeroPosicion + ". [X] " + tarea.substring(1, tarea.length()));                
            }
            else {
                System.out.println(numeroPosicion + ". [ ] " + tarea);                 
            }
            numeroPosicion = numeroPosicion + 1;
        }
    }

    /**
     * Muestra por pantalla todas las tareas que contienen el texto indicado
     * como parámetro, una en cada línea, y además muestra un mensaje al final 
     * indicando el numero de coincidencias encontradas. Si no hay ninguna que 
     * contenga el texto buscado informa de la situación. Este método es 
     * insensible a mayúsculas o minúsculas.
     */
    public void mostrarCoincidentes(String textoABuscar) {
        boolean hayCoincidencia = false;
        int numeroTareasCoincidentes = 0;
        for(String tarea : tareas) {
            // Si textoABuscar contiene ALGO de tarea, entonces imprime.
            if(tarea.toLowerCase().contains(textoABuscar.toLowerCase())){
                numeroTareasCoincidentes += 1;
                System.out.println(tarea);
                hayCoincidencia = true;
            }
        }
        if(hayCoincidencia == false){
            System.out.println("No hay coincidencias");
        }
        else {
            System.out.println("El número de tareas coincidentes es " + numeroTareasCoincidentes);
        }
    }

    /**
     * Muestra por pantalla la primera tarea que contenga el texto indicado como
     * parámetro. En caso de que no haya ninguna coincidencia no muestra nada.
     */
    public void mostrarPrimeraCoincidente(String textoABuscar) {
        boolean yaSeHaImpresoLaPrimeraTareaCoincidente = false;
        for(String tarea : tareas) {
            if(yaSeHaImpresoLaPrimeraTareaCoincidente == false && tarea.toLowerCase().contains(textoABuscar.toLowerCase())) {
                System.out.println(tarea);
                yaSeHaImpresoLaPrimeraTareaCoincidente = true;
            }
        }
    }

    /**
     * Muestra por pantalla todas las tareas existentes, una por línea,
     * usando un bucle while
     */
    public void mostrarTareas2() {
        int posicionTareaActual = 0;
        while(posicionTareaActual < tareas.size()) {
            System.out.println(tareas.get(posicionTareaActual));
            posicionTareaActual += 1;
        }
    }

    /**
     * Muestra las tareas numeradas usando un bucle while empezando en 1
     */
    public void mostrarTareasNumeradas2() {
        int posicionTarea = 0;
        while(posicionTarea < tareas.size()) {
            System.out.println((posicionTarea + 1) + ". " + tareas.get(posicionTarea));
            posicionTarea += 1;
        }
    }

    /**
     * Muestra por pantalla las primeras n tareas (siendo n un parametro). En
     * caso de que no haya suficientes tareas muestra solo las que haya.
     */
    public void mostrarNPrimeras(int n) {
        int posicionTarea = 0;
        while(posicionTarea < tareas.size() && posicionTarea < n) {
            System.out.println((posicionTarea + 1) + ". " + tareas.get(posicionTarea));
            posicionTarea += 1;
        }
    }

    /**
     * Devuelve true si hay al menos una tarea que contenga el texto indicado
     * como parámetro y false en caso contrario. El método se debe ejecutar de
     * la forma más rápida posible
     */
    public boolean hayTareaCoincidente(String textoABuscar) {
        boolean hayTareaCoincidente = false;
        String tarea = "";
        int contador = 0;
        while(contador < tareas.size() && hayTareaCoincidente == false) {
            tarea = tareas.get(contador);
            if(tarea.toLowerCase().contains(textoABuscar.toLowerCase())) {
                hayTareaCoincidente = true;
            }
            contador += 1;
        }
        return hayTareaCoincidente;
    }

    /**
     * Elimina la primera tarea que contiene el texto indicado por parámetro
     */
    public void eliminarPrimeraTareaCoincidente(String textoABuscar) {
        int contador = 0;
        String tarea = "";
        boolean tareaEliminada = false;

        while(contador < tareas.size() && tareaEliminada == false) {
            tarea = tareas.get(contador);
            if(tarea == textoABuscar) {
                tareas.remove(tarea);
                tareaEliminada = true;
            }
            contador += 1;
        }
    }

    /**
     * Elimina todas las tareas que contienen el texto a buscar
     */
    public void eliminarTodasTareasCoincidentes(String textoABuscar) {
        int contador = 0;
        String tarea = "";

        while(contador < tareas.size()) {
            tarea = tareas.get(contador);
            if(tarea == textoABuscar) {
                tareas.remove(tarea);
                contador -= 1;
            }
            contador += 1;
        }
    }

    /**
     * Marca como completada la tarea indicada como parámetro. Por ejemplo,
     * si el parámetro es 0 marca como completada la primera tarea, si es 1 la
     * segunda, etc.
     */
    public void marcarComoCompletada(int indiceTarea) {
        String tarea = tareas.get(indiceTarea);
        tarea = "$" + tarea;
        tareas.set(indiceTarea, tarea);
    }
}