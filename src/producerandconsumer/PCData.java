package producerandconsumer;

public class PCData {
    private final int intDate;

    public PCData(int d) {
        intDate = d;
    }

    public PCData(String d){
        intDate = Integer.valueOf(d);
    }

    public int getDate() {
        return intDate;
    }

    @Override
    public String toString() {
        return "PCData{" +
                "date=" + intDate +
                '}';
    }
}
