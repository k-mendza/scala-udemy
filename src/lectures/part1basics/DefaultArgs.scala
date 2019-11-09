package lectures.part1basics

object DefaultArgs extends App {

  def trFact(n: Int, acc: Int = 1): Int = {
    if (n <= 1) 1
    else trFact(n-1, n*acc)
  }

  trFact(10)

  def saveImage(format: String = "jpg", height: Int = 1080, width: Int = 1920): Unit = {
    println("Saving image")
  }
  saveImage()
  saveImage("bmp")
  saveImage(width = 1024)
}
