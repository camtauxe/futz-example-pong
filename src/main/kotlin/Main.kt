package futzpong

import com.camerontauxe.futz.*
import javafx.scene.input.KeyCode
import javafx.scene.paint.Color

/**
 * Main function. Calls FUTZ.init
 */
fun main(args : Array<String>) {
    FUTZ.init(width = 1280.0, height = 720.0, initialScene = PongScene)
    // This does not return until the game is closed
}
