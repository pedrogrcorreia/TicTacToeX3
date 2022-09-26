package tictactoe.logic.Util;

import tictactoe.logic.GameClient;

import java.io.*;

public class Load {

    public static GameClient loadGame(File fileName){
        GameClient gameClient;
        ObjectInputStream in = null;

        try{
            in = new ObjectInputStream(new FileInputStream(fileName));
            gameClient = (GameClient) in.readObject();
        } catch(IOException e){
            gameClient = null;
            System.out.println("File not found.");
        } catch(ClassNotFoundException e){
            gameClient = null;
            System.out.println("Class not found.");
        } finally{
            if(in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return gameClient;
    }
}
