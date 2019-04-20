package GUI;


import BussinessRules.GenerateStations;
import Data.Station;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


/**
 * Created by Esteban on 5/31/2016.
 * All rights reserved
 */
public class GUIstepbystep extends JFrame
{
    JComponent stationLabel;
    ArrayList<Station> stationsData;

    /**
     * Crea la ventana.
     * @throws HeadlessException
     */
    public GUIstepbystep() throws HeadlessException
    {

        GenerateStations obj1 = new GenerateStations();
        obj1.startAllRoots();
        stationsData = obj1.stationsData;

        this.setTitle("StepByStep");
        this.setResizable(false);
        this.setBounds(70,75,1231,450);


        JButton returnButton = returnButton("Return");

        stationLabel = textMap();
        stationLabel.add(returnButton);

        this.getContentPane().add(stationLabel);
        this.setVisible(true);
    }

    /**
     * Crea un botón encargado
     * de cerrar una ventana
     * @param text
     * @return
     */
    private JButton returnButton(String text)
    {
        JButton returnButton = new JButton(text);
        returnButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                GUIstepbystep.super.dispose(); //http://stackoverflow.com/questions/2352727/closing-jframe-with-button-click
            }
        });

        return returnButton;
    }

    /**
     * Crea una ventana que cuenta con BackGround.
     * @return JComponent
     */
    private JComponent textMap()
    {
        ImageIcon s = new ImageIcon((getClass().getResource("/GUI/images/1.jpg")));
        ImagePanel stationLabel = new ImagePanel(s.getImage());


        stationLabel.setLayout(new GridLayout(14,2,10,10));
        stationLabel.setBackground(Color.WHITE);
        stationLabel.setVisible(true);

        return stationLabel;
    }


    /**
     * Busca en dónde se encuentra el String dentro del ArrayList
     * tipo Station
     */
    public int checkStation(ArrayList<Station> array, String station) {
        for (int i = 0; i < array.size(); i++) {
            Station obj = array.get(i);
            if (obj.stationName.equals(station)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Recibe dos Strings que se encuentrean dentro del ArrayList,
     * Se encarga de definir cuál algorítmo se usará (Izquierda a derecha)
     * o (Derecha a izquierda)
     * @param start
     * @param end
     */
    public  void checkPatron(String start, String end)
    {
        if (leftOrRight(start, end, stationsData))
        {
            transparentPanel("You're coming from "+start+" to "+end,80);
            rightToLeft(start, end, stationsData);
        }
        else
        {
            transparentPanel("You're coming from "+start+" to "+end,80);
            leftToRight(start, end, stationsData);
        }
    }

    /**
     *Algoritmo encargado de buscar en el ArrayList
     *si el String inicio es menor al String Final.
     */
    private boolean leftOrRight(String start, String end, ArrayList<Station> array)
    {
        int startPos = 0;
        int endPos = 0;
        for (int i = 0; i < array.size(); i++)
        {
            Station obj = array.get(i);

            if (start.equals(obj.stationName))
            {
                startPos = i;
            }
            if (end.equals(obj.stationName))
            {
                endPos = i;
            }
        }

        if (startPos < endPos)
        {
            return true;
        } else
        {
            return false;
        }
    }

    /**
     *Algoritmo encargado de buscar en el ArrayList
     * de Derecha a izquierda
     */
    private void rightToLeft(String start, String end, ArrayList<Station> array)
    {
        int startStation = checkStation(stationsData,start);
        Station startObj = array.get(startStation);

        int endStation = checkStation(stationsData,end);
        Station endObj= array.get(endStation);

        if (startObj.rootUbication == 2)
        {
            if (endObj.rootUbication == 2)
            {
                travelRoot(startStation,endStation,array);
                transparentPanel("You're in your end Station");
            }

            if (endObj.rootUbication == 5)
            {
                downRoot(startStation,2,array);
                travelRoot(checkStation(stationsData,"Parque Berrio"),endStation,stationsData,4);
                transparentPanel("You're in your end Station");
            }

            if (endObj.rootUbication != 2 && endObj.rootUbication != 5)
            {
                downRoot(startStation,2,array);
                travelRoot(checkStation(stationsData,"Parque Berrio"),endStation,stationsData);
                transparentPanel("You're in your end Station");
            }
        }

        if (startObj.rootUbication == 4)
        {
            if (endObj.rootUbication == 4)
            {
                travelRoot(startStation,endStation,array);
                transparentPanel("You're in your end Station");
            }
            if (endObj.rootUbication != 4)
            {
                downRoot(startStation,4,array);
                travelRoot(checkStation(stationsData,"Madera"),endStation,stationsData);
                transparentPanel("You're in your end Station");
            }
        }

        if (startObj.rootUbication != 4 && startObj.rootUbication != 2)
        {
            if (endObj.rootUbication == 1 || endObj.rootUbication == 2)
            {
                travelRoot(startStation,endStation,stationsData);
                transparentPanel("You're in your end Station");
            }
            if (endObj.rootUbication == 3 || endObj.rootUbication == 4)
            {
                travelRoot(startStation,endStation,stationsData,2);
                transparentPanel("You're in your end Station");
            }
            if (endObj.rootUbication == 5)
            {
                travelRoot(startStation,endStation,stationsData,2,4);
                transparentPanel("You're in your end Station");
            }
        }

    }


    /**
     * Viaja a través de las "Station" dentro de un array,
     * teniendo todas en cuenta, inicia en la posición dada por StartStation
     * y finaliza en la posición dada como EndStation
     * @param startStation
     * @param endStation
     * @param array
     */
    private void travelRoot(int startStation,int endStation,ArrayList<Station> array)
    {
        for (int i = startStation; i <= endStation; i++)
        {
            transparentPanel(array.get(i));
        }
    }

    /**
     * Viaja a través de las "Station" dentro de un array,
     * saltandose 1 root, inicia en la posición dada por StartStation
     * y finaliza en la posición dada como EndStation
     * @param startStation
     * @param endStation
     * @param array
     */
    private void travelRoot(int startStation,int endStation,ArrayList<Station> array, int skipRoot)
    {
        for (int i = startStation; i <= endStation; i++)
        {
            if (skipRoot != array.get(i).rootUbication)
            {
                transparentPanel(array.get(i));
            }
        }
    }


    /**
     * Viaja a través de las "Station" dentro de un array,
     * saltandose 2 root, inicia en la posición dada por StartStation
     * y finaliza en la posición dada como EndStation
     * @param startStation
     * @param endStation
     * @param array
     */
    private void travelRoot(int startStation,int endStation,ArrayList<Station> array, int skipRoot, int skipRoot2)
    {
        for (int i = startStation; i <= endStation; i++)
        {
            if (skipRoot != array.get(i).rootUbication && skipRoot2 != array.get(i).rootUbication)
            {
                transparentPanel(array.get(i));
            }
        }
    }

    /**
     * Busca la estación con la root inferior a la root contenida en la posición del
     * ArrayList dada por StartStation.
     */
    private void downRoot(int startStation, int stationRoot, ArrayList<Station> array)
    {
        for (int i = startStation; i >= 0;i--)
        {
            transparentPanel(array.get(i));
            if (array.get(i).rootUbication != stationRoot)
            {
                break;
            }
        }
    }

    /**
     *Algoritmo encargado de buscar en el ArrayList
     * de Izquierda a derecha.
     */
    private void leftToRight(String start, String end, ArrayList<Station> array)
    {
        int startStation = checkStation(stationsData,start);
        Station startObj = array.get(startStation);

        int endStation = checkStation(stationsData,end);
        Station endObj= array.get(endStation);

        if (endObj.rootUbication == 4 && startObj.rootUbication != 4)
        {
            travelDownRoot(startStation,checkStation(array,"Madera"),array);
            transparentPanel("Use Metro in station Acevedo");
            travelRoot(checkStation(array,"Andalucia"),endStation,array);
            transparentPanel("You're in your end Station");
        }

        if (endObj.rootUbication == 2 && startObj.rootUbication == 5)
        {
            travelDownRoot(startStation,checkStation(array,"Parque Berrio"),array,4);
            transparentPanel("Use Metro in station San Antonio");
            travelRoot(checkStation(array,"Cisneros"),endStation,array);
            transparentPanel("You're in your end Station");
        }

        if (endObj.rootUbication == 2 && startObj.rootUbication != 5 && startObj.rootUbication != 2)
        {
            travelDownRoot(startStation,checkStation(array,"Parque Berrio"),array);
            transparentPanel("Use Metro in station San Antonio");
            travelRoot(checkStation(array,"Cisneros"),endStation,array);
            transparentPanel("You're in your end Station");
        }

        if (endObj.rootUbication == 2 && startObj.rootUbication == 2)
        {
            travelDownRoot(startStation,endStation,array);
            transparentPanel("You're in your end Station");
        }

        if (endObj.rootUbication != 2 && startObj.rootUbication == 2)
        {
            travelDownRoot(startStation,endStation,array);
            transparentPanel("You're in your end Station");
        }

        if (startObj.rootUbication != 5 && endObj.rootUbication != 2)
        {
            travelDownRoot(startStation,endStation,array,2);
            transparentPanel("You're in your end Station");
        }

        if (startObj.rootUbication == 5 && endObj.rootUbication != 2)
        {
            travelDownRoot(startStation,endStation,array,4,2);
            transparentPanel("You're in your end Station");
        }
    }

    /**
     * Viaja a través de las "Station" dentro de un array,
     * teniendo todas en cuenta, inicia en la posición dada por StartStation
     * y finaliza en la posición dada como EndStation
     * viaja desde el último punto del Array hacía el primero
     * @param startStation
     * @param endStation
     * @param array
     */
    private void travelDownRoot(int startStation,int endStation,ArrayList<Station> array)
    {
        for (int i = startStation; i >= endStation; i--)
        {
            transparentPanel(array.get(i));
        }
    }

    /**
     * Viaja a través de las "Station" dentro de un array,
     * saltandose 1 root, inicia en la posición dada por StartStation
     * y finaliza en la posición dada como EndStation
     * viaja desde el último punto del Array hacía el primero
     * @param startStation
     * @param endStation
     * @param array
     */
    private void travelDownRoot(int startStation,int endStation,ArrayList<Station> array, int skipRoot)
    {
        for (int i = startStation; i >= endStation; i--)
        {
            if (skipRoot != array.get(i).rootUbication)
            {
                transparentPanel(array.get(i));
            }
        }
    }

    /**
     * Viaja a través de las "Station" dentro de un array,
     * saltandose 2 root, inicia en la posición dada por StartStation
     * y finaliza en la posición dada como EndStation
     * viaja desde el último punto del Array hacía el primero
     * @param startStation
     * @param endStation
     * @param array
     */
    private void travelDownRoot(int startStation,int endStation,ArrayList<Station> array, int skipRoot, int skipRoot2)
    {
        for (int i = startStation; i >= endStation; i--)
        {

            if (skipRoot != array.get(i).rootUbication && skipRoot2 != array.get(i).rootUbication)
            {
                transparentPanel(array.get(i));
            }
        }
    }

    /**
     * Crea un panel transparente con datos específicos
     * de un objeto tipo Station
     * @param station
     */
    private void transparentPanel (Station station)
    {
        JPanel toAdd = new JPanel();
        JLabel InsidePanel = new JLabel("Use "+station.unity+" in station "+station.stationName);
        InsidePanel.setForeground(Color.WHITE);
        toAdd.setBackground(new Color(0,0,0,125));
        toAdd.add(InsidePanel);
        stationLabel.add(toAdd);
        this.setVisible(true);
    }


    /**
     * Crea un panel transparente con un texto
     * se define su transparencia por medio de un int
     */
    private void transparentPanel (String text,int transparency)
    {
        JPanel toAdd = new JPanel();
        JLabel InsidePanel = new JLabel(text);
        InsidePanel.setForeground(Color.BLACK);
        toAdd.setBackground(new Color(255,255,255,transparency));
        toAdd.add(InsidePanel);
        stationLabel.add(toAdd);
        this.setVisible(true);
    }

    /**
     * Crea un panel transparente con un texto
     * tiene un fondo blanco.
     */
    public void transparentPanel (String text)
    {
        JPanel toAdd = new JPanel();
        JLabel InsidePanel = new JLabel(text);
        InsidePanel.setForeground(Color.WHITE);
        toAdd.setBackground(new Color(0,0,0,125));
        toAdd.add(InsidePanel);
        stationLabel.add(toAdd);
        this.setVisible(true);
    }
}