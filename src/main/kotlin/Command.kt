import kotlin.text.*

object Command {
    const val START: String = "/start"
    const val HELP: String = "/help"
    const val END: String = "/end"
    const val PARK: String = "/park"
    const val RETURN: String = "/return"
    const val PARK_INFO_BY_CAR: String = "/park_info_by_car"
    const val PARK_INFO_BY_PLACE: String = "/park_info_by_place"

    fun run(command: String): Boolean {
        when (command) {
            START -> Message.START.display()
            HELP -> Message.HELP.display()
            PARK -> {
                println("Введите данные машины в формате: Модель Цвет Номер Имя_Владельца Фамилия_Владельца")
                val carInfo: String = readln()
                val list = carInfo.split(" ")
                if (list.size != 5 || list[2].toIntOrNull() == null || list[3].contains(Regex("[0-9]")) || list[3].contains(
                        Regex("[0-9]")
                    )
                ) {
                    println("Неверный нормат данных. Введите команду снова.")
                } else {
                    Manager.parkCar(Car(list[0], list[1], list[2], Owner(list[3], list[4])))
                }
            }
            RETURN -> {
                println("Введите номер машины:")
                val id = readln()
                if (id.toIntOrNull() == null) {
                    println("Неверный формат данных. Введите команду снова.")
                } else {
                    println("Введите владельца в формате: Имя Фамилия")
                    val list = readln().split(" ", limit = 2)
                    if (list.size != 2 || list[0].contains(Regex("[0-9]")) || list[1].contains(
                            Regex("[0-9]")
                        )
                    ) {
                        println("Неверный формат данных. Введите команду снова.")
                    } else {
                        Manager.returnCar(id, Owner(list[0], list[1]))
                    }

                }
            }
            PARK_INFO_BY_CAR -> {
                println("Введите номер машины:")
                val carId = readln()

                if (carId.toIntOrNull() == null) {
                    println("Некорректный формат номера. Номер состоит из цифр. Введите команду снова.")
                } else Manager.getParkInfoById(carId)
            }
            PARK_INFO_BY_PLACE -> {
                println("Введите номер парковочного места:")
                val id = readln().toIntOrNull()
                if (id == null) {
                    println("Некорректный формат номера. Номер состоит из цифр. Введите команду снова.")
                } else Manager.getParkInfoByPlace(id)
            }
            END -> {
                Message.END.display()
                return false
            }
            else -> Message.NOT_A_COMMAND.display()
        }
        return true
    }


}