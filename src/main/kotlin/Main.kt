const val COMMAND_START = "/start"
const val COMMAND_END = "/end"
const val COMMAND_HELP = "/help"
const val HELP_MESSAGE = """/start - program displays a greeting
/end - finishes the program.
"""
const val NOT_A_COMMAND_MESSAGE = """There is no such command.
Input /help to get existing commands."""
const val HELLO_MESSAGE = "Hello! This is ConsoleParking program!"
const val END_MESSAGE = "Goodbye!"


fun main() {
    var input: String
    var end = false
    while (!end) {
        input = readln()
        println(
            when (input) {
                COMMAND_START -> HELLO_MESSAGE
                COMMAND_HELP -> HELP_MESSAGE
                COMMAND_END -> {
                    end = true; END_MESSAGE
                }
                else -> NOT_A_COMMAND_MESSAGE
            }
        )
    }
}

