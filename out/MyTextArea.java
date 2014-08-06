package by.et.jtapi.tst;

import java.awt.*;
import java.io.*;


/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 6/19/14
 * Time: 6:59 AM
 * To change this template use File | Settings | File Templates.
 */
public class MyTextArea extends TextArea
{

    public MyTextArea() {
        super();
        currentLength = 0;
        setEditable(false);
        setBackground(Color.white);
    }

    public synchronized void append(boolean always, String str) {

        if ( tracing || always ) {
            currentLength += str.length();
            if (currentLength > 28000) {
                replaceRange("", 0, 14000);
                currentLength = getText().length();
            }
            super.append(str);
        }
    }

    public synchronized void append (String str) {

        this.append(true, str);
    }

    public void setState (boolean state) {

        if (state) {
            tracing = true;
        } else {
            tracing = false;
        }
    }

    public void clear () {

        this.setText("");
    }

    int          currentLength;
    boolean      tracing = false;
}