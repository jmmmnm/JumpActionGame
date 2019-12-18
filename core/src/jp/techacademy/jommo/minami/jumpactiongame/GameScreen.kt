package jp.techacademy.jommo.minami.jumpactiongame

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.graphics.Camera
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.utils.viewport.FitViewport

class GameScreen (private val mGame: JumpActionGame) : ScreenAdapter() {
    companion object{
        val CAMERA_WIDTH = 10f
        val CAMERA_HEIGHT = 15f

    }

    private val mBg: Sprite
    private val mCamera: OrthographicCamera
    private val mViewPort: FitViewport


    init {
        //背景の準備
        val bgTexture = Texture("back.png")
        //TextureRegionで切り出すときの原点は左上
        mBg = Sprite(TextureRegion(bgTexture, 0,0,540, 810))
        mBg.setSize(CAMERA_WIDTH, CAMERA_HEIGHT)
        mBg.setPosition(0f,0f)

       // カメラ、ViewPortを生成、設定する
        mCamera = OrthographicCamera()
        mCamera.setToOrtho(false, CAMERA_WIDTH, CAMERA_HEIGHT)
        mViewPort = FitViewport(CAMERA_WIDTH, CAMERA_HEIGHT, mCamera)
    }

    override fun render(delta: Float) {
        Gdx.gl.glClearColor(0f,0f,0f,1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        // カメラの座標をアップデート（計算）し、スプライトの表示に反映させる
        mCamera.update()
        mGame.batch.projectionMatrix = mCamera.combined

        mGame.batch.begin()

        // 原点は左下
        mBg.setPosition(mCamera.position.x - CAMERA_WIDTH / 2, mCamera.position.y - CAMERA_HEIGHT / 2)
        mBg.draw(mGame.batch)

        mGame.batch.end()
    }

    override fun resize(width: Int, height: Int) {
        mViewPort.update(width, height)
    }
}
