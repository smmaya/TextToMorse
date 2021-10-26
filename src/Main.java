import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        // litery i cyfry, przecinek i kropka
        String myString = "sos, last coords 54.372158 18.638306";

        char[] keyArray = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '.', ','};
        String[] valueArray = {"*-", "-***", "-*-*", "-**", "*", "**-*", "--*", "****", "**", "*---", "-*-", "*-**", "--", "-*", "---", "*--*", "--*-", "*-*", "***", "-", "**-", "***-", "*--", "-**-", "-*--", "--**", "*----", "**---", "***--", "****-", "*****", "-****", "--***", "---**", "----*", "-----", "*-*-*-", "--**--"};

        char[] myStringArray = myString.toCharArray();
        System.out.println("Message: " + myString);
        int j = 0;
        for (int i = 0; i < myString.length(); i++) {
            for (j = 0; j < keyArray.length; j++) {
                if (myStringArray[i] == keyArray[j]) {
                    System.out.print(valueArray[j] + " ");
                    MakeSound(valueArray[j]);
                    break;
                }
            }
        }

    }

    public static void MakeSound(String singleCode) throws MalformedURLException, InterruptedException {
        char[] chars = singleCode.toCharArray();
        for (char singleChar : chars) {
            if (singleChar == '-') {
                dashSound();
                Thread.sleep(750);
            } else if (singleChar == '*') {
                dotSound();
                Thread.sleep(450);
            }
        }
        Thread.sleep(950);
    }

    public static void dotSound() throws MalformedURLException {
        File dot = new File("/Users/Maya/Projects/TextToMorse/src/sounds/dot.wav");
        URL url1 = null;
        if (dot.canRead()) {
            url1 = dot.toURI().toURL();
        }
        AudioClip clip1 = Applet.newAudioClip(url1);
        clip1.play();
    }

    public static void dashSound() throws MalformedURLException {
        File dash = new File("/Users/Maya/Projects/TextToMorse/src/sounds/dash.wav");
        URL url2 = null;
        if (dash.canRead()) {
            url2 = dash.toURI().toURL();
        }
        AudioClip clip2 = Applet.newAudioClip(url2);
        clip2.play();
    }

}
