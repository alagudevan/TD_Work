import utils.{csvHelper, argsHelper}
import api.{Coefficient, ServiceQuadraticEquations}
import scala.collection.mutable.ListBuffer

/**
 * Entry point of the application. Can be execute using sbt with following arguments.
 * /Users/vijay/IdeaProjects/QuadraticEquations/src/main/resources/input.csv,/Users/vijay/IdeaProjects/QuadraticEquations/src/main/resources
 */
object Main {

  private val output_header = "a,b,c,x1,x2"
  def main(args: Array[String]): Unit = {

    val (input_path, output_path) = argsHelper.parse_command_line_arguments(args)
    val input_list = csvHelper.read_csv(input_path)
    val coefficients = parse_input(input_list, output_path)

    val output = calculate_qe(coefficients)
    csvHelper.write_csv(output, s"${output_path}/output.csv")
  }

  /**
   * parse input lines and convert into a list of coefficients
   * @param lst
   * @param output_path
   * @return
   */
  private def parse_input(lst: List[String], output_path: String): List[Coefficient] = {

    var coefficients: List[Coefficient] = List.empty
    val invalid_rows_list = new ListBuffer[String]
    invalid_rows_list += output_header

    lst.drop(1).map(x => {
      val tup = x.split(",")
      tup match {
        case Array(a, b, c) =>
          if (a.toDoubleOption != None && b.toDoubleOption != None && c.toDoubleOption != None)
            coefficients = coefficients :+ Coefficient(a.toDouble, b.toDouble, c.toDouble)
          else
            invalid_rows_list += s"${a}, ${b}, ${c}, Invalid coefficients to calculate QE !!"
            println("Invalid coefficients to calculate QE !!")
        case _ =>
          invalid_rows_list += s"Not enough params to calculate QE !!"
          println("Not enough params to calculate QE !!")
      }
    })

    csvHelper.write_csv(invalid_rows_list.toList, s"${output_path}/invalid_records.csv")
    coefficients
  }

  /**
   * function to calculate qe for each coefficient
   * @param coefficients
   * @return
   */
  private def calculate_qe(coefficients: List[Coefficient]): List[String] = {

    val output_list = new ListBuffer[String]
    output_list += output_header
    coefficients.foreach(coe => {
      val output = ServiceQuadraticEquations.solve(coe) match {
        case None => "Invalid Inputs, Invalid Inputs"
        case Some(x) => s"${x._1}, ${x._2}"
      }
      output_list += s"${coe.a}, ${coe.b}, ${coe.c}, ${output}"
    })

    output_list.toList
  }
}