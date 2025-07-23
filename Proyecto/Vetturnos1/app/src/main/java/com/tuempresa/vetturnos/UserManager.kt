package com.tuempresa.vetturnos

object UserManager {
    private val usuarios = mutableMapOf<String, User>()

    init {
        // Usuarios predefinidos para pruebas
        usuarios["admin"] = User("admin", "admin", "1234")
        usuarios["cliente"] = User("cliente", "cliente", "abcd")
    }

    fun authenticate(usuario: String, clave: String): User? {
        return usuarios[usuario]?.takeIf { it.clave == clave }
    }

    fun addUser(correo: String, clave: String, rol: String) {
        usuarios[correo] = User(correo, rol, clave)
    }
}
