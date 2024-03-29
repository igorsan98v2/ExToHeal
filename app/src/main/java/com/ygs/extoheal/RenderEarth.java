package com.ygs.extoheal;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;

import org.rajawali3d.lights.DirectionalLight;
import org.rajawali3d.materials.Material;
import org.rajawali3d.materials.methods.DiffuseMethod;
import org.rajawali3d.materials.textures.ATexture;
import org.rajawali3d.materials.textures.Texture;
import org.rajawali3d.math.vector.Vector3;
import org.rajawali3d.primitives.Sphere;
import org.rajawali3d.renderer.Renderer;

public class RenderEarth extends org.rajawali3d.renderer.Renderer {

    private DirectionalLight directionalLight;
    private Sphere earthSphere;
    Context context;
    public void onTouchEvent(MotionEvent event){
    }

    public void onOffsetsChanged(float x, float y, float z, float w, int i, int j){
    }
    public RenderEarth(Context context) {
        super(context);
        this.context = context;
        setFrameRate(60);
    }

    @Override
    protected void initScene() {
        directionalLight = new DirectionalLight(1f, .2f, -1.0f);
        directionalLight.setColor(1.0f, 1.0f, 1.0f);
        directionalLight.setPower(2);
        getCurrentScene().addLight(directionalLight);
        Material material = new Material();
        material.enableLighting(true);
        material.setDiffuseMethod(new DiffuseMethod.Lambert());
        material.setColor(0);

        Texture earthTexture = new Texture("Earth", R.drawable.ic_action_settings);
        try{
            material.addTexture(earthTexture);

        } catch (ATexture.TextureException error){
            Log.d("DEBUG", "TEXTURE ERROR");
        }
        earthSphere = new Sphere(1, 24, 24);
        earthSphere.setMaterial(material);
        getCurrentScene().addChild(earthSphere);
        getCurrentCamera().setZ(4.2f);
    }

    @Override
    public void onRender(final long elapsedTime, final double deltaTime) {
        super.onRender(elapsedTime, deltaTime);
        earthSphere.rotate(Vector3.Axis.Y, 1.0);
    }
}