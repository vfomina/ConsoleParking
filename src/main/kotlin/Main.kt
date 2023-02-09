fun main() {
    var input: String
    while (true) {
        input = readln()
        if (!Command.run(input)) break
    }
}

