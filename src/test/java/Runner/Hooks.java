package Runner;

import static sun.awt.windows.TranslucentWindowPainter.createInstance;

public class Hooks {

    @Before public void setUp(){
        createInstance(browserName);
    }
}
