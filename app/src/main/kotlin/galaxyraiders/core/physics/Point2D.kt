package galaxyraiders.core.physics

import kotlin.math.sqrt
import kotlin.math.abs


data class Point2D(val x: Double, val y: Double) {
  operator fun plus(p: Point2D): Point2D {
    val somaX = x + p.x
    val somaY = y + p.y
    return Point2D(somaX,somaY)
  }

  operator fun plus(v: Vector2D): Point2D {
    val somaX = x + v.dx
    val somaY = y + v.dy
    return Point2D(somaX,somaY)
  }

  override fun toString(): String {
    return "Point2D(x=$x, y=$y)"
  }

  fun toVector(): Vector2D {
    return Vector2D(x,y)
  }

  fun impactVector(p: Point2D): Vector2D {
    return Vector2D(abs(x-p.x),abs(y-p.y))
  }

  fun impactDirection(p: Point2D): Vector2D {
    val impactVector = this.impactVector(p)
    return Vector2D(impactVector.dx,impactVector.dy)
  }

  fun contactVector(p: Point2D): Vector2D {
    return Vector2D(abs(x-p.x),abs(y-p.y))
  }

  fun contactDirection(p: Point2D): Vector2D {
    val contactVector = this.contactVector(p)
    return Vector2D(contactVector.dx,contactVector.dy)
  }

  fun distance(p: Point2D): Double {
    val somaQuadrados = (x-p.x)*(x-p.x)+(y-p.y)*(y-p.y)
    val dist = sqrt(somaQuadrados)
    return dist
  }
}
