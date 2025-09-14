package service;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Sistema de Control de Lugares Turísticos ===");

        // Crear fotografía
        Fotografia foto = new Fotografia("jpg", "/fotos/juan.jpg", 85.5);
        System.out.println("Fotografía: " + foto);

        // Crear perfil
        Perfil perfil = new Perfil("Aventurero", "Le gusta explorar lugares nuevos");
        System.out.println("Perfil: " + perfil);

        // Crear lugares
        Lugar antigua = new Lugar("Antigua Guatemala", "Sacatepéquez", "78451234");
        Lugar tikal = new Lugar("Tikal", "Petén", "12345678");
        Lugar atitlan = new Lugar("Lago de Atitlán", "Sololá", "87654321");

        System.out.println("\n=== Lugares registrados ===");
        System.out.println(antigua);
        System.out.println(tikal);
        System.out.println(atitlan);

        // Crear persona
        Persona juan = new Persona("Juan Carlos", "Pérez López", foto, perfil);

        // Agregar lugares visitados
        juan.agregarLugar(antigua);
        juan.agregarLugar(tikal);
        juan.agregarLugar(atitlan);

        System.out.println("\n=== Persona y lugares visitados ===");
        System.out.println(juan);

        System.out.println("\n=== Cantidad de lugares visitados: " +
                juan.getLugaresVisitados().size() + " ===");
    }
}