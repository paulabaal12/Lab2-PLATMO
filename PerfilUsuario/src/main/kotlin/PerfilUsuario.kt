data class PerfilUsuario(
    val ID:Int,
    val Nombres:String,
    val Apellidos: String,
    val UrlPhoto: String,
    val Edad: Int,
    val Correo: String,
    val Biografia : String,
    val Estado: String,
    val Hobbies: MutableList<Hobby> //se puede modificar despues
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

