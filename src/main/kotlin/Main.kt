fun main() {
    var input: String
    while(true) {
        input = readln()
        val mes = Command.getMessage(input)
        mes.display()
        if (mes == Message.END) break
    }
}

