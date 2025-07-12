/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prueba1;

/**
 *
 * @author GotrixGamer
 */
public class Interesado {
    private String dni;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String mail;
    private boolean esTrabajadorUl;

    public Interesado(String dni, String nombres,String apellidos, String telefono, String mail, boolean esTrabajadorUl) {
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.mail = mail;
        this.esTrabajadorUl = esTrabajadorUl;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public boolean isEsTrabajadorUl() {
        return esTrabajadorUl;
    }

    public void setEsTrabajadorUl(boolean esTrabajadorUl) {
        this.esTrabajadorUl = esTrabajadorUl;
    }
    
}
