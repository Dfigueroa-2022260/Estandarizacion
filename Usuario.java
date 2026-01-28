package org.djoserfigueroa.model;

/**
 * Representa a un usuario autenticado del sistema de agenda de contactos.
 * Extiende AbstractContacto añadiendo funcionalidades de autenticación
 * y gestión de credenciales.
 *
 * Reutiliza la información básica de contacto e incorpora atributos
 * específicos para usuarios que pueden autenticarse y gestionar contactos.
 * 
 * @author Djoser Emanuel Figueroa Jimenez
 * @version 1.0
 * @since 2025
 */

public class Usuario extends AbstractContacto {
    
    //ATRIBUTOS DEL USUARIO
    
    /** 
     * Identificador único del usuario en la tabla de usuarios.
     * Diferente al idContacto heredado, representa la identidad autenticable.
     */
    private int idUsuario;
    
    /** 
     * Dirección de correo electrónico utilizada como credencial de acceso.
     * Debe ser única en el sistema y servir como nombre de usuario.
     */
    private String emailUsuario;
    
    /** 
     * Contraseña encriptada o en texto plano para autenticación.
     * NOTA: En producción debería almacenarse encriptada con hash seguro.
     */
    private String contrasenia;
    
    /** 
     * Número de teléfono específico del usuario.
     * Puede diferir del telefonoContacto heredado si el usuario
     * mantiene números separados para diferentes propósitos.
     */
    private int telefonoUsuario;
    
    // ===== CONSTRUCTORES =====
    
    /**
 * Constructor por defecto de Usuario.
 * Inicializa la clase padre AbstractContacto y los atributos propios
 * con valores predeterminados.
 *
 * Permite crear instancias vacías que se completarán posteriormente
 * mediante setters o procesos de autenticación.
 */

    public Usuario() {
        super(); // Inicializa la clase padre AbstractContacto
    }
    
   /**
    * Constructor que crea un usuario usando únicamente sus datos de autenticación.
    * Ideal cuando no se requiere información de contacto completa.
    *
    * @param idUsuario Identificador único del usuario.
    * @param emailUsuario Correo electrónico usado como credencial.
    * @param contrasenia Contraseña del usuario.
    * @param telefonoUsuario Teléfono del usuario.
    */

    
    public Usuario(int idUsuario, String emailUsuario, String contrasenia, int telefonoUsuario) {
        // No llama a super() con parámetros, deja los datos de contacto vacíos
        this.idUsuario = idUsuario;
        this.emailUsuario = emailUsuario;
        this.contrasenia = contrasenia;
        this.telefonoUsuario = telefonoUsuario;
    }
    
    /**
     * Constructor completo que inicializa tanto datos de contacto como de usuario.
     * Permite crear una instancia de Usuario con información personal completa
     * y credenciales de autenticación.
     * 
     * @param idUsuario Identificador único del usuario
     * @param emailUsuario Email para autenticación
     * @param contrasenia Contraseña del usuario
     * @param telefonoUsuario Teléfono específico del usuario
     * @param idContacto ID del contacto (de la clase padre)
     * @param nombre Nombre del usuario
     * @param apellido Apellido del usuario
     * @param genero Género del usuario
     * @param categoria Categoría de contacto
     * @param fechaNacimiento Fecha de nacimiento
     * @param direccion Dirección de residencia
     * @param telefono Teléfono de contacto (heredado)
     * @param email Email de contacto (heredado)
     */
    public Usuario(int idUsuario, String emailUsuario, String contrasenia, int telefonoUsuario, 
                   int idContacto, String nombre, String apellido, String genero, String categoria, 
                   String fechaNacimiento, String direccion, int telefono, String email) {
        // Inicializa la clase padre con datos de contacto completos
        super(idContacto, nombre, apellido, genero, categoria, fechaNacimiento, direccion, telefono, email);
        
        // Inicializa atributos específicos de usuario
        this.idUsuario = idUsuario;
        this.emailUsuario = emailUsuario;
        this.contrasenia = contrasenia;
        this.telefonoUsuario = telefonoUsuario;
    }
    
    //GETTERS AND SETTERS
    
    /**
     * Obtiene el identificador único del usuario.
     * @return ID del usuario en la tabla de usuarios
     */
    public int getIdUsuario() {
        return idUsuario;
    }
    
    /**
     * Establece el identificador único del usuario.
     * @param idUsuario ID del usuario (debe ser positivo y único)
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    /**
     * Obtiene el email utilizado para autenticación.
     * @return Email de credencial del usuario
     */
    public String getEmailUsuario() {
        return emailUsuario;
    }
    
    /**
     * Establece el email utilizado para autenticación.
     * @param email Email válido y único en el sistema
     */
    public void setEmailUsuario(String email) {
        this.emailUsuario = email;
    }
    
    /**
     * Obtiene la contraseña del usuario.
     * @return Contraseña del usuario
     */
    public String getContrasenia() {
        return contrasenia;
    }
    
    /**
     * Establece la contraseña del usuario.
     * RECOMENDACIÓN: La contraseña debería encriptarse antes del almacenamiento.
     * @param contrasenia Contraseña (preferiblemente encriptada)
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    /**
     * Obtiene el teléfono específico del usuario.
     * @return Número de teléfono del usuario
     */
    public int getTelefonoUsuario() {
        return telefonoUsuario;
    }
    
    /**
     * Establece el teléfono específico del usuario.
     * @param telefono Número de teléfono válido
     */
    public void setTelefonoUsuario(int telefono) {
        this.telefonoUsuario = telefono;
    }
    
    // MÉTODOS Auxiliares
    
    /**
     * Genera representación en String del usuario para debugging.
     * No incluye contraseña por seguridad.
     * @return String con información básica del usuario
     */
    @Override
    public String toString() {
        return String.format("Usuario{idUsuario=%d, emailUsuario='%s', nombre='%s', apellido='%s'}", 
                           idUsuario, emailUsuario, getNombre(), getApellido());
    }
    
    /**
     * Verifica si dos usuarios son iguales basándose en su ID de usuario.
     * @param obj Objeto a comparar
     * @return true si los usuarios tienen el mismo idUsuario
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Usuario usuario = (Usuario) obj;
        return idUsuario == usuario.idUsuario;
    }
    
    /**
     * Genera código hash basado en el ID del usuario.
     * @return Código hash del usuario
     */
    @Override
    public int hashCode() {
        return Integer.hashCode(idUsuario);
    }
    
    /**
     * Verifica si el usuario tiene credenciales válidas básicas.
     * @return true si tiene email y contraseña no vacíos
     */
    public boolean tieneCredencialesValidas() {
        return emailUsuario != null && !emailUsuario.trim().isEmpty() &&
               contrasenia != null && !contrasenia.trim().isEmpty();
    }
    
    /**
     * Obtiene el nombre completo del usuario.
     * @return Nombre y apellido concatenados, o solo el disponible
     */
    public String getNombreCompleto() {
        String nombre = getNombre();
        String apellido = getApellido();
        
        if (nombre != null && apellido != null) {
            return nombre + " " + apellido;
        } else if (nombre != null) {
            return nombre;
        } else if (apellido != null) {
            return apellido;
        } else {
            return "Usuario sin nombre";
        }
    }
}//class