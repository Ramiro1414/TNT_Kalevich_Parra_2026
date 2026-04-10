data class UserAccount(val uuid: String, val email: String, var balance: Double)

fun main() {
    
    val usuario1: UserAccount = UserAccount(uuid = "123", email = "rami@gmail.com", balance = 1000.0)
    val usuario2: UserAccount = UserAccount(uuid = "456", email = "test@gmail.com", balance = 200.0)
    
    println(usuario1)
    println(usuario2)
    
    print("usuario1 == usuario2: " + usuario1.equals(usuario2))
    
}
