package jp.techacademy.jommo.minami.jumpactiongame

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.graphics.g2d.TextureRegion

class GameScreen (private val mGame: JumpActionGame) : ScreenAdapter() {
    private val mBg: Sprite

    init {
        //背景の準備
        val bgTexture = Texture("back.png")
        //TextureRegionで切り出すときの原点は左上
        mBg = Sprite(TextureRegion(bgTexture, 0,0,540, 810))
        mBg.setPosition(0f,0f)
    }

    override fun render(delta: Float) {
        Gdx.gl.glClearColor(0f,0f,0f,1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        mGame.batch.begin()
        mBg.draw(mGame.batch)
        mGame.batch.end()
    }
}
