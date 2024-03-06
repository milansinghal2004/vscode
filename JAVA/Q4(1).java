abstract class TrunkCall {
    protected int duration;
    private String type;

    public TrunkCall(int duration, String type) {
        this.duration = duration;
        this.type = type;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public abstract double computeCharges();
}

class OrdinaryCall extends TrunkCall {
    public OrdinaryCall(int duration) {
        super(duration, "ordinary");
    }
    public double computeCharges() {
        return duration * 10;
    }
}

class UrgentCall extends TrunkCall {
    public UrgentCall(int duration) {
        super(duration, "urgent");
    }
    public double computeCharges() {
        return duration * 15;
    }
}

class LightningCall extends TrunkCall {
    public LightningCall(int duration) {
        super(duration, "lightning");
    }
    public double computeCharges() {
        return duration * 20;
    }
}

public class Q4 {
    public static void main(String[] args) {
        OrdinaryCall ordinaryCall = new OrdinaryCall(10);
        UrgentCall urgentCall = new UrgentCall(10);
        LightningCall lightningCall = new LightningCall(10);
        System.out.println("Ordinary call charges: " + ordinaryCall.computeCharges());
        System.out.println("Urgent call charges: " + urgentCall.computeCharges());
        System.out.println("Lightning call charges: " + lightningCall.computeCharges());
    }
}
