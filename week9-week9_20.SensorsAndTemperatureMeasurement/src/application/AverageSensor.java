/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabriel
 */
public class AverageSensor implements Sensor {

    private List<Sensor> sensors;
    private List<Integer> readings;

    public AverageSensor() {
        this.sensors = new ArrayList<Sensor>();
        this.readings = new ArrayList<Integer>();
    }

    @Override
    public void on() {
        for (Sensor sensor : this.sensors) {
            sensor.on();
        }

    }

    @Override
    public void off() {
        for (Sensor sensor : this.sensors) {
            sensor.off();
        }
    }

    @Override
    public boolean isOn() {
        for (Sensor sensor : this.sensors) {
            if (!sensor.isOn()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int measure() {

        if (!this.isOn() || this.sensors.isEmpty()) {
            throw new IllegalStateException("AverageSensor is off or empty.");
        }

        int reading = 0;
        for (Sensor sensor : this.sensors) {
            reading += sensor.measure();
        }
        int avg = reading / this.sensors.size();
        this.readings.add(avg);
        
        return avg;
    }

    public void addSensor(Sensor additional) {
        this.sensors.add(additional);
    }

    public List<Integer> readings() {
        return this.readings;
    }

}
