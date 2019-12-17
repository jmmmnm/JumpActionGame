package jp.techacademy.jommo.minami.jumpactiongame

import com.badlogic.gdx.Game
import com.badlogic.gdx.graphics.g2d.SpriteBatch

class JumpActionGame : Game() {
    lateinit var batch: SpriteBatch

    override fun create() {
        batch = SpriteBatch()

        // GameScreenを表示する
        setScreen(GameScreen(this))
    }
}
