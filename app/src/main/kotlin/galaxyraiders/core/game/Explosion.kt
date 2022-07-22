package galaxyraiders.core.game

import galaxyraiders.core.physics.Point2D
import galaxyraiders.core.physics.Vector2D

const val TTL = 25

class Explosion(
  initialPosition: Point2D,
  initialVelocity: Vector2D,
  radius: Double,
  mass: Double
) :
  SpaceObject("Explosion", 'X', initialPosition, initialVelocity, radius, mass) {
  public var ticksToLive = TTL
  fun tick() {
    this.ticksToLive -= 1
  }

  fun isExpired(): Boolean {
    return this.ticksToLive <= 0
  }
}
