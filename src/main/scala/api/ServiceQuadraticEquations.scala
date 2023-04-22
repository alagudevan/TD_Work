package api

import scala.math._
import com.typesafe.scalalogging._
object ServiceQuadraticEquations extends TQuadraticEquations {

  val logger = Logger("QuadraticEquations")

  /**
   * method to solve the quadratic equation
   * For Formula for Quadratic equation is ax2 + bx + c = 0 OR x = (-b +(-) Sqrt(b*b-4ac)) / 2a
   * @param a - coefficient a
   * @param b - coefficient a
   * @param c - coefficient a
   * @return : result can be a tuple of (Double, Double) or None
   */
  override def solve(coe: Coefficient): Option[(Double,Double)] = {

    if (coe.a == 0) {
      println("Cannot calulate QE if coefficient a is 0.0")
      None
    }
    else {
      val d = calculateDiscriminant(coe)
      println(s"Calculate QE for coefficients a: ${coe.a}, b: ${coe.b}, c: ${coe.c}")
      d match {
        case Some(d) => {
          val x1 = (-coe.b + sqrt(d)) / (2 * coe.a)
          val x2 = (-coe.b - sqrt(d)) / (2 * coe.a)
          Some(x1, x2)
        }
        case _ => {
          println(s"Unable to calculate Quadratic equation, due to discriminant being real number ")
          None
        }
      }
    }

  }

  /**
   * method to calculate the discriminant. Takes all the coefficients and find the d. If it is not real
   * number, it would return a None which will be handled by the calling method
   * @param a
   * @param b
   * @param c
   * @return Double or None.
   */
  def calculateDiscriminant(coe: Coefficient): Option[Double] = {

    val d = coe.b * coe.b - 4 * coe.a * coe.c

    println(s"Calculated Discriminant: ${d}")
    if (d < 0) None
    else Some(d)
  }
}
