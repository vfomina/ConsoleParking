data class Car(val model: String, val color: String, val id: String, val owner: Owner) {
    override fun toString(): String = "$model $color $id $owner"
}