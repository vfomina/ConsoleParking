import kotlin.text.*

object Command {
    const val START: String = "/start"
    const val HELP: String = "/help"
    const val END: String = "/end"
    const val PARK: String = "/park"
    const val RETURN: String = "/return"
    const val PARK_INFO_BY_CAR: String = "/park_info_by_car"
    const val PARK_INFO_BY_PLACE: String = "/park_info_by_place"
    const val PARK_STATS: String = "/park_stats"
    const val PARK_ALL_STATS: String = "/park_all_stats"

    fun run(command: String): Boolean {
        when (command) {
            START -> Message.START.display()
            HELP -> Message.HELP.display()
            PARK -> {
                println("Введите данные машины в формате: Модель Цвет Номер Имя_Владельца Фамилия_Владельца")
                val carData = readln().split("\\s+".toRegex())
                if (!rightParkInputLen(carData) || carData[2].isNotANumber() || carData[3].containsNumbers() || carData[4].containsNumbers()) {
                    println("Неверный формат данных. Введите команду снова.")
                } else {
                    Manager.parkCar(
                        Car(
                            carData[0], carData[1], carData[2], Owner(carData[3], carData[4])
                        )
                    )
                }
            }
            RETURN -> {
                println("Введите номер машины:")
                val id = readln()
                if (id.toIntOrNull() == null) {
                    println("Неверный формат данных. Введите команду снова.")
                } else {
                    println("Введите владельца в формате: Имя Фамилия")
                    val ownerData = readln().split("\\s+".toRegex(), limit = 2)
                    if (!rightReturnInputLen(ownerData) || ownerData[0].containsNumbers() || ownerData[1].containsNumbers()) {
                        println("Неверный формат данных. Введите команду снова.")
                    } else {
                        Manager.returnCar(id, Owner(ownerData[0], ownerData[1]))
                    }

                }
            }
            PARK_INFO_BY_CAR -> {
                println("Введите номер машины:")
                val carId = readln()
                if (carId.isNotANumber()) {
                    println("Некорректный формат номера. Номер состоит из цифр. Введите команду снова.")
                } else Manager.getParkInfoById(carId)
            }
            PARK_INFO_BY_PLACE -> {
                println("Введите номер парковочного места:")
                val id = readln()
                if (id.isNotANumber()) {
                    println("Некорректный формат номера. Номер состоит из цифр. Введите команду снова.")
                } else Manager.getParkInfoByPlace(id.toInt())
            }
            PARK_STATS -> { Manager.getParkStats() }
            PARK_ALL_STATS -> { Manager.getParkAllStats() }
            END -> {
                Message.END.display()
                return false
            }
            else -> Message.NOT_A_COMMAND.display()
        }
        return true

    }

    fun String.isNotANumber(): Boolean = toIntOrNull() == null

    fun String.containsNumbers(): Boolean = contains(Regex("[0-9]"))

    fun rightParkInputLen(list: List<String>) = list.size == 5

    fun rightReturnInputLen(list: List<String>) = list.size == 2


}