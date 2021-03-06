package com.iserm.game.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.SkinLoader;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Assets {

    private static AssetManager assetManager = new AssetManager();

    public static final AssetDescriptor<Skin> SKIN_VIS = new AssetDescriptor<>("ui/uiskin.json", Skin.class, new SkinLoader.SkinParameter("ui/uiskin.atlas"));

    public static void load() {
        assetManager.load(SKIN_VIS);
        assetManager.finishLoading();

    }

    public static AssetManager getAssetManager() {
        return assetManager;
    }
}
