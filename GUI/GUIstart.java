    package GUI;

    import BussinessRules.GenerateStations;

    import javax.swing.*;
    import java.awt.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;

    /**
     * Created by Esteban on 5/8/2016.
     * All rights reserved
     */
    public class GUIstart extends JFrame
    {
        /**
         * Crea la ventana completa
         * @throws HeadlessException
         */
        public GUIstart() throws HeadlessException
        {
            this.setTitle("Metro's App");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setResizable(false);
            this.setBounds(70,75,1231,450);


            JComponent Start = start();
            this.getContentPane().add(Start);
            this.setVisible(true);
        }

        /**
         * Crea e inicializa todos los paneles, text fields, y objetos presentes
         * que habrán en la ventana
         * @return JComponent
         */
        private JComponent start() {
            ImageIcon s = new ImageIcon(getClass().getResource("/GUI/images/metrocable.jpg"));
            ImagePanel windowPanel = new ImagePanel(s.getImage());
            windowPanel.setLayout(null);


            JPanel text = transparentPanel("Hey!, welcome to Metro's App, select your option and start calculate your route!");
            JButton stepByStep = new JButton("Step By Step");
            JButton imageStepByStep = new JButton("Image Route");
            JButton closeApp = new JButton("Close");
            JButton instructions = new JButton("Instructions");


            imageStepByStep.setEnabled(false);
            stepByStep.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                        dispose();
                    new GUImap();
                }
            });
            closeApp.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                        System.exit(0);
                }
            });

            text.setBounds(360,90,500,30);
            stepByStep.setBounds(390,230,200,50);
            imageStepByStep.setBounds(640,230,200,50);
            closeApp.setBounds(640,300,200,50);
            instructions.setBounds(390,300,200,50);
            instructions.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e)
                            {
                                    JOptionPane.showMessageDialog(null,"Put in the text fields your Stations starting with Caps, then click in calculate route","Instructions",JOptionPane.PLAIN_MESSAGE);
                }
            });
            windowPanel.add(text);
            windowPanel.add(instructions);
            windowPanel.add(imageStepByStep);
            windowPanel.add(stepByStep);
            windowPanel.add(closeApp);

            return windowPanel;
        }

        public JPanel transparentPanel (String text)
        {
            JPanel toAdd = new JPanel();
            JLabel InsidePanel = new JLabel(text);
            InsidePanel.setForeground(Color.WHITE);
            toAdd.setBackground(new Color(0,0,0,125));
            toAdd.add(InsidePanel);

            return toAdd;
        }
    }


