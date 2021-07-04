package pmf.unsa.dreamteameuro.formats

import java.text.SimpleDateFormat
import java.util.*

class MyFormat {
    companion object {
        fun formatPrice(price: Int): String {
            var formated = "$"
            var pom = price
            var i = 0
            if (pom < 1000000) {
                val str = price.toString()
                if (str.length == 6)
                    formated += str.substring(0, 2) + " k"
                else if (str.length == 5)
                    formated += str.substring(0, 1) + " k"
                else
                    formated += str[0] + " k"
            }
            while (pom >= 1000000) {
                val str = price.toString()
                pom /= 10
                formated += str[i]
                i += 1
                if (pom < 1000000)
                    formated += "." + str[i] + " m"
            }
            return formated
        }

        // https://stackoverflow.com/questions/47250263/kotlin-convert-timestamp-to-datetime
        fun formatDate(epoc: Long): String? {
            try {
                val sdf = SimpleDateFormat("dd/MM/yyyy")
                val netDate = Date(epoc*1000)
                return sdf.format(netDate)
            } catch (e: Exception) {
                return e.toString()
            }
        }

        fun formatPosition(pos: String): String {
            when (pos) {
                "G" -> return "Goalkeeper"
                "D" -> return "Defender"
                "M" -> return "Midfielder"
                "F" -> return "Forward"
                else -> { // Note the block
                    return "Position not defined"
                }
            }
        }

        fun formatHeight(h: Int): String {
            return h.toString() + " cm"
        }
    }
}