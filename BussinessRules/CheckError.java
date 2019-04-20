package BussinessRules;

import Data.Station;

import java.util.ArrayList;

/**
 * Created by Esteban on 6/6/2016.
 * All rights reserved
 */
public class CheckError
{
    /**
     *Verifica que el String corresponda a una estación del ArrayList
     * @param array ArrayList
     * @param station String
     * @return
     */
    public boolean searchError(ArrayList<Station> array, String station)
    {
        for (int i = 0; i < array.size(); i++)
        {
            Station obj = array.get(i);
            if (obj.stationName.equals(station))
            {
              return true;
            }
        }
        return false;
    }
}