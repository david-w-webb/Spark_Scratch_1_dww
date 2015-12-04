/**
  * Created by WebbD on 12/4/2015.
  */
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._

object SimpleApp {
  def main(args: Array[String]) {
    val logFile = "src/data/sample.txt"  //This is the input file
    val sc = new SparkContext("local", "Simple App", "/path/to/spark-1.3.1",
      List("C:\\Users\\webbd\\Documents\\Assignments\\MasterControl\\5_whys.txt"))
    val logData = sc.textFile(logFile, 2).cache()
    val checkString = "I "
    val numStrings = logData.filter(line => line.contains(checkString)).count()
    println("Lines with %s: %s".format(checkString, numStrings))
  }
}

