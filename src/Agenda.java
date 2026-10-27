import java.util.*;

public class Agenda {
    //inicializacionde arrays
    private Map<String,Contacto> contactos = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    private Set<String> grupos = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
    private Map<String, Set<String>> gruposContactos = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    private List<Contacto> contactosList = new ArrayList<>();

    //metodo de agregar contacto
    public void agregarContacto (Contacto c){

        if (contactos.containsKey(c.getNombre())){
            System.out.println("El contacto "+c+" ya existe");
        }
        else{
            contactos.put(c.getNombre(), c);
            contactosList.add(c);
            System.out.println("El contacto "+c+" se ha agregado");
        }

    }
    //Metodo de buscar contacto
    public Contacto buscarContacto (String nombre){
        //retornar el contacto o null si no existe
        return contactos.get(nombre);
    }
    //metodo eiminar contacto
    public boolean  eliminarContacto(String nombre){
        //eliminar el usuario del map y de los grupos
        //return true;
        if (!contactos.containsKey(nombre)){
            System.out.println("El contacto "+nombre+" no existe");
            return false;
        }
        Contacto contacto = contactos.get(nombre);
        contactosList.remove(contacto);

        contactos.remove(nombre);

        for(Set<String> grupos: gruposContactos.values()){
            grupos.remove(nombre);
        }
        System.out.println("El contacto "+nombre+" se ha eliminado");
        return true;
    }
    //metodo para listar contactos
    public void listarContactos(){
        //muestra todos los contactos en orden alfabetico
        //TreeMap
        System.out.println("Contactos en orden alfabetico:");
        for (Contacto contacto : contactos.values()){
            System.out.println(contacto.toString());
        }
    }
    //metodo para listarHistorial
    public void listarHistorial(){
        /*el historial es una List<Contacto> que guarda los
           contactos en el orden en que se agregaron. Es independiente del TreeMap , que los
            guarda ordenados por nombre. Esto te permite comparar dos comportamientos:
            orden de inserción ( ArrayList ) vs orden alfabético ( TreeMap ).*/
        //muestra los contactos en el orden que se agregaron
        //ArayList
        System.out.println("Historial en orden de entrada:");
        for (Contacto contacto : contactosList){
            System.out.println(contacto.toString());
        }

    }
    //metodo para agregarGrupo
    public void agregarGrupo(String nombreGrupo){
        if(grupos.contains(nombreGrupo)){
            System.out.println("El Grupo "+nombreGrupo+" ya existe");
        }
        else{
            grupos.add(nombreGrupo);
            gruposContactos.put(nombreGrupo, new TreeSet<>());
            System.out.println("El Grupo "+nombreGrupo+" se ha agregado");
        }
        //si ya existe muestra error
    }
    //metodo para agregar contacto a grupo
    public void agregarContactoAGrupo(String nombreContacto, String nombreGrupo){
        //agregar nombre del contato al grupo calidar que ambos existan
        if(!contactos.containsKey(nombreContacto)){
            System.out.println("El contacto "+nombreContacto+" no existe");
            return;
        }
        if(!gruposContactos.containsKey(nombreGrupo)){
            System.out.println("El gripo "+nombreGrupo+" se no existe");
            return;
        }
        gruposContactos.get(nombreGrupo).add(nombreContacto);
        System.out.println("El contacto "+nombreContacto+" se ha agregado al grupo");

    }
    //metodo para listar los grupos en orden alfabetico
    public void listarGrupos(){
        //Muestra los gurpos en orden alfabetico
        System.out.println("Grupos en orden alfabetico:");
        for (String grupo : grupos){
            System.out.println(" + "+grupo);
        }
    }
    //metodo para moatrarcontactos por grupo
    public void mostrarContactosPorGrupos(String nombreGrupo){
        //muestra lis contactos del grupo si el grupo no existe o esta vacio muestra error
        if(!grupos.contains(nombreGrupo)){
            System.out.println("El Grupo "+nombreGrupo+" no existe");
            return;
        }
        Set<String> miembos = gruposContactos.get(nombreGrupo);
        if(miembos.isEmpty()){
            System.out.println("El grupo "+nombreGrupo+" esta vacio");
        }else {
            System.out.println("los contactos del grupo son: ");
            for (String contacto : miembos){
                Contacto c = contactos.get(contacto);
                System.out.println(c.toString());
            }
        }
    }

}
