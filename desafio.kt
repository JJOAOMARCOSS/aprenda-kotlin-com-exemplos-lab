enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Usuario(val nome: String)

class Formacao(
    val nome: String,
    val nivel: Nivel,
    val conteudos: List<ConteudoEducacional>
) {
    private val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        if (inscritos.contains(usuario)) {
            println("${usuario.nome} já está matriculado.")
        } else {
            inscritos.add(usuario)
            println("${usuario.nome} foi matriculado na formação $nome.")
        }
    }

    fun listarInscritos(): List<Usuario> = inscritos.toList()

    fun listarConteudos(): List<String> =
        conteudos.map { "${it.nome} (${it.duracao}min)" }
}

fun main() {
    val kotlinBasico = ConteudoEducacional("Kotlin Básico", 90)
    val poo = ConteudoEducacional("POO com Kotlin", 120)
    val colecoes = ConteudoEducacional("Coleções em Kotlin", 80)

    val formacaoKotlin = Formacao(
        nome = "Formação Kotlin Developer",
        nivel = Nivel.INTERMEDIARIO,
        conteudos = listOf(kotlinBasico, poo, colecoes)
    )

    val aluno1 = Usuario("João")
    val aluno2 = Usuario("Maria")

    formacaoKotlin.matricular(aluno1)
    formacaoKotlin.matricular(aluno2)
    formacaoKotlin.matricular(aluno1)

    println("\nConteúdos da formação:")
    formacaoKotlin.listarConteudos().forEach(::println)

    println("\nAlunos matriculados:")
    formacaoKotlin.listarInscritos().forEach { println(it.nome) }
}
