package Utils

object argsHelper {
  /**
   * function to parse the command line arguments
   * @param args
   * @return
   */
  def parse_command_line_arguments(args: Array[String]): (String, String) = {

    val args_list = args(0).split(",")
    if (args_list.length == 2)
        (args_list(0).toString(), args_list(1).toString())
      else {
        println("Invalid Arguments passed. The programs looks for only 2 arguments. Input file path and Output path")
        System.exit(1)
        ("Invalid Path", "Invalid Path")
      }

  }

}
