package com.marius.app.myapplicationmeginimas;

import java.util.Random;

/** Represents a Naval Battle game **/
public class LaivuGeneratorius {
    /** Number of rows on the map */
    public static final int ROW = 10;
    /** Number of columns on the map */
    public static final int COLUMNS = 10;
    /** Indicates that the boat is in the horizontal direction */
    public static final int HORIZONTAL=0;
    /** Indicates that the boat is in the vertical direction */
    public static final int VERTICAL=1;
    /** Sense of positive direction */
    public static final int POSITIVE =1;
    /** Sense of negative direction */
    public static final int NEGAVTIVE =-1;
    /** Number of boats that are initially generated **/
    public static final int NUM_BIGS=1;
    public static final int NUM_MEDIUMS=3;
    public static final int NUM_SMALLS=5;
    /** Boat size */
    public static final int TAM_BIG=5;
    public static final int TAM_MEDIUM=3;
    public static final int TAM_SMALL=2;
    /**
     Map of positions of the boats. Each position if there is a boat. Otherwise,
     * It is assumed that there is water.
     */
    private boolean[][] map;
    /** Generator of random numbers */
    private Random random;

    /** Class constructor */
    public LaivuGeneratorius (){
        random= new Random();
        iniciarMapa();
        generarBarcos();
    }

    /** Start the map with all water */
    public void iniciarMapa(){
        map = new boolean[ROW][COLUMNS];
        for(int i = 0; i< map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j]=false;
            }
        }
    }

    /** Determines if there is a ship in a position */
    public boolean hayBarco(int x, int y){
        return map[x][y];
    }

    /** Generates several ships and places them on the map */
    public void generarBarcos(){
        for(int i = 0; i< NUM_BIGS; i++) {
            generarBarco(TAM_BIG);
        }
        for(int i=0; i<NUM_SMALLS; i++) {
            generarBarco(TAM_SMALL);
        }
        for(int i=0; i<NUM_MEDIUMS; i++) {
            generarBarco(TAM_MEDIUM);
        }
    }

    /** Method that generates a boat and places it on the map
     * @param tam Ship size. */
    public void generarBarco(int tam){
        //While we did not find space, we tried to locate a boat
        boolean encontradoEspacio=false;
        while(!encontradoEspacio) {
            // Choose random position
            int x = random.nextInt(ROW);
            int y = random.nextInt(COLUMNS);
            // Choose address
            int dir = elegirDireccion();
            // Calculate meaning
            int sentido = calcularSentidoBarco(x,y,dir, tam);
            // See if there is space
            encontradoEspacio = hayEspacioParaBarco(x, y, dir, sentido, tam);
            // Position the boat if there is space
            if (encontradoEspacio) {
                escribirBarco(x,y,dir,sentido, tam);
            }
        }
    }

    /**
     Indicates if there is space available for a boat **/
    public boolean hayEspacio(int x, int y){
        return !map[x][y];
    }
    /** Choose an address randomly. It will return constant HORIZONTAL or VERTICAL. */
    public int elegirDireccion(){
        int r = random.nextInt(2);
        if(r==0) {
            return HORIZONTAL;
        }else {
            return VERTICAL;
        }
    }
    /** Calculate the meaning of a ship of a certain size
     * @param x position X of the boat
     * @param and Y position of the boat
     * @param dir Boat address
     * @param tam Boat size
     */
    public int calcularSentidoBarco(int x, int y, int dir, int tam){
        //Distinguish between possible directions
        if (dir == HORIZONTAL){
            if(y<= COLUMNS /2){
                return POSITIVE;
            }else{
                return NEGAVTIVE;
            }
            // Yes vertical
        }else{
            if(x<= COLUMNS /2){
                return POSITIVE;
            }else{
                return NEGAVTIVE;
            }
        }
    }
    /** Place the boat in a position, direction and direction */
    public void escribirBarco(int x, int y, int dir, int sentido, int tam){
        int xi, yi;
        xi=x;
        yi=y;
        for (int i = 0; i< tam; i++){
            setMapaPos(xi,yi,true);
            if(dir==VERTICAL) {
                xi += sentido;
            }else {
                yi += sentido;
            }
        }
    }
    /** Place the boat in a position, direction and direction */
    public boolean hayEspacioParaBarco(int x, int y, int dir, int sentido, int tam){
        int xi, yi;
        xi=x;
        yi=y;
        boolean hayEspacio = true;
        for (int i = 0; i< tam; i++){
            if(getMapaPos(xi,yi))
                hayEspacio=false;
            if(dir==VERTICAL) {
                xi += sentido;
            }else {
                yi += sentido;
            }
        }
        return hayEspacio;
    }

    /** Change map position by checking the limits */
    public void setMapaPos(int x, int y, boolean value){
        if(x< ROW && y < COLUMNS) {
            map[x][y] = true;
        }else{

        }
    }
    /** Returns the position of the map by checking the limits */
    public boolean getMapaPos(int x, int y){
        if(x< ROW && y < COLUMNS) {
            return map[x][y];
        }else{

            return false;
        }
    }
}