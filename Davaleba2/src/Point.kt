import kotlin.math.pow
import kotlin.math.sqrt

class Point(x: Int, y: Int) {
    private var x: Int
    private var y: Int

    init {
        this.x = x
        this.y = y
    }

    override fun toString(): String {
        return "(x:$x, y:$y)"
    }

    fun equals(point: Point): Boolean {
        return point.x == x && point.y == y
    }

    fun wrap() : Void? {
        this.x = this.x * -1
        this.y = this.y * -1
        return null
    }
}
