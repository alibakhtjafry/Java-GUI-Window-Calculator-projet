import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JTextArea;

class viewHistoryListener implements ActionListener{
    private JTextArea area;

    public viewHistoryListener(JTextArea area){
        this.area=area;
    }
     @Override
     public void actionPerformed(ActionEvent e){

        try{
            BufferedReader readFile=new BufferedReader(new FileReader("calculation_results.txt"));
            StringBuilder str=new StringBuilder();
            String store;
            while((store=readFile.readLine())!=null){
                str.append(store).append("\n");
            }
            readFile.close();
            area.setText(str.toString());
        }
        catch(Exception except){
            except.printStackTrace(); //it will print the issue

        }
     }
    
}