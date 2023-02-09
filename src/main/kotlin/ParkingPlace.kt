class ParkingPlace(val id: Int) {
    var car: Car? = null
    var isEmpty: Boolean = true
        get() = car == null

    override fun toString() = "P$id : ${car ?: "Свободно"}"
}