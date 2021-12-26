package client.GUI;

import java.awt.*;

public class MainGUI {
    public static void main(String[] args) {
        Dimension minDimension = new Dimension();
        minDimension.height = 300;
        minDimension.width = 200;
        new LoginForm( minDimension, null);
    }
}
