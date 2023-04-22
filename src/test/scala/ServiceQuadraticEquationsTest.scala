import api.{Coefficient, ServiceQuadraticEquations}

class ServiceQuadraticEquationsTest extends org.scalatest.funsuite.AnyFunSuiteLike {

  //val obj = new ServiceQuadraticEquations()
  test("Test QE Scenarios 1 real root") {
    assert(ServiceQuadraticEquations.solve(Coefficient(1, 0, 0)) == Some(0.0,-0.0))
    assert(ServiceQuadraticEquations.solve(Coefficient(2, 4, 2)) == Some(-1, -1))
    assert(ServiceQuadraticEquations.solve(Coefficient(-4000, 3842, -11)) == Some(0.0028716778067944234,0.9576283221932056))
    assert(ServiceQuadraticEquations.solve(Coefficient(8, 8, 2)) == Some(-0.5, -0.5))
    assert(ServiceQuadraticEquations.solve(Coefficient(8000, 8000, 2000)) == Some(-0.5,-0.5))
  }

  test("Test QE Scenarios - 2 Real roots") {
    assert(ServiceQuadraticEquations.solve(Coefficient(1, -5, 6)) == Some(3.0, 2.0))
    assert(ServiceQuadraticEquations.solve(Coefficient(29, 44, 1)) == Some(-0.02307831007925716,-1.4941630692310877))
    assert(ServiceQuadraticEquations.solve(Coefficient(582, 693, 17)) == Some(-0.025058370210756752,-1.1656632792737793))
    assert(ServiceQuadraticEquations.solve(Coefficient(-92, 77, 18)) == Some(-0.19043571395237907,1.0273922356915095))
    assert(ServiceQuadraticEquations.solve(Coefficient(1, -5, 6)) == Some(3.0, 2.0))
  }

  test("Test QE Scenarios - No Real roots") {
    assert(ServiceQuadraticEquations.solve(Coefficient(5, 4, 7)) == None)
    assert(ServiceQuadraticEquations.solve(Coefficient(10, 4, 7)) == None)
    assert(ServiceQuadraticEquations.solve(Coefficient(94, 0, 1)) == None)
    assert(ServiceQuadraticEquations.solve(Coefficient(77843, 56, 12)) == None)
    assert(ServiceQuadraticEquations.solve(Coefficient(2324, 34, 454)) == None)

  }

}
