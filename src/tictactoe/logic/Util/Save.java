package tictactoe.logic.Util;

import tictactoe.logic.GameClient;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Save {

    public static boolean saveGame(GameClient game, File file){
        ObjectOutputStream out = null;
        try{
            out = new ObjectOutputStream(new FileOutputStream(file));
            out.writeObject(game);
            return true;
        } catch(IOException e){
            return false;
        } finally{
            if(out != null){
                try {
                    out.close();
                } catch (IOException e){
                    return false;
                }
            }
        }
    }
}
