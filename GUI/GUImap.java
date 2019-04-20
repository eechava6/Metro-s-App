package GUI;


import BussinessRules.CheckError;
import BussinessRules.GenerateStations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Esteban on 5/8/2016.
 * All rights reserved
 */
public class GUImap extends JFrame
{

    /**Constructor
     * Crea la ventana que contiene el mapa.
     * @throws HeadlessException
     */
    public GUImap() throws HeadlessException {
          this.setTitle("Metro of Medellin - Map");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setBounds(70,75,1231,450);


        JComponent map = map();

        this.getContentPane().add(map);
        this.setVisible(true);
    }
    //Métodos

    /**
     * Crea e inicializa todos los paneles, text fields, y objetos presentes
     * que habrán en la ventana
     * @return JComponent
     */
    private JComponent map()
    {
        ImageIcon s = new ImageIcon((getClass().getResource("/GUI/images/metroMap.gif")));
        JPanel functionalPanel = new JPanel(); //Panel principal.
        ImagePanel mapPanel = new ImagePanel(s.getImage());//Panel con el mapa.
        JPanel valuesPanel = new JPanel();//Panel para el usuario.

        functionalPanel.setLayout(new BorderLayout(10,10));
        functionalPanel.setBackground(Color.WHITE.darker());
        mapPanel.setLayout(new BorderLayout());
        mapPanel.setBackground(Color.GRAY.brighter());
        valuesPanel.setLayout(new GridLayout(3,2));
        valuesPanel.setBackground(Color.WHITE);


        JLabel startStationlbl = new JLabel("What's your start Station");
        JTextField startStationtxt = new JTextField("Write here");
        startStationtxt.setForeground(Color.gray);
        startStationtxt.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                startStationtxt.setForeground(Color.BLACK);
                startStationtxt.setText("");
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        JLabel endStationlbl = new JLabel("What's your end Station");
        JTextField endStationtxt = new JTextField("Write here");
        endStationtxt.setForeground(Color.gray);
        endStationtxt.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                endStationtxt.setForeground(Color.BLACK);
                endStationtxt.setText("");
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });


        JButton stepByStep = new JButton("Show Step by Step");
         stepByStep.addActionListener(new ActionListener()
         {
             @Override
             public void actionPerformed(ActionEvent e)
             {

                     GenerateStations obj2 = new GenerateStations();
                     obj2.startAllRoots();
                     CheckError obj1 = new CheckError();//Pere ya sé
                     if (obj1.searchError(obj2.stationsData,startStationtxt.getText()) == false ||
                             obj1.searchError(obj2.stationsData,endStationtxt.getText()) == false)
                     {
                         JOptionPane.showMessageDialog(null,"Atención, ha ingresado una estación inválida.","Error",JOptionPane.ERROR_MESSAGE);
                     }
                     else
                     {
                         GUIstepbystep obj3 = new GUIstepbystep();
                         obj3.checkPatron(startStationtxt.getText(),endStationtxt.getText());

                     } }
         });
        valuesPanel.setBackground(Color.gray);
        startStationlbl.setForeground(Color.WHITE);
        endStationlbl.setForeground(Color.WHITE);
        JLabel recommendations = new JLabel("Remember, every word starts in caps.");

        valuesPanel.add(startStationlbl);
        valuesPanel.add(startStationtxt);
        valuesPanel.add(endStationlbl);
        valuesPanel.add(endStationtxt);
        valuesPanel.add(stepByStep);
        valuesPanel.add(recommendations);


        JLabel map = new JLabel(new ImageIcon(getClass().getResource("/GUI/images/metroMap.gif")));

        map.setBounds(70,80,1231,200);
        mapPanel.setBounds(70,80,1231,200);
        mapPanel.add(map);
        mapPanel.setVisible(true);


        functionalPanel.add(mapPanel,BorderLayout.NORTH);
        functionalPanel.add(valuesPanel,BorderLayout.CENTER);
        functionalPanel.setBackground(Color.GRAY.brighter());



        return functionalPanel;
    }


}
