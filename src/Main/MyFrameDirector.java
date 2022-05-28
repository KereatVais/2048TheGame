package Main;

public class MyFrameDirector {
    public void makeFrame(MyFrame frame) {
        frame.createFrame();
        frame.addGraphics();
        frame.addButtons();
    }

    public void makeFrame(MyFrame frame, int rowCount, int columnCount) {
        frame.createFrame();
        frame.addBoard(rowCount, columnCount);
        frame.addGraphics();
        frame.addButtons();
    }
}
