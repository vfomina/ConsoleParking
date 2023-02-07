object Parking {
    val parkingPlace = mutableMapOf<Int,Car?>()

    val carsParked: Int
        get() = parkingPlace.size
}