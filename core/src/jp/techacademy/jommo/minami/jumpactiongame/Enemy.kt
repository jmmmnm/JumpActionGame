package jp.techacademy.jommo.minami.jumpactiongame

import com.badlogic.gdx.graphics.Texture

class Enemy(texture: Texture, srcX: Int, srcY: Int, srcWidth: Int, srcHeight: Int)
    : GameObject(texture, srcX, srcY, srcWidth, srcHeight) {

    companion object {
        // 横幅、高さ
        val ENEMY_WIDTH = 1.0f
        val ENEMY_HEIGHT = 1.0f

        val ENEMY_VELOCITY = 2.0f
    }

    init {
        setSize(ENEMY_WIDTH, ENEMY_HEIGHT)
        velocity.x = ENEMY_VELOCITY
    }

    fun update(deltaTime: Float){
        x += velocity.x * deltaTime

        if (x < GameScreen.WORLD_WIDTH/2 - Ufo.UFO_WIDTH/2 - ENEMY_WIDTH) {
            velocity.x = -velocity.x
            x = GameScreen.WORLD_WIDTH/2 - Ufo.UFO_WIDTH/2 - ENEMY_WIDTH
        }
        if (x > GameScreen.WORLD_WIDTH/2 + Ufo.UFO_WIDTH/2) {
            velocity.x = -velocity.x
            x = GameScreen.WORLD_WIDTH/2 + Ufo.UFO_WIDTH/2
        }

    }
}