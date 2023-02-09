object Parking {
    val parkingPlaces = buildList<ParkingPlace> {
        for (i in 1..20) add(ParkingPlace(i))
    }

    fun isFull(): Boolean {
        for (place in parkingPlaces) {
            if (place.isEmpty) {
                return false
            }
        }
        return true
    }

}