package ispd.application;

import ispd.Main;
import ispd.gui.JPrincipal;
import ispd.gui.LogExceptions;
import ispd.gui.SplashWindowBuilder;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GuiApplication implements Application
{
    private static final String GUI_LOOK_AND_FEEL_CLASS_NAME = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
    private static final String ERROR_FILE = String.join(File.separator, "Erros", "Erros_Simulador");
    private static final String OUTPUT_FILE = String.join(File.separator, "Erros", "Saida_Simulador");

    private static void openGui ()
    {
        final var splashWindow = SplashWindowBuilder.visibleDefaultSplashWindow();
        final var mainWindow = GuiApplication.initializeApplication();

        splashWindow.dispose();
        mainWindow.setVisible(true);
    }

    private static JPrincipal initializeApplication ()
    {
        final var exceptionLogger = new LogExceptions(null);
        Thread.setDefaultUncaughtExceptionHandler(exceptionLogger);

        GuiApplication.redirectSystemStreams();
        GuiApplication.setGuiLookAndFeel();

        final var mainWindow = GuiApplication.buildMainWindow();

        // TODO: Study if exceptionLogger can be instantiated after creating the main window
        exceptionLogger.setParentComponent(mainWindow);

        return mainWindow;
    }

    private static void redirectSystemStreams ()
    {
        redirectStreamToFile(System::setErr, ERROR_FILE);
        redirectStreamToFile(System::setOut, OUTPUT_FILE);
    }

    private static void redirectStreamToFile (
            final Consumer<PrintStream> streamRedirect, final String pathToFile)
    {
        var fileStream = GuiApplication.getFileStreamOrNull(pathToFile);

        // TODO: Maybe optional?
        if (fileStream == null)
            return;

        var printStream = new PrintStream(fileStream);
        // TODO: Uncomment once behaviour has been validated
//        streamRedirect.accept(printStream);
    }

    private static FileOutputStream getFileStreamOrNull (final String pathToFile)
    {
        try
        {
            return new FileOutputStream(pathToFile);
        } catch (FileNotFoundException ex)
        {
            GuiApplication.logWithMainLogger(ex);
            return null;
        }
    }

    private static void setGuiLookAndFeel ()
    {
        try
        {
            UIManager.setLookAndFeel(GUI_LOOK_AND_FEEL_CLASS_NAME);
        } catch (ClassNotFoundException | IllegalAccessException |
                 InstantiationException | UnsupportedLookAndFeelException ex)
        {
            GuiApplication.logWithMainLogger(ex);
        }
    }

    private static void logWithMainLogger (final Exception ex)
    {
        // TODO: Perhaps message instead of 'null'?
        Logger.getLogger(Main.class.getName())
                .log(Level.SEVERE, null, ex);
    }

    private static JPrincipal buildMainWindow ()
    {
        JPrincipal gui = new JPrincipal();
        gui.setLocationRelativeTo(null);
        return gui;
    }

    @Override
    public void run ()
    {
        GuiApplication.openGui();
    }
}