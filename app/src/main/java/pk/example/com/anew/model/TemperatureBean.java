package pk.example.com.anew.model;


public class TemperatureBean {
    private int low;
    private int high;
    private String mDate;

    public TemperatureBean(int i, int i1, String date) {
        this.low = i;
        this.high = i1;
        this.mDate = date;
    }

    public TemperatureBean(int i, int i1) {
        this.low = i;
        this.high = i1;

    }

    public int getLow() {
        return low;
    }

    public void setLow(int low) {
        this.low = low;
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }
}
