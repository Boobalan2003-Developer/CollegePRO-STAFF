
package eascpkg;
import javax.swing.*;
import java.awt.*;

public class LoadingTraceExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Loading Trace Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 150);

            // Create a label for displaying loading status
            JLabel statusLabel = new JLabel("Loading...", JLabel.CENTER);
            frame.add(statusLabel, BorderLayout.NORTH);

            // Create a progress bar
//            JProgressBar progressBar = new JProgressBar(0, 100);
//            progressBar.setIndeterminate(true); // Shows an indeterminate loading animation
//            frame.add(progressBar, BorderLayout.CENTER);

            // Button to start loading
            JButton loadButton = new JButton("Start Loading Task");
            frame.add(loadButton, BorderLayout.SOUTH);

            SwingWorker<Void, Integer> worker = new SwingWorker<>() {
                    @Override
                    protected Void doInBackground() throws InterruptedException {
                        // Simulate a long-running task
                        for (int i = 0; i <= 100; i += 10) {
                            Thread.sleep(100); // Simulate work
                            publish(i); // Update progress
                        }
                        return null;
                    }

                    @Override
                    protected void process(java.util.List<Integer> chunks) {
                        // Get the latest published progress value
                        int progress = chunks.get(chunks.size() - 1);
//                        progressBar.setIndeterminate(false); // Switch to determinate mode
//                        progressBar.setValue(progress); // Update progress bar
                        statusLabel.setText("Loading... " + progress + "%");
                    }

                    @Override
                    protected void done() {
//                        progressBar.setValue(100);
                        statusLabel.setText("Loading Complete!");
                        loadButton.setEnabled(true); // Re-enable the button
                    }
                };

                // Start the SwingWorker
                worker.execute();
            loadButton.addActionListener(e -> {
                // Disable the button to prevent re-clicking
                loadButton.setEnabled(false);

                // Use SwingWorker for background task
                
            });

            frame.setVisible(true);
        });
    }
}

