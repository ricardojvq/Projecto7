package proj7.ex5.main;

import proj7.ex5.exchanger.PPRun;

import java.util.concurrent.*;

/**
 * Created by ricardoquirino on 06/07/15.
 */
public class Exercicio5 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Exchanger<String> exchanger = new Exchanger<String>();
        new Thread(new PPRun(exchanger,"Ping!")).start();
        new Thread(new PPRun(exchanger,"Pong!")).start();

    }
}
