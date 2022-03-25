fun main() {
    //Davaleba 1
    val point1 = Point(14, -8)
    val point2 = Point(5, 6)

    println(point1.toString())
    println("Point 1 is ${if(point1.equals(point2)) "" else "NOT"} equal  to Point 2")
    point1.wrap()
    println("wrapped point is: $point1")

    //Davaleba 2
    println(AbstractFactory().create("Boeing737"))
    println(AbstractFactory().create("Boeing777"))
    println(AbstractFactory().create("Audi"))
    println(AbstractFactory().create("Maserati"))

}

