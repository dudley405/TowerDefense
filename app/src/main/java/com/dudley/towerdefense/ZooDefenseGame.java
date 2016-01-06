package com.dudley.towerdefense;

import com.dudley.towerdefense.framework.Screen;
import com.dudley.towerdefense.framework.impl.AndroidGame;

/**
 * Created by Justin on 1/2/2016.
 */
public class ZooDefenseGame extends AndroidGame {


    @Override
    public Screen getInitScreen() {
        return new LoadingScreen(this);
    }

}
