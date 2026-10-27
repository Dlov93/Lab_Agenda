import java.util.Scanner;

public class MenuPrincipal {

    public static void main(String[] args) {
        //inicializamos el escanner
        Scanner scanner = new Scanner(System.in);
        //creamos el objero agenda
        Agenda agenda = new Agenda();
        //Variable de opciones
        int opcion = 0;

        System.out.println("Por favor escoja una opcion");
        //Menu de opciones
        while(opcion != 10){
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

            //validacion hasNextInt
            if(scanner.hasNextInt()){
                opcion = scanner.nextInt();
                scanner.nextLine();


            switch (opcion){
                //agregar contacto
                case 1: {
                    System.out.println("Ingresa el nombre del contacto");
                    String nombre = scanner.nextLine();
                    System.out.println("Ingresa el telefono del contacto");
                    String telefono = scanner.nextLine();
                    System.out.println("Ingresa el email del contacto");
                    String email = scanner.nextLine();

                    Contacto nuevocontacto = new Contacto(nombre, telefono, email);
                    agenda.agregarContacto(nuevocontacto);
                    break;
                }
                //Buscar contacto
                case 2: {
                    System.out.println("Ingresa el nombre del contacto");
                    String nombre = scanner.nextLine();
                    Contacto encontrado = agenda.buscarContacto(nombre);
                    if(encontrado != null){
                        System.out.println("Contacto "+encontrado.toString()+ "Encontrado");
                    }else{
                        System.out.println("Contacto no encontrado");
                    }
                    break;
                }
                //Eliminar contacto
                case 3: {
                    System.out.println("Ingresa el nombre del contacto");
                    String nombre = scanner.nextLine();
                    agenda.eliminarContacto(nombre);
                    break;
                }
                //Listar contactos en orden alfabetico
                case 4: {
                    agenda.listarContactos();
                    break;
                }
                //Listar contactos en orden inserccion
                case 5: {
                    agenda.listarHistorial();
                    break;
                }
                //Agregar grupo
                case 6: {
                    System.out.println("Ingresa el nombre del grupo");
                    String nombreGrupo = scanner.nextLine();
                    agenda.agregarGrupo(nombreGrupo);
                    break;
                }
                //Agregar contacto a grupo
                case 7: {
                    System.out.println("Ingresa el nombre del contacto");
                    String nombre = scanner.nextLine();
                    System.out.println("Ingresa el telefono del grupo");
                    String grupo = scanner.nextLine();
                    agenda.agregarContactoAGrupo(nombre,grupo);
                }
                //Listar grupos
                case 8: {
                    agenda.listarGrupos();
                    break;
                }
                //Mostrar contactos por grupo
                case 9: {
                    System.out.println("Ingresa el nombre del grupo");
                    String nombreGrupo = scanner.nextLine();
                    agenda.mostrarContactosPorGrupos(nombreGrupo);
                    break;
                }
                //Salir del menu
                case 10: {
                    System.out.println("Saliendo del menu");
                    break;
                } default:
                    System.out.println("Opcion invalida elige una opcion nueva:");
                    break;


            }

            }else {
                System.out.println("Opcion invalida elige una opcion del 1 al 10");
            }

        }
        //cerrar el scanner
        scanner.close();

    }
}
