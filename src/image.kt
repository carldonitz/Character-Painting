import java.awt.Color
import java.net.URL
import javax.imageio.ImageIO

/**
 * Created by Donitz on 2017/4/24.
 */


fun main(args: Array<String>) {
    val image = ImageIO.read(URL("http://a3.att.hudong.com/47/16/01200000027030134395164862221.jpg"))
    println("""
#include <stdio.h>
int main(const int argc, const char *argv[]) {""")
    (0..image.height - 1 step 2).forEach { y ->
        print("\tputs(\"")
        (0..image.width - 1 step 1).forEach { x ->
            val _1 = Color(image.getRGB(x, y))

            val _3 = Color(image.getRGB(x, y + 1))
            val r = (_1.red +  _3.red  ) / 2
            val g = (_1.green +_3.green) / 2
            val b = (_1.blue + _3.blue ) / 2
            System.out.print(when ((r + g + b) / 3) {
                in 0..20 -> ' '
                in 21..95 -> '-'
                in 96..130 -> '*'
                else -> '0'
            })
        }
        println("\");")
    }
    println("}")
}