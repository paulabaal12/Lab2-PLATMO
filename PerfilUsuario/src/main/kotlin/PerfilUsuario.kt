import kotlin.io.*
data class PerfilUsuario(
    val ID:Int,
    val Nombres:String,
    val Apellidos: String,
    val UrlPhoto: String?, //acepta null
    val Edad: Int,
    val Correo: String,
    val Biografia : String?,
    val Estado: String,
    val Hobbies: MutableList<Hobby> = mutableListOf()//se puede modificar despues
) {
    fun agregarhobby(hobby: Hobby){
        Hobbies.add(hobby)
    }
}
data class Hobby(
    val Titulo: String,
    val Descripcion: String,
    val UrlPhoto: String)

fun main() {

    val listaUsuarios: MutableList<PerfilUsuario> = mutableListOf()
    // Usuarios precargados para pruebas
    listaUsuarios.add(
        PerfilUsuario(
            161998, "Charles", "Leclerc", "image/jpeg;base64", 25, "lec1612@gmail.com",
            "Piloto de F1", "Activo"
        )
    )
    listaUsuarios.add(
        PerfilUsuario(
            131989, "Taylor", "Swift", "image/jpeg;base22", 33, "taytay13@gmail.com",
            "Industria Musical, Cantante", "Activo"
        )
    )

    do {
        println("Bienvenido, seleccione una opción")
        println("1.- Crear Perfil")
        println("2.- Buscar perfil de usuario(s)")
        println("3.- Eliminar Perfil")
        println("4.- Agregar Hobby")
        println("5.- Salir")
        var opción = readLine()!!.toInt()
        when (opción) {
            1 -> {
                println("Crea un perfil")
                println("ID: ")
                val ID = readLine()!!.toInt()
                println("Nombres: ")
                val Nombres = readLine().toString()
                println("Apellidos: ")
                val Apellidos = readLine().toString()
                println("URL de foto, puede omitir: ")
                val UrlPhoto = readLine().toString()
                println("Edad: ")
                val Edad = readLine()!!.toInt()
                println("Correo: ")
                val Correo = readLine().toString()
                println("Biografía, puede omitir: ")
                val Biografia = readLine().toString()
                println("Estado (Activo, Pendiente, Inactivo): ")
                val Estado = readLine().toString()
                val usuario = PerfilUsuario(ID, Nombres, Apellidos, UrlPhoto, Edad, Correo, Biografia, Estado)
                listaUsuarios.add(usuario)
                print("\n${Nombres} ${Apellidos}  tu perfil se ha creado exitosamente\n")

            }

            2 -> {
                println("Buscar Usuario, Ingrese Nombres/ Apellidos o ID")
                val confirmacion = readLine().orEmpty()
                var found = false
                for (usuario in listaUsuarios) {
                    if (usuario.Nombres.equals(confirmacion, ignoreCase = true) ||
                        usuario.Apellidos.equals(confirmacion, ignoreCase = true) ||
                        usuario.ID.toString() == confirmacion
                    ) {
                        found = true
                        println("Perfil encontrado:")
                        println("ID: ${usuario.ID}")
                        println("Nombres: ${usuario.Nombres}")
                        println("Apellidos: ${usuario.Apellidos}")
                        println("URL de foto: ${usuario.UrlPhoto}")
                        println("Edad: ${usuario.Edad}")
                        println("Correo: ${usuario.Correo}")
                        println("Biografía: ${usuario.Biografia}")
                        println("Estado: ${usuario.Estado}")
                        println("Hobbies: ")
                        for (hobby in usuario.Hobbies) {
                            println("- Título: ${hobby.Titulo}")
                            println("  Descripción: ${hobby.Descripcion}")
                            println("  URL: ${hobby.UrlPhoto}")
                        }
                        break
                    }
                }
            }

            3 -> {
                println("Eliminar Perfil/Usuario, debe ingresar el ID")
                val idingresado = readln().toIntOrNull()
                val borrar = listaUsuarios.find { it.ID == idingresado }
                if (idingresado != null) {
                    listaUsuarios.remove(borrar)
                    println("Perfil eliminado/borrado")
                } else {
                    println("No existe ningun usuario con ese ID")
                }
            }

            4 -> {
                println("Agregar Hobby,Ingrese Apellido/Nombre o ID ")
                val respuestausuario = readLine().toString()
                val agregarhobby = listaUsuarios
                if (agregarhobby.equals(respuestausuario)) {
                    println("Titulo (hobby: ")
                    val Titulo = readLine().toString()
                    println("Descripción (hobby: ")
                    val Descripcion = readLine().toString()
                    println("URL (hobby: ")
                    val UrlPhoto = readLine().toString()

                    val hobby = Hobby(Titulo, Descripcion, UrlPhoto)
                    println("Se agrego tu hobby")
                } else {
                    println("No se pudo agregar tu hobby")
                }
            }

            5 -> {
                println("Eso fue todo!!")
            }

            else -> {
                println("Está opción no es valida :(")
            }
        }
    } while (opción != 5)
}
