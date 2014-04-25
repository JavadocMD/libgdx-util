package com.javadocmd.libgdx

abstract class Vector2[T : Numeric](val _1: T, val _2: T)
abstract class Vector3[T : Numeric](val _1: T, val _2: T, val _3: T)

case class Position(val x: Float, val y: Float)
case class Offset(val dx: Float, val dy: Float)

case class Size(val w: Float, val h: Float)
case class SizeI(val w: Int, val h: Int)