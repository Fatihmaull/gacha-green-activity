import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HijaukuHariIniApp extends JFrame {
    private List<String> tasks;
    private List<String> recentTasks;
    private JLabel taskLabel;
    private JButton gatchaButton;

    public HijaukuHariIniApp() {
        setTitle("Hijauku Hari Ini");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        tasks = new ArrayList<>();
        recentTasks = new ArrayList<>();
        initializeTasks();

        taskLabel = new JLabel("Putar gatcha untuk tugas hari ini", SwingConstants.CENTER);
        taskLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        add(taskLabel, BorderLayout.CENTER);

        gatchaButton = new JButton("Putar Gatcha");
        gatchaButton.setFont(new Font("Arial", Font.PLAIN, 16));
        gatchaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String task = getRandomTask();
                taskLabel.setText(task);
                recentTasks.add(task);
                if (recentTasks.size() > 7) {
                    recentTasks.remove(0);
                }
            }
        });
        add(gatchaButton, BorderLayout.SOUTH);
    }

    private void initializeTasks() {
        tasks.add("Bawa tas belanja sendiri");
        tasks.add("Matikan lampu yang tidak digunakan");
        tasks.add("Daur ulang sampah plastik");
        tasks.add("Gunakan sepeda untuk perjalanan pendek");
        tasks.add("Kurangi durasi mandi");
        tasks.add("Ikuti webinar tentang lingkungan");
        tasks.add("Gunakan botol minum sendiri");
        tasks.add("Tanam pohon atau tanaman di halaman");
        tasks.add("Hindari penggunaan tisu sekali pakai");
        tasks.add("Bersihkan sampah di sekitar lingkungan");
    }

    private String getRandomTask() {
        List<String> availableTasks = new ArrayList<>();
        for (String task : tasks) {
            if (!recentTasks.contains(task)) {
                availableTasks.add(task);
            }
        }

        if (availableTasks.isEmpty()) {
            availableTasks = new ArrayList<>(tasks);
        }

        Random random = new Random();
        int randomIndex = random.nextInt(availableTasks.size());
        return availableTasks.get(randomIndex);
    }
}