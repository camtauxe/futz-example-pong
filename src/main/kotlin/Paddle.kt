package futzpong

import com.camerontauxe.futz.*
import com.camerontauxe.futz.prefab.*
import javafx.scene.input.KeyCode
import javafx.scene.paint.Color

private val PADDLE_RECT: Rect       = Rect(Vector2(0.0,0.0), width = 0.25, height = 1.5)
private val PADDLE_SPEED: Double    = 0.15;

class Paddle(val upKey: KeyCode, val downKey: KeyCode) : RectEntity(rect = PADDLE_RECT.copy()) {

    override var name: String = "Paddle"

    override fun update() {

        if (Input.isPressed(upKey) && ! Input.isPressed(downKey)) {
            position.y -= PADDLE_SPEED
        }
        else if (Input.isPressed(downKey) && ! Input.isPressed(upKey)) {
            position.y += PADDLE_SPEED
        }

        clampInside(PongScene.BOUNDS)
    }
}