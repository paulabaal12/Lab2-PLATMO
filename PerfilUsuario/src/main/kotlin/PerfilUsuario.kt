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
