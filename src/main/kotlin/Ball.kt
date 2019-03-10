package futzpong

import com.camerontauxe.futz.*
import com.camerontauxe.futz.prefab.*
import javafx.scene.paint.Color
import javafx.scene.canvas.GraphicsContext
import java.util.Random

val BALL_RECT: Rect = Rect(x = 0.0, y = 0.0, width = 0.25, height = 0.25)
val BALL_SPEED = 4.0

class Ball : RectEntity(rect = BALL_RECT.copy()) {

    override var name = "Ball"

    private var velocity: MutableVector2 = MutableVector2(0.0, 0.0)
    private val rand: Random = Random()

    fun launch() {
        val angle = rand.nextDouble() * (0.5*Math.PI) + (0.75*Math.PI)
        var x = Math.cos(angle) * BALL_SPEED
        var y = Math.sin(angle) * BALL_SPEED
        if (rand.nextBoolean())
            x = -x

        velocity = MutableVector2(x, y)
    }

    override fun update() {
        if (isCollidingWith(PongScene.player1)) {
            velocity.x = -velocity.x
            if (velocity.x > 0)
                position.x = PongScene.player1.position.x + PADDLE_RECT.width
            else
                position.x = PongScene.player1.position.x - BALL_RECT.width
        }
        else if (isCollidingWith(PongScene.player2)) {
            velocity.x = -velocity.x
            if (velocity.x > 0)
                position.x = PongScene.player2.position.x + PADDLE_RECT.width
            else
                position.x = PongScene.player2.position.x - BALL_RECT.width
        }

        val newPos = position + Vector2(velocity.x * FUTZ.frameTime, velocity.y * FUTZ.frameTime)

        if (newPos.x < PongScene.BOUNDS.x)
            velocity.x = -velocity.x
        else if (newPos.x > PongScene.BOUNDS.x2 - BALL_RECT.width)
            velocity.x = -velocity.x
        
        if (newPos.y < PongScene.BOUNDS.y)
            velocity.y = -velocity.y
        else if (newPos.y > PongScene.BOUNDS.y2 - BALL_RECT.height)
            velocity.y = -velocity.y

        position += Vector2(velocity.x * FUTZ.frameTime, velocity.y * FUTZ.frameTime)
    }

    override fun start() {
        launch()
    }

    override fun draw(ctx: GraphicsContext) {
        ctx.fill = fill
        ctx.fillOval(rect.x, rect.y, rect.width, rect.height)
    }
}

