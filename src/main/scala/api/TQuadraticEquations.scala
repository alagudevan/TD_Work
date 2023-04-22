package api

trait TQuadraticEquations {

  /**
   * signature for solve method. Any class extends the trait need to have their own implementation
   * @param a - coefficient a
   * @param b - coefficient a
   * @param c - coefficient a
   * @return : result can be a tuple of (Double, Double) or None
   */
  def solve(coefficient: Coefficient): Option[(Double, Double)]

}
