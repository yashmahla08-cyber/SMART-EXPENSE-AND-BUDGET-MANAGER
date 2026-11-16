package com.smartexpense;

import com.smartexpense.controller.AuthController;
import com.smartexpense.dao.DatabaseInitializer;
import com.smartexpense.util.DatabaseConnection;
import com.smartexpense.view.MainFrame;
import com.smartexpense.view.auth.AuthFrame;
import com.smartexpense.view.theme.UITheme;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 * Application Entry Point for Smart Expense and Budget Manager.
 */
public class Main {
    public static final String APP_NAME = "Smart Expense and Budget Manager";
    public static final String APP_VERSION = "1.0.0";

    public static void main(String[] args) {
        // Initialize Theme before any Swing component creation
        UITheme.setupTheme();

        SwingUtilities.invokeLater(() -> {
            System.out.println("Starting " + APP_NAME + " v" + APP_VERSION);

            // 1. Initialize Database connection & auto-provision schema
            DatabaseConnection.init();
            boolean dbReady = DatabaseInitializer.initialize();
            if (!dbReady) {
                System.err.println("[Main] Warning: Database initialization had issues. Please verify credentials in db.properties.");
            }

            // 2. Launch Authentication GUI
            AuthController authController = new AuthController();
            AuthFrame authFrame = new AuthFrame(authController);

            authController.setOnLoginSuccess(user -> {
                System.out.println("[Main] User authenticated: " + user.getUsername() + " (" + user.getFullName() + ")");
                authFrame.dispose();
                MainFrame mainFrame = new MainFrame(user);
                mainFrame.setVisible(true);
            });

            authFrame.setVisible(true);
        });
    }
}
