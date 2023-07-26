data class PerfilUsuario(
    val ID:Int,
    val Nombres:String,
    val Apellidos: String,
    val UrlPhoto: String,
    val Edad: Int,
    val Correo: String,
    val Biografia : String,
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
    val UrlPhoto: String
)

fun main(){
    val listaUsuarios: MutableList<PerfilUsuario> = mutableListOf()
    var opción = readLine()!!.toInt()
    do{
        println("Bienvenido, seleccione una opción")
        println("1.- Crear Perfil")
        println("2.- Buscar perfil de usuario(s)")
        println("3.- Eliminar Perfil")
        println("4.- Agregar Hobby")
        println("5.- Salir")
        when(opción){
            1->{

            }
            2->{

            }
            3->{

            }
            4->{

            }
            5->{
                println("Eso fue todo!!")
            }
            else->{
                println("Está opción no es valida :(")
            }
        }
    } while(opción !=5)

    //USUARIOS PREDETERMINADOS
    listaUsuarios.add(
        PerfilUsuario(
            161998,"Charles", "Leclerc", "image/jpeg;base64", 25, "lec1612@gmail.com",
            "Piloto de F1" , "Activo" )
    )
    listaUsuarios.add(
        PerfilUsuario(
            131989,"Taylor", "Swift", "image/jpeg;base22", 33, "taytay13@gmail.com",
            "Industria Musical, Cantante" , "Activo" )
    )
}
