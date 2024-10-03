public class AverageTemperature {
    private int[] temperature;
    private int counter;
    private double average;

    public AverageTemperature(int temperatureSize) {
        this.temperature = new int[temperatureSize];
        for (int i = 0; i < temperature.length; i++) {
            temperature[i] = 1 + i;
        }
        this.counter = 0;
    }

    public double days(int days) {
        int sum = 0;
        for (int i = 0; i < days; i++) {  // Iterate from 0 to days-1 (inclusive)
            sum += this.temperature[i];
        }

        this.average = (double) sum / days;  // Average based on 'days' number of elements

        for (int i = 0; i < days; i++) {
            if (this.temperature[i] > this.average) {
                this.counter++;
            }
        }
        return this.counter;
    }


    public String toString() {

        return this.counter + " day(s) above average temperature."+"\n"+"Average: "+this.average;
    }
}
