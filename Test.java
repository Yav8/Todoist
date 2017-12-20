
public class Test {
    /**
     * Metodo principal
     */
    public static void main(String[] args) {
        
    }
    
    public void test3() {
        Todoist todoist = new Todoist();

        todoist.addTarea("Hacer la cama");
        todoist.addTarea("Hacer la cama");
        todoist.addTarea("Estudiar");
        todoist.addTarea("Comer");       
        System.out.println("Añadimos 4 tareas: Hacer la cama, Hacer la cama, Estudiar y Comer");
        
        todoist.eliminarTodasTareasCoincidentes("Hacer la cama");
        System.out.println("Eliminamos todas las tareas coincidentes");
        System.out.println("Aplicamos el test:");
        if(todoist.getNumeroDeTareasPendientes() < 4) {
            System.out.println("Se han eliminado las tareas coincidentes correctamente. El número de tareas actuales es: " + todoist.getNumeroDeTareasPendientes());
        }
        else {
            System.out.println("ERROR, no se ha eliminado la tarea");
        }
    }
    
    public void test2() {
        Todoist todoist = new Todoist();

        todoist.addTarea("Hacer la cama");
        todoist.addTarea("Hacer la cama");
        todoist.addTarea("Estudiar");
        todoist.addTarea("Comer");       
        System.out.println("Añadimos 4 tareas: Hacer la cama, hacer los deberes, estudiar y comer");
        
        todoist.eliminarPrimeraTareaCoincidente("Hacer la cama");
        System.out.println("Eliminamos la primera tarea coincidente");
        System.out.println("Aplicamos el test:");
        if(todoist.getNumeroDeTareasPendientes() == 3) {
            System.out.println("Se ha eliminado la primera tarea coincidente correctamente. El número de tareas actuales es: " + todoist.getNumeroDeTareasPendientes());
        }
        else {
            System.out.println("ERROR, no se ha eliminado la tarea");
        }
    }
    
    public void test1() {
        System.out.println("Creamos un objeto todoist...");
        Todoist todoist = new Todoist();
        System.out.println("Mostramos el numero de tareas pendientes...");
        todoist.mostrarNumeroTareasPendientes();
        System.out.println("Añadimos una tarea...");
        todoist.addTarea("Hacer una tortilla de patata");
        System.out.println("Añadimos otra tarea...");
        todoist.addTarea("Sacar la basura");
        System.out.println("Añadimos otra tarea...");
        todoist.addTarea("Dormir la siesta");
        System.out.println("\nMostramos todas las tareas...");
        todoist.mostrarTareas();
        System.out.println("\nEliminamos la segunda tarea...");
        boolean valorDevuelto;
        valorDevuelto = todoist.eliminarTarea(1);
        System.out.println("El metodo de eliminar anterior devolvio...");
        System.out.println(valorDevuelto);
        todoist.eliminarTarea(1);
        System.out.println("\nMostramos todas las tareas...");
        todoist.mostrarTareas();
        System.out.println("\nIntentamos borrar una tarea que no existe...");
        valorDevuelto = todoist.eliminarTarea(1000);
        System.out.println("El metodo de eliminar anterior devolvio...");
        System.out.println(valorDevuelto);
        System.out.println("\nMostramos todas las tareas...");
        todoist.mostrarTareas();
        System.out.println("\n### Intentamos borrar una tarea que no existe...");
        valorDevuelto = todoist.eliminarTarea(1000);
        System.out.println("El metodo de eliminar anterior devolvio...");
        System.out.println(valorDevuelto);   
        
        System.out.println("\n### Añadimos varias tareas...");
        todoist.addTarea("Estudiar 'Programacion'");
        todoist.addTarea("Estudiar 'Entornos'");
        
        System.out.println("\n### Mostramos todas las tareas...");
        todoist.mostrarTareas();    
        
        System.out.println("\n### Mostramos las tareas numeradas...");
        todoist.mostrarTareasNumeradas();
        
        System.out.println("\n### Mostramos las tareas impares unicamente...");
        todoist.mostrarTareasEnPosicionImpar();
        
        System.out.println("\n### Mostramos las tareas que contienen el texto 'Estudiar'...");
        todoist.mostrarCoincidentes("estudiar");
    }
}
