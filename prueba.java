/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prueba1;

/**
 *
 * @author GotrixGamer
 */
public class prueba {
    public static void main(String[] args) {
        GestorTramites gestor = new GestorTramites();

        // Crear interesados
        Interesado i1 = new Interesado("12345678", "Ana Torres", "900111222", "ana@mail.com", false);
        Interesado i2 = new Interesado("87654321", "Luis Pérez", "900333444", "luis@mail.com", true);
        Interesado i3 = new Interesado("45678912", "Carla Díaz", "900888555", "carla@mail.com", false);

        // Crear documentos de referencia
        Documento d1 = new Documento("Solicitud A", "Descripción A", "archivoA.pdf");
        Documento d2 = new Documento("Solicitud B", "Descripción B", "archivoB.pdf");
        Documento d3 = new Documento("Solicitud C", "Descripción C", "archivoC.pdf");

        // Registrar expedientes
        gestor.registrarExpediente("Alta", i1, "Trámite urgente", d1);
        gestor.registrarExpediente("Media", i2, "Consulta académica", d2);
        gestor.registrarExpediente("Alta", i3, "Solicitud de constancia", d3);

        System.out.println("\n📋 Lista de pendientes:");
        gestor.mostrarExpediente();

        // Finalizar un expediente (por ID exacto, ej: EXP001)
        System.out.println("\n✅ Finalizando EXP001...");
        gestor.finalizarExpediente("EXP001");

        // Mostrar alerta automática desde lista circular
        System.out.println("\n🔔 Alerta automática:");
        Expediente alerta = gestor.alertaSiguiente();
        if (alerta != null) {
            System.out.println("📢 " + alerta.getId() + ": " + alerta.getAsunto() + " [" + alerta.getPrioridad() + "]");
        } else {
            System.out.println("No hay expedientes finalizados aún.");
        }
    }
}
