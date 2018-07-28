


	/*
	 *
	 * Copyright © 2000-2006 Sun Microsystems, Inc. All rights reserved. 
	 * PROPRIETARY/CONFIDENTIAL
	 * Use is subject to license terms
	 */


	package ticker;

	import javax.microedition.lcdui.*;
	import javax.microedition.lcdui.Display;
	import javax.microedition.lcdui.Displayable;
	import javax.microedition.lcdui.Command;
	import javax.microedition.lcdui.CommandListener;
	import javax.microedition.midlet.MIDlet;
	/**
	 * The Ticker Demo simply sets a rather long ticker to the screen.
	 *
	 * @version 2.0
	 */

	public class TickerDemo extends MIDlet implements CommandListener{
	    /**
	     * This is the text displayed in the ticker.
	     */
	    private static final String TICKER_TEXT = "This is a ticker see it " +
	                    "scroll along the way... On and on it goes without " +
	                    "stopping even for a second!";

	    private boolean firstTime;

	    private Form mainForm;
	    private Command exitCommand = new Command("Exit", Command.EXIT, 1);
	    private Display     myDisplay;
	    private Ticker t;
	    public TickerDemo() {
	        myDisplay = Display.getDisplay(this);
	        firstTime = true;
	        mainForm = new Form("Ticker");
	        mainForm.setCommandListener(this);
	    }                    

	    protected void startApp() {

	        if (firstTime) {
	            t = new Ticker(TICKER_TEXT);
	            mainForm.setTicker(t);
	            firstTime = false;
	        }
	        mainForm.addCommand(exitCommand);
	        myDisplay.setCurrent(mainForm);        
	    }

	    protected void destroyApp(boolean unconditional) {         
	        myDisplay.setCurrent((Displayable)null);
	        notifyDestroyed();
	    }

	    protected void pauseApp() {
	    }    

	    public void commandAction(Command c, Displayable s) {
		if (c == exitCommand) {
	            destroyApp(true);	    
		}	
	    }
	}



