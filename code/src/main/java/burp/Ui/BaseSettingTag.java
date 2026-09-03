package burp.Ui;

import java.awt.*;
import javax.swing.*;

import burp.IBurpExtenderCallbacks;
import burp.Bootstrap.YamlReader;

public class BaseSettingTag {
    private YamlReader yamlReader;

    private JCheckBox isStartBox;
    private JCheckBox allDirectoryScanBox;

    public BaseSettingTag(IBurpExtenderCallbacks callbacks, JTabbedPane tabs, YamlReader yamlReader) {
        JPanel baseSetting = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        this.yamlReader = yamlReader;

        this.input1_1(baseSetting, c);
        this.input1_2(baseSetting, c);
        this.input1_3(baseSetting, c);

        tabs.addTab("基本设置", baseSetting);
    }

    private void input1_1(JPanel baseSetting, GridBagConstraints c) {
        JLabel br_lbl_1_1 = new JLabel("基础设置");
        br_lbl_1_1.setForeground(new Color(255, 89, 18));
        br_lbl_1_1.setFont(new Font("Serif", Font.PLAIN, br_lbl_1_1.getFont().getSize() + 2));
        c.insets = new Insets(5, 5, 5, 5);
        c.gridx = 0;
        c.gridy = 1;
        baseSetting.add(br_lbl_1_1, c);
    }

    private void input1_2(JPanel baseSetting, GridBagConstraints c) {
        this.isStartBox = new JCheckBox("插件-启动", this.yamlReader.getBoolean("isStart"));
        this.isStartBox.setFont(new Font("Serif", Font.PLAIN, this.isStartBox.getFont().getSize()));
        c.insets = new Insets(5, 5, 5, 5);
        c.gridx = 0;
        c.gridy = 2;
        baseSetting.add(this.isStartBox, c);
    }

    private void input1_3(JPanel baseSetting, GridBagConstraints c) {
        this.allDirectoryScanBox = new JCheckBox("全部目录主动跑（每目录最多2个，总数不限）", this.yamlReader.getBoolean("scan.allDirectoryScan.isStart", true));
        this.allDirectoryScanBox.setFont(new Font("Serif", Font.PLAIN, this.allDirectoryScanBox.getFont().getSize()));
        c.insets = new Insets(5, 5, 5, 5);
        c.gridx = 0;
        c.gridy = 3;
        baseSetting.add(this.allDirectoryScanBox, c);
    }

    public Boolean isStart() {
        return this.isStartBox.isSelected();
    }

    public Boolean isAllDirectoryScan() {
        return this.allDirectoryScanBox.isSelected();
    }
}
