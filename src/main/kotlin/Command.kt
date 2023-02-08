object Command {
    const val START: String = "/start"
    const val HELP: String = "/help"
    const val END: String = "/end"

    fun getMessage(command: String): Message =
        when (command)  {
            START -> Message.START
            HELP -> Message.HELP
            END -> Message.END
            else -> Message.NOT_A_COMMAND
        }


}