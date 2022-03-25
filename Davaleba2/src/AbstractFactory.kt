class AbstractFactory {
    fun create(type: String): Any? {
        return when (type) {
            "Boeing737" -> AircraftFactory().create(type)
            "Boeing777" -> AircraftFactory().create(type)
            "Audi" -> CarFactory().create(type)
            "Maserati" -> CarFactory().create(type)
            else -> null
        }
    }
}