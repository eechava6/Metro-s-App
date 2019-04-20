package Data;

/**
 * Created by Esteban on 5/14/2016.
 * All rights reserved
 */
public class Station
{
    //Atributos
    public String stationName;
    public String unity;
    public int rootUbication;
    //Constructor
    public Station()
    {
        this.stationName = "No name";
        this.rootUbication = 0;
        this.unity = "No unity";
    }

    public Station(String stationName, String unity, int rootUbication)
    {
        this.stationName = stationName;
        this.unity = unity;
        this.rootUbication = rootUbication;
    }
}
