object Manager {

    fun returnCar(carId: String, owner: Owner) {

        val placeId = findCarById(carId)
        if (placeId == null) {
            Message.CAR_NOT_FOUND.display()
            return
        } else if (Parking.parkingPlaces[placeId-1].car?.owner != owner) {
            println(Parking.parkingPlaces[placeId-1].car?.owner)
            println("Неверные данные владельца")
            return
        }

        Parking.parkingPlaces[placeId-1].car = null
        println("Машина возвращена. Парковочное место P$placeId свободно.")
    }

    fun getParkInfoByPlace(id: Int) {
        if (id > 20 || id < 1) {
            //сообщение "Неверный номер парковки. 1 ...20"
            println("Неверный номер парковочного места. В парковке ${Parking.parkingPlaces.size} мест")
            return
        }
        val car = Parking.parkingPlaces[id-1].car
        if (car == null) {
            println("Данное парковочное место свободно")
        } else {
            println(car)
        }
    }

    /**
     * function looks for car in parkingPlaces by its id and returns ints place or null
     */
    fun findCarById(carId: String): Int? = Parking.parkingPlaces.find { it.car?.id == carId }?.id

    fun getParkInfoById(carId: String) {
        val id = findCarById(carId)
        if (id == null) {
            Message.CAR_NOT_FOUND.display()
        } else println("Машина находится на парковочном месте P$id")
    }

    fun parkCar(newCar: Car): Boolean {
        val duplicateCarParkId = findCarById(newCar.id)

        if (duplicateCarParkId != null) {
            println("Некорректный нормер машины.\nМашина с таким номером уже находится на парковке. Проверьте правильность введенных данных")
            return false
        } else {
            if (Parking.isFull()) {
                println("На данный момент парковка заполнена")
                return false
            }
            Parking.parkingPlaces.first { it.car == null }.car = newCar
            println("Успешно!")
            return true
        }


    }

    fun getParkStats() {}

    fun getParkAllStats() {}

}