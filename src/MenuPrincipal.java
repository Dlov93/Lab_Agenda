import java.util.Scanner;

public class MenuPrincipal {
    public static void main(String[] args) {
        int opcion = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor escoja una opcion");
        while(opcion<10 && opcion>0){
            System.out.println("=== AGENDA DE CONTACTOS ===");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Buscar contacto");
            System.out.println("3. Eliminar contacto");
            System.out.println("4. Listar contactos (orden alfabetico)");
            System.out.println("5. Listar historial (orden de insercion)");
            System.out.println("6. Agregar grupo");
            System.out.println("7. Agregar contacto a grupo");
            System.out.println("8. Listar grupos");
            System.out.println("9. Mostrar contactos por grupo");
            System.out.println("10. Salir");
            System.out.println("===========================================");
            System.out.println("Elige una opcion");
            opcion = scanner.nextInt();

            switch (opcion){
                case 1: {
                    System.out.println("Ingresa el nombre del contacto");
                    String nombre = scanner.next();
                    System.out.println("Ingresa el telefono del contacto");
                    String telefono = scanner.next();
                    System.out.println("Ingresa el email del contacto");
                    String email = scanner.next();
                }
                case 2: {
                    System.out.println("Ingresa el nombre del contacto");
                    String nombre = scanner.next();
                }
                case 3: {
                    System.out.println("Ingresa el nombre del contacto");
                    String nombre = scanner.next();
                }
                case 4: {
                    //Agenda.listarContacto();
                }
                case 5: {
                    //Agenda.listarHistorial();
                }
                case 6: {
                    System.out.println("Ingresa el nombre del grupo");
                    String nombre = scanner.next();
                    //Agenta.agregarGrupo();
                }
                case 7: {
                    System.out.println("Ingresa el nombre del contacto");
                    String nombre = scanner.next();
                    System.out.println("Ingresa el telefono del grupo");
                    String grupo = scanner.next();
                    //Agenda.agregarContactoAGrupo(nombre,grupo);
                }
                case 8: {
                    //Agenda.listarGrupos();
                }
                case 9: {
                    System.out.println("Ingresa el nombre del grupo");
                    String nombreGrupo = scanner.next();
                    //Agenda.mostrarContactosPorGrupos(nombreGrupo)
                }


            }

        }scanner.close();

    }
}
