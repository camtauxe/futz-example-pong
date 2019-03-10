package futzpong

import com.camerontauxe.futz.*
import javafx.scene.input.KeyCode
import javafx.scene.paint.Color
import javafx.scene.canvas.GraphicsContext

object PongScene : Scene() {

    val BOUNDS = Rect(x = -4.5, y = - 2.5, width = 9.0, height = 5.0)

    val player1 = Paddle(upKey = KeyCode.W,      downKey = KeyCode.S)
    val player2 = Paddle(upKey = KeyCode.UP,     downKey = KeyCode.DOWN)

    val ball = Ball()

    val bg = PongBackground()

    override fun construct() {
        player1.spawn(atPos = Vector2(-4.0, -0.75))
        player2.spawn(atPos = Vector2(3.0, -0.75))

        ball.spawn(atPos = Vector2(0.0, 0.0) - Vector2(0.125, 0.125))

        bg.spawn(atDepth = -1)
    }
}

class PongBackground() : Entity() {

    override val static = true
    override val name   = "Background"

    override fun draw(ctx: GraphicsContext) {
        ctx.save()
        ctx.transformEntitySpaceToWorldSpace(this)

        ctx.fill = Color.BLACK
        ctx.fillRect(Viewport.worldRectOrigin)

        ctx.stroke = Color.WHITE
        ctx.lineWidth = Viewport.pixelsToUnits(2.0)
        ctx.strokeRect(PongScene.BOUNDS)
        ctx.strokeLine(0.0, PongScene.BOUNDS.y, 0.0, PongScene.BOUNDS.y2)

        val centerCircleRadius = 0.5
        ctx.strokeOval(
            -centerCircleRadius, -centerCircleRadius,
            centerCircleRadius*2, centerCircleRadius*2
        )

        ctx.restore()
    }
}