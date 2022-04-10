package com.iserm.game.utils;

import com.badlogic.gdx.maps.MapLayer;
import com.iserm.game.Scenes.Mine;
import com.iserm.game.Scenes.Zone;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

import java.util.ArrayList;

public abstract class Constants
{
    public final static int VIEWPORT_WIDTH = 960 ;
    public final static int VIEWPORT_HEIGHT = 512;

    public final static int WINDOW_WIDTH = 1200;
    public final static int WINDOW_HEIGHT = 720;

    public final static String GAME_TITLE = "ISERM Simulator";


    public static TmxMapLoader maploader = new TmxMapLoader();
    public static TiledMap map = maploader.load("ui/maps/Maps_1.tmx");


    public static MapLayer fenetreDecouverte = map.getLayers().get("Decouverte");
    public static MapLayer fenetreexploration = map.getLayers().get("explorer mines");
    public static MapLayer fenetrefail = map.getLayers().get("Fail");
    public static MapLayer fenetrereussiteexploration = map.getLayers().get("Mines trouvee");
    public static MapLayer fenetreexploitation = map.getLayers().get("Decision exploitation");



    public static ArrayList<Zone> zone = new ArrayList<Zone>();
    public static ArrayList<Mine> mine = new ArrayList<Mine>();


    //Variables entrees
    public MapLayer entree0 = map.getLayers().get("Entree0");
    public MapLayer entree1 = map.getLayers().get("Entree1");
    public MapLayer entree6 = map.getLayers().get("Entree6");
    public MapLayer entree8 = map.getLayers().get("Entree8");
    public MapLayer entree16 = map.getLayers().get("Entree16");
    public MapLayer entree19 = map.getLayers().get("Entree019");

    public MapLayer boutonEntree0 = map.getLayers().get("Entree_0");
    public MapLayer boutonEntree1= map.getLayers().get("Entree_1");
    public MapLayer boutonEntree6 = map.getLayers().get("Entree_6");
    public MapLayer boutonEntree8 = map.getLayers().get("Entree_8");
    public MapLayer boutonEntree16 = map.getLayers().get("Entree_16");
    public MapLayer boutonEntree19 = map.getLayers().get("Entree_19");

    //Variables Rubis
    public final MapLayer Rubis0 = map.getLayers().get("Ruby_0");
    public final MapLayer Rubis1 = map.getLayers().get("Ruby_1");
    public final MapLayer Rubis6 = map.getLayers().get("Ruby_6");



   // Variable des mines
    public MapLayer mine0 = map.getLayers().get("Mine_0");
    public MapLayer mine1 = map.getLayers().get("Mine_1");
    public MapLayer mine2 = map.getLayers().get("Mine_2");
    public MapLayer mine3 = map.getLayers().get("Mine_3");
    public MapLayer mine4 = map.getLayers().get("Mine_4");
    public MapLayer mine5 = map.getLayers().get("Mine_5");
    public MapLayer mine6 = map.getLayers().get("Mine_6");
    public MapLayer mine7 = map.getLayers().get("Mine_7");
    public MapLayer mine8 = map.getLayers().get("Mine_8");
    public MapLayer mine9 = map.getLayers().get("Mine_9");
    public MapLayer mine10 = map.getLayers().get("Mine_10");
    public MapLayer mine11 = map.getLayers().get("Mine_11");
    public MapLayer mine12 = map.getLayers().get("Mine_12");
    public MapLayer mine13 = map.getLayers().get("Mine_13");
    public MapLayer mine14 = map.getLayers().get("Mine_14");
    public MapLayer mine15 = map.getLayers().get("Mine_15");
    public MapLayer mine16 = map.getLayers().get("Mine_16");
    public MapLayer mine17 = map.getLayers().get("Mine_17");
    public MapLayer mine18 = map.getLayers().get("Mine_18");
    public MapLayer mine19 = map.getLayers().get("Mine_19");
    public MapLayer mine20 = map.getLayers().get("Mine_20");
    public MapLayer mine21 = map.getLayers().get("Mine_21");
    public MapLayer mine22 = map.getLayers().get("Mine_22");


    //Variables de zone
    public MapLayer zone2= map.getLayers().get("Zone2");
    public MapLayer zone3 = map.getLayers().get("Zone3");
    public MapLayer zone4 = map.getLayers().get("Zone4");
    public MapLayer zone5 = map.getLayers().get("Zone5");
    public MapLayer zone6 = map.getLayers().get("Zone6");

    //Variables de nuage
    public MapLayer nuage1 = map.getLayers().get("Nuage_Zone1");
    public MapLayer nuage2 = map.getLayers().get("Nuage_Zone2");
    public MapLayer nuage3 = map.getLayers().get("Nuage_Zone3");
    public MapLayer nuage4 = map.getLayers().get("Nuage_Zone4");
    public MapLayer nuage5 = map.getLayers().get("Nuage_Zone5");
    public MapLayer nuage6 = map.getLayers().get("Nuage_Zone6");

    //Variables bouton
    public MapLayer boutondecouverteoui = map.getLayers().get("Bouton oui_decouverte");
    public MapLayer boutondecouvertenon= map.getLayers().get("Bouton non_decouverte");
    public MapLayer boutonexplorationoui = map.getLayers().get("Bouton oui_exploration");
    public MapLayer boutonexplorationnon = map.getLayers().get("Bouton non_exploration");
    public MapLayer boutonexploitationoui = map.getLayers().get("Bouton oui_exploitation");
    public MapLayer boutonexploitationnon = map.getLayers().get("Bouton non_exploitation");
    public MapLayer boutonfailok = map.getLayers().get("Bouton ok_Fail");
    public MapLayer boutonreussiteexploration = map.getLayers().get("Bouton reussite_exploration");

//    //Mines valables
//    public ArrayList minesexploration = new ArrayList<Integer>();
//
//
////Mines ok
//    minesexploration.add(0);
//    minesexploration.add(1);
//    minesexploration.add(6);
//    minesexploration.add(8);
//    minesexploration.add(16);
//    minesexploration.add(19);



    //Variables pour mines


    public boolean mine_0dejaexploree;
    public boolean mine_1dejaexploree;
    public boolean mine_2dejaexploree;
    public boolean mine_3dejaexploree;
    public boolean mine_4dejaexploree;
    public boolean mine_5dejaexploree;
    public boolean mine_6dejaexploree;
    public boolean mine_7dejaexploree;
    public boolean mine_8dejaexploree;
    public boolean mine_9dejaexploree;
    public boolean mine_10dejaexploree;
    public boolean mine_11dejaexploree;
    public boolean mine_12dejaexploree;
    public boolean mine_13dejaexploree;
    public boolean mine_14dejaexploree;
    public boolean mine_15dejaexploree;
    public boolean mine_16dejaexploree;
    public boolean mine_17dejaexploree;
    public boolean mine_18dejaexploree;
    public boolean mine_19dejaexploree;
    public boolean mine_20dejaexploree;
    public boolean mine_21dejaexploree;
    public boolean mine_22dejaexploree;

    public boolean mine_0enexploitation;
    public boolean mine_1enexploitation;
    public boolean mine_6enexploitation;
    public boolean mine_8enexploitation;
    public boolean mine_16enexploitation;
    public boolean mine_19enexploitation;


}
