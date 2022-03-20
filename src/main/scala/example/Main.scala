package example

import scala.io.Source

object Main {
  def main(args: Array[String]): Unit = {
    val url = "https://ejje.weblio.jp/ranking/20220320"
    val prefix = "<a href=\"https://ejje.weblio.jp/content/"
    val words = Source.fromURL(url).mkString.split("\n")
      .collect {
        case line if line.startsWith(prefix) =>
          line.replace(prefix, "").split("\"").head
      }
      .filter(_.length == 5)
      .take(6)

    words.foreach(println)
  }
}