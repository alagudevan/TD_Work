package Utils

import java.io.{BufferedWriter, File, FileWriter}
import scala.io._

/**
 * csvHelper class to read and write csv files.
 */
object csvHelper {

  def read_csv(path: String): List[String] = {

    Source.fromFile(path).getLines.toList

  }

  def write_csv(output: List[String], path: String): Unit = {

    val file = new File(s"${path}")
    val bw = new BufferedWriter(new FileWriter(file))
    bw.write(output.mkString("\n"))
    bw.close()
  }


}
