enum class Message(val text: String) {
    START("Hello! This is ConsoleParking program!"),
    HELP(
        """/start - program displays a greeting
/end - finishes the program."""
    ),
    END("Goodbye!"),
    NOT_A_COMMAND(
        """There is no such command.
Input /help to get existing commands."""
    );

    fun display() {
        println(this.text)
    }

}