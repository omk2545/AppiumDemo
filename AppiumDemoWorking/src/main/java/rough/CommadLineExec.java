package rough;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by okulkarni on 12/22/2016.
 */
public class CommadLineExec {


    public static void main(String a[]) throws IOException {

////        System.out.println("Hello");
//
//        final List<String> commands = new ArrayList<String>();
//        commands.add("cmd");
//        commands.add("appium - h"); // second commandline argument
//     //   commands.add(input3);// third commandline agrument
//        ProcessBuilder pb = new ProcessBuilder(commands);


        String port;

String startservercmd = "appium -a 127.0.0.1 -p 4739 --no-reset -U LS4503";
       // startAppiumServer()


CommadLineExec commadLineExec = new CommadLineExec();

        commadLineExec.startAppiumServer("4556","OmkarDevice-1");
        commadLineExec.startAppiumServer("5652","OmkarDEVICE-2");



    }




    public void startAppiumServer(String port, String deviceId){


    String command  = "appium -a 127.0.0.1 -p"+port +"--no-reset -U"+deviceId;
    //String startservercmd = "appium -a 127.0.0.1 -p 4739 --no-reset -U LS4503";
    Runtime rt = Runtime.getRuntime();
    // rt.exec(new String[]{"cmd.exe","/c","start"});

    try {
        System.out.println("Running the appium on Port "+port+" and DeviceId "+deviceId);
        rt.exec("cmd.exe /c start "+command);
    } catch (IOException e) {
        e.printStackTrace();
    }


}



}
